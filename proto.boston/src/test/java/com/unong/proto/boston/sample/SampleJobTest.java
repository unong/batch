package com.unong.proto.boston.sample;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/daum-servlet-context.xml", "/spring/root-context.xml", "/spring/sample-job-context.xml",
		"/job-runner-context.xml" })
public class SampleJobTest {
	private static final Logger log = LoggerFactory.getLogger(SampleJobTest.class);

	public SampleJobTest() {
		log.info("Unong construct test");
	}
	
	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;
	
	@Test
	public void test1step() throws Exception {
		log.info("Unong start test");

		Job job = jobLauncherTestUtils.getJob();
		log.info("Unong jobName {}", job.getName());
		
		JobExecution je1 = jobLauncherTestUtils.launchJob();
		assertEquals(ExitStatus.COMPLETED, je1.getExitStatus());
		
		JobExecution je2 = jobLauncherTestUtils.launchStep("test1step");
		assertEquals(ExitStatus.COMPLETED, je2.getExitStatus());
	}

}
