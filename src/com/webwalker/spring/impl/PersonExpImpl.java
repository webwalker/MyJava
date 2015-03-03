package com.webwalker.spring.impl;

import java.util.Date;

public class PersonExpImpl {
	private Integer id;
	private String name;
	private Date birth;
	private double height;

	// 无参数的构造器
	public PersonExpImpl() {
	}

	// 初始化全部属性的构造器
	public PersonExpImpl(Integer id, String name, Date birth) {
		this.id = id;
		this.name = name;
		this.birth = birth;
	}

	// 初始化全部属性的构造器
	public PersonExpImpl(Integer id, String name, double height) {
		this.id = id;
		this.name = name;
		this.height = height;
	}

	// id属性的setter和getter方法
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	// name属性的setter和getter方法
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	// birth属性的setter和getter方法
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Date getBirth() {
		return this.birth;
	}

	// height属性的setter和getter方法
	public void setHeight(double height) {
		this.height = height;
	}

	public double getHeight() {
		return this.height;
	}
}
