<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>충전 상품 목록</h1>

<table>
	<tr>
		<td>image</td>
		<td>${pointDto.pointName}</td>
		<td>${pointDto.pointPrice}</td>
		<td>${pointDto.pointCharge}</td>
	</tr>
</table>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>