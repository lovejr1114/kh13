--account 테이블 생성 구문
create table account(
owner varchar2(21),
base_rate number(5,2),
plus_rate number(5,2),
monthly number,
period number(3)
);

DROP TABLE account;

--soccer 테이블 생성 구문
create table soccer(
rank number(2),
name varchar2(21),
win number(2),
draw number(2),
lose number(2)
);
drop table soccer;

--olympic 테이블 생성 구문
create table olympic(
name varchar2(21),
event varchar2(60),
type char(6),
gold number(3),
silver number(3),
bronze number(3)
);

drop table olympic;


--테이블을 만들고 데이터를 추가하도록 코드 작성
CREATE TABLE student(
name varchar2(21),
score number(3)
);

--데이터 추가
--INSERT INTO 테이블이름(형식들) values(값들);
--(주의) 오라클에서 문자열은 외따옴표를 쓴다 (') 
INSERT INTO student(name, score) values('김정은', 95);

--데이터 조회
--SELECT * FROM 테이블이름;
SELECT *FROM student;


--통신사 요금제 테이블 생성 및 데이터 추가 코드
CREATE TABLE telecom(
agency varchar2(45),
goods varchar2(50),
monthly1 NUMBER,
GB_data number(3),
calling number(4),
sms number(4)
);

DROP TABLE telecom;

INSERT INTO telecom(agency,goods,monthly1,GB_data,calling,sms) values('SK','5G언택트52',52000,200,1000,2000);
INSERT INTO telecom(agency,goods,monthly1,GB_data,calling,sms) values('KT','5G세이브',54000,100,900,1500);
INSERT INTO telecom(agency,goods,monthly1,GB_data,calling,sms) values('LG','5G시그니처',130000,500,2000,2500);

SELECT *FROM telecom;



/*
   테이블 제약 조건 (table constraint)
   - 테이블에 추가되는 데이터에 대한 조건을 설정할 수 있다
   - 종류는 null(없음), 중복, 값의 범위 or 조건 등이 있다
   - null을 허용하지 않으려면 컬럼 옆에 not null 키워드를 추가한다 
   - 중복을 허용하지 않으려면 컬럼 옆에 unique 키워드를 추가한다 
   - 허용되는 값을 지정하려면 컬럼 옆에 check 키워드를 추가한다
 */


CREATE TABLE menu(
menu_name varchar2(60) NOT NULL UNIQUE
	CHECK(regexp_like(menu_name, '^[가-힣]+$')),
menu_type varchar2(9) NOT NULL CHECK(menu_type IN ('디저트','음료')),
menu_price NUMBER NOT NULL CHECK(menu_price >= 0),
--menu_event char(1) NOT NULL check(menu_event = 'Y' or menu_event = 'N')
menu_event char(1) NOT NULL check(menu_event IN ('Y','N'))
);
DROP TABLE menu;

INSERT INTO menu(menu_name,menu_type,menu_price,menu_event)
values('아메리카노','음료',2500,'Y');

SELECT*FROM menu;



--학원 강좌 정보 테이블 생성 및 출력
CREATE TABLE class(
class_course varchar2(60) NOT NULL unique,
class_time number NOT NULL CHECK(class_time >= 0 and MOD(class_time, 30) = 0),
class_price NUMBER NOT NULL CHECK(class_price >= 0),
class_type varchar(12) NOT NULL check(class_type IN ('온라인','오프라인','혼합'))
);

DROP table class;

INSERT INTO class(class_course,class_time,class_price,class_type)
	values('자바 마스터과정',90,1000000,'온라인');
INSERT INTO class(class_course,class_time,class_price,class_type)
	values('파이썬 기초',60,600000,'온라인');
INSERT INTO class(class_course,class_time,class_price,class_type)
	values('웹 개발자 단기완성',120,1200000,'오프라인');

SELECT * FROM class;



--휴대폰 판매정보 테이블 생성 및 출력 (선생님 코드 보자 그냥)
CREATE TABLE phone(
phone_name varchar2(50) NOT NULL,
phone_telecom char(2) NOT NULL CHECK(phone_telecom IN ('SK','KT','LG')),
phone_price NUMBER NOT NULL CHECK(phone_price >= 0),
phone_agreement_month NUMBER check(phone_agreement_month IN ('null','24','36'))
--이름+통신사를 합쳐서 같은 경우는 없다
unique(phone_name, phone_telecom)
);

DROP TABLE phone;

INSERT INTO phone(phone_name,phone_telecom,phone_price,phone_agreement_month)
	values('갤럭시Fold4','SK',1800000,null);
INSERT INTO phone(phone_name,phone_telecom,phone_price,phone_agreement_month)
	values('갤럭시Fold4','KT',1750000,24);
INSERT INTO phone(phone_name,phone_telecom,phone_price,phone_agreement_month)
	values('아이폰15','LG',2000000,30);
INSERT INTO phone(phone_name,phone_telecom,phone_price,phone_agreement_month)
	values('아이폰15','SK',1990000,null);

SELECT * FROM phone;


/*
	기본키(Primary key)
	- 테이블에 단 한개만 설정할 수 있는 유일한 불변 값
	- 대표 항목 역할을 하며 NOT NULL + UNIQUE 효과를 가짐
	- 회원으로 치면 "아이디"와 "닉네임" 중에서 "아이디"가 기본키 역할을 수행할 수 있다
	- 모든 항목 중에 가장 검색 속도가 빠름
	- 테이블 당 1개를 반드기 만들 것을 권장(없으면 번호라도 생성해서 지정)
*/

--포켓몬스터 테이블
DROP TABLE pocketmon;
CREATE TABLE pocketmon(
pocketmon_no NUMBER PRIMARY key,
pocketmon_name varchar2(30) NOT null,
pocketmon_type varchar2(9) NOT NULL
);
INSERT INTO pocketmon(pocketmon_no,pocketmon_name,pocketmon_type)
	values(1,'이상해씨','풀');
INSERT INTO pocketmon(pocketmon_no,pocketmon_name,pocketmon_type)
	values(4,'파이리','불꽃');
INSERT INTO pocketmon(pocketmon_no,pocketmon_name,pocketmon_type)
	values(7,'꼬부기','물');
INSERT INTO pocketmon(pocketmon_no,pocketmon_name,pocketmon_type)
	values(2,'피카츄','전기');

SELECT * FROM pocketmon;
COMMIT;


--게시판 테이블 생성 문제(과제)
/*다음 조건을 만족하는 테이블을 생성하고 샘플 데이터를 등록하시오

	게시판 테이블(table board)
	- 게시글 번호(board_no)
	- 필수 항목이며 중복이 불가한 숫자
	게시글 제목(board_title) 
	- 한글 100자 이내로 설정 가능하며 필수 항목
	게시글 내용(board_content)
	- 가능한 최대의 문자열 크기로 설정하며 필수 항목
	게시글 작성자(board_writer)
	- 게시글 작성한 사람의 아이디(영문숫자8~20자)
	- 작성자가 탈퇴한 경우 null로 설정됨
	게시글 조회수(board_readcount)
	- 0 이상의 숫자로 설정되는 항목*/
CREATE TABLE board(
  board_no NUMBER PRIMARY KEY, 
  board_title varchar2(300) NOT NULL,
  board_content varchar2(4000) NOT null,
  board_writer varchar2(20) CHECK(regexp_like(board_writer, '^[a-zA-Z0-9]{8,20}$')),
  board_readcount NUMBER DEFAULT 0 NOT NULL CHECK(board_readcount >= 0)
);

DROP TABLE board;

INSERT INTO board(board_no, board_title, board_content, board_writer, board_readcount)
	VALUES(1, 'sql을 배우다', 'sql 생각보다 쉽지 않네', 'kimjungeun', 1234);
INSERT INTO board(board_no, board_title, board_content, board_writer, board_readcount)
	VALUES(2, '과제', '과제라니', 'Gorani1104', 47394);
INSERT INTO board(board_no, board_title, board_content, board_writer)
	VALUES(3, '약속', '약속장소에 가야돼', 'HitManBang');

SELECT * FROM board;


/*
	시퀀스 (sequence)
	- 데이터베이스 객체 중 하나
	- 번호 생성기 
	- 프라이머리키 생성하는 용도로 쓰인다
	- 테이블과 세트로 사용하는 경우가 많으면 "기본키" 생성하는 목적으로 주로
*/
DROP SEQUENCE product_seq;
CREATE SEQUENCE product_seq;
-- create sequence product_seq nocache;
DROP TABLE product;
CREATE TABLE product(
product_no NUMBER PRIMARY KEY,
product_name varchar2(60) NOT NULL,
product_price NUMBER NOT null
);

--시퀀스를 이용한 데이터 생성(시퀀스이름.nextval)
INSERT INTO product(product_no, product_name, product_price)
values(product_seq.nextval ,'30인치 모니터',250000);
INSERT INTO product(product_no, product_name, product_price)
values(product_seq.nextval ,'RTX 3080 Ti',1460000);
SELECT * FROM product;

-- 시퀀스의 자세한 정보 확인
SELECT * FROM USER_SEQUENCES; 


/*
	날짜 데이터
	- DATE 또는 timestamp 형태를 사용
	- date는 초까지, timestamp는 밀리초까지 저장
	- java.SQL.DATE 클래스와 DATE 형태가 호환됨
 	- java.SQL.Timestamp 클래스와 timestamp 형태가 호환됨
	- 연/월/일/시/분/초(+밀리초)가 모두 필요한 경우 사용한다
	- 변환 명령은 to_date()
	- 변환 형식 : Y(연도), M(월), D(일), HH/HH24(시간), MI(분), S(초)
	- 현재 시각을 구하는 키워드 존재 (sysdate)(systimestamp)
	- 날짜는 더하기 빼기가 가능하다 (단위 : 일)
*/
DROP SEQUENCE funding_seq;
CREATE SEQUENCE funding_seq;
DROP TABLE funding;
CREATE TABLE funding(
funding_no NUMBER PRIMARY KEY,
funding_title varchar2(90) NOT NULL,
funding_dest NUMBER NOT NULL,
funding_begin DATE NOT NULL,
funding_end DATE NOT null
);
--날짜는 문자열로도 가능하다
INSERT INTO funding(funding_no, funding_title, funding_dest, funding_begin, funding_end)
VALUES(funding_seq.nextval,'자바 서적',500000,'2024-01-10','2024-01-31');
--변환명령을 사용하면 더 정확하게 형식을 지정할 수 있다
-- to_date(값, 형식)
INSERT INTO funding(funding_no, funding_title, funding_dest, funding_begin, funding_end)
VALUES(funding_seq.nextval,'데이터베이스 서적',600000,
	to_date('2024-01-10','YYYY-MM-DD'), to_date('2024-01-31','YYYY-MM-DD'));
INSERT INTO funding(funding_no, funding_title, funding_dest, funding_begin, funding_end)
VALUES(funding_seq.nextval,'웹 개발 서적',700000,
	to_date('2024-01-05 10:58:30','YYYY-MM-DD HH24:MI:SS'),
	to_date('2024-01-31 23:59:59','YYYY-MM-DD HH24:MI:SS'));
INSERT INTO funding(funding_no, funding_title, funding_dest, funding_begin, funding_end)
VALUES(funding_seq.nextval,'클라우드 서적',750000,
	sysdate,
	to_date('2024-01-31 23:59:59','YYYY-MM-DD HH24:MI:SS'));
INSERT INTO funding(funding_no, funding_title, funding_dest, funding_begin, funding_end)
VALUES(funding_seq.nextval,'한달짜리 펀딩',760000,
	sysdate, sysdate+30);
	
SELECT * FROM funding;


--테이블 정의서 book테이블
DROP SEQUENCE book_seq;
CREATE SEQUENCE book_seq;
DROP TABLE book;
CREATE TABLE book(
book_id NUMBER PRIMARY key,
book_title varchar2(300) NOT null,
book_author varchar2(90) CHECK(regexp_like(book_author, '^[^!@#$]+$')),
book_publication_date char(10) CHECK(regexp_like(book_publication_date,
'^([0-9]{4})-(02-(0[1-9]|1[0-9]|2[0-8])|(0[469]|11)-(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))$')),
book_price NUMBER(*,2) DEFAULT 0 NOT NULL check(book_price >= 0),
book_publisher varchar2(90),
book_page_count NUMBER NOT NULL check(book_page_count >= 1),
book_genre varchar2(20) NOT null
);
INSERT INTO book(book_id, book_title, book_author, book_publication_date,
	book_price,book_publisher, book_page_count, book_genre)
values(book_seq.nextval, '김정화 푸드','김정화','2024-01-05',
	6.48,'한식뷔페',520,'요리');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(book_seq.nextval, 'Harry Potter 1', 'J.K. Rowling', '2001-06-26', 19.99, 'Scholastic', 320, 'Fantasy');															
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(book_seq.nextval, 'To Kill a Mockingbird', 'Harper Lee', '1960-07-11', 14.99, 'Grand Central Publishing', 336, 'Classic');															
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(book_seq.nextval, 'The Great Gatsby', 'F. Scott Fitzgerald', '1925-04-10', 12.99, 'Scribner', 180, 'Classic');														
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(book_seq.nextval, '1984', 'George Orwell', '1949-06-08', 10.99, 'Secker & Warburg', 328, 'Dystopian');															
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(book_seq.nextval, 'Pride and Prejudice', 'Jane Austen', '1813-01-28', 9.99, 'Penguin Classics', 432, 'Romance');															
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(book_seq.nextval, 'The Hobbit', 'J.R.R. Tolkien', '1937-09-21', 15.99, 'Houghton Mifflin Harcourt', 320, 'Fantasy');															
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(book_seq.nextval, 'The Catcher in the Rye', 'J.D. Salinger', '1951-07-16', 11.99, 'Little, Brown and Company', 224, 'Classic');															
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(book_seq.nextval, 'Lord of the Rings', 'J.R.R. Tolkien', '1954-07-29', 29.99, 'Allen & Unwin', 1178, 'Fantasy');															
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(book_seq.nextval, 'To the Lighthouse', 'Virginia Woolf', '1927-05-05', 13.99, 'Harcourt, Brace and Company', 209, 'Modernist');															
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(book_seq.nextval, 'The Alchemist', 'Paulo Coelho', '1988-06-01', 9.99, 'HarperOne', 208, 'Fiction');															

SELECT * FROM book;
COMMIT;

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
DROP TABLE product;
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
insert into product values(11, '테스트', '과자', 13000, '2019-06-01', '2020-06-01');
ROLLBACK; --지금까지의 작업 내용을 취소
commit; --지금까지의 작업내용을 저장
SELECT * FROM product;

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



-- 정렬(order by)
-- 조건으로 데이터까지 다 골라냈다면 원하는 기준에 맞게 정렬할 수 있다
-- 조회 구문의 마지막에 'order by 항목 asc/desc'를 적는다
-- (중요) 조건보다 뒤에 작성되어야 한다

SELECT * FROM book;
SELECT * FROM product;

SELECT *FROM book ORDER BY book_id ASC; --오름차순
SELECT * FROM book ORDER BY book_id DESC; --내림차순

-- (Q) 상품을 최근 제조한 순으로 조회 (최신순)
SELECT * FROM product ORDER BY made DESC;
-- 같은것이 나올 수도 있으니까 명확하게.
SELECT * FROM product ORDER BY made DESC, NO asc;

-- (Q) 상품을 이름순으로 출력 (가나다 순)
SELECT * FROM product ORDER BY name ASC;
-- 이름 같은 상품이 나올 수 있으니 조금 더 안전한 코드를 사용 (예측이 가능한)
SELECT * FROM product ORDER BY name ASC, NO asc;

-- (Q) 상품을 종류별로 가격이 비싼 순으로 출력
SELECT * FROM product ORDER BY price DESC;
-- 종류별로 추가코드와 안전한 프라이머리키 코드
SELECT * FROM product ORDER BY TYPE  ASC, price DESC, NO asc;

-- (Q) 유통기한이 가장 짧은 상품부터 출력
SELECT * FROM product ORDER BY expire ASC;
-- 제조와 유통 사이
SELECT * FROM product ORDER BY expire - made ASC;
SELECT product.*, expire-made 유통기한 FROM product ORDER BY 유통기한 ASC, NO asc;





--평가
CREATE TABLE MEMBER
(MEMBER_ID varchar2(20) PRIMARY KEY,
MEMBER_PW VARCHAR2(20) NOT NULL,
MEMBER_NICK VARCHAR2(20) NOT NULL UNIQUE);


/*
	수정(update)
	- UPDATE 테이블명 SET 변경구문 [where 조건]
	- 사실상 조건은 무조건 사용한다고 봐야하며, 특히 PK(primary key) 조건이 많이 쓰임
*/

-- 모든 상품의 가격을 0원으로 변경
UPDATE product SET price=0;

--모든 상품의 종류를 과자로, 가격을 100원으로 변경
UPDATE product SET TYPE = '과자', price =100;

-- 1번 상품의 가격을 2000원으로 변경
UPDATE product SET price = 2000 WHERE no=1;
-- (주의사항) 없는 번호도 실행은 된다
UPDATE product SET price = 2000 WHERE no=100;

-- (Q) 멘토스의 가격을 1000원으로 변경하고 분류를 과자로 변경
UPDATE product SET TYPE = '과자', price = 1000 WHERE name= '멘토스';

-- (Q) 과자의 가격을 500원 할인(오라클에는 누적연산이 없습니다)
UPDATE product SET price = price-500 WHERE TYPE = '과자';
--홈페이지 조회수 올릴 때 이런 코드를 사용

-- (Q) 아이스크림의 가격을 10% 인상(오라클에는 누적연산이 없습니다)
UPDATE product SET price = price+(price*10/100) WHERE TYPE = '아이스크림';
-- price*110/100 또는 price*1.1 로 식 쓴다.

SELECT * FROM product;




/*
	삭제(delete)
	-전체를 지울 일은 거의 존재하지 않으므로 조건을 결합하여 사용
*/

-- 전체 삭제
DELETE product; --추천
DELETE FROM product; --가능하지만 비추천(select와 헷갈림)

-- 1번 상품 삭제
DELETE product WHERE NO=1;

-- (Q) 과자와 아이스크림 삭제
DELETE product WHERE TYPE IN ('과자','아이스크림');

-- (Q) 2020년 상반기에 생산된 제품 삭제
DELETE product WHERE made BETWEEN 
	TO_date('2020-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS')
	AND 
	to_date('2020-06-30 23:59:59', 'YYYY-MM-DD HH24:MI:SS');

SELECT * FROM product;
ROLLBACK;


--emp 문제
DROP TABLE emp;
CREATE TABLE emp(
emp_no number primary key,--사원번호, 시퀀스로 자동 부여
emp_name varchar2(21) not null,--사원의 한글 이름
emp_dept varchar2(30) not null,--사원의 소속 부서
emp_date char(10) not null,--사원의 입사일
emp_sal number default 0 not null check(emp_sal >= 0)--사원의 급여(원)
);
DROP SEQUENCE emp_seq;
create sequence emp_seq;

INSERT INTO emp(emp_no, emp_name, emp_dept, emp_date, emp_sal)
	VALUES (emp_seq.nextval, '김정은','C강의실','2023-12-04',200000);
INSERT INTO emp(emp_no, emp_name, emp_dept, emp_date, emp_sal)
	VALUES (emp_seq.nextval, '피카츄','영업부','2019-08-25',550000);
INSERT INTO emp(emp_no, emp_name, emp_dept, emp_date, emp_sal)
	VALUES (emp_seq.nextval, '피카츄','홍보기획부','2020-01-01',150000);
	
SELECT * FROM emp;
COMMIT;
ROLLBACK;
UPDATE emp SET emp_name='정실버',emp_dept='금은동', emp_date='2024-01-01',
	emp_sal=1000000 WHERE emp_no=2;

--Menu등록 과제
DROP TABLE menu;
create table menu(
menu_no number primary key,--메뉴번호, 시퀀스로 자동 부여
menu_name_kor varchar2(60) not null,--메뉴 한글 이름
menu_name_eng varchar2(60) not null,--메뉴 영문 이름
menu_type varchar2(30) not null,--메뉴 종류
menu_price number default 0 not null check(menu_price >= 0)--메뉴 판매가(원)
);
DROP SEQUENCE menu_seq;
create sequence menu_seq;

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
SELECT
  menu_seq.nextval,
  '메뉴' || level,
  'Menu' || level,
  CASE WHEN mod(level, 3) = 0 THEN '한식'
       WHEN mod(level, 3) = 1 THEN '양식'
       ELSE '일식'
  END,
  5000 + (level * 1000)
FROM dual
CONNECT BY level <= 10;

SELECT * FROM menu;
COMMIT;
ROLLBACK;

--검색조회
--java에서 포켓몬검색1
--SELECT * FROM pocketmon WHERE pocketmon_name LIKE '피카' || '%';
--java에서 포켓몬검색2
--SELECT * FROM pocketmon WHERE instr(항목명, 찾고싶은 글자) > 0;
SELECT * FROM pocketmon WHERE instr(pocketmon_name, ?) > 0;

--과제
SELECT * FROM emp WHERE emp_name LIKE '김정' || '%' or emp_dept LIKE '영업' || '%';
SELECT * FROM emp WHERE (instr(emp_name, '김정') > 0 OR instr(emp_dept, '영업') > 0);


--회원 관리 시스템 member 테이블 생성
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
member_id varchar2(20) PRIMARY KEY,
member_pw varchar2(15) NOT NULL,
member_nick varchar2(30) NOT NULL UNIQUE,
member_birth char(10),
member_contact char(11),
member_email varchar2(60) NOT null,
member_post char(6),
member_address1 varchar2(300),
member_address2 varchar2(300),
member_level varchar2(12) DEFAULT '일반회원' NOT null,
member_point NUMBER DEFAULT 0 NOT null,
member_join DATE DEFAULT sysdate NOT null,
member_login date,

CHECK(regexp_like(member_id, '^[a-z][a-z0-9]{7,19}$')),
CHECK(regexp_like(MEMBER_pw, '^[A-Za-z0-9!@#$]{6,15}$')
			AND
			regexp_like(member_pw, '[A-Z]+')
			AND 
			regexp_like(member_pw, '[a-z]+')
			AND 
			regexp_like(member_pw, '[0-9]+')
			AND 
			regexp_like(member_pw, '[!@#$]+')),
CHECK(regexp_like(member_nick, '^[가-힣][가-힣0-9]{1,9}$')),
CHECK(regexp_like(member_birth, 
	'^([0-9]{4})-(02-(0[1-9]|1[0-9]|2[0-8])|(0[469]|11)-(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))$')),
check(regexp_like(member_contact, '^010[1-9][0-9]{3}[0-9]{4}$')),
check(regexp_like(MEMBER_email, '@')),
check((member_post IS NULL AND member_address1 IS NULL AND member_address2 IS null)
		OR 
		(member_post IS NOT NULL AND member_address1 IS NOT NULL AND member_address2 IS NOT null)),
CHECK(member_level IN ('일반회원','우수회원','관리자')),
check(member_point >= 0)
);

