<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-1200">
	<div class="cell">
		<h1>포인트 충전</h1>
	</div>
	<div class="cell">
		<c:forEach var="itemDto" items="${list}">
			<h2>${itemDto.itemName}</h2>
		<img src="image?itemNo=${itemDto.itemNo}"> <br>
		가격 : 
		<fmt:formatNumber value="${itemDto.itemPrice}" pattern="#,##0"/> 
		원 ,
		충전 포인트  :
		<fmt:formatNumber value="${itemDto.itemCharge}" pattern="#,##0"/>
		포인트
		<hr>
		<%-- 구매를 위한 form 생성 --%>
		<form action="charge" method="post" autocomplete="off">
			<input type="hidden" name="itemNo" value="${itemDto.itemNo}">
			<input type="number" name="buyQty" value="1" required>
		<button>구매</button>
		</form>
	</c:forEach>
	</div>
</div>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>