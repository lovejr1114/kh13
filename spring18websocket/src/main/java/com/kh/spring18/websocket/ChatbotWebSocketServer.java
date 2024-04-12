package com.kh.spring18.websocket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring18.dao.ChatbotDao;
import com.kh.spring18.dto.ChatbotDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChatbotWebSocketServer extends TextWebSocketHandler { //상속은 클래스로 받는게 편하지만 클래스는 상속이 하나밖에 안된다. (이미 다른걸 상속받고 있으면 상속이 안됨)
	
	@Autowired
	private ChatbotDao chatbotDao;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//사용자가 접속하면 모든 질문 목록을 사용자에게 전송
		//(모든 질문 목록 → List<ChatbotDto> → JSON(클라이언트가 알아들을 수 있게))
		
		//일단 목록 조회
		List<ChatbotDto> list = chatbotDao.selectList();
		
		//목록으로 JSON 문자열 생성(수동)
		ObjectMapper mapper = new ObjectMapper(); //JSON 변환도구
		String json = mapper.writeValueAsString(list); 
		
		//메세지 객체 생성
		TextMessage message = new TextMessage(json); //문자열만 들어갈 수 있다. (JSON으로 바꾼다)
		
		//전송
//		session.sendMessage(질문목록이 담긴 메세지 객체);
		session.sendMessage(message);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//사용자가 보내는 메세지를 받아서 처리하는 메소드
		//- 사용자는 질문번호를 보낸다
		//- 질문번호를 받아서 상세조회한 뒤 나오는 정보를 전송하면 된다.
//		int chatbotNo = message.getPayload(); //안들어간다. 이유는 문자열이기 때문에
		int chatbotNo = Integer.parseInt(message.getPayload()); //문자열을 숫자로... 인티저 파스인트
		ChatbotDto chatbotDto = chatbotDao.selectOne(chatbotNo); //조회
		
		//목록으로 JSON 문자열 생성(수동)
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(chatbotDto); //JSON 변환
		
		TextMessage response = new TextMessage(json); //규격에 맞게 포장
		session.sendMessage(response); //웹소켓이라는건 정해진 규격이 잇음. 그래서 chatbotDto가 안들어감
	}
}
