package oop.multi1;

/*
 	인터페이스 (interface)
 	- 다중상속 전용 클래스
 	- 다중상속에 문제가 되는 모든 부분이 제거된 클래스
 */
public interface Singer {
	//필드 - 변수 생성 불가 (만들 수는 있지만 기능은 구현이 안됨. 사실 상 못 만드는 것이나 마찬가지)
	//메소드 -  추상 메소드만 가능 (1.8부터는 default 메소드도 가능)
	/*public abstract을 적지 않아도 붙은것과 같은 기능이 실행됨*/void sing();
	//생성자 - 만들 수 없다.
}
