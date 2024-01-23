<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>로그인</h1>

<form action="login" method="post">
	아이디 <input name="memberId" type="text" required placeholder="소문자,숫자 8~20자"> <br><br>
	비밀번호 <input name="memberPw" type="password" required placeholder="영문대소문자,숫자,특수문자 6~15자"> <br><br>
	<button>로그인</button>
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>