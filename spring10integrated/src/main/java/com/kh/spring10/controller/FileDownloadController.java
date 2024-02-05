package com.kh.spring10.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring10.dao.AttachDao;
import com.kh.spring10.dto.AttachDto;

@Controller
@RequestMapping("/download")
public class FileDownloadController {
	
	@Autowired
	private AttachDao attachDao;
	
	//여태까지 모든 컨트롤러에서는 사용자가 볼 화면을 반환했다.
	//이 매핑은 그렇지 않다는 것을 표시해야한다 (@ResponseBody)
	//사용자에게는 화면이 아닌 파일이 담긴 응답 객체를 반환
	//- ByteArrayResource가 파일의 내용을 말함
	//- ResponseEntity가 사용자에게 보내질 응답 객체를 말함
	//파일 테이블의 기본키(attachNo)를 전달받아 해당하는 파일을 사용자에게 반환
	
	@RequestMapping //주소가 없으므로 클래스 위에 있는 주소가 기본으로 되며, 단 이 것은 하나밖에 만들 수 없음
	@ResponseBody //내가 지금 너한테 화면을 안보여준다는 뜻
	public ResponseEntity<ByteArrayResource> download(
				@RequestParam int attachNo) throws IOException {
		
		//1. attachNo로 파일 정보(AttachDto)를 불러온다
		AttachDto attachDto = attachDao.selectOne(attachNo);
		
		//2. attachDto가 없으면 404 처리
		if(attachDto == null) {
//			return ResponseEntity.notFound(404).build();
			return ResponseEntity.notFound().build();
		}
		
		//3. 실제 파일을 불러온다. (apache commons io, apache commons fileupload)
		File dir = new File(System.getProperty("user.home"), "upload");
		File target = new File(dir, String.valueOf(attachDto.getAttachNo())); //파일명은 절대 문자일수없다 그래서 String.valueOf해줌
		
		byte[] data = FileUtils.readFileToByteArray(target); //파일을 읽어라. (만약 이게 없으면 반복문으로 읽어야함)
		ByteArrayResource resource = new ByteArrayResource(data); //포장
		
		//4. attachDto에 있는 정보와 실제파일(3번) 정보를 조합하여 사용자에게 반환하겠다		
		//- 추가적인 정보를 제공해서 파일 다운로드 처리가 일어나도록 구현
		//- 추가적인 정보는 header에 설정
//		return ResponseEntity.status(200).body(내용(실제파일));
//		return ResponseEntity.ok()
//				.header("이름","값")
//				.header("Content-Encoding","UTF-8")
//				.header("Content-Type",attachDto.getAttachType()) //파일 유형
//				.header("Content-Type", "application/octet-stream") //무조건 다운로드
//				.header("Content-Length", String.valueOf(attachDto.getAttachSize()))
//				.header("Content-Disposition","attachment; filename=\""+attachDto.getAttachName())// 세미콜론은 구분해주는 코드
//				.body(resource);
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_ENCODING, StandardCharsets.UTF_8.name())
//				.header(HttpHeaders.CONTENT_TYPE, attachDto.getAttachType())
				.contentType(MediaType.APPLICATION_OCTET_STREAM) //무조건 다운로드
				.contentLength(attachDto.getAttachSize())
				.header(HttpHeaders.CONTENT_DISPOSITION, 
					ContentDisposition.attachment()
						.filename(attachDto.getAttachName(), StandardCharsets.UTF_8)
						.build().toString()
				)
				.body(resource);
	}
}
