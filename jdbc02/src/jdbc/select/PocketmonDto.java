package jdbc.select;

//DTO
//- Data Transfer Object 의 줄임말
//- 한글로 말하면 "변환용 객체"
//- 선생님은 이걸 "포장 상자"라고 부른다
//- 테이블당 1개씩 테이블과 똑같이 생성
public class PocketmonDto {
	//필드 - DB의 컬럼명을 작성
	private int pocketmonNo;
	private String pocketmonName;
	private String pocketmonType;
	//필드를 만들고 추가로 setter / getter / 기본생성자(매개변수가 하나도 없는 생성자)를 구현
	public int getPocketmonNo() {
		return pocketmonNo;
	}
	public void setPocketmonNo(int pocketmonNo) {
		this.pocketmonNo = pocketmonNo;
	}
	public String getPocketmonName() {
		return pocketmonName;
	}
	public void setPocketmonName(String pocketmonName) {
		this.pocketmonName = pocketmonName;
	}
	public String getPocketmonType() {
		return pocketmonType;
	}
	public void setPocketmonType(String pocketmonType) {
		this.pocketmonType = pocketmonType;
	}
	public PocketmonDto() {
		super();
	}
	
}
