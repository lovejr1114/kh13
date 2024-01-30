<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>게시판 목록 및 검색</h1>

<form action="list" method="get">
	<select name="column">
		<option name="">선택하세요</option>
		<option name="board_title" ${param.column == 'board_title' ? 'selected' : ''}>제목</option>
		<option name="board_writer" ${param.column == 'board_writer' ? 'selected' : ''}>작성자</option>
	</select>
	<input type="search" name="keyword" placeholder="검색어 입력" required value="${param.keyword}">
</form>

<c:choose>
	<c:when test="${list == null}">
		<h2>검색어를 입력하세요</h2>
	</c:when>
	<c:when test="${list.isEmpty()}">
		<h2>검색 결과가 존재하지 않습니다.</h2>
	</c:when>
	<c:otherwise>
		<table border="1" width="800">
			<thead>
				<tr>
					<th>번호</th>
					<th width="40%">제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="boardDto" items="${list}">
					<tr>
						<td>${boardDto.boardNo}</td>
						<td align="left"><a href="detail?boardNo=${boardDto.boardNo}">${boardDto.boardTitle}</a></td>
						<td>${boardDto.boardWriter}</td>
						<td>
							<fmt:formatDate value="${boardDto.boardWtime}" pattern="MM.dd"/>
						</td>
						<td>${boardDto.boardReadCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>

<h2><a href="write">글 작성</a></h2>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>