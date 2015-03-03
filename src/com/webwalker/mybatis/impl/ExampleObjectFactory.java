package com.webwalker.mybatis.impl;

import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class ExampleObjectFactory extends DefaultObjectFactory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Object create(Class type) {
		return super.create(type);
	}

	public void setProperties(Properties properties) {
		super.setProperties(properties);
	}
}
