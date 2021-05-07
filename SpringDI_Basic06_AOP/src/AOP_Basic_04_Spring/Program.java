package AOP_Basic_04_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:AOP_Basic_04_Spring/ApplicationContext.xml");
		Calc calc = context.getBean("proxy", Calc.class);
		int result = calc.MUL(123, 456);
		System.out.println("AOP 결과: " + result); 
	}

}
