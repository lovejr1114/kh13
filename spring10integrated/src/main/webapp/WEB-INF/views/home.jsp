<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
 	HTML은 여러 버전이 있었으며, 지금은 HTML 5가 표준
 	- 디자인과 관련된 요소를 많이 제거하고 다른 언어들과의 화합을 고려
 	- 자체적으로 제공하는 컴포넌트(화면 도구)를 많이 늘렸음
 	
 	<!DOCTYPE html> 은  HTML5임을 표시하는 것
 	
 	<html>은 HTML 문서의 범위를 정하는 태그 (없으면 자동으로 생김)
 	<html>은 <head>와 <body>로 나뉜다
 	<head>에는 문서의 정보를 작성하고 <body>에는 화면에 표시할 내용을 작성
 	
 	<meta>는 홈페이지의 정보를 설정하는 태그
 	<title>은 문서의 제목이며 브라우저의 탭 부분에 표시됨
  --%>
 

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-600">
	<div class="cell center">
		<h1>환영합니다!</h1>
	</div>
	<div class="cell">
		<img src="https://via.placeholder.com/600x400">
	</div>
</div>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
