<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>메뉴 등록</h1>

<form action="insert" method="post">
	메뉴명(한글) <input name="menuNameKor" type="text"> <br><br>
	메뉴명(영어) <input name="menuNameEng" type="text"> <br><br>
	메뉴 타입 <input name="menuType" type="text"> <br><br>
	메뉴판매가 <input name="menuPrice" type="number"> <br><br>
	<button>등록</button>
</form>