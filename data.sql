-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hyh_work
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `approval`
--

DROP TABLE IF EXISTS `approval`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `approval` (
  `aid` int NOT NULL AUTO_INCREMENT,
  `sid` int DEFAULT NULL,
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `reason` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `attName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `att` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `msg` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `approval`
--

LOCK TABLES `approval` WRITE;
/*!40000 ALTER TABLE `approval` DISABLE KEYS */;
INSERT INTO `approval` VALUES (1,1,'张无忌要请假','光明顶被围攻，急需回明教!','请假','等待审批','张无忌的附件.docx','attachment/张无忌的附件.docx',''),(2,5,'黄蓉要请假','有考试需要参加，望老师批准','请假','等待审批','黄蓉的附件.docx','attachment/黄蓉的附件.docx',''),(3,7,'小龙女要休学','身体原因，希望休学','休学','等待审批','小龙女的附件.docx','attachment/小龙女的附件.docx',''),(5,2,'我想回家','sdad','请假',NULL,NULL,NULL,NULL),(6,2,'djaskl','dasdasl','请假',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `approval` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arrange_course`
--

DROP TABLE IF EXISTS `arrange_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `arrange_course` (
  `ctid` int NOT NULL AUTO_INCREMENT,
  `oid` int DEFAULT NULL,
  `rid` int DEFAULT NULL,
  `weekno` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `week` int DEFAULT NULL,
  `start` int DEFAULT NULL,
  `size` int DEFAULT NULL,
  PRIMARY KEY (`ctid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arrange_course`
--

LOCK TABLES `arrange_course` WRITE;
/*!40000 ALTER TABLE `arrange_course` DISABLE KEYS */;
INSERT INTO `arrange_course` VALUES (1,1,5,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',1,1,2),(2,2,6,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',1,3,2),(3,4,7,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',1,5,3),(4,3,8,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',2,1,2),(5,6,9,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',2,5,2),(6,7,10,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',3,1,2),(7,1,5,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',4,3,2),(8,2,6,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',4,9,2),(9,3,7,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',5,3,2),(10,6,8,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',5,5,2),(11,8,10,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',1,3,2),(12,9,9,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',1,1,2),(13,11,8,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',1,5,3),(14,10,7,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',2,3,2),(15,13,6,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',2,6,2),(16,14,5,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',3,3,2),(17,8,8,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',4,5,2),(18,9,7,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',4,7,2),(19,10,6,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',5,1,2),(20,13,5,'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',5,7,2),(24,1,10,'1,3,5,7,9,11,13,15',5,7,2);
/*!40000 ALTER TABLE `arrange_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `people` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'[教务处]江苏省2021年下半年中小学教师资格考试笔试报名公告','叶孤城','2021-10-01','article/1-江苏省2021年下半年中小学教师资格考试笔试报名公告.html'),(2,'[教务处]关于做好江苏第二师范学院2021届本科毕业设计（论文）抽检评优工作的通知','花满楼','2021-10-02','article/2-关于做好江苏第二师范学院2021届本科毕业设计（论文）抽检评优工作的通知.html'),(3,'[教务处]2021-2022学年校历','楚留香','2021-10-03','article/3-2021-2022学年校历.html'),(4,'[教务处]关于做好2020—2021学年第二学期期末考试工作的通知','花无缺','2021-10-04','article/4-关于做好2020—2021学年第二学期期末考试工作的通知.html'),(5,'[教务处]关于做好2021年秋季江苏省高等学校计算机等级考试报名的通知','傅红雪','2021-10-05','article/5-关于做好2021年秋季江苏省高等学校计算机等级考试报名的通知.html'),(6,'[教务处]江苏省2021年下半年中小学教师资格考试笔试报名公告','叶孤城','2021-10-06','article/6-江苏省2021年下半年中小学教师资格考试笔试报名公告.html'),(7,'[教务处]关于做好江苏第二师范学院2021届本科毕业设计（论文）抽检评优工作的通知','花满楼','2021-10-07','article/7-关于做好江苏第二师范学院2021届本科毕业设计（论文）抽检评优工作的通知.html'),(8,'[教务处]2021-2022学年校历','楚留香','2021-10-08','article/8-2021-2022学年校历.html'),(9,'[教务处]关于做好2020—2021学年第二学期期末考试工作的通知','花无缺','2021-10-09','article/9-关于做好2020—2021学年第二学期期末考试工作的通知.html'),(10,'[教务处]关于做好2021年秋季江苏省高等学校计算机等级考试报名的通知','傅红雪','2021-10-10','article/10-关于做好2021年秋季江苏省高等学校计算机等级考试报名的通知.html'),(11,'[教务处]江苏省2021年下半年中小学教师资格考试笔试报名公告','叶孤城','2021-10-11','article/11-江苏省2021年下半年中小学教师资格考试笔试报名公告.html'),(12,'[教务处]关于做好江苏第二师范学院2021届本科毕业设计（论文）抽检评优工作的通知','花满楼','2021-10-12','article/12-关于做好江苏第二师范学院2021届本科毕业设计（论文）抽检评优工作的通知.html'),(13,'[教务处]2021-2022学年校历','楚留香','2021-10-13','article/13-2021-2022学年校历.html'),(14,'[教务处]关于做好2020—2021学年第二学期期末考试工作的通知','花无缺','2021-10-14','article/14-关于做好2020—2021学年第二学期期末考试工作的通知.html'),(15,'[教务处]关于做好2021年秋季江苏省高等学校计算机等级考试报名的通知','傅红雪','2021-10-15','article/15-关于做好2021年秋季江苏省高等学校计算机等级考试报名的通知.html'),(16,'[教务处]江苏省2021年下半年中小学教师资格考试笔试报名公告','叶孤城','2021-10-16','article/16-江苏省2021年下半年中小学教师资格考试笔试报名公告.html');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clazz`
--

DROP TABLE IF EXISTS `clazz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clazz` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `cname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mid` int DEFAULT NULL,
  `cremark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clazz`
--

LOCK TABLES `clazz` WRITE;
/*!40000 ALTER TABLE `clazz` DISABLE KEYS */;
INSERT INTO `clazz` VALUES (1,'19小教1班',1,'无'),(2,'20小教1班',1,'无'),(3,'19学前1班',3,'无'),(4,'20学前1班',3,'无'),(5,'19计科1班',4,'无'),(6,'19计科2班',4,'无'),(7,'20计科1班',4,'无'),(8,'20计科2班',4,'无'),(9,'19数学1班',5,'无'),(10,'19数学2班',5,'无'),(11,'20数学1班',5,'无'),(12,'19物联网1班',6,'无'),(13,'20物联网1班',6,'无'),(14,'19汉语言1班',9,'无'),(15,'20汉语言1班',9,'无'),(16,'20汉语言2班',9,'无'),(17,'19英语1班',11,'无'),(18,'20英语1班',11,'无');
/*!40000 ALTER TABLE `clazz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `courseId` int NOT NULL AUTO_INCREMENT,
  `courseName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `courseRemark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`courseId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'高等数学','无'),(2,'线性代数','无'),(3,'概率论与数理统计','无'),(4,'离散数学','无'),(5,'大学英语','无'),(6,'形势与政策','无'),(7,'C程序设计','无'),(8,'数据结构','无'),(9,'操作系统','无'),(10,'计算机组成原理','无'),(11,'计算机网络','无'),(12,'Java程序设计','无'),(13,'数据库原理及应用','无'),(14,'Python程序设计','无'),(15,'人工智能','无');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_grade`
