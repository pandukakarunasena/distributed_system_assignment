package ds.assignment.communication.server;

import ds.tutorials.sycnhronization.DistributedTxCoordinator;
import ds.tutorials.sycnhronization.DistributedTxListener;
import ds.tutorials.sycnhronization.DistributedTxParticipant;
import grpc.generated.retail.shop.RestockItemServiceGrpc;
import grpc.generated.retail.shop.RestockItemRequest;
import grpc.generated.retail.shop.RestockItemResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class RestockItemServiceImpl extends RestockItemServiceGrpc.RestockItemServiceImplBase
        implements DistributedTxListener {

    private ManagedChannel channel = null;
    RestockItemServiceGrpc.RestockItemServiceBlockingStub clientStub = null;
    private RetailShopServer server;

    private HashMap<String, Integer> tempDataHolder;
    private boolean transactionStatus = false;

    public RestockItemServiceImpl(RetailShopServer server){
        this.server = server;
    }

    private void startDistributedTx(int quantity) {
        try {
            server.getRestockTransaction().start(String.valueOf(quantity), String.valueOf(UUID.randomUUID()));
            tempDataHolder = new HashMap<String, Integer>();
            tempDataHolder.put("ITEM", quantity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void restockItem(RestockItemRequest request,
                             io.grpc.stub.StreamObserver<RestockItemResponse> responseObserver) {

        int quantity = request.getQuantity();
        if (server.isLeader()){
            // Act as primary
            try {
                System.out.println("Updating quantity as Primary");
                startDistributedTx(quantity);
                updateSecondaryServers(quantity);
                System.out.println("going to perform");
                System.out.println("QUANTITY TO BE RESTOCKED " + quantity);
                if (quantity >= 0){
                    System.out.println("RESTOCK CHECK PASSED");
                    ((DistributedTxCoordinator)server.getRestockTransaction()).perform();
                } else {
                    System.out.println("RESTOCK CHECK FAILED");
                    ((DistributedTxCoordinator)server.getRestockTransaction()).sendGlobalAbort();
                }
            } catch (Exception e) {
                System.out.println("Error while restocking" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            // Act As Secondary
            if (request.getIsSentByPrimary()) {
                System.out.println("Updating quantity on secondary, on Primary's command");
                startDistributedTx(quantity);
                if (quantity >= 0) {
                    ((DistributedTxParticipant)server.getRestockTransaction()).voteCommit();
                } else {
                    ((DistributedTxParticipant)server.getRestockTransaction()).voteAbort();
                }
            } else {
                RestockItemResponse response = callPrimary(quantity);
                if (response.getRestockComplete()) {
                    transactionStatus = true;
                }
            }
        }
        RestockItemResponse response = RestockItemResponse
                .newBuilder()
                .setRestockComplete(transactionStatus)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void updateQuantity() {
        if (tempDataHolder.size()!=0) {
            int quantity = tempDataHolder.get("ITEM");
            System.out.println("ITEM quantity to be restocked " + quantity);
            server.setExistingQuantity(server.getExistingQuantity() + quantity);
            System.out.println("Item restocked to " + quantity);
            tempDataHolder = null;
        }
    }

    private RestockItemResponse callServer(int quantity, boolean isSentByPrimary, String IPAddress, int port) {
        System.out.println("Call Server " + IPAddress + ":" + port);
        channel = ManagedChannelBuilder.forAddress(IPAddress, port)
                .usePlaintext()
                .build();
        clientStub = RestockItemServiceGrpc.newBlockingStub(channel);

        RestockItemRequest request = RestockItemRequest
                .newBuilder()
                .setQuantity(quantity)
                .setIsSentByPrimary(isSentByPrimary)
                .build();
        RestockItemResponse response = clientStub.restockItem(request);
        return response;
    }

    private RestockItemResponse callPrimary(int quantity) {

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
