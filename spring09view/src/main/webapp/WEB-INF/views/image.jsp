<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>이미지 실습</h1>

<%--
	img태그
	- 페이지에 이미지를 보여줄 수 있는 효과를 부여
	- 태그만으로는 정보가 부족하므로 속성(attribute)을 통해 추가 정보를 전달
	- 속성은 key=value 형태이며, 속성과 속성 사이에는 반드시 띄어쓰기가 필요!
	
	- src : 이미지의 경로
	- width : 이미지의 폭(px 픽셀, %)
	- height : 이미지의 높이(px 픽셀, %)	
	- alt : 접근성 향상을 위한 도움말
--%>

<!-- <img src="이미지의 주소 or 위치 or ..."> 혹시 주소가 data로 시작하면 쓰지 말기-->
<img width="200" src="https://item.kakaocdn.net/do/49a292677e5b578a8985bb315c19700cf604e7b0e6900f9ac53a43965300eb9a">

<hr>

<img alt="고심이 이미지" width="30%" src="https://item.kakaocdn.net/do/49a292677e5b578a8985bb315c19700cf604e7b0e6900f9ac53a43965300eb9a">

<hr>

<%--
	프로젝트 외부 위치에 있는 이미지는 보안상의 이유로 src에 설정할 수 없다.
	이미지를 프로젝트에 포함시켜야 한다 (src/main/resources폴더 -> static폴더)
	이미지를 해당 위치에 포함시키면 주소가 파일명으로 자동 생성된다.
	
	http://localhost:8080/파일명
	
	다음과 같이 이미지 태그로 부를 수 있다.
	<img width="400" src="http://localhost:8080/7277796c3f7ef108040dcfde1bd2fb9c15b3f4e3c2033bfd702a321ec6eda72c.png">
	
	같은 서버의 같은 프로젝트에 있기 때문에 주소를 생략할 수 있다.
	- 프로토콜 생략 : <img width="400" src="//localhost:8080/7277796c3f7ef108040dcfde1bd2fb9c15b3f4e3c2033bfd702a321ec6eda72c.png">
	- host/port 생략 : <img width="400" src="/7277796c3f7ef108040dcfde1bd2fb9c15b3f4e3c2033bfd702a321ec6eda72c.png">
	위와 같은 방식으로 절대경로(absolute path)라고 부른다.
	
	한편, 다음과 같이 작성해도 된다.
	<img width="400" src="7277796c3f7ef108040dcfde1bd2fb9c15b3f4e3c2033bfd702a321ec6eda72c.png">
	위와 같은 방식은 상대경로(relative path) 라고 부른다.
	
	절대경로는 언제나 한결같은 위치를 가리키고
	상대경로는 현재 페이지에 따라 다른 위치를 가리킨다
	
	 --%>
<img width="400" src="7277796c3f7ef108040dcfde1bd2fb9c15b3f4e3c2033bfd702a321ec6eda72c.png">