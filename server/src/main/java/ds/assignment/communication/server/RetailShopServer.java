package ds.assignment.communication.server;

import ds.tutorials.sycnhronization.DistributedLock;
import ds.tutorials.sycnhronization.DistributedTx;
import ds.tutorials.sycnhronization.DistributedTxCoordinator;
import ds.tutorials.sycnhronization.DistributedTxParticipant;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class RetailShopServer {

    private DistributedLock leaderLock;
    private AtomicBoolean isLeader = new AtomicBoolean(false);
    private byte[] leaderData;
    private int serverPort;
    private Map<String, Double> accounts = new HashMap();

    DistributedTx transactionPurchase;
    DistributedTx transactionRestock;
    PurchaseItemServiceImpl purchaseItemService;
    RestockItemServiceImpl restockItemService;
    GetItemQuantityServiceImpl getItemQuantityService;
    int itemQuantity = 1000;

    public static String buildServerData(String IP, int port) {

        StringBuilder builder = new StringBuilder();
        builder.append(IP).append(":").append(port);
        return builder.toString();
    }

    public RetailShopServer(String host, int port) throws InterruptedException, IOException, KeeperException {

        this.serverPort = port;
        leaderLock = new DistributedLock("RetailsShopServerCluster", buildServerData(host, port));

        purchaseItemService = new PurchaseItemServiceImpl(this);
        restockItemService = new RestockItemServiceImpl(this);
        transactionPurchase = new DistributedTxParticipant(purchaseItemService);
        transactionRestock = new DistributedTxParticipant(restockItemService);

        getItemQuantityService = new GetItemQuantityServiceImpl(this);
    }

    public static void main (String[] args) throws Exception{
        if (args.length != 1) {
            System.out.println("Usage executable-name <port>");
        }

        int serverPort = Integer.parseInt(args[0]);
        DistributedLock.setZooKeeperURL("localhost:2181");
        DistributedTx.setZooKeeperURL("localhost:2181");

        RetailShopServer server = new RetailShopServer("localhost", serverPort);
        server.startServer();
    }

    public void startServer() throws IOException, InterruptedException, KeeperException {
        Server server = ServerBuilder
                .forPort(serverPort)
                .addService(purchaseItemService)
                .addService(restockItemService)
                .addService(getItemQuantityService)
                .build();
        server.start();
        System.out.println("RetailShopServer Started and ready to accept requests on port " + serverPort);

        tryToBeLeader();
        server.awaitTermination();
    }

    private void tryToBeLeader() throws KeeperException, InterruptedException {

        Thread leaderCampaignThread = new Thread(new LeaderCampaignThread());
        leaderCampaignThread.start();
    }

    class LeaderCampaignThread implements Runnable {

        private byte[] currentLeaderData = null;

        @Override
        public void run() {
            System.out.println("Starting the leader Campaign");

            try {
                boolean leader = leaderLock.tryAcquireLock();

                while (!leader) {
                    byte[] leaderData = leaderLock.getLockHolderData();
                    if (currentLeaderData != leaderData) {
                        currentLeaderData = leaderData;
                        setCurrentLeaderData(currentLeaderData);
                    }
                    Thread.sleep(10000);
                    leader = leaderLock.tryAcquireLock();
                }
                currentLeaderData = null;
                beTheLeader();
            } catch (Exception e){
            }
        }
    }

    private synchronized void setCurrentLeaderData(byte[] leaderData) {
        this.leaderData = leaderData;
    }

    private void beTheLeader() {

        System.out.println("I got the leader lock. Now acting as primary");
        isLeader.set(true);
        transactionPurchase = new DistributedTxCoordinator(purchaseItemService);
        transactionRestock = new DistributedTxCoordinator(restockItemService);
    }

    public boolean isLeader() {
        return isLeader.get();
    }

    public synchronized String[] getCurrentLeaderData() {
        return new String(leaderData).split(":");
    }

    public List<String[]> getOthersData() throws KeeperException, InterruptedException {

        List<String[]> result = new ArrayList<>();
        List<byte[]> othersData = leaderLock.getOthersData();

        for (byte[] data : othersData) {
            String[] dataStrings = new String(data).split(":");
            result.add(dataStrings);
        }
        return result;
    }

    public int getExistingQuantity() {
        return itemQuantity;
    }

    public void setExistingQuantity(int quantity) {
        itemQuantity -= quantity;
    }

    public DistributedTx getRestockTransaction() {
        return transactionRestock;
    }

    public DistributedTx getPurchaseTransaction() {
        return transactionPurchase;
    }

}
