package grpc.generated.retail.shop;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: RetailShop.proto")
public final class PurchaseItemServiceGrpc {

  private PurchaseItemServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.generated.retail.shop.PurchaseItemService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.generated.retail.shop.PurchaseItemRequest,
      grpc.generated.retail.shop.PurchaseItemResponse> getPurchaseItemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "purchaseItem",
      requestType = grpc.generated.retail.shop.PurchaseItemRequest.class,
      responseType = grpc.generated.retail.shop.PurchaseItemResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.generated.retail.shop.PurchaseItemRequest,
      grpc.generated.retail.shop.PurchaseItemResponse> getPurchaseItemMethod() {
    io.grpc.MethodDescriptor<grpc.generated.retail.shop.PurchaseItemRequest, grpc.generated.retail.shop.PurchaseItemResponse> getPurchaseItemMethod;
    if ((getPurchaseItemMethod = PurchaseItemServiceGrpc.getPurchaseItemMethod) == null) {
      synchronized (PurchaseItemServiceGrpc.class) {
        if ((getPurchaseItemMethod = PurchaseItemServiceGrpc.getPurchaseItemMethod) == null) {
          PurchaseItemServiceGrpc.getPurchaseItemMethod = getPurchaseItemMethod =
              io.grpc.MethodDescriptor.<grpc.generated.retail.shop.PurchaseItemRequest, grpc.generated.retail.shop.PurchaseItemResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "purchaseItem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.retail.shop.PurchaseItemRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.retail.shop.PurchaseItemResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PurchaseItemServiceMethodDescriptorSupplier("purchaseItem"))
              .build();
        }
      }
    }
    return getPurchaseItemMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PurchaseItemServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PurchaseItemServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PurchaseItemServiceStub>() {
        @java.lang.Override
        public PurchaseItemServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PurchaseItemServiceStub(channel, callOptions);
        }
      };
    return PurchaseItemServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PurchaseItemServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PurchaseItemServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PurchaseItemServiceBlockingStub>() {
        @java.lang.Override
        public PurchaseItemServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PurchaseItemServiceBlockingStub(channel, callOptions);
        }
      };
    return PurchaseItemServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PurchaseItemServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PurchaseItemServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PurchaseItemServiceFutureStub>() {
        @java.lang.Override
        public PurchaseItemServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PurchaseItemServiceFutureStub(channel, callOptions);
        }
      };
    return PurchaseItemServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PurchaseItemServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void purchaseItem(grpc.generated.retail.shop.PurchaseItemRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.retail.shop.PurchaseItemResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPurchaseItemMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPurchaseItemMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                grpc.generated.retail.shop.PurchaseItemRequest,
                grpc.generated.retail.shop.PurchaseItemResponse>(
                  this, METHODID_PURCHASE_ITEM)))
          .build();
    }
  }

  /**
   */
  public static final class PurchaseItemServiceStub extends io.grpc.stub.AbstractAsyncStub<PurchaseItemServiceStub> {
    private PurchaseItemServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PurchaseItemServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PurchaseItemServiceStub(channel, callOptions);
    }

    /**
     */
    public void purchaseItem(grpc.generated.retail.shop.PurchaseItemRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.retail.shop.PurchaseItemResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPurchaseItemMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PurchaseItemServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<PurchaseItemServiceBlockingStub> {
    private PurchaseItemServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PurchaseItemServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PurchaseItemServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.generated.retail.shop.PurchaseItemResponse purchaseItem(grpc.generated.retail.shop.PurchaseItemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPurchaseItemMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PurchaseItemServiceFutureStub extends io.grpc.stub.AbstractFutureStub<PurchaseItemServiceFutureStub> {
    private PurchaseItemServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PurchaseItemServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PurchaseItemServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.generated.retail.shop.PurchaseItemResponse> purchaseItem(
        grpc.generated.retail.shop.PurchaseItemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPurchaseItemMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PURCHASE_ITEM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PurchaseItemServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PurchaseItemServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PURCHASE_ITEM:
          serviceImpl.purchaseItem((grpc.generated.retail.shop.PurchaseItemRequest) request,
              (io.grpc.stub.StreamObserver<grpc.generated.retail.shop.PurchaseItemResponse>) responseObserver);
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

  private static abstract class PurchaseItemServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PurchaseItemServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.generated.retail.shop.RetailShop.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PurchaseItemService");
    }
  }

  private static final class PurchaseItemServiceFileDescriptorSupplier
      extends PurchaseItemServiceBaseDescriptorSupplier {
    PurchaseItemServiceFileDescriptorSupplier() {}
  }

  private static final class PurchaseItemServiceMethodDescriptorSupplier
      extends PurchaseItemServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PurchaseItemServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PurchaseItemServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PurchaseItemServiceFileDescriptorSupplier())
              .addMethod(getPurchaseItemMethod())
              .build();
        }
      }
    }
    return result;
  }
}
