package ds.assignment.communication.server;

import ds.tutorials.sycnhronization.DistributedTxCoordinator;
import ds.tutorials.sycnhronization.DistributedTxListener;
import ds.tutorials.sycnhronization.DistributedTxParticipant;
import grpc.generated.retail.shop.PurchaseItemRequest;
import grpc.generated.retail.shop.PurchaseItemResponse;
import grpc.generated.retail.shop.PurchaseItemServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PurchaseItemServiceImpl extends PurchaseItemServiceGrpc.PurchaseItemServiceImplBase
        implements DistributedTxListener {

    private ManagedChannel channel = null;
    PurchaseItemServiceGrpc.PurchaseItemServiceBlockingStub clientStub = null;
    private RetailShopServer server;

    private HashMap<String, Integer> tempDataHolder;
    private boolean transactionStatus = false;

    public PurchaseItemServiceImpl(RetailShopServer server){
        this.server = server;
    }

    private void startDistributedTx(int quantity) {
        try {
            server.getPurchaseTransaction().start(String.valueOf(quantity), String.valueOf(UUID.randomUUID()));
            tempDataHolder = new HashMap<String, Integer>();
            tempDataHolder.put("ITEM", quantity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void purchaseItem(PurchaseItemRequest request,
                             io.grpc.stub.StreamObserver<PurchaseItemResponse> responseObserver) {

        int quantity = request.getQuantity();
        if (server.isLeader()){
            // Act as primary
            try {
                System.out.println("Updating quantity as Primary");
                startDistributedTx(quantity);
                updateSecondaryServers(quantity);
                System.out.println("going to perform");
                System.out.println("QUANTITY TO BE PURCHASED " + quantity);
                System.out.println("EXISTING QUANTITY " + server.getExistingQuantity());
                if (quantity <= server.getExistingQuantity()){
                    System.out.println("PURCHASE CHECK PASSED");
                    ((DistributedTxCoordinator)server.getPurchaseTransaction()).perform();
                } else {
                    System.out.println("PURCHASE CHECK FAILED");
                    ((DistributedTxCoordinator)server.getPurchaseTransaction()).sendGlobalAbort();
                }
            } catch (Exception e) {
                System.out.println("Error while purchasing " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            // Act As Secondary
            if (request.getIsSentByPrimary()) {
                System.out.println("Updating quantity on secondary, on Primary's command");
                startDistributedTx(quantity);
                if (quantity >= 0) {
                    ((DistributedTxParticipant)server.getPurchaseTransaction()).voteCommit();
                } else {
                    ((DistributedTxParticipant)server.getPurchaseTransaction()).voteAbort();
                }
            } else {
                PurchaseItemResponse response = callPrimary(quantity);
                if (response.getPurchaseComplete()) {
                    transactionStatus = true;
                }
            }
        }
        PurchaseItemResponse response = PurchaseItemResponse
                .newBuilder()
                .setPurchaseComplete(transactionStatus)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void updateQuantity() {
        if (tempDataHolder.size()!=0) {
            int quantity = tempDataHolder.get("ITEM");
            System.out.println("ITEM quantity to be purchased " + quantity);
            server.setExistingQuantity(quantity);
            System.out.println("No of " + quantity + " is purchased");
            tempDataHolder = null;
        }
    }

    private PurchaseItemResponse callServer(int quantity, boolean isSentByPrimary, String IPAddress, int port) {
        System.out.println("Call Server " + IPAddress + ":" + port);
        channel = ManagedChannelBuilder.forAddress(IPAddress, port)
                .usePlaintext()
                .build();
        clientStub = PurchaseItemServiceGrpc.newBlockingStub(channel);

        PurchaseItemRequest request = PurchaseItemRequest
                .newBuilder()
                .setQuantity(quantity)
                .setIsSentByPrimary(isSentByPrimary)
                .build();
        PurchaseItemResponse response = clientStub.purchaseItem(request);
        return response;
    }

    private PurchaseItemResponse callPrimary(int quantity) {

        System.out.println("Calling Primary server");
        String[] currentLeaderData = server.getCurrentLeaderData();
        String IPAddress = currentLeaderData[0];
        int port = Integer.parseInt(currentLeaderData[1]);
        return callServer(quantity, false, IPAddress, port);
    }

    private void updateSecondaryServers(int quantity) throws KeeperException, InterruptedException {

        System.out.println("Updating other servers");
        List<String[]> othersData = server.getOthersData();
        for (String[] data : othersData) {
            String IPAddress = data[0];
            int port = Integer.parseInt(data[1]);
            callServer(quantity,true, IPAddress, port);
        }
    }

    @Override
    public void onGlobalCommit() {
        updateQuantity();
    }

    @Override
    public void onGlobalAbort() {
        tempDataHolder = null;
        System.out.println("Transaction Aborted by the Coordinator");
    }
}
