package oop.modifier1_1;

public class Test01 {
	public static void main(String[] args) {
		Book a = new Book();
		
		a.data("마흔에 읽는 쇼펜하우어", "강용수", 15300, 850);
		
		//만약 페이지를 900으로 변경하려면
		a.setPage(-900); // setter메소드를 사용
		
		a.information();
		
		Book b = new Book();
		b.data("트렌드 코리아 2024", "김난도 외", 17100, 950);
		
		//(Q) a와 b의 가격차이는?  -> 게터메소드로 설정해서 해주면 가능하다.
		System.out.println(a.getPrice() - b.getPrice());
	}
}
