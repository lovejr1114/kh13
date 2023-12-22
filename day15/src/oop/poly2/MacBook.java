package oop.poly2;

public class MacBook extends NoteBook {
	
	@Override
	public void power() {
		System.out.println("맥북의 전원 기능 실행");
	}

	@Override
	public void video() {
		System.out.println("맥북의 동영상 재생 기능 실행");
	}

	@Override
	public void typing() {
		System.out.println("맥북의 타이핑 기능 실행");
	}

}
