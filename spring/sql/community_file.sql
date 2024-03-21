CREATE DATABASE  IF NOT EXISTS `community`;
USE `community`;

DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `fi_num` int NOT NULL AUTO_INCREMENT,
  `fi_bo_num` int NOT NULL,
  `fi_name` varchar(150) NOT NULL,
  `fi_ori_name` varchar(50) NOT NULL,
  PRIMARY KEY (`fi_num`),
  KEY `FK_board_TO_file_1` (`fi_bo_num`),
  CONSTRAINT `FK_board_TO_file_1` FOREIGN KEY (`fi_bo_num`) REFERENCES `board` (`bo_num`)
);
