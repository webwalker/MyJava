package com.webwalker.cxf;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.webwalker.entity.User;
import com.webwalker.entity.Users;

public class MainClient {
	static String prefix = "http://localhost:8080/test/services/";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Spring1();
		ComplexClient();
		// Invoke();
	}

	static void Spring1() {
		// spring 调用ws服务端
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"/WebContent/CLIENT/ws-client.xml");

		WebServiceSample client = (WebServiceSample) context
				.getBean("WebServiceSampleClient");
		System.out.println(client.say("Test"));

	}

	static void Spring2() {
		// spring 调用ws服务端
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"/WebContent/CLIENT/ws-client.xml");

		IHelloWorld helloWorld = (IHelloWorld) context
				.getBean("helloWorldClient");
		System.out.println(helloWorld.sayHello("Test"));

	}

	static void ComplexClient() {
		// 调用WebService JaxWsProxyFactoryBean factory = new
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(IComplexUserService.class);
		factory.setAddress(prefix + "ComplexSample");
		IComplexUserService service = (IComplexUserService) factory.create();
		
		System.out.println("#############Client getUserByName##############");
		User user = service.getUserByName("hoojo");
		System.out.println(user);
		
		user.setAddress("China-Guangzhou");
		service.setUser(user);
		System.out.println("#############Client getUsers##############");
		Users users = service.getUsers(4);
		System.out.println(users);
		
		List<User> tempUsers = new ArrayList<User>();
		for (User u : users.getUsers()) {
			System.out.println(u);
			u.setName("hoojo" + new Random().nextInt(100));
			u.setAddress("Chian-GuangZhou#" + new Random().nextInt(100));
			tempUsers.add(u);
		}
		users.getUsers().clear();
		users.getUsers().addAll(tempUsers);
		service.setUsers(users);
		System.out.println("#############Client getUserArray##############");
		users = service.getUserArray(4);
		User[] userArr = new User[4];
		int i = 0;
		for (User u : users.getUserArr()) {
			System.out.println(u);
			u.setName("hoojo" + new Random().nextInt(100));
			u.setAddress("Chian-ShenZhen#" + new Random().nextInt(100));
			userArr[i] = u;
			i++;
		}
		users.setUserArr(userArr);
		service.setUserArray(users);
		System.out
				.println("##################Client getUserMap###############");
		users = service.getUserMap();
		System.out.println(users.getMaps());
		users.getMaps().put("ABA", userArr[0]);
		service.setUserMap(users);
	}

	static void Invoke() {
		// Jax-WS
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress("http://localhost:8080/test/services/HelloWorld");
		factory.setServiceClass(IHelloWorld.class);
		// 增加拦截器（客户端、服务端都可以通过代码、配置方式设置拦截器）
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());

		IHelloWorld hello = (IHelloWorld) factory.create();
		System.out.println(hello.sayHello("xujian"));

		// pojo
		/*
		 * ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
		 * factory.setAddress("http://localhost:8080/HelloWorld");
		 * factory.setServiceClass(IHelloWorld.class); IHelloWorld hello =
		 * (IHelloWorld) factory.create();
		 * System.out.println(hello.sayHello("xujian"));
		 */
	}

}
