package com.webwalker.cxf;

import javax.jws.WebService;

@WebService
public interface IHelloWorld {

	public String sayHello(String name);
}
