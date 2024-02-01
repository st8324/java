/*
테이블명만 쓰는 것과 DB명.테이블명을 쓰는 것의 차이
- 테이블명만 쓰는 경우는 내가 작업하려는 DB가 선택됐을 때 
- DB명.테이블명은 현재 선택된 DB와 상관없이 작업할 수 있다
*/
USE TEST;
# 테이블에 등록된 컬럼 순서에 상관 없이 추가할 때 나열한 컬럼 순서대로 값들을 넣어주면 됨 
INSERT INTO `MEMBER`(ID, PW, EMAIL, REG_DATE) 
	VALUES("ABC", "DEF", "ABC@NAVER.COM", NOW());
INSERT INTO `MEMBER`(PW, ID, REG_DATE, EMAIL) 
	VALUES("비번123", "ID1", NOW(), "ID1@NAVER.COM");
# 속성명을 생략한 대신, 테이블에 등록된 컬럼 순서대로 값들을 넣어주어야 함 
INSERT INTO MEMBER
	VALUES("ID2", "비번입니다", "ABCDEF@GMAIL.COM", NOW());
# NOW()를 이용해서 날짜를 문자열에 저장하면 날짜가 문자열로 변환되서 문제가 없음
# 날짜형태가 아닌 문자열을 DATETIME에 저장하려 하면 에러가 발생 
# INSERT INTO MEMBER
#	VALUES("ID3", "비번입니다", NOW() , "ABCDEF@GMAIL.COM");
# 날짜형태인 문자열을 DATETIME에 저장하려 하면 변환이 가능하기 때문에 정상 동작
INSERT INTO MEMBER
	VALUES("ID3", "비번입니다", NOW() , "2024-02-01 16:25:00");

# 아이디가 ID3인 회원의 이메일을 ID3@NAVER.COM으로 수정하는 쿼리
UPDATE 
	MEMBER 
SET 
	EMAIL = "ID3@NAVER.COM" 
WHERE 
	ID = "ID3";
# 아이디가 ID1인 회원의 비번을 IDABC로, 이메일을 IDABC@NAVER.COM으로 수정하는 쿼리
UPDATE
	MEMBER
SET
	PW = "IDABC",
    EMAIL = "IDABC@NAVER.COM"
WHERE
	ID = "ID1";
    
# 아이디가 ABC인 회원의 정보를 삭제하는 쿼리
DELETE 
FROM
	MEMBER
WHERE
	ID = "ABC";
    
# MEMBER 테이블을 조회
SELECT ID, PW, EMAIL, REG_DATE FROM MEMBER;
SELECT * FROM MEMBER;

# ID가 ID1인 회원의 정보를 조회
SELECT * FROM MEMBER WHERE ID = "ID1";

    
    