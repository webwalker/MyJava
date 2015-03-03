package com.webwalker.spring.impl;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.webwalker.spring.Interface.Axe;
import com.webwalker.spring.Interface.Person;

public class ChineseCollection implements Person {
	// 下面是系列集合属性
	private List<String> schools;
	private Map scores;
	private Map<String, Axe> phaseAxes;
	private Properties health;
	private Set axes;
	private String[] books;

	public ChineseCollection() {
		System.out.println("Spring实例化主调bean：Chinese实例...");
	}

	// schools属性依赖注入必须的setter方法
	public void setSchools(List schools) {
		this.schools = schools;
	}

	// scores属性依赖注入必须的setter方法
	public void setScores(Map scores) {
		this.scores = scores;
	}

	// phaseAxes属性依赖注入必须的setter方法
	public void setPhaseAxes(Map<String, Axe> phaseAxes) {
		this.phaseAxes = phaseAxes;
	}

	// health属性依赖注入必须的setter方法
	public void setHealth(Properties health) {
		this.health = health;
	}

	// axes属性依赖注入必须的setter方法
	public void setAxes(Set axes) {
		this.axes = axes;
	}

	// books属性依赖注入必须的setter方法
	public void setBooks(String[] books) {
		this.books = books;
	}

	// 访问上面全部的集合属性
	@Override
	public void useAxe() {
		System.out.println(schools);
		System.out.println(scores);
		System.out.println(phaseAxes);
		System.out.println(health);
		System.out.println(axes);
		System.out.println(java.util.Arrays.toString(books));
	}
}