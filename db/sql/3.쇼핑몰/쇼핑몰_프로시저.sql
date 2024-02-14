
# 제품을 추가하는 프로시저 
# 제품 코드는 영문3자리(주어짐), 숫자3자리(같은 카테고리로 등록된 제품들 수를 이용)
# 주어지는 정보 : 제품코드영문3자리, 제품명, 내용, 가격, 카테고리명 
# 프로시저 실행 결과 : 제품이 등록 
USE SHOPPINGMALL;

DROP PROCEDURE IF EXISTS INSERT_PRODUCT;
DELIMITER //
CREATE PROCEDURE INSERT_PRODUCT(
	IN _CODE CHAR(3),
    IN _TITLE VARCHAR(50),
    IN _CONTENT TEXT,
    IN _PRICE INT,
    IN _CATEGORY VARCHAR(10)
)
BEGIN
	DECLARE _COUNT INT;
    DECLARE _PR_CODE VARCHAR(15);
    DECLARE _CA_NUM INT;
    # _CATEGROY와 일치하는 등록된 제품 수를 찾아서 +1을 한 후 변수에 저장 
    SET _COUNT = (
		SELECT COUNT(*) + 1 FROM PRODUCT 
        JOIN CATEGORY ON CA_NUM = PR_CA_NUM
		WHERE CA_NAME = _CATEGORY);
	
    # _CODE와 _COUNT를 이용하여 _PR_CODE를 생성
    # _COUNT가 3자리가 아니면 앞에 '0'을 붙여서 3자리로 만든 후 제품 코드를 생성 
    SET _PR_CODE = CONCAT(_CODE, LPAD(_COUNT, 3, '0'));
    
    # _CATEGORY를 이용하여 _CA_NUM를 찾음 
    SET _CA_NUM = (SELECT CA_NUM FROM CATEGORY WHERE CA_NAME = _CATEGORY);
    
    IF _CA_NUM IS NOT NULL THEN 
		INSERT INTO PRODUCT(PR_CODE, PR_TITLE, PR_CONTENT, PR_PRICE, PR_CA_NUM)
        VALUES(_PR_CODE, _TITLE, _CONTENT, _PRICE, _CA_NUM);
    END IF;
    
END //
DELIMITER ;

# CALL INSERT_PRODUCT('ABC', '수정펜', '수정펜입니다', 3000, '기타');
# CALL INSERT_PRODUCT('ABC', '수정펜', '수정펜입니다', 3000, 'ABC');
/*
SELECT 
    COUNT(*) + 1
FROM
    PRODUCT
        JOIN
    CATEGORY ON CA_NUM = PR_CA_NUM
WHERE
    CA_NAME = '기타';
    
SELECT 
    COUNT(*) + 1
FROM
    PRODUCT
WHERE
    PR_CA_NUM = (SELECT 
            CA_NUM
        FROM
            CATEGORY
        WHERE
            CA_NAME = '기타');
*/

# 제품을 주문하는 프로시저 
DROP PROCEDURE IF EXISTS INSERT_ORDER;
DELIMITER //
CREATE PROCEDURE INSERT_ORDER(
	IN _AMOUNT INT,
    IN _ID VARCHAR(13),
    IN _PR_CODE VARCHAR(15)
)
BEGIN
	DECLARE _PRICE INT; # 제품 가격
    DECLARE _TOTAL_PRICE INT; # 제품 총 가격 
    
    # 제품 가격을 가져옴 
    SET _PRICE = (SELECT PR_PRICE FROM PRODUCT WHERE PR_CODE = _PR_CODE);
    # 제품 총 가격을 계산 
    SET _TOTAL_PRICE = _PRICE * _AMOUNT;
    # ORDER 테이블에 데이터를 추가 
    INSERT INTO `ORDER`(OR_AMOUNT, OR_TOTAL_PRICE, OR_ME_ID, OR_PR_CODE)
    VALUES(_AMOUNT, _TOTAL_PRICE, _ID, _PR_CODE);
END //
DELIMITER ;
CALL INSERT_ORDER(3, 'qwe123', 'ABC004');
