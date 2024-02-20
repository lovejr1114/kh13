<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-500">
	<div class="cell center">
		<h1>${boardDto.boardNo}번 글 보기</h1>
	</div>
	<div>
		<table class="table table-border">
			<tr>
				<td class="left">
					${boardDto.boardTitle}
					
					<%-- (추가) 수정시각 유무에 따라 수정됨 표시 --%>
					<c:if test="${boardDto.boardEtime != null}">
						(수정됨)
					</c:if>
				</td>
			</tr>
			<tr>
				<td class="right">
					<%-- 탈퇴한 사용자일 때와 아닐 때 나오는 정보가 다르게 구현 --%>
					<c:choose>
						<c:when test="${boardDto.boardWriter == null}">
							${boardDto.boardWriterStr}
						</c:when>
						<c:otherwise>
							${memberDto.memberNick}
							(${memberDto.memberLevel})
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr height="200" valign="top">
				<td class="left">
					<%-- 
						HTML은 엔터와 스페이스 등을 무시하기 때문에 textarea와 모양이 달라진다
						- 상용 에디터를 쓰면 알아서 글자를 보정해주기 때문에 문제가 없다
						- 기본 textarea를 쓰면 문제가 발생한다 
						- <pre>태그를 사용하면 글자를 있는 그대로 출력한다.
					 --%>
					<pre>${boardDto.boardContent}</pre>
				</td>
			</tr>
			<tr>
				<td class="right">
					조회수 ${boardDto.boardReadcount}
					댓글?
					<br>
					<fmt:formatDate value="${boardDto.boardWtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					<br>
					${boardDto.boardWtimeDiff}
				</td>
			</tr>
			<tr>
				<td class="right">
					<a href="write">글쓰기</a>
					<a href="write?boardTarget=${boardDto.boardNo}">답글쓰기</a>
					
					<%-- 
						수정과 삭제링크는 회원이면서 본인글이거나 관리자일 경우만 출력
						- if문에 ${회원 && (본인글 || 관리자)}
						- 본인글이란 로그인한 사용자와 아이디와 게시글 작성자가 같은 경우
						- 관리자란 로그인한 사용자 등급이 '관리자'인 경우
					--%>
					<c:if test="${sessionScope.loginId != null && (sessionScope.loginId == boardDto.boardWriter || sessionScope.loginLevel == '관리자')}">
						<a href="edit?boardNo=${boardDto.boardNo}">글 수정</a>
						<a href="delete?boardNo=${boardDto.boardNo}">글 삭제</a>
					</c:if>
					<a href="list">글 목록</a>
				</td>
			</tr>
		</table>
	</div>
</div>





<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>