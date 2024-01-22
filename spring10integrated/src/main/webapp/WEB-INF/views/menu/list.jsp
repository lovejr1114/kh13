<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
 <h1>메뉴 목록</h1>
 
 <form action="list" method="get">
 	<select name="column">
 		<option value="menu_name_kor" ${param.column == 'menu_name_kor' ? 'selected' : '' }>메뉴명(한글)</option>
 		<option value="menu_name_eng" ${param.column == 'menu_name_eng' ? 'selected' : ''}>메뉴명(영문)</option>
 		<option value="menu_type" ${param.column == 'menu_type' ? 'selected' : ''}>메뉴 유형</option>
 	</select>
 	<input type="text" name="keyword" placeholder="검색어 입력" required value="${param.keyword}">
 	<button>검색</button>
 </form>
 
 <table border="1" width="500">
 	<thead>
 		<tr>
 			<th>메뉴 번호</th>
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
 		</tr>
 		</c:forEach>
 	</tbody>
 </table>