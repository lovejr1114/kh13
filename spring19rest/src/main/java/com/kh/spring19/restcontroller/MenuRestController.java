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

import com.kh.spring19.dao.MenuDao;
import com.kh.spring19.dto.MenuDto;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="메뉴", description="메뉴 정보!!")

@CrossOrigin
@RestController
@RequestMapping("/menu")
public class MenuRestController {

	@Autowired
	private MenuDao menuDao;
	
	//등록
	@PostMapping("/")
	public MenuDto insert(@RequestBody MenuDto menuDto) {
		//시퀀스 번호 생성
		int sequence = menuDao.sequence();
		menuDto.setMenuNo(sequence); //시퀀스로 번호 세팅
		menuDao.add(menuDto); //등록		
		return menuDao.selectOne(sequence);
	}
	
	//조회
	@GetMapping("/")
	public ResponseEntity<List<MenuDto>> list(){
		List<MenuDto> list = menuDao.selectList();
		return ResponseEntity.ok().body(list);
	}
	//상세 조회
	@GetMapping("/{menuNo}")
	public ResponseEntity<MenuDto> find(@PathVariable int menuNo){
		MenuDto menuDto = menuDao.selectOne(menuNo);
		if(menuDto == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok().build();
		}
	}
	
	//수정
	@PutMapping("/")
	public ResponseEntity<?> editAll(@RequestBody MenuDto menuDto) {
		boolean result = menuDao.editAll(menuDto);
		if(result == false) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok().build();
		}
	}
	@PatchMapping("/")
	public ResponseEntity<?> editUnit(@RequestBody MenuDto menuDto){
		boolean result = menuDao.editUnit(menuDto);
		if(result ==false) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok().build();
		}
	}
	//삭제
	@DeleteMapping("/{menuNo}")
	public ResponseEntity<?> delete(@PathVariable int menuNo) {
		boolean result = menuDao.delete(menuNo);
		if(result == false) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok().build();
		}
	}
}
