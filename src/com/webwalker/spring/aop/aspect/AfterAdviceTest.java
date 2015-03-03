package com.webwalker.spring.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

//定义一个切面
@Aspect
public class AfterAdviceTest {
	// 匹配org.crazyit.app.service包下所有类的、
	// 所有方法的执行作为切入点
	@After("execution(* com.webwalker.spring.aop.impl.*.*(..))")
	public void release() {
		System.out.println("模拟方法结束后的释放资源...");
	}
}
