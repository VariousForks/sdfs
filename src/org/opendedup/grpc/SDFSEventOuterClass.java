// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SDFSEvent.proto

package org.opendedup.grpc;

public final class SDFSEventOuterClass {
  private SDFSEventOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_opendedup_grpc_SDFSEvent_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_opendedup_grpc_SDFSEvent_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017SDFSEvent.proto\022\022org.opendedup.grpc\"\216\002" +
      "\n\tSDFSEvent\022\021\n\tstartTime\030\001 \001(\003\022\017\n\007endTim" +
      "e\030\002 \001(\003\022\r\n\005level\030\003 \001(\t\022\014\n\004type\030\004 \001(\t\022\016\n\006" +
      "target\030\005 \001(\t\022\020\n\010shortMsg\030\006 \001(\t\022\017\n\007longMs" +
      "g\030\007 \001(\t\022\027\n\017percentComplete\030\010 \001(\001\022\020\n\010maxC" +
      "ount\030\t \001(\003\022\024\n\014currentCount\030\n \001(\003\022\014\n\004uuid" +
      "\030\013 \001(\t\022\022\n\nparentUuid\030\014 \001(\t\022\024\n\014extendedIn" +
      "fo\030\r \001(\t\022\024\n\014childrenUUid\030\016 \003(\tB2P\001Z.gith" +
      "ub.com/opendedup/sdfs-client-go/sdfs/;sd" +
      "fsb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_org_opendedup_grpc_SDFSEvent_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_org_opendedup_grpc_SDFSEvent_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_opendedup_grpc_SDFSEvent_descriptor,
        new java.lang.String[] { "StartTime", "EndTime", "Level", "Type", "Target", "ShortMsg", "LongMsg", "PercentComplete", "MaxCount", "CurrentCount", "Uuid", "ParentUuid", "ExtendedInfo", "ChildrenUUid", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
