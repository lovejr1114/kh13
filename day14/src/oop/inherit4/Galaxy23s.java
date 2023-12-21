package oop.inherit4;

public class Galaxy23s extends Phone {
	
	//Phone 클래스가 필요로 하는 데이터를 전달하기 위해 생성자를 구현
	// = Phone 클래스는 number를 필요로 하기 때문에 해당 생성자 구현
	public Galaxy23s(String number) {
		super(number); //수퍼 클래스 생성자로 전달해주세요
	}
	
	public void information() {
		//super는 상위 클래스를 지칭하는 표현
		
//		System.out.println("이 기기의 번호는 "+super.number+"입니다");
		//상위 클래스에 private로 변수를 설정했다면 위 코드가 에러남.
		
		System.out.println("이 기기의 번호는 "+super.getNumber()+"입니다");
		//private으로 설정했을 시, 세터/게터메소드를 만들어주면 출력하면 된다.
		
		//만약 이름이 겹치지 않는다면 this로 표현해도 가능
//		System.out.println("이 기기의 번호는 "+this.getNumber()+"입니다");	
	}
	//- 상속받은 내용 중에서 마음에 들지 않는 메소드가 있다면, 재정의를 통해서 내용을 변경할 수 있다
	//똑같은 형태로 메소드를 한 번 더 만든다
	public void internet() {
		System.out.println("삼성 인터넷 기능");
		//위에 코드는 상속코드에 파이널로 만들면 에러가 남.
	}
}
