-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: rvc
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `IdCompra` bigint NOT NULL AUTO_INCREMENT,
  `IdProveedor` int NOT NULL,
  `Total` double NOT NULL,
  `F_compra` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IdCompra`),
  KEY `IdProveedor` (`IdProveedor`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`IdProveedor`) REFERENCES `proveedor` (`IdProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,4,1412000,'2019-05-19'),(2,3,34500,'2018-02-02'),(3,5,93000,'2018-03-06'),(4,2,890000,'2017-07-05'),(5,1,154500,'2019-01-24'),(7,5,6000,'2020-07-06'),(8,5,3000,'2020-07-06'),(9,5,80000,'2020-07-06'),(10,5,2500,'2020-07-06');
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_de_compra`
--

DROP TABLE IF EXISTS `es_de_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_de_compra` (
  `IdCompra` bigint NOT NULL,
  `IdProducto` bigint NOT NULL,
  `Cantidad_C` int NOT NULL,
  KEY `IdCompra` (`IdCompra`),
  KEY `IdProducto` (`IdProducto`),
  CONSTRAINT `es_de_compra_ibfk_1` FOREIGN KEY (`IdCompra`) REFERENCES `compra` (`IdCompra`),
  CONSTRAINT `es_de_compra_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_de_compra`
--

LOCK TABLES `es_de_compra` WRITE;
/*!40000 ALTER TABLE `es_de_compra` DISABLE KEYS */;
INSERT INTO `es_de_compra` VALUES (1,5,2),(1,7,3),(2,3,4),(3,1,2),(3,6,2),(4,4,4),(5,2,5),(7,8,12),(8,8,6),(9,1,32),(10,1,1);
/*!40000 ALTER TABLE `es_de_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_de_venta`
--

DROP TABLE IF EXISTS `es_de_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_de_venta` (
  `IdVenta` bigint NOT NULL,
  `IdProducto` bigint NOT NULL,
  `Cantidad_V` int NOT NULL,
  KEY `IdVenta` (`IdVenta`),
  KEY `IdProducto` (`IdProducto`),
  CONSTRAINT `es_de_venta_ibfk_1` FOREIGN KEY (`IdVenta`) REFERENCES `venta` (`IdVenta`),
  CONSTRAINT `es_de_venta_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_de_venta`
--

LOCK TABLES `es_de_venta` WRITE;
/*!40000 ALTER TABLE `es_de_venta` DISABLE KEYS */;
INSERT INTO `es_de_venta` VALUES (1,1,1),(1,2,1),(1,6,1),(2,2,1),(2,3,1),(2,7,1),(3,2,1),(3,3,1),(3,5,1),(4,4,1),(4,7,1),(11,1,3),(12,1,1),(13,2,1),(14,1,1),(15,1,1),(16,1,51);
/*!40000 ALTER TABLE `es_de_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `IdProducto` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `precio_c` double NOT NULL,
  `precio_v` double NOT NULL,
  `c_serial` bigint NOT NULL,
  `f_vencimiento` varchar(10) DEFAULT NULL,
  `cantidad` int NOT NULL,
  `IdProveedor` int NOT NULL,
  PRIMARY KEY (`IdProducto`),
  KEY `IdProveedor` (`IdProveedor`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`IdProveedor`) REFERENCES `proveedor` (`IdProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Gatorade','Bebidas',2500,3600,10001101,'2021-06-11',0,5),(2,'Kumis','Lácteos',3090,5890,10000012,'2020-10-12',15,1),(3,'Grissly Clásica','Confitería',690,1550,10000503,'2022-05-19',40,3),(4,'Crema Dental Triple Acción','Cuidado personal',17800,33990,10019004,'2024-07-02',44,2),(5,'Galleta Kit-Kat','Confitería',2250,3490,10000025,'2023-03-06',48,4),(6,'Canada Dry','Bebidas',1200,2800,10030306,'2020-08-05',15,5),(7,'Milo Bolsa','Despensa',25990,44800,10000877,'2026-11-06',31,4),(8,'Speed Max','Bebidas',500,1000,10000002,'2020-09-12',18,5);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `IdProveedor` int NOT NULL AUTO_INCREMENT,
  `Nomb_Prov` varchar(20) NOT NULL,
  PRIMARY KEY (`IdProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Alpina'),(2,'Colgate'),(3,'Colombina S.A.'),(4,'Nestlé'),(5,'Postobón');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `Nom_usu` varchar(20) NOT NULL,
  `passw` varchar(20) NOT NULL,
  `tipo_usuario` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('Diego_RB','leganoajuanpa567','Administrador'),('Nicolás _RN','tanialamas123','Administrador'),('Juan_BM','nosequeponer408','Empleado');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `IdVenta` bigint NOT NULL AUTO_INCREMENT,
  `Nom_Cli` varchar(30) DEFAULT NULL,
  `Total` double NOT NULL,
  `F_venta` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IdVenta`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,'Pablo',94500,'2019-10-26'),(2,'Sebastian',493410,'2020-02-22'),(3,'Gisselle',73630,'2019-11-16'),(4,'Fernando',651940,'2020-03-03'),(11,'Gatorade',10800,'2020-07-05'),(12,'Pepito',3600,'2020-07-05'),(13,'Julia',5890,'2020-07-05'),(14,'tatis',3600,'2020-07-05'),(15,'Pepito',3600,'2020-07-06'),(16,'Pepito',183600,'2020-07-06');
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-06 18:24:01
