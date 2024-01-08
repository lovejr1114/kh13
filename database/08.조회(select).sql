/*
	조회(Select)
	- 데이터베이스에 저장된 데이터들을 원하는 기준에 맞게 읽어내는 것
	- SELECT 항목 FROM 테이블
*/

--전체 도서 조회
SELECT * FROM book;
SELECT book. * FROM book;

-- 도서명만 조회
SELECT book_title FROM book;

-- 도서명과 페이지수만 조회
SELECT book_title, book_page_count FROM book;

-- 항목을 계산하여 추가로 조회할 수 있다
SELECT book_title, length(book_title) FROM book;
SELECT book_title "도서 제목", LENGTH(book_title) "제목글자수" FROM book;
-- ""를 쓰지 않고 띄어쓰기를 하게 된다면 다음 데이터를 읽어오므로 여기선 쌍따옴표를 허용한다

--도서명과 출간연도를 조회하고싶은 경우
-- substr(항목,시작위치,글자수) : 오라클은 문자열 위치 시작이 1부터이다.
SELECT
	book_title 도서명,
	substr(book_publication_date, 1, 4) 출간연도
	FROM book;
