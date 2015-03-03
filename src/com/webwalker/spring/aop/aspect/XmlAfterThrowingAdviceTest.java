package com.webwalker.spring.aop.aspect;

public class XmlAfterThrowingAdviceTest {
	// 定义一个普通方法作为增强处理方法
	public void doRecoveryActions(Throwable ex) {
		// ex代表目标方法中抛出的异常
		System.out.println("目标方法中抛出的异常:" + ex);
		System.out.println("模拟抛出异常后的资源回收...");
	}
}
