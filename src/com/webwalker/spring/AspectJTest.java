package com.webwalker.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.webwalker.spring.aop.Interface.Person;

public class AspectJTest {
	static ApplicationContext ctx = null;
	static String defaultBeanPath = "/WebContent/WEB-INF/beansAspectJ.xml";
	static String aopPath = "/WebContent/WEB-INF/beansAOP.xml";

	public static void main(String[] args) {

		ctx = new FileSystemXmlApplicationContext(
				new String[] { defaultBeanPath });

		// 创建Spring容器
		// Person p = ctx.getBean("chinese", Person.class);
		// System.out.println(p.sayHello("张三"));
		// p.eat("西瓜");
		// p.eat("西瓜", new java.util.Date());
		// p.divide();

		SpringAop();
	}

	static void SpringAop() {
		ctx = new FileSystemXmlApplicationContext(new String[] { aopPath });
		
		Person p = ctx.getBean("chinese", Person.class);
		System.out.println(p.sayHello("张三"));
		p.eat("西瓜");
	}
}
