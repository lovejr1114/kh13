<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	EL에서 파라미터를 읽고싶다면 param 이라는 내장객체를 사용한다
	예를 들어서, ${param.query}라고 쓰면 query=... 을 읽는다.
 --%>


<h1>EL에서 파라미터 읽기</h1>

<form action="test03" method="get">
<%--
	메소드가 post로 되면 주소가 깔끔해진다.
	하지만 새로고침을 할 때 양식 다시 제출 확인이 뜨면서
	사용자가 불편함을 느끼게 된다. 그래서 get으로 써줌.
	post는 원래 제출용 방식이기 때문에 주소만 깔끔하게하는 용도임..
	--%>
	<input type="search" name="query" value="${param.query}">
	<button>검색</button>
</form>

<h2>${param.query} 에 대한 검색 결과</h2>