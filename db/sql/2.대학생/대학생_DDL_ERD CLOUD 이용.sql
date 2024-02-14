DROP DATABASE IF EXISTS university2;
CREATE DATABASE IF NOT EXISTS university2;

USE university2;

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
	`st_num`	char(10)	NOT NULL,
	`st_name`	varchar(30) not null,
	`st_major`	varchar(15) not null,
	`st_grade`	int not null default 1	
);

DROP TABLE IF EXISTS `professor`;

CREATE TABLE `professor` (
	`pr_num`	char(10)	NOT NULL,
	`pr_name`	varchar(30) not null,
	`pr_room`	varchar(100),
	`pr_major`	varchar(15) not null	
);

DROP TABLE IF EXISTS `lecture`;

CREATE TABLE `lecture` (
	`le_num`	int	primary key auto_increment,
	`le_title`	varchar(30) not null,
	`le_room`	varchar(20),
	`le_schedule`	varchar(50) not null,
	`le_point`	int not null default 0,
	`le_time`	int not null default 0,
	`le_pr_num`	char(10)
);

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
	`co_num`	int	primary key auto_increment,
	`co_st_num`	char(10)	NOT NULL,
	`co_le_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
	`ct_st_num`	char(10)	NOT NULL,
	`ct_phone`	varchar(13) not null,
	`ct_addr`	varchar(30) not null,
	`ct_detail`	varchar(30) not null default ""
);

ALTER TABLE `student` ADD CONSTRAINT `PK_STUDENT` PRIMARY KEY (
	`st_num`
);

ALTER TABLE `professor` ADD CONSTRAINT `PK_PROFESSOR` PRIMARY KEY (
	`pr_num`
);


ALTER TABLE `contact` ADD CONSTRAINT `PK_CONTACT` PRIMARY KEY (
	`ct_st_num`
);

ALTER TABLE `lecture` ADD CONSTRAINT `FK_professor_TO_lecture_1` FOREIGN KEY (
	`le_pr_num`
)
REFERENCES `professor` (
	`pr_num`
);

ALTER TABLE `course` ADD CONSTRAINT `FK_student_TO_course_1` FOREIGN KEY (
	`co_st_num`
)
REFERENCES `student` (
	`st_num`
);

ALTER TABLE `course` ADD CONSTRAINT `FK_lecture_TO_course_1` FOREIGN KEY (
	`co_le_num`
)
REFERENCES `lecture` (
	`le_num`
);

ALTER TABLE `contact` ADD CONSTRAINT `FK_student_TO_contact_1` FOREIGN KEY (
	`ct_st_num`
)
REFERENCES `student` (
	`st_num`
);

