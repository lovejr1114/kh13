<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>게시글 등록</h1>

<form action="write" method="post">
	작성자 <input name="boardWriter" type="text" readonly value="${sessionScope.loginId}"><br><br>
	제목 <input name="boardTitle" type="text" requird><br><br>
	내용 <br>
	<input name="boardContent" type="text" size="100" required><br><br>
	<button>등록</button>
</form>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>