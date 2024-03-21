CREATE DATABASE  IF NOT EXISTS `community`;
USE `community`;

DROP TABLE IF EXISTS `member_state`;
CREATE TABLE `member_state` (
  `ms_state` varchar(10) NOT NULL,
  PRIMARY KEY (`ms_state`)
);

INSERT INTO `member_state` VALUES ('기간정지'),('영구정지'),('이용중'),('탈퇴');
