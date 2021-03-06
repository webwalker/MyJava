package com.webwalker.entity;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 677484458789332877L;
	private int id;
	private String name;
	private String email;
	private String address;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return this.id + "#" + this.name + "#" + this.email + "#"
				+ this.address;
	}
}
