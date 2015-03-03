package com.webwalker.spring.impl;

import java.util.List;

import com.webwalker.spring.Interface.Axe;
import com.webwalker.spring.Interface.PersonExpression;

public class Author implements PersonExpression {
	private Integer id;
	private String name;
	private List<String> books;
	private Axe axe;

	public void setAxe(Axe axe) {
		this.axe = axe;
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

	// books属性的setter和getter方法
	public void setBooks(List<String> books) {
		this.books = books;
	}

	public List<String> getBooks() {
		return this.books;
	}

	public void useAxe() {
		System.out.println("我是" + name + "，正在砍柴\n" + axe.chop());
	}
}