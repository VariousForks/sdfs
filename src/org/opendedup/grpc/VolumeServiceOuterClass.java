// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: VolumeService.proto

package org.opendedup.grpc;

public final class VolumeServiceOuterClass {
  private VolumeServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_VolumeInfoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_VolumeInfoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_VolumeInfoResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_VolumeInfoResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_AuthenticationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_AuthenticationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_AuthenticationResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_AuthenticationResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_MessageQueueInfoResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_MessageQueueInfoResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023VolumeService.proto\022\022org.opendedup.grp" +
      "c\032\016Shutdown.proto\032\016FileInfo.proto\"\023\n\021Vol" +
      "umeInfoRequest\"\246\005\n\022VolumeInfoResponse\022\014\n" +
      "\004path\030\001 \001(\t\022\014\n\004name\030\002 \001(\t\022\023\n\013currentSize" +
      "\030\003 \001(\003\022\021\n\tcapactity\030\004 \001(\003\022\031\n\021maxPercenta" +
      "geFull\030\005 \001(\001\022\026\n\016duplicateBytes\030\006 \001(\003\022\021\n\t" +
      "readBytes\030\007 \001(\001\022\022\n\nwriteBytes\030\010 \001(\003\022\024\n\014s" +
      "erialNumber\030\t \001(\003\022\017\n\007dseSize\030\n \001(\003\022\023\n\013ds" +
      "eCompSize\030\013 \001(\003\022\017\n\007readOps\030\014 \001(\001\022\020\n\010writ" +
      "eOps\030\r \001(\001\022\022\n\nreadErrors\030\016 \001(\003\022\023\n\013writeE" +
      "rrors\030\017 \001(\003\022\r\n\005files\030\020 \001(\003\022\030\n\020closedGrac" +
      "efully\030\021 \001(\010\022\032\n\022allowExternalLinks\030\022 \001(\010" +
      "\022\022\n\nusePerfMon\030\023 \001(\010\022\021\n\tclusterId\030\024 \001(\t\022" +
      "\027\n\017VolumeClustered\030\025 \001(\010\022\032\n\022readTimeoutS" +
      "econds\030\026 \001(\005\022\033\n\023writeTimeoutSeconds\030\027 \001(" +
      "\005\022\032\n\022compressedMetaData\030\030 \001(\010\022\021\n\tsyncFil" +
      "es\030\031 \001(\010\022\023\n\013maxPageSize\030\032 \001(\003\022B\n\014message" +
      "Queue\030\033 \003(\0132,.org.opendedup.grpc.Message" +
      "QueueInfoResponse\022\023\n\013perfMonFile\030\034 \001(\t\022\017" +
      "\n\007offline\030\035 \001(\010\";\n\025AuthenticationRequest" +
      "\022\020\n\010username\030\001 \001(\t\022\020\n\010password\030\002 \001(\t\"i\n\026" +
      "AuthenticationResponse\022\r\n\005token\030\001 \001(\t\022\r\n" +
      "\005error\030\002 \001(\t\0221\n\terrorCode\030\003 \001(\0162\036.org.op" +
      "endedup.grpc.errorCodes\"\304\001\n\030MessageQueue" +
      "InfoResponse\022\020\n\010hostName\030\001 \001(\t\022C\n\006mqType" +
      "\030\002 \001(\01623.org.opendedup.grpc.MessageQueue" +
      "InfoResponse.MQType\022\014\n\004port\030\003 \001(\005\022\r\n\005top" +
      "ic\030\004 \001(\t\022\020\n\010authInfo\030\005 \001(\t\"\"\n\006MQType\022\014\n\010" +
      "RabbitMQ\020\000\022\n\n\006PubSub\020\0012\267\002\n\rVolumeService" +
      "\022i\n\020AuthenticateUser\022).org.opendedup.grp" +
      "c.AuthenticationRequest\032*.org.opendedup." +
      "grpc.AuthenticationResponse\022^\n\rGetVolume" +
      "Info\022%.org.opendedup.grpc.VolumeInfoRequ" +
      "est\032&.org.opendedup.grpc.VolumeInfoRespo" +
      "nse\022[\n\016ShutdownVolume\022#.org.opendedup.gr" +
      "pc.ShutdownRequest\032$.org.opendedup.grpc." +
      "ShutdownResponseB2P\001Z.github.com/opended" +
      "up/sdfs-client-go/sdfs/;sdfsb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          org.opendedup.grpc.Shutdown.getDescriptor(),
          org.opendedup.grpc.FileInfo.getDescriptor(),
        });
    internal_static_org_opendedup_grpc_VolumeInfoRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_org_opendedup_grpc_VolumeInfoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_VolumeInfoRequest_descriptor,
        new java.lang.String[] { });
    internal_static_org_opendedup_grpc_VolumeInfoResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_org_opendedup_grpc_VolumeInfoResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_VolumeInfoResponse_descriptor,
        new java.lang.String[] { "Path", "Name", "CurrentSize", "Capactity", "MaxPercentageFull", "DuplicateBytes", "ReadBytes", "WriteBytes", "SerialNumber", "DseSize", "DseCompSize", "ReadOps", "WriteOps", "ReadErrors", "WriteErrors", "Files", "ClosedGracefully", "AllowExternalLinks", "UsePerfMon", "ClusterId", "VolumeClustered", "ReadTimeoutSeconds", "WriteTimeoutSeconds", "CompressedMetaData", "SyncFiles", "MaxPageSize", "MessageQueue", "PerfMonFile", "Offline", });
    internal_static_org_opendedup_grpc_AuthenticationRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_org_opendedup_grpc_AuthenticationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_AuthenticationRequest_descriptor,
        new java.lang.String[] { "Username", "Password", });
    internal_static_org_opendedup_grpc_AuthenticationResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_org_opendedup_grpc_AuthenticationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_AuthenticationResponse_descriptor,
        new java.lang.String[] { "Token", "Error", "ErrorCode", });
    internal_static_org_opendedup_grpc_MessageQueueInfoResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_org_opendedup_grpc_MessageQueueInfoResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_MessageQueueInfoResponse_descriptor,
        new java.lang.String[] { "HostName", "MqType", "Port", "Topic", "AuthInfo", });
    org.opendedup.grpc.Shutdown.getDescriptor();
    org.opendedup.grpc.FileInfo.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
