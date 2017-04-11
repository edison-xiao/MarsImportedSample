// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TaskOperateEnum.proto

package com.xinguang.tubobo.msgprotocol.transfer;

public final class TaskOperateEnumPB {
  private TaskOperateEnumPB() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code TaskOperateEnum}
   */
  public enum TaskOperateEnum
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <pre>
     *抢单
     * </pre>
     *
     * <code>GRAB = 0;</code>
     */
    GRAB(0),
    /**
     * <pre>
     *取货
     * </pre>
     *
     * <code>PICK = 1;</code>
     */
    PICK(1),
    /**
     * <pre>
     *送达
     * </pre>
     *
     * <code>FINISH = 2;</code>
     */
    FINISH(2),
    UNRECOGNIZED(-1),
    ;

    /**
     * <pre>
     *抢单
     * </pre>
     *
     * <code>GRAB = 0;</code>
     */
    public static final int GRAB_VALUE = 0;
    /**
     * <pre>
     *取货
     * </pre>
     *
     * <code>PICK = 1;</code>
     */
    public static final int PICK_VALUE = 1;
    /**
     * <pre>
     *送达
     * </pre>
     *
     * <code>FINISH = 2;</code>
     */
    public static final int FINISH_VALUE = 2;


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
    public static TaskOperateEnum valueOf(int value) {
      return forNumber(value);
    }

    public static TaskOperateEnum forNumber(int value) {
      switch (value) {
        case 0: return GRAB;
        case 1: return PICK;
        case 2: return FINISH;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<TaskOperateEnum>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        TaskOperateEnum> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<TaskOperateEnum>() {
            public TaskOperateEnum findValueByNumber(int number) {
              return TaskOperateEnum.forNumber(number);
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
      return com.xinguang.tubobo.msgprotocol.transfer.TaskOperateEnumPB.getDescriptor().getEnumTypes().get(0);
    }

    private static final TaskOperateEnum[] VALUES = values();

    public static TaskOperateEnum valueOf(
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

    private TaskOperateEnum(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:TaskOperateEnum)
  }


  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025TaskOperateEnum.proto*1\n\017TaskOperateEn" +
      "um\022\010\n\004GRAB\020\000\022\010\n\004PICK\020\001\022\n\n\006FINISH\020\002B=\n(co" +
      "m.xinguang.tubobo.msgprotocol.transferB\021" +
      "TaskOperateEnumPBb\006proto3"
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
