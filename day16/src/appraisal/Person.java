package appraisal;

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private String job;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age >= 1) {
		this.age = age;
		}
		else {
		this.age = 1;
		}
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	String getAgeInfor() {
		if(age >= 20) {
			return "(성인)";
		}
		else if(age >=14 && age <= 19) {
			return "(청소년)";
		}
		else if(age >= 8 && age <= 13) {
			return "(어린이)";
		}
		else {
			return "(유아)";
		}
	}
	
	
	Person(String firstName, String lastName, int age){
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAge(age);
		this.setJob("무직");
		}
	
	Person(String firstName, String lastName, int age, String job){
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAge(age);
		this.setJob(job);
	}


	void information() {
		System.out.println("<사용자 정보>");
		System.out.println("이름 : " + this.getLastName() + this.getFirstName());
		System.out.println("나이 : " + this.getAge() + "세 " + this.getAgeInfor());
		System.out.println("직업 : " + this.getJob());
	}
}
