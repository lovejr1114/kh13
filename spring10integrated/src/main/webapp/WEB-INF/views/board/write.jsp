<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>게시글 작성</h1>

<form action="write" method="post">
	제목 <input name="boardTitle" type="text" requird><br><br>
	내용 <br>
	<%-- 
		여러 줄 입력하고 싶다면 textarea 태그를 사용한다. type은 없고 name만 적으면 된다.
		<input type="text" name="boardContent" required>
		
		textarea 태그는 종료 태그가 필요하며, type과 value를 설정할 수 없다.
		<textarea name="boardContent" required></textarea>	
	 --%>
	<textarea name="boardContent" required></textarea>	
	<br><br>
	<button>등록</button>
</form>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>