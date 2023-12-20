package oop.keyword6;

public class GameScreen {
	private final int width;
	private final int height;
	private String title;
	

	//생성자
	
	public GameScreen(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.setTitle(title);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

	public int getResolution() {
		return this.width * this.height;
	}
	

	void information() {
		System.out.println("<게임화면 정보>");
		System.out.println("타이틀 : " + this.getTitle());
		System.out.println("해상도 : " + this.getResolution()
		+" ("+this.width+" x "+this.height+")" );
	}
}
