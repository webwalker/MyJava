package com.webwalker.cxf;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.webwalker.entity.User;
import com.webwalker.entity.Users;

@WebService
@SOAPBinding(style = Style.RPC)
@SuppressWarnings("deprecation")
public class ComplexUserService {
	public User getUserByName(@WebParam(name = "name") String name) {
		User user = new User();
		user.setId(new Date().getSeconds());
		user.setName(name);
		user.setAddress("china");
		user.setEmail(name + "@hoo.com");
		return user;
	}

	public void setUser(User user) {
		System.out.println("############Server setUser###########");
		System.out.println("setUser:" + user);
	}

	public Users getUsers(int i) {
		List<User> users = new ArrayList<User>();
		for (int j = 0; j <= i; j++) {
			User user = new User();
			user.setId(new Date().getSeconds());
			user.setName("jack#" + j);
			user.setAddress("china");
			user.setEmail("jack" + j + "@hoo.com");
			users.add(user);
		}
		Users u = new Users();
		u.setUsers(users);
		return u;
	}

	public void setUsers(Users users) {
		System.out.println("############Server setUsers###########");
		for (User u : users.getUsers()) {
			System.out.println("setUsers:" + u);
		}
	}

	public Users getUserArray(int i) {
		User[] users = new User[i];
		for (int j = 0; j < i; j++) {
			User user = new User();
			user.setId(new Date().getSeconds());
			user.setName("jack#" + j);
			user.setAddress("china");
			user.setEmail("jack" + j + "@hoo.com");
			users[j] = user;
		}
		Users u = new Users();
		u.setUserArr(users);
		return u;
	}

	public void setUserArray(Users users) {
		System.out.println("############Server setUserArray###########");
		for (User u : users.getUserArr()) {
			System.out.println("setUserArray:" + u);
		}
	}

	public void setUserMap(Users maps) {
		System.out.println("############Server setUserMap###########");
		System.out.println("setUserMap:" + maps.getMaps());
	}

	public Users getUserMap() {
		HashMap<String, User> users = new HashMap<String, User>();
		User user = new User();
		user.setId(new Date().getSeconds());
		user.setName("jack#");
		user.setAddress("china#");
		user.setEmail("jack@hoo.com");
		users.put("A", user);
		user = new User();
		user.setId(new Date().getSeconds());
		user.setName("tom");
		user.setAddress("china$$");
		user.setEmail("tom@hoo.com");
		users.put("B", user);
		Users u = new Users();
		u.setMaps(users);
		return u;
	}
}