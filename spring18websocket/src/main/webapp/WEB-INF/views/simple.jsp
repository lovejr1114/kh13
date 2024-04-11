<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>Simple 웹소켓</h1>

<button class="btn-connect">연결</button>
<button class="btn-disconnect">종료</button>


<!--  JS처리 -->
<!-- jquery CDN -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".btn-connect").click(function(){
			window.socket = new WebSocket("ws://localhost:8080/ws/simple");
		});
		
		$(".btn-disconnect").click(function(){
			window.socket.close();
		});
	});
</script>