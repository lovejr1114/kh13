package oop.midifier2;

public class Academy {
	//멤버 필드(변수)
	private String course;
	private int time;
	private int price;
	private String type;
	
	//setter
	void setCourse(String course) {
		this.course = course;
	}
//	void setTime(int time) {
//		if(time % 30 == 0 && time > 0) {
//		this.time = time;
//		}
//	}
//	시간은 0이하이거나 30의 배수가 아니라면 설정하지 않는다
	void setTime(int time){
		if(time<=0){
			return; //그만해!
			}
		if(time % 30 != 0) {
			return; //그만해!
		}
		this.time = time;
		}  // 위 주석코드와 같은 코드인데 이 코드가 조금 더 활용적이다.
	
	// price가 0 이상일 경우 설정하세요. (화이트리스트 방식)
//	void setPrice(int price) {
//		if(price >= 0) {
//		this.price = price;
//		}
//	}
	//price가 0 미만이라면 설정하지 마세요 (블랙리스트 방식)
	void setPrice(int price) {
		if(price < 0) {
			return;
		}
		this.price = price;
	}
	
	//(주의) 문자열과 객체 등은 비교연산을 쓰지 않는다 (비교연산은 원시형을 위한 연산)
	//(해결) 별도의 비교명령을 쓰거나 switch 구문을 사용한다
//	void setType(String type) {
//		if(type == "온라인" || type == "오프라인" || type == "혼합") {		
//			this.type = type;
//		}
//	}
	void setType(String type) {
		switch(type) {
		case "온라인":
		case "오프라인":
		case "혼합":
			this.type = type;
		}
	}
	
	//getter
	int getPrice() {
		return this.price;
	}
	String getCourse() {
		return this.course;
	}
	int getTime() {
		return this.time;
	}
	String getType(){
		return this.type;
	}
	
	//1시간당 수강료를 계산하는 메소드가 추가로 필요하다 ( 가상의  getter)
	int getTimePrice() {
		return this.price / this.time;
	}
	
	//기타 메소드
	void data(String course, int time, int price, String type) {
		this.setCourse(course);
		this.setTime(time);
		this.setPrice(price);
		this.setType(type);
	}
	
	void information() {
		System.out.println("<학원 강의 요금표>");
		System.out.println("강좌명 : " + this.getCourse());
		System.out.println("강의 시간 : " + this.getTime() + "시간");
		System.out.println("수강료 : " + this.getPrice() + "원 (시간당 수강료 : " + this.getTimePrice()+"원)");
		System.out.println("구분 : " + this.getType());		
		System.out.println();
	}
}
