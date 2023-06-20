package ds.assignment.communication.client;

import grpc.generated.retail.shop.RestockItemRequest;
import grpc.generated.retail.shop.RestockItemResponse;
import grpc.generated.retail.shop.RestockItemServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class RestockItemServiceClient {

    private ManagedChannel channel = null;
    RestockItemServiceGrpc.RestockItemServiceBlockingStub clientStub = null;
    String host;
    int port;

    public RestockItemServiceClient (String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void initializeConnection () {
        System.out.println("Initializing Connecting to server at " + host + ":" + port);
        channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();
        clientStub = RestockItemServiceGrpc.newBlockingStub(channel);
    }
    public void closeConnection() {
        channel.shutdown();
    }

    public void processUserRequests() throws InterruptedException {

        while (true) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("\nEnter quantity to restock :");
            int quantity = userInput.nextInt();
            System.out.println("Requesting server to restock  " + quantity + " of the item.");
            RestockItemRequest request = RestockItemRequest
                    .newBuilder()
                    .setQuantity(quantity)
                    .setIsSentByPrimary(false)
                    .build();

            RestockItemResponse response = clientStub.restockItem(request);

            System.out.printf("Transaction Status " + (response.getRestockComplete() ? "Successful" : "Failed"));
            Thread.sleep(1000);
        }
    }
}
