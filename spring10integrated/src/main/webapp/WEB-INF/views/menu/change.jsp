<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

${dto}

<h1>메뉴 정보 수정</h1>

<form action="change" method="post">
	<input type="hidden" name="menuNo" required value="${dto.menuNo}">
	한글 메뉴명 <input type="text" name="menuNameKor" required value="${dto.menuNameKor}"> <br><br>
	영어 메뉴명 <input type="text" name="menuNameEng" required value="${dto.menuNameEng}"> <br><br>
	메뉴 타입 <input type="text" name="menuType" required value="${dto.menuType}"> <br><br>
	메뉴 가격 <input type="number" name="menuPrice" required value="${dto.menuPrice}"> <br><br>
	<button>변경하기</button>
</form>