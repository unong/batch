package com.unong.proto.boston.sample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import com.unong.proto.boston.sample.DaumController;

import static org.springframework.test.web.ModelAndViewAssert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/daum-servlet-context.xml", "/spring/root-context.xml", "/spring/sample-job-context.xml"})
public class DaumControllerTest {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private HandlerAdapter handlerAdapter;

	@Autowired
	private DaumController daumController;

	@Before
	public void setUp() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		handlerAdapter = new AnnotationMethodHandlerAdapter();
	}

	@Test
	public void startTest() throws Exception {

		request.setRequestURI("/");
		request.setMethod("GET");

		ModelAndView daumModelAndView = handlerAdapter.handle(request, response, daumController);

		assertViewName(daumModelAndView, "index");
	}
}
