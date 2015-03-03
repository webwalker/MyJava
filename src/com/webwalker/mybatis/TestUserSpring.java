package com.webwalker.mybatis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.webwalker.entity.User;
import com.webwalker.mybatis.mapper.UserMapper;
import com.webwalker.utils.Consts;

public class TestUserSpring {
	@Test
	public void testGetUser() {
		ApplicationContext aContext = new FileSystemXmlApplicationContext(
				Consts.Path.WebInf + "applicationContext-mybatis-TestUser.xml");
		UserMapper userMapper = aContext.getBean(UserMapper.class);
		User user = userMapper.getUser("张三");
		System.out.println(user.toString());
	}

	@Test
	public void testAddUser() {
		ApplicationContext aContext = new FileSystemXmlApplicationContext(
				Consts.Path.WebInf + "applicationContext-mybatis-TestUser.xml");
		UserMapper userMapper = aContext.getBean(UserMapper.class);
		User user = new User();
		user.setName("张三");
		user.setAge(18);
		userMapper.insertUser(user);
		System.out.println("添加成功");
	}
}
