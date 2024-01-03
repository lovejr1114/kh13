package api.util.collection2;

import java.util.HashSet;
import java.util.Set;

public class Test01Set2 {
	public static void main(String[] args) {
		//Set<E>
		//- 전체를 매우 빠르게 탐색할 수 있도록 신경 쓴 구조
		//- 구조에 따라 TreeSet, HashSet 등이 존재
		//- 구조적으로 중복이 불가능
		//- 구조적으로 정해진 저장 순서를 따른다
		//- 구조적으로 인덱스가 존재하지않는다
		
//		HashSet<String> ts = new HashSet<>();
		Set<String> hs = new HashSet<>(); //업캐스팅
		
		//데이터 추가
		hs.add("피카츄");
		hs.add("라이츄");
		hs.add("파이리");
		hs.add("꼬부기");
		
		hs.add("피카츄");
		hs.add("피카츄");
		hs.add("피카츄"); //중복 허용되지 않음
		
		//데이터 검색
		System.out.println(hs.contains("피카츄")); //피카츄가 저장소에 있습니까?
		
		//데이터 삭제
		hs.remove("파이리");
		
		//데이터 출력
		System.out.println(hs);
		System.out.println("개수 = "+hs.size());
	}
}
