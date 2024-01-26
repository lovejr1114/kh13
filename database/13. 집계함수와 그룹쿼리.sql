/* 
	집계함수와 그룹쿼리
	- 집계 함수는 테이블의 정보를 모아서 하나의 결과로 만드는 함수
 	- 단일행 함수는 테이블 정보만큼의 결과를 만들어내는 함수
 */

-- 단일행 함수는 조회 구문에 붙여서 사용할 수 있다.
select book.*, upper(book_title), lower(book_title), length(book_title) from book;

-- 집계 함수는 데이터 개수와 관계 없이 결과가 하나로 나온다
SELECT sum(book_price) from book;
select avg(book_price) from book;
select max(book_price) from book;
select min(book_price) from book;
select count(book_price) from book;

-- 집계함수는 조회구문에 붙여서 사용할 수 없다
select book_title, avg(book_price) from book;

-- 집계함수를 전체가 아닌 그룹별로 적용할 수도 있다
-- (ex) 전체 평균 가격 ---> 장르별 평균 가격
SELECT book_genre from book;

select book_genre from book group by book_genre;

select book_genre, sum(book_price), avg(book_price) from book group by book_genre;

-- (Q) product 테이블에서 상품종류별 개수와 최고, 최저가격을 출력
select type, count(type), max(price), min(price) from product group by type; --내가한거
select count(no) 개수, max(price) 최고가, min(price) 최저가 from product; --샘이한거
--뒤에 글씨는 별칭을 붙이는것
SELECT type from product;
SELECT distinct type from product; --중복제거 (그룹 아님)
SELECT type from product group by type;

select type, count(no) 개수, max(price) 최고가, min(price) 최저가 from product group by type;
