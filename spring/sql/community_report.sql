CREATE DATABASE  IF NOT EXISTS `community`;
USE `community`;

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
  `rp_num` int NOT NULL AUTO_INCREMENT,
  `rp_me_id` varchar(13) NOT NULL,
  `rp_rt_name` varchar(15) NOT NULL,
  `rp_table` varchar(10) NOT NULL,
  `rp_content` text NOT NULL,
  `rp_state` varchar(5) NOT NULL DEFAULT '신고접수',
  `rp_target` int NOT NULL,
  PRIMARY KEY (`rp_num`),
  KEY `FK_member_TO_report_1` (`rp_me_id`),
  KEY `FK_report_type_TO_report_1` (`rp_rt_name`),
  CONSTRAINT `FK_member_TO_report_1` FOREIGN KEY (`rp_me_id`) REFERENCES `member` (`me_id`),
  CONSTRAINT `FK_report_type_TO_report_1` FOREIGN KEY (`rp_rt_name`) REFERENCES `report_type` (`rt_name`)
) ;

