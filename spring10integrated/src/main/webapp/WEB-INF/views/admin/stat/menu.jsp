<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>메뉴 유형별 메뉴 개수 통계</h1>

<table border="1" width="300">
	<thead>
		<tr>
			<th>유형</th>
			<th>개수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="statVO" items="${list}">
			<tr>
				<td>${statVO.title}</td>
				<td>${statVO.count}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>