package javaconfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmpManagerImpl implements EmpManager{

	List<Emp> list = new ArrayList<Emp>();
	
	public List<Emp> getAllEmps() throws Exception {
		
		System.out.println("[Target Method]: getAllEmps() called ...");
		
		return list;
	}

	public void setEmp(Emp e) {
		
		list.add(e);
	}
	

}
