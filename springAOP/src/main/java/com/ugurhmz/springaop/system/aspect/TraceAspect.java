package com.ugurhmz.springaop.system.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;



@Aspect
@Configuration
public class TraceAspect {

	
	
	@Before("execution(* com.ugurhmz.springaop.module.sales.*.*(..))")
	public void comingAll(JoinPoint joinPoint) {
		
		System.out.println("comingAll");
		System.out.println("JoinPoint long str: "+joinPoint.toLongString());
		System.out.println("JoinPoint kısa str: "+joinPoint.toShortString());
		
		System.out.println(joinPoint.getTarget().getClass().getSimpleName()+" ");
		System.out.println(joinPoint.getSignature().getName()+" ");
		
		for(Object arg : joinPoint.getArgs()) {
			System.out.println(arg + ":"+arg.getClass().getSimpleName());
		}
		
	}
	
	
	@Before("execution(* com.ugurhmz.springaop.module.sales.Sales*.*Something(String))")
	public void comingSomething(JoinPoint joinPoint) {
		System.out.println("comingSomething...");
	}
	
	
	@Before("execution(* com.ugurhmz.springaop.module.sales.*.handle*(..))")
	public void comingHandle(JoinPoint joinPoint) {
		System.out.println("comingHandle...");
	}
	
	
	@Around("execution(* com.ugurhmz.springaop.module.sales.*.*(..)))")
	public Object aroundAll(ProceedingJoinPoint joinPoint) throws  Throwable {
		System.out.println("Around");
		
		Object result = joinPoint.proceed();
		return result;
	}
	
	
	
	@After("execution(* com.ugurhmz.springaop.module.sales.*.*(..))")
	public void goAfterAll(JoinPoint joinPoint) {
		System.out.println("After");
	}
	
	
	@AfterReturning("execution(* com.ugurhmz.springaop.module.sales.*.*(..))")
	public void goingReturning(JoinPoint joinPoint) {
		System.out.println("AfterReturning");
	}
	
	
	@AfterThrowing("execution(* com.ugurhmz.springaop.module.sales.*.*(..))")
	public void goingThrowing(JoinPoint joinPoint) {
		System.out.println("AfterThrowing");
	}
	
	
	
	
	
}
