CREATE DATABASE  IF NOT EXISTS `citas` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `citas`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: citas
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `catalogo_sistemas`
--

DROP TABLE IF EXISTS `catalogo_sistemas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalogo_sistemas` (
  `id` int NOT NULL,
  `sistema` varchar(60) DEFAULT NULL,
  `subsistema` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalogo_sistemas`
--

LOCK TABLES `catalogo_sistemas` WRITE;
/*!40000 ALTER TABLE `catalogo_sistemas` DISABLE KEYS */;
/*!40000 ALTER TABLE `catalogo_sistemas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cita_status`
--

DROP TABLE IF EXISTS `cita_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cita_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita_status`
--

LOCK TABLES `cita_status` WRITE;
/*!40000 ALTER TABLE `cita_status` DISABLE KEYS */;
INSERT INTO `cita_status` VALUES (1,'agendada'),(2,'confirmada'),(3,'cancelada');
/*!40000 ALTER TABLE `cita_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citas`
--

DROP TABLE IF EXISTS `citas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_paciente` int NOT NULL,
  `fecha_hora` datetime(6) DEFAULT NULL,
  `id_paciente_type` int NOT NULL,
  `id_status` int NOT NULL,
  `numero_sesion` int NOT NULL,
  `costo_terapia` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_idx` (`id_paciente_type`),
  KEY `status_idx` (`id_status`),
  CONSTRAINT `status` FOREIGN KEY (`id_status`) REFERENCES `cita_status` (`id`),
  CONSTRAINT `type` FOREIGN KEY (`id_paciente_type`) REFERENCES `paciente_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citas`
--

LOCK TABLES `citas` WRITE;
/*!40000 ALTER TABLE `citas` DISABLE KEYS */;
/*!40000 ALTER TABLE `citas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diagnostico`
--

DROP TABLE IF EXISTS `diagnostico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diagnostico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cita` int NOT NULL,
  `id_sistema` int NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `diagnostico` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cita_idx` (`id_cita`),
  KEY `sistema_idx` (`id_sistema`),
  CONSTRAINT `cita` FOREIGN KEY (`id_cita`) REFERENCES `citas` (`id`),
  CONSTRAINT `FKqyb0xjyiwomtrng91ernc9d3q` FOREIGN KEY (`id_sistema`) REFERENCES `catalogo_sistemas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnostico`
--

LOCK TABLES `diagnostico` WRITE;
/*!40000 ALTER TABLE `diagnostico` DISABLE KEYS */;
/*!40000 ALTER TABLE `diagnostico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudios`
--

DROP TABLE IF EXISTS `estudios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cita` int NOT NULL,
  `ubicacion` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ciya_idx` (`id_cita`),
  CONSTRAINT `citas` FOREIGN KEY (`id_cita`) REFERENCES `citas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudios`
--

LOCK TABLES `estudios` WRITE;
/*!40000 ALTER TABLE `estudios` DISABLE KEYS */;
/*!40000 ALTER TABLE `estudios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exploracion_fisica`
--

DROP TABLE IF EXISTS `exploracion_fisica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exploracion_fisica` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cita` int NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `exploracion` varchar(600) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_exploracion_fisica_citas1_idx` (`id_cita`),
  CONSTRAINT `fk_exploracion_fisica_citas1` FOREIGN KEY (`id_cita`) REFERENCES `citas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exploracion_fisica`
--

LOCK TABLES `exploracion_fisica` WRITE;
/*!40000 ALTER TABLE `exploracion_fisica` DISABLE KEYS */;
/*!40000 ALTER TABLE `exploracion_fisica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente_type`
--

DROP TABLE IF EXISTS `paciente_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente_type`
--

LOCK TABLES `paciente_type` WRITE;
/*!40000 ALTER TABLE `paciente_type` DISABLE KEYS */;
INSERT INTO `paciente_type` VALUES (1,'nicial'),(2,'Subsecuente');
/*!40000 ALTER TABLE `paciente_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `padecimiento`
--

DROP TABLE IF EXISTS `padecimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `padecimiento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  `evolucion` varchar(255) NOT NULL,
  `estado_actual` varchar(255) NOT NULL,
  `fecha` date NOT NULL,
  `id_cita` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK55be985aopg7851t9lxvappb7_idx` (`id_cita`),
  CONSTRAINT `FK55be985aopg7851t9lxvappb7` FOREIGN KEY (`id_cita`) REFERENCES `citas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `padecimiento`
--

LOCK TABLES `padecimiento` WRITE;
/*!40000 ALTER TABLE `padecimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `padecimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revaloracion`
--

DROP TABLE IF EXISTS `revaloracion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `revaloracion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_diagnostico` int NOT NULL,
  `id_sistema` int NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `diagnostico` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sistema_idx` (`id_sistema`),
  KEY `diagnostico_idx` (`id_diagnostico`),
  CONSTRAINT `diagnostico` FOREIGN KEY (`id_diagnostico`) REFERENCES `diagnostico` (`id`),
  CONSTRAINT `FK21vj47cso57gjv6n11b60y136` FOREIGN KEY (`id_sistema`) REFERENCES `catalogo_sistemas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revaloracion`
--

LOCK TABLES `revaloracion` WRITE;
/*!40000 ALTER TABLE `revaloracion` DISABLE KEYS */;
/*!40000 ALTER TABLE `revaloracion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-07  1:30:13
