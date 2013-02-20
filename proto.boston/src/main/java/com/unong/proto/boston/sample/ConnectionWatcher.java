package com.unong.proto.boston.sample;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionWatcher implements Watcher {
	private static final Logger log = LoggerFactory.getLogger(ConnectionWatcher.class);
	
	private static final int SESSION_TIMEOUT = 5000;
	
	public ZooKeeper zk;
	
	private CountDownLatch connectedSignal = new CountDownLatch(1);
	
	public void connect(String hosts) throws IOException, InterruptedException {
		zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
		connectedSignal.await();
	}
	
	public void close() throws InterruptedException {
		zk.close();
	}
	
	@Override
	public void process(WatchedEvent event) {
		log.debug("UNONG watchedEvent stat : {}", event.getState().name());
		
		if(event.getState() == KeeperState.SyncConnected) {
			connectedSignal.countDown();
		} 
	}
}
