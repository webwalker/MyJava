package com.webwalker.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.webwalker.spring.Interface.PersonExpression;
import com.webwalker.spring.impl.PersonExpImpl;

//表达式语言，可在运行时查询操作对象图，比JSP 2的EL更強大，支持方法调用和基本字符串模板函数
//可以脱离sp容器来使用，也可在Annotation或XML配置中使用SPEL,这样可充分简化SP的Bean配置
public class SpringExpressionTest {
	static ApplicationContext ctx = null;
	static String expressionBeanPath = "/WebContent/WEB-INF/beansExpression.xml";

	public static void main(String[] args) {

		ctx = new FileSystemXmlApplicationContext(
				new String[] { expressionBeanPath });

		Basic();
		// simplify();
	}

	static void Basic() {
		// 创建一个ExpressionParser对象，用于解析表达式
		ExpressionParser parser = new SpelExpressionParser();
		// 最简单的字符串表达式
		Expression exp = parser.parseExpression("'HelloWorld'");
		System.out.println("'HelloWorld'的结果： " + exp.getValue() + ","
				+ exp.getValue(String.class));
		double num = (Double) parser.parseExpression("0.23").getValue(
				Double.class);
		System.out.println("'Double'的结果： " + num);
		// 调用方法的表达式
		exp = parser.parseExpression("'HelloWorld'.concat('!')");
		System.out.println("'HelloWorld'.concat('!')的结果： " + exp.getValue());
		// 调用对象的getter方法
		exp = parser.parseExpression("'HelloWorld'.bytes");
		System.out.println("'HelloWorld'.bytes的结果： " + exp.getValue());
		// 访问对象的属性(d相当于HelloWorld.getBytes().length)
		exp = parser.parseExpression("'HelloWorld'.bytes.length");
		System.out.println("'HelloWorld'.bytes.length的结果：" + exp.getValue());
		// 使用构造器来创建对象
		exp = parser.parseExpression("new String('helloworld')"
				+ ".toUpperCase()");
		System.out.println("new String('helloworld')" + ".toUpperCase()的结果是： "
				+ exp.getValue(String.class));

		PersonExpImpl person = new PersonExpImpl(1, "孙悟空", new Date());
		exp = parser.parseExpression("name");
		// 以指定对象作为root来计算表达式的值
		// 相当于调用person.name表达式的值
		System.out.println("以persn为root，name表达式的值是： "
				+ exp.getValue(person, String.class));
		exp = parser.parseExpression("name=='孙悟空'");
		// 创建一个ExpressionParser对象，用于解析表达式
		StandardEvaluationContext ectx = new StandardEvaluationContext();
		ectx.setRootObject(person);
		// 以指定Context来计算表达式的值
		System.out.println(exp.getValue(ectx, Boolean.class));

		List<Boolean> list = new ArrayList<Boolean>();
		list.add(true);
		// 上下文对象，可包含多个对象，只能有一个ROOT
		// 将list设置成EvaluationContext的一个变量
		ectx.setVariable("list", list);
		// 修饰list变量的第一个元素的值
		// 特殊变量：#this正在计算的对象、#root根对象
		parser.parseExpression("#list[0]").setValue(ectx, "false");
		// list集合的第一个元素被改变
		System.out.println("list集合的第一个元素为： " + list.get(0));

		// 创建一个数组
		exp = parser
				.parseExpression("new String[]{'java' , 'Struts' , 'Spring'}");
		System.out.println(exp.getValue());
		// 创建二维数组
		exp = parser.parseExpression("new int[2][4]");
		System.out.println(exp.getValue());

		// 创建一个List集合
		exp = parser.parseExpression("{'java' , 'Struts' , 'Spring'}");
		System.out.println(exp.getValue());
		// 创建“二维”List集合
		exp = parser.parseExpression("{{'疯狂Java讲义' , ''}, {'左传' , '战国策'}}");
		System.out.println(exp.getValue());

		// List、Map
		List<String> sList = new ArrayList<String>();
		sList.add("Java");
		sList.add("Spring");
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("Java", 80.0);
		map.put("Spring", 89.0);
		// 设置两个变量
		ectx.setVariable("mylist", sList);
		ectx.setVariable("mymap", map);
		// 访问List集合的第二个元素
		System.out.println(parser.parseExpression("#mylist[1]").getValue(ectx));
		// 访问Map集合的指定元素
		System.out.println(parser.parseExpression("#mymap['Java']").getValue(
				ectx));

		// 调用方法，用String对象的substring方法
		System.out.println(parser.parseExpression(
				"'HelloWorld'.substring(2, 5)").getValue());
		sList.clear();
		sList.add("java");
		sList.add("struts");
		sList.add("spring");
		sList.add("hibernate");
		// 设置一个变量
		ectx.setVariable("mylist", sList);
		System.out.println(parser.parseExpression("#mylist.subList(1, 3)")
				.getValue(ectx));

		// 算术、比较、逻辑、赋值、三目运算
		// 创建一个ExpressionParser对象，用于解析表达式
		sList.add("java");
		sList.add("struts");
		sList.add("spring");
		sList.add("hibernate");
		// 设置一个变量
		ectx.setVariable("mylist", sList);
		// 对集合的第一个元素进行赋值
		parser.parseExpression("#mylist[0]='疯狂Java讲义'").getValue(ectx);
		// 下面将输出 疯狂Java讲义
		System.out.println(sList.get(0));
		// 使用三目运算符
		System.out.println(parser.parseExpression(
				"#mylist.size()>3?" + "'myList长度大于3':'myList长度不大于3'").getValue(
				ectx));
		// 三目判断为空，简写方法
		String name = null;
		ectx.setVariable("operator", name);
		System.out
				.println(parser.parseExpression("name?:'不为空'").getValue(ectx));

		// 类型运算符
		// 调用Math的静态方法
		System.out.println(parser.parseExpression("T(java.lang.Math).random()")
				.getValue());
		// 调用Math的静态方法
		System.out.println(parser.parseExpression(
				"T(System).getProperty('os.name')").getValue());

		// 调用构造器，创建对象
		System.out.println(parser.parseExpression(
				"new String('HelloWorld').substring(2, 4)").getValue());
		// 创建对象
		System.out.println(parser.parseExpression(
				"new javax.swing.JFrame('测试')" + ".setVisible('true')")
				.getValue());

		// 自定义函数，意义不大
		// ectx.registerFunction("0", Method.getMethod("test"));

		// 使用安全操作，将输出null(等同3目运算的?判断)
		System.out.println("----"
				+ parser.parseExpression("#foo?.bar").getValue());
		// 不使用安全操作，将引发NullPointerException
		// System.out.println(parser.parseExpression("#foo.bar").getValue());

		// 集合选择
		sList.clear();
		sList.add("疯狂Java讲义");
		sList.add("疯狂Ajax讲义");
		sList.add("疯狂XML讲义");
		sList.add("经典Java EE企业应用实战");
		ectx.setVariable("mylist", sList);
		// 判断集合元素项length()方法的长度大于7，“疯狂XML讲义”被剔除
		exp = parser.parseExpression("#mylist.?[length()>7]");
		System.out.println(exp.getValue(ectx));
		map.put("Java", 89.0);
		map.put("Spring", 82.0);
		map.put("英语", 75.0);
		ectx.setVariable("mymap", map);
		// 判断Map集合的value值大于80，只保留前面2个Entry
		exp = parser.parseExpression("#mymap.?[value>80]");
		System.out.println(exp.getValue(ectx));

		// 集合投影
		sList.add("疯狂Java讲义");
		sList.add("疯狂Ajax讲义");
		sList.add("疯狂XML讲义");
		sList.add("经典Java EE企业应用实战");
		ectx.setVariable("mylist", sList);
		// 得到的新集合的元素是原集合的每个元素length()方法返回值
		exp = parser.parseExpression("#mylist.![length()]");
		System.out.println(exp.getValue(ectx));
		List<PersonExpImpl> list2 = new ArrayList<PersonExpImpl>();
		list2.add(new PersonExpImpl(1, "孙悟空", 162));
		list2.add(new PersonExpImpl(1, "猪八戒", 182));
		list2.add(new PersonExpImpl(1, "牛魔王", 195));
		ectx.setVariable("mylist2", list2);
		// 得到的新集合的元素是原集合的每个元素name属性值
		exp = parser.parseExpression("#mylist2.![name]");
		System.out.println(exp.getValue(ectx));

		// 表达式模板
		PersonExpImpl p1 = new PersonExpImpl(1, "孙悟空", 162);
		PersonExpImpl p2 = new PersonExpImpl(1, "猪八戒", 182);
		exp = parser.parseExpression("我的名字是#{name},身高是#{height}",
				new TemplateParserContext());
		// 将使用p1对象name、height填充上面表达式模板中的#{}
		System.out.println(exp.getValue(p1));
		// 将使用p2对象name、height填充上面表达式模板中的#{}
		System.out.println(exp.getValue(p2));
	}

	static void test() {

	}

	static void simplify() {
		PersonExpression author = ctx.getBean("author", PersonExpression.class);
		System.out.println(author.getBooks());
		author.useAxe();
	}
}
