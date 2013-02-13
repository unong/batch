package com.unong.proto.boston.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BostonServletContextListener implements ServletContextListener {
	private static final Logger log = LoggerFactory.getLogger(BostonServletContextListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.debug("UNONG context start");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.debug("UNONG context destroyed");
	}

}
