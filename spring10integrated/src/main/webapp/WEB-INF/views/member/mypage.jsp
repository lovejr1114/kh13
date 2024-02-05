<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>마이페이지</h1>
<hr>
<h2>${sessionScope.loginId} 님의 회원 정보</h2>

<img src="image" width="200" height="200"><br>

<table border="1" width="400">
	<tr>
		<th>닉네임</th>
		<td>${memberDto.memberNick}</td>
	</tr>
	<tr>
		<th>연락처</th>
		<td>${memberDto.memberContact}</td>
	</tr>
	<tr>
		<th>생년월일</th>
		<td>${memberDto.memberBirth}</td>
	</tr>
	<tr>
		<th>E-mail</th>
		<td>${memberDto.memberEmail}</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>
			[${memberDto.memberPost}]
			${memberDto.memberAddress1}
			${memberDto.memberAddress2}
		</td>
	</tr>
	<tr>
		<th>회원등급</th>
		<td>${memberDto.memberLevel}</td>
	</tr>
	<tr>
		<th>포인트</th>
		<td>${memberDto.memberPoint} Point</td>
	</tr>
	<tr>
		<th>가입일</th>
		<td>
			<fmt:formatDate value="${memberDto.memberJoin}" 
									pattern="y년 M월 d일 H시 m분 s초"/>
		</td>
	</tr>
	<tr>
		<th>최근 로그인</th>
		<td>
			<fmt:formatDate value="${memberDto.memberLogin}" 
									pattern="y년 M월 d일 H시 m분 s초"/>
		</td>
	</tr>
</table>
		
		
<h3><a href="/member/password">비밀번호 변경</a></h3>
<h3><a href="/member/change">개인정보 변경</a></h3>
<h3><a href="/member/exit">회원 탈퇴</a></h3>


		
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>