package xml.copy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmpLoggingAspect {
	
	@Before("execution(* xml.EmpManagerImpl.get*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println(">>>>>>> Before Advice : " + joinPoint.getSignature().getName());
	}

	@Around("execution(* xml.EmpManagerImpl.get*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(">>>>>>> Around Advice[전] : " + pjp.getSignature().getName());
		
		// 메서드를 호출 안 할수도 있고 여러번 호출할 수 있다
		Object obj = pjp.proceed();
		
		System.out.println(">>>>>>> Around Advice[후] : " + pjp.getSignature().getName());
		
		// return 값은 대체 가능
		return obj;
	}
	
	// 에러가 나든 말든 finally처럼 실행된다
	@After("execution(* xml.EmpManagerImpl.get*(..))")
	public void after(JoinPoint joinPoint) {
		System.out.println(">>>>>>> after Advice : " + joinPoint.getSignature().getName());
	}
	
	// 예외가 났을 때
	@AfterThrowing(pointcut = "execution(* xml.EmpManagerImpl.get*(..))", throwing = "ex")
	public void logAgterThrowingAllMethods(Exception ex) throws Throwable {
		System.out.println(">>>>>> @AfterThrowing advice : " + ex);
	}
	
}
