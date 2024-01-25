<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>학생 목록 및 검색</h1>
<h3><a href="add">신규 등록</a></h3>

<c:choose>
	<c:when test="${requestScope.isSearch}">
		<h1>학생 검색</h1>
	</c:when>
	<c:otherwise>
		<h1>학생 목록</h1>
	</c:otherwise>
</c:choose>


<form action="list" method="get">
	<select name="column">
		<c:choose>
			<c:when test="${param.column == 'student_id'}">
				<option value="student_id">학생 번호</option>
			</c:when>
			<c:otherwise>
				<option value="student_id">학생 번호</option>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.column == 'name'}">
				<option value="name">학생명</option>
			</c:when>
			<c:otherwise>
				<option value="name">학생명</option>
			</c:otherwise>
		</c:choose>
	</select>
	<input type="search" name="keyword" placeholder="검색어 입력" required value="${param.keyword}">
	<button>검색</button>
</form>


<table border="1">
	<thead>
		<tr>
			<th>학생 번호</th>
			<th>학생명</th>
			<th>국어점수</th>
			<th>수학점수</th>
			<th>영어점수</th>
		</tr>
	<tbody align="center">
		<c:forEach var="dto" items="${list}">
		<tr>
			<td>${studentDto.studentId}</td>
			<td>${studentDto.name}</td>
			<td>${studentDto.koreanScore}</td>
			<td>${studentDto.mathScore}</td>
			<td>${studentDto.englishScore}</td>
		</tr>
		</c:forEach>
	</tbody>	
	</thead>
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>