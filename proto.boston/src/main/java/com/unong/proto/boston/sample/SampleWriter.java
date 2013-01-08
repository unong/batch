package com.unong.proto.boston.sample;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class SampleWriter implements ItemWriter<Integer>{
	private static final Logger log = LoggerFactory.getLogger(SampleWriter.class);

	private int calledCnt = 0;
	
	@Override
	public void write(List<? extends Integer> arg0) throws Exception {
		for(Integer arg : arg0) {
			log.info("Unong call start writer => {}", arg);
		}
		
		try {
			Thread.sleep(500);
		}
		catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new RuntimeException("Job interrupted.");
		}		
		
		++calledCnt;
		log.info("Unong called writer => {}", calledCnt);
	}

}
