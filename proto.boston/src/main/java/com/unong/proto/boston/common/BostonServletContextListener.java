package com.unong.proto.boston.common;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.zookeeper.KeeperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.unong.proto.boston.common.modules.ILockManager;

public class BostonServletContextListener implements ServletContextListener {
	private static final Logger log = LoggerFactory.getLogger(BostonServletContextListener.class);
	
	private ILockManager lockManager;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			lockManager.wannaBeMaster();
		} catch (IOException e) {
			log.error("zookeepr server cannot connect", e);
		} catch (InterruptedException e) {
			log.error("connection thread has problem", e);
		} catch (KeeperException e) {
			log.error("zookeeper has problem", e);
		}
		
		log.debug("UNONG context start");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			lockManager.destroyed();
		} catch (InterruptedException e) {
			log.error("problem occured closing zookeeper", e);
		}
		
		log.debug("UNONG context destroyed");
	}

}
