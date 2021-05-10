package javaconfig;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class EmpTest {

	public static void main(String[] args) throws Exception {
		
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(EmpConfig.class);
		
		EmpManager manager = context.getBean(EmpManager.class);
		
		manager.setEmp(new Emp("안승주" , "2"));
		manager.setEmp(new Emp("문형철" , "3"));
		
		List<Emp> emps = manager.getAllEmps();
		System.out.println(emps);
	}

}
