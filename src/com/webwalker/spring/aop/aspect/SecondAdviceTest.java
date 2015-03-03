package com.webwalker.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

//定义一个切面
@Aspect
@Order(1)
public class SecondAdviceTest {
	// 定义Before增强处理执行
	@Before("execution(* com.webwalker.spring.aop.impl.*.*(..))")
	public void zuthority(JoinPoint jp) {
		System.out.println("⑴号Before增强：模拟执行权限检查");
	}
}
