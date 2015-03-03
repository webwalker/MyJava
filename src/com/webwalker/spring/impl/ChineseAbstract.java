package com.webwalker.spring.impl;

import org.springframework.beans.factory.BeanNameAware;

import com.webwalker.spring.Interface.Axe;
import com.webwalker.spring.Interface.Person;
import com.webwalker.spring.Interface.PersonHello;

public abstract class ChineseAbstract implements Person {

	public ChineseAbstract() {
		System.out.println("Spring实例化主调bean：ChineseAbstract实例...");
	}

	// 定义一个抽象方法，该方法将由Spring负责实现
	public abstract Axe getAxe();
	
	public void useAxe() {
		System.out.println("正在使用 " + getAxe() + "砍柴！");
		System.out.println(getAxe().chop());
	}
}