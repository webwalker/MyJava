package com.webwalker.mybatis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.webwalker.entity.User;
import com.webwalker.mybatis.mapper.UserMapper;
import com.webwalker.mybatis.service.UserService;
import com.webwalker.utils.Consts;

public class TestUserServiceSpring {
	@Test
	public void userServiceTest() {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				Consts.Path.WebInf
						+ "applicationContext-mybatis-testuserservice.xml");
		UserService service = (UserService) context.getBean("userService");
		User user = service.getUser("张三");
		System.out.println(user.toString());
	}
}
