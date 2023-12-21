package oop.inherit6;

public class PapersFile {
	private String name;
	private int size;
	private int page;
	
	public PapersFile(String name, int size, int page) {
		this.setName(name);
		this.setSize(size);
		this.setPage(page);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public final void execute() {
		System.out.println("실행 기능");
	}
	public final void information() {
		System.out.println("정보 출력 기능");
	}
	
	
}
