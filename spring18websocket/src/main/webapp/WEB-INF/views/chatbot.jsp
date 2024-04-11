<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<h1>챗봇 예제</h1>

<button class="btn-connect">연결</button>
<button class="btn-disconnect">종료</button>

<hr>

<div class="question-wrapper"></div>

<!-- jquery CDN -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".btn-connect").click(function(){
		window.socket = new WebSocket("ws://localhost:8080/ws/chatbot");
		
		//웹소켓을 생성하고 나서 예상되는 각종 상황에 대해 미리 콜백함수를 정의
		//(콜백함수 : 예약함수)
		//- onopen (연결완료시), onclose(연결종료시), onerror(오류발생시)
		//- onmessage(메세지수신시)
		window.socket.onmessage = function(e){
			//console.log(e.data); //서버에서 전송된 내용(문자열)
			
			//해석
			var json = JSON.parse(e.data); //자바스크립트 스타일로 해석
			//console.log(json);
			
			//json에 들어있는 데이터 개수만큼 버튼을 생성하여 추가하겠다.
			$(".question-wrapper").empty();
			$(json).each(function(){ //jQuery 반복문
				//console.log(this);
				var button = $("<button>").text(this.chatbotQuestion)
														.addClass("btn-question");
				$(".question-wrapper").append(button);
			});
		}
	});
	$(".btn-disconnect").click(function(){
		window.socket.close();
	});
});
</script>