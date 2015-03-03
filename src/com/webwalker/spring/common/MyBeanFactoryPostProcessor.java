package com.webwalker.spring.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/*
 * 可对BeanFactory、ApplicationContext等执行后处理器，还可注册额外的属性编辑器
 * 对ApplicationContext一样使用BeanFactoryPostProcessor
 * 常用的：PropertyPlaceholderConfigurer、PropertyOverrideConfigurer、CustomAutowireConfigurer、CustomScopeConfigurer
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	/**
	 * 重写该方法，对Spring进行后处理。
	 * 
	 * @param beanFactory
	 *            Spring容器本身
	 */
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("程序对Spring所做的BeanFactory的初始化没有改变...");
		System.out.println("Spring容器是：" + beanFactory);
	}
}