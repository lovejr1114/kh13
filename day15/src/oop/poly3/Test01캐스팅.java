package oop.poly3;

public class Test01캐스팅 {
	public static void main(String[] args) {
		//Hwang의 객체를 만들어서 UP/DOWN 캐스팅 구현
		
		//집이라고 볼 수 있음
		Hwang h1 = new Hwang(); //왼쪽의 형태는 보관의 형태, 오른쪽이 진짜 객체의 형태
		h1.game();
		h1.drink();
		h1.teach();
		System.out.println("----------");
		
		//출근을 한다면
		Teacher t = h1; //업캐스팅 (Hwang -> Teacher로 업캐스팅)
//		t.game(); //보이지 않는 기능
//		t.drink(); //안보이는 기능
		t.teach(); //재정의 되어 있어서 연결되어 실행
		System.out.println("----------");
		
		//퇴근한다 하면
//		Hwang h2 = t; //Teacher에서 Hwang으로 되돌림 (다운캐스팅)
		Hwang h2 = (Hwang)t; //다운캐스팅은 조금 까다롭다. 캐스팅을 강제로 바꿔줘야함.
		h2.game();
		h2.drink();
		h2.teach();
	}
}
