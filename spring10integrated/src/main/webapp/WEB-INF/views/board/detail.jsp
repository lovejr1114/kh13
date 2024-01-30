<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>${boardDto.boardNo}번 글 보기</h1>

<table border="1" width="800">
	<tr>
		<td>
			${boardDto.boardTitle}
		</td>
	</tr>
	<tr>
		<td>
			<%-- 탈퇴한 사용자일 때와 아닐 때 나오는 정보가 다르게 구현 --%>
			<c:choose>
				<c:when test="${boardDto.boardWriter == null}">
					${boardDto.boardWriterStr}
				</c:when>
				<c:otherwise>
					${memberDto.memberNick}
					(${memberDto.memberLevel})
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr height="200" valign="top">
		<td>
			${boardDto.boardContent}
		</td>
	</tr>
	<tr>
		<td>
			조회수 ${boardDto.boardReadcount}
			댓글?
			<br>
			<fmt:formatDate value="${boardDto.boardWtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
		</td>
	</tr>
</table>

<h3><a href="delete?boardNo=${boardDto.boardNo}">삭제하기</a></h3>
<h3><a href="edit?boardNo=${boardDto.boardNo}">수정하기</a></h3>




<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>