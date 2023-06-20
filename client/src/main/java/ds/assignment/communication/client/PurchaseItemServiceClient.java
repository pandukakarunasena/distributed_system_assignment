package ds.assignment.communication.client;

import grpc.generated.retail.shop.PurchaseItemRequest;
import grpc.generated.retail.shop.PurchaseItemResponse;
import grpc.generated.retail.shop.PurchaseItemServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class PurchaseItemServiceClient {

    private ManagedChannel channel = null;
    PurchaseItemServiceGrpc.PurchaseItemServiceBlockingStub clientStub = null;
    String host;
    int port;

    public PurchaseItemServiceClient (String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void initializeConnection () {
        System.out.println("Initializing Connecting to server at " + host + ":" + port);
        channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();
        clientStub = PurchaseItemServiceGrpc.newBlockingStub(channel);
    }
    public void closeConnection() {
        channel.shutdown();
    }

    public void processUserRequests() throws InterruptedException {

        while (true) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("\nEnter quantity to purchase :");
            int quantity = userInput.nextInt();
            System.out.println("Requesting server to purchase  " + quantity + " of the item.");
            PurchaseItemRequest request = PurchaseItemRequest
                    .newBuilder()
                    .setQuantity(quantity)
                    .setIsSentByPrimary(false)
                    .build();

            PurchaseItemResponse response = clientStub.purchaseItem(request);

            System.out.printf("Transaction Status " + (response.getPurchaseComplete() ? "Successful" : "Failed"));
            Thread.sleep(1000);
        }
    }
}
