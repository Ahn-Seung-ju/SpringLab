package xml;

import java.util.ArrayList;
import java.util.List;

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
