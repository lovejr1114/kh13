<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
  
  
<div class="container w-800">
	<div class="cell center">
		<h1>메뉴 목록</h1>
		<a href="insert"> 신규 등록</a>
	</div>
	<div class="cell">
		
	</div>
</div>




 <h1>
 	메뉴 목록
 	<button><a href="insert"> 신규 등록</a></button>
 </h1>
 
 <form action="list" method="get">
 	<select name="column">
 		<option value="menu_name_kor" ${param.column == 'menu_name_kor' ? 'selected' : '' }>메뉴명(한글)</option>
 		<option value="menu_name_eng" ${param.column == 'menu_name_eng' ? 'selected' : ''}>메뉴명(영문)</option>
 		<option value="menu_type" ${param.column == 'menu_type' ? 'selected' : ''}>메뉴 유형</option>
 	</select>
 	<input type="text" name="keyword" placeholder="검색어 입력" required value="${param.keyword}">
 	<button>검색</button>
 </form>
 
 <table border="1" width="700">
 	<thead>
 		<tr>
 			<th width="20%">메뉴 번호</th>
 			<th>메뉴 이름</th>
 			<th>메뉴 유형</th>
 			<th>판매 가격</th>
 		</tr>	
 	</thead>
 	<tbody align="center">
 		<c:forEach var="dto" items="${list}">
 		<tr>
 			<td>${dto.menuNo}</td>
 			<td>${dto.menuNameKor}(${dto.menuNameEng})</td>
 			<td>${dto.menuType}</td>
<%--  			<td align="right">${dto.menuPrice}원</td> --%>
			<td align="right">
				<fmt:formatNumber value="${dto.menuPrice}" pattern="#,##0"/>원
			<td><button><a href="detail?menuNo=${dto.menuNo}">이동</a></button></td>
 		</tr>
 		</c:forEach>
 	</tbody>
 </table>
 
 
 <%-- 네비게이터 출력 --%>
 <jsp:include page="/WEB-INF/views/template/navigator.jsp"></jsp:include>
 
 <%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>