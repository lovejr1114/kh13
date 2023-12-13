package array;

public class Test03배열생성2 {
	public static void main(String[] args) {
//		다음 정보를 저장할 수 있도록 배열을 만들고 데이터를 출력하세요
//		[1] 30, 50, 20, 10, 40
//		[2] 피카츄, 라이츄, 파이리, 꼬부기
//		[3] 177.1f, 182.3f, 160.5f, 157.9f, 180.1f, 163.6f
		
		int[] a = new int[] {30, 50, 20, 10, 40};
		
//		for(int i=0; i<5; i++) { //5칸이니까 5로 적으면 i<=4보다 조금 더 간결해짐
		for(int i=0; i<a.length; i++) { //a.lenght는 a배열의 길이(칸 수)
			System.out.println(a[i]);
		}
//		System.out.println(a[0]);
//		System.out.println(a[1]);
//		System.out.println(a[2]);
//		System.out.println(a[3]);
//		System.out.println(a[4]);	
		
		
		String[] b = new String[] {"피카츄", "라이츄", "파이리", "꼬부기"};
		
//		for(int i=0; i<=3; i++) {   또는   for(int i=0; i<4; i++) {
		for(int i=0; i<b.length; i++) {
			System.out.println(b[i]);
		}
//		System.out.println(b[0]);
//		System.out.println(b[1]);
//		System.out.println(b[2]);
//		System.out.println(b[3]);		
		
		
		
		float[] c = new float[] {177.1f, 182.3f, 160.5f, 157.9f, 180.1f, 163.6f};	
		
//		for(int i=0; i<=5; i++) {     or      for(int i=0; i<6; i++) {
		for(int i=0; i<c.length; i++ ) {
			System.out.println(c[i]);
		}
//		System.out.println(c[0]);
//		System.out.println(c[1]);
//		System.out.println(c[2]);
//		System.out.println(c[3]);
//		System.out.println(c[4]);
//		System.out.println(c[5]);			
	}

}
