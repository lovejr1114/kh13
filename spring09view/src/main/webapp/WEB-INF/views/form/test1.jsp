<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>폼 예제</h1>

<%--
	<form>
	- 정보를 제출하기 위한 도구 모음 (주소를 생성하는 도구)
	- 화면에 보이지 않음
	- action 속성으로 제출할 대상을 설정할 수 있다
	<input>
	- 입력을 위한 도구
	- 입력한 값이 전송될 때 파라미터의 이름을 name 속성으로 설정
	<button>
	- 폼(form)을 전송 시키는 도구
--%>
<h3>지니뮤직 검색창</h3>
<form action="https://genie.co.kr/search/searchMain">
	<input name="query">
	<button>검색</button>
</form>

<h3>마켓컬리 검색창</h3>
<form action="https://www.kurly.com/search">
	<input name="sword">
	<button title="검색"><img width="20" height="20" src="/search_icon.png"></button>
</form>