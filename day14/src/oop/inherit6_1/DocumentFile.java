package oop.inherit6_1;

//(주의) 상속은 1개 클래스만 가능
public class DocumentFile extends File {
	//추가 필드
	private int pageSize;
	
	public void setPageSize(int pageSize) {
		if(pageSize <= 0) return;
		this.pageSize = pageSize;
	}
	public int getPageSize() {
		return pageSize;
	}

	//생성자 -  페이지 크기를 지정하지 않으면 1, 지정 하는 것도 가능
	public DocumentFile(String filename) {
		super(filename);
		this.setPageSize(1);
	}
	public DocumentFile(String filename, int pageSize) {
		super(filename);
		this.setPageSize(pageSize);
	}
	
	public DocumentFile(String filename, long filesize) {
		super(filename, filesize);
		this.setPageSize(1);
	}
	public DocumentFile(String filename, long filesize, int pageSize) { //이게 지정
		super(filename, filesize);
		this.setPageSize(pageSize);
	}
	
}
