package OracleEmployeeDBPrj;

public class EmployeeDTO {
	private int no;
	private String name;
	private String jobGrade;
	private int department;
	private String email;
	
	public EmployeeDTO(int no, String name, String job, int department, String email) {
		super();
		this.no = no;
		this.name = name;
		this.jobGrade = job;
		this.department = department;
		this.email = email;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getjobGrade() {
		return jobGrade;
	}

	public void setjobGrade(String job) {
		this.jobGrade = job;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
