package dto;

public class Student {
	
	private int id;
	private String name;
	private String email;
	private String password;
	private double marks;
	
	public Student(){
		
	}

	public Student(int id, String name, String email, String password, double marks) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "\nStudent [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", marks="
				+ marks + "]";
	}
	
	

}
