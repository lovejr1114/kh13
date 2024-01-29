<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>   

<h1>${memberDto.memberId} 님의 회원 정보</h1>

<table border="1" width="400">
	<tr>
		<th width="30%">아이디</th>
		<td>${memberDto.memberId}</td>
	</tr>
	<tr>
		<th>닉네임</th>
		<td>${memberDto.memberNick}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${memberDto.memberEmail}</td>
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
		<th>주소</th>
		<td>
			[${memberDto.memberPost}]
			${memberDto.memberAddress1}
			${memberDto.memberAddress2}
		</td>
	</tr>
	<tr>
		<th>등급</th>
		<td>${memberDto.memberLevel}</td>
	</tr>
	<tr>
		<th>가입일</th>
		<td>
			<fmt:formatDate value="${memberDto.memberJoin}" pattern="yyyy-MM-dd E HH:mm:ss"/>
		</td>
	</tr>
	<tr>
		<th>최종 로그인</th>
		<td>
			<fmt:formatDate value="${memberDto.memberLogin}" pattern="yyyy-MM-dd E HH:mm:ss"/>
		</td>
	</tr>
</table>

<h2><a href="#">임시 비밀번호 발행</a></h2>
<h2><a href="#">회원 정보 변경</a></h2>
<h2><a href="#">회원 강제 탈퇴</a></h2>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>   