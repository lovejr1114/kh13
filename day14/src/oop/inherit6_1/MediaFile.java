package oop.inherit6_1;

public class MediaFile extends File {

	//생성자는 상속받는 상위클래스에 맞춘다! (2개면 2개 다)
	public MediaFile(String filename) {
		super(filename);
	}
	public MediaFile(String filename, long filesize) {
		super(filename, filesize);
	}

	//추가되는 기능 정의
	public void forward() {
		System.out.println("10초 앞으로 이동");
	}
	public void rewind() {
		System.out.println("10초 뒤로 이동");
	}
	
}
