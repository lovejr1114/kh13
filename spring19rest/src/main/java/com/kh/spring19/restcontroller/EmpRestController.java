package com.kh.spring19.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring19.dao.EmpDao;
import com.kh.spring19.dto.EmpDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="사원 정보 관리 도구", description = "설명")

@CrossOrigin
@RestController
@RequestMapping("/emp")
public class EmpRestController {

	@Autowired
	private EmpDao empDao;
	
	//문서용 설정 추가
	@Operation(
			description = "사원 목록 조회",
			responses = {
					//성공, 실패에 대한 정보를 주겠다
					@ApiResponse(
						responseCode = "200",
						description = "조회 성공",
						content= {
							@Content(
								mediaType="application/json",
								array = @ArraySchema( //배열일 땐 어레이스키마
									schema = @Schema(implementation = EmpDto.class)
								) //EmpDto가 담긴 배열이야
							)
						}
					),
					@ApiResponse(
						responseCode = "500",
						description = "서버 오류",
						content = {
							@Content(
								mediaType = "text/plain",
								schema = @Schema(implementation = String.class),
								examples = @ExampleObject("server error")
							)
						}
					)
			}
	)
	
	
	
	//조회
	@GetMapping("/")
	public List<EmpDto> list(){
		return empDao.selectList();
	}
	
	//등록
	@PostMapping("/")
	public void insert(@RequestBody EmpDto empDto) {
		empDao.insert(empDto);
	}
	
	//전체 수정
	@PutMapping("/")
	public boolean editAll(@RequestBody EmpDto empDto) {
		return empDao.update(empDto);
	}
	
	//일부 수정
	@PatchMapping("/")
	public boolean editUnit(@RequestBody EmpDto empDto) {
		boolean result = empDao.update(empDto);
		return result;
	}
	
	//삭제
	@DeleteMapping("/{empNo}")
	public boolean delete(@PathVariable int empNo) {
		return empDao.delete(empNo);
	}
	
	//상세
//	@GetMapping("/{empNo}")
//	public EmpDto find(@PathVariable int empNo) {
//		EmpDto empDto = empDao.selectOne(empNo);
//		return empDto;
//	}
	//조회되지 않는 경우 (null인 경우)는 404번으로 처리하고싶다면
	//수동으로 반환 값 처리할 수 있도록 해야한다.
	@GetMapping("/{empNo}")
	public ResponseEntity<EmpDto> find(@PathVariable int empNo){
		EmpDto empDto = empDao.selectOne(empNo);
		if(empDto == null) {
			//사용자에게 404를 보낸다
//			return ResponseEntity.notFound().build();
			return ResponseEntity.status(404).build(); //404의 다른말이 notFound, 둘이 같은 코드
		}
//		return ResponseEntity.ok(empDto); //성공했을 경우
		return ResponseEntity.status(200).body(empDto);
	}
}
