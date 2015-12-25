package org.opendedup.sdfs.filestore;

import java.io.File;






import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReentrantLock;

import org.opendedup.collections.DataArchivedException;
import org.opendedup.logging.SDFSLogger;
import org.opendedup.sdfs.Main;
import org.opendedup.sdfs.filestore.AbstractChunkStore;
import org.opendedup.sdfs.filestore.ChunkData;
import org.opendedup.sdfs.servers.HCServiceProxy;
import org.opendedup.util.CompressionUtils;
import org.opendedup.util.DeleteDir;
import org.opendedup.util.EncryptUtils;
import org.opendedup.util.StringUtils;
import org.w3c.dom.Element;

import com.google.common.io.BaseEncoding;

import org.opendedup.collections.HashExistsException;
import static java.lang.Math.toIntExact;

/**
 * 
 * @author Sam Silverberg The S3 chunk store implements the AbstractChunkStore
 *         and is used to store deduped chunks to AWS S3 data storage. It is
 *         used if the aws tag is used within the chunk store config file. It is
 *         important to make the chunk size very large on the client when using
 *         this chunk store since S3 charges per http request.
 * 
 */
public class BatchFileChunkStoreNoMap implements AbstractChunkStore, AbstractBatchStore, Runnable {
	private String name;
	boolean compress = false;
	boolean encrypt = false;
	
	private HashMap<Integer, Integer> deletes = new HashMap<Integer, Integer>();
	boolean closed = false;
	boolean deleteUnclaimed = true;
	File staged_sync_location = new File(Main.chunkStore + File.separator + "syncstaged");
	File container_location = new File(Main.chunkStore);

	// private String bucketLocation = null;
	static {

	}

	public static boolean checkAuth(String awsAccessKey, String awsSecretKey) {
		return false;
	}

	public static boolean checkBucketUnique(String awsAccessKey, String awsSecretKey, String bucketName) {
		return false;
	}

	public BatchFileChunkStoreNoMap() {

	}

	@Override
	public long bytesRead() {
		return 0;
	}

	@Override
	public long bytesWritten() {
		return 0;
	}

	@Override
	public void close() {

		try {
			// container = pool.borrowObject();
			HashMap<String, String> md = new HashMap<String, String>();
			md.put("currentlength", Long.toString(HashBlobArchive.currentLength.get()));
			md.put("compressedlength", Long.toString(HashBlobArchive.compressedLength.get()));
			FileOutputStream fout = new FileOutputStream(new File(this.container_location, "BucketInfo"));
			ObjectOutputStream oon = new ObjectOutputStream(fout);
			oon.writeObject(md);
			oon.flush();
			oon.close();
			fout.flush();
			fout.close();
		} catch (Exception e) {
			SDFSLogger.getLog().error("error closing container", e);
		} finally {
			this.closed = true;
		}
		try {
			// this.serviceClient.
		} catch (Exception e) {

		}
	}

	public void expandFile(long length) throws IOException {

	}

