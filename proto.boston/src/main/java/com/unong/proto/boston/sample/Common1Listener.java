package com.unong.proto.boston.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class Common1Listener implements StepExecutionListener {
	private static final Logger log = LoggerFactory.getLogger(Common1Listener.class);
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.debug("UNONG C1 : {} ", "before");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		log.debug("UNONG C1 : {} ", "after");
		return ExitStatus.COMPLETED;
	}
	
}
