package oop.constructor3;

public class Game {
	//필드
	private String id;
	private String job;
	private int level;
	private int gold;

	//setter
	void setId(String id) {	
		this.id = id;
	}
	void setJob(String job) { //if(job==전사 ||  ... 이런 코드는 안됨.
		switch(job) {
		case "전사": case "도적": case "마법사":
			this.job = job;
		}
	}
	void setLevel(int level) {
		if(level < 1) return; 
		this.level = level;
	}
	void setGold(int gold) {
		if(gold < 0) return;
		this.gold = gold;
	}
	//getter
	String getId() {
		return this.id;
	}
	String getJob() {
		return this.job;
	}
	int getLevel() {
		return this.level;
	}
	int getGold() {
		return this.gold;
	}
	
	
	//생성자
	Game(String id, String job){
		this.setId(id);
		this.setJob(job);
		this.setLevel(1);
		this.setGold(100);
	}
	
	//출력
	void information() {
		System.out.println("ID : " + this.getId());
		System.out.println("직업  : " + this.getJob());
		System.out.println("레벨 : " + this.level);
		System.out.println("소지금 : " + this.gold +"골드");
		}
	
	void levelUp() {
		this.level++;
	}
}
