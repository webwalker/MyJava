package com.webwalker.spring;

import java.util.Date;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.webwalker.entity.PersonService;
import com.webwalker.spring.Interface.Being;
import com.webwalker.spring.Interface.Person;
import com.webwalker.spring.Interface.PersonHello;
import com.webwalker.spring.impl.AppConfig;
import com.webwalker.spring.impl.Chinese;
import com.webwalker.spring.impl.MyContextAware;
import com.webwalker.spring.impl.Son;
import com.webwalker.spring.listener.EmailEvent;

public class SpringTest {
	static ApplicationContext ctx = null;
	static String defaultBeanPath = "/WebContent/WEB-INF/beans.xml";
	static String injectBeanPath = "/WebContent/WEB-INF/beansInject.xml";
	static String schemaBeanPath = "/WebContent/WEB-INF/beansSchema.xml";

	public static void main(String[] args) {

		// 从src相对路径查找
		// ApplicationContext ctx = new ClassPathXmlApplicationContext(
		// "/WEB-INF/beans.xml");
		// 创建Spring容器
		ctx = new FileSystemXmlApplicationContext(
				new String[] { defaultBeanPath });

		// PersonService();
		// Axe();
		// 加载资源文件_国际化支持();
		// EventListener();
		// contextAware();
		// scope();
		// autowire();
		// injectCollection();
		// appconfigBean();
		// staticFactoryBean();
		// factoryBean();
		// abstractBean();
		// specialFactoryBean();
		// getBeanId();
		// chineseLifecycle();
		// sysnBean();
		// injectProperties();
		// injectField();
		// injectMethod();
		schemaNameSpace();
	}

	static void PersonService() {
		// 输出Spring容器
		System.out.println(ctx);
		PersonService p = ctx.getBean("personService", PersonService.class);
		p.info();
	}

	static void Axe() {
		// 获取chinese 实例
		Person p = ctx.getBean("chinese", Person.class);
		// 调用useAxe()方法
		p.useAxe();
	}

	static void 加载资源文件_国际化支持() {
		// 创建参数数组
		String[] a = { "读者" };
		// 使用getMessage方法获取本地化消息。Locale的getDefault方法
		// 返回计算机环境的默认Locale
		String hello = ctx.getMessage("hello", a, Locale.getDefault());
		Object[] b = { new Date() };
		String now = ctx.getMessage("now", b, Locale.getDefault());
		// 打印出两条本地化消息
		System.out.println(hello);
		System.out.println(now);
	}

	static void EventListener() {
		// 创建一个ApplicationEvent对象
		EmailEvent ele = new EmailEvent("hello", "spring_test@163.com",
				"this is a test");
		// 主动触发容器事件
		ctx.publishEvent(ele);
	}

	// bean获取创建它的sp容器
	static void contextAware() {
		MyContextAware p = ctx.getBean("contextAware", MyContextAware.class);
		// 打印出Chinese实例获得的ApplicationContext
		System.out.println(p.getContext());
		// 比较两种方法获得的BeanFactory
		System.out.println(ctx == p.getContext());
	}

	static void scope() {
		// 判断两次请求singleton作用域的Bean实例是否相等
		System.out.println(ctx.getBean("personService") == ctx
				.getBean("personService"));
		// 判断两次请求prototype作用域的Bean实例是否相等
		System.out.println(ctx.getBean("p1") == ctx.getBean("p1"));
	}

	static void autowire() {
		Person p = ctx.getBean("chineseWireByName", Person.class);
		p.useAxe();

		p = ctx.getBean("chineseWireByType", Person.class);
		p.useAxe();
	}

	static void injectCollection() {
		// 获取容器中Bean，并调用方法。
		Person p = ctx.getBean("chineseCollection", Person.class);
		p.useAxe();
	}

	static void appconfigBean() {
		// 创建Spring容器
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		// 获取chinese 实例
		Person p = ctx.getBean("chinese", Person.class);
		// 调用useAxe()方法
		p.useAxe();
	}

	static void staticFactoryBean() {
		Being b1 = ctx.getBean("dog", Being.class);
		b1.testBeing();
		Being b2 = ctx.getBean("cat", Being.class);
		b2.testBeing();
	}

	static void factoryBean() {
		PersonHello p1 = ctx.getBean("chineseBean", PersonHello.class);
		System.out.println(p1.sayHello("Mary"));
		System.out.println(p1.sayGoodBye("Mary"));
		PersonHello p2 = ctx.getBean("americanBean", PersonHello.class);
		System.out.println(p2.sayHello("Jack"));
		System.out.println(p2.sayGoodBye("Jack"));
	}

	static void abstractBean() {
		Person p1 = ctx.getBean("chineseChild", Person.class);
		Person p2 = ctx.getBean("chineseChild", Person.class);
		p1.useAxe();
		System.out.println(p1 == p2);
	}

	static void specialFactoryBean() {
		// 直接请求FactoryBean时，系统将返回该FactoryBean的产品
		PersonHello p1 = ctx.getBean("chineseSpecialFactoryBean",
				PersonHello.class);
		System.out.println(p1.sayHello("Mary"));
		System.out.println(p1.sayGoodBye("Mary"));
		// 再次获取该FactoryBean的产品
		PersonHello p2 = ctx.getBean("chineseSpecialFactoryBean",
				PersonHello.class);
		System.out.println(p1 == p2);
		// 如需获取FactoryBean本身，则应该在Bean id前增加&
		System.out.println(ctx.getBean("&chineseSpecialFactoryBean"));
	}

	static void getBeanId() {
		Chinese chin = ctx.getBean("chinese", Chinese.class);
		chin.getId();
	}

	// 生命周期, 初始化污染代码，侵入式设计，不推荐使用
	// 引入多个XML文件
	static void chineseLifecycle() {
		// 以CLASSPATH路径下的配置文件创建ApplicationContext
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext(
				new String[] { defaultBeanPath });

		Person p = ctx.getBean("chineseLifecycle", Person.class);
		p.useAxe();
		// 为Spring容器注册关闭钩子
		ctx.registerShutdownHook();
	}

	// 协调同步Bean 利用方法注入
	// 当作用域不同而相互依赖时，只有一次初始化机会……，依赖关系也是在初始化时设置，所以后续要同步
	static void sysnBean() {
		Person p = ctx.getBean("chineseSync", Person.class);
		// 两次通过p对象使用Axe对象
		p.useAxe();
		p.useAxe();

		/*
		 * SP每次都執行這個 public Axe getAxe() { return ctx.getBean("steelAxe"); }
		 */
	}

	// 注入其他Bean的属性值
	static void injectProperties() {
		ctx = new FileSystemXmlApplicationContext(
				new String[] { injectBeanPath });

		System.out.println("系统获取theAge的值：" + ctx.getBean("theAge"));
		System.out.println("系统获取theAge2的值：" + ctx.getBean("theAge2"));
		System.out.println("系统获取的son1：" + ctx.getBean("son1"));
		System.out.println("系统获取son2：" + ctx.getBean("son2"));
	}

	static void injectField() {
		ctx = new FileSystemXmlApplicationContext(
				new String[] { injectBeanPath });
		// 获取son Bean实例
		Son son = ctx.getBean("son", Son.class);
		// 输出son的age值
		System.out.println("系统获取son的age属性值：" + son.getAge());
		System.out.println("系统获取theAge1的值：" + ctx.getBean("theAgeField1"));
		System.out.println("系统获取theAge2的值：" + ctx.getBean("theAgeField2"));
	}

	// 注入其他Bean的方法返回值
	static void injectMethod() {
		ctx = new FileSystemXmlApplicationContext(
				new String[] { injectBeanPath });
		// 获取son1 Bean实例
		Son son1 = ctx.getBean("son1Method", Son.class);
		// 输出son1的age值
		System.out.println("系统获取son1的age属性值：" + son1.getAge());
		// 获取son2 Bean实例
		Son son2 = ctx.getBean("son2Method", Son.class);
		// 输出son2的age值
		System.out.println("系统获取son2的age属性值：" + son2.getAge());
		System.out.println("系统获取Java版本：" + ctx.getBean("javaVersion"));
	}

	// 采用p命名、util命名
	static void schemaNameSpace() {
		ctx = new FileSystemXmlApplicationContext(
				new String[] { schemaBeanPath });
		// 获取chinese 实例
		Person p = ctx.getBean("chinese", Person.class);
		// 调用useAxe()方法
		p.useAxe();
		System.out.println(ctx.getBean("test"));
		System.out.println(ctx.getBean("confTest"));
	}
}
