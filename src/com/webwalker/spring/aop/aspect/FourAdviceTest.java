package com.webwalker.spring.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

//定义一个切面
@Aspect
// 指定优先级, 越小优先级越高
@Order(2)
public class FourAdviceTest {
	// 定义Around增强处理执行
	@Around("execution(* com.webwalker.spring.aop.impl.*.*(..))")
	public Object processTx(ProceedingJoinPoint jp) throws java.lang.Throwable {
		System.out.println("Around增强：执行目标方法之前，模拟开始事务...");
		// 访问执行目标方法的参数
		Object[] args = jp.getArgs();
		// 当执行目标方法的参数存在，
		// 且第一个参数是字符串参数
		if (args != null && args.length > 0
				&& args[0].getClass() == String.class) {
			// 改变第一个目标方法的第一个参数
			args[0] = "被改变的参数";
		}
		// 执行目标方法，并保存目标方法执行后的返回值
		Object rvt = jp.proceed(args);
		System.out.println("Around增强：执行目标方法之后，模拟结束事务...");
		return rvt + " 新增的内容";
	}

	// 定义Before增强处理执行
	@Before("execution(* com.webwalker.spring.aop.impl.*.*(..))")
	public void authority(JoinPoint jp) {
		System.out.println("Before增强：模拟执行权限检查");
		// 返回被织入增强处理的目标方法
		System.out.println("Before增强：被织入增强处理的目标方法为："
				+ jp.getSignature().getName());
		// 访问执行目标方法的参数
		System.out
				.println("Before增强：目标方法的参数为：" + Arrays.toString(jp.getArgs()));
		// 访问被增强处理的目标对象
		System.out.println("Before增强：被织入增强处理的目标对象为：" + jp.getTarget());
	}

	// 定义AfterReturning增强处理执行
	@AfterReturning(pointcut = "execution(* com.webwalker.spring.aop.impl.*.*(..))", returning = "rvt")
	public void log(JoinPoint jp, Object rvt) {
		System.out.println("AfterReturning增强：获取目标方法返回值:" + rvt);
		System.out.println("AfterReturning增强：模拟记录日志功能...");
		// 返回被织入增强处理的目标方法
		System.out.println("AfterReturning增强：被织入增强处理的目标方法为："
				+ jp.getSignature().getName());
		// 访问执行目标方法的参数
		System.out.println("AfterReturning增强：目标方法的参数为："
				+ Arrays.toString(jp.getArgs()));
		// 访问被增强处理的目标对象
		System.out.println("AfterReturning增强：被织入增强处理的目标对象为：" + jp.getTarget());
	}

	// 定义After增强处理执行
	@After("execution(* com.webwalker.spring.aop.impl.*.*(..))")
	public void release(JoinPoint jp) {
		System.out.println("After增强：模拟方法结束后的释放资源...");
		// 返回被织入增强处理的目标方法
		System.out.println("After增强：被织入增强处理的目标方法为："
				+ jp.getSignature().getName());
		// 访问执行目标方法的参数
		System.out.println("After增强：目标方法的参数为：" + Arrays.toString(jp.getArgs()));
		// 访问被增强处理的目标对象
		System.out.println("After增强：被织入增强处理的目标对象为：" + jp.getTarget());
	}
}
