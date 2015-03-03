package com.webwalker.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.webwalker.spring.aop.Interface.NewsDao;

public class SpringTransaction {
	static ApplicationContext ctx = null;
	static String defaultBeanPath = "/WebContent/WEB-INF/beansTransaction.xml";

	public static void main(String[] args) {

		ctx = new FileSystemXmlApplicationContext(
				new String[] { defaultBeanPath });

		// basic();
		txNameSpace();
		annotation();
	}

	static void basic() {
		// 获取事务代理Bean
		NewsDao dao = (NewsDao) ctx.getBean("newsDaoTrans", NewsDao.class);
		// 执行插入操作
		dao.insert("疯狂Java", "轻量级Java EE企业应用实战");
	}

	// 优势：sp容器只有一个newsDaoBean，已经具有事务性，不像basic容易遗忘事务
	static void txNameSpace() {
		ctx = new FileSystemXmlApplicationContext(
				new String[] { "/WebContent/WEB-INF/beansTransactionTx.xml" });
		// 获取事务代理Bean
		NewsDao dao = (NewsDao) ctx.getBean("newsDaoTrans", NewsDao.class);
		// 执行插入操作
		dao.insert("疯狂Java", "轻量级Java EE企业应用实战");
	}

	static void annotation() {
		ctx = new FileSystemXmlApplicationContext(
				new String[] { "/WebContent/WEB-INF/beansTransactionAnnotation.xml" });
		// 获取事务代理Bean
		NewsDao dao = (NewsDao) ctx.getBean("newsDaoTrans", NewsDao.class);
		// 执行插入操作
		dao.insert("疯狂Java", "轻量级Java EE企业应用实战");
	}
}
