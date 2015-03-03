package com.webwalker.spring.annotations;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.webwalker.spring.Interface.Axe;
import com.webwalker.spring.Interface.Person;

// @Scope("prototype") 指定作用域为prototype
// 普通的Bean，尽量考虑使用下面的声明来代替@Component, 因为未来版本可有更多语义
// @Controller // 控制器组件类
// @Service //业务组件
// @Repository //标注一个DAO组件类
//@DependsOn({ "steelAxe", "abc" }) 强制初始化其他Bean
//@Lazy(true)	指定该Bean是否取消预初始化
@Component
public class Chinese implements Person {
	// byType自动装配
	@Autowired
	@Qualifier("steelAxe")
	private Axe axe;
	private Set<Axe> axeset;

	// 可接受多个参数的普通方法
	// @Autowired
	// public Chinese(Axe axe, Dog dog) {
	//
	// }

	@Autowired
	private Axe[] axes;

	@Autowired
	public void setAxes(Set<Axe> axeset) {
		this.axeset = axeset;
	}

	@Autowired
	public void setAxess(@Qualifier("steelAxe") Axe axe) {

	}

	// 设值注入所需的setter方法，如省略name属性，则name默认为set后面的名称，首字母小写
	@Autowired
	@Resource(name = "stoneAxe")
	public void setAxe(Axe axe) {
		this.axe = axe;
	}

	// 实现Person接口的useAxe方法
	public void useAxe() {
		// 调用axe的chop()方法，
		// 表明Person对象依赖于axe对象
		System.out.println(axe.chop());
	}

	// 定制生命周期
	@PostConstruct
	public void init() {
		System.out.println("正在执行初始化方法   init...");
	}

	@PreDestroy
	public void close() {
		System.out.println("正在执行销毁之前的close方法 ...");
	}
}