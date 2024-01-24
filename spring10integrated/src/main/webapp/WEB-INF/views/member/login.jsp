<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>로그인</h1>

<c:if test="${param.error != null}">
	<h3 style="color:red">로그인 정보가 일치하지 않습니다.</h3>
</c:if>


<form action="login" method="post">
	아이디 <input name="memberId" type="text" required placeholder="소문자,숫자 8~20자"> <br><br>
	비밀번호 <input name="memberPw" type="password" required placeholder="영문대소문자,숫자,특수문자 6~15자"> <br><br>
	<button>로그인</button>
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>