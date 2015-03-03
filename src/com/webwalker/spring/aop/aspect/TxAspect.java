package com.webwalker.spring.aop.aspect;

public aspect TxAspect 
{
	//指定执行Hello.sayHello()方法时执行下面代码块
	void around():call(void AspectJTest.sayHello())
	{
		System.out.println("开始事务...");
		proceed();
		System.out.println("事务结束...");
	}
}