USE SHOPPINGMALL;

# MEMBER 테이블의 권한은 일반회원 : USER, 관리자 : ADMIN
# 아이디가 AMDIN이고, 비번이 ADMIN, 이메일이 ADMIN@GMAIL.COM, 번호가 010-0000-0000인 관리자가 
# 회원가입했을 때 필요한 쿼리 
INSERT INTO MEMBER VALUES("ADMIN", "ADMIN", "ADMIN@GMAIL", "010-0000-0000", "ADMIN", 0);

# 관리자가 다음의 제품을 등록할 때 필요한 쿼리
# 카테고리를 등록 : 기타 
INSERT INTO CATEGORY VALUES(NULL, "기타");
# 등록된 기타 카테고리의 기본키를 확인 후 아래 제품에 추가 
SELECT * FROM CATEGORY;
# 코드 : ABC001, 제품명 : 텀블러, 가격 : 20000, 내용 : 스타벅스 텀블러입니다, 카테고리 : 기타 1
INSERT INTO PRODUCT VALUES("ABC001", "텀블러", "스타벅스 텀블러입니다.", 20000, 1);
# 카테고리 : 전자제품, 의류, 식품, 자동차
INSERT INTO CATEGORY(CA_NAME) VALUES("전자제품"),("의류"),("식품"),("자동차");
/* 
코드 : ABC002, 제품명 : 볼펜, 	내용 : 모나미 볼펜, 	가격 : 1000, 카테고리 : 기타 1
코드 : ABC003, 제품명 : 지우개, 	내용 : 좋은 지우개, 	가격 : 500, 	카테고리 : 기타 1
코드 : ELC001, 제품명 : 마우스, 	내용 : 무선 마우스, 	가격 : 10000,	카테고리 : 전자제품 2
코드 : ELC002, 제품명 : 키보드, 	내용 : 무선 키보드, 	가격 : 50000,	카테고리 : 전자제품 2
코드 : CLO001, 제품명 : 모자, 	내용 : 좋은 모자,	가격 : 10000,	카테고리 : 의류 3
코드 : CLO002, 제품명 : 셔치, 	내용 : 구김없는 셔츠	가격 : 50000,	카테고리 : 의류 3
코드 : FOO001, 제품명 : 만두, 	내용 : 고기만두, 	가격 : 10000,	카테고리 : 식품 4
코드 : FOO002, 제품명 : 라면, 	내용 : 맛있는 라면, 	가격 : 3000, 	카테고리 : 식품 4
코드 : CAR001, 제품명 : 방향제, 	내용 : 향기 좋음, 	가격 : 5000, 	카테고리 : 자동차 5
*/
INSERT INTO PRODUCT VALUES
("ABC002", "볼펜","모나미 볼펜",1000,1),
("ABC003", "지우개","좋은 지우개",500,1),
("ELC001", "마우스", 	"무선 마우스", 10000,2),
("ELC002", "키보드", 	"무선 키보드", 50000,2),
("CLO001", "모자", 	"좋은 모자",10000,3),
("CLO002", "셔츠", 	"구김없는 셔츠",50000,3),
("FOO001", "만두", 	"고기만두",10000,4),
("FOO002", "라면", 	"맛있는 라면",3000,4),
("CAR001", "방향제", 	"향기 좋음",5000,5);

# 아이디 : abc123, 비번 : abc123, 이메일 abc123@kh.com 번호 : 011-1111-1111
# 아이디 : qwe123, 비번 : qwe123, 이메일 qwe123@kh.com 번호 : 011-2222-2222
INSERT INTO MEMBER(ME_ID, ME_PW, ME_EMAIL, ME_PHONE) VALUES
("abc123", "abc123", "abc123@kh.com", "011-1111-1111"),
("qwe123", "qwe123", "qwe123@kh.com", "011-2222-2222");

# abc123회원이 마우스를 장바구니에 2개 담았을 때 실행되는 쿼리 
INSERT INTO BASKET(BA_AMOUNT, BA_ME_ID, BA_PR_CODE)
VALUES(2, "abc123",	"ELC001");

# abc123회원이 마우스를 장바구니에 3개 담았을 때 실행되는 쿼리 
UPDATE BASKET 
SET 
    BA_AMOUNT = 3
WHERE
    BA_ME_ID = 'abc123'
        AND BA_PR_CODE = 'ELC001';
SELECT * FROM BASKET WHERE BA_ME_ID = "abc123";
SELECT * FROM PRODUCT WHERE PR_CODE = "ELC002";
# abc123회원이 키보드를 장바구니에 1개 담았을 실행되는 쿼리
INSERT INTO BASKET(BA_AMOUNT, BA_ME_ID, BA_PR_CODE) VALUES(1, "abc123", "ELC002");

# abc123회원이 장바구니에 담긴 모든 제품을 주문했을 때 실행되는 쿼리 
INSERT INTO `ORDER`(OR_AMOUNT, OR_TOTAL_PRICE, OR_ME_ID, OR_PR_CODE)
VALUES(3, 3*10000, "abc123", "ELC001"),
(1, 1*50000, "abc123", "ELC002");
# 장바구니에 담긴 제품을 구매하면 장바구니에는 해당 제품을 제거 
DELETE FROM BASKET WHERE BA_NUM = 1;
DELETE FROM BASKET WHERE BA_NUM = 2;
        
        
        








