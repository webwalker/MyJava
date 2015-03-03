package com.webwalker.mybatis.service;

import com.webwalker.entity.User;

public interface UserService {

	public void insertUser(User user);

	public User getUser(String name);
}