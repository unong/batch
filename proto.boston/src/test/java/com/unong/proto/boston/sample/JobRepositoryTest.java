package com.unong.proto.boston.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.AbstractJobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/daum-servlet-context.xml", "/spring/root-context.xml", "/spring/sample-job-context.xml",
		"/job-runner-context.xml" })
public class JobRepositoryTest {
	private static final Logger log = LoggerFactory.getLogger(JobRepositoryTest.class);
	
//	@Autowired
//	private JobRepository jobRepository;
	
	@Autowired
	private JobRegistry jobRegistry;

	@Autowired
	private JobOperator jobOperator;
	
	@Autowired
	private JobExplorer jobExplorer;
	
	@Autowired
	private AbstractJobRepositoryFactoryBean jobRepository;
	
	@Test
	public void testRepository() throws Exception {
		for(String name : jobRegistry.getJobNames()) {
			log.debug("UNONG : "+ name);
		}
		
		List<JobInstance> jobs = jobExplorer.getJobInstances("test1job", 0, 10);
		for(JobInstance j : jobs) {
			log.debug("UNONG2 : {}" , j.getId());
			log.debug("UNONG2 : {}" , j.getJobName());
			log.debug("UNONG2 : {}" , j.getVersion());
		}
		
		log.debug("UNONG4 : {} , {}" ,jobs.get(0).getJobParameters().toString(), new JobParameters().toString());
		
		JobRepository jr = jobRepository.getJobRepository();
		
		StepExecution se = jr.getLastStepExecution(jobs.get(0), "test1step");
		log.debug("UNONG3 : {}", se.getStatus().name());
		
		Map<String, JobParameter> p = new HashMap<String, JobParameter>();
		p.put("random", new JobParameter(26352L));
		JobParameters jp = new JobParameters(p);
		JobExecution exe = jr.getLastJobExecution("test1job", jp);
		if(exe != null) {
			log.debug("UNONG5 : {}", exe.getCreateTime().toString());
			log.debug("UNONG5 : {}", exe.getEndTime().toString());
			log.debug("UNONG5 : {}", exe.getStartTime().toString());
			log.debug("UNONG5 : {}", exe.getStatus().name());
			log.debug("UNONG5 : {}", exe.getJobId());
			
			
		} else {
			log.debug("no instance");
		}
		
		
	}

}