	@Override
	public byte[] getChunk(byte[] hash, long start, int len) throws IOException, DataArchivedException {
		try {
			byte[] b = HashBlobArchive.getBlock(hash, start);
			return b;
		} catch (ExecutionException e) {
			SDFSLogger.getLog().error("Unable to get block at " + start, e);
			throw new IOException(e);
		}

	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {

	}

	@Override
	public long size() {
		// TODO Auto-generated method stub
		return HashBlobArchive.currentLength.get();
	}

	public void cacheData(byte[] hash, long start, int len) throws IOException, DataArchivedException {

	}

	@Override
	public long writeChunk(byte[] hash, byte[] chunk, int len) throws IOException {
		try {
			return HashBlobArchive.writeBlock(hash, chunk);
		} catch (HashExistsException e) {
			throw e;
		} catch (Exception e) {
			SDFSLogger.getLog().warn("error writing hash", e);
			throw new IOException(e);
		}
	}

	private ReentrantLock delLock = new ReentrantLock();
	int del = 0;

	@Override
	public void deleteChunk(byte[] hash, long start, int len) throws IOException {
		delLock.lock();
		try {
			ByteBuffer bz = ByteBuffer.allocate(8);
			bz.putLong(start);
			bz.position(0);
			int id = bz.getInt();
			del++;
			// SDFSLogger.getLog().info("deleting " + del);
			if (this.deletes.containsKey(id)) {
				int sz = this.deletes.get(id) + 1;
				this.deletes.put(id, sz);
			} else
				this.deletes.put(id, 1);

		} catch (Exception e) {
			SDFSLogger.getLog().error("error putting data", e);
			throw new IOException(e);
		} finally {
			delLock.unlock();
		}

		/*
		 * String hashString = this.encHashArchiveName(start,
		 * Main.chunkStoreEncryptionEnabled); try { CloudBlockBlob blob =
		 * container.getBlockBlobReference("blocks/" +hashString);
		 * HashMap<String, String> metaData = blob.getMetadata(); int objs =
		 * Integer.parseInt(metaData.get("objects")); objs--; if(objs <= 0) {
		 * blob.delete(); blob = container.getBlockBlobReference("keys/"
		 * +hashString); blob.delete(); }else { metaData.put("objects",
		 * Integer.toString(objs)); blob.setMetadata(metaData);
		 * blob.uploadMetadata(); } } catch (Exception e) { SDFSLogger.getLog()
		 * .warn("Unable to delete object " + hashString, e); } finally {
		 * //pool.returnObject(container); }
		 */
	}

	public void deleteBucket() throws IOException, InterruptedException {
		try {
			DeleteDir.deleteDirectory(container_location);
		} finally {
			// pool.returnObject(container);
		}
		this.close();
	}

	@Override
	public void init(Element config) throws IOException {
		this.name = "filestore";
		this.staged_sync_location.mkdirs();
		HashBlobArchive.REMOVE_FROM_CACHE = false;

		if (config.hasAttribute("default-bucket-location")) {
			// bucketLocation = config.getAttribute("default-bucket-location");
		}
		if (config.hasAttribute("block-size")) {
			int sz = (int) StringUtils.parseSize(config.getAttribute("block-size"));
			HashBlobArchive.MAX_LEN = sz;
		}
		if (config.hasAttribute("delete-unclaimed")) {
			this.deleteUnclaimed = Boolean.parseBoolean(config.getAttribute("delete-unclaimed"));
		}
		if (config.hasAttribute("upload-thread-sleep-time")) {
			int tm = Integer.parseInt(config.getAttribute("upload-thread-sleep-time"));
			HashBlobArchive.THREAD_SLEEP_TIME = tm;
		} else {
			HashBlobArchive.THREAD_SLEEP_TIME = 1000 * 60 * 5;
		}
		if (config.hasAttribute("local-cache-size")) {
			long sz = StringUtils.parseSize(config.getAttribute("local-cache-size"));
			HashBlobArchive.setLocalCacheSize(sz);
		}
		if (config.hasAttribute("map-cache-size")) {
			int sz = Integer.parseInt(config.getAttribute("map-cache-size"));
			HashBlobArchive.MAP_CACHE_SIZE = sz;
		}
		if (config.hasAttribute("io-threads")) {
			int sz = Integer.parseInt(config.getAttribute("io-threads"));
			Main.dseIOThreads = sz;
		}
		if(config.hasAttribute("allow-sync")){
			HashBlobArchive.allowSync = Boolean.parseBoolean(config.getAttribute("allow-sync"));
		}

		try {
			File f = new File(this.container_location, "BucketInfo");
			if (f.exists()) {
				FileInputStream fin = new FileInputStream(f);
				ObjectInputStream oon = new ObjectInputStream(fin);
				@SuppressWarnings("unchecked")
				HashMap<String, String> md = (HashMap<String, String>) oon.readObject();
				oon.close();
				long sz = 0;
				long cl = 0;
				if (md.containsKey("currentlength")) {
					sz = Long.parseLong(md.get("currentlength"));
					if (sz < 0)
						sz = 0;
				}
				if (md.containsKey("compressedlength")) {
					cl = Long.parseLong(md.get("compressedlength"));
					if (cl < 0)
						cl = 0;
				}
				HashBlobArchive.currentLength.set(sz);
				HashBlobArchive.compressedLength.set(cl);
				f.delete();
			}
			this.compress = Main.compress;
			this.encrypt = Main.chunkStoreEncryptionEnabled;
		} catch (Exception e) {
			throw new IOException(e);
		} finally {
			// if (pool != null)
			// pool.returnObject(container);
		}
		Thread thread = new Thread(this);
		thread.start();
		HashBlobArchive.init(this);
	}

	// Iterator<ListBlobItem> iter = null;

	@Override
	public long getFreeBlocks() {
		return 0;
	}

	@Override
	public ChunkData getNextChunck() throws IOException {
		try {
		while(!keys.hasNext()) {
			cm = this.getNextMap();
			if(cm == null)
				return null;
			keys = cm.keySet().iterator();
		}
		String kv = keys.next();
		byte [] key= BaseEncoding.base64().decode(kv);
		return new ChunkData(key, hid);
		}catch(Exception e) {
			throw new IOException(e);
		}
	}

	private HashMap<String, String> readHashMap(long id) throws IOException, ClassNotFoundException {
		File _f = new File(HashBlobArchive.getPath(id).getPath() + ".md");
		FileInputStream fin = new FileInputStream(_f);
		ObjectInputStream oon = new ObjectInputStream(fin);
		@SuppressWarnings("unchecked")
		HashMap<String, String> md = (HashMap<String, String>) oon.readObject();
		oon.close();
		return md;
	}

	private void writeHashMap(HashMap<String, String> md, long id) throws IOException {
		File _f = new File(HashBlobArchive.getPath(id).getPath() + ".md");
		FileOutputStream fout = new FileOutputStream(_f);
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(md);
		out.flush();
		out.close();
	}

	private int verifyDelete(int id) throws IOException {
		try {
			int claims = 0;
		Map<String,Integer> m = this.getHashMap(id);
		Set<String> keys = m.keySet();
		for (String key : keys) {
			long _cid = HCServiceProxy.getHashesMap().get(BaseEncoding.base64().decode(key));
			ByteBuffer bz = ByteBuffer.allocate(8);
			bz.putLong(_cid);
			bz.position(0);
			int cid = bz.getInt();
			if (cid == id)
				claims++;
		}
		return claims;
		}catch(Exception e) {
			throw new IOException(e);
		}
	}
	
	private String[] getStrings(int id) throws IOException, ClassNotFoundException {
		HashMap<String, String> md = this.readHashMap(id);
		
		byte[] nm = Files.readAllBytes(new File(HashBlobArchive.getPath(id).getPath() + ".smap").toPath());
		boolean encrypt = Boolean.parseBoolean(md.get("encrypt"));
		if (encrypt) {
			nm = EncryptUtils.decryptCBC(nm);
		}
		boolean compress = Boolean.parseBoolean(md.get("lz4Compress"));
		if (compress) {
			int size = Integer.parseInt(md.get("keysize"));
			nm = CompressionUtils.decompressLz4(nm, size);
		}
		String st = new String(nm);
		return st.split(",");

	}

	

	@Override
	public long maxSize() {
		return Main.chunkStoreAllocationSize;
	}

	@Override
	public long compressedSize() {
		return HashBlobArchive.compressedLength.get();
	}

	@Override
	public void deleteDuplicate(byte[] hash, long start, int len) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean fileExists(long id) throws IOException {
		try {
			File f = HashBlobArchive.getPath(id);
			return f.exists();
		} catch (Exception e) {
			SDFSLogger.getLog().error("unable to get id", e);
			throw new IOException(e);
		}

	}

	@Override
	public void writeHashBlobArchive(HashBlobArchive arc,long id) throws IOException {
		try {
			HashMap<String, String> metaData = new HashMap<String, String>();
			metaData.put("objects", Integer.toString(arc.getSz()));
			metaData.put("bsize", Integer.toString(arc.uncompressedLength.get()));
			byte [] chunks = arc.getHashesString().getBytes();
			File blob = new File(arc.getFile().getPath() + ".smap");
			// metaData = new HashMap<String, String>();
			int sz = chunks.length;
			if (Main.compress) {
				chunks = CompressionUtils.compressLz4(chunks);
			} 
			if (Main.chunkStoreEncryptionEnabled) {
				chunks = EncryptUtils.encryptCBC(chunks);
			}
			metaData.put("keycompressedsize", Integer.toString(chunks.length));
			metaData.put("keysize", Integer.toString(sz));
			Files.write(blob.toPath(), chunks);
			this.writeHashMap(metaData,id);
		} catch (Exception e) {
			SDFSLogger.getLog().error("unable to write archive " + arc.getID(), e);
			throw new IOException(e);
		} finally {
			// pool.returnObject(container);
		}

	}

	@Override
	public byte[] getBytes(long id) throws IOException {
		return null;
	}

	@Override
	public void run() {
		while (!closed) {
			try {
				Thread.sleep(1000);
				if (this.deletes.size() > 0) {
					this.delLock.lock();
					HashMap<Integer, Integer> odel = null;
					try {
						odel = this.deletes;
						this.deletes = new HashMap<Integer, Integer>();
						// SDFSLogger.getLog().info("delete hash table size of "
						// + odel.size());
					} finally {
						this.delLock.unlock();
					}
					Set<Integer> iter = odel.keySet();
					for (Integer k : iter) {

						try {
							File blob = HashBlobArchive.getPath(k);
							HashMap<String, String> metaData = null;
							int objs = 0;
							try {
								metaData = this.readHashMap(k);
								objs = Integer.parseInt(metaData.get("objects"));
							}catch(Exception e) {
								metaData = new HashMap<String,String>();
							}
							// SDFSLogger.getLog().info("remove requests for " +
							// hashString + "=" + odel.get(k));
							int delobj = 0;
							if (metaData.containsKey("deleted-objects"))
								delobj = Integer.parseInt((String) metaData.get("deleted-objects"));
							
							delobj = delobj + odel.get(k);
							SDFSLogger.getLog().debug("remove requests for " +
									 k + "=" + odel.get(k) + " delob="+delobj + " bsz=" + metaData.get("bsize"));
							if (objs <= delobj) {

								if (this.deleteUnclaimed) {
									int claims = this.verifyDelete(k);
									if (claims > 0) {
										SDFSLogger.getLog().warn("Not deleting " + k + " claims=" + claims);
										metaData.put("objects", Integer.toString(claims));
										metaData.put("deleted-objects", "0");
										metaData.put("deleted-objects", Integer.toString(delobj));
										this.writeHashMap(metaData, k);
										try {
											long cl =0;
										//long cl = HashBlobArchive.compactArchive(k);
										HashBlobArchive.currentLength.addAndGet(-1 * Integer.parseInt(metaData.get("bsize")));
										SDFSLogger.getLog().info("compacted archive ["+k+"] by [" + cl+"]");
										}catch(Exception e) {
											
										}
									} else {
										long fs = blob.length();
										HashBlobArchive.deleteArchive(k);
										HashBlobArchive.currentLength.addAndGet(-1 * Integer.parseInt(metaData.get("bsize")));
										HashBlobArchive.compressedLength.addAndGet(-1 *fs);
										File _f = new File(HashBlobArchive.getPath(k).getPath() + ".md");
										_f.delete();
									}
								} else {
									// SDFSLogger.getLog().info("deleting " +
									// hashString);
									metaData.put("deleted", "true");
									metaData.put("deleted-objects", Integer.toString(delobj));
									this.writeHashMap(metaData, k);
								}
								HashBlobArchive.removeCache(k.longValue());
							} else {
								 SDFSLogger.getLog().debug("updating " +
								 k + " sz=" +objs);
								metaData.put("deleted-objects", Integer.toString(delobj));
								this.writeHashMap(metaData, k);
								try {
									long cl =0;
								//long cl = HashBlobArchive.compactArchive(k);
								
								HashBlobArchive.currentLength.addAndGet(-1 * Integer.parseInt(metaData.get("bsize")));
								SDFSLogger.getLog().info("compacted archive ["+k+"] by [" + cl+"]");
								}catch(Exception e) {
									
								}
							}
						} catch (Exception e) {
							SDFSLogger.getLog().warn("Unable to delete object " + k, e);
						} finally {
							// pool.returnObject(container);
						}
					}

				}
			} catch (InterruptedException e) {
				break;
			} catch (Exception e) {
				SDFSLogger.getLog().error("error in delete thread", e);
			}
		}

	}

	@Override
	public void sync() throws IOException {
		HashBlobArchive.sync();

	}

	@Override
	public boolean checkAccess() {
		return true;
	}

	@Override
	public Map<String, Integer> getHashMap(long id) throws IOException {
		try {
			
			return this.getHashMap(toIntExact(id));
		}catch(Exception e) {
			throw new IOException(e);
		}
	
	}
	
	public Map<String, Integer> getHashMap(int id) throws IOException {
		try {
			
			String[] ks = this.getStrings(id);	
			HashMap<String, Integer> m = new HashMap<String, Integer>(ks.length);
			for (String k : ks) {
				String[] kv = k.split(":");
				m.put(kv[0], Integer.parseInt(kv[1]));
			}

			return m;
		}catch(Exception e) {
			throw new IOException(e);
		}
	
	}

	@Override
	public void setReadSpeed(int kbps) {
		HashBlobArchive.setReadSpeed((double) kbps);

	}

	@Override
	public void setWriteSpeed(int kbps) {
		HashBlobArchive.setWriteSpeed((double) kbps);

	}

	@Override
	public void setCacheSize(long sz) throws IOException {
		HashBlobArchive.setCacheSize(sz);

	}

	@Override
	public int getReadSpeed() {
		return (int) HashBlobArchive.getReadSpeed();
	}

	@Override
	public int getWriteSpeed() {
		return (int) HashBlobArchive.getWriteSpeed();
	}

	@Override
	public long getCacheSize() {
		return HashBlobArchive.getCacheSize();
	}

	@Override
	public long getMaxCacheSize() {
		return HashBlobArchive.getLocalCacheSize();
	}

	@Override
	public String restoreBlock(long id, byte[] hash) {
		return null;

	}

	@Override
	public boolean blockRestored(String id) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean checkAccess(String username, String password, Properties props) throws Exception {
		return true;
	}

	@Override
	public void deleteStore() {
		// TODO Auto-generated method stub

	}

	@Override
	public void compact() {
		// TODO Auto-generated method stub

	}
	
	public void traverseCache(File f) {
		if (f.isDirectory() && !f.getName().equalsIgnoreCase("outgoing")
				&& !f.getName().equalsIgnoreCase("syncstaged")
				&& !f.getName().equalsIgnoreCase("metadata")
				&& !f.getName().equalsIgnoreCase("blocks")
				&& !f.getName().equalsIgnoreCase("keys")
				&& !f.getName().equalsIgnoreCase("sync")) {
			File[] fs = f.listFiles();
			for (File z : fs) {
				if (z.isDirectory()) {
					traverseCache(z);
				} else {
					try {
						if (!z.getPath().endsWith(".map")
								&& !z.getPath().endsWith(".map1") && !z.getPath().endsWith(".md")) {
							maps.add(Integer.parseInt(z.getName()));
						}
					} catch (Exception e) {
						SDFSLogger.getLog().error(
								"unable to cache " + z.getPath(), e);
					}
				}
			}
		}
	}

	private ArrayList<Integer> maps = new ArrayList<Integer>();
	private Iterator<Integer> iter = null;
	private Map<String,Integer> cm = null;
	private Iterator<String> keys = null;
	private long hid;
	@Override
	public void iterationInit(boolean getchunks) throws IOException {
		this.traverseCache(new File(Main.chunkStore));
		iter = maps.iterator();
		HashBlobArchive.currentLength.set(0);
		HashBlobArchive.compressedLength.set(0);
		try {
			cm = this.getNextMap();
			keys = cm.keySet().iterator();
			
		} catch (Exception e) {
			throw new IOException(e);
		}

	}
	
	private Map<String,Integer> getNextMap() throws Exception {
		while(iter.hasNext()) {
			hid = iter.next().longValue();
			try {
				File mf = HashBlobArchive.getPath(hid);
				HashBlobArchive.compressedLength.addAndGet(mf.length());
				mf = new File(mf.getPath() + ".smap");
				Map<String,Integer> m = this.getHashMap(hid);
				HashMap<String, String> metaData = this.readHashMap(hid);
				HashBlobArchive.currentLength.addAndGet(Integer.parseInt(metaData.get("bsize")));
				if(metaData.containsKey("deleted-objects") || metaData.containsKey("deleted")) {
					metaData.remove("deleted-objects");
					metaData.remove("deleted");
					this.writeHashMap(metaData, hid);
				}	
				return m;
			}catch(Exception e) {
				SDFSLogger.getLog().error("error getting " +hid,e);
				throw e;
			}
		}
		return null;
	}

	@Override
	public Iterator<String> getNextObjectList() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringResult getStringResult(String key) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLocalData() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void writeHashBlobArchive(HashBlobArchiveNoMap arc) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeHashBlobArchive(HashBlobArchiveNoMap arc, int id) throws IOException {
		// TODO Auto-generated method stub
		
	}

}