package com.webwalker.cxf;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class MainServer {

	/**
	 * http://localhost:8080/HelloWorld?wsdl
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Jax-WS
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		factory.setServiceClass(HelloWorldImpl.class);
		factory.setAddress("http://localhost:8082/HelloWorld");
		org.apache.cxf.endpoint.Server server = factory.create();
		server.start();

		// 直接发布
		System.out.println("Server start ……");
		HelloWorldImpl service = new HelloWorldImpl();
		String address = "http://localhost:9000/helloWorld";
		Endpoint.publish(address, service);

		// pojo
		/*
		 * HelloWorldImpl helloWorldImpl = new HelloWorldImpl();
		 * ServerFactoryBean svrFactory = new ServerFactoryBean();
		 * svrFactory.setServiceClass(HelloWorldImpl.class);
		 * svrFactory.setAddress("http://localhost:8082/HelloWorld");
		 * svrFactory.setServiceBean(helloWorldImpl); svrFactory.create();
		 */
	}

}
