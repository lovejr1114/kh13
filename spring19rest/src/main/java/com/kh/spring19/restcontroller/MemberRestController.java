package com.kh.spring19.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		
		//비밀번호 비교
		boolean isValid = findDto.getMemberPw().equals(findDto.getMemberPw());
		if(isValid) { //MemberLoginVO(200) 성공
			String token = jwtService.create(findDto);
			
			return ResponseEntity.ok().body(MemberLoginVO.builder()
						.memberId(findDto.getMemberId())
						.memberLevel(findDto.getMemberLevel())
						.token(token)//JWT 토큰
					.build()); //200
		}
		else { //실패 - 파라미터가 오류(400)이거나 미인증(401)
			return ResponseEntity.status(401).build(); //401
		}
	}
}
