package xml;

import java.util.List;

import org.springframework.stereotype.Component;

public interface EmpManager {
	List<Emp> getAllEmps() throws Exception;
	void setEmp(Emp e);
}
