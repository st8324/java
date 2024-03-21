CREATE DATABASE  IF NOT EXISTS `community`;
USE `community`;

DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
  `bo_num` int NOT NULL AUTO_INCREMENT,
  `bo_co_num` int NOT NULL,
  `bo_me_id` varchar(13) NOT NULL,
  `bo_title` varchar(50) NOT NULL,
  `bo_content` text NOT NULL,
  `bo_view` int NOT NULL DEFAULT '0',
  `bo_report_count` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`bo_num`),
  KEY `FK_community_TO_board_1` (`bo_co_num`),
  KEY `FK_member_TO_board_1` (`bo_me_id`),
  CONSTRAINT `FK_community_TO_board_1` FOREIGN KEY (`bo_co_num`) REFERENCES `community` (`co_num`),
  CONSTRAINT `FK_member_TO_board_1` FOREIGN KEY (`bo_me_id`) REFERENCES `member` (`me_id`)
);


