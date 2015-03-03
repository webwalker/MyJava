package com.webwalker.spring.aop.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

//定义一个切面
@Aspect
public class AfterThrowingAdviceTest {
	// 匹配com.webwalker.spring.aop.impl包下所有类的、
	// 所有方法的执行作为切入点
	@AfterThrowing(throwing = "ex", pointcut = "execution(* com.webwalker.spring.aop.impl.*.*(..))")
	public void doRecoveryActions(Throwable ex) {
		System.out.println("目标方法中抛出的异常:" + ex);
		System.out.println("模拟抛出异常后的增强处理...");
	}
}
