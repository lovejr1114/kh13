/*
	조건 -제시한 조건에 부합하는 데이터만 조회(필터링)
	- 조회구문 뒤에 'where 조건식' 을 추가
*/
-- 10달러 미만인 도서만 조회
SELECT * FROM book WHERE book_price < 10;

-- 10~15달러 사이(between)의 도서만 조회
SELECT * FROM  book WHERE book_price >= 10 and book_price <= 15;
SELECT * FROM book WHERE book_price BETWEEN 10 AND 15;

-- 5번 도서만 조회
SELECT * FROM book WHERE book_id = 25; --25번 도서만 보여달라
SELECT * FROM book WHERE book_id != 18; -- 18번 도서만 빼고 보여달라

-- 문자 조건
-- [1] 장르가 Fantasy인 도서를 조회 (오라클은 문자도 = 로 비교)
SELECT * FROM book WHERE book_genre = 'Fantasy';
SELECT * FROM book WHERE lower(book_genre) = 'fantasy'; --소문자로 적었을 시 검사 코드

-- [2] T로 시작하는 도서 조회
-- like 연산자는 패턴을 지정할 때 사용하며 %는 해당 자리는 무관하다는 뜻
-- instr 함수는 지정한 글자가 어느 위치에 있는지 알아내는 명령
-- 시작 검사만큼은 like 연산자가 매우 빠르며, 나머지는 전반적으로 instr 함수가 빠르다
SELECT * FROM book WHERE book_title LIKE 'T%';
SELECT * FROM book WHERE instr(book_title, 'T') = 1; --자바로 치면 indexof 같은 것. T가 1번위치에 있냐?, T로 시작하냐!
-- 시작하는 단어를 찾을 때는 like가 제일 빠르다.


-- (Q) 대소문자 상관없이 h가 들어있는 도서를 조회
SELECT * FROM book WHERE lower(book_title) LIKE '%h%';
SELECT * FROM  book WHERE instr(lower(book_title), 'h') > 0; --추천

-- (Q) 저자명이 J로 시작하는 도서를 조회
SELECT * FROM book WHERE book_author LIKE 'J%'; --추천
SELECT * FROM book WHERE instr(book_author), 'J') = 1;

-- (Q) 출판사명이 Company로 끝나는 도서를 조회
SELECT * FROM book WHERE book_publisher LIKE '%Company';
SELECT * FROM book WHERE instr(book_publisher, 'Company') = length(book_publisher)-LENGTH('Company')+1;

-- (Q) 도서명에 숫자가 들어간 도서를 조회
SELECT * FROM book WHERE REGEXP_LIKE(book_title, '[0-9]+'); 



--
create table product(
no number primary key,
name varchar2(30) not null,
type varchar2(15) check(type in ('과자','아이스크림','주류','사탕')),
price number,
made date,
expire date
);

insert into product values(1, '스크류바', '아이스크림', 1200, '2020-05-01', '2020-10-01');
insert into product values(2, '마이쮸', '사탕', 900, '2020-01-01', '2021-01-01');
insert into product values(3, '초코파이', '과자', 3000, '2020-01-01', '2021-01-01');
insert into product values(4, '맛동산', '과자', 2200, '2020-02-01', '2020-10-20');
insert into product values(5, '참이슬', '주류', 1000, '2020-01-05', '2020-04-05');
insert into product values(6, '처음처럼', '주류', 1000, '2020-03-15', '2020-08-15');
insert into product values(7, '바나나킥', '과자', 1500, '2020-05-03', '2020-06-03');
insert into product values(8, '빠삐코', '아이스크림', 1000, '2019-12-01', '2020-06-01');
insert into product values(9, '멘토스', '사탕', 1200, '2020-03-20', '2020-12-31');
insert into product values(10, '오레오', '과자', 2100, '2019-06-01', '2020-06-01');

commit;

-- 날짜 조건
-- - 특정 항목을 검사하거나 기간으로 검색하는 경우가 많다
SELECT * FROM product;

-- 2020년에 제조된 상품 조회
SELECT * FROM product WHERE extract(YEAR FROM made) = 2020;
SELECT * FROM product WHERE to_char(made, 'YYYY') = '2020';
SELECT * FROM product WHERE
	made >= to_date('2020-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS')
	AND
	made <= to_date('2020-12-31 23:59:59', 'YYYY-MM-DD HH24:MI:SS');
SELECT * FROM product WHERE
	made BETWEEN
	to_date('2020-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS')
	AND
	to_date('2020-12-31 23:59:59', 'YYYY-MM-DD HH24:MI:SS');
	

-- (Q) 여름에 제조한 상품 목록 조회 (6~8월)
SELECT * FROM product WHERE
	extract(MONTH FROM made) >= 6 AND EXTRACT(MONTH FROM made) <= 8;
--샘 코드
SELECT * FROM product WHERE EXTRACT(MONTH FROM made) IN (6,7,8);
SELECT * FROM product WHERE EXTRACT(MONTH FROM made) BETWEEN 6 AND 8;
SELECT * FROM product WHERE TO_char(made, 'MM') IN ('06','07','08');

-- (Q) 2019년 하반기에 제조한 상품 목록 조회 (7~12월)
SELECT * FROM product WHERE TO_char(made, 'YYYY-MM') = '2019-07';
SELECT * FROM product WHERE
	made BETWEEN
	to_date('2019-07-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS')
	AND 
	to_date('2019-12-31 23:59:59', 'YYYY-MM-DD HH24:MI:SS');
--샘 코드
SELECT * FROM product WHERE
	EXTRACT(year FROM made) = 2019
	AND EXTRACT(MONTH FROM made) BETWEEN 7 AND 12;

SELECT * FROM product WHERE
	regexp_like(to_char(made,'YYYY-MM'),'^2019-(0[7-9]|1[0-2])$');
	
SELECT * FROM product WHERE made BETWEEN to_date('2019-07-01 00:00:00','YYYY-MM-DD HH24:MI:SS')
	AND to_date('2019-12-31 23:59:59','YYYY-MM-DD HH24:MI:SS');

-- (Q) 2020년 이후에 현재까지 제조한 상품 목록 조회
SELECT * FROM product WHERE to_char(made, 'YYYY') = '2020';
--샘코드
SELECT * FROM product WHERE
	made BETWEEN
	to_date('2020-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS')
	AND sysdate;

-- (Q) 최근 5년간 제조한 상품 목록 조회
SELECT * FROM product WHERE made BETWEEN SYSDATE-5 * 365 AND sysdate;

--5분
SELECT * FROM product WHERE made BETWEEN SYSDATE-5 /24/60 AND sysdate;