INSERT INTO member(member_id, member_pw, member_nick, member_birth, member_contact,
	member_email, member_post, member_address1, member_address2, member_level,
	member_point, member_join, member_login)
VALUES ('kkje1114','kkje1114','김정은','1995-11-04','01012345678','kkje1114@naver.com','17028',
			'서울시 강서구','가양동','일반회원',0,sysdate,'1234');
insert into member(member_id, member_pw, member_nick, member_email)
values('testuser1', 'Testuser1!', '테스트유저1', 'testuser1@khacademy.com');

SELECT * FROM MEMBER;
COMMIT;
ROLLBACK;

UPDATE MEMBER SET member_pw = 'TEST@a123' WHERE member_id= 'test2kh13';

/*
 	외래키 (Foreign Key)
 	- 다른 테이블과 연결하기 위해 사용하는 도구
 	- 1대 N 관계같은 구조적으로 결합되어 있는 형태를 구현할 때 사용
 	- 데이터의 안정성이 올라간다
 	
 	<외래키 옵션>
 	- 외래키 뒤에 on delete 를 붙이면 삭제 시 자동처리를 지시할 수 있다
 	[1] on delete cascade를 붙이면 상위 항목이 지워지면 하위 항목이 삭제된다
 		(게시글 삭제되면 댓글도 삭제 / 상품삭제하면 리뷰도 삭제 등...)
 	[2] on delete set null 을 붙이면 상위 항목이 지워지면 하위 항목의 외래키 값이 null로 변경된다
 	[3] on delete를 안붙이면 하위 항목이 있으면 상위 항목을 지울 수 없다
 */
--포켓몬스터 테이블
DROP TABLE monster;
CREATE TABLE monster(
monster_no NUMBER PRIMARY KEY,
monster_name varchar2(30) NOT null
);
--포켓몬스터 속성 테이블
CREATE TABLE monster_attr(
--monster_no REFERENCES monster(monster_no),
--monster_no REFERENCES monster(monster_no) ON DELETE cascade,
monster_no REFERENCES monster(monster_no) ON DELETE SET null,
attr_name varchar2(30) NOT null
);
-- 1, 이상해씨, 풀/독
INSERT INTO monster(monster_no, monster_name) VALUES (1,'이상해씨');
INSERT INTO monster_attr(monster_no, attr_name) VALUES (1, '풀');
INSERT INTO monster_attr(monster_no, attr_name) VALUES (1, '독');
COMMIT;
-- 4, 파이리, 불
INSERT INTO monster(monster_no, monster_name) values(4,'파이리');
INSERT INTO monster_attr(monster_no, attr_name) values(4,'불');
COMMIT;
-- 1번(이상해씨) 삭제 (지울 때는 반대로 하위속성 먼저 지우고 지워야 함.)
DELETE monster_attr WHERE monster_no=1;
DELETE monster WHERE monster_no=1;
ROLLBACK;


-- 학생 테이블 생성
DROP TABLE student;
CREATE TABLE student (
  student_id NUMBER PRIMARY KEY,
  name VARCHAR2(50) NOT NULL,
  korean_score NUMBER CHECK (korean_score >= 0 AND korean_score <= 100) NOT NULL,
  math_score NUMBER CHECK (math_score >= 0 AND math_score <= 100) NOT NULL,
  english_score NUMBER CHECK (english_score >= 0 AND english_score <= 100) NOT NULL
);
drot SEQUENCE student_seq;
CREATE SEQUENCE student_seq;

SELECT * FROM student;
COMMIT;


--240119 평가
SELECT * FROM board;
DROP table board;
ROLLBACK;
update board SET board_readcount= +1, board_title= CONCAT(board_title, ' (인기글)') WHERE board_no=3;

SELECT * FROM product;
select * from product order by product_price desc where product_price < 10000;
SELECT poduct_name, product_price FROM product_product WHERE product_price <= 10000 ORDER BY product_price asc;
--위에 조회는 product_만 빼주면 조회 될 것임
CREATE TABLE BOARD(
BOARD_NO NUMBER PRIMARY KEY,
BOARD_TITLE VARCHAR2(300) NOT NULL,
BOARD_CONTENT VARCHAR2(4000) NOT NULL
);
CREATE SEQUENCE BOARD_SEQ;
SELECT * FROM BOARD;


SELECT * FROM pocketmon;
SELECT * FROM emp;
SELECT * FROM menu ORDER BY menu_no asc;
