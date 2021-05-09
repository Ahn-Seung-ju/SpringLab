package com.java.ex;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogApp {
	
	public Object logging(ProceedingJoinPoint joinpoint) throws Throwable {
		
		String methodname = joinpoint.getSignature().toShortString();
		System.out.println("[logging start]: " + methodname + " is start!!!");
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			System.out.println("[logging end]" + methodname + " is finished");
		}
		
	}
}
