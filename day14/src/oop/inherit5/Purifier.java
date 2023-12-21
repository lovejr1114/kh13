package oop.inherit5;

public class Purifier {
	private String company;
	private int price;
	
	public Purifier(String company, int price) {
		this.setCompany(company);
		this.setPrice(price);
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
			this.company = company;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price >= 0) {
		this.price = price;
		}
	}
	
	public final void nomal() {
		System.out.println("정수 1잔");
	}
}
