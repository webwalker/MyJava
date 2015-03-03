package com.webwalker.cxf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.webwalker.entity.User;

public class SpringUsersWsClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 调用WebService
		/*
		 * JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		 * factory.setServiceClass(IComplexUserService.class);
		 * factory.setAddress("http://localhost:8080/CXFWebService/Users");
		 * IComplexUserService service = (IComplexUserService) factory.create();
		 * System
		 * .out.println("#############Client getUserByName##############"); User
		 * user = service.getUserByName("hoojo"); System.out.println(user);
		 * user.setAddress("China-Guangzhou"); service.setUser(user);
		 */
	}

}
