<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<style>
	.point-img {
		width:80px;
	}
</style>

<div class="container w-1200">
	<div class="cell center">
		<h1>포켓볼 충전</h1>
	</div>
	<div class="cell flex-cell">
		<div class="w-50 center">
			<c:forEach var="pointDto" items="list">
				<h3>${pointDto.pointName}</h3>
				<img src="/image/pocketball.png" class="point-img">
				판매가 :
				<fmt:formatNumber value="${pointDto.pointPrice}" pattern="#,##0"/>
				포켓볼 : 
				<fmt:formatNumber value="${pointDto.pointCharge}" pattern="#,##0"/>
				<form action="charge" method="post" autocomplete="off">
					<input type="hidden" name="pointNo" value="${pointDto.pointNo}">
					<button>구매</button>
				</form>
			</c:forEach>
		</div>
	</div>

</div>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>