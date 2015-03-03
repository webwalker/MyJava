package com.webwalker.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.webwalker.spring.Interface.Person;

/**
 * 零配置测试
 * 
 * @author Administrator
 * 
 */
public class SprintZeroConfigTest {
	static AbstractApplicationContext ctx = null;
	static String beansProcessorPath = "/WebContent/WEB-INF/beanZeroConfig.xml";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ctx = new FileSystemXmlApplicationContext(
				new String[] { beansProcessorPath });

		compontent();
	}

	static void compontent() {
		// 获取Spring容器中的所有Bean实例的名
		System.out.println("--------------"
				+ java.util.Arrays.toString(ctx.getBeanDefinitionNames()));

		// @Scope指定Bean作用域，注册关闭钩子
		ctx.registerShutdownHook();
		Person person = ctx.getBean("chinese", Person.class);
		person.useAxe();

		// @Resource配置依赖
		person = ctx.getBean("chinese", Person.class);
		person.useAxe();

		// @自动装配、精确装配
		person = ctx.getBean("chinese", Person.class);
		person.useAxe();
	}
}
