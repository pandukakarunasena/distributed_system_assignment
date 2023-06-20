package grpc.generated.retail.shop;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: RetailShop.proto")
public final class GetItemQuantityServiceGrpc {

  private GetItemQuantityServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.generated.retail.shop.GetItemQuantityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.generated.retail.shop.GetItemQuantityRequest,
      grpc.generated.retail.shop.GetItemQuantityResponse> getGetItemQuantityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getItemQuantity",
      requestType = grpc.generated.retail.shop.GetItemQuantityRequest.class,
      responseType = grpc.generated.retail.shop.GetItemQuantityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.generated.retail.shop.GetItemQuantityRequest,
      grpc.generated.retail.shop.GetItemQuantityResponse> getGetItemQuantityMethod() {
    io.grpc.MethodDescriptor<grpc.generated.retail.shop.GetItemQuantityRequest, grpc.generated.retail.shop.GetItemQuantityResponse> getGetItemQuantityMethod;
    if ((getGetItemQuantityMethod = GetItemQuantityServiceGrpc.getGetItemQuantityMethod) == null) {
      synchronized (GetItemQuantityServiceGrpc.class) {
        if ((getGetItemQuantityMethod = GetItemQuantityServiceGrpc.getGetItemQuantityMethod) == null) {
          GetItemQuantityServiceGrpc.getGetItemQuantityMethod = getGetItemQuantityMethod =
              io.grpc.MethodDescriptor.<grpc.generated.retail.shop.GetItemQuantityRequest, grpc.generated.retail.shop.GetItemQuantityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getItemQuantity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.retail.shop.GetItemQuantityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.retail.shop.GetItemQuantityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GetItemQuantityServiceMethodDescriptorSupplier("getItemQuantity"))
              .build();
        }
      }
    }
    return getGetItemQuantityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GetItemQuantityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GetItemQuantityServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GetItemQuantityServiceStub>() {
        @java.lang.Override
        public GetItemQuantityServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GetItemQuantityServiceStub(channel, callOptions);
        }
      };
    return GetItemQuantityServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GetItemQuantityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GetItemQuantityServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GetItemQuantityServiceBlockingStub>() {
        @java.lang.Override
        public GetItemQuantityServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GetItemQuantityServiceBlockingStub(channel, callOptions);
        }
      };
    return GetItemQuantityServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GetItemQuantityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GetItemQuantityServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GetItemQuantityServiceFutureStub>() {
        @java.lang.Override
        public GetItemQuantityServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GetItemQuantityServiceFutureStub(channel, callOptions);
        }
      };
    return GetItemQuantityServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GetItemQuantityServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getItemQuantity(grpc.generated.retail.shop.GetItemQuantityRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.retail.shop.GetItemQuantityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetItemQuantityMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetItemQuantityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                grpc.generated.retail.shop.GetItemQuantityRequest,
                grpc.generated.retail.shop.GetItemQuantityResponse>(
                  this, METHODID_GET_ITEM_QUANTITY)))
          .build();
    }
  }

  /**
   */
  public static final class GetItemQuantityServiceStub extends io.grpc.stub.AbstractAsyncStub<GetItemQuantityServiceStub> {
    private GetItemQuantityServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetItemQuantityServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GetItemQuantityServiceStub(channel, callOptions);
    }

    /**
     */
    public void getItemQuantity(grpc.generated.retail.shop.GetItemQuantityRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.retail.shop.GetItemQuantityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetItemQuantityMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GetItemQuantityServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GetItemQuantityServiceBlockingStub> {
    private GetItemQuantityServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetItemQuantityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GetItemQuantityServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.generated.retail.shop.GetItemQuantityResponse getItemQuantity(grpc.generated.retail.shop.GetItemQuantityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetItemQuantityMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GetItemQuantityServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GetItemQuantityServiceFutureStub> {
    private GetItemQuantityServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetItemQuantityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GetItemQuantityServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.generated.retail.shop.GetItemQuantityResponse> getItemQuantity(
        grpc.generated.retail.shop.GetItemQuantityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetItemQuantityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ITEM_QUANTITY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GetItemQuantityServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GetItemQuantityServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ITEM_QUANTITY:
          serviceImpl.getItemQuantity((grpc.generated.retail.shop.GetItemQuantityRequest) request,
              (io.grpc.stub.StreamObserver<grpc.generated.retail.shop.GetItemQuantityResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GetItemQuantityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GetItemQuantityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.generated.retail.shop.RetailShop.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GetItemQuantityService");
    }
  }

  private static final class GetItemQuantityServiceFileDescriptorSupplier
      extends GetItemQuantityServiceBaseDescriptorSupplier {
    GetItemQuantityServiceFileDescriptorSupplier() {}
  }

  private static final class GetItemQuantityServiceMethodDescriptorSupplier
      extends GetItemQuantityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GetItemQuantityServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GetItemQuantityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GetItemQuantityServiceFileDescriptorSupplier())
              .addMethod(getGetItemQuantityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
