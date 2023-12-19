package oop.constructor2;

public class Music {
	private String title;
	private String singer;
	private int play;
	private int good;
	
	String getTitle() {
		return title;
	}
	void setTitle(String title) {
		this.title = title;
	}
	String getSinger() {
		return singer;
	}
	void setSinger(String singer) {
		this.singer = singer;
	}
	int getPlay() {		
			return play;
	}
	void setPlay(int play) {
		if(play >= 0) {
		this.play = play;
		}
	}
	int getGood() {
		return good;
	}
	void setGood(int good) {
		if(play >= 0) {
		this.good = good;
		}
	}
	
	
	//
	boolean getPlayBest() {
		if(play >= 100000) {
			return true;
		}
		else {
			return false;
		}
	}
	boolean getGoodBest() {
		if(good >= 100000) {
			return true;
		}
		else {
			return false;
		}
	}
	int getRanking() {
		return getPlay() * 2 + getGood() / 2;
	}
	
	
	//생성자
	Music(String title, String singer, int play, int good){
		this.setTitle(title);
		this.setSinger(singer);
		this.setPlay(play);
		this.setGood(good);
	}

	
	void information() {
		if(this.getPlayBest() && this.getGoodBest()) {
			System.out.println("노래제목 : " + this.title +" (베스트) (인기곡)");
		}
		else if(this.getPlayBest()) {
			System.out.println("노래제목 : " + this.title +" (베스트)");
		}
		else if(this.getGoodBest()) {
			System.out.println("노래제목 : " + this.title +" (인기곡)");
		}
		else {			
			System.out.println("노래제목 : " + this.title);
		}
		System.out.println("가수 : " + this.singer);
		System.out.println("재생 수 : " + this.play);
		System.out.println("좋아요 수 : " + this.good);
		System.out.println("랭킹포인트 : " +this.getRanking()+"점");
		System.out.println();
	}
}
