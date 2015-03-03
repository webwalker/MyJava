package com.webwalker.spring.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.webwalker.spring.Interface.Axe;
import com.webwalker.spring.Interface.Person;

/**
 * 配置的的方式实现Bean的管理
 * 
 * @author Administrator
 * 
 */
@Configuration
// @Import
// @ImportResource("classpath:/beans.xml")
public class AppConfig {
	// 定义需要依赖注入的属性值
	@Value("孙悟空")
	String personName;

	// 配置一个Bean：chinese
	// @Scope
	// @Lazy
	// @DependsOn
	@Bean(name = "chinese")
	public Person person() {
		Chinese p = new Chinese();
		p.setAxe(stoneAxe());
		p.setName(personName);
		return p;
	}

	// 配置Bean：stoneAxe
	@Bean(name = "stoneAxe")
	public Axe stoneAxe() {
		return new StoneAxe();
	}

	// 配置Bean：steelAxe
	@Bean(name = "steelAxe")
	public Axe steelAxe() {
		return new SteelAxe();
	}
}
