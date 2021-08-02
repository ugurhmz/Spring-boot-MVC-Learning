package com.ugurhmz.springaop.system.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;



@Aspect
@Configuration
public class TraceAspect {

	
	
	@Before("execution(* com.ugurhmz.springaop.module.sales.*.*(..))")
	public void comingAll(JoinPoint joinPoint) {
		
		System.out.println("comingAll");
	}
	
	
	@Before("execution(* com.ugurhmz.springaop.module.sales.Sales*.*Something(String))")
	public void comingSomething(JoinPoint joinPoint) {
		System.out.println("comingSomething...");
	}
	
	
	@Before("execution(* com.ugurhmz.springaop.module.sales.*.handle*(..))")
	public void comingHandle(JoinPoint joinPoint) {
		System.out.println("comingHandle...");
	}
	
	
	
}
