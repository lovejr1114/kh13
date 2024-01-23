
--포트 확인
SELECT dbms_xdb.gethttpport() FROM dual;

--포트 변경
EXEC dbms_xdb.sethttpport(9090);
