<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>Simple 웹소켓 예제</h1>

<button class="btn-connect">연결</button>
<button class="btn-disconnect">종료</button>

<hr>

<!-- 누르면 전송되는 버튼을 배치 -->
<button class="btn-word">권서영</button>
<button class="btn-word">권유정</button>
<button class="btn-word">이예림</button>


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
		
		//단어버튼을 누르면 서버로 메세지를 전송한다
		$(".btn-word").click(function(){
			//window.socket.send(메세지);
			var text = $(this).text(); //버튼에 써있는 글자를 불러와서
			window.socket.send(text); //서버로 전송!
		});
	});
</script>