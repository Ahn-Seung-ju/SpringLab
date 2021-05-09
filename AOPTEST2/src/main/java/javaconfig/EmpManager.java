package javaconfig;

import java.util.List;


public interface EmpManager {
	List<Emp> getAllEmps() throws Exception;
	void setEmp(Emp e);
}
