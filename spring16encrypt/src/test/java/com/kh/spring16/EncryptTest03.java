package com.kh.spring16;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EncryptTest03 {

	@Test
	public void test() {
		//단방향 암호화
		//- 의도적으로 데이터에 손실이 발생하도록 계산하여 복원이 안되도록 암호화하는 기술
		//- 복원은 안되지만 비교는 가능하도록 계산한다
		
		//(중요)
		//- 단방향 암호화에서는 절대로 충돌(collision)이 발생하면 안된다
		//- 의도적으로 숫자를 매우 크게 키워서 충돌을 피하고자 노력한다
		//- SHA(Secure Hash Algorithm), BCrypt, SCrypt, RSA(공개키), ...
		
		int origin = 7;
		
//		int result = (origin + 5) % 10; //충돌 발생
		//위 계산식으로 했을 때 origin에 7, 17, 27을 넣으면 같은 값이 나온다. 이것은 잘못된 방법이다.
		
		int result = (origin * 1234567 + 9876543) % 10000000;
		
//		log.debug("origin = {}", origin);
		log.debug("result = {}", result);
	}
}
