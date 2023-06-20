// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RetailShop.proto

package grpc.generated.retail.shop;

/**
 * Protobuf type {@code grpc.generated.retail.shop.RestockItemResponse}
 */
public final class RestockItemResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.generated.retail.shop.RestockItemResponse)
    RestockItemResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RestockItemResponse.newBuilder() to construct.
  private RestockItemResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RestockItemResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RestockItemResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RestockItemResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            restockComplete_ = input.readBool();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.generated.retail.shop.RetailShop.internal_static_grpc_generated_retail_shop_RestockItemResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.generated.retail.shop.RetailShop.internal_static_grpc_generated_retail_shop_RestockItemResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.generated.retail.shop.RestockItemResponse.class, grpc.generated.retail.shop.RestockItemResponse.Builder.class);
  }

  public static final int RESTOCKCOMPLETE_FIELD_NUMBER = 1;
  private boolean restockComplete_;
  /**
   * <code>bool restockComplete = 1;</code>
   * @return The restockComplete.
   */
  @java.lang.Override
  public boolean getRestockComplete() {
    return restockComplete_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (restockComplete_ != false) {
      output.writeBool(1, restockComplete_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (restockComplete_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, restockComplete_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.generated.retail.shop.RestockItemResponse)) {
      return super.equals(obj);
    }
    grpc.generated.retail.shop.RestockItemResponse other = (grpc.generated.retail.shop.RestockItemResponse) obj;

    if (getRestockComplete()
        != other.getRestockComplete()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + RESTOCKCOMPLETE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getRestockComplete());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.generated.retail.shop.RestockItemResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.generated.retail.shop.RestockItemResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.generated.retail.shop.RestockItemResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.generated.retail.shop.RestockItemResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.generated.retail.shop.RestockItemResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.generated.retail.shop.RestockItemResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.generated.retail.shop.RestockItemResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.generated.retail.shop.RestockItemResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.generated.retail.shop.RestockItemResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.generated.retail.shop.RestockItemResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.generated.retail.shop.RestockItemResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.generated.retail.shop.RestockItemResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.generated.retail.shop.RestockItemResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code grpc.generated.retail.shop.RestockItemResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.generated.retail.shop.RestockItemResponse)
      grpc.generated.retail.shop.RestockItemResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.generated.retail.shop.RetailShop.internal_static_grpc_generated_retail_shop_RestockItemResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.generated.retail.shop.RetailShop.internal_static_grpc_generated_retail_shop_RestockItemResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.generated.retail.shop.RestockItemResponse.class, grpc.generated.retail.shop.RestockItemResponse.Builder.class);
    }

    // Construct using grpc.generated.retail.shop.RestockItemResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      restockComplete_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.generated.retail.shop.RetailShop.internal_static_grpc_generated_retail_shop_RestockItemResponse_descriptor;
    }

    @java.lang.Override
    public grpc.generated.retail.shop.RestockItemResponse getDefaultInstanceForType() {
      return grpc.generated.retail.shop.RestockItemResponse.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.generated.retail.shop.RestockItemResponse build() {
      grpc.generated.retail.shop.RestockItemResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.generated.retail.shop.RestockItemResponse buildPartial() {
      grpc.generated.retail.shop.RestockItemResponse result = new grpc.generated.retail.shop.RestockItemResponse(this);
      result.restockComplete_ = restockComplete_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.generated.retail.shop.RestockItemResponse) {
        return mergeFrom((grpc.generated.retail.shop.RestockItemResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.generated.retail.shop.RestockItemResponse other) {
      if (other == grpc.generated.retail.shop.RestockItemResponse.getDefaultInstance()) return this;
      if (other.getRestockComplete() != false) {
        setRestockComplete(other.getRestockComplete());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.generated.retail.shop.RestockItemResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.generated.retail.shop.RestockItemResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private boolean restockComplete_ ;
    /**
     * <code>bool restockComplete = 1;</code>
     * @return The restockComplete.
     */
    @java.lang.Override
    public boolean getRestockComplete() {
      return restockComplete_;
    }
    /**
     * <code>bool restockComplete = 1;</code>
     * @param value The restockComplete to set.
     * @return This builder for chaining.
     */
    public Builder setRestockComplete(boolean value) {
      
      restockComplete_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool restockComplete = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearRestockComplete() {
      
      restockComplete_ = false;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:grpc.generated.retail.shop.RestockItemResponse)
  }

  // @@protoc_insertion_point(class_scope:grpc.generated.retail.shop.RestockItemResponse)
  private static final grpc.generated.retail.shop.RestockItemResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.generated.retail.shop.RestockItemResponse();
  }

  public static grpc.generated.retail.shop.RestockItemResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RestockItemResponse>
      PARSER = new com.google.protobuf.AbstractParser<RestockItemResponse>() {
    @java.lang.Override
    public RestockItemResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RestockItemResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RestockItemResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RestockItemResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.generated.retail.shop.RestockItemResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

