package oop.inherit6;

public class Test01객체생성 {
	public static void main(String[] args) {
		System.out.println("<MP4>");
		Mp4 m1 = new Mp4("love or die",111110,150);
		m1.outout();
		m1.execute();
		m1.forward();
		m1.rewind();
		m1.information();
		
		System.out.println("<MP3>");
		Mp3 m2 = new Mp3("Chill kill",444444,456);
		m2.outout();
		m2.execute();
		m2.forward();
		m2.rewind();
		m2.information();
		
		System.out.println("<HWP>");
		Hwp p1 = new Hwp("hwp 파일",567,7);
		p1.output();
		p1.execute();
		p1.perview();
		p1.information();
		
		System.out.println("<PPT>");
		Ppt p2 = new Ppt("ppt 파일",555,65);
		p2.output();
		p2.execute();
		p2.slideShow();
		p2.information();
	}
}
