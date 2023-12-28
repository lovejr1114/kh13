package api.lang.string3;

public class Test02문자열버퍼 {
	public static void main(String[] args) {
		//StringBuffer를 이용한 문자열 합산
		
//		String star = "";
		StringBuffer buffer = new StringBuffer(); // buffer를 문자열로 바꾸고싶으면 buffer.toString()로 바꾸면됨
		long begin = System.currentTimeMillis(); //현재 시간을 밀리초(ms)로 반환 (0.001초 단위로 시간을 구해주는)
		for(int i=1; i<=10000000; i++) {
//			star += "*";
			buffer.append("*");
		}
		long end = System.currentTimeMillis();
		long gap = end - begin;
//		System.out.println("star = " + star);
		System.out.println("gap = " + gap); //초로 바꾸고싶으면 결과값에 나누기 1000
	}
}
