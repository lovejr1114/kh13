package oop.inherit5_1;
//정수기 클래스
public class Purifier {
	//필드
	private String company;
	private int price; //가격이 설정되어 있으면 프라이빗으로 쓰는게 좋다. 가격제한이 없으면 protected로.
	
	
	//setter / getter
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
			this.company = company;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0) return;
		this.price = price;
	}
	
	//생성자
	//-(참고) protected의 "우리"라는 개념에는 "패키지 + 상속그룹"이 포함
	public Purifier(String company, int price) { //public -> protected로 바꿔주면 메인에 쓸 수 있음.
		this.setCompany(company);
		this.setPrice(price);
	}
	//메소드
	public final void nomal() {
		System.out.println("정수 1잔 추출");
	}
}
