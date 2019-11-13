-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: mario
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `pizza_toppings`
--

DROP TABLE IF EXISTS `pizza_toppings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pizza_toppings` (
  `pizza_id` int(11) NOT NULL,
  `toppings_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza_toppings`
--

LOCK TABLES `pizza_toppings` WRITE;
/*!40000 ALTER TABLE `pizza_toppings` DISABLE KEYS */;
INSERT INTO `pizza_toppings` VALUES (1,53),(1,26),(1,33),(2,53),(2,20),(2,7),(3,53),(3,26),(3,23),(3,4),(3,30),(3,33),(4,53),(4,26),(4,36),(4,17),(4,6),(5,53),(5,47),(6,53),(6,26),(6,22),(6,3),(6,33),(7,53),(7,26),(7,35),(8,53),(8,26),(8,33),(8,2),(9,53),(9,26),(9,33),(9,31),(10,53),(10,26),(10,27),(10,39),(10,50),(11,53),(11,26),(11,18),(11,10),(11,46),(12,53),(12,26),(12,2),(12,33),(13,53),(13,26),(13,37),(13,41),(14,29),(14,43),(15,53),(15,26),(15,23),(15,33),(16,53),(16,26),(16,46),(16,19),(17,53),(17,26),(17,23),(17,27),(18,26),(18,36),(19,53),(19,26),(19,38),(19,49),(20,53),(20,26),(20,53),(20,32),(21,53),(21,26),(21,11),(21,36),(21,42),(22,53),(22,26),(22,22),(22,30),(23,53),(23,26),(23,23),(23,27),(23,3),(23,2),(23,33),(24,53),(24,26),(24,21),(24,40),(24,30),(25,53),(25,12),(25,14),(26,53),(26,26),(26,5),(27,53),(27,26),(27,49),(27,16),(28,53),(28,26),(28,22),(28,18),(29,53),(29,26),(29,4),(29,27),(29,6),(29,36),(30,53),(30,26),(30,18),(30,36);
/*!40000 ALTER TABLE `pizza_toppings` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-13 14:41:25
