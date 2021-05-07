package AOP_Basic_04_Spring;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;



public class LogPrintAroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		System.out.println("around advice invoke start");
		System.out.println("method: " + method);
		
		//보조 업무
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		//주 업무(실 객체의 함수 호출)
		Object result = method.proceed(); // 실겍체의 실함수를 호출한 결과를 받아서
		
		//보조 업무
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[Time log Method:" + method +  " ]");
		log.info("[Time log Method:" + sw.getTotalTimeMillis() + " ]"); 
		
		
		return result;
	}

	
	
}
