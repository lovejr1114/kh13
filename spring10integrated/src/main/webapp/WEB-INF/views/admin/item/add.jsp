<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<%-- 
	파일을 전송하려는 form은 다음과 같이 설정해야 한다
	- method=post (get은 크기제한이 있다)
	- encType=multipart/form-data (왼쪽이 대분류, 오른쪽이 소분류)
--%>
	
	<%--
		파일선택은 input[type=file]로 한다
		- accept를 통해 원하는 유형만 선택할 수 있다
	 --%>
	<%-- 이미지 <input type="file" name="attach" required accept=".png, .jpg, .gif"> <br><br> --%>


<form action="add" method="post" enctype="multipart/form-data" autocomplete="off">
	<div class="container w-500">
    	<div class="cell">
			<h1>판매 상품 등록</h1>
        </div>
        
        <div calss="cell">
         	<label>아이템명</label>
         	<input type="text" name="itemName" required>
         </div>
         <div calss="cell">
         	<input type="number" name="itemPrice" required>
         </div>
         <div calss="cell">
         	<input type="number" name="itemCharge" required>
         </div>    
         <div class="cell">
         <label>이미지</label>
         	<input type="file" name="attach" class="tool w-100">
         </div>
         <button>신규 등록</button>
         </div>
	</div>
</form>




<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>