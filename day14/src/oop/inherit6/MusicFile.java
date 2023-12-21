package oop.inherit6;

public class MusicFile {
	private String name;
	private int size;
	
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

	public MusicFile(String name, int size) {
		this.setName(name);
		this.setSize(size);
	}
	
	public final void execute() {
		System.out.println("실행 기능");
	}
	public final void forward() {
		System.out.println("빨리감기 기능");
	}
	public final void rewind() {
		System.out.println("되감기 기능");
	}
	public final void information() {
		System.out.println("정보출력 기능");
	}
	
	void outout() {
		System.out.println("파일 이름 : " + this.getName());
		System.out.println("파일 크기 : " + this.getSize());
	}
}
