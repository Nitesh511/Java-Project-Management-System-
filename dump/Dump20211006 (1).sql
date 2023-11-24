-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `admittable`
--

DROP TABLE IF EXISTS `admittable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admittable` (
  `id` int NOT NULL,
  `patientname` varchar(45) DEFAULT NULL,
  `wardno` varchar(45) DEFAULT NULL,
  `bednum` varchar(45) DEFAULT NULL,
  `doctor` varchar(45) DEFAULT NULL,
  `nurse` varchar(45) DEFAULT NULL,
  `admitteddate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admittable`
--

LOCK TABLES `admittable` WRITE;
/*!40000 ALTER TABLE `admittable` DISABLE KEYS */;
INSERT INTO `admittable` VALUES (1,'Nitesh ','General','A1','Dr.Ashis(Neuro Surgen)','Sita',' 2056'),(2,'karki','General','A1','Dr.Ashis(Neuro Surgen)','Sita','2021'),(3,' Naruto','ICU','B1','Dr.shyam(Radiologist)','Muna',' 2021');
/*!40000 ALTER TABLE `admittable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diagno`
--

DROP TABLE IF EXISTS `diagno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diagno` (
  `id` int DEFAULT NULL,
  `patientname` varchar(45) DEFAULT NULL,
  `diagnosis` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagno`
--

LOCK TABLES `diagno` WRITE;
/*!40000 ALTER TABLE `diagno` DISABLE KEYS */;
INSERT INTO `diagno` VALUES (NULL,' Avishek','ICU'),(2,' Nishant',' 2056/11/14');
/*!40000 ALTER TABLE `diagno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keydate`
--

DROP TABLE IF EXISTS `keydate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `keydate` (
  `id` int DEFAULT NULL,
  `patientname` varchar(45) DEFAULT NULL,
  `treatmentdate` varchar(45) DEFAULT NULL,
  `treatmenttime` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keydate`
--

LOCK TABLES `keydate` WRITE;
/*!40000 ALTER TABLE `keydate` DISABLE KEYS */;
INSERT INTO `keydate` VALUES (NULL,' Avishek','2021','8'),(NULL,'Nishant ','2022',' 9'),(1,' avishek','2','2 '),(2,'Nishant ','2',' 1');
/*!40000 ALTER TABLE `keydate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab_report`
--

DROP TABLE IF EXISTS `lab_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lab_report` (
  `patient_id` int DEFAULT NULL,
  `file_path` varchar(45) DEFAULT NULL,
  `uploaded_date` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab_report`
--

LOCK TABLES `lab_report` WRITE;
/*!40000 ALTER TABLE `lab_report` DISABLE KEYS */;
INSERT INTO `lab_report` VALUES (1,'C:\\Users\\Owner\\Desktop\\1.txt','2021/10/06');
/*!40000 ALTER TABLE `lab_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicinetable`
--

DROP TABLE IF EXISTS `medicinetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicinetable` (
  `id` int NOT NULL,
  `patientname` varchar(45) DEFAULT NULL,
  `medicinename` varchar(45) DEFAULT NULL,
  `medicinetime` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicinetable`
--

LOCK TABLES `medicinetable` WRITE;
/*!40000 ALTER TABLE `medicinetable` DISABLE KEYS */;
INSERT INTO `medicinetable` VALUES (1,' vishek',' cetamol',' 12 am'),(2,' Nishant',' Flexon',' 10:45');
/*!40000 ALTER TABLE `medicinetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(50) DEFAULT NULL,
  `dob` varchar(50) DEFAULT NULL,
  `contact` int DEFAULT NULL,
  `age` int DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `bloodgroup` varchar(50) DEFAULT NULL,
  `doctor` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `symptoms` varchar(50) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,' cscswv',' wewvw',1235,18,'Male','A+','Dr.Bibek(Neuro Surgen)',' sfvrgvre',' regverge',' regerg'),(2,' Nishant',' 2056/11/14',984178,20,'Male','A+','Dr.Bibek(Cardio)',' Kathmandu',' Fever',' 2021/10/10'),(3,' Hestin',' 2021',8282727,20,'Male','A+','Dr.Bibek(Neuro Surgen)',' KTM',' Headache',' 2019');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `register` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
INSERT INTO `register` VALUES (1,'n','Admin','n','n','n','n');
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registration` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usertype` varchar(45) DEFAULT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` VALUES (6,'Admin',' ','','','Male',' ',''),(7,'Admin',' Naruto','Hatake','Naruto@gmail.com','Male',' Kapan','12345');
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-06 14:03:56
