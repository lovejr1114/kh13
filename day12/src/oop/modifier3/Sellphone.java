package oop.modifier3;

public class Sellphone {
	private String name;
	private String telecom;
	private int price;
	private int contact;
	
	//setter
	void setName(String name) {
		this.name = name;
	}
	void setTelecom(String telecom) {
		switch(telecom) { //소문자, 대문자 구분할 수 있는 코드 인터넷에서 찾아보기
		case "SK":
		case "LG":
		case "KT":
			this.telecom = telecom;
		}
	}
	void setPrice(int price) {
		if(price < 0) return;
		this.price = price;
	}
	void setContact(int contact) {
		switch(contact) {
		case 0:
		case 24:
		case 36:
			this.contact = contact;
		}
	}	
	
	//getter
	String getName() {
		return this.name;
	}
	String getTelecom() {
		return this.telecom;
	}
	int getPrice() {
		return this.price;
	}
	int getContact() {
		return this.contact;
	}
		
	boolean getContactStatus() { //개월이 0이면
//		return this.contact > 0;
		if(this.contact > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	int getResult() {
		if(!this.getContactStatus()) { //약정기간이 없으면
			return this.getPrice() * 95 /100;
		}
		else { //약정기간이 있으면
			return this.getPrice();
		}
	}
	int getMonthPrice() { //가격을 개월로 나눠서
		return this.getPrice() / this.getContact();
	}
	
	//기타
	void data(String name, String telecom, int price) { //약정이 없을 수도 있으니까 두 개 만들어줌 (오버로딩)
		this.data(name, telecom, price, 0);
	}
	void data(String name, String telecom, int price, int contact) {
		this.setName(name);
		this.setTelecom(telecom);
		this.setPrice(price);
		this.setContact(contact);
	}
	
	
	void information() {
		System.out.println("<휴대폰 판매 정보>");
		System.out.println("이름 : " + this.getName());
		System.out.println("통신사 : " + this.getTelecom());
		System.out.println("가격 : " +getResult() + "원");
		if(this.getContactStatus()) {
			System.out.println("약정기간 : " + this.getContact()+"개월");
			System.out.println("(월 "+this.getMonthPrice()+"원)");
		}
		else {
			System.out.println("약정 기간 없음");
		}
		System.out.println();
	}
	
	
}
