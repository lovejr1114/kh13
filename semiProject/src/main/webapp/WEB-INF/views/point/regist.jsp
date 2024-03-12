<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="regist" method="post" autocomplete="off" enctype="multipart/form-data">
	<div class="container w-800">
		<div class="cell center">
			<h1>포인트 충전 상품 등록</h1>
		</div>
		
		<div class="cell">
			<label>상품명</label>
			<input type="text" name="pointName" required>
		</div>
		<div class="cell">
			<label>상품 판매가격</label>
			<input type="number" name="pointPrice" required>
		</div>
		<div class="cell">
			<label>충전 금액</label>
			<input type="number" name="pointCharge" required>
		</div>
		
		<div class="cell">
			<label>이미지 등록</label>
			<input type="file" name="attach" class="tool w-100">
		</div>

		<div class="cell">
			<button>등록</button>
		</div>
		
	</div>
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>