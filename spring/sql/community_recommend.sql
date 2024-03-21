CREATE DATABASE  IF NOT EXISTS `community`;
USE `community`;
DROP TABLE IF EXISTS `recommend`;
CREATE TABLE `recommend` (
  `re_num` int NOT NULL AUTO_INCREMENT,
  `re_me_id` varchar(13) NOT NULL,
  `re_bo_num` int NOT NULL,
  `re_state` int NOT NULL,
  PRIMARY KEY (`re_num`),
  KEY `FK_member_TO_recommend_1` (`re_me_id`),
  KEY `FK_board_TO_recommend_1` (`re_bo_num`),
  CONSTRAINT `FK_board_TO_recommend_1` FOREIGN KEY (`re_bo_num`) REFERENCES `board` (`bo_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_member_TO_recommend_1` FOREIGN KEY (`re_me_id`) REFERENCES `member` (`me_id`)
) ;