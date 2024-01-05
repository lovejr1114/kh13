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
