package model;

public class Producer {
	private int id;
	private String name;
	private int age;
	private String gender;
	private String password;
	
	public Producer() {
		super();
	}

	public Producer(int id, String name, int age, String gender, String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.password = password;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String toString() {
		return name+" "+password;
	}

}
