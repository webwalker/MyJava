package com.webwalker.spring.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

import com.webwalker.spring.Interface.Axe;
import com.webwalker.spring.Interface.Person;
import com.webwalker.spring.Interface.PersonHello;

public class Chinese implements Person, PersonHello, InitializingBean,
		BeanNameAware {
	private Axe axe;
	private int age;
	private String name;
	private List schools;
	private Map scores;
	private Set axes;

	// 默认的构造器
	public Chinese() {
		System.out.println("Spring实例化主调bean：Chinese实例...");
	}

	// 构造注入所需的带参数的构造器
	public Chinese(Axe axe) {
		this.axe = axe;
	}

	// 设值
	public void setAxe(Axe axe) {
		System.out.println("Spring执行依赖关系注入...");
		this.axe = axe;
	}

	// 设值注入age属性所需的setter方法
	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	// 设值注入所需的setter方法
	public void setName(String name) {
		this.name = name;
	}

	// schools属性依赖注入必须的setter方法
	public void setSchools(List schools) {
		this.schools = schools;
	}

	// scores属性依赖注入必须的setter方法
	public void setScores(Map scores) {
		this.scores = scores;
	}

	// axes属性依赖注入必须的setter方法
	public void setAxes(Set axes) {
		this.axes = axes;
	}

	// 实现Person接口的useAxe方法
	public void useAxe() {
		// 调用axe的chop()方法，
		// 表明Person对象依赖于axe对象
		System.out.println(name + axe.chop());
		System.out.println("age属性值：" + age);
		System.out.println(schools);
		System.out.println(scores);
		System.out.println(axes);
	}

	// 实现Person接口必须实现如下两个方法
	public String sayHello(String name) {
		return name + "，您好";
	}

	public String sayGoodBye(String name) {
		return name + "，下次再见";
	}

	// 保存部署该Bean时指定的id属性
	private String beanName;

	public void setBeanName(String name) {
		this.beanName = name;
	}

	public void getId() {
		System.out.println("Chinese实现类" + ", 部署该Bean时指定的id为" + beanName);
	}

	// 下面是两个生命周期方法
	public void init() {
		System.out.println("正在执行初始化方法   init...");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("正在执行初始化方法  afterPropertiesSet...");
	}
}