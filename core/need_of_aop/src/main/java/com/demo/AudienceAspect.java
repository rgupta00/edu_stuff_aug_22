package com.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AudienceAspect {
	//Before, After , AfterRetrun AfterThrows, Around (filter)
//	@AfterReturning("execution(public void doMagic())")
	
	
	@Before("execution( * do*(*))")
	public void clapping() {
		System.out.println("wow we enjoyed a lot");
	}
	
	
//	@Around("execution(public String doMagic())")
//	public Object clapping(ProceedingJoinPoint joinPoint) throws Throwable {
//		System.out.println("start");
//		//any code to invoke the target method ?
//		Object value=joinPoint.proceed();
//		System.out.println("end");
//		return value;
//	}
	
//	@AfterThrowing(pointcut = "execution(public void doMagic())", throwing = "ex")
//	public void callTheDrNow(PanicAttackExcpetion ex) {
//		System.out.println(ex.getMessage());
//	}
}









//@Pointcut("execution(public void doMagic())")
//public void myPointCut() {}
//
//@Before("myPointCut()")
//public void clapping() {
//	System.out.println("wow we enjoyed a lot");
//}