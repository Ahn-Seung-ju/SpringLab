package DI_04_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		//java 코드
		//MessageBeanlmpl message = new MessageBeanlmpl("hong");
		//message.setGreeting("hello");
		//message.sayHello();
		
		//Spring
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_04_Spring/DI_04.xml");
		
		MessageBean message = context.getBean("m1",MessageBean.class);
		message.sayHello();
	}

}
