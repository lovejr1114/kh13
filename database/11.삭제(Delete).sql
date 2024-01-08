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
