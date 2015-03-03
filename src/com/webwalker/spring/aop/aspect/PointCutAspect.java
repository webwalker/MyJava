package com.webwalker.spring.aop.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

//定义切入点
@Aspect
public class PointCutAspect {
	// 定义一个PointCut，其名为logPointcut
	// 该PointCut对应于指定Hello对象的sayHello方法
	// pointcut logPointcut():execution(void AspectJTest.sayHello());
	// 在logPointcut之后执行下面代码块
	// after():logPointcut()
	// {
	// System.out.println("记录日志...");
	// }

	// 更多的切入点指示符、组合符号，参考其他文档或J2EE企业应用实战
	// 直接使用SystemArchitecture切面类的myPointcut切入点
	// args(msg)保证该切入点只匹配只有一个字符串参数的方法
	@AfterReturning(pointcut = "SystemArchitecture.myPointcut()"
			+ "&&args(msg)", returning = "retVal")
	public void writeLog(String msg, Object retVal) {
		System.out.println(msg);
		System.out.println(retVal);
		System.out.println("定义pointcut....");
	}
}