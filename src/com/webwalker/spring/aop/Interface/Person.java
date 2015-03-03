package com.webwalker.spring.aop.Interface;

import java.util.Date;

public interface Person {
	// 定义一个sayHello()方法
	public String sayHello(String name);

	// 定义一个eat()方法
	public void eat(String food);

	public void eat(String food, Date time);
	// 定义一个divide()方法
	// public void divide();
}
