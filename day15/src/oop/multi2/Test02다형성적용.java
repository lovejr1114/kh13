package oop.multi2;

public class Test02다형성적용 {
	public static void main(String[] args) {
		//랜덤으로 비행 물체 1개를 만들어서 날려보세요
		
		int choice = 1;
		
		Flyable f; //리모컨, 변수 하나 만들어놓고
		//문제가 예약가능한 물체 1개를 만들으라하면 Flyable 대신 Reserve가 되고,
		// if문 안에는 예약가능한 것을 입력해야한다.
		if(choice == 1) {
			f = new Drone(); //업캐스팅 
			//만약 여기에 드론이 아니라 트레인이었다면 상속관계가 아니라 실행이 안됨
		}
		else {
			f = new Airplane(); //업캐스팅
		}
		
		f.fly();
	}
}
