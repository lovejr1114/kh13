package api.util.collection2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test05집합연산 {
	public static void main(String[] args) {
		
		//서로 다른 두 개의 집합을 준비했다
		Set<Integer> a = Set.of(10, 20, 30, 60);
		Set<Integer> b = Set.of(30, 40, 50, 60);
		
		//합집합 (union)
		Set<Integer> union = new TreeSet<>();
		union.addAll(a); // a를 다 더해라
		union.addAll(b); //b를 다 더해라
		System.out.println("union = " +union);
		
//		List<Integer> union1 = new ArrayList<>();
//		union1.addAll(a); // a를 다 더해라
//		union1.addAll(b); //b를 다 더해라
//		System.out.println("union = " +union1);
		//List는 중복이 가능해서 다 나온다.
		
		
		
		//교집합 (intersection)
		Set<Integer> intersect = new TreeSet<>();
		intersect.addAll(a); // a는 전부 추가
		intersect.retainAll(b); // b와 겹치는 부분만 남겨라
		System.out.println("intersection = "+intersect);
		
		
		//차집합 (except 또는 minus)
		Set<Integer> minus =  new TreeSet<>();
		minus.addAll(a); //a는 전부 추가
		minus.removeAll(b); //b에 포함된 내용을 제거하라
		System.out.println("minus = "+minus);
	}
}
