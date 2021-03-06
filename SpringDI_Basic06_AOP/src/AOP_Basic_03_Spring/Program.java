package AOP_Basic_03_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:AOP_Basic_03_Spring/ApplicationContext.xml");
		Calc calc = context.getBean("proxy", Calc.class);
		int result = calc.ADD(123, 456);
		System.out.println("AOP 결과: " + result); 
	}

}
