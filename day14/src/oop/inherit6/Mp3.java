package oop.inherit6;

public class Mp3 extends MusicFile {
	
	private int duration;
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Mp3(String name, int size, int duration) {
		super(name, size);
		this.setDuration(duration);
	}
	void outout() {
	System.out.println("파일 이름 : " + this.getName());
	System.out.println("파일 크기 : " + this.getSize());
	System.out.println("재생 시간 : " + this.getDuration());
	}
}
