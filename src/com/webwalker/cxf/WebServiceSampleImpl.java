package com.webwalker.cxf;

import java.util.ArrayList;

import javax.jws.WebService;

import com.webwalker.entity.ListObject;
import com.webwalker.entity.UserDTO;

/**
 * WebService实现类.
 * 
 * 使用@WebService指向Interface定义类即可.
 */
@WebService(endpointInterface = "com.webwalker.cxf.WebServiceSample")
public class WebServiceSampleImpl implements WebServiceSample {

	public String sayUserName(UserDTO user) {
		return "hello " + user.getName();
	}

	public String say(String hello) {
		return "hello " + hello;
	}

	public ListObject findUsers() {
		ArrayList<Object> list = new ArrayList<Object>();

		list.add(instancUser(1, "lib"));
		list.add(instancUser(2, "mld"));
		list.add(instancUser(3, "lq"));
		list.add(instancUser(4, "gj"));
		ListObject o = new ListObject();
		o.setList(list);
		return o;
	}

	private UserDTO instancUser(Integer id, String name) {
		UserDTO user = new UserDTO();
		user.setId(id);
		user.setName(name);
		return user;
	}
}
