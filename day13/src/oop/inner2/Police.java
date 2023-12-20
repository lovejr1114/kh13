package oop.inner2;

public class Police {
	private String name, level;
	private Gun gun;
	
	
	public Police(String name, String level) {
		this.setName(name);
		this.setLevel(level);
		//총은 Police 만 접근이 가능하므로 외부 설정이 아니라 직접 생성한다.
		Gun gun = new Gun();
		this.setGun(gun);
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}


	public Gun getGun() {
		return gun;
	}

	public void setGun(Gun gun) {
		this.gun = gun;
	}



	//중첩 클래스 (inner class, nested class)
	//- 특정 클래스에 "소속"된 클래스
	private static final class Gun { //public이면 import가 가능하다.
		//필드 + 메소드 + 생성자 + 클래스
	}
}
