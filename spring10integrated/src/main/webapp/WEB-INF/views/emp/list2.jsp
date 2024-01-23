<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 실습 문제
	Emp와 Menu에 대한 목록 및 검색 통합 페이지를 구현
	Emp - /emp/list
	Menu - /menu/list
	검색은 column과 keyword 항목을 이용하여 처리
	검색어 입력창을 통해 검색이 가능하도록 구현
	검색 시 입력한 검색어와 항목이 유지되도록 구현 -> 못했음 ㅠㅠ
 --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>사원 목록 및 검색
	<button><a href="insert">신규등록</a></button>
</h1>
<%-- 
if(isSearch){
	<h1>사원 검색</h1>
}
else{
	<h1>사원 목록</h1>
}
--%>
<c:choose>
	<c:when test="${requestScope.isSearch}">
		<h1>사원 검색</h1>
	</c:when>
	<c:otherwise>
		<h1>사원 목록</h1>
	</c:otherwise>
</c:choose>


<%-- 검색창 --%>
<form action="list" method="get">
	<select name="column">
		<%--
			EL은 문자열도 ==로 비교한다. (물론 equals도 가능)
			EL은 문자열을 쌍따옴표로 쓰건 외따옴표로 쓰건 상관하지 않는다
		 --%>
		<c:choose>
			<c:when test="${param.column == 'emp_name'}">
				<option value="emp_name">사원명</option>
			</c:when>
			<c:otherwise>
				<option value="emp_name">사원명</option>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.column == 'emp_dept'}">
				<option value="emp_dept">부서명</option>
			</c:when>
			<c:otherwise>
				<option value="emp_dept">부서명</option>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.column == 'emp_date'}">
				<option value="emp_date">입사일</option>
			</c:when>
			<c:otherwise>
				<option value="emp_date">입사일</option>
			</c:otherwise>
		</c:choose>
	</select>
	<input type="search" name="keyword" placeholder="검색어 입력" required
			value="${param.keyword}">
	<button>검색</button>
</form>


<%-- 목록 출력 --%>
<table border="1">
	<thead>
		<tr>
			<th>사원번호</th>
			<th>사원명</th>
			<th>부서명</th>
			<th>입사일</th>
			<th>급여액</th>
		</tr>
	<tbody align="center">
		<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.empNo}</td>
			<td>${dto.empName}</td>
			<td>${dto.empDept}</td>
			<td>${dto.empDate}</td>
			<td>${dto.empSal}원</td>
			<td><a href="detail?empNo=${dto.empNo}">이동</a></td>
		</tr>
		</c:forEach>
	</tbody>
	</thead>
</table>



<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>