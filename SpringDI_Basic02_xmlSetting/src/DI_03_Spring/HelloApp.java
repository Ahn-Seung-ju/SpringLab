package DI_03_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class HelloApp {
	public static void main(String[] args) {
		//영문
		//MessageBean_en ms_en = new MessageBean_en();
		//ms_en.sayHello("hong");
		
		//한글
		//MessageBean_kr ms_kr = new MessageBean_kr();
		//ms_kr.sayHello("hong");
		
		//MessageBean ms_bean = new MessageBean_kr();
		//ms_bean.sayHello("hong");
		
		//spring 컨테이너 생성 > 생성된 컨테이너 객체 생성 조립(xml)
		//컨테이너 생성방법: 다양한 방법
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_03_Spring/DI_03.xml");
		//Generic -> 형변환에의 대한 이점
		//원칙: (MessageBean)context.getBean("messagebean")
		MessageBean message = context.getBean("msbean",MessageBean.class);
		message.sayHello("hong");
	}
}
/*
	요구사항
	1. 한글버전 (hong) : 안녕 hong
	2. 영어버전 (hong) : hello hong
	
	MessageBean_kr > 안녕 hong
	MessageBean_eng > hello hong
	
	>> 인터페이스 활용 : MessageBean 설계 (다
*/