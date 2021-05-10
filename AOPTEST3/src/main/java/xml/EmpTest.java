package xml;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpTest {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("AspectJ.xml");
		
		EmpManager manager = (EmpManager) context.getBean("empManagerImpl");
		
		manager.setEmp(new Emp("안승주" , "3"));
		
		List<Emp> list = manager.getAllEmps();
	}

}
