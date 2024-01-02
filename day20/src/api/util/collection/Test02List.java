package api.util.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test02List {
	public static void main(String[] args) {
		//List<E>
		//- 순서를 가장 중요하게 생각하는 저장소
		//- 그룹 내에서 클래스가 다르다는 것은 저장 원리가 다르다는 것
		
		ArrayList<String> a = new ArrayList<>();
//		LinkedList<String> b = new LinkedList<>();
//		CopyOnWriteArrayList<String> c = new CopyOnWriteArrayList<>();
		
		//데이터 추가
		a.add("자바");
		a.add("파이썬");
		a.add("안드로이드");
		a.add("루비");
		a.add("엘릭서"); //디스코드 만든 언어 (서버 부분)
		
		//출력
		System.out.println(a);
	}
}
