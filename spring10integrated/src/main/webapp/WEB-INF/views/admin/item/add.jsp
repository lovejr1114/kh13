<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>판매 상품 등록</h1>

<%-- 
	파일을 전송하려는 form은 다음과 같이 설정해야 한다
	- method=post (get은 크기제한이 있다)
	- encType=multipart/form-data (왼쪽이 대분류, 오른쪽이 소분류)
--%>
<form action="add" method="post" enctype="multipart/form-data"> <%-- 파일전송이되는 기본 옵션 --%>
	상품명 <input type="text" name="itemName" required> <br><br>
	판매액 <input type="number" name="itemPrice" required> <br><br>
	충전액 <input type="number" name="itemCharge" required> <br><br>
	
	<%--
		파일선택은 input[type=file]로 한다
		- accept를 통해 원하는 유형만 선택할 수 있다
	 --%>
	<%-- 이미지 <input type="file" name="attach" required accept=".png, .jpg, .gif"> <br><br> --%>
	이미지 <input type="file" name="attach" required accept="image/*"> <br><br>
	<button>신규 등록</button>
</form>





<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>