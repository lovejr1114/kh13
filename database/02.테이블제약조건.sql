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



-- 휴대폰 판매 정보 테이블
create table phone(
phone_name varchar2(60) not null,
phone_telecom char(2) not null check(phone_telecom in ('SK', 'KT', 'LG')),
phone_price number not null check(phone_price >= 0),
phone_contract number(2) check(phone_contract in (0, 24, 36)),
-- 이름+통신사를 합쳐서 같은 경우는 없다
unique(phone_name, phone_telecom)
);
drop table phone;

insert into phone(phone_name, phone_telecom, phone_price, phone_contract)
values('갤럭시Fold4', 'SK', 1800000, null);
insert into phone(phone_name, phone_telecom, phone_price)
values('갤럭시Fold4', 'SK', 1800000);
insert into phone(phone_name, phone_telecom, phone_price, phone_contract)
values('갤럭시Fold4', 'KT', 1750000, 24);
insert into phone(phone_name, phone_telecom, phone_price, phone_contract)
values('아이폰15', 'LG', 2000000, 36);
insert into phone(phone_name, phone_telecom, phone_price, phone_contract)
values('아이폰15', 'SK', 1990000, null);