--

DROP TABLE IF EXISTS `course_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_grade` (
  `cgid` int NOT NULL AUTO_INCREMENT,
  `oid` int DEFAULT NULL,
  `sid` int DEFAULT NULL,
  `score` decimal(10,1) DEFAULT NULL,
  PRIMARY KEY (`cgid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_grade`
--

LOCK TABLES `course_grade` WRITE;
/*!40000 ALTER TABLE `course_grade` DISABLE KEYS */;
INSERT INTO `course_grade` VALUES (1,1,1,85.0),(2,1,2,95.7),(3,1,3,59.5),(4,8,7,95.5),(5,8,8,87.0),(6,8,9,59.5),(18,1,4,92.0),(19,1,5,85.0),(20,1,6,77.0),(21,8,10,55.0),(22,8,11,44.0),(23,8,12,99.0),(24,2,1,85.0),(25,2,2,75.0),(26,2,3,33.0),(27,2,4,60.0),(28,2,5,95.0),(29,2,6,71.0),(30,3,1,78.0),(31,3,2,64.0),(32,3,3,99.0),(33,3,4,51.0),(34,3,5,77.0),(35,3,6,85.0);
/*!40000 ALTER TABLE `course_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `major` (
  `mid` int NOT NULL AUTO_INCREMENT,
  `mname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mdept` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mremark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major`
--

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
INSERT INTO `major` VALUES (2,'教育技术学','教育科学学院','无'),(3,'学前教育','学前教育学院','无'),(4,'计算机科学与技术','数信学院','无'),(5,'数学与应用数学','数信学院','无'),(6,'物联网工程','数信学院','无'),(7,'物理学','工程学院','无'),(8,'电子信息工程','工程学院','无'),(9,'汉语言文学','人文学院','无'),(10,'秘书学','人文学院','无'),(11,'英语','外国语学院','无'),(13,'生物科学','生命科学学院','无'),(14,'化学','生命科学学院','无'),(15,'财务管理','经管学院','无'),(16,'音乐学','艺术学院','无'),(19,'美术学','艺术学院','无'),(20,'信息管理与信息系统','数信学院',NULL);
/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manager` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pswd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,'admin','admin','管理员'),(6,'ygc','ygc','教务处'),(7,'fhx','fhx','教务处'),(8,'hwq','hwq','教务处'),(9,'clx','clx','教务处'),(10,'hml','hml','教务处'),(11,'管理123','$2a$10$k/NGb1Geu5I7crWp9OgKGOGYeXWFINaioko3O2zR4jDIL9FIsP8.i',NULL);
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `open_course`
--

DROP TABLE IF EXISTS `open_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `open_course` (
  `oid` int NOT NULL AUTO_INCREMENT,
  `year` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `term` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cid` int DEFAULT NULL,
  `tid` int DEFAULT NULL,
  `courseId` int DEFAULT NULL,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `open_course`
--

LOCK TABLES `open_course` WRITE;
/*!40000 ALTER TABLE `open_course` DISABLE KEYS */;
INSERT INTO `open_course` VALUES (1,'2021-2022学年','第一学期',7,1,1,'基础课'),(2,'2021-2022学年','第一学期',7,2,2,'基础课'),(3,'2021-2022学年','第一学期',7,3,4,'基础课'),(4,'2021-2022学年','第一学期',7,4,5,'专业课'),(5,'2021-2022学年','第一学期',7,5,6,'专业课'),(6,'2021-2022学年','第一学期',7,6,7,'专业课'),(7,'2021-2022学年','第一学期',7,7,10,'专业课'),(8,'2021-2022学年','第一学期',8,1,1,'基础课'),(9,'2021-2022学年','第一学期',8,2,2,'基础课'),(10,'2021-2022学年','第一学期',8,3,4,'基础课'),(11,'2021-2022学年','第一学期',8,4,5,'专业课'),(12,'2021-2022学年','第一学期',8,5,6,'专业课'),(13,'2021-2022学年','第一学期',8,6,7,'专业课'),(14,'2021-2022学年','第一学期',8,7,10,'专业课');
/*!40000 ALTER TABLE `open_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `rid` int NOT NULL AUTO_INCREMENT,
  `rname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `capacity` int DEFAULT NULL,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'博1-101',200,'阶梯教室'),(2,'博1-102',200,'阶梯教室'),(3,'博1-201',200,'阶梯教室'),(4,'博1-202',200,'阶梯教室'),(5,'博2-101',70,'普通教室'),(6,'博2-102',70,'普通教室'),(7,'博2-201',70,'普通教室'),(8,'博2-202',70,'普通教室'),(9,'博2-301',150,'普通教室'),(10,'博2-302',150,'普通教室'),(11,'明1-301',70,'实验室1'),(12,'明1-302',70,'实验室1'),(13,'明1-401',150,'实验室2'),(14,'崇1-301',140,'普通教室');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `sid` int NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ssex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sage` int DEFAULT NULL,
  `cid` int DEFAULT NULL,
  `sstatus` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sremark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pswd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'张无忌','男',20,7,'正常','无','18698765432','湖北省十堰市丹江口市武当山','$10$9125K1OEbHTm8IEeCYrP0.87gZ6deODR8kI9.wkdJUKiw9WKYqj42'),(2,'学生123','女',23,7,'正常','无','186987654332','江苏省南京市秦淮区王府大道','$2a$10$7fTnlIJw5NAKdviWcQlOJedvsurDCAN8085tGuW2W.2h0rKhB93d2'),(3,'赵敏','女',16,7,'正常','无','18698765432','北京市东城区汝阳王府','$10$9125K1OEbHTm8IEeCYrP0.87gZ6deODR8kI9.wkdJUKiw9WKYqj42'),(4,'郭靖','男',18,7,'正常','无','18698765432','浙江省杭州市牛家村','$10$9125K1OEbHTm8IEeCYrP0.87gZ6deODR8kI9.wkdJUKiw9WKYqj42'),(5,'黄蓉','女',16,7,'正常','无','18698765432','浙江省舟山市桃花岛','$10$9125K1OEbHTm8IEeCYrP0.87gZ6deODR8kI9.wkdJUKiw9WKYqj42'),(6,'杨过','男',17,7,'正常','无','18698765432','陕西省西安市终南山','$10$9125K1OEbHTm8IEeCYrP0.87gZ6deODR8kI9.wkdJUKiw9WKYqj42'),(7,'小龙女','女',16,8,'正常','无','18698765432','陕西省西安市终南山','$10$9125K1OEbHTm8IEeCYrP0.87gZ6deODR8kI9.wkdJUKiw9WKYqj42'),(8,'段誉','男',20,8,'正常','无','18698765432','云南省大理市大理皇宫','$10$9125K1OEbHTm8IEeCYrP0.87gZ6deODR8kI9.wkdJUKiw9WKYqj42'),(9,'乔峰','男',23,8,'正常','无','18698765432','内蒙古赤峰市南院大王府','$10$9125K1OEbHTm8IEeCYrP0.87gZ6deODR8kI9.wkdJUKiw9WKYqj42'),(10,'虚竹','男',21,8,'正常','无','18698765432','河南省郑州市登封市少林寺','$10$9125K1OEbHTm8IEeCYrP0.87gZ6deODR8kI9.wkdJUKiw9WKYqj42'),(11,'王语嫣','女',17,8,'正常','无','18698765432','江苏省苏州市吴中区金庭镇曼陀山庄','$10$9125K1OEbHTm8IEeCYrP0.87gZ6deODR8kI9.wkdJUKiw9WKYqj42'),(12,'陆冠英','男',18,1,'正常','无','18698765432','江苏省无锡市宜兴市周铁镇归云庄','$10$9125K1OEbHTm8IEeCYrP0.87gZ6deODR8kI9.wkdJUKiw9WKYqj42'),(13,'贾宝玉','男',15,2,'正常','无','18698765432','江苏省南京市秦淮区荣国公府','$10$9125K1OEbHTm8IEeCYrP0.87gZ6deODR8kI9.wkdJUKiw9WKYqj42'),(14,'林黛玉','女',13,2,'正常','无','18698765432','江苏省苏州市姑苏区林府','$10$9125K1OEbHTm8IEeCYrP0.87gZ6deODR8kI9.wkdJUKiw9WKYqj42'),(15,'薛宝钗','女',16,2,'正常','无','18698765432','江苏省南京市秦淮区薛府','$10$9125K1OEbHTm8IEeCYrP0.87gZ6deODR8kI9.wkdJUKiw9WKYqj42'),(16,'贾探春','女',14,2,'正常','无','18698765432','江苏省南京市秦淮区荣国公府','$10$9125K1OEbHTm8IEeCYrP0.87gZ6deODR8kI9.wkdJUKiw9WKYqj42'),(17,'王熙凤','女',23,2,'正常','无','18398273492','sdadasd','$10$9125K1OEbHTm8IEeCYrP0.87gZ6deODR8kI9.wkdJUKiw9WKYqj42'),(20,'周芷若','女',17,7,'正常','无','18698765432','四川省乐山市峨眉山市峨眉山','$10$9125K1OEbHTm8IEeCYrP0.87gZ6deODR8kI9.wkdJUKiw9WKYqj42');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `tid` int NOT NULL AUTO_INCREMENT,
  `tname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tsex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tstatus` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tremark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pswd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'张三丰','男','正常','无','13952776288','湖北省十堰市丹江口市武当山','123456'),(2,'老师123','男','正常','无','13952776288','新疆省乌鲁木齐市天山灵鹫公','$2a$10$b3c1hCOeYLiouNkKS3gZpOAoziqFKOOTdt2xlqPNq461UTvfMr1Nq'),(3,'马钰','男','正常','无','13952776288','陕西省西安市终南山','123456'),(4,'洪七公','男','正常','无','13952776288','河南省开封市丐帮总舵','123456'),(5,'黄药师','男','正常','无','13952776288','浙江省舟山市桃花岛','123456'),(6,'王重阳','男','正常','无','13952776288','陕西省西安市终南山','$2a$10$nO/tbz6AvBKoX1/WeeFaZOtCRIwY5ZhJElyQkHDKWbQyHHHnPFAG2'),(7,'独孤求败','男','正常','无','13952776288','湖北省襄阳市城郊','123456'),(8,'风清扬','男','正常','无','13952776288','陕西省渭南市华阴市华山','123456'),(9,'宁中则','女','正常','无','13952776288','陕西省渭南市华阴市华山','123456'),(10,'岳不群','男','正常','无','13952776288','陕西省渭南市华阴市华山','123456'),(11,'天山童姥','女','正常','无','13952776288','新疆省乌鲁木齐市天山灵鹫宫','123456'),(12,'穆人清','男','正常','无','13952776288','陕西省渭南市华阴市华山','123456'),(13,'陈近南','男','正常','无','13952776288','福建省漳州府龙溪县石美村','123456'),(14,'九难','女','正常','无','13952776288','北京市东城区紫禁城','123456'),(16,'柯镇恶','男','正常','无','13952776288','浙江省嘉兴市南湖区南湖','123456');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-28 22:44:28
