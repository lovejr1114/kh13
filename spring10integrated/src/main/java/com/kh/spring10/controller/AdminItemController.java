package com.kh.spring10.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring10.dao.AttachDao;
import com.kh.spring10.dao.ItemDao;
import com.kh.spring10.dto.AttachDto;
import com.kh.spring10.dto.ItemDto;

@Controller
@RequestMapping("/admin/item")
public class AdminItemController {
	
	@Autowired
	private AttachDao attachDao;
	
	@Autowired
	private ItemDao itemDao;

	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/admin/item/add.jsp";
	}
	
	//Multipart 방식으로 전송되는 데이터는
	//application.properties에 몇 가지 설정을 한 뒤 자연스럽게 수신이 가능하다
	//(중요) 파일은 MultipartFile 형태로 수신한다
	@PostMapping("/add")
	public String add(@ModelAttribute ItemDto itemDto,
//								@RequestParam String itemName,
//								@RequestParam int itemPrice,
//								@RequestParam int itemCharge, //이 3개가 위 modelatt로...
								@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
//		System.out.println("itemName="+itemName);
//		System.out.println("itemPrice="+itemPrice);
//		System.out.println("itemCharge="+itemCharge);
//		System.out.println("isEmpty="+ attach.isEmpty());
		
		//충전상품 등록
		int itemNo = itemDao.getSequence();
		itemDto.setItemNo(itemNo);
		itemDao.insert(itemDto);
		
		if(!attach.isEmpty()) {//파일이 있으면
			System.out.println("파일명="+attach.getOriginalFilename());
			System.out.println("파일유형="+attach.getContentType());
			System.out.println("파일크기="+attach.getSize());
			
			//파일명을 대체하기 위한 시퀀스 생성
			int attachNo = attachDao.getSequence();
			
			//파일과 관련된 작업(저장 등..)을 구현
			//[1] 파일이 저장될 위치(디렉터리)를 정한다
			//[2] [1]번에서 정한 위치에 신규파일을 생성해야한다
			//[3] 사용자에게서 전송받은 파일의 내용을 [2]번 파일에 복사한다 (덮어쓰기)
			
			//[1]
//			File dir = new File("D:/upload"); //디렉터리 객체 생성
			File dir = new File(System.getProperty("user.home"), "upload");
			dir.mkdirs(); //실제 디렉터리 생성
			System.out.println("dir="+dir.getAbsolutePath()); //절대경로 위치
			
			//[2]
//			File target = new File(dir, attach.getOriginalFilename()); //파일 객체 생성
			File target = new File(dir, String.valueOf(attachNo)); //파일 객체 생성
			
			//[3]
			attach.transferTo(target); //파일 내용 복사
			
			//첨부파일 정보를 DB에 저장
			AttachDto attachDto = new AttachDto();
			attachDto.setAttachNo(attachNo);
			attachDto.setAttachName(attach.getOriginalFilename());//사용자가 올린 파일명
			attachDto.setAttachType(attach.getContentType());
			attachDto.setAttachSize(attach.getSize());
			
			attachDao.insert(attachDto);
			
			//연결
			itemDao.connect(itemNo, attachNo);
		}
		return "redirect:add";
	}
}
