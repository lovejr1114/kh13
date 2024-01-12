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
