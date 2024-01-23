<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>사원 정보 수정</h1>

<form action="edit" method="post">
	<input type="hidden" name="empNo" required value="${dto.empNo}">
	사원명 <input type="text" name="empName" required value="${dto.empName}"> <br><br>
	부서명 <input type="text" name="empDept" required value="${dto.empDept}"> <br><br>
	입사일 <input type="date" name="empDate" required value="${dto.empDate}"> <br><br>
	급여액 <input type="number" name="empSal" required value="${dto.empSal}"> <br><br>
	<button>변경하기</button>
</form>


<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>