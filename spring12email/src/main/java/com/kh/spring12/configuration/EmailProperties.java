package com.kh.spring12.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

//application.properties에 작성된 custom.email.어쩌구 설정을 담아두는 파일
@Service
@ConfigurationProperties(prefix = "custom.email")
//위에 경고 뜨는 것은 "너 커스텀속성 썼네? 근데 기술상 밑줄을 못없애줘. 밑줄없애고싶으면 pm.xl에 뭐 하나 추가해! 하면서 알림창에거 눌러준다
public class EmailProperties {
	private String id;
	private String pw;
	//'어쩌구'에 해당하는 부분을 필드로 만들고 세터/게터도.
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	

}
