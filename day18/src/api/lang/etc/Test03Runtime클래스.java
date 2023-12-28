package api.lang.etc;

import java.io.IOException;

public class Test03Runtime클래스 {
	public static void main(String[] args) throws IOException {
		//Runtime 클래스
		//- 직접 객체를 생성할 수는 없으나 생성된 객체를 빌려올 수는 있는 구조
		//- 객체를 빌려오는 메소드를 찾아야한다 (static 메소드)
		//- get으로 시작하며 getInstance라는 이름을 많이 쓴다
		
//		Runtime rt = new Runtime(); //생성
		Runtime rt = Runtime.getRuntime(); //대여(렌탈)
		
		// rt로는 터미널 명령을 실행할 수 있다 (터미널= 윈도우에서는 'cmd')
		// 그냥 실행하면 실행을 장담할 수 없으니 Plan B를 설계하고 실행하라!라는 에러가 뜸
		//throws IOException 이걸 메인 옆에 추가하면 에러가 안 뜬다
		
		String os = System.getProperty("os.name");
		if(os.startsWith("Windows")) {
		rt.exec("notepad"); //메모장실행
		rt.exec("calc"); //계산기 실행
		rt.exec("mspaint"); //그림판 실행
		}
		else if(os.startsWith("Mac")) { //맥
			rt.exec("open-a TextEdit.app");
		}
	}
}
