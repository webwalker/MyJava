package com.webwalker.test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.webwalker.cxf.WebServiceSample;

public class TestWebServiceSample extends TestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public final void test() {
		// spring 调用ws服务端
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"/WebContent/CLIENT/ws-client.xml");

		WebServiceSample client = (WebServiceSample) context
				.getBean("WebServiceSampleClient");
		System.out.println(client.say("Test"));
	}

}
