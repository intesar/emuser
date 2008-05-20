-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	6.0.3-alpha-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema biz
--

CREATE DATABASE IF NOT EXISTS biz;
USE biz;

--
-- Definition of table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(45) NOT NULL,
  `authority` varchar(45) NOT NULL,
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Index_3` (`username`,`authority`),
  KEY `FK_authorities_2` (`authority`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` (`username`,`authority`,`id`) VALUES 
 ('mdshannan@gmail.com','ROLE_ADMIN',23),
 ('mdshannan@gmail.com','ROLE_USER',24);
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;


--
-- Definition of table `authority`
--

DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `role` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authority`
--

/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` (`role`,`description`) VALUES 
 ('ROLE_ADMIN',NULL),
 ('ROLE_USER',NULL);
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;


--
-- Definition of table `oraganization`
--

DROP TABLE IF EXISTS `oraganization`;
CREATE TABLE `oraganization` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `last_user` varchar(45) DEFAULT NULL,
  `last_action` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Index_3` (`name`),
  KEY `FK_oraganization_1` (`id`,`description`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `oraganization`
--

/*!40000 ALTER TABLE `oraganization` DISABLE KEYS */;
INSERT INTO `oraganization` (`id`,`name`,`type`,`description`,`last_user`,`last_action`) VALUES 
 (14,'xyz','IT','n/a',NULL,NULL);
/*!40000 ALTER TABLE `oraganization` ENABLE KEYS */;


--
-- Definition of table `timesheet`
--

DROP TABLE IF EXISTS `timesheet`;
CREATE TABLE `timesheet` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `submision_date` datetime DEFAULT NULL,
  `status` varchar(45) NOT NULL,
  `user` int(10) unsigned NOT NULL,
  `paid_amount` int(10) unsigned DEFAULT NULL,
  `status_date` datetime NOT NULL,
  `comment` varchar(45) DEFAULT NULL,
  `last_user` varchar(45) NOT NULL,
  `last_action` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_timesheet_1` (`user`),
  CONSTRAINT `FK_timesheet_1` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `timesheet`
--

/*!40000 ALTER TABLE `timesheet` DISABLE KEYS */;
/*!40000 ALTER TABLE `timesheet` ENABLE KEYS */;


--
-- Definition of table `timesheet_detail`
--

DROP TABLE IF EXISTS `timesheet_detail`;
CREATE TABLE `timesheet_detail` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `timesheet` int(10) unsigned NOT NULL DEFAULT '1',
  `current_date` date NOT NULL,
  `regular_hour` double NOT NULL DEFAULT '0',
  `over_time_hour` double NOT NULL DEFAULT '0',
  `day` varchar(45) NOT NULL DEFAULT 'MONDAY',
  `last_user` varchar(45) NOT NULL,
  `last_action` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_timesheet_detail_1` (`timesheet`),
  CONSTRAINT `FK_timesheet_detail_1` FOREIGN KEY (`timesheet`) REFERENCES `timesheet` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `timesheet_detail`
--

/*!40000 ALTER TABLE `timesheet_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `timesheet_detail` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `enabled` tinyint(3) unsigned NOT NULL DEFAULT '1',
  `last_user` varchar(45) DEFAULT NULL,
  `last_aciton` varchar(45) DEFAULT NULL,
  `organization` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Index_3` (`username`),
  KEY `FK_users_1` (`organization`),
  CONSTRAINT `FK_users_1` FOREIGN KEY (`organization`) REFERENCES `oraganization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`,`username`,`password`,`first_name`,`last_name`,`enabled`,`last_user`,`last_aciton`,`organization`) VALUES 
 (15,'mdshannan@gmail.com','admin','n/a','n/a',0,NULL,NULL,14);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
