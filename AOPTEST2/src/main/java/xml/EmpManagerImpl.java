package xml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

public class EmpManagerImpl implements EmpManager{
	
	List<Emp> emps = new ArrayList<>();
	
	@Override
	public List<Emp> getAllEmps() throws Exception {
		
		System.out.println("[Target Method] getAllEmps() called...");
		
		return emps;
	}

	@Override
	public void setEmp(Emp e) {
		emps.add(e);
	}

}
