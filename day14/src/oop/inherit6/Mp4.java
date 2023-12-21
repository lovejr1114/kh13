package oop.inherit6;

public class Mp4 extends MusicFile {
	
	private int speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Mp4(String name, int size, int speed) {
		super(name, size);
		this.setSpeed(speed);
	}
	void outout() {
		System.out.println("파일 이름 : " + this.getName());
		System.out.println("파일 크기 : " + this.getSize());
		System.out.println("재생속도 : " + this.getSpeed());
	}
}
