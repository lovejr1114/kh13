package api.lang.string2;

public class Test04둘중하나 {
	public static void main(String[] args) {
		
//		String greet = "hello";
//		
//		String regex = "^(hello|hi)$"; //hello 또는 hi만 가능
		
		String greet = "hello Tom";
		
		String regex = "^(hello\\s(Tom|Jerry)|hi\\s(Bob|Jack))$";
		//hello Tom(Jerry) 또는 hi Bob(Jack)만 가능
			
			
		System.out.println(greet.matches(regex));
	}
}
