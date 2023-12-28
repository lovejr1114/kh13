package api.lang.etc;

public class Test01시스템클래스 {
	public static void main(String[] args) {
		//System클래스
		//-생성자가 없는 클래스
		//- 생성자가 없다는 것은 (1)객체 아예 생성 불가 (2)객체 생성 개수 제한
		//- 모든 필드와 메소드가 static이면 (1)번에 해당
		//- static이 아닌 필드나 메소드가 있으면 (2)번에 해당
		
		//-System 클래스는 (1)에 해당
		
		//현재 시각 구하기
		//- 기준시(UTC)인 1970-01-01 00:00:00초 이후에 흘러간 밀리초 반환
		//- 시간 출력용이 아니라 시간 차이를 구하는 용도
		long time = System.currentTimeMillis();
		System.out.println("time = " + time);
		
		//프로그램 종료
		//- 외부 시스템에게 종료하며 상태를 알려줄 수 있다
		//- 0은 정상적인 종료를 의미
		//- 0이 아닌 숫자는 비정상적인 종료를 의미하며 개발자가 정하기 나름
//		System.exit(0);
//		System.out.println("이 메세지는 출력해도 나오지 않습니다."
//				+ "이유는 앞에서 프로그램이 끝나기 때문에.");
		
		//시스템 환경정보 읽기
		System.out.println(System.getProperties());
		
		System.out.println(System.getProperty("java.specification.version")); //자바버전
		System.out.println(System.getProperty("os.name")); //운영체제 이름
		System.out.println(System.getProperty("user.country")); //유저 지역
		System.out.println(System.getProperty("user.language")); //유저 언어
		System.out.println(System.getProperty("user.name")); //사용자명
		
		//(중요) 사용자의 동의 없이 파일을 생성할 수 있는 사용자 홈 위치(운영체제마다 다르다)
		System.out.println(System.getProperty("user.home")); //사용자 홈 *나중에 무조건 씀*
		
		//출력도 종류가 나눠져있다
		System.out.println("Hello"); //정상 출력
		System.err.println("Hello"); //오류 출력
	}
}
