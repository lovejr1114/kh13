<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>나의 홈페이지</title>
	</head>
	<body>
		<%--
			상단 영역
			- 홈페이지에서 가장 많이 보이는 부분
			- 로고, 검색창, 각종 메뉴들을 배치
			- div는 투명한 영역
		 --%>
		
		<div>
			<%-- 템플릿 페이지는 무조건 절대경로를 써야한다 --%>
			<a href="/">홈으로</a>
			<a href="/pocketmon/list">포켓몬스터 시스템</a>
			<a href="/emp/list">사원관리 시스템</a>
			<a href="/menu/list">메뉴관리 시스템</a>	
		</div>
		<div>
			<a href="/member/join">회원가입</a>
			<a href="">로그인</a>
<!-- 			<a href="">로그아웃</a> -->
<!-- 			<a href="">내정보</a> -->
		</div>
		 <hr>
		<%--
			중단 영역
			- 실질적인 홈페이지의 내용이 표시되는 영역
			- 크기는 무제한으로 늘어날 수 있음
		 --%>
		 <div>