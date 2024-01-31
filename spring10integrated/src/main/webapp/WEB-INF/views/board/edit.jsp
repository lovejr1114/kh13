<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>게시글 수정</h1>

<form action="edit" method="post">
	<input type="hidden" name="boardNo" value="${boardDto.boardNo}">

	제목 <input type="text" name="boardTitle" value="${boardDto.boardTitle}">
	<%-- textarea는 시작태그와 종료태그 사이에 내용을 작성(enter,띄어쓰기도 인식함) --%>
	내용 <textarea name="boardContent" value="${boardDto.boardContent}" required>${boardDto.boardContent}</textarea><br><br>
	<button>수정</button>
</form>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>