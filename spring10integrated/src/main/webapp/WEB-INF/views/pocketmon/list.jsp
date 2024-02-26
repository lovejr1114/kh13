<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<div clas="container w-1200">
	<div class="cell">
		<div class="cell center">
			<h1>포켓몬 목록</h1>
		</div>
		<div class="cell right">
			<i class="fa-solid fa-ghost yellow"></i>
			<a href="insert1" class="link">신규 등록</a>
		</div>
	</div>	
	
		<div class="clearbox"></div>
		
		<div class="cell center">
			<%-- 검색창 --%>
			<form action="list" merthod="get" autocomplete="off">
				<select name="column">
					<option value="pocketmon_name">이름</option>
					<option value="pocketmon_type">속성</option>
				</select>
				<input type="search" name="keyword" value="${param.keyword}">
				<button>
					검색
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</form>
		</div>

	<div class="cell">
		<%--for(PocketmonDto dto : list) --%>
		<table class="table table-border">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>속성</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${requestScope.list}">
					<tr>
						<td>${dto.pocketmonNo}</td>
						<td>${dto.pocketmonName}</td>
						<td>${dto.pocketmonType}</td>
						<td><a href="detail?pocketmonNo=${dto.pocketmonNo}" class="link blue">이동</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>






<jsp:include page="/WEB-INF/views/template/navigator.jsp"></jsp:include>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>