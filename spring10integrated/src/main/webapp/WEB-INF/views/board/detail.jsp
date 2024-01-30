<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<table border="1" width="800">
	<tr>
		<td>${boardDto.boardTitle}</td>
	</tr>
	<tr>
		<td>${boardDto.boardWriter}</td>
	</tr>
	<tr>
		<td>${boardDto.boardContent}</td>
	</tr>
	<tr>
		<td>${boardDto.boardWtime}</td>
	</tr>
	<tr>
		<td>${boardDto.boardReadCount}</td>
	</tr>
</table>

<h3><a href="delete?boardNo=${boardDto.boardNo}">삭제하기</a></h3>
<h3><a href="edit?boardNo=${boardDto.boardNo}">수정하기</a></h3>




<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>