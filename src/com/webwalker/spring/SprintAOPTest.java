package com.webwalker.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.webwalker.spring.Interface.Person;

public class SprintAOPTest {
	static ApplicationContext ctx = null;
	static String beansProcessorPath = "/WebContent/WEB-INF/beansProcessor.xml";

	// 用于处理分布于各模块中的交叉关注点问题
	public static void main(String[] args) {
		ctx = new FileSystemXmlApplicationContext(
				new String[] { beansProcessorPath });

		// beanProcessor();
		try {
			springContextProcessor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void beanProcessor() {

		// 手动注册BeanPostProcessor，获取Bean后处理器实例
		/*
		 * DefaultListableBeanFactory factory = new DefaultListableBeanFactory(
		 * (BeanFactory) ctx); MyBeanPostProcessor prr =
		 * factory.getBean("beanPostProcessor", MyBeanPostProcessor.class);
		 * factory.addBeanPostProcessor(prr); // 注册BeanPostProcessor实例
		 * System.out.println("程序已经实例化BeanFactory..."); Person p =
		 * factory.getBean("chinese", Person.class);
		 * System.out.println("程序中已经完成了chinese bean的实例化..."); p.useAxe();
		 */

		// 以ApplicationContex作为Spring容器
		// 它会自动搜索并注册容器后处理器、Bean后处理器
		// 自动注册BeanPostProcessor，效果完全一样
		Person p = (Person) ctx.getBean("chinese");
		p.useAxe();
	}

	// 容器后处理器，负责处理容器本身
	static void springContextProcessor() throws Exception {
		Person p = (Person) ctx.getBean("chinese");
		p.useAxe();

		// 属性占位符配置器
		// DataSource ds = (DataSource) ctx.getBean("dataSource");
		// Connection conn = ds.getConnection();
		// PreparedStatement pstmt = conn
		// .prepareStatement("insert into news_inf value(null , ? , ?)");
		// pstmt.setString(1, "疯狂Java讲义");
		// pstmt.setString(2, "Struts 2权威指南");
		// pstmt.executeUpdate();
		// pstmt.close();
		// conn.close();
		
		//重写占位符配置器
		
	}
}
