// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: IOService.proto

package org.opendedup.grpc;

public final class IOService {
  private IOService() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_dataWriteRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_dataWriteRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_dataWriteResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_dataWriteResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_mkDirRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_mkDirRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_mkDirResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_mkDirResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_rmDirRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_rmDirRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_rmDirResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_rmDirResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_unlinkRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_unlinkRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_unlinkResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_unlinkResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_dataReadRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_dataReadRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_dataReadResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_dataReadResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_fileCloseRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_fileCloseRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_fileCloseResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_fileCloseResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_mkNodRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_mkNodRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_mkNodResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_mkNodResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_fileOpenRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_fileOpenRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_fileOpenResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_fileOpenResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017IOService.proto\022\022org.opendedup.grpc\032\016F" +
      "ileInfo.proto\"P\n\020dataWriteRequest\022\022\n\nfil" +
      "eHandle\030\001 \001(\003\022\r\n\005start\030\002 \001(\003\022\013\n\003len\030\003 \001(" +
      "\005\022\014\n\004data\030\004 \001(\014\"U\n\021dataWriteResponse\022\r\n\005" +
      "error\030\001 \001(\t\0221\n\terrorCode\030\002 \001(\0162\036.org.ope" +
      "ndedup.grpc.errorCodes\"\034\n\014mkDirRequest\022\014" +
      "\n\004path\030\001 \001(\t\"Q\n\rmkDirResponse\022\r\n\005error\030\001" +
      " \001(\t\0221\n\terrorCode\030\002 \001(\0162\036.org.opendedup." +
      "grpc.errorCodes\"\034\n\014rmDirRequest\022\014\n\004path\030" +
      "\001 \001(\t\"Q\n\rrmDirResponse\022\r\n\005error\030\001 \001(\t\0221\n" +
      "\terrorCode\030\002 \001(\0162\036.org.opendedup.grpc.er" +
      "rorCodes\"\035\n\runlinkRequest\022\014\n\004path\030\001 \001(\t\"" +
      "R\n\016unlinkResponse\022\r\n\005error\030\001 \001(\t\0221\n\terro" +
      "rCode\030\002 \001(\0162\036.org.opendedup.grpc.errorCo" +
      "des\"A\n\017dataReadRequest\022\022\n\nfileHandle\030\001 \001" +
      "(\003\022\r\n\005start\030\002 \001(\003\022\013\n\003len\030\003 \001(\005\"p\n\020dataRe" +
      "adResponse\022\014\n\004data\030\001 \001(\014\022\014\n\004read\030\002 \001(\005\022\r" +
      "\n\005error\030\003 \001(\t\0221\n\terrorCode\030\004 \001(\0162\036.org.o" +
      "pendedup.grpc.errorCodes\"&\n\020fileCloseReq" +
      "uest\022\022\n\nfileHandle\030\001 \001(\003\"U\n\021fileCloseRes" +
      "ponse\022\r\n\005error\030\001 \001(\t\0221\n\terrorCode\030\002 \001(\0162" +
      "\036.org.opendedup.grpc.errorCodes\"\034\n\014mkNod" +
      "Request\022\014\n\004path\030\001 \001(\t\"Q\n\rmkNodResponse\022\r" +
      "\n\005error\030\001 \001(\t\0221\n\terrorCode\030\002 \001(\0162\036.org.o" +
      "pendedup.grpc.errorCodes\"\037\n\017fileOpenRequ" +
      "est\022\014\n\004path\030\001 \001(\t\"h\n\020fileOpenResponse\022\022\n" +
      "\nfileHandle\030\001 \001(\003\022\r\n\005error\030\002 \001(\t\0221\n\terro" +
      "rCode\030\003 \001(\0162\036.org.opendedup.grpc.errorCo" +
      "des2\236\005\n\rFileIOService\022L\n\005MkDir\022 .org.ope" +
      "ndedup.grpc.mkDirRequest\032!.org.opendedup" +
      ".grpc.mkDirResponse\022L\n\005rmDir\022 .org.opend" +
      "edup.grpc.rmDirRequest\032!.org.opendedup.g" +
      "rpc.rmDirResponse\022O\n\006unlink\022!.org.opende" +
      "dup.grpc.unlinkRequest\032\".org.opendedup.g" +
      "rpc.unlinkResponse\022T\n\005write\022$.org.opende" +
      "dup.grpc.dataWriteRequest\032%.org.opendedu" +
      "p.grpc.dataWriteResponse\022Q\n\004read\022#.org.o" +
      "pendedup.grpc.dataReadRequest\032$.org.open" +
      "dedup.grpc.dataReadResponse\022V\n\007release\022$" +
      ".org.opendedup.grpc.fileCloseRequest\032%.o" +
      "rg.opendedup.grpc.fileCloseResponse\022L\n\005m" +
      "knod\022 .org.opendedup.grpc.mkNodRequest\032!" +
      ".org.opendedup.grpc.mkNodResponse\022Q\n\004ope" +
      "n\022#.org.opendedup.grpc.fileOpenRequest\032$" +
      ".org.opendedup.grpc.fileOpenResponseB\002P\001" +
      "b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          org.opendedup.grpc.FileInfo.getDescriptor(),
        });
    internal_static_org_opendedup_grpc_dataWriteRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_org_opendedup_grpc_dataWriteRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_dataWriteRequest_descriptor,
        new java.lang.String[] { "FileHandle", "Start", "Len", "Data", });
    internal_static_org_opendedup_grpc_dataWriteResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_org_opendedup_grpc_dataWriteResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_dataWriteResponse_descriptor,
        new java.lang.String[] { "Error", "ErrorCode", });
    internal_static_org_opendedup_grpc_mkDirRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_org_opendedup_grpc_mkDirRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_mkDirRequest_descriptor,
        new java.lang.String[] { "Path", });
    internal_static_org_opendedup_grpc_mkDirResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_org_opendedup_grpc_mkDirResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_mkDirResponse_descriptor,
        new java.lang.String[] { "Error", "ErrorCode", });
    internal_static_org_opendedup_grpc_rmDirRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_org_opendedup_grpc_rmDirRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_rmDirRequest_descriptor,
        new java.lang.String[] { "Path", });
    internal_static_org_opendedup_grpc_rmDirResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_org_opendedup_grpc_rmDirResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_rmDirResponse_descriptor,
        new java.lang.String[] { "Error", "ErrorCode", });
    internal_static_org_opendedup_grpc_unlinkRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_org_opendedup_grpc_unlinkRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_unlinkRequest_descriptor,
        new java.lang.String[] { "Path", });
    internal_static_org_opendedup_grpc_unlinkResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_org_opendedup_grpc_unlinkResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_unlinkResponse_descriptor,
        new java.lang.String[] { "Error", "ErrorCode", });
    internal_static_org_opendedup_grpc_dataReadRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_org_opendedup_grpc_dataReadRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_dataReadRequest_descriptor,
        new java.lang.String[] { "FileHandle", "Start", "Len", });
    internal_static_org_opendedup_grpc_dataReadResponse_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_org_opendedup_grpc_dataReadResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_dataReadResponse_descriptor,
        new java.lang.String[] { "Data", "Read", "Error", "ErrorCode", });
    internal_static_org_opendedup_grpc_fileCloseRequest_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_org_opendedup_grpc_fileCloseRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_fileCloseRequest_descriptor,
        new java.lang.String[] { "FileHandle", });
    internal_static_org_opendedup_grpc_fileCloseResponse_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_org_opendedup_grpc_fileCloseResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_fileCloseResponse_descriptor,
        new java.lang.String[] { "Error", "ErrorCode", });
    internal_static_org_opendedup_grpc_mkNodRequest_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_org_opendedup_grpc_mkNodRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_mkNodRequest_descriptor,
        new java.lang.String[] { "Path", });
    internal_static_org_opendedup_grpc_mkNodResponse_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_org_opendedup_grpc_mkNodResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_mkNodResponse_descriptor,
        new java.lang.String[] { "Error", "ErrorCode", });
    internal_static_org_opendedup_grpc_fileOpenRequest_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_org_opendedup_grpc_fileOpenRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_fileOpenRequest_descriptor,
        new java.lang.String[] { "Path", });
    internal_static_org_opendedup_grpc_fileOpenResponse_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_org_opendedup_grpc_fileOpenResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_fileOpenResponse_descriptor,
        new java.lang.String[] { "FileHandle", "Error", "ErrorCode", });
    org.opendedup.grpc.FileInfo.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
