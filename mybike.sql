-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: mybike
-- ------------------------------------------------------
-- Server version	5.6.28-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bikes`
--

DROP TABLE IF EXISTS `bikes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bikes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bikes`
--

LOCK TABLES `bikes` WRITE;
/*!40000 ALTER TABLE `bikes` DISABLE KEYS */;
INSERT INTO `bikes` VALUES (1,'available','progress'),(2,'available','progress'),(3,'available','ashtonbee'),(4,'available','ashtonbee'),(5,'available','morningside'),(6,'available','morningside'),(7,'out','progress'),(8,'out','progress'),(9,'unavailable','progress'),(10,'unavailable','progress');
/*!40000 ALTER TABLE `bikes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memberinfo`
--

DROP TABLE IF EXISTS `memberinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memberinfo` (
  `id` int(9) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `dob` date NOT NULL,
  `gender` char(1) NOT NULL COMMENT 'M/F',
  `contactNumber` varchar(12) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(30) NOT NULL,
  `apartment` varchar(10) DEFAULT NULL,
  `city` varchar(15) NOT NULL,
  `province` char(2) NOT NULL COMMENT '''ON/PQ/AB/MB''',
  `postalCode` varchar(6) NOT NULL COMMENT '''A1A2B2''',
  `password` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `memberId_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memberinfo`
--

LOCK TABLES `memberinfo` WRITE;
/*!40000 ALTER TABLE `memberinfo` DISABLE KEYS */;
INSERT INTO `memberinfo` VALUES (300748503,'Huang','Zixuan','1966-10-10','M','416-343-3333','swomiloj@my.centennialcollege.ca','39 templeton rd',NULL,'Toronto','ON','M2k3D3','hello'),(300749019,'Tigno','Raphael','1966-10-10','M','333-333-3333','ad@my.centennialcollege.ca','34',NULL,'Toronto','ON','m3k333','hello'),(300760378,'Wen','Balloon','1966-10-10','M','416-343-3333','swomiloj@my.centennialcollege.ca','39 templeton rd',NULL,'Toronto','ON','M2k3D3','hello'),(822913893,'Womiloju','Sara','1966-10-10','F','416-333-3333','swomiloj@my.centennialcollege.ca','39 templeton rd',NULL,'Toronto','ON','M2k3D3','hello');
/*!40000 ALTER TABLE `memberinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payinfo`
--

DROP TABLE IF EXISTS `payinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payinfo` (
  `ccNumber` int(16) NOT NULL,
  `memberId` int(9) NOT NULL,
  `ccType` varchar(20) NOT NULL,
  `ccExpiryDate` varchar(5) NOT NULL COMMENT 'MM/YY',
  `cardHolderName` varchar(45) NOT NULL,
  `amount` double NOT NULL,
  `paymentId` int(9) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`paymentId`),
  KEY `memberId_idx` (`memberId`),
  CONSTRAINT `memberId` FOREIGN KEY (`memberId`) REFERENCES `memberinfo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payinfo`
--

LOCK TABLES `payinfo` WRITE;
/*!40000 ALTER TABLE `payinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `payinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservationdetails`
--

DROP TABLE IF EXISTS `reservationdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservationdetails` (
  `reservationId` int(9) NOT NULL AUTO_INCREMENT,
  `paymentId` int(9) NOT NULL,
  `reserveStart` date NOT NULL,
  `reserveEnd` date NOT NULL,
  `bikeId` int(9) NOT NULL,
  `reserveType` char(1) NOT NULL,
  PRIMARY KEY (`reservationId`),
  KEY `paymentId_idx` (`paymentId`),
  CONSTRAINT `paymentId` FOREIGN KEY (`paymentId`) REFERENCES `payinfo` (`paymentId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservationdetails`
--

LOCK TABLES `reservationdetails` WRITE;
/*!40000 ALTER TABLE `reservationdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservationdetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-17 21:26:24
