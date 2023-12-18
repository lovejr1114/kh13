package oop.method2;

public class Test01메소드사용 {
	public static void main(String[] args) {
		//객체 생성
		Olympics a = new Olympics();
		Olympics b = new Olympics();
		Olympics c = new Olympics();
		
		//초기화
		a.data("진종오", "사격", "하계", 4,2,0);
		b.data("김수녕","양궁","하계", 4,1,1);
		c.data("전이경","쇼트트랙","동계",4,0,1);
		
		//출력
		a.information();
		b.information();
		c.information();
	}
}
