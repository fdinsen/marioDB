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

-- order_id
-- Table structure for table `active_orders`
--
LOCK TABLES `active_orders` WRITE;
DROP TABLE IF EXISTS `active_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `active_orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `total_price` double NOT NULL,
  `pickup_time` datetime NOT NULL,
  `customer_phone` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
UNLOCK TABLES;
--
-- Dumping data for table `active_orders`
--

LOCK TABLES `active_orders` WRITE;
/*!40000 ALTER TABLE `active_orders` DISABLE KEYS */;
INSERT INTO `active_orders` VALUES (1,75,'2019-11-12 10:20:51',12345678),(2,75,'2019-11-12 10:20:51',12345678),(3,0,'2019-11-13 14:23:05',12345678);
/*!40000 ALTER TABLE `active_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customer_name` varchar(45) DEFAULT '',
  `customer_phone` int(11) NOT NULL,
  PRIMARY KEY (`customer_phone`),
  UNIQUE KEY `customer_phone_UNIQUE` (`customer_phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES ('DEFAULT USER',0),('Mikkel',10111213),('Jonathan',12131415),('John',12345678),('Caroline',23456789),('Mathias',34567890),('Louise',45678910);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderlines_pizzas`
--

DROP TABLE IF EXISTS `orderlines_pizzas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderlines_pizzas` (
  `orderline_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `pizza_id` varchar(45) DEFAULT NULL,
  `pizza_size` int DEFAULT 0,
  PRIMARY KEY (`orderline_id`),
  UNIQUE KEY `orderline_id_UNIQUE` (`orderline_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderlines_pizzas`
--

LOCK TABLES `orderlines_pizzas` WRITE;
/*!40000 ALTER TABLE `orderlines_pizzas` DISABLE KEYS */;
INSERT INTO `orderlines_pizzas` VALUES (1,1,'1',1),(2,2,'5',0),(3,1,'5',0);
/*!40000 ALTER TABLE `orderlines_pizzas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderlines_toppings`
--

DROP TABLE IF EXISTS `orderlines_toppings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderlines_toppings` (
  `orderline_topping_id` int(11) NOT NULL AUTO_INCREMENT,
  `topping_id` int(11) DEFAULT NULL,
  `orderline_id` int(11) NOT NULL,
  `order_id` int(11) not NULL,
  PRIMARY KEY (`orderline_topping_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderlines_toppings`
--

LOCK TABLES `orderlines_toppings` WRITE;
/*!40000 ALTER TABLE `orderlines_toppings` DISABLE KEYS */;
INSERT INTO `orderlines_toppings` VALUES (1,1,1,1),(2,2,1,2);
/*!40000 ALTER TABLE `orderlines_toppings` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `pizzas`
--

DROP TABLE IF EXISTS `pizzas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pizzas` (
  `pizza_id` int(11) NOT NULL,
  `pizza_name` varchar(45) NOT NULL,
  `pizza_price` double NOT NULL,
  PRIMARY KEY (`pizza_id`),
  UNIQUE KEY `name_UNIQUE` (`pizza_name`),
  UNIQUE KEY `id_UNIQUE` (`pizza_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizzas`
--

LOCK TABLES `pizzas` WRITE;
/*!40000 ALTER TABLE `pizzas` DISABLE KEYS */;
INSERT INTO `pizzas` VALUES (1,'Margherita',67),(2,'Marinara',63),(3,'Quattro',79),(4,'Carbonara',85),(5,'Frutti di Mare',67),(6,'Quattro Formaggi',64),(7,'Crudo',70),(8,'Napoletana or Napoli',55),(9,'Pugliese',61),(10,'Montanara',70),(11,'Emiliana',57),(12,'Romana',74),(13,'Fattoria',75),(14,'Schiacciata',69),(15,'Prosciutto',49),(16,'Americana',45),(17,'Prosciutto e Funghi',84),(18,'Braccio di Ferro',80),(19,'Sarda',61),(20,'Tonno',62),(21,'Valtellina',72),(22,'Gorgonzola',86),(23,'Calzone',87),(24,'Pizza al Pesto',51),(25,'Mediterranea',74),(26,'Ortolana',81),(27,'Diavola',52),(28,'Rustica',83),(29,'Contadina',58),(30,'Parmigiana',90);
/*!40000 ALTER TABLE `pizzas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saved_orders`
--

DROP TABLE IF EXISTS `saved_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saved_orders` (
  `saved_order_id` int(11) NOT NULL AUTO_INCREMENT,
  `total_price` double DEFAULT NULL,
  `pickup_time` datetime DEFAULT NULL,
  `customer_phone` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`saved_order_id`),
  KEY `customer_phone_idx` (`customer_phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saved_orders`
--

LOCK TABLES `saved_orders` WRITE;
/*!40000 ALTER TABLE `saved_orders` DISABLE KEYS */;
INSERT INTO `saved_orders` (customer_phone) VALUES (11111111),(22222222),(33333333),(44444444),(55555555);
/*!40000 ALTER TABLE `saved_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saved_orders_pizzas`
--

DROP TABLE IF EXISTS `saved_orders_pizzas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saved_orders_pizzas` (
  `saved_order_id` int(11) NOT NULL,
  `pizza_name` varchar(45) NOT NULL,
  `pizza_topping` varchar(500) NOT NULL,
  `pizza_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saved_orders_pizzas`
--

LOCK TABLES `saved_orders_pizzas` WRITE;
/*!40000 ALTER TABLE `saved_orders_pizzas` DISABLE KEYS */;
INSERT INTO `saved_orders_pizzas` VALUES (1,"America","Tomat,ost,skinke",50),(1,"Danmark","Tomat,polse,skinke,log",70),(2,"Finlan","Tomat,ost,skinke",50),(2,"Tyskland","Tomat,polse,skinke,log",70),(3,"Holland","Tomat,ost,skinke",50),(3,"Sverige","Tomat,polse,skinke,log",70),(4,"Norge","Tomat,ost,skinke",50),(4,"Tyskland","Tomat,polse,skinke,log",70),(5,"Thailand","Tomat,ost,skinke",50),(5,"Australien","Tomat,polse,skinke,log",70);
/*!40000 ALTER TABLE `saved_orders_pizzas` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `toppings` VALUES (1,'Ananas',8),(2,'Anchovies',8),(3,'Artiscoc',9),(4,'Asparges',7),(5,'Assorted vegetables',9),(6,'Bacon',14),(7,'Basil',3),(8,'Bearnaise',10),(9,'Bell pepper',7),(10,'Boiled potatoes',13),(11,'Bresaola',16),(12,'Buffalo mozzarella',14),(13,'Champignon',10),(14,'Cherry tomatoes',7),(15,'Chicken',12),(16,'Chilli pepper',9),(17,'Egg',6),(18,'Eggplant',7),(19,'French fries',11),(20,'Garlic',7),(21,'Genoese Pesto',6),(22,'Gorgonzola',15),(23,'Ham',15),(25,'Minzed meat',15),(26,'Mozzarella',15),(27,'Mushrooms',8),(28,'mussels',10),(29,'Olive oil',4),(30,'Olives',7),(31,'Onion',6),(32,'Onions',6),(33,'Oregano',3),(34,'Paprika',7),(35,'parma ham',15),(36,'Parmesan',6),(37,'Peas',6),(38,'Pecorino',12),(39,'Pepperoni',15),(40,'Pine nuts',7),(41,'Porchetta',16),(42,'Rocket saled',5),(43,'Rosemary',8),(44,'Salami',10),(45,'Salate',12),(46,'Sausage',11),(47,'Seafood',12),(48,'Shrimp',10),(49,'Spicy salami',10),(50,'Stracchino',9),(51,'Suace',8),(52,'Susages',15),(53,'Tomato Sauce',5),(24,'Tuna fish',10);
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

-- Dump completed on 2019-11-13 14:47:31
