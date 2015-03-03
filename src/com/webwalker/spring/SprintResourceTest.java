package com.webwalker.spring;

import java.net.MalformedURLException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;

import com.webwalker.spring.Interface.Person;
import com.webwalker.spring.impl.TestBean;

/**
 * 零配置测试
 * 
 * @author Administrator
 * 
 */
public class SprintResourceTest {
	static AbstractApplicationContext ctx = null;
	static String beansProcessorPath = "/WebContent/WEB-INF/beansOther.xml";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ctx = new FileSystemXmlApplicationContext(
				new String[] { beansProcessorPath });

		Resource();
	}

	static void Resource() {

		// 创建一个Resource对象，指定从文件系统里读取资源
		UrlResource ur;
		try {
			ur = new UrlResource("file:book.xml");
			// 获取该资源的简单信息
			System.out.println(ur.getFilename());
			System.out.println(ur.getDescription());
			// System.out.println(ur.getFile());

			// 默认从文件系统的当前路径加载book.xml资源
			FileSystemResource fr = new FileSystemResource("book.xml");
			// 获取该资源的简单信息
			System.out.println(fr.getFilename());
			System.out.println(fr.getDescription());

			// ServletContextResource src = new ServletContextResource(
			// application, "WEB-INF/book.xml");
			// // 获取该资源的简单信息
			// System.out.println(src.getFilename());
			// System.out.println(src.getDescription());

			// 从数据库读出blob数据时可用
			String file = "<?xml version='1.0' encoding='GBK'?>"
					+ "<计算机书籍列表><书><书名>疯狂Java讲义"
					+ "</书名><作者>李刚</作者></书><书><书名>"
					+ "轻量级Java EE企业应用实战</书名><作者>李刚" + "</作者></书></计算机书籍列表>";
			byte[] fileBytes = file.getBytes();
			// 以字节数组作为资源来创建Resource对象
			ByteArrayResource bar = new ByteArrayResource(fileBytes);
			// 获取该资源的简单信息
			System.out.println(bar.getDescription());

			// 可强制使用：classpath:bean.xml、file:bean.xml、http://...
			Resource res = ctx.getResource("book.xml");
			// 获取该资源的简单信息
			System.out.println(res.getFilename());
			System.out.println(res.getDescription());

			// 注入资源
			// 获取容器中名为test的Bean实例
			TestBean tb = ctx.getBean("test", TestBean.class);
			// 通过tb实例来获取ResourceLoader对象
			ResourceLoader rl = tb.getResourceLoader();
			// 判断程序获得ResourceLoader和容器是否相同
			System.out.println(rl == ctx);

			// ApplicationContext中使用资源
			// ApplicationContext ctx = new
			// FileSystemXmlApplicationContext("bean.xml");
			// ApplicationContext ctx = new
			// FileSystemXmlApplicationContext("classpath:bean.xml");
			// ApplicationContext ctx = new
			// FileSystemXmlApplicationContext("classpath*:bean.xml");
			// ApplicationContext ctx = new
			// FileSystemXmlApplicationContext("classpath*:bean*.xml");
			// ApplicationContext ctx = new
			// FileSystemXmlApplicationContext("classpath:bean2.xml");
			// ApplicationContext ctx = new
			// FileSystemXmlApplicationContext("bean.xml");
			// FileSystemXmlApplicationContext("/bean.xml");
			// FileSystemXmlApplicationContext("file:bean.xml");
			// FileSystemXmlApplicationContext("file:/bean.xml");
			System.out.println("----" + ctx);
			Resource r = ctx.getResource("book.xml");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}
}
