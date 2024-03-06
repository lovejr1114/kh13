<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<form action="login" method="post" autocomplete="off">
<div class="container w-400">
	<div class="cell center"><h1>로그인</h1></div>
	<div class="cell">
		<label>아이디</label>
		<input type="text" name="memberId" required class="tool w-100">
	</div>
	<div class="cell">
		<label>비밀번호</label>
		<input type="password" name="memberPw" required class="tool w-100">
	</div>
	<div class="cell my-30">
		<button class="btn positive w-100">로그인</button>
	</div>
	<hr>
	<div class="cell center">
		<div class="cell">
			<a href="#" class="link">아이디 찾기</a>
		</div>
		<div class="cell">
			<a href="#" class="link">비밀번호 찾기</a>
		</div>
	</div>
	<c:if test="${param.error != null}">
	<div class="cell center">
		<h3 style="color:red">로그인 정보가 일치하지 않습니다</h3>
	</div>
	</c:if>
</div>
		
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>