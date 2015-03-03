package com.webwalker.spring.aop.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

//定义一个切面
@Aspect
public class AfterReturningAdviceTest {
	// 匹配com.webwalker.spring.aop.impl包下所有类的、
	// 所有方法的执行作为切入点
	@AfterReturning(returning = "rvt", pointcut = "execution(* com.webwalker.spring.aop.impl.*.*(..))")
	public void log(Object rvt) {
		System.out.println("获取目标方法返回值:" + rvt);
		System.out.println("模拟记录日志功能...");
	}
}
