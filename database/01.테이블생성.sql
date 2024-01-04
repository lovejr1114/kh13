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
