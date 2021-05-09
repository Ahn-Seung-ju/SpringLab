package xml;

public class Emp {
	private String Empno;
	private String ename;

	
	
	public Emp(String empno, String ename) {
		super();
		Empno = empno;
		this.ename = ename;
	}

	public String getEmpno() {
		return Empno;
	}

	public void setEmpno(String empno) {
		Empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "Emp [Empno=" + Empno + ", ename=" + ename + "]";
	}

}
