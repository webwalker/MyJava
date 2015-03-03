package com.webwalker.spring.impl;

import com.webwalker.spring.Interface.Person;

public class PersonFactory {

	/**
	 * 获得Person实例的实例工厂方法
	 * 
	 * @param ethnic
	 *            决定返回哪个Person实例的参数
	 * @return 返回Person实例
	 */
	public Person getPerson(String ethnic) {

		if (ethnic.equalsIgnoreCase("chin")) {
			return new Chinese();
		} else {
			return new American();
		}
	}
}
