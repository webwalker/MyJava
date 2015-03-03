package com.webwalker.entity;

import java.util.HashMap;
import java.util.List;

/**
 * CXF直接传递集合对象会出现异常，用一个对象包装下就Ok了
 * 
 * @author Administrator
 * 
 */
public class Users {
	private List<User> users;
	private User[] userArr;
	private HashMap<String, User> maps;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User[] getUserArr() {
		return userArr;
	}

	public void setUserArr(User[] userArr) {
		this.userArr = userArr;
	}

	public HashMap<String, User> getMaps() {
		return maps;
	}

	public void setMaps(HashMap<String, User> maps) {
		this.maps = maps;
	}

}