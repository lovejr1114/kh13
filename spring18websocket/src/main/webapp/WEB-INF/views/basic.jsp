<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>Basic 웹소켓 예제</h1>

<button class="btn-connect">연결</button>
<button class="btn-disconnect">종료</button>


<!--  JS처리 -->
<!-- jquery CDN -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	//연결 버튼을 누르면 웹소켓 생성, 종료 버튼을 누르면 웹소켓 소멸
	$(".btn-connect").click(function(){
		//WebSocket은 기본 제공하는 기능
    	//최상위 객체인 window를 사용하여 어디서든 접근 가능하게 설정
		//var socket = new WebSocket("연결주소");
		window.socket = new WebSocket("ws://localhost:8080/ws/basic");
		//앞의 프로토콜이 ws로 다르기 때문에 주소를 다 적어주어야 한다
	});
	$(".btn-disconnect").click(function(){
        window.socket.close();
    });
});
</script>