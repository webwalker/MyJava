package com.webwalker.spring.aop.aspect;

import java.util.Date;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AccessArgAspect {
	
	// 下面的args(msg,time)保证该切入点只匹
	// 具有第一个参数是字符串，第二个参数是Date的方法
	@AfterReturning(pointcut = "execution(* com.webwalker.spring.aop.impl"
			+ ".*.*(..)) && args(food , time , ..)", returning = "retVal")
	public void access(Date time, String food, Object retVal) {
		System.out.println("目标方法中String参数为：" + food);
		System.out.println("目标方法中Date参数为：" + time);
		System.out.println("模拟记录日志....");
	}
}