<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>포켓몬 목록</h1>

<h1>
	포켓몬 목록
	<a href="insert1">+신규등록</a>
</h1>

<%-- 검색창 --%>
<form action="list" merthod="get">
	<select name="column">
		<option value="pocketmon_name">이름</option>
		<option value="pocketmon_type">속성</option>
	</select>
	<input type="search" name="keyword" value="${param.keyword}">
	<button>검색</button>
</form>


<%--for(PocketmonDto dto : list) --%>
<c:forEach var="dto" items="${requestScope.list}">
	<h2>
	번호 = ${dto.pocketmonNo}
	이름 = ${dto.pocketmonName}
	속성 = ${dto.pocketmonType}
	<a href="detail?pocketmonNo=${dto.pocketmonNo}">이동</a>
	</h2>
</c:forEach>


<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>