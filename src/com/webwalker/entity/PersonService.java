package com.webwalker.entity;

public class PersonService {
	private String name;
	private String a;

	// name属性的setter方法
	public void setName(String name) {
		this.name = name;
	}
	
	public void seta(String name) {
		this.a = name;
	}

	// 测试Person类的info方法
	public void info() {
		System.out.println("此人名为：" + name + "," + a);
	}
}
