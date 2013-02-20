package com.unong.proto.boston.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DaumController {

	private static final Logger logger = LoggerFactory.getLogger(DaumController.class);

	@Autowired
	private JobLauncher jobLauncher = null;
	
	@Autowired
	private Job test1job;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView start() {

		try {
			jobLauncher.run(test1job, new JobParameters());
		} catch (JobExecutionAlreadyRunningException e) {
			logger.error("e1", e);
		} catch (JobRestartException e) {
			logger.error("e2", e);
		} catch (JobInstanceAlreadyCompleteException e) {
			logger.error("e3", e);
		} catch (JobParametersInvalidException e) {
			logger.error("e4", e);
		}
		
		logger.info("start");

		return new ModelAndView("index");
	}
}
