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
