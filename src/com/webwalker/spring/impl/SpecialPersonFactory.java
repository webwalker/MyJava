package com.webwalker.spring.impl;

import org.springframework.beans.factory.FactoryBean;

import com.webwalker.spring.Interface.Person;

public class SpecialPersonFactory implements FactoryBean<Person> {

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

	Person p = null;

	// 返回工厂Bean所生产的产品
	public Person getObject() {
		if (p == null) {
			p = new Chinese();
		}
		return p;
	}

	// 获取工厂Bean所生产的产品的类型
	public Class<? extends Person> getObjectType() {
		return Chinese.class;
	}

	// 返回该工厂Bean所生成的产品是否为单例
	public boolean isSingleton() {
		return true;
	}
}
