<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
 
 <%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
 
 <c:choose>
 	<c:when test="${dto != null}">
 		<h1>메뉴 정보</h1>
 		
 		<table border="1" width="300">
 			<tr>
 				<th width="30%">메뉴 번호</th>
 				<td>${dto.menuNo}</td>
 			</tr>
 			<tr>
 				<th>메뉴명</th>
 				<td>${dto.menuNameKor}(${dto.menuNameEng})</td>
 			</tr>
 			<tr>
 				<th>메뉴 유형</th>
 				<td>${dto.menuType}</td>
 			</tr>
 			<tr>
 				<th>판매가</th>
 				<td>
 				<fmt:formatNumber value="${dto.menuPrice}" pattern="#,##0"></fmt:formatNumber>원
 				</td>
 			</tr>
 		</table>
 		
 		<button><a href="list">목록보기</a></button>
 		<button><a href="insert">신규 등록</a></button>
 		<button><a href="change?menuNo=${dto.menuNo}">변경하기</a></button>
 		<button><a href="delete?menuNo=${dto.menuNo}">삭제하기</a></button>
 	</c:when>
 	<c:otherwise>
 		<h2>존재하지 않는 메뉴입니다</h2>
 	</c:otherwise>
 </c:choose>
 
 
 <%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>