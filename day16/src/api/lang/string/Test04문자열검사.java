package api.lang.string;

public class Test04문자열검사 {
	public static void main(String[] args) {
		
		String url = "http://www.naver.com";
		
		//홈페이지 주소인가? (http로 시작하는가)
		System.out.println("http로 시작? "  + url.startsWith("http"));
		System.out.println("https로 시작? "  + url.startsWith("https"));
		
		// .com 으로 끝나는가? (회사의 주소인가?)
		System.out.println(".com으로 종료? "+ url.endsWith(".com"));
		
		//naver 주소인가? (naver가 들어있는가?)
		System.out.println("naver가 포함? "+ url.contains("naver"));
		
		//네이버가 어디있어요?
		System.out.println("naver 위치 = " + url.indexOf("naver"));
		System.out.println("kakao 위치 = " + url.indexOf("kakao"));
			//카카오는 없기 때문에 결과는 -1이 나옴. boolean이 아니라 int이기 때문에.
		
		//글자 수
		System.out.println("글자수 = " + url.length());
		
		//특정 위치 글자를 추출
//		char ch = url.charAt(11);   //변수로 저장하고 싶으면 이렇게!
		System.out.println("+11 위치의 글자 = " + url.charAt(11));
	}
}
