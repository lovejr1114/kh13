package oop.keyword5_1;

public class Member {
	private final String id;
	private String password;
	
	
	public Member(String id) {
		this.id = id;
	}
	public Member(String id, String password) {
		this.id = id;
		this.setPassword(password);
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	
	void information() {
		System.out.println("<회원 정보>");
		System.out.println("아이디 : " + this.id);
		System.out.println("패스워드 : " + this.getPassword());
	}
}
