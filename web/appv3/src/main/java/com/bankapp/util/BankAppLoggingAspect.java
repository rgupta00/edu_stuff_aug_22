package com.bankapp.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bankapp.exceptions.BankAccountNotFoundException;
@Aspect
@Component
public class BankAppLoggingAspect {

	private Logger logger= LoggerFactory.getLogger(BankAppLoggingAspect.class);
	
	//i want to apply this for any method of service layer 
	
	@Pointcut("execution( * com.bankapp.model.service.*Impl.*(..))")
	public void allMethodsOfServiceLayer() {}
	
//	@Around("allMethodsOfServiceLayer()")
	@Around("@annotation(MyLogger)")
	public Object loggingAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long start= System.currentTimeMillis();
		
		Object val=proceedingJoinPoint.proceed();
		try {
			Thread.sleep(1000);
		}catch(InterruptedException ex) {}
		
		long end= System.currentTimeMillis();
		
		
		logger.info("time taken to execute transfer method is : "+(end-start)+ "ms");
		return val;
	}
	
	@AfterThrowing(pointcut = "execution( * com.bankapp.model.service.*Impl.*(..))", throwing = "ex")
	public void logTheError(BankAccountNotFoundException ex) throws Throwable {
		logger.error("Exception occoured : "+ex.toString());

	}
}
