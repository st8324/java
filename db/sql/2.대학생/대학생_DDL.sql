# 대학생 관리 프로그램 물리적 설계

# DB 생성
DROP DATABASE IF EXISTS university;
CREATE DATABASE IF NOT EXISTS university;

# DB 선택
USE university;

# student 테이블 삭제 후 추가
DROP TABLE IF EXISTS student;
CREATE TABLE IF NOT EXISTS student(
	st_num CHAR(10) PRIMARY KEY,
    st_name VARCHAR(30) NOT NULL,
    st_major VARCHAR(15) NOT NULL,
    st_grade INT NOT NULL DEFAULT 1
);

# professor 테이블 삭제 후 추가
DROP TABLE IF EXISTS professor;
CREATE TABLE IF NOT EXISTS professor(
	pr_num CHAR(10) PRIMARY KEY,
    pr_name VARCHAR(30) NOT NULL,
    pr_room VARCHAR(100),
    pr_major VARCHAR(15) NOT NULL
);

# lecture 테이블 삭제 후 추가
DROP TABLE IF EXISTS lecture;
CREATE TABLE IF NOT EXISTS lecture(
	le_num INT PRIMARY KEY AUTO_INCREMENT,
    le_title VARCHAR(30) NOT NULL,
    le_room VARCHAR(20),
    le_schedule VARCHAR(50) NOT NULL,
    le_point INT NOT NULL DEFAULT 0,
    le_time INT NOT NULL DEFAULT 0,
    le_pr_num CHAR(10),
    FOREIGN KEY(le_pr_num) REFERENCES professor(pr_num)
);

# course 테이블 삭제 후 추가
DROP TABLE IF EXISTS course;
CREATE TABLE IF NOT EXISTS course(
	co_num INT PRIMARY KEY AUTO_INCREMENT,
    co_st_num CHAR(10) NOT NULL,
    co_le_num INT NOT NULL,
    FOREIGN KEY(co_st_num) REFERENCES student(st_num),
    FOREIGN KEY(co_le_num) REFERENCES lecture(le_num)
);

#contact 테이블 삭제 후 추가
DROP TABLE IF EXISTS contact;
CREATE TABLE IF NOT EXISTS contact(
	ct_st_num CHAR(10) PRIMARY KEY,
    ct_phone VARCHAR(13) NOT NULL,
    ct_addr VARCHAR(30) NOT NULL,
    ct_detail VARCHAR(30) NOT NULL DEFAULT "",
    FOREIGN KEY(ct_st_num) REFERENCES student(st_num)
);










