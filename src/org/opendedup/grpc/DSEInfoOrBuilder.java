// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: VolumeService.proto

package org.opendedup.grpc;

public interface DSEInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:org.opendedup.grpc.DSEInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 maxSize = 1;</code>
   * @return The maxSize.
   */
  long getMaxSize();

  /**
   * <code>int64 currentSize = 2;</code>
   * @return The currentSize.
   */
  long getCurrentSize();

  /**
   * <code>int64 entries = 3;</code>
   * @return The entries.
   */
  long getEntries();

  /**
   * <code>int64 compressedSize = 4;</code>
   * @return The compressedSize.
   */
  long getCompressedSize();

  /**
   * <code>int64 freeBlocks = 5;</code>
   * @return The freeBlocks.
   */
  long getFreeBlocks();

  /**
   * <code>int64 pageSize = 6;</code>
   * @return The pageSize.
   */
  long getPageSize();

  /**
   * <code>string storageType = 7;</code>
   * @return The storageType.
   */
  java.lang.String getStorageType();
  /**
   * <code>string storageType = 7;</code>
   * @return The bytes for storageType.
   */
  com.google.protobuf.ByteString
      getStorageTypeBytes();

  /**
   * <code>int32 listenPort = 8;</code>
   * @return The listenPort.
   */
  int getListenPort();

  /**
   * <code>string listenHost = 9;</code>
   * @return The listenHost.
   */
  java.lang.String getListenHost();
  /**
   * <code>string listenHost = 9;</code>
   * @return The bytes for listenHost.
   */
  com.google.protobuf.ByteString
      getListenHostBytes();

  /**
   * <code>int32 readSpeed = 10;</code>
   * @return The readSpeed.
   */
  int getReadSpeed();

  /**
   * <code>int32 writeSpeed = 11;</code>
   * @return The writeSpeed.
   */
  int getWriteSpeed();

  /**
   * <code>int64 cacheSize = 12;</code>
   * @return The cacheSize.
   */
  long getCacheSize();

  /**
   * <code>int64 maxCacheSize = 13;</code>
   * @return The maxCacheSize.
   */
  long getMaxCacheSize();

  /**
   * <code>bool listenEncrypted = 14;</code>
   * @return The listenEncrypted.
   */
  boolean getListenEncrypted();

  /**
   * <code>string encryptionKey = 15;</code>
   * @return The encryptionKey.
   */
  java.lang.String getEncryptionKey();
  /**
   * <code>string encryptionKey = 15;</code>
   * @return The bytes for encryptionKey.
   */
  com.google.protobuf.ByteString
      getEncryptionKeyBytes();

  /**
   * <code>string encryptionIV = 16;</code>
   * @return The encryptionIV.
   */
  java.lang.String getEncryptionIV();
  /**
   * <code>string encryptionIV = 16;</code>
   * @return The bytes for encryptionIV.
   */
  com.google.protobuf.ByteString
      getEncryptionIVBytes();

  /**
   * <code>string cloudAccessKey = 17;</code>
   * @return The cloudAccessKey.
   */
  java.lang.String getCloudAccessKey();
  /**
   * <code>string cloudAccessKey = 17;</code>
   * @return The bytes for cloudAccessKey.
   */
  com.google.protobuf.ByteString
      getCloudAccessKeyBytes();

  /**
   * <code>string cloudSecretKey = 18;</code>
   * @return The cloudSecretKey.
   */
  java.lang.String getCloudSecretKey();
  /**
   * <code>string cloudSecretKey = 18;</code>
   * @return The bytes for cloudSecretKey.
   */
  com.google.protobuf.ByteString
      getCloudSecretKeyBytes();

  /**
   * <code>string bucketName = 19;</code>
   * @return The bucketName.
   */
  java.lang.String getBucketName();
  /**
   * <code>string bucketName = 19;</code>
   * @return The bytes for bucketName.
   */
  com.google.protobuf.ByteString
      getBucketNameBytes();
}
