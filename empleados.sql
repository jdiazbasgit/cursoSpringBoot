-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: empleados
-- ------------------------------------------------------
-- Server version	5.7.25

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
-- Table structure for table `cargos`
--

DROP TABLE IF EXISTS `cargos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargos`
--

LOCK TABLES `cargos` WRITE;
/*!40000 ALTER TABLE `cargos` DISABLE KEYS */;
INSERT INTO `cargos` VALUES (1,'jefe'),(2,'conductor'),(3,'limpiador'),(4,'conserje'),(5,'piloto');
/*!40000 ALTER TABLE `cargos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_laborales`
--

DROP TABLE IF EXISTS `datos_laborales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datos_laborales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `salario` int(11) NOT NULL,
  `fecha_alta` datetime DEFAULT NULL,
  `cargos_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dtos_laborales_cargos1_idx` (`cargos_id`),
  CONSTRAINT `fk_dtos_laborales_cargos1` FOREIGN KEY (`cargos_id`) REFERENCES `cargos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_laborales`
--

LOCK TABLES `datos_laborales` WRITE;
/*!40000 ALTER TABLE `datos_laborales` DISABLE KEYS */;
INSERT INTO `datos_laborales` VALUES (3,1000,'2021-01-01 00:00:00',2),(4,2000,'2021-01-01 00:00:00',1),(5,500,'2021-01-01 00:00:00',3),(6,12345,'2021-01-01 00:00:00',2),(7,54321,'2021-01-01 00:00:00',5),(8,541,'2021-01-01 00:00:00',5);
/*!40000 ALTER TABLE `datos_laborales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_personales`
--

DROP TABLE IF EXISTS `datos_personales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datos_personales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estado_civil` varchar(45) NOT NULL,
  `hijos_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_datos_personales_hijos_idx` (`hijos_id`),
  CONSTRAINT `fk_datos_personales_hijos` FOREIGN KEY (`hijos_id`) REFERENCES `hijos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_personales`
--

LOCK TABLES `datos_personales` WRITE;
/*!40000 ALTER TABLE `datos_personales` DISABLE KEYS */;
INSERT INTO `datos_personales` VALUES (1,'casado',5),(3,'casado',1),(4,'soltero',1),(12,'soltero',2),(13,'soltero',5),(14,'divorciado',5);
/*!40000 ALTER TABLE `datos_personales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `dni` varchar(45) DEFAULT NULL,
  `fecha_nacimiento` datetime NOT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `datos_personales_id` int(11) NOT NULL,
  `datos_laborales_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_empleados_datos_personales1_idx` (`datos_personales_id`),
  KEY `fk_empleados_dtos_laborales1_idx` (`datos_laborales_id`),
  CONSTRAINT `fk_empleados_datos_personales1` FOREIGN KEY (`datos_personales_id`) REFERENCES `datos_personales` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleados_dtos_laborales1` FOREIGN KEY (`datos_laborales_id`) REFERENCES `datos_laborales` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'jesus','123123123','2021-05-20 15:45:52','adadad',4,4),(2,'Javier','15478424H','2021-05-19 17:32:57','1616161616',1,3),(3,'Javier','15478424H','2021-05-19 17:33:44','1616161616',1,3),(4,'Esteban','15478424A','2021-05-19 17:41:34','1616161456',4,4),(6,'Alejandro','15478424A','2021-05-06 17:43:40','1616161456',1,3),(7,'Javier','15478424A','2021-05-19 17:44:17','1616161456',1,3),(8,'nombrec2','dnic2','2021-05-06 17:53:44','telefonoc2',13,5),(9,'grupo03',NULL,'2021-05-19 16:03:53',NULL,1,5),(10,'nombrec3','dnic3','2021-05-19 19:56:26','telefonoc3',4,4),(11,'Juan','71122296V','2021-05-19 21:09:22','987456123',4,3),(12,'Juan','71122250V','2021-05-20 15:17:22','987456123',1,3),(13,'nombrec3','dnic3','2021-05-20 15:21:48','telefonoc3',4,4),(14,'Juan2','71122296V','2021-05-20 15:31:07','987456123',4,5),(15,'nombre_jueves','dni_jueves','2021-05-20 15:35:42','telefono_jueves',4,4),(16,'nombre_jueves2','dni_jueves2','2021-05-20 15:38:43','telefono_jueves2',4,4),(17,'nombre_jueves2','dni_jueves2','2021-05-20 15:40:29','telefono_jueves2',4,4),(18,'Pedro','asdsa','2021-05-20 15:45:00','987456123',1,3),(19,'jesus','123123123','2021-05-20 15:46:20','adadad',4,4),(20,'Javier','456456456','2021-05-19 16:03:53','456456456',14,7),(21,'Javier','456456456','2021-05-19 16:03:53','456456456',14,7);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hijos`
--

DROP TABLE IF EXISTS `hijos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hijos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chicos` int(11) NOT NULL DEFAULT '0',
  `chicas` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hijos`
--

LOCK TABLES `hijos` WRITE;
/*!40000 ALTER TABLE `hijos` DISABLE KEYS */;
INSERT INTO `hijos` VALUES (1,0,0),(2,1,0),(3,0,1),(4,1,1),(5,2,1),(6,0,3),(7,10,10),(8,60,0);
/*!40000 ALTER TABLE `hijos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rol` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (4,'ROLE_USER'),(5,'ROLE_ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  `roles_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `roles_idx` (`roles_id`),
  CONSTRAINT `roles` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (3,'user','$2a$10$ySriWyP8BdOhEMhDjVRi5.YK.PWHPoSCuyoXVIi40DBuvBM1qRZYy',1,4),(4,'admin','$2a$10$YQLch25eXxliEsYamhqwnehW/Zvzi3ZgGqNOzpfS3LyW0lqhfgJwa',1,5);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-20 19:58:55
