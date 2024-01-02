package api.util.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test02List2 {
	public static void main(String[] args) {	
		ArrayList<String> a = new ArrayList<>();
		//String[] a = new String[5];
		
		//데이터 추가
		a.add("자바");					//a[0] = "자바";
		a.add("파이썬");				//a[1] = "파이썬";
		a.add("안드로이드");		//a[2] = "안드로이드";
		a.add("루비");					//a[3] = "루비";
		a.add("엘릭서");				//a[4] = "엘릭서";
		
		//데이터 개수 확인
		System.out.println("개수 = " + a.size());
		
		//데이터 검색
		System.out.println("자바가 있나요? = " +a.contains("자바"));
		
		//데이터 삭제
		a.remove("파이썬");
		
		//출력
		System.out.println(a);
	}
}
