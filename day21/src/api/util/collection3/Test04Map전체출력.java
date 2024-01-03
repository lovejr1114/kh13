package api.util.collection3;

import java.util.Map;
import java.util.Set;

public class Test04Map전체출력 {
	public static void main(String[] args) {
		//Map 역시 전체 데이터 출력이 가능하다
		Map<String, Integer> votes = Map.of(
				"피카츄",30, "라이츄",25, "꼬부기",12, "뮤츠",99);
		
		//Map의 Key 부분만 보면 Set과 같은 구조이므로 변환하여 출력
		Set<String> names = votes.keySet(); //저장소에서 이름만 따로 모아서 넘겨준다
		System.out.println(names); //순서는 신경쓰지 않아도 된다.
		for(String name : names) {
			System.out.println("이름 : "+name);
			System.out.println("득표수 : "+votes.get(name));
		}
	}
}
