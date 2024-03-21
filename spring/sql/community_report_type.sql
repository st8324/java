CREATE DATABASE  IF NOT EXISTS `community`;
USE `community`;
DROP TABLE IF EXISTS `report_type`;
CREATE TABLE `report_type` (
  `rt_name` varchar(15) NOT NULL,
  PRIMARY KEY (`rt_name`)
);
INSERT INTO `report_type` VALUES ('광고'),('기타'),('욕설'),('음란'),('커뮤니티에 맞지 않음'),('허위사실유포');
