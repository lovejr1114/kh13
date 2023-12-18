package oop.method2;

public class Olympics {
	//변수
	String name, event, division;
	int gold, silver, bronze;
	
	//메소드
	void information() {
		System.out.println("이름 : " + this.name);
		System.out.println("종목 : " + this.event);
		System.out.println("구분 : " + this.division);
		System.out.println("금메달 : " +this.gold+"개, 은메달 : " +this.silver+
				"개, 동메달 : "+ this.bronze+"개");
		System.out.println();
	}
	
	void data(String name, String event, String division, int gold, int silver, int bronze){
		this.name = name;
		this.event = event;
		this.division = division;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
}
