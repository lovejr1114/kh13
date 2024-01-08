--2024.01.08 데이터베이스 평가 문제
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
rollback;
