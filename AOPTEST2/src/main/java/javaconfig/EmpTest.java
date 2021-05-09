package javaconfig;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

public class EmpTest {
	
	public static void main(String[] args) throws Exception{
//		ApplicationContext context = new ClassPathXmlApplicationContext("aspectjannotation.xml");
//		EmpManager manager = (EmpManager)context.getBean("empManager");
		
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(EmpConfig.class);
		EmpManager manager = context.getBean(EmpManager.class);
		
		manager.setEmp(new Emp("1", "홍길동"));
		manager.setEmp(new Emp("2", "김유신"));
		
		List<Emp> emps = manager.getAllEmps();
		System.out.println(emps);
	}
	
}
