CREATE DATABASE  IF NOT EXISTS `community` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `community`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: community
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (2,2,'abc123','테스트','테스트 입니다.',0,0),(3,1,'admin','공지사항','공지사항입니다',2,0),(4,1,'admin','1','1',0,0),(5,1,'admin','안녕','안녕',1,0),(6,1,'admin','a','ãã',2,0),(7,1,'admin','ㅌㅌ','ㅌㅌ',0,0),(8,1,'admin','인코딩','인코딩',5,0),(9,2,'admin','자유게시판 테스트','자유게시판 테스트',2,0),(10,1,'asd123','asd','asd',0,0),(11,1,'asd123','22','22',10,0),(12,1,'asd123','eee','eee',0,0),(13,1,'asd123','a','ê²ìê¸ ë±ë¡',0,0),(14,3,'asd123','aaaaa - 수정 - 토론으로','aaaa- 수정 - 토론으로',15,0),(16,2,'asd123','29일 게시글','29일 게시글',0,0),(18,2,'asd123','ㅁㄴㅇㄹ','ㅁㄴㅇㄹ',2,0),(19,1,'asd123','ㅁㄴㅇ','ㅁㄴㅇ',0,0),(20,1,'asd123','ㅁㄴㅇ','ㅁㄴㅇ',0,0),(21,1,'asd123','asd123','asd123',0,0),(22,1,'asd123','asd123','asd123',0,0),(23,1,'asd123','123123','123123',0,0),(24,1,'asd123','df','df',0,0),(25,3,'asd123','토론으로 수정','123',5,0),(26,1,'asd123','asd123','asd123',0,0),(27,1,'asd123','asd123','asd123',0,0),(28,1,'asd123','asd123','asd123',0,0),(29,1,'asd123','첨부파일 업로드 테스트','asd123',8,0),(30,1,'asd123','asd123','asd123',0,0),(31,1,'admin','첨부','첨부',0,0),(32,1,'admin','첨부2','첨부2',0,0),(33,1,'admin','dd','dd',0,0),(34,1,'admin','admin','admin',2,0),(35,1,'admin','d','d',2,0),(36,1,'admin','dd','dd',4,0),(38,1,'admin','3월 5일 1차 게시글','3월 5일 1차 게시글',6,0),(39,1,'asd123','asd회원의 게시글','asd회원의 게시글',5,0),(41,1,'admin','첨부 복습','첨부 복습',7,0),(43,1,'admin','썸머노트','<h1><span style=\"background-color: rgb(255, 255, 0);\">안녕하세요.</span></h1><p><br></p><p><br></p><h2><b>안녕</b></h2><p><br></p><p><span style=\"background-color: rgb(255, 0, 0);\"><font color=\"#ffffff\" style=\"\"><u>썸머노트를 이용한 게시글입니다</u></font></span><u style=\"font-size: var(--bs-body-font-size); font-weight: var(--bs-body-font-weight); text-align: var(--bs-body-text-align); color: rgb(255, 255, 255); background-color: rgb(255, 0, 0);\">.</u></p><p><u style=\"font-size: var(--bs-body-font-size); font-weight: var(--bs-body-font-weight); text-align: var(--bs-body-text-align); color: rgb(255, 255, 255); background-color: rgb(255, 0, 0);\"><br></u></p><p><u style=\"font-size: var(--bs-body-font-size); font-weight: var(--bs-body-font-weight); text-align: var(--bs-body-text-align); color: rgb(255, 255, 255); background-color: rgb(255, 0, 0);\"><br></u></p><p><u style=\"font-size: var(--bs-body-font-size); font-weight: var(--bs-body-font-weight); text-align: var(--bs-body-text-align); color: rgb(255, 255, 255); background-color: rgb(255, 0, 0);\"><br></u></p><p><span style=\"background-color: rgb(255, 0, 0);\"><font color=\"#ffffff\" style=\"\"><u><br></u></font></span></p><p><span style=\"background-color: rgb(255, 0, 0);\"><font color=\"#ffffff\" style=\"\"><u><br></u></font></span></p><p><span style=\"background-color: rgb(255, 0, 0);\"><font color=\"#ffffff\" style=\"\"><u><br></u></font></span></p><p><span style=\"background-color: rgb(255, 0, 0);\"><font color=\"#ffffff\" style=\"\"><u><br></u></font></span></p><p><span style=\"background-color: rgb(255, 0, 0);\"><font color=\"#ffffff\" style=\"\"><u><br></u></font></span></p><p><span style=\"background-color: rgb(255, 0, 0);\"><font color=\"#ffffff\" style=\"\"><u><br></u></font></span></p><p><span style=\"background-color: rgb(255, 0, 0);\"><font color=\"#ffffff\" style=\"\"><u><br></u></font></span></p><p><span style=\"background-color: rgb(255, 0, 0);\"><font color=\"#ffffff\" style=\"\"><u><br></u></font></span></p><p><span style=\"background-color: rgb(255, 0, 0);\"><font color=\"#ffffff\" style=\"\"><u><br></u></font></span></p><p><span style=\"background-color: rgb(255, 0, 0);\"><font color=\"#ffffff\" style=\"\"><u><br></u></font></span></p><p><span style=\"background-color: rgb(255, 0, 0);\"><font color=\"#ffffff\" style=\"\"><u><br></u></font></span></p><p><span style=\"background-color: rgb(255, 0, 0);\"><font color=\"#ffffff\" style=\"\"><u><br></u></font></span></p><p><span style=\"background-color: rgb(255, 0, 0);\"><font color=\"#ffffff\" style=\"\"><u><br></u></font></span></p>',57,0),(44,1,'asd123','이미지','<p>ㅇ</p>',70,0),(45,1,'asd123','썸머노트 테스트','<p>테스트 <span style=\"background-color: rgb(255, 255, 0);\">썸머노트</span></p><p><span style=\"background-color: rgb(255, 255, 0);\"><br></span></p><p><span style=\"background-color: rgb(255, 255, 0);\">수정</span></p>',193,0),(46,4,'zxc123','공부합시다','내용',0,0),(47,3,'zxc123','토론합시다','<p><font color=\"#000000\" style=\"background-color: rgb(255, 255, 0);\">토론합시다</font><br></p>',4,0),(49,4,'asd123','자유 첨부 - 수정','<p><font color=\"#000000\" style=\"background-color: rgb(255, 255, 0);\">ㅇㄹ- 수정</font></p>',139,0);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-21 11:32:18
