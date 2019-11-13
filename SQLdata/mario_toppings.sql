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
-- Table structure for table `toppings`
--

DROP TABLE IF EXISTS `toppings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `toppings` (
  `toppings_id` int(11) NOT NULL,
  `topping_name` varchar(45) NOT NULL,
  `topping_price` double NOT NULL,
  PRIMARY KEY (`toppings_id`),
  UNIQUE KEY `ToppingName_UNIQUE` (`topping_name`),
  UNIQUE KEY `IdToppings_UNIQUE` (`toppings_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toppings`
--

LOCK TABLES `toppings` WRITE;
/*!40000 ALTER TABLE `toppings` DISABLE KEYS */;
INSERT INTO `toppings` VALUES (1,'Ananas',8),(2,'Anchovies',8),(3,'Artiscoc',9),(4,'Asparges',7),(5,'Assorted vegetables',9),(6,'Bacon',14),(7,'Basil',3),(8,'Bearnaise',10),(9,'Bell pepper',7),(10,'Boiled potatoes',13),(11,'Bresaola',16),(12,'Buffalo mozzarella',14),(13,'Champignon',10),(14,'Cherry tomatoes',7),(15,'Chicken',12),(16,'Chilli pepper',9),(17,'Egg',6),(18,'Eggplant',7),(19,'French fries',11),(20,'Garlic',7),(21,'Genoese Pesto',6),(22,'Gorgonzola',15),(23,'Ham',15),(25,'Minzed meat',15),(26,'Mozzarella',15),(27,'Mushrooms',8),(28,'mussels',10),(29,'Olive oil',4),(30,'Olives',7),(31,'Onion',6),(32,'Onions',6),(33,'Oregano',3),(34,'Paprika',7),(35,'parma ham',15),(36,'Parmesan',6),(37,'Peas',6),(38,'Pecorino',12),(39,'Pepperoni',15),(40,'Pine nuts',7),(41,'Porchetta',16),(42,'Rocket saled',5),(43,'Rosemary',8),(44,'Salami',10),(45,'Salate',12),(46,'Sausage',11),(47,'Seafood',12),(48,'Shrimp',10),(49,'Spicy salami',10),(50,'Stracchino',9),(51,'Suace',8),(52,'Susages',15),(53,'Tomato Sauce',5),(54,'Tuna fish',10);
/*!40000 ALTER TABLE `toppings` ENABLE KEYS */;
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
