package com.webwalker.spring.impl;


public class PersonSon {
	private int age;
	private Son son;

	// age属性的setter和getter方法
	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	// son属性的setter和getter方法
	public void setSon(Son son) {
		this.son = son;
	}

	public Son getSon() {
		return this.son;
	}
}
