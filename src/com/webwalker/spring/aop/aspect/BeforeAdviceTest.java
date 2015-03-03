package com.webwalker.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeAdviceTest {
	// 匹配com.webwalker.spring.aop.impl包下所有类的、
	// 所有方法的执行作为切入点
	@Before("execution(* com.webwalker.spring.aop.impl.*.*(..))")
	public void authority() {
		System.out.println("模拟执行权限检查");
	}
}