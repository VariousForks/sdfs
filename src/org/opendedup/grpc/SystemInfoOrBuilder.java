// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: VolumeService.proto

package org.opendedup.grpc;

public interface SystemInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:org.opendedup.grpc.SystemInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 activeThreads = 1;</code>
   * @return The activeThreads.
   */
  int getActiveThreads();

  /**
   * <code>int32 blocksStored = 2;</code>
   * @return The blocksStored.
   */
  int getBlocksStored();

  /**
   * <code>int32 maxBlocksStored = 3;</code>
   * @return The maxBlocksStored.
   */
  int getMaxBlocksStored();

  /**
   * <code>int64 totalSpace = 4;</code>
   * @return The totalSpace.
   */
  long getTotalSpace();

  /**
   * <code>int64 freeSpace = 5;</code>
   * @return The freeSpace.
   */
  long getFreeSpace();

  /**
   * <code>double totalCpuLoad = 6;</code>
   * @return The totalCpuLoad.
   */
  double getTotalCpuLoad();

  /**
   * <code>double cpuCores = 7;</code>
   * @return The cpuCores.
   */
  double getCpuCores();

  /**
   * <code>double sdfsCpuLoad = 8;</code>
   * @return The sdfsCpuLoad.
   */
  double getSdfsCpuLoad();

  /**
   * <code>double totalMemory = 10;</code>
   * @return The totalMemory.
   */
  double getTotalMemory();

  /**
   * <code>double freeMemory = 11;</code>
   * @return The freeMemory.
   */
  double getFreeMemory();
}