-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: acm_system
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `air_companies`
--

DROP TABLE IF EXISTS `air_companies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `air_companies` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `founded_at` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `company_type` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlmnso1j4qrkmkfkotqq5inrij` (`company_type`),
  CONSTRAINT `FKlmnso1j4qrkmkfkotqq5inrij` FOREIGN KEY (`company_type`) REFERENCES `company_types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `air_companies`
--

/*!40000 ALTER TABLE `air_companies` DISABLE KEYS */;
INSERT INTO `air_companies` VALUES (1,2010,'Boss',5);
/*!40000 ALTER TABLE `air_companies` ENABLE KEYS */;

--
-- Table structure for table `airplane_types`
--

DROP TABLE IF EXISTS `airplane_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airplane_types` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airplane_types`
--

/*!40000 ALTER TABLE `airplane_types` DISABLE KEYS */;
INSERT INTO `airplane_types` VALUES (1,'Big'),(2,'Small'),(3,'VIP'),(4,'CARRIAGE'),(5,'short distance');
/*!40000 ALTER TABLE `airplane_types` ENABLE KEYS */;

--
-- Table structure for table `airplanes`
--

DROP TABLE IF EXISTS `airplanes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airplanes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` int DEFAULT NULL,
  `factory_serial_number` varchar(255) DEFAULT NULL,
  `flight_distance` int DEFAULT NULL,
  `fuel_capacity` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number_of_flights` int DEFAULT NULL,
  `air_company` bigint DEFAULT NULL,
  `airplane_type` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7ge38qsnrd4sgfpf9e4hdfkx6` (`air_company`),
  KEY `FKevuiepfhh6xni8giy7xv91pk5` (`airplane_type`),
  CONSTRAINT `FK7ge38qsnrd4sgfpf9e4hdfkx6` FOREIGN KEY (`air_company`) REFERENCES `air_companies` (`id`),
  CONSTRAINT `FKevuiepfhh6xni8giy7xv91pk5` FOREIGN KEY (`airplane_type`) REFERENCES `airplane_types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airplanes`
--

/*!40000 ALTER TABLE `airplanes` DISABLE KEYS */;
INSERT INTO `airplanes` VALUES (1,2000,'fhdaj1y543',0,15156,'A320',0,1,1);
/*!40000 ALTER TABLE `airplanes` ENABLE KEYS */;

--
-- Table structure for table `company_types`
--

DROP TABLE IF EXISTS `company_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_types` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_types`
--

/*!40000 ALTER TABLE `company_types` DISABLE KEYS */;
INSERT INTO `company_types` VALUES (1,'Big company'),(2,'Small company'),(3,'Low cost'),(4,'Beginner company'),(5,'LowCost'),(6,'Starter');
/*!40000 ALTER TABLE `company_types` ENABLE KEYS */;

--
-- Table structure for table `flight_statuses`
--

DROP TABLE IF EXISTS `flight_statuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight_statuses` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `status_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_statuses`
--

/*!40000 ALTER TABLE `flight_statuses` DISABLE KEYS */;
INSERT INTO `flight_statuses` VALUES (1,'PENDING'),(2,'ACTIVE'),(3,'DELAYED'),(4,'COMPLETED');
/*!40000 ALTER TABLE `flight_statuses` ENABLE KEYS */;

--
-- Table structure for table `flights`
--

DROP TABLE IF EXISTS `flights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flights` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `delay_started_at` datetime DEFAULT NULL,
  `departure_country` varchar(255) DEFAULT NULL,
  `destination_country` varchar(255) DEFAULT NULL,
  `distance` int NOT NULL,
  `ended_at` datetime DEFAULT NULL,
  `estimated_flight_time` int DEFAULT NULL,
  `started_at` datetime DEFAULT NULL,
  `air_company` bigint DEFAULT NULL,
  `flight_status` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs86lrpgehnnkhar7op8jlqp6c` (`air_company`),
  KEY `FKm4yygdasau5sxfqieur7otyte` (`flight_status`),
  CONSTRAINT `FKm4yygdasau5sxfqieur7otyte` FOREIGN KEY (`flight_status`) REFERENCES `flight_statuses` (`id`),
  CONSTRAINT `FKs86lrpgehnnkhar7op8jlqp6c` FOREIGN KEY (`air_company`) REFERENCES `air_companies` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flights`
--

/*!40000 ALTER TABLE `flights` DISABLE KEYS */;
INSERT INTO `flights` VALUES (1,'2018-01-21 10:01:35',NULL,'Ukraine','Poland',500,NULL,56,NULL,1,1),(2,'2018-01-21 10:01:35',NULL,'Ukraine','Poland',500,NULL,56,NULL,1,1);
/*!40000 ALTER TABLE `flights` ENABLE KEYS */;

--
-- Table structure for table `flights_airplanes`
--

DROP TABLE IF EXISTS `flights_airplanes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flights_airplanes` (
  `flight_id` bigint NOT NULL,
  `airplanes_id` bigint NOT NULL,
  UNIQUE KEY `UK_eqoyh44ghputyfueq9o4gfmcm` (`airplanes_id`),
  KEY `FKpqc7l4dsbqvrebusay89r0xod` (`flight_id`),
  CONSTRAINT `FKd50kc4flee3e1c62na25044ce` FOREIGN KEY (`airplanes_id`) REFERENCES `airplanes` (`id`),
  CONSTRAINT `FKpqc7l4dsbqvrebusay89r0xod` FOREIGN KEY (`flight_id`) REFERENCES `flights` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flights_airplanes`
--

/*!40000 ALTER TABLE `flights_airplanes` DISABLE KEYS */;
INSERT INTO `flights_airplanes` VALUES (2,1);
/*!40000 ALTER TABLE `flights_airplanes` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-21 17:34:29
