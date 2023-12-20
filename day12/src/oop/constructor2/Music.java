package oop.constructor2;

public class Music {
	private String title;
	private String singer;
	private long play;
	private int good;
	
	String getTitle() {
		return this.title;
	}
	void setTitle(String title) {
		this.title = title;
	}
	String getSinger() {
		return this.singer;
	}
	void setSinger(String singer) {
		this.singer = singer;
	}
	long getPlay() {		
			return this.play;
	}
	void setPlay(long play) {
		if(play >= 0L) {
		this.play = play;
		}
	}
	int getGood() {
		return this.good;
	}
	void setGood(int good) {
		if(play >= 0) {
		this.good = good;
		}
	}
	
	
	//
	String getPlayBest() {
		if(play >= 100000L) {
			return "(베스트)";
		}
			return "";
	}
	String getGoodBest() {
		if(good >= 100000) {
			return "(인기곡)";
		}
		else {
			return "";
		}
	}
	long getRanking() {
		return getPlay() * 2 + getGood() / 2;
	}
	
	
	//생성자
	Music(String title, String singer){
		this(title, singer, 0, 0);	
	}
	
	Music(String title, String singer, long play, int good){
		this.setTitle(title);
		this.setSinger(singer);
		this.setPlay(play);
		this.setGood(good);
	}

	
	void information() {
		System.out.println("노래제목 : " + this.title + this.getPlayBest()+ this.getGoodBest());
		System.out.println("가수 : " + this.singer);
		System.out.println("재생 수 : " + this.play +"회");
		System.out.println("좋아요 수 : " + this.good +"개");
		System.out.println("랭킹포인트 : " +this.getRanking()+"점");
		System.out.println();
	}
}
