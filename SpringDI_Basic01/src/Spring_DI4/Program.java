package Spring_DI4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		/*
		 * 
		1. SpringFramework 가 제공하는 컨테이너 안에 객체 생성 (메모리 공간 : IOC 컨테이너)
		
		2. 컨테이너를 만들고 그 메모리에 필요한 객체를 생성하고 조립(주입) .. 소멸
		
		NewRecordView view = new NewRecordView();
		
		NewRecord record = new NewRecord();
		
		view.setRecord(record);// setter 주입 (다형성)
		*/
		
		//저장공간인 컨테이너를 만들고 ... 그 다음 xml read 하기 시작합니다.. 컨테이너 안에 객체 생성, 주입 과정 실행
		ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
		
		//컨테이너 안에서 필요한 객체만 골라서 놀면 됨
		//레고박스 안에 만들어진 블럭들이 있고 ... 원하는 블럭을 가지고 노는 것
		RecordView view = (RecordView)context.getBean("view");
		
		view.input();
		view.print();
		
		//예외발생
		//Caused by: java.lang.ClassNotFoundException: org.apache.commons.logging.LogFactory --> 보조 jar 파일을 찾아서 넣어 주어야한다
		
	}

}
