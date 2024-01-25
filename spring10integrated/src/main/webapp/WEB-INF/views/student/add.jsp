<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>학생 등록</h1>

<form action="add" method="post">
	학생명 <input type="text" required> <br><br>
	국어점수 <input name="koreanScore" type="number" required placeholder="0~100점"> <br><br>
	수학점수 <input name="mathScore" type="number" required placeholder="0~100점"> <br><br>
	영어점수 <input name="englishScore" type="number" required placeholder="0~100점"> <br><br>
	<button>등록하기</button>
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>