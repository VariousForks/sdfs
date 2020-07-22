// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: FileInfo.proto

package org.opendedup.grpc;

/**
 * Protobuf enum {@code org.opendedup.grpc.errorCodes}
 */
public enum errorCodes
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>NOERR = 0;</code>
   */
  NOERR(0),
  /**
   * <code>ENOENT = 1;</code>
   */
  ENOENT(1),
  /**
   * <code>EIO = 3;</code>
   */
  EIO(3),
  /**
   * <code>EAGAIN = 4;</code>
   */
  EAGAIN(4),
  /**
   * <code>EEXIST = 5;</code>
   */
  EEXIST(5),
  /**
   * <code>ENOTDIR = 6;</code>
   */
  ENOTDIR(6),
  /**
   * <code>ENODATA = 7;</code>
   */
  ENODATA(7),
  /**
   * <code>ENAVAIL = 8;</code>
   */
  ENAVAIL(8),
  /**
   * <code>EPERM = 9;</code>
   */
  EPERM(9),
  /**
   * <code>ENOSPC = 10;</code>
   */
  ENOSPC(10),
  /**
   * <code>EACCES = 11;</code>
   */
  EACCES(11),
  /**
   * <code>ENOTEMPTY = 12;</code>
   */
  ENOTEMPTY(12),
  /**
   * <code>ENNOSYS = 13;</code>
   */
  ENNOSYS(13),
  /**
   * <code>ENODEV = 14;</code>
   */
  ENODEV(14),
  /**
   * <code>EBADFD = 15;</code>
   */
  EBADFD(15),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>NOERR = 0;</code>
   */
  public static final int NOERR_VALUE = 0;
  /**
   * <code>ENOENT = 1;</code>
   */
  public static final int ENOENT_VALUE = 1;
  /**
   * <code>EIO = 3;</code>
   */
  public static final int EIO_VALUE = 3;
  /**
   * <code>EAGAIN = 4;</code>
   */
  public static final int EAGAIN_VALUE = 4;
  /**
   * <code>EEXIST = 5;</code>
   */
  public static final int EEXIST_VALUE = 5;
  /**
   * <code>ENOTDIR = 6;</code>
   */
  public static final int ENOTDIR_VALUE = 6;
  /**
   * <code>ENODATA = 7;</code>
   */
  public static final int ENODATA_VALUE = 7;
  /**
   * <code>ENAVAIL = 8;</code>
   */
  public static final int ENAVAIL_VALUE = 8;
  /**
   * <code>EPERM = 9;</code>
   */
  public static final int EPERM_VALUE = 9;
  /**
   * <code>ENOSPC = 10;</code>
   */
  public static final int ENOSPC_VALUE = 10;
  /**
   * <code>EACCES = 11;</code>
   */
  public static final int EACCES_VALUE = 11;
  /**
   * <code>ENOTEMPTY = 12;</code>
   */
  public static final int ENOTEMPTY_VALUE = 12;
  /**
   * <code>ENNOSYS = 13;</code>
   */
  public static final int ENNOSYS_VALUE = 13;
  /**
   * <code>ENODEV = 14;</code>
   */
  public static final int ENODEV_VALUE = 14;
  /**
   * <code>EBADFD = 15;</code>
   */
  public static final int EBADFD_VALUE = 15;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static errorCodes valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static errorCodes forNumber(int value) {
    switch (value) {
      case 0: return NOERR;
      case 1: return ENOENT;
      case 3: return EIO;
      case 4: return EAGAIN;
      case 5: return EEXIST;
      case 6: return ENOTDIR;
      case 7: return ENODATA;
      case 8: return ENAVAIL;
      case 9: return EPERM;
      case 10: return ENOSPC;
      case 11: return EACCES;
      case 12: return ENOTEMPTY;
      case 13: return ENNOSYS;
      case 14: return ENODEV;
      case 15: return EBADFD;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<errorCodes>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      errorCodes> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<errorCodes>() {
          public errorCodes findValueByNumber(int number) {
            return errorCodes.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return org.opendedup.grpc.FileInfo.getDescriptor().getEnumTypes().get(0);
  }

  private static final errorCodes[] VALUES = values();

  public static errorCodes valueOf(
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

  private errorCodes(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:org.opendedup.grpc.errorCodes)
}

