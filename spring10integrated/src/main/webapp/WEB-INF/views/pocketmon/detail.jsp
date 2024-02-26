<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--
	컨트롤러에서 dto라는 이름으로 정보가 전달되며 없을 수 있다
	조건을 통해 있는 경우와 없는 경우를 분리하여 출력
 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<div class="container w-800">
	<div class="cell center">
		<h1>포켓몬 정보</h1>
	</div>
	<div class="cell">
	<c:choose>
	<c:when test="${dto != null}">	
	<table class="table table-horizontal">
			<tr>
				<th width="30%">번호</th>
				<td>${dto.pocketmonNo}</td>
			</tr>
				<th>이름</th>
				<td>${dto.pocketmonName}</td>
			<tr>
				<th>속성</th>
				<td>${dto.pocketmonType}</td>
			</tr>
		</table>

	</c:when>
	<c:otherwise>
		<h1>존재하지 않는 포켓몬 번호</h1>
	</c:otherwise>
</c:choose>
	</div>
	<div class="cell right">
		<%-- 다른 페이지로의 링크 --%>
		<h2><a href="list">목록보기</a></h2>
		<h2><a href="edit?pocketmonNo=${dto.pocketmonNo}">수정하기</a></h2>
		<h2><a href="delete?pocketmonNo=${dto.pocketmonNo}"
							class="link link-confirm" data-message="정말 삭제하시겠습니까?">삭제하기</a></h2>
	</div>
</div>






<c:choose>
	<c:when test="${dto != null}">
		<h1>포켓몬 정보</h1>
		
		<table class="table table-border">
			<tr>
				<th width="30%">번호</th>
				<td>${dto.pocketmonNo}</td>
			</tr>
				<th>이름</th>
				<td>${dto.pocketmonName}</td>
			<tr>
				<th>속성</th>
				<td>${dto.pocketmonType}</td>
			</tr>
		</table>
		
		<%-- 다른 페이지로의 링크 --%>
		<h2><a href="list">목록보기</a></h2>
		<h2><a href="edit?pocketmonNo=${dto.pocketmonNo}">수정하기</a></h2>
		<h2><a href="delete?pocketmonNo=${dto.pocketmonNo}"
							class="link link-confirm" data-message="정말 삭제하시겠습니까?">삭제하기</a></h2>
	</c:when>
	<c:otherwise>
		<h1>존재하지 않는 포켓몬 번호</h1>
	</c:otherwise>
</c:choose>


<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>