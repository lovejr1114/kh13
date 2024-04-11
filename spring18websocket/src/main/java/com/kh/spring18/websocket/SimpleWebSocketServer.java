package com.kh.spring18.websocket;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SimpleWebSocketServer extends TextWebSocketHandler {

	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.debug("접속");
	}
	
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.debug("종료");
	}
}
