package com.webwalker.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitecture {
	@Pointcut("execution(* com.webwalker.spring.aop.impl" + ".impl.Chin*.say*(..))")
	public void myPointcut() {
	}
}
