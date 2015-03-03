package com.webwalker.spring.common;

import org.springframework.beans.factory.config.BeanPostProcessor;

import com.webwalker.spring.impl.Chinese;

public class MyBeanPostProcessor implements BeanPostProcessor {
	/**
	 * 对容器中的Bean实例进行后处理
	 * 
	 * @param bean
	 *            需要进行后处理的原Bean实例
	 * @param beanName
	 *            需要进行后处理的Bean实例的名字
	 * @return 返回后处理完成后的Bean
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		System.out.println("Bean后处理器在初始化之前对" + beanName + "进行增强处理...");
		// 返回的处理后的Bean实例，
		// 该Bean实例就是容器中到时实际使用的Bean实例
		// 该Bean实例甚至可与原Bean截然不同
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) {
		System.out.println("Bean后处理器在初始化之后对" + beanName + "进行增强处理...");
		// 如果该Bean是Chinese类的实例
		if (bean instanceof Chinese) {
			// 修改其name属性值
			Chinese c = (Chinese) bean;
			c.setName("后处理器起作用了——【Struts 2权威指南】");
		}
		return bean;
	}
}
