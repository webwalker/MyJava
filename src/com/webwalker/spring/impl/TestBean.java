package com.webwalker.spring.impl;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class TestBean implements ResourceLoaderAware {
	ResourceLoader rd;

	private Resource res;

	// 依赖注入Resource资源的setter方法
	public void setResource(Resource res) {
		this.res = res;
	}

	// 实现ResourceLoaderAware接口必须实现的方法
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.rd = resourceLoader;
	}

	// 返回ResourceLoader对象的引用
	public ResourceLoader getResourceLoader() {
		return rd;
	}
}