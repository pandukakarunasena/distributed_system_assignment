package ds.assignment.communication.client;

import grpc.generated.retail.shop.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GetItemQuantityServiceClient {

    private ManagedChannel channel = null;
    GetItemQuantityServiceGrpc.GetItemQuantityServiceBlockingStub clientStub = null;
    String host;
    int port;

    public GetItemQuantityServiceClient (String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void initializeConnection () {
        System.out.println("Initializing Connecting to server at " + host + ":" + port);
        channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();
        clientStub = GetItemQuantityServiceGrpc.newBlockingStub(channel);
    }

    public void closeConnection() {
        channel.shutdown();
    }

    public void processUserRequests() throws InterruptedException {

        while (true) {
            System.out.println("Requesting server to show the current stock of the item.");

            GetItemQuantityRequest request = GetItemQuantityRequest
                    .newBuilder()
                    .build();

            GetItemQuantityResponse response = clientStub.getItemQuantity(request);
            System.out.println("Current stock: " + response.getQuantity());
        }
    }
}
