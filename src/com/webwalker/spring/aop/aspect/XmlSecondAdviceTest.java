package com.webwalker.spring.aop.aspect;

public class XmlSecondAdviceTest {
	// 定义Before增强处理
	public void authority(String aa) {
		System.out.println("目标方法的参数为：" + aa);
		System.out.println("①号Before增强：模拟执行权限检查");
	}
}
