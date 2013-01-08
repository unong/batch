package com.unong.proto.boston.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class SampleReader implements ItemReader<Integer>{
	private static final Logger log = LoggerFactory.getLogger(SampleReader.class);

	private Integer calledCnt = 0;
	
	@Override
	public Integer read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		
		++calledCnt;
		log.info("Unong :: called reader => {}", calledCnt);
		
		// maybe read some from a file or files
		// then return some to object
		return calledCnt;
	}
}
