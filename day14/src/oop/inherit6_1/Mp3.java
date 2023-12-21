package oop.inherit6_1;

public class Mp3 extends MediaFile {
	//추가 필드
	private int duration;
	
	//getter&setter
	public int getDuratuon() {
		return duration;
	}
	public void setDuratuon(int duratuon) {
		if(duration < 0) return;
		this.duration = duratuon;
	}
	

	//생성자
	public Mp3(String filename, int duration) {
		super(filename);
		this.setDuratuon(duration);
	}
	public Mp3(String filename, long filesize, int duration) {
		super(filename, filesize);
		this.setDuratuon(duration);
	}
	
	public String getDurationString() {
		if(this.duration < 60) {
		return this.duration + "초"; 
		}
		else if(this.duration < 60 * 60) {
			int min = duration / 60;
			int sec = duration % 60;
			return min + "분" + sec + "초";
		}
		else if(this.duration < 24* 60* 60) {
			int hour =  duration / 60 /60;
			int min = duration / 60 % 60;
			int sec = duration % 60;
		}
		return "매우 김";
	}
	
	//재정의를 통해 인포메이션 개조
	public void information() {
		System.out.println("<파일 정보>");
		System.out.println("이름 : " + this.getFilename());
		System.out.println("크기 : " + this.getFilesize()+"바이트");
//		System.out.println("재생 시간 : " + this.getDuratuon() + "초");
		System.out.println("재생 시간 : " +  this.getDurationString());
	}
}
