package oop.method9_1;

public class Account {
	String name;
	double baseRate;
	double preRate;
	int monthly;
	int deposit;
	
	void data(String name, double baseRate, double preRate, int monthly, int deposit) {
		this.name = name;
	}
	
	void information() {
		System.out.println("예금주 : " + this.name);
	}
}
