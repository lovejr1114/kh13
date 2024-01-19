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

<h1>사원 목록 검색</h1>

<form action="list" method="get">
	<select name="column">
		<option value="emp_name" selected="selected">이름</option>
		<option value="emp_dept" selected>부서</option>
	</select>
	<input type="search" name="keyword" value="${param.keyword}" required>
	<button>검색</button>
</form>

<c:forEach var="dto" items="${list}">
	<h2>
	사번 = ${dto.empNo}
	이름 = ${dto.empName}
	부서 = ${dto.empDept}
	입사일 = ${dto.empDate}
	급여 = ${dto.empSal}
	</h2>
</c:forEach>