package com.kh.spring18.websocket;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SimpleWebSocketServer extends TextWebSocketHandler {
	
	/*
	 * 사용자가 웹소켓 서버에 접속하면 자동 실행되는 메소드
	 * - WebSocketSession - 접속한 웹소켓 사용자의 정보 (HttpSession과 다름)
	 * - CloseStatus - 종료를 어떻게 했는지에 대한 정보
	 * */

	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.debug("접속");
		log.debug("session={}",session);
		
		//session을 이용하면 사용자에게 메세지를 보낼 수 있다
//		session.sendMessage(메세지객체);
//		TextMessage message = new TextMessage("어서오세요!");
		TextMessage message = new TextMessage(LocalDateTime.now().toString());
		session.sendMessage(message);
	}
	/*
	 * 사용자가 웹소켓 서버에서 접속 종료하면 자동 실행되는 메소드
	 * - WebSocketSession - 접속 종료한 웹소켓 사용자의 정보(HttpSession과 다름)
	 * */
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.debug("종료");
		log.debug("session={}",session);
		
		//사용자가 나간 뒤에 메세지를 보낼 수 있을까? => 절대 불가하다!
	}
	
	/*
	 * 사용자가 웹소켓 서버에 메세지를 보내면 실행되는 메소드
	 * - WebSocketSession - 메세지를 보낸 사용자 정보(HttpSession과 다름)
	 * -  TextMessage - 사용자가 보낸 메세지 객체
	 * */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.debug("사용자가 메세지를 보냈습니다.");
		log.debug("message={}",message);
		log.debug("payload ={}",message.getPayload());
		
		switch (message.getPayload()) {
		case "권서영":
			session.sendMessage(new TextMessage("탁"));
			break;
		case "권유정":
			session.sendMessage(new TextMessage("말진짜로"));
			break;
		case "이예림":
			session.sendMessage(new TextMessage("꺽정"));
			break;
		default:
			session.sendMessage(new TextMessage("ㅎㅎ"));
			break;
		}
	}
}
