<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>회원관리</h1>

<%-- 
	절대경로 /admin/member/search
	상대경로 search
 --%>
<form action="search" method="get">
	<select name="column">
		<option value="member_id" ${param.column == 'member_id' ? 'selected' : ""}>아이디</option>
		<option value="member_nick" ${param.column == 'member_nick' ? 'selected' : ""}>닉네임</option>
		<option value="member_contact" ${param.column == 'member_contact' ? 'selected' : ""}>연락처</option>
		<option value="member_email" ${param.column == 'member_email' ? 'selected' : ""}>이메일</option>
		<option value="member_birth" ${param.column == 'member_birth' ? 'selected' : ""}>생년월일</option>
	</select>
	<input type="search" name="keyword" placeholder="검색어 입력" requried value="${param.keyword}">
	<button>찾기</button>
</form>


<hr>

<%-- 조회 결과는 list의 유무에 따라 다르게 출력 --%>

<c:choose>
	<c:when test="${list == null}"> <%--list가 null 이라면 --%>
		<h1>검색어를 입력하세요</h1>
	</c:when>
	<c:when test="${list.isEmpty()}"> <%--list가 비어있다면 --%>
		<h2>검색 결과가 존재하지 않습니다</h2>
	</c:when>
	<c:otherwise>
		<table border="1" width="800">
			<thead>
				<tr>
					<th>아이디</th>
					<th>닉네임</th>
					<th>이메일</th>
					<th>연락처</th>
					<th>생년월일</th>
					<th>더 보기</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="memberDto" items="${list}">
					<tr>
						<td>${memberDto.memberId}</td>
						<td>${memberDto.memberNick}</td>
						<td>${memberDto.memberEmail}</td>
						<td>${memberDto.memberContact}</td>
						<td>${memberDto.memberBirth}</td>
						<td>
							<a href="/admin/member/detail?memberId=${memberDto.memberId}">&raquo;</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>



<h2>${memberDto.memberId}님의 정보</h2>





<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>