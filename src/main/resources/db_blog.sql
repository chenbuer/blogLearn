/*
SQLyog Ultimate v11.24 (64 bit)
MySQL - 5.6.17 : Database - db_blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_blog`;

/*Table structure for table `t_blog` */

DROP TABLE IF EXISTS `t_blog`;

CREATE TABLE `t_blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `summary` varchar(400) DEFAULT NULL,
  `releaseDate` datetime DEFAULT NULL,
  `clickHit` int(11) DEFAULT NULL,
  `replyHit` int(11) DEFAULT NULL,
  `content` text,
  `typeId` int(11) DEFAULT NULL,
  `keyWord` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeId` (`typeId`),
  CONSTRAINT `t_blog_ibfk_1` FOREIGN KEY (`typeId`) REFERENCES `t_blogtype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

/*Data for the table `t_blog` */

insert  into `t_blog`(`id`,`title`,`summary`,`releaseDate`,`clickHit`,`replyHit`,`content`,`typeId`,`keyWord`) values (1,'aa','aa','2017-04-10 00:40:28',2,2,'我是第一个',1,'test'),(2,'bb','我是第二个eeeesssssssssssssssssssssssssssssss','2017-03-16 22:40:05',0,0,'我是第二个eeeesssssssssssssssssssssssssssssss',2,'test'),(3,'update11','terstdfasda vfe bb b是否打算更让人','2017-04-11 23:36:26',0,0,'terstdfa<strong><span style=\"color:#E53333;\">sda vfe bb b是否打算更让</span></strong>人',2,'update update11'),(19,'dd','dd','2017-04-04 23:17:46',4,4,NULL,2,NULL),(20,'ee','ee','2017-04-12 23:18:14',5,5,NULL,1,NULL),(21,'ff','66','2017-04-04 23:18:28',6,6,NULL,2,NULL),(22,'ss','77','2017-04-21 23:18:39',7,7,NULL,2,NULL),(23,'test','88','2017-04-05 23:18:49',8,8,NULL,1,NULL),(24,'dd','ff','2017-04-20 00:11:57',4,4,NULL,1,NULL),(25,'dd','aa','2017-04-06 00:12:13',3,3,NULL,1,NULL),(26,'tt','dd','2017-04-15 00:12:25',3,3,NULL,1,NULL),(27,'55','5','2017-05-04 00:12:38',5,5,NULL,1,NULL),(28,'6','6','2017-04-28 00:12:50',6,6,NULL,2,NULL),(29,'7','7','2017-05-05 00:12:59',7,7,NULL,1,NULL),(30,'8','8','2017-04-13 00:13:09',8,8,NULL,1,NULL),(31,'9','9','2017-04-18 00:13:23',9,9,NULL,1,NULL),(32,'用kindeditor写的第一篇博客','						博客内容...\n					','2017-04-17 01:40:39',NULL,NULL,'						博客内容...\n					',1,'用kindeditor写的第一篇博客'),(33,'用kindeditor写的第一篇博客','						博客内容...\n					','2017-04-17 01:41:18',NULL,NULL,'						博客内容...\n					',1,'用kindeditor写的第一篇博客'),(34,'用kindeditor写的第一篇文章','						博客内容...\n					','2017-04-17 01:47:14',NULL,NULL,'						博客内容...\n					',1,'用kindeditor写的第一篇文章'),(35,'1111用kindeditor写的第一篇文章','						博客内容...\n					','2017-04-17 01:48:27',NULL,NULL,'						博客内容...\n					',2,'1111用kindeditor写的第一篇文章'),(36,NULL,NULL,'2017-04-17 02:03:21',NULL,NULL,NULL,NULL,NULL),(37,NULL,NULL,'2017-04-17 02:50:51',NULL,NULL,NULL,NULL,NULL),(38,NULL,NULL,'2017-04-17 02:50:58',NULL,NULL,NULL,NULL,NULL),(39,NULL,NULL,'2017-04-17 02:52:17',NULL,NULL,NULL,NULL,NULL),(40,NULL,NULL,'2017-04-17 02:53:12',NULL,NULL,NULL,NULL,NULL),(41,NULL,NULL,'2017-04-17 02:54:25',NULL,NULL,NULL,NULL,NULL),(42,'updateupdate','博客内容...','2017-04-18 01:00:25',NULL,NULL,'						博客内容...\n					',1,'updateupdate updateupdate'),(43,'updateupdate','博客内容...','2017-04-18 01:02:05',NULL,NULL,'						博客内容...\n					',1,'updateupdate updateupdate'),(44,'updateupdate','博客内容...','2017-04-18 01:03:40',NULL,NULL,'						博客内容...\n					',1,'updateupdate updateupdate'),(45,'用kindeditor编辑一个','用kindeditor编辑一个','2017-04-19 00:14:23',NULL,NULL,'用kindeditor编辑一个',2,'用kindeditor编辑一个'),(46,'lucene1','lucene1lucene1lucene1lucene1lucene1','2017-04-20 23:10:19',NULL,NULL,'lucene1lucene1lucene1lucene1lucene1',1,'lucene1'),(47,'lucene1','lucene1lucene1lucene1lucene1lucene1','2017-04-20 23:10:36',NULL,NULL,'lucene1lucene1lucene1lucene1lucene1',1,'lucene1'),(48,'lucene1','lucene1lucene1lucene1lucene1lucene1','2017-04-20 23:11:42',NULL,NULL,'lucene1lucene1lucene1lucene1lucene1',1,'lucene1'),(49,'lucene1','lucene1lucene1lucene1lucene1lucene1','2017-04-20 23:12:30',NULL,NULL,'lucene1lucene1lucene1lucene1lucene1',1,'lucene1'),(50,'lucene1','lucene1lucene1lucene1lucene1lucene1','2017-04-20 23:15:08',NULL,NULL,'lucene1lucene1lucene1lucene1lucene1',1,'lucene1'),(51,'lucene1','lucene1lucene1lucene1lucene1lucene1','2017-04-20 23:15:49',NULL,NULL,'lucene1lucene1lucene1lucene1lucene1',1,'lucene1'),(52,'lucene1','lucene1lucene1lucene1lucene1lucene1','2017-04-20 23:16:31',NULL,NULL,'lucene1lucene1lucene1lucene1lucene1',1,'lucene1'),(53,'lucene1','lucene1lucene1lucene1lucene1lucene1','2017-04-20 23:16:55',NULL,NULL,'lucene1lucene1lucene1lucene1lucene1',1,'lucene1'),(54,'lucene1','lucene1lucene1lucene1lucene1lucene1','2017-04-20 23:18:44',NULL,NULL,'lucene1lucene1lucene1lucene1lucene1',1,'lucene1'),(55,'lucenelucenelucene','lucenelucenelucenelucene','2017-04-21 00:05:39',NULL,NULL,'lucenelucenelucenelucene',2,'lucene'),(56,'lucenelucenelucene222','lucenelucenelucenelucene22','2017-04-21 00:08:35',NULL,NULL,'lucenelucenelucenelucene22',2,'lucene222'),(57,'lucenelucenelucene222','lucenelucenelucenelucene22','2017-04-21 00:08:51',NULL,NULL,'lucenelucenelucenelucene22',2,'lucene222');

/*Table structure for table `t_blogtype` */

DROP TABLE IF EXISTS `t_blogtype`;

CREATE TABLE `t_blogtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(30) DEFAULT NULL,
  `orderNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_blogtype` */

insert  into `t_blogtype`(`id`,`typeName`,`orderNo`) values (1,'java',1),(2,'python',2);

/*Table structure for table `t_link` */

DROP TABLE IF EXISTS `t_link`;

CREATE TABLE `t_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `linkName` varchar(100) DEFAULT NULL,
  `linkUrl` varchar(100) DEFAULT NULL,
  `linkNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_link` */

insert  into `t_link`(`id`,`linkName`,`linkUrl`,`linkNo`) values (1,'我的博客','http://chenbuer.github.com',1),(2,'我的github','http://github.com/chenbuer',2),(3,'我的facebook','http://www.facebook.com',3);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `profile` text,
  `nickName` varchar(50) DEFAULT NULL,
  `sign` varchar(100) DEFAULT NULL,
  `imageName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`userName`,`password`,`profile`,`nickName`,`sign`,`imageName`) values (1,'chenbuer','231d4af96cba51e9b10d0d973b845406','志远加油，屌不屌还得靠自己','chenbuer','大美女','chenbuer.png');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
