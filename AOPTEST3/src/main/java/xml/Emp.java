package xml;

public class Emp {
	String ename;
	String empno;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public Emp(String ename, String empno) {
		super();
		this.ename = ename;
		this.empno = empno;
	}
	@Override
	public String toString() {
		return "Emp [ename=" + ename + ", empno=" + empno + "]";
	}
	
	
}
