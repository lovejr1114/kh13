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
