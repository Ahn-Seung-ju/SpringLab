package xml;
	
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class EmpLoggingAspect {
	
	//@Before
	public void before(JoinPoint joinPoint) {
		System.out.println(">>>>>>>>>> Before Advice : " + joinPoint.getSignature().getName());
		
	}
	
	//@around
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println(">>>>>>>>>> Around Advice[전] : " + pjp.getSignature().getName());
		
		Object obj = pjp.proceed();
		
		System.out.println(">>>>>>>>>> Around Advice[후] : " + pjp.getSignature().getName());
		return obj;
	}
	
	//@After
	public void after(JoinPoint joinPoint) {
		System.out.println(">>>>>>>>>> After Advice : " + joinPoint.getSignature().getName());
	}
	
	//@AfterThrowing
	public void throwingAllMethod(Exception ex) {
		System.out.println(">>>>>>>>>> @AfterThrowing advice : " + ex);
	}
}
