package com.webwalker.spring.impl;

import com.webwalker.spring.Interface.Axe;

public class StoneAxe implements Axe {
	public StoneAxe() {
		System.out.println("Spring实例化依赖bean：StoneAxe实例...");
	}

	public String chop() {
		return "石斧砍柴好慢";
	}
}