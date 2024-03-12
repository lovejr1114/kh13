<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-1200">
	<div class="cell">
		<h1>포인트 충전</h1>
	</div>
	<div class="cell">
		<c:forEach var="pointDto" items="${list}">
			<h2>${pointDto.pointName}</h2>
		<img src="image?itemNo=${pointDto.pointNo}"> <br>
		가격 : 
		<fmt:formatNumber value="${pointDto.pointPrice}" pattern="#,##0"/> 
		원 ,
		충전 포인트  :
		<fmt:formatNumber value="${pointDto.pointCharge}" pattern="#,##0"/>
		포인트
		<hr>
		<%-- 구매를 위한 form 생성 --%>
		<form action="charge" method="post" autocomplete="off">
			<input type="hidden" name="pointNo" value="${pointDto.pointNo}">
			<input type="number" name="point" value="1" required>
		<a href="registComplete"><button>구매</button></a>
		</form>
	</c:forEach>
	</div>
</div>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>