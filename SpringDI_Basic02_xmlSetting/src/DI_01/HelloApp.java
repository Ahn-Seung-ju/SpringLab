package DI_01;

public class HelloApp {
	public static void main(String[] args) {
		MessageBean messagebean = new MessageBean();
		messagebean.sayHello("hong");
		
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