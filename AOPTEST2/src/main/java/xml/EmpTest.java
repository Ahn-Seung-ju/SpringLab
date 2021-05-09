package xml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

public class EmpTest {
	
//	static EmpManager manager;
//	
//	@Autowired
//	public EmpTest(EmpManager manager) {
//		this.manager = manager;
//	}
	
	public static void main(String[] args) throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("aspectjannotation.xml");
		
		EmpManager manager = (EmpManager)context.getBean("car");
		
		manager.setEmp(new Emp("1", "홍길동"));
		manager.setEmp(new Emp("2", "김유신"));
		
		List<Emp> emps = manager.getAllEmps();
		System.out.println(emps);
	}
	
}
