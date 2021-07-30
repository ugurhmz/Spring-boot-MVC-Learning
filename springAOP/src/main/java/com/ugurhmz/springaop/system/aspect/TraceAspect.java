package com.ugurhmz.springaop.system.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;



@Aspect
@Configuration
public class TraceAspect {

	
	
	@Before("execution(* com.ugurhmz.springaop.module.sales.*.*(..))")
	public void coming(JoinPoint joinPoint) {
		
		System.out.println("Before çalıştı : ");
	}
	
}
