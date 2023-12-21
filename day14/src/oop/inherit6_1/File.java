package oop.inherit6_1;

public class File {
	//필드
	private String filename;
	private long filesize;
	
	//생성자
	public File(String filename) { //파일 이름은 무조건 있어야 하니까.
		this(filename, 0L);
	}
	public File(String filename, long filesize) {
		this.setFilename(filename);
		this.setFilesize(filesize);
	}
	
	
	//setter / getter
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		if(filesize < 0L) return; //파일에 조건이 걸어져있다면!
		this.filename = filename;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	
	//메소드
	public void execute() {
		System.out.println(this.filename + "파일 실행");
	}
	public void information() {
		System.out.println("<파일 정보>");
		System.out.println("이름 : " + this.filename);
		System.out.println("크기 : " + this.filesize+"바이트");
	}
	
}
