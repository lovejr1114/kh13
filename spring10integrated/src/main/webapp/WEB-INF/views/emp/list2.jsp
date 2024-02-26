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


<div class="container w-500">
	<div class="cell center">
		<h1>사원 목록 및 검색</h1>
	</div>
	<div class="cell right">
		<i class="fa-solid fa-user"></i>
		<a href="insert" class="link">신규등록</a>
	</div>
	
	
	<%-- 
		if(isSearch){
			<h1>사원 검색</h1>
		}
		else{
			<h1>사원 목록</h1>
		}
	--%>
	<div class="cell">
		<c:choose>
			<c:when test="${requestScope.isSearch}">
				<h1>사원 검색</h1>
			</c:when>
			<c:otherwise>
				<h1>사원 목록</h1>
			</c:otherwise>
		</c:choose>
		<%-- 검색창 --%>
		<form action="list" method="get" autocomplete="off">
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
	</div>
	
	<form action="deleteAll" method="post">
	<div class="cell">
		<%-- 목록 출력 --%>
		<table class="table table-horizontal">
			<thead>
				<tr>
					 <c:if test="${sessionScope.loginLevel == '관리자'}">
					<th>
						<input type="checkbox" class="check-all">
					</th>
					</c:if>
					<th>사원번호</th>
					<th>사원명</th>
					<th>부서명</th>
					<th>입사일</th>
					<th>급여액</th>
					<th></th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="dto" items="${list}">
				<tr>
					<td>
						<input type="checkbox" class="check-item"
									name="empNo" value="${dto.empNo}">
					</td>
					<td>${dto.empNo}</td>
					<td>${dto.empName}</td>
					<td>${dto.empDept}</td>
					<td>${dto.empDate}</td>
					<td>${dto.empSal}원</td>
					<td><a href="detail?empNo=${dto.empNo}" class="link">이동</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<!-- 삭제 버튼 -->
	 <c:if test="${sessionScope.loginLevel == '관리자'}">
	<div class="cell right">
		<button class="btn negative">삭제</button>
	</div>
	</c:if>
	</form>
</div>



<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>