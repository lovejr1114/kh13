package com.kh.spring19.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring19.dao.MemberDao;
import com.kh.spring19.dto.MemberDto;
import com.kh.spring19.service.JwtService;
import com.kh.spring19.vo.MemberLoginVO;

@CrossOrigin
@RestController
@RequestMapping("/member")
public class MemberRestController {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/login")
	public ResponseEntity<MemberLoginVO> login(@RequestBody MemberDto memberDto){
		//아이디로 정보 조회
		MemberDto findDto = memberDao.selectOne(memberDto.getMemberId());
		if(findDto == null) { //아이디가 없으면 (404)
			return ResponseEntity.notFound().build(); //404
		}
		
		//비밀번호 비교 (암호화가 있다면 코드가 달라질 수 있음)
		boolean isValid = findDto.getMemberPw().equals(findDto.getMemberPw());
		
		if(isValid) { //MemberLoginVO(200) 성공
			String accessToken = jwtService.createAccessToken(findDto);
			String refreshToken = jwtService.createRefreshToken(findDto);
			
			return ResponseEntity.ok().body(MemberLoginVO.builder()
						.memberId(findDto.getMemberId()) //회원 아이디
						.memberLevel(findDto.getMemberLevel()) //회원 등급
						.accessToken(accessToken)//JWT 토큰
						.refreshToken(refreshToken) //JWT 토큰
					.build()); //200
		}
		else { //실패 - 파라미터가 오류(400)이거나 미인증(401)
			return ResponseEntity.status(401).build(); //401
		}
	}
	
	//refresh token으로 로그인하는 매핑
	//- header에 있는 Authorization이라는 항목을 읽어 해석한 뒤 결과를 반환
	//- 토큰이 만료되었다면 (잘못된 토큰 / 시간 지남/ ...) 401(미인증)  반환
	public ResponseEntity<MemberLoginVO> refresh(@RequestHeader("Authorization") String refreshToken){
		try {
			MemberLoginVO loginVO = jwtService.parse(refreshToken);
			//loginVO에 있는 정보가 실제 DB와 일치하는지 추가적으로 조회
			MemberDto memberDto = memberDao.selectOne(loginVO.getMemberId());
			if(memberDto == null) {//존재하지 않는 아이디
				throw new Exception("존재하지 않는 아이디");
			}
			if(loginVO.getMemberLevel().equals(memberDto.getMemberLevel())) {
				throw new Exception("정보 불일치");
			}
			//위에서 필터링 되지 않았다면 refresh token이 유효하다고 볼 수 있다
			//-> 사용자에게 새롭게 access token을 발급한다
			//-> 보안을 위해서 refresh token도 재발급한다
			String accessToken = jwtService.createAccessToken(memberDto);
			String newRefreshToken = jwtService.createRefreshToken(memberDto);
			return ResponseEntity.ok().body(MemberLoginVO.builder()
						.memberId(memberDto.getMemberId())
						.memberLevel(memberDto.getMemberLevel())
						.accessToken(accessToken)
						.refreshToken(newRefreshToken)
					.build());
		}
		catch(Exception e) {//잘못된 토큰
			return ResponseEntity.status(401).build();
		}
	}
}
