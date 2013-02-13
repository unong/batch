package com.unong.proto.boston.sample;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class Common2Listener extends StepListenerSupport<String, String> {
	private static final Logger log = LoggerFactory.getLogger(Common2Listener.class);
	
	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		log.debug("UNONG C2 : {}", "afterStep");
		return super.afterStep(stepExecution);
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.debug("UNONG C2 : {}", "beforeStep");
		super.beforeStep(stepExecution);
	}

	@Override
	public void afterChunk() {
		log.debug("UNONG C2 : {}", "afterChunk");
		super.afterChunk();
	}

	@Override
	public void beforeChunk() {
		log.debug("UNONG C2 : {}", "beforeChunk");
		super.beforeChunk();
	}

	@Override
	public void afterRead(String item) {
		log.debug("UNONG C2 : {}", "afterRead");
		super.afterRead(item);
	}

	@Override
	public void beforeRead() {
		log.debug("UNONG C2 : {}", "beforeRead");
		super.beforeRead();
	}

	@Override
	public void onReadError(Exception ex) {
		log.debug("UNONG C2 : {}", "onReadError");
		super.onReadError(ex);
	}

	@Override
	public void afterWrite(List<? extends String> items) {
		log.debug("UNONG C2 : {}", "afterWrite");
		super.afterWrite(items);
	}

	@Override
	public void beforeWrite(List<? extends String> items) {
		log.debug("UNONG C2 : {}", "beforeWrite");
		super.beforeWrite(items);
	}

	@Override
	public void onWriteError(Exception exception, List<? extends String> items) {
		log.debug("UNONG C2 : {}", "onWriteError");
		super.onWriteError(exception, items);
	}

	@Override
	public void afterProcess(String item, String result) {
		log.debug("UNONG C2 : {}", "afterProcess");
		super.afterProcess(item, result);
	}

	@Override
	public void beforeProcess(String item) {
		log.debug("UNONG C2 : {}", "beforeProcess");
		super.beforeProcess(item);
	}

	@Override
	public void onProcessError(String item, Exception e) {
		log.debug("UNONG C2 : {}", "onProcessError");
		super.onProcessError(item, e);
	}

	@Override
	public void onSkipInProcess(String item, Throwable t) {
		log.debug("UNONG C2 : {}", "onSkipInProcess");
		super.onSkipInProcess(item, t);
	}

	@Override
	public void onSkipInRead(Throwable t) {
		log.debug("UNONG C2 : {}", "onSkipInRead");
		super.onSkipInRead(t);
	}

	@Override
	public void onSkipInWrite(String item, Throwable t) {
		log.debug("UNONG C2 : {}", "onSkipInWrite");
		super.onSkipInWrite(item, t);
	}

	
}
