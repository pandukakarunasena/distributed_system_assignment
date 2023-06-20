package ds.assignment.communication.server;

import grpc.generated.retail.shop.GetItemQuantityRequest;
import grpc.generated.retail.shop.GetItemQuantityResponse;
import grpc.generated.retail.shop.GetItemQuantityServiceGrpc;
import io.grpc.stub.StreamObserver;

public class GetItemQuantityServiceImpl extends GetItemQuantityServiceGrpc.GetItemQuantityServiceImplBase {

    private RetailShopServer server;

    public GetItemQuantityServiceImpl(RetailShopServer server) {
        this.server = server;
    }

    @Override
    public void getItemQuantity(GetItemQuantityRequest request, StreamObserver<GetItemQuantityResponse> responseObserver) {

        GetItemQuantityResponse response = GetItemQuantityResponse
                .newBuilder()
                .setQuantity(server.getExistingQuantity())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
