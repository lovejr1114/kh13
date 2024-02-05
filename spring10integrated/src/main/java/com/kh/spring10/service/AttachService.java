package com.kh.spring10.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring10.dao.AttachDao;
import com.kh.spring10.dto.AttachDto;

@Service
public class AttachService {
	
	@Autowired
	private AttachDao attachDao;
	
	//파일 저장 + DB 저장
	public int save(MultipartFile attach) throws IllegalStateException, IOException {
		int attachNo = attachDao.getSequence(); //시퀀스 생성
		File dir = new File(System.getProperty("user.home"), "upload");
		dir.mkdirs(); //폴더가 없다면 생성 (있으면 Pass)
		File target = new File(dir, String.valueOf(attachNo));
		attach.transferTo(target); //실물 파일 저장
		
		AttachDto attachDto = new AttachDto();
		attachDto.setAttachNo(attachNo);
		attachDto.setAttachName(attach.getOriginalFilename());
		attachDto.setAttachType(attach.getContentType());
		attachDto.setAttachSize(attach.getSize());		
		
		attachDao.insert(attachDto); //DB저장
		
		return attachNo;
	}
	
	//파일 삭제 + DB 삭제
	public void remove(int attachNo) {
		//실제 파일 삭제
		File dir = new File(System.getProperty("user.home"), "upload");
		File target = new File (dir, String.valueOf(attachNo));
		target.delete();
		attachDao.delete(attachNo); //파일 정보 지우고
		return ;
	}
	
}
