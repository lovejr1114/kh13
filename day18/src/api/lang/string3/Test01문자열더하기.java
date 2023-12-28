package api.lang.string3;

public class Test01문자열더하기 {
	public static void main(String[] args) {
		//문자열이 불변이어서 생기는 단점 살펴보기 (ex: 별 생성)
		
		String star = "";
		long begin = System.currentTimeMillis(); //현재 시간을 밀리초(ms)로 반환 (0.001초 단위로 시간을 구해주는)
		for(int i=1; i<=10; i++) {
			star += "*";
		}
		long end = System.currentTimeMillis();
		long gap = end - begin;
//		System.out.println("star = " + star);
		System.out.println("gap = " + gap); //초로 바꾸고싶으면 결과값에 나누기 1000
	}
}
