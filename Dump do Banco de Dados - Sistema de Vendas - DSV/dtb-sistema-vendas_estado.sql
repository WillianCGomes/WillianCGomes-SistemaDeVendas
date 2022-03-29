-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: dtb-sistema-vendas
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
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `id_estado` int NOT NULL AUTO_INCREMENT,
  `codigo_uf` int NOT NULL,
  `nome` varchar(50) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `regiao_id_regiao` int NOT NULL,
  PRIMARY KEY (`id_estado`),
  KEY `fk_estado_regiao_idx` (`regiao_id_regiao`),
  CONSTRAINT `fk_estado_regiao` FOREIGN KEY (`regiao_id_regiao`) REFERENCES `regiao` (`id_regiao`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,12,'Acre','AC',1),(2,27,'Alagoas','AL',2),(3,13,'Amazonas','AM',1),(4,16,'Amapá','AP',1),(5,29,'Bahia','BA',2),(6,23,'Ceará','CE',2),(7,53,'Distrito Federal','DF',5),(8,32,'Espírito Santo','ES',3),(9,52,'Goiás','GO',5),(10,21,'Maranhão','MA',2),(11,31,'Minas Gerais','MG',3),(12,50,'Mato Grosso do Sul','MS',5),(13,51,'Mato Grosso','MT',5),(14,15,'Pará','PA',1),(15,25,'Paraíba','PB',2),(16,26,'Pernambuco','PE',2),(17,22,'Piauí','PI',2),(18,41,'Paraná','PR',4),(19,33,'Rio de Janeiro','RJ',3),(20,24,'Rio Grande do Norte','RN',2),(21,11,'Rondônia','RO',1),(22,14,'Roraima','RR',1),(23,43,'Rio Grande do Sul','RS',4),(24,42,'Santa Catarina','SC',4),(25,28,'Sergipe','SE',2),(26,35,'São Paulo','SP',3),(27,17,'Tocantins','TO',1);
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-29  0:14:42
