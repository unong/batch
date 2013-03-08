package com.unong.proto.boston.common.modules;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;

/**
 * 
 * @author unong
 * 
 */
public interface ILockManager {

	// i wanna be master
	public void wannaBeMaster() throws IOException, InterruptedException, KeeperException;

	// context destroyed 
	public void destroyed() throws InterruptedException;
	
	// notify if i'm master
	
	// i am available worker
	
	// who (or what?) was failed ?
	
	// who is available ?
	
	// notify if some job finished  
	
}
