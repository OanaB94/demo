-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: teachers
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `idteacher` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_subject_teacher_idx` (`idteacher`),
  CONSTRAINT `fk_subject_teacher` FOREIGN KEY (`idteacher`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Informatica',1,'Algoritmi si dezvoltare'),(2,'Biologie',3,'Tipuri de mamifere'),(3,'Geografie	',6,'Pamantul si rotatia in jurul Soarelui'),(4,'Muzica',8,'Invatarea acordurilor muzicale'),(5,'Sport',3,'Handbal'),(6,'Desen',6,'Pictura in ulei'),(7,'Romana',8,'Comentarii literare'),(8,'Matematica',1,'Functii derivabile'),(9,'Engleza',4,'Timpuri verbale'),(10,'Franceza',7,'Timpul trecut'),(13,'bbb',NULL,'bbb'),(14,'Oana',NULL,'gdfgfdgdfA'),(15,'Robu',4,'Bianca'),(17,'Hhhrgggg',1,NULL),(18,'Hhhrgggg',1,NULL),(19,'Hhhrgggg',1,NULL),(21,'aa',2,'aa'),(22,'aa',2,'aa'),(23,'aa',2,'aa'),(26,'oana',6,'d');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `dateOfEmployment` date DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Ionescu','Ion','1980-04-23','2000-02-02','748745636'),(2,'Antonescu ','Maria','2000-08-25','2021-02-05','750123654'),(3,'Huluta','Petru','1950-02-02','1970-03-07','733589741'),(4,'Burdea ','Ioana','1970-04-02','1990-09-02','754987999'),(5,'Andrei','Andrei','2001-05-12','2021-07-05','764127460'),(6,'Isac','Octavian','1995-06-12','2015-05-08','756321000'),(7,'Macovei','Dorian','2000-09-13','2021-01-12','758666333'),(8,'Vasilescu','Teodora','1950-07-24','1975-09-27','742354777'),(9,'Tarcan','Andreea','1975-03-23','2020-10-24','748889631'),(10,'Rusu','Gabriel','2000-12-12','2020-10-08','3695326666'),(14,'Paraschiv','Oana-Bianca','1994-01-06','2021-07-15','0749735097'),(19,'Hhh','Hhh','1973-10-10','2021-09-09','0749735097'),(20,'Hhh','Hhh','1973-10-10','2021-09-09','0749735097');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-18 12:24:02
