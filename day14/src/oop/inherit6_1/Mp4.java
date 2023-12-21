package oop.inherit6_1;

public class Mp4 extends MediaFile {
	//추가되는 필드를 정의
	private float speed;
	
	//setter & getter
	public void setSpeed(float speed) {
		if(speed <= 0f) return;
		this.speed = speed;
	}
	public float getSpeed() {
		return speed;
	}
	
	//생성자
	public Mp4(String filename) {
		super(filename);
		this.setSpeed(1f);
	}
	public Mp4(String filename, long filesize) {
		super(filename, filesize);
		this.setSpeed(1f); //속도는 설정을 안해도 된다
	}
	
	//information이 마음에 들지 않아... 왜 재생속도가 안나오지?
	//재정의(override)를 해서 내용을 바꿔보자
	public void information() {
		System.out.println("<파일 정보>");
		System.out.println("이름 : " + this.getFilename());
		System.out.println("크기 : " + this.getFilesize()+"바이트");
		//또 치기 싫으면 원래 있던 것을 불러오고 밑에 내용 추가해주기
//		super.information(); //근데 앞,뒤에만 가능하고 중간에 끼어넣기는 불가능
		System.out.println("배속 : x" + this.speed);
	}
	
}
