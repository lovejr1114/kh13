<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>사원 등록</h1>

<%-- 
	절대경로 
	<from action="/emp/insert2"></from>
	상대경로
	<form action="insert2"></form>
--%>

<form action="insert" method="post">
	사원명 <input name="empName" type="text"> <br><br>
	부서명 <input name="empDept" type="text"> <br><br>
	입사일 <input name="empDate" type="date"> <br><br>
	급여액 <input name="empSal" type="text"> <br><br>
	<button>등록</button>
</form>