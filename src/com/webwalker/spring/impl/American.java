package com.webwalker.spring.impl;

import com.webwalker.spring.Interface.Person;
import com.webwalker.spring.Interface.PersonHello;

public class American implements Person, PersonHello {
	// 实现Person接口必须实现如下两个方法
	public String sayHello(String name) {
		return name + ",Hello!";
	}

	public String sayGoodBye(String name) {
		return name + ",Good Bye!";
	}

	@Override
	public void useAxe() {
		// TODO Auto-generated method stub

	}
}