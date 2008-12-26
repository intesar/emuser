-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.67-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema pm
--

CREATE DATABASE IF NOT EXISTS pm;
USE pm;

--
-- Definition of table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(45) NOT NULL,
  `authority` varchar(45) NOT NULL,
  `id` int(10) unsigned NOT NULL auto_increment,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `Index_2` (`username`,`authority`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` (`username`,`authority`,`id`) VALUES 
 ('abc','ROLE_USER',10),
 ('abc1','ROLE_ADMIN',12),
 ('abc1','ROLE_USER',11),
 ('fatimashanoor1','ROLE_ADMIN',8),
 ('fatimashanoor1','ROLE_USER',5),
 ('i','ROLE_ADMIN',20),
 ('i','ROLE_USER',21),
 ('intesar.mohammed','ROLE_ADMIN',3),
 ('intesar.mohammed','ROLE_USER',2),
 ('irfan.mohammed@bizintelapps.com','ROLE_USER',26),
 ('jjj','ROLE_ADMIN',18),
 ('jjj','ROLE_USER',19),
 ('kkk','ROLE_ADMIN',14),
 ('kkk','ROLE_USER',13),
 ('lll','ROLE_ADMIN',17),
 ('lll','ROLE_USER',16),
 ('m','ROLE_USER',15),
 ('mdshannan@gmail.com','ROLE_ADMIN',25),
 ('mdshannan@gmail.com','ROLE_USER',24),
 ('shannan.mohammed','ROLE_ADMIN',23),
 ('shannan.mohammed','ROLE_USER',22),
 ('xy','ROLE_ADMIN',9),
 ('xy','ROLE_USER',6);
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;


--
-- Definition of table `organization`
--

DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `website_url` varchar(145) default NULL,
  `create_user` int(10) unsigned default NULL,
  `create_ip` varchar(45) default NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `Index_2` (`name`),
  KEY `Index_3` (`website_url`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `organization`
--

/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` (`id`,`name`,`website_url`,`create_user`,`create_ip`,`create_date`) VALUES 
 (7,'bizintelapps',NULL,NULL,NULL,'2008-11-26 23:14:33'),
 (8,'bizintelapps.com',NULL,NULL,NULL,'2008-12-11 19:44:35'),
 (9,'mdshannan',NULL,NULL,NULL,'2008-12-20 23:04:48');
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;


--
-- Definition of table `project`
--

DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `description` varchar(1000) default NULL,
  `_status` varchar(45) NOT NULL default '',
  `create_user` varchar(45) NOT NULL,
  `create_date` datetime NOT NULL,
  `visibility` varchar(45) default NULL,
  `parent_project` int(10) unsigned default NULL,
  `organization` int(10) unsigned NOT NULL,
  `last_update_user` int(10) unsigned default NULL,
  `last_update_date` datetime default NULL,
  `estimated_hours` double default '0',
  `hourly_rate` double default '0',
  `estimated_cost` double default '0',
  `notification_emails` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_project_organization` (`organization`),
  CONSTRAINT `FK_project_1` FOREIGN KEY (`organization`) REFERENCES `organization` (`id`),
  CONSTRAINT `FK_project_organization` FOREIGN KEY (`organization`) REFERENCES `organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project`
--

/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` (`id`,`name`,`description`,`_status`,`create_user`,`create_date`,`visibility`,`parent_project`,`organization`,`last_update_user`,`last_update_date`,`estimated_hours`,`hourly_rate`,`estimated_cost`,`notification_emails`) VALUES 
 (2,'OurUmmah','Muslim Social Networking. alksjdflaks','On Hold','5','2008-11-29 23:45:52',NULL,NULL,8,15,'2008-12-13 19:25:53',0,0,0,NULL),
 (3,'OurUmmah3','Muslim Social Networking','Completed','5','2008-11-29 23:45:52','',NULL,8,15,'2008-12-13 19:26:49',0,0,0,NULL),
 (4,'OurUmmah4','Muslim Social Networking','In Progess','5','2008-11-29 23:45:52','',NULL,8,5,'2008-11-29 00:00:00',0,0,0,NULL),
 (5,'OurUmmah5','Muslim Social Networking','In Progess','5','2008-11-29 23:45:52','',NULL,8,5,'2008-11-29 00:00:00',0,0,0,NULL),
 (6,'OurUmmah6','Muslim Social Networking','In Progess','5','2008-11-29 23:45:52','',NULL,8,5,'2008-11-29 00:00:00',0,0,0,NULL),
 (7,'OurUmmah7','Muslim Social Networking','In Progess','5','2008-11-29 23:45:52','',NULL,8,5,'2008-11-29 00:00:00',0,0,0,NULL),
 (8,'OurUmmah8','Muslim Social Networking','In Progess','5','2008-11-29 23:45:52','',NULL,8,5,'2008-11-29 00:00:00',0,0,0,NULL),
 (9,'OurUmmah9','Muslim Social Networking','In Progess','5','2008-11-29 23:45:52','',NULL,8,5,'2008-11-29 00:00:00',0,0,0,NULL),
 (10,'OurUmmah10','Muslim Social Networking...... testing this','On Hold','5','2008-11-29 23:45:52','',NULL,8,15,'2008-12-13 19:31:42',0,0,0,NULL),
 (11,'OurUmmah11','Muslim Social Networking','In Progess','5','2008-11-29 23:45:52','',NULL,8,5,'2008-11-29 00:00:00',0,0,0,NULL),
 (12,'OurUmmah12','Muslim Social Networking','In Progess','5','2008-11-29 23:45:52','',NULL,8,5,'2008-11-29 00:00:00',0,0,0,NULL),
 (13,'OurUmmah13','Muslim Social Networking','In Progess','5','2008-11-29 23:45:52','',NULL,8,5,'2008-11-29 00:00:00',0,0,0,NULL),
 (14,'test-project1',NULL,'In Progress','15','2008-12-13 19:34:14',NULL,NULL,8,15,'2008-12-13 19:34:14',0,0,0,NULL),
 (15,'urooj',NULL,'In Progress','15','2008-12-19 22:11:49',NULL,NULL,8,15,'2008-12-19 22:11:49',0,0,0,NULL),
 (16,'ittefaaq','','Completed','15','2008-12-19 22:12:10',NULL,NULL,8,15,'2008-12-20 14:56:11',0,0,0,NULL),
 (17,'',NULL,'In Progress','15','2008-12-22 20:39:44',NULL,NULL,8,15,'2008-12-22 20:39:44',0,0,0,NULL),
 (18,'hello-brother',NULL,'In Progress','15','2008-12-25 19:07:38',NULL,NULL,8,15,'2008-12-25 19:07:38',0,0,0,'0.0');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;


--
-- Definition of table `project_users`
--

DROP TABLE IF EXISTS `project_users`;
CREATE TABLE `project_users` (
  `id` int(11) NOT NULL auto_increment,
  `is_enabled` tinyint(1) default '0',
  `expiration_date` datetime default NULL,
  `is_manager` tinyint(1) unsigned NOT NULL default '0',
  `create_date` datetime NOT NULL,
  `project` int(11) default NULL,
  `create_user` int(11) default NULL,
  `users` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project_users`
--

/*!40000 ALTER TABLE `project_users` DISABLE KEYS */;
INSERT INTO `project_users` (`id`,`is_enabled`,`expiration_date`,`is_manager`,`create_date`,`project`,`create_user`,`users`) VALUES 
 (1,1,NULL,1,'2008-12-21 00:02:39',3,15,15),
 (13,1,NULL,1,'2008-12-25 02:34:02',3,15,12);
/*!40000 ALTER TABLE `project_users` ENABLE KEYS */;


--
-- Definition of table `task`
--

DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int(11) NOT NULL,
  `parent_task` int(11) default NULL,
  `sequence_number` double default NULL,
  `title` varchar(105) NOT NULL default 'na',
  `context` varchar(45) default NULL,
  `deadline` datetime default NULL,
  `completed_date` datetime default NULL,
  `visibility` varchar(45) default NULL,
  `last_status_changed_date` datetime default NULL,
  `_status` varchar(45) NOT NULL default 'New',
  `create_date` datetime default NULL,
  `percentage_completed` int(11) default NULL,
  `description` varchar(255) default NULL,
  `priority` varchar(45) NOT NULL default 'Medium',
  `project` int(11) default NULL,
  `owner` int(11) default NULL,
  `assigned_to` int(11) default NULL,
  `estimated_hours` double default NULL,
  `spend_hours` double default '1',
  `notification_emails` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task`
--

/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` (`id`,`parent_task`,`sequence_number`,`title`,`context`,`deadline`,`completed_date`,`visibility`,`last_status_changed_date`,`_status`,`create_date`,`percentage_completed`,`description`,`priority`,`project`,`owner`,`assigned_to`,`estimated_hours`,`spend_hours`,`notification_emails`) VALUES 
 (1,NULL,NULL,'test1',NULL,'2009-10-10 00:00:00','2009-10-11 00:00:00',NULL,NULL,'New','2008-12-25 00:00:00',NULL,'testing task','Medium',NULL,15,8,NULL,1,NULL),
 (7,NULL,NULL,'tes71','','2009-10-10 00:00:00','2009-10-11 00:00:00','','2009-10-11 00:00:00','New','2008-12-21 00:00:00',NULL,'testing task','Medium',3,15,8,NULL,1,NULL),
 (8,NULL,NULL,'tes71','','2009-10-10 00:00:00','2009-10-11 00:00:00','','2009-10-11 00:00:00','New','2008-12-22 00:00:00',NULL,'testing task','Medium',4,15,NULL,NULL,1,NULL),
 (9,NULL,NULL,'tes71','','2009-10-10 00:00:00','2009-10-11 00:00:00','','2009-10-11 00:00:00','New','2008-12-23 00:00:00',NULL,'testing task','Medium',NULL,15,8,NULL,1,NULL),
 (21,NULL,NULL,'tes21','','2009-10-10 00:00:00','2009-10-11 00:00:00','','2009-10-11 00:00:00','New','2008-12-10 00:00:00',NULL,'testing task','Medium',NULL,15,8,NULL,1,NULL),
 (31,NULL,NULL,'tes31','','2009-10-10 00:00:00','2009-10-11 00:00:00','','2009-10-11 00:00:00','New','2008-12-10 00:00:00',NULL,'testing task','Medium',NULL,15,8,NULL,1,NULL),
 (41,NULL,NULL,'tes41','','2009-10-10 00:00:00','2009-10-11 00:00:00','','2009-10-11 00:00:00','New','2008-12-10 00:00:00',NULL,'testing task','Medium',NULL,15,8,NULL,1,NULL),
 (51,NULL,NULL,'tes51','','2009-10-10 00:00:00','2009-10-11 00:00:00','','2009-10-11 00:00:00','New','2008-12-10 00:00:00',NULL,'testing task','Medium',NULL,15,8,NULL,1,NULL),
 (61,NULL,NULL,'tes61','','2009-10-10 00:00:00','2009-10-11 00:00:00','','2009-10-11 00:00:00','New','2008-12-10 00:00:00',NULL,'testing task','Medium',NULL,15,8,NULL,1,NULL),
 (71,NULL,NULL,'tes71','','2009-10-10 00:00:00','2009-10-11 00:00:00','','2009-10-11 00:00:00','New','2008-12-10 00:00:00',NULL,'testing task','Medium',NULL,15,8,NULL,1,NULL);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;


--
-- Definition of table `task_comments`
--

DROP TABLE IF EXISTS `task_comments`;
CREATE TABLE `task_comments` (
  `id` int(11) NOT NULL,
  `_text` varchar(255) NOT NULL,
  `create_date` datetime NOT NULL,
  `task` int(11) NOT NULL,
  `create_user` int(11) default NULL,
  PRIMARY KEY  (`id`),
  CONSTRAINT `FK_task_comments_id` FOREIGN KEY (`id`) REFERENCES `task` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task_comments`
--

/*!40000 ALTER TABLE `task_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_comments` ENABLE KEYS */;


--
-- Definition of table `task_history`
--

DROP TABLE IF EXISTS `task_history`;
CREATE TABLE `task_history` (
  `id` int(11) NOT NULL,
  `_status` varchar(255) NOT NULL,
  `priority` varchar(255) NOT NULL,
  `description` varchar(255) default NULL,
  `sequence_number` double default NULL,
  `visibility` varchar(255) NOT NULL,
  `update_date` datetime default NULL,
  `title` varchar(255) NOT NULL,
  `percentage_completed` int(11) NOT NULL,
  `deadline` datetime default NULL,
  `task` int(11) default NULL,
  `update_user` int(11) default NULL,
  `assigned_to` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task_history`
--

/*!40000 ALTER TABLE `task_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_history` ENABLE KEYS */;


--
-- Definition of table `task_impedance`
--

DROP TABLE IF EXISTS `task_impedance`;
CREATE TABLE `task_impedance` (
  `id` int(11) NOT NULL,
  `resolved_date` datetime NOT NULL,
  `last_updated_user` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `_text` varchar(255) NOT NULL,
  `is_resolved` tinyint(1) NOT NULL default '0',
  `task` int(11) default NULL,
  `create_user` int(11) default NULL,
  `resolved_user` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task_impedance`
--

/*!40000 ALTER TABLE `task_impedance` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_impedance` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `password` varchar(145) NOT NULL,
  `is_encrypted` tinyint(1) unsigned default NULL,
  `enabled` tinyint(1) unsigned NOT NULL,
  `firstname` varchar(45) default NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) default NULL,
  `city` varchar(45) default NULL,
  `country` varchar(45) default NULL,
  `create_user` int(10) unsigned default NULL,
  `create_date` datetime NOT NULL,
  `is_administrator` tinyint(1) unsigned NOT NULL,
  `expiration_date` date default NULL,
  `last_update_user` varchar(45) default NULL,
  `organization` int(10) unsigned NOT NULL,
  `last_update_date` datetime NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `Index_3` (`username`),
  KEY `FK_users_organization` (`organization`),
  CONSTRAINT `FK_users_1` FOREIGN KEY (`organization`) REFERENCES `organization` (`id`),
  CONSTRAINT `FK_users_organization` FOREIGN KEY (`organization`) REFERENCES `organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`,`username`,`password`,`is_encrypted`,`enabled`,`firstname`,`lastname`,`email`,`city`,`country`,`create_user`,`create_date`,`is_administrator`,`expiration_date`,`last_update_user`,`organization`,`last_update_date`) VALUES 
 (5,'intesar.mohammed@bizintelapps.com','d0nad9J2DLgqygxEIUXR7xeDyNz5sjilQ9/poHNvLQKAoz68LUMZC4E3yLiZMh0L',1,1,'intesar','mohammed','intesar.mohammed@bizintelapps.com','hyderabad',NULL,NULL,'2008-11-26 23:14:33',1,NULL,'5',7,'2008-11-28 21:37:29'),
 (6,'fatimashanoor1','+T74qOMyBR0javCfiP8hkdydxXTy4oYYdL6u6oQMxXTW0OAqDShH84uULGXgxTBR',1,1,'shanoor','fatima','fatimashanoor1@gmail.com',NULL,NULL,5,'2008-11-28 22:03:35',1,NULL,'5',7,'2008-11-28 23:12:53'),
 (7,'xy','uKR0wQutHl2fNWsQmTRYODC2kMZHQwfreK6fMv6EwPfD5Xxp7IKrjiM5B03vNCr6',1,1,'x','y1','xy@xy.com',NULL,NULL,5,'2008-11-28 23:01:55',1,NULL,'5',7,'2008-11-29 20:02:43'),
 (8,'abc','WcTuEd9r9Tax79d8s/dLL8BPPuxIO17bamlATRdpwOY/d3FsiFgiSPnMJ/lNZxAp',1,1,'abc','abc','abc@gmail.com',NULL,NULL,5,'2008-11-29 20:03:09',0,NULL,'5',7,'2008-11-29 20:03:09'),
 (9,'abc1','B/eM0dPKgpsvhG8N0W55nLNPlQjdWJXHHChLlrwMu5MlUnq0y5bBKcUYUrCNcBud',1,1,'abc','abc','abc',NULL,NULL,5,'2008-11-29 20:08:04',1,NULL,'5',7,'2008-11-29 20:08:04'),
 (10,'kkk','GcQN+7q5TNmLycnnHXWEF+nLyM3IMaM1KElJ+caOlclQXjEmOXD4GLFh0X3Nn71q',1,1,'kkkk','kkk','kkk',NULL,NULL,5,'2008-11-29 20:08:42',1,NULL,'5',7,'2008-11-29 20:08:42'),
 (11,'m','3is2WEfxjE0ceKbzfBNBH2cc+XZW+anMBD0alWjQb2tB4l/xeDPyBB0z2fdYwUSh',1,1,'mmm','mm','m',NULL,NULL,5,'2008-11-29 20:12:35',0,NULL,'5',7,'2008-11-29 20:12:35'),
 (12,'lll','f/JOcfPtZr/xvPCnymwYBQ12LyA6UP1I7maX7ehTuzyM6hLCvwLtWG6XFtRNfDKb',1,1,'lll','lll','ll',NULL,NULL,5,'2008-11-29 20:23:27',1,NULL,'5',7,'2008-11-29 20:23:27'),
 (13,'jjj','9GyiQ2METG18dGvzsZwPnu983a4WHk4Qtz63MA06vTKaDuPxh2IjlydicJFhGCEz',1,1,'jjj','jjj','jj',NULL,NULL,5,'2008-11-29 20:25:46',1,NULL,'5',7,'2008-11-29 20:25:46'),
 (14,'i','yJxkRs9r9YVdOYy+aA8xHH4tqkjDi9ST0iMCo2+gSiBfxwkPX8w83ekzbdfnQx6k',1,1,'ii','ii','i',NULL,NULL,5,'2008-11-29 20:26:32',1,NULL,'5',7,'2008-11-29 20:26:32'),
 (15,'shannan.mohammed','t47r7C9kne725+yCiBSX/d8+I3r0tIWSsGSkXsupe3Qkn9xV6ZaIBJoFFwpzxmZG',1,1,'shannan','mohammed','shannan.mohammed@gmail.com','hyderabad',NULL,NULL,'2008-12-11 19:44:35',1,NULL,NULL,8,'2008-12-11 19:44:35'),
 (16,'mdshannan@gmail.com','PB5iXUgBhQnbXwd2s31cth0DlaeRlkyTvpawVHBNpBmJmNSyMsl1jJKUntBtJKby',1,1,'shannan','md','mdshannan@gmail.com','city',NULL,NULL,'2008-12-20 23:04:48',1,NULL,NULL,9,'2008-12-20 23:04:48'),
 (17,'irfan.mohammed@bizintelapps.com','vY+38+ih7DWPisS5Q84knmTZxdcM3clKFj5ncY28Ruq53qXZeYSxDj0KlwlMoMRI',1,1,'irfan','mohammed','irfan.mohammed@bizintelapps.com',NULL,NULL,15,'2008-12-21 00:02:39',0,NULL,'15',8,'2008-12-21 00:02:39');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
