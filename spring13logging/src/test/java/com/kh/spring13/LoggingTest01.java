package com.kh.spring13;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class LoggingTest01 {
	
	//로거(Logger)는 로그 메세지를 출력하기 위한 도구이다
	//파일마다 생성해야 하는 것이 원칙
	//어떤 기술(Log4J, Logback, ..)을 쓰더라도 Slf4J로 보관하여 사용
//	Logger log = LoggerFactory.getLogger(LoggingTest01.class);
	
	//롬복을 사용할 경우 클래스 상단에 @Slf4J라고 작성하면 자동생성됨

	@Test //junit거
	public void test() {
		//로깅의 수준(Level)은 총 6단계가 존재
		//[TRACE] → [DEBUG] → [INFO] → [WARN] → [ERROR] → [FATAL] 페이탈은 제일 치명적
		//- TRACE는 프로그램의 모든 과정에 대한 기록
		//- DEBUG는 개발 과정에서의 확인 메세지
		//- INFO는 처리와 관련된 정보 메세지
		//- WARN은 잠재적 위험요소에 대한 경고 메세지
		//- ERROR는 기능이 중단되는 경우에 대한 메세지(예외)
		//- FATAL은 서버가 중단되는 경우에 대한 메세지 (프로그램이 뻗었을 때)
		
//		System.out.println("김정은");
		log.debug("디버그 메세지"); 
		log.info("인포 메세지");
		log.warn("경고 메세지");
		log.error("오류 메세지");
	}
}
