// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ResultCode.proto

package com.xinguang.tubobo.msgprotocol.transfer;

public final class ResultCodePB {
  private ResultCodePB() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code ResultCode}
   */
  public enum ResultCode
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>SUCCESS = 0;</code>
     */
    SUCCESS(0),
    /**
     * <code>FAILURE = 1;</code>
     */
    FAILURE(1),
    /**
     * <pre>
     *内部服务错误
     * </pre>
     *
     * <code>SERVER_ERROR = 2;</code>
     */
    SERVER_ERROR(2),
    /**
     * <pre>
     *未登录
     * </pre>
     *
     * <code>UNLONGIN = 100;</code>
     */
    UNLONGIN(100),
    /**
     * <pre>
     *未认证
     * </pre>
     *
     * <code>UNAUTHED = 101;</code>
     */
    UNAUTHED(101),
    /**
     * <pre>
     *任务不可抢
     * </pre>
     *
     * <code>TASK_UN_GETABLE = 102;</code>
     */
    TASK_UN_GETABLE(102),
    /**
     * <pre>
     *押金不足
     * </pre>
     *
     * <code>INSUFFICIENT_DEPOSIT = 103;</code>
     */
    INSUFFICIENT_DEPOSIT(103),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>SUCCESS = 0;</code>
     */
    public static final int SUCCESS_VALUE = 0;
    /**
     * <code>FAILURE = 1;</code>
     */
    public static final int FAILURE_VALUE = 1;
    /**
     * <pre>
     *内部服务错误
     * </pre>
     *
     * <code>SERVER_ERROR = 2;</code>
     */
    public static final int SERVER_ERROR_VALUE = 2;
    /**
     * <pre>
     *未登录
     * </pre>
     *
     * <code>UNLONGIN = 100;</code>
     */
    public static final int UNLONGIN_VALUE = 100;
    /**
     * <pre>
     *未认证
     * </pre>
     *
     * <code>UNAUTHED = 101;</code>
     */
    public static final int UNAUTHED_VALUE = 101;
    /**
     * <pre>
     *任务不可抢
     * </pre>
     *
     * <code>TASK_UN_GETABLE = 102;</code>
     */
    public static final int TASK_UN_GETABLE_VALUE = 102;
    /**
     * <pre>
     *押金不足
     * </pre>
     *
     * <code>INSUFFICIENT_DEPOSIT = 103;</code>
     */
    public static final int INSUFFICIENT_DEPOSIT_VALUE = 103;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static ResultCode valueOf(int value) {
      return forNumber(value);
    }

    public static ResultCode forNumber(int value) {
      switch (value) {
        case 0: return SUCCESS;
        case 1: return FAILURE;
        case 2: return SERVER_ERROR;
        case 100: return UNLONGIN;
        case 101: return UNAUTHED;
        case 102: return TASK_UN_GETABLE;
        case 103: return INSUFFICIENT_DEPOSIT;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<ResultCode>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        ResultCode> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<ResultCode>() {
            public ResultCode findValueByNumber(int number) {
              return ResultCode.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return com.xinguang.tubobo.msgprotocol.transfer.ResultCodePB.getDescriptor().getEnumTypes().get(0);
    }

    private static final ResultCode[] VALUES = values();

    public static ResultCode valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private ResultCode(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:ResultCode)
  }


  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020ResultCode.proto*\203\001\n\nResultCode\022\013\n\007SUC" +
      "CESS\020\000\022\013\n\007FAILURE\020\001\022\020\n\014SERVER_ERROR\020\002\022\014\n" +
      "\010UNLONGIN\020d\022\014\n\010UNAUTHED\020e\022\023\n\017TASK_UN_GET" +
      "ABLE\020f\022\030\n\024INSUFFICIENT_DEPOSIT\020gB8\n(com." +
      "xinguang.tubobo.msgprotocol.transferB\014Re" +
      "sultCodePBb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
