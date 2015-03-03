package com.webwalker.spring.impl;

import com.webwalker.spring.Interface.Being;


public class BeingFactory
{
	/**
	 * 获取Being实例的静态工厂方法
	 * @param arg 决定返回哪个Being实例的参数
	 */
	public static Being getBeing(String arg) 
	{
		//调用此静态方法的参数为dog，则返回Dog实例
		if (arg.equalsIgnoreCase("dog"))
		{
			return new Dog();
		}
		//否则返回Cat实例
		else
		{
			return new Cat();
		}
	}
}
