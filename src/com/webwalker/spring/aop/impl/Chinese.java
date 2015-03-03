package com.webwalker.spring.aop.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.webwalker.spring.aop.Interface.Person;

@Component
public class Chinese implements Person {
	// 实现Person接口的sayHello()方法
	public String sayHello(String name) {

		System.out.println("sayHello方法被调用...");

		// 该方法体内虽然抛出了异常，但该方法
		// 自己处理了该异常，所以AOP不会对该异常进行处理
		// try {
		// System.out.println("sayHello方法开始被执行...");
		// new java.io.FileInputStream("a.txt");
		// } catch (Exception ex) {
		// System.out.println("目标类的异常处理" + ex.getMessage());
		// }

		// 返回简单的字符串
		return name + " Hello , Spring AOP";
	}

	// 定义一个eat()方法
	public void eat(String food) {
		System.out.println("我正在吃:" + food);
	}

	public void eat(String food, Date time) {
		System.out.println("我正在吃" + food + ",现在时间是:" + time);
	}

	// 定义一个divide()方法
	// public void divide() {
	// int a = 5 / 0;
	// System.out.println("divide执行完成！");
	// }
}