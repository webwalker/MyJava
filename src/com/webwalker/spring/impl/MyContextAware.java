package com.webwalker.spring.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//定义Bean类，实现ApplicationContextAware接口
//该类将拥有访问容器的能力
//
public class MyContextAware implements ApplicationContextAware {
	// 将BeanFactory容器以成员变量保存
	private ApplicationContext ctx;

	/**
	 * 实现ApplicationContextAware接口必须实现的方法
	 * 
	 * @param ctx
	 *            创建bean实例的ApplicationContext
	 */
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.ctx = ctx;
	}

	// 获得ApplicationContext的测试方法
	public ApplicationContext getContext() {
		return ctx;
	}
}