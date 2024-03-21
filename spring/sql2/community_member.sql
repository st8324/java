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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `me_id` varchar(13) NOT NULL,
  `me_ms_state` varchar(10) NOT NULL,
  `me_pw` varchar(255) NOT NULL,
  `me_email` varchar(30) NOT NULL,
  `me_authority` varchar(5) NOT NULL DEFAULT 'USER',
  `me_stop` datetime DEFAULT NULL,
  `me_fail` int NOT NULL DEFAULT '0',
  `me_cookie` varchar(255) DEFAULT NULL,
  `me_cookie_limit` datetime DEFAULT NULL,
  PRIMARY KEY (`me_id`),
  KEY `FK_member_state_TO_member_1` (`me_ms_state`),
  CONSTRAINT `FK_member_state_TO_member_1` FOREIGN KEY (`me_ms_state`) REFERENCES `member_state` (`ms_state`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('a','이용중','b','c','USER',NULL,0,NULL,NULL),('abc','이용중','abcv','a','USER',NULL,0,NULL,NULL),('abc123','기간정지','abc123','abc123@kh.co.kr','USER','2024-03-15 11:35:55',0,NULL,NULL),('admin','이용중','$2a$10$ZEn6/Bax12I./56Ry8bohefrZWJtqfypkoCldTofM7KVVSJbAeMd2','stajun@gmail.com','ADMIN',NULL,0,NULL,NULL),('admin1','이용중','admin1','admin@kh.ac.kr','USER',NULL,0,NULL,NULL),('admin123','이용중','$2a$10$xMd5LT/jBjpB9ZEltvdVseU/HSDOrpLMgR8dcaHGtkhZcx0c8hvqK','stajun@naver.com','USER',NULL,0,NULL,NULL),('asd123','이용중','$2a$10$p0xCAWWMI4CEW9tDpKW9FO/fNWl1a4PicrMbkAKhF7JtWZQzmw4P6','stajun@naver.com','USER',NULL,0,NULL,NULL),('asd1234','이용중','asd1234','asd@naver.com','USER',NULL,0,NULL,NULL),('asd213','이용중','asd123','asd123@naver.com','USER',NULL,0,NULL,NULL),('e','이용중','e','e','USER',NULL,0,NULL,NULL),('qwe123','탈퇴','qwe123','qwe123@kh.co.kr','USER',NULL,0,NULL,NULL),('stajun','이용중','stajun','stajun@kh.kr','USER',NULL,0,NULL,NULL),('zxc123','이용중','zxc123','zxc123@naver.com','USER',NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
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
