# 문자열 함수
SELECT LENGTH("안녕"); # 바이트 수를 리턴
SELECT CHAR_LENGTH("안녕"); # 글자수를 리턴
SELECT CONCAT("%", "안녕", "%");	# 문자열들을 이어 붙여서 리턴 
SELECT FIELD("안녕", "HI", "HELLO", "안녕", "안녕하세요"); # 안녕이 있는 위치를 리턴. 1부터 시작, 없으면 0
SELECT INSTR("안녕하세요", "안녕"); #안녕의 시작 위치를 리턴, 1부터 시작 
SELECT LOCATE("안녕", "안녕하세요"); #안녕의 시작 위치를 리턴, 1부터 시작 
SELECT FORMAT(10000.123, 2); # 소수점 2째자리 까지 표현. 3자리마다 , 추가
SELECT BIN(31), OCT(31), HEX(31);
SELECT CONCAT(LPAD(HEX(255),2,'0'), LPAD(HEX(0),2,'0'), LPAD(HEX(0),2,'0')) AS '색상코드';
SELECT INSERT('c의 정석', 1, 1, 'JAVA'); # 1번지부터 1글자를 제거하고(c를 제거), 주어진 문자열(JAVA)를 추가 
SELECT LEFT("안녕하세요.", 2);
SELECT RIGHT("안녕하세요.", 4);
SELECT LOWER("ABCdef"), UPPER("ABCdef");
SELECT LPAD("1", 3, "0"), RPAD("1", 3, "0");
SELECT REPEAT("안녕",3);
SELECT REPLACE("C의 정석", "C", "JAVA");
SELECT REVERSE("ABCDEF");
SELECT SUBSTRING("자바의 정석", 1, 2);

# 시간 함수
SELECT ADDDATE(NOW(), 2);
SELECT SUBDATE(NOW(), 2);
SELECT ADDTIME("11:30", "2:00:00");
SELECT SUBTIME("11:30", "2:00:00");
SELECT YEAR(NOW()), MONTH(NOW()), DAY(NOW());
SELECT DATE(NOW()), TIME(NOW());
SELECT DATEDIFF("2024-03-02", NOW());
SELECT TIMEDIFF("11:30", "9:00");
SELECT DATE_ADD(NOW(), INTERVAL 1 DAY);
SELECT DATE_ADD(NOW(), INTERVAL 3 WEEK);
SELECT DATE_ADD(NOW(), INTERVAL 1 YEAR);
SELECT DATE_ADD(NOW(), INTERVAL "1 1" YEAR_MONTH);

# 수학 함수
SELECT FLOOR(1.23), CEIL(1.23), ROUND(1.23), ABS(-1);