CREATE DATABASE  IF NOT EXISTS `community`;
USE `community`;
DROP TABLE IF EXISTS `community`;

CREATE TABLE `community` (
  `co_num` int NOT NULL AUTO_INCREMENT,
  `co_name` varchar(10) NOT NULL,
  PRIMARY KEY (`co_num`)
);
INSERT INTO `community` VALUES (1,'공지'),(2,'자유'),(3,'토론'),(4,'공부');

