package data;

public class Test03영화관 {
	public static void main(String[] args) {
		int adultPrice = 12000;
		int teenPrice = 8500;
		int adultPerson = 2;
		int teenPerson = 2;
		
		int adultTotal = adultPrice * adultPerson;
		int teenTotal = teenPrice * teenPerson;
		int total = adultTotal + teenTotal;
		System.out.println(adultTotal);
		System.out.println(teenTotal);
		System.out.println(total);
	}

}
