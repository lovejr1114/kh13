<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://cdn-script.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(function(){
	//form을 전송할 때 체크되지 않은 항목들이 전송되지 않도록 처리
	$(".purchase-form").submit(function(){
		//하나도 체크가 안된 경우는 알림창 후 전송 중지
		var count = $(this).find("[name=no]:checked").length; //this == form
		if(count == 0){
			alert("체크 후 구매하세요");
			return false;
		}
		
		//체크되지 않은 항목의 수량 입력칸을 전송되지 않도록 처리(disabled 처리)
		$(this).find(".product-wrapper").each(function(){ //div 를 찾아서
			//this == div
			var checked = $(this).find("[name=no]").prop("checked"); //체크 여부 확인
			if(checked == false){ //체크가 안된 경우에는
				$(this).find("[name=qty]").prop("disabled",true); //입력창 비활성화
			}
		});
		
		return true;
	});
});

</script>

<h1>복잡한 결제</h1>

<form action="purchase" method="post" class="purchase-form">
<c:forEach var="productDto" items="${list}">
	<div class="product-wrapper">
		<input type="checkbox" name="no" value="${productDto.no}">
		[${productDto.type}]
		${productDto.name}
		(${productDto.price}원)
		<input type="number" name="qty">
	</div>
</c:forEach>
<button type="submit">구매하기</button>
</form>