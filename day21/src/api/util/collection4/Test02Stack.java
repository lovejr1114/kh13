package api.util.collection4;

import java.util.Stack;

public class Test02Stack {
	public static void main(String[] args) {
		//Stack (스택)
		//- LIFO(Last-In-First-Out) 구조
		//- 데이터를 최신순으로 관리
		
		Stack<String> stack = new Stack<String>();
		
		//데이터 추가 - push() '밀어넣는다'
		stack.push("뽀로로");
		stack.push("크롱");
		stack.push("루피");
		stack.push("패티");
		
		//데이터 확인 - peek()
		System.out.println("현재 차례 = "+stack.peek());
		
		//데이터 삭제 - pop() 뒤로가기버튼 누르는거 (컨트롤+z)
		stack.pop();//패티 out
		stack.pop(); //루피 out
		System.out.println("현재 차례 = "+stack.peek());
	}
}
