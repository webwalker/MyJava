package com.webwalker.cxf;

import javax.jws.WebService;

@WebService
public class HelloWorldImpl implements IHelloWorld {

	@Override
	public String sayHello(String name) {
		System.out.println("sayHello is called by " + name);
		return "Hello " + name;
	}

}
