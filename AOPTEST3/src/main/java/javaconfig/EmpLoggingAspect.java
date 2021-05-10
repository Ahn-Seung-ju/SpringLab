package javaconfig;
	
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmpLoggingAspect {
	
	@Before("execution(* javaconfig.EmpManagerImpl.get*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println(">>>>>>>>>> Before Advice : " + joinPoint.getSignature().getName());
		
	}
	
	@Around("execution(* javaconfig.EmpManagerImpl.get*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println(">>>>>>>>>> Around Advice[전] : " + pjp.getSignature().getName());
		
		Object obj = pjp.proceed();
		
		System.out.println(">>>>>>>>>> Around Advice[후] : " + pjp.getSignature().getName());
		return obj;
	}
	
	@After("execution(* javaconfig.EmpManagerImpl.get*(..))")
	public void after(JoinPoint joinPoint) {
		System.out.println(">>>>>>>>>> After Advice : " + joinPoint.getSignature().getName());
	}
	
	@AfterThrowing(pointcut = "execution(* javaconfig.EmpManagerImpl.get*(..))", throwing = "ex")
	public void throwingAllMethod(Exception ex) {
		System.out.println(">>>>>>>>>> @AfterThrowing advice : " + ex);
	}
	
	
	
}
