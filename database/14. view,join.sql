-- [1] 테이블 1개로 게시판 구현(카테고리를 항목으로 설정)
create table board(
board_no number primary key,
board_title varchar2(300),
board_content varchar2(4000),
board_writer varchar2(20),
board_category varchar2(30) not null,
check(board_category in ('자유', '공지', '유머'))
);

insert into board values(1, '제목테스트', '내용테스트', 'testuser', '자유');
insert into board values(2, '제목테스트', '내용테스트', 'testuser', '공지');
insert into board values(3, '제목테스트', '내용테스트', 'testuser', '유머');

--자유게시판 조회
select * from board where board_category = '자유';
--유머게시판 조회
select * from board where board_category = '유머';
--공지게시판 조회
select * from board where board_category = '공지';

--뷰(view, 논리테이블)를 생성해서 조회를 편하게...
create view freeboard as 
select * from board where board_category = '자유';
create view humorboard as 
select * from board where board_category = '유머';
create view noticeboard as 
select * from board where board_category = '공지';

--뷰를 조회하면 뷰에 저장된 구문이 실행되어 결과가 나온다
select * from freeboard;
select * from humorboard;
select * from noticeboard;

drop table board;

-- [2] 카테고리를 별도의 테이블로 분할하여 구현
create table category(
category_no number primary key,
category_name varchar2(30) not null
);
insert into category values(1, '자유');
insert into category values(2, '유머');
insert into category values(3, '공지');

create table board(
board_no number primary key,
board_title varchar2(300),
board_content varchar2(4000),
board_writer varchar2(20),
board_category references category(category_no) on delete cascade
);
insert into board values(1, '테스트제목', '테스트내용', 'testuser', 1);--자유
insert into board values(2, '테스트제목', '테스트내용', 'testuser', 3);--공지
insert into board values(3, '테스트제목', '테스트내용', 'testuser', 2);--유머
insert into board values(4, '테스트제목', '테스트내용', 'testuser', null);

select * from category;
select * from board;

-- 테이블 조인(join)을 이용하여 합쳐서 조회
-- select * from board + category;
-- select 항목 from A inner join B on 합성조건 (커플만 조회)
-- select 항목 from A left outer join B on 합성조건 (솔로도 조회, A가 기준)
-- select 항목 from A right outer join B on 합성조건 (솔로도 조회, B가 기준)
select * from board 
	inner join category 
	on board.board_category = category.category_no;
