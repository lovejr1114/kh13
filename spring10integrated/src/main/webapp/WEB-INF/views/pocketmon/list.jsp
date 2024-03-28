<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="row">
	<div class="col">
		<div class="p-4 text-center">
			<h1>포켓몬스터 목록</h1>
		</div>
	</div>
</div>

<div class="row mt-2">
	<div class="col text-end">
		<a class="btn btn-primary">
			<i class="fa-solid fa-plus"></i>
			신규등록
		</a>
	</div>
</div>


<%-- 검색창 --%>
<form action="list" method="get" class="row row-cols-lg-auto g-3 align-items-center justify-content-center">
	<div class="col">
		<select name="column" class="form-select">
			<option value="pocketmon_name">이름</option>
			<option value="pocketmon_type">속성</option>
		</select>
	</div>
	<div class="col">
		<input type="search" name="keyword" value="${param.keyword}" class="form-control">
	</div>
	<div class="col">
		<button class="btn btn-success" type="submit">
			<i class="fa-solid fa-magnifying-glass"></i>
			검색
		</button>
	</div>
</form>

<div class="row mt-4">
	<div class="col">
		<table class="table table-striped">
			<thead class="text-center">
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>속성</th>
					<th>관리</th>
				</tr>
			</thead>
			<tbody class="text-center">
				<%-- for(PocketmonDto dto : list) --%>
				<c:forEach var="dto" items="${list}">
				<tr>
					<td>${dto.pocketmonNo}</td>
					<td>${dto.pocketmonName}</td>
					<td>${dto.pocketmonType}</td>
					<td>
						<a class="link" href="detail?pocketmonNo=${dto.pocketmonNo}">
							<i class="fa-solid fa-circle-info"></i>
							보기
						</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>