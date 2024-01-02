package api.util.collection;

import java.util.ArrayList;
import java.util.TreeSet;

public class Test01 {
	public static void main(String[] args) {
		//Collection
		//- 데이터를 무한대로 저장하기 위한 저장소, 저장 시스템
		//- 배열과 비슷하지만 가변/불변 차이가 있다(배열은 정해진 수대로만)
		//- 내용물(Generic type)을 같이 작성하는 것을 권장한다
		
		TreeSet a = new TreeSet();
		//TreeSet 이라는 저장소가 생긴다.
		//그냥 만들면 경고가 나온다. (상자에 파손주의 스티커 안붙여진 느낌)
		//=아무 표시 없이 저장소를 만들었으므로 경고 발생 (Object 저장)
		
		TreeSet<String> b = new TreeSet<String>();
		//<String>을 표시해서 저장소를 만들었으므로 경고 없음 (String 저장)
		
		TreeSet<String> c = new TreeSet<>();
		//우측에는 Generic type을 생략할 수 있다. 이 형태를 웬만하면 쓴다.
		
		
		ArrayList<String> d = new ArrayList<>();
		//배열과 비슷한
		
		
		//데이터 추가 - .add()
		c.add("피카츄");		d.add("피카츄");
		c.add("라이츄");		d.add("라이츄");
		c.add("파이리");		d.add("파이리");
		c.add("꼬부기");		d.add("꼬부기");
		
		//출력
		System.out.println("c = " + c);
		System.out.println("d = " + d);
	}
}
