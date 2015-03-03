package com.webwalker.spring.annotations;

import org.springframework.stereotype.Component;

import com.webwalker.spring.Interface.Axe;


@Component
public class MyTest {
	private Axe axe;

	// 设值注入所需的setter方法
	public void setAxe(Axe axe) {
		this.axe = axe;
	}

	// 实现Person接口的useAxe方法
	public void useAxe() {
		// 调用axe的chop()方法，
		// 表明Person对象依赖于axe对象
		System.out.println(axe.chop());
	}
}