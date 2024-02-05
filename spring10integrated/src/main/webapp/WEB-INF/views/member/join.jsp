<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>회원 가입</h1>

<form action="join" method="post" enctype="multipart/form-data">

	아이디 * <input name="memberId" type="text" required placeholder="소문자,숫자 8~20자"> <br><br>
	비밀번호 * <input name="memberPw" type="password" required placeholder="대/소문자,숫자,특수문자 포함 6~15자"> <br><br>
	닉네임 * <input name="memberNick" type="text" required placeholder="한글,숫자 2~10자"> <br><br>
	이메일 * <input name="memberEmail" type="email" required> <br><br>
	생년월일 <input name="memberBirth" type="date"> <br><br>
	연락처 <input name="memberContact" type="tel"> <br><br>
	주소 <br><br>
		 <input name="memberPost" type="text" placeholder="우편번호"> <br><br>
		 <input name="memberAddress1" type="text" placeholder="기본주소"> <br><br>
		 <input name="memberAddress2" type="text" placeholder="상세주소"> <br><br>
	프로필사진 <input type="file" name="attach" accept="image/*"><br><br>
	
	<button>가입하기</button>
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>