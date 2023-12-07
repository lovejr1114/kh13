package data2;

public class Test06페이지번호계산기 {
	public static void main(String[] args) {
		
		//입력
		int page = 275;
		int scope = 10;
		
		//계산
		int first = (page / scope * scope)+1;
		int last = (page / scope * scope)+scope;
		//System.out.println(first);
		//System.out.println(last);
		
		
		//출력
		//System.out.println(page + "페이지의 첫 페이지는 " + first + "페이지이고, 마지막 페이지는 " + last + "페이지 입니다.");

		
		//선생님풀이
		//입력
		int page1 = 4;
		int size = 10; //보여줄 번호의 개수
		
		//계산
		int begin = (page1 - 1) / size * size + 1;
		//int end = (page1 - 1) / size * size + 10;
		int end = begin + (size - 1);
		System.out.println(begin);
		System.out.println(end);
		
		//출력
		//System.out.println("시작번호 : " +begin);
		//System.out.println("종료번호 : " + end);
	}

}
