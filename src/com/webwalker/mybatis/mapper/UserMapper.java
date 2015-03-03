package com.webwalker.mybatis.mapper;

import com.webwalker.entity.User;

public interface UserMapper extends SqlMapper {

	public void insertUser(User user);

	public User getUser(String name);
}
