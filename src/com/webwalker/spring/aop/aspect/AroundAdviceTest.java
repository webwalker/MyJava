package com.webwalker.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

//定义一个切面
@Aspect
public class AroundAdviceTest {
	// 匹配com.webwalker.spring.aop.impl包下所有类的、
	// 所有方法的执行作为切入点
	@Around("execution(* com.webwalker.spring.aop.impl.*.*(..))")
	public Object processTx(ProceedingJoinPoint jp) throws java.lang.Throwable {
		System.out.println("执行目标方法之前，模拟开始事务...");
		// 执行目标方法，并保存目标方法执行后的返回值
		// 如果目标方法无参数时会报错
		Object rvt = jp.proceed(new String[] { "被改变的参数" });
		System.out.println("执行目标方法之后，模拟结束事务...");
		return rvt + " 新增的内容";
	}
}
