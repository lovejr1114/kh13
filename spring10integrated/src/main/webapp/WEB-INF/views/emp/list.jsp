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

<h1>사원 목록 및 검색</h1>
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
<%-- for(EmpDto dto : list) {} --%>
<c:forEach var="dto" items="${list}">
	<h1>
		[${dto.empNo}]
		${dto.empName}
		(${dto.empDept})
		-
		${dto.empDate}
		<%--
			html에서 꺾쇠는 태그를 의미하여 사용할 수 없다
			특수문자로 대체하여 사용
			<는 less than, 줄여서 &lt;
			>는 greater than, 줄여서 &gt;
			띄어쓰기는 non-breaking space, 줄여서 &nbsp;
			궁금하다면 인터넷에 HTML 특수문자표 검색
		 --%>
		 &lt;${dto.empSal}원&gt;
		</h1>
</c:forEach>


<!-- <form action="list" method="get"> -->
<!-- 	<select name="column"> -->
<!-- 		<option value="emp_name" selected="selected">이름</option> -->
<!-- 		<option value="emp_dept" selected>부서</option> -->
<!-- 	</select> -->
<%-- 	<input type="search" name="keyword" value="${param.keyword}" required> --%>
<!-- 	<button>검색</button> -->
<!-- </form> -->

<%-- <c:forEach var="dto" items="${list}"> --%>
<!-- 	<h2> -->
<%-- 	사번 = ${dto.empNo} --%>
<%-- 	이름 = ${dto.empName} --%>
<%-- 	부서 = ${dto.empDept} --%>
<%-- 	입사일 = ${dto.empDate} --%>
<%-- 	급여 = ${dto.empSal} --%>
<!-- 	</h2> -->
<%-- </c:forEach> --%>