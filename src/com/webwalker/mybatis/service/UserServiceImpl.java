package com.webwalker.mybatis.service;

import com.webwalker.entity.User;
import com.webwalker.mybatis.mapper.UserMapper;

//服务层实现类
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;

	@Override
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	@Override
	public User getUser(String name) {
		return userMapper.getUser(name);
	}
}