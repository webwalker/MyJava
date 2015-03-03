package com.webwalker.spring.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.webwalker.spring.Interface.Axe;
import com.webwalker.spring.Interface.Person;

public class ChineseLifecycle implements Person, InitializingBean,
		DisposableBean {
	private Axe axe;

	public ChineseLifecycle() {
		System.out.println("Spring实例化主调bean：Chinese实例...");
	}

	// 依赖注入必须的setter方法
	public void setAxe(Axe axe) {
		System.out.println("Spring执行依赖关系注入...");
		this.axe = axe;
	}

	public void useAxe() {
		System.out.println(axe.chop());
	}

	// 测试用初始化方法
	public void init() {
		System.out.println("正在执行初始化方法   init...");
	}

	// 实现InitializingBean接口必须实现的方法
	public void afterPropertiesSet() throws Exception {
		System.out.println("正在执行初始化方法  afterPropertiesSet...");
	}

	public void close() {
		System.out.println("正在执行销毁之前的方法   close...");
	}

	public void destroy() throws Exception {
		System.out.println("正在执行销毁之前的方法  destroy...");
	}
}