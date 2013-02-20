package com.unong.proto.boston.zookeeper;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.junit.Test;

import com.unong.proto.boston.sample.ConnectionWatcher;

public class ZooKeeperClientTest {

	@Test
	public void testListgroup() throws IOException, InterruptedException, KeeperException {
		ConnectionWatcher watcher = new ConnectionWatcher();
		watcher.connect("192.168.174.144");
		
		String path = "/zoo";
		List<String> children = watcher.zk.getChildren(path, false);
		if(children.isEmpty()) {
			System.out.println("No Member in group : zoo");
		} else {
			for(String child : children) {
				System.out.println(child);
			}
		}
		
		watcher.close();
	}

}
