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
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `fi_num` int NOT NULL AUTO_INCREMENT,
  `fi_bo_num` int NOT NULL,
  `fi_name` varchar(150) NOT NULL,
  `fi_ori_name` varchar(50) NOT NULL,
  PRIMARY KEY (`fi_num`),
  KEY `FK_board_TO_file_1` (`fi_bo_num`),
  CONSTRAINT `FK_board_TO_file_1` FOREIGN KEY (`fi_bo_num`) REFERENCES `board` (`bo_num`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (2,31,'/2024/03/04/bbbd164d-4737-464c-a820-25786bd7c255_과정수료증.pdf','과정수료증.pdf'),(3,34,'/2024/03/04/6f048197-0131-4220-938c-19da821b8f65_과정수료증.pdf','과정수료증.pdf'),(4,36,'/2024/03/04/29f08148-4573-4c7d-b412-ffca6f03e1f4_과정수료증.pdf','과정수료증.pdf'),(8,38,'/2024/03/05/56476826-ef74-4cda-b7e9-b7ce0340b53e_과정수료증.pdf','과정수료증.pdf'),(9,39,'/2024/03/05/b0a229a1-e4ef-4ea6-a1cc-255dc6d065ef_과정수료증.pdf','과정수료증.pdf'),(10,39,'/2024/03/05/88b55e07-4f85-4c0d-ae08-c5c997d47bd3_1. 과정 OT.pdf','1. 과정 OT.pdf'),(18,44,'/2024/03/06/65019cf8-5cae-4d90-8c87-275feddf4474_다운로드.jpg','다운로드.jpg'),(23,49,'/2024/03/18/2795a620-78b0-47dc-a13b-ec14ec15fe2b_https-content.xml','https-content.xml');
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-21 11:32:19
