<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-1200">
	<div class="cell title center">
		<h1 align="center">마이페이지</h1>
		<hr class="my-20">
	</div>
	
	<div class="cell center">
		<h2>${sessionScope.loginId} 님의 회원 정보</h2>
	</div>
	
	<div class="cell floating-cell">
		<div class="p-20">
			<div class="cell">
				<img src="image" width="200" height="200">
			</div>
			<div class="cell">
				<a href="/member/password" class=" btn w-100">비밀번호 변경</a>
			</div>
			<div class="cell">
				<a href="/member/change" class="btn w-100">개인정보 변경</a>
			</div>	
			<div class="cell">	
				<a href="/member/exit" class="btn negative w-100">회원 탈퇴</a>
			</div>
	</div>
	
	<div class="cell w-50 m-50">
		<table class="table table-border">
			<tr>
				<th>닉네임</th>
				<td>${memberDto.memberNick}</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>${memberDto.memberContact}</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>${memberDto.memberBirth}</td>
			</tr>
			<tr>
				<th>E-mail</th>
				<td>${memberDto.memberEmail}</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					[${memberDto.memberPost}]
					${memberDto.memberAddress1}
					${memberDto.memberAddress2}
				</td>
			</tr>
			<tr>
				<th>회원등급</th>
				<td>${memberDto.memberLevel}</td>
			</tr>
			<tr>
				<th>포인트</th>
				<td>${memberDto.memberPoint} Point</td>
			</tr>
			<tr>
				<th>가입일</th>
				<td>
					<fmt:formatDate value="${memberDto.memberJoin}" 
											pattern="y년 M월 d일 H시 m분 s초"/>
				</td>
			</tr>
			<tr>
				<th>최근 로그인</th>
				<td>
					<fmt:formatDate value="${memberDto.memberLogin}" 
											pattern="y년 M월 d일 H시 m분 s초"/>
				</td>
			</tr>
		</table>
	</div>
</div>
</div>

<div>
		<div class="cell title center">
		<h2>포인트 구매내역</h2>
	</div>
	<div class="cell">
		<h3 align="right">
			<i class="fa-solid fa-credit-card"></i>
			<a href="/point/charge" class="link">추가 구매</a>
		</h3>
	</div>
</div>
	<div class="cell">
		<table class="table table-border">
	<thead>
		<tr>
			<th>번호</th>
			<th>상품명</th>
			<th>수량</th>
			<th>구매금액</th>
			<th>구매일시</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="buyDto" items="${buyList}">
		<tr>
			<td align="center">${buyDto.buySerial}</td>
			<td>${buyDto.itemName}</td>
			<td>${buyDto.buyQty}</td>
			<td>
				<fmt:formatNumber value="${buyDto.buyTotal}" pattern="#,##0"/>
			</td>
			<td>
				<fmt:formatDate value="${buyDto.buyTime}" pattern="yyyy-MM-dd HH:mm"/>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
	</div>
</div>


		
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>