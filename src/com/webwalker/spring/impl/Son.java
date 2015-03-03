package com.webwalker.spring.impl;

public class Son {
	private int age;

	// age属性的setter和getter方法
	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public String toString() {
		return "Son[age=" + age + "]";
	}
}