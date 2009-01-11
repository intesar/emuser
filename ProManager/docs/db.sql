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
  `create_user` int(10) unsigned default NULL,
  `create_date` datetime default NULL,
  `vid` int(10) unsigned default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `Index_2` (`username`,`authority`),
  KEY `Index_3` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` (`username`,`authority`,`id`,`create_user`,`create_date`,`vid`) VALUES 
 ('intesar.mohammed','ROLE_USER',2,NULL,NULL,1),
 ('intesar.mohammed','ROLE_ADMIN',3,NULL,NULL,1),
 ('fatimashanoor1','ROLE_USER',5,NULL,NULL,1),
 ('xy','ROLE_USER',6,NULL,NULL,1),
 ('abc','ROLE_USER',10,NULL,NULL,1),
 ('kkk','ROLE_USER',13,NULL,NULL,1),
 ('kkk','ROLE_ADMIN',14,NULL,NULL,1),
 ('m','ROLE_USER',15,NULL,NULL,1),
 ('lll','ROLE_USER',16,NULL,NULL,1),
 ('lll','ROLE_ADMIN',17,NULL,NULL,1),
 ('irfan.mohammed@bizintelapps.com','ROLE_USER',26,NULL,NULL,1),
 ('info@bizintelapps.com','ROLE_USER',27,NULL,NULL,1),
 ('xy','ROLE_ADMIN',30,NULL,NULL,1),
 ('fatimashanoor1','ROLE_ADMIN',31,NULL,NULL,1),
 ('abc','ROLE_ADMIN',32,NULL,NULL,1),
 ('','ROLE_USER',33,NULL,NULL,1),
 ('intesar@ymail.com','ROLE_USER',40,NULL,NULL,1),
 ('intesar@ymail.com','ROLE_ADMIN',41,NULL,NULL,1);
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
  `vid` int(10) unsigned default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `Index_2` (`name`),
  KEY `Index_3` (`website_url`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `organization`
--

/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` (`id`,`name`,`website_url`,`create_user`,`create_ip`,`create_date`,`vid`) VALUES 
 (7,'bizintelapps',NULL,NULL,NULL,'2008-11-26 23:14:33',1),
 (8,'bizintelapps.com',NULL,NULL,NULL,'2008-12-11 19:44:35',1),
 (9,'mdshannan',NULL,NULL,NULL,'2008-12-20 23:04:48',1),
 (13,'bia',NULL,NULL,NULL,'2009-01-07 20:13:02',1);
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
  `vid` int(10) unsigned default NULL,
  `enabled` int(10) unsigned NOT NULL default '1',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `Index_3` (`name`,`organization`),
  KEY `FK_project_organization` (`organization`),
  KEY `Index_4` (`name`),
  CONSTRAINT `FK_project_1` FOREIGN KEY (`organization`) REFERENCES `organization` (`id`),
  CONSTRAINT `FK_project_organization` FOREIGN KEY (`organization`) REFERENCES `organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project`
--

/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` (`id`,`name`,`description`,`_status`,`create_user`,`create_date`,`visibility`,`parent_project`,`organization`,`last_update_user`,`last_update_date`,`estimated_hours`,`hourly_rate`,`estimated_cost`,`notification_emails`,`vid`,`enabled`) VALUES 
 (2,'OurUmmah','Muslim Social Networking. alksjdflaks','Completed','5','2008-11-29 23:45:52',NULL,NULL,8,15,'2008-12-26 22:39:54',0,0,0,NULL,1,1),
 (10,'OurUmmah10',NULL,'In Progess','5','2008-11-29 23:45:52','',NULL,8,7,'2008-12-31 19:39:16',0,0,0,NULL,1,1),
 (12,'OurUmmah12','Muslim Social Networking','In Progess','5','2008-11-29 23:45:52','',NULL,8,5,'2008-11-29 00:00:00',0,0,0,NULL,1,1),
 (14,'test-project1',NULL,'In Progress','15','2008-12-13 19:34:14',NULL,NULL,8,15,'2008-12-13 19:34:14',0,0,0,NULL,1,1),
 (15,'urooj',NULL,'In Progress','15','2008-12-19 22:11:49',NULL,NULL,8,15,'2008-12-19 22:11:49',0,0,0,NULL,1,1),
 (16,'ittefaaq','','Completed','15','2008-12-19 22:12:10',NULL,NULL,8,15,'2008-12-20 14:56:11',0,0,0,NULL,1,1),
 (18,'hello-brother',NULL,'In Progress','15','2008-12-25 19:07:38',NULL,NULL,8,15,'2008-12-25 19:07:38',0,0,0,'0.0',1,1),
 (19,'faceguard1','lkjlkjasdf','In Progess','15','2008-12-26 22:26:10',NULL,NULL,8,15,'2008-12-26 22:26:39',0,0,0,'0.0',1,1),
 (20,'faceguard2',NULL,'In Progress','15','2008-12-26 22:38:57',NULL,NULL,8,15,'2008-12-26 22:38:57',0,0,0,'0.0',1,1),
 (21,'demo',NULL,'In Progess','7','2008-12-31 19:51:48',NULL,NULL,8,7,'2008-12-31 19:51:48',0,0,0,'0.0',1,1),
 (22,'project1',NULL,'In Progess','21','2009-01-07 21:33:13',NULL,NULL,13,21,'2009-01-07 21:33:13',0,0,0,'0.0',1,1);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;


--
-- Definition of table `project_report`
--

DROP TABLE IF EXISTS `project_report`;
CREATE TABLE `project_report` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `project` int(10) unsigned default NULL,
  `task_created` int(10) unsigned NOT NULL default '0',
  `task_finished` int(10) unsigned default '0',
  `estimated_time` double unsigned default '0',
  `time_spend` double unsigned default '0',
  `month` int(10) unsigned NOT NULL,
  `year` int(10) unsigned NOT NULL,
  `organization` int(10) unsigned default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `Index_2` (`project`,`month`,`year`),
  KEY `Index_3` (`task_finished`),
  KEY `Index_4` (`task_created`),
  KEY `Index_5` (`time_spend`),
  KEY `Index_6` (`estimated_time`),
  KEY `FK_project_report_2` (`organization`),
  CONSTRAINT `FK_project_report_1` FOREIGN KEY (`project`) REFERENCES `project` (`id`),
  CONSTRAINT `FK_project_report_2` FOREIGN KEY (`organization`) REFERENCES `organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project_report`
--

/*!40000 ALTER TABLE `project_report` DISABLE KEYS */;
INSERT INTO `project_report` (`id`,`project`,`task_created`,`task_finished`,`estimated_time`,`time_spend`,`month`,`year`,`organization`) VALUES 
 (10,14,40,39,40,60,10,2008,8),
 (11,14,70,70,210,230,11,2008,8),
 (12,NULL,22,8,25,118,0,2009,8),
 (13,14,2,0,0,0,0,2009,NULL),
 (16,NULL,7,0,15,0,0,2009,13);
/*!40000 ALTER TABLE `project_report` ENABLE KEYS */;


--
-- Definition of table `project_users`
--

DROP TABLE IF EXISTS `project_users`;
CREATE TABLE `project_users` (
  `id` int(11) NOT NULL auto_increment,
  `is_enabled` tinyint(1) default '0',
  `expiration_date` datetime default NULL,
  `is_manager` tinyint(1) unsigned NOT NULL default '0',
  `create_date` datetime default NULL,
  `project` int(11) NOT NULL,
  `create_user` int(11) default NULL,
  `users` int(11) NOT NULL,
  `vid` int(10) unsigned default NULL,
  PRIMARY KEY  (`id`),
  KEY `Index_2` (`project`,`users`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project_users`
--

/*!40000 ALTER TABLE `project_users` DISABLE KEYS */;
INSERT INTO `project_users` (`id`,`is_enabled`,`expiration_date`,`is_manager`,`create_date`,`project`,`create_user`,`users`,`vid`) VALUES 
 (2,1,NULL,1,'2008-12-31 22:26:49',21,7,7,1),
 (3,1,NULL,1,'2009-01-07 21:33:35',22,21,21,1);
/*!40000 ALTER TABLE `project_users` ENABLE KEYS */;


--
-- Definition of table `task`
--

DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int(11) NOT NULL auto_increment,
  `parent_task` int(11) default NULL,
  `sequence_number` double default NULL,
  `title` varchar(105) NOT NULL default 'na',
  `context` varchar(45) default NULL,
  `deadline` datetime default NULL,
  `completed_date` datetime default NULL,
  `visibility` varchar(45) default NULL,
  `last_status_changed_date` datetime default NULL,
  `_status` varchar(45) NOT NULL default 'New',
  `create_date` datetime NOT NULL,
  `percentage_completed` int(11) default NULL,
  `description` varchar(255) default NULL,
  `priority` varchar(45) NOT NULL default 'Medium',
  `project` int(11) default NULL,
  `owner` int(11) NOT NULL,
  `assigned_to` int(11) default NULL,
  `estimated_hours` double default NULL,
  `spend_hours` double default '1',
  `notification_emails` varchar(255) default NULL,
  `assigned_date` date default NULL,
  `vid` int(10) unsigned default NULL,
  `assigned_by` int(10) unsigned default NULL,
  PRIMARY KEY  (`id`),
  KEY `Index_2` (`title`),
  KEY `Index_3` (`deadline`),
  KEY `Index_4` (`completed_date`),
  KEY `Index_5` (`_status`),
  KEY `Index_6` (`create_date`),
  KEY `Index_7` (`priority`),
  KEY `Index_8` (`notification_emails`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task`
--

/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` (`id`,`parent_task`,`sequence_number`,`title`,`context`,`deadline`,`completed_date`,`visibility`,`last_status_changed_date`,`_status`,`create_date`,`percentage_completed`,`description`,`priority`,`project`,`owner`,`assigned_to`,`estimated_hours`,`spend_hours`,`notification_emails`,`assigned_date`,`vid`,`assigned_by`) VALUES 
 (29,NULL,NULL,'task1',NULL,NULL,NULL,NULL,'2009-01-04 16:22:44','Completed','2009-01-04 13:04:39',0,'','Medium',NULL,7,NULL,2,2,'',NULL,3,NULL),
 (30,NULL,NULL,'task2',NULL,NULL,NULL,NULL,'2009-01-04 16:19:51','Completed','2009-01-04 13:05:03',0,'','Medium',NULL,7,NULL,2,2,'',NULL,2,NULL),
 (31,NULL,NULL,'task 3',NULL,NULL,NULL,NULL,'2009-01-04 16:20:45','Completed','2009-01-04 13:05:42',0,'','Medium',NULL,7,NULL,2,0,'',NULL,2,NULL),
 (32,NULL,NULL,'task 4',NULL,NULL,NULL,NULL,'2009-01-04 13:06:04','New','2009-01-04 13:06:04',0,'','Medium',NULL,7,5,0,0,'','2009-01-04',1,7),
 (33,NULL,NULL,'task 5',NULL,NULL,NULL,NULL,'2009-01-04 13:06:40','New','2009-01-04 13:06:40',0,'','Medium',NULL,7,5,2,0,'','2009-01-04',1,7),
 (34,NULL,NULL,'task 6',NULL,NULL,NULL,NULL,'2009-01-04 16:25:08','Completed','2009-01-04 13:07:25',0,'','Medium',NULL,7,7,1,0,'','2009-01-04',4,7),
 (35,NULL,NULL,'task 7',NULL,NULL,NULL,NULL,'2009-01-04 16:27:11','Completed','2009-01-04 13:09:34',0,'','Medium',NULL,7,7,4,10,'','2009-01-04',3,7),
 (36,NULL,NULL,'',NULL,NULL,NULL,NULL,'2009-01-04 13:13:17','Completed','2009-01-04 13:10:42',0,'','Medium',NULL,7,7,2,2,'','2009-01-04',3,7),
 (37,NULL,NULL,'task 8',NULL,NULL,NULL,NULL,'2009-01-04 13:11:49','Completed','2009-01-04 13:11:49',0,'','Medium',NULL,7,7,2,2,'','2009-01-04',1,7),
 (38,NULL,NULL,'hello testing and playing with creating task and assign to o',NULL,NULL,NULL,NULL,'2009-01-04 19:35:35','New','2009-01-04 13:40:28',0,'','Medium',NULL,7,7,1,50,'','2009-01-04',3,7),
 (39,NULL,NULL,'hello testing and playing with creating task and assign to o',NULL,NULL,NULL,NULL,'2009-01-04 18:57:01','New','2009-01-04 13:40:34',0,'','Medium',NULL,7,7,10,0,'','2009-01-04',3,7),
 (40,NULL,NULL,'hello testing and playing with creating task and assign to o',NULL,NULL,NULL,NULL,'2009-01-04 19:36:24','Completed','2009-01-04 13:40:39',0,'','Medium',NULL,7,7,10,100,'','2009-01-04',5,7),
 (41,NULL,NULL,'hello testing and playing with creating task and assign to o',NULL,NULL,NULL,NULL,'2009-01-04 13:40:45','New','2009-01-04 13:40:45',0,'','Medium',NULL,7,NULL,0,0,'',NULL,1,NULL),
 (42,NULL,NULL,'hello testing and playing with creating task and assign to o',NULL,NULL,NULL,NULL,'2009-01-04 13:40:52','New','2009-01-04 13:40:52',0,'','Medium',NULL,7,NULL,0,0,'',NULL,1,NULL),
 (43,NULL,NULL,'hello testing and playing with creating task and assign to o',NULL,NULL,NULL,NULL,'2009-01-04 13:40:58','New','2009-01-04 13:40:58',0,'','Medium',NULL,7,NULL,0,0,'',NULL,1,NULL),
 (44,NULL,NULL,'hello testing and playing with creating task and assign to o',NULL,NULL,NULL,NULL,'2009-01-04 13:41:02','New','2009-01-04 13:41:02',0,'','Medium',NULL,7,NULL,0,0,'',NULL,1,NULL),
 (45,NULL,NULL,'hello testing and playing with creating task and assign to o',NULL,NULL,NULL,NULL,'2009-01-04 13:41:14','New','2009-01-04 13:41:14',0,'','Medium',NULL,7,NULL,0,0,'',NULL,1,NULL),
 (46,NULL,NULL,'hello testing and playing with creating task and assign to o',NULL,NULL,NULL,NULL,'2009-01-04 13:41:18','New','2009-01-04 13:41:18',0,'','Medium',NULL,7,NULL,0,0,'',NULL,1,NULL),
 (47,NULL,NULL,'hello testing and playing with creating task and assign to o',NULL,NULL,NULL,NULL,'2009-01-04 13:41:27','New','2009-01-04 13:41:27',0,'','Medium',NULL,7,NULL,0,0,'',NULL,1,NULL),
 (48,NULL,NULL,'hello testing and playing with creating task and assign to o',NULL,NULL,NULL,NULL,'2009-01-04 13:41:32','New','2009-01-04 13:41:32',0,'','Medium',NULL,7,NULL,0,0,'',NULL,1,NULL),
 (49,NULL,NULL,'hello testing and playing with creating task and assign to o',NULL,NULL,NULL,NULL,'2009-01-04 13:41:36','New','2009-01-04 13:41:36',0,'','Medium',NULL,7,NULL,0,0,'',NULL,1,NULL),
 (50,NULL,NULL,'hello testing and playing with creating task and assign to o',NULL,NULL,NULL,NULL,'2009-01-04 13:41:41','New','2009-01-04 13:41:41',0,'','Medium',NULL,7,NULL,0,0,'',NULL,1,NULL),
 (51,NULL,NULL,'demo',NULL,NULL,NULL,NULL,'2009-01-04 18:57:55','New','2009-01-04 18:57:55',0,'','Medium',NULL,7,7,10,0,'','2009-01-04',1,7),
 (53,NULL,NULL,'check email',NULL,NULL,NULL,NULL,'2009-01-07 21:01:29','New','2009-01-07 21:01:29',0,'check email','Medium',NULL,7,NULL,1,0,'',NULL,1,NULL),
 (54,NULL,NULL,'check email',NULL,NULL,NULL,NULL,'2009-01-07 21:02:16','New','2009-01-07 21:02:16',0,'check email','Medium',NULL,21,NULL,2,0,'',NULL,1,NULL),
 (56,NULL,NULL,'second demo',NULL,NULL,NULL,NULL,'2009-01-07 21:07:34','New','2009-01-07 21:07:34',0,'demo','Medium',NULL,21,NULL,2,0,'',NULL,1,NULL),
 (57,NULL,NULL,'testin',NULL,NULL,NULL,NULL,'2009-01-07 21:11:12','New','2009-01-07 21:11:12',0,'lk','Medium',NULL,21,NULL,2,0,'',NULL,1,NULL),
 (58,NULL,NULL,'demo',NULL,NULL,NULL,NULL,'2009-01-07 21:13:23','New','2009-01-07 21:13:23',0,'demo','Medium',NULL,21,NULL,3,0,'',NULL,1,NULL),
 (59,NULL,NULL,'dm',NULL,NULL,NULL,NULL,'2009-01-07 21:18:04','New','2009-01-07 21:18:04',0,'lk','Medium',NULL,21,NULL,2,0,'',NULL,1,NULL),
 (60,NULL,NULL,'demo',NULL,NULL,NULL,NULL,'2009-01-07 21:25:17','New','2009-01-07 21:25:17',0,'','Medium',NULL,21,NULL,2,0,'',NULL,1,NULL),
 (61,NULL,NULL,'demo',NULL,NULL,NULL,NULL,'2009-01-07 21:30:03','New','2009-01-07 21:30:03',0,'','Medium',NULL,21,NULL,2,0,'',NULL,1,NULL);
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
-- Definition of table `user_report`
--

DROP TABLE IF EXISTS `user_report`;
CREATE TABLE `user_report` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `user` int(10) unsigned NOT NULL,
  `month` int(10) unsigned NOT NULL,
  `year` int(10) unsigned NOT NULL,
  `total_created` int(10) unsigned default '0',
  `assigned` int(10) unsigned default '0',
  `self_assigned` int(10) unsigned default '0',
  `total_assigned` int(10) unsigned default '0',
  `estimated_hours` double unsigned default '0',
  `hours_spend` double unsigned default '0',
  `total_completed` int(10) unsigned NOT NULL default '0',
  `created_self_assigned` int(10) unsigned default '0',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `Index_3` (`user`,`month`,`year`),
  KEY `Index_4` (`assigned`),
  KEY `Index_5` (`total_completed`),
  KEY `Index_6` (`hours_spend`),
  CONSTRAINT `FK_user_report_1` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_report`
--

/*!40000 ALTER TABLE `user_report` DISABLE KEYS */;
INSERT INTO `user_report` (`id`,`user`,`month`,`year`,`total_created`,`assigned`,`self_assigned`,`total_assigned`,`estimated_hours`,`hours_spend`,`total_completed`,`created_self_assigned`) VALUES 
 (10,7,9,2008,50,50,10,60,180,160,100,0),
 (11,7,10,2008,40,20,20,40,200,190,40,5),
 (12,7,11,2008,50,10,7,7,190,200,25,10),
 (13,7,0,2009,24,0,0,7,31,118,8,7),
 (14,5,0,2009,0,2,0,2,2,0,0,0),
 (15,6,0,2009,0,1,0,1,2,0,0,0),
 (16,21,0,2009,7,0,0,0,0,0,0,0);
/*!40000 ALTER TABLE `user_report` ENABLE KEYS */;


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
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `city` varchar(45) default NULL,
  `country` varchar(45) default NULL,
  `create_user` int(10) unsigned default NULL,
  `create_date` datetime NOT NULL,
  `is_administrator` tinyint(1) unsigned NOT NULL default '0',
  `expiration_date` date default NULL,
  `last_update_user` varchar(45) default NULL,
  `organization` int(10) unsigned NOT NULL,
  `last_update_date` datetime default NULL,
  `vid` int(10) unsigned default NULL,
  `is_super` tinyint(1) unsigned default '0',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `Index_3` (`username`),
  UNIQUE KEY `Index_4` (`email`),
  KEY `FK_users_organization` (`organization`),
  KEY `Index_5` (`firstname`),
  KEY `Index_6` (`lastname`),
  KEY `Index_7` (`firstname`,`lastname`),
  KEY `Index_8` (`city`),
  KEY `Index_9` (`country`),
  CONSTRAINT `FK_users_1` FOREIGN KEY (`organization`) REFERENCES `organization` (`id`),
  CONSTRAINT `FK_users_organization` FOREIGN KEY (`organization`) REFERENCES `organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`,`username`,`password`,`is_encrypted`,`enabled`,`firstname`,`lastname`,`email`,`city`,`country`,`create_user`,`create_date`,`is_administrator`,`expiration_date`,`last_update_user`,`organization`,`last_update_date`,`vid`,`is_super`) VALUES 
 (5,'intesar.mohammed@bizintelapps.com','d0nad9J2DLgqygxEIUXR7xeDyNz5sjilQ9/poHNvLQKAoz68LUMZC4E3yLiZMh0L',1,1,'intesar','mohammed','intesar.mohammed@bizintelapps.com','hyderabad',NULL,NULL,'2008-11-26 23:14:33',1,NULL,'5',8,'2008-11-28 21:37:29',1,0),
 (6,'fatimashanoor1','+T74qOMyBR0javCfiP8hkdydxXTy4oYYdL6u6oQMxXTW0OAqDShH84uULGXgxTBR',1,1,'shanoor','fatima','fatimashanoor1@gmail.com',NULL,NULL,5,'2008-11-28 22:03:35',1,NULL,'7',8,'2008-12-30 23:43:00',1,0),
 (7,'xy','uKR0wQutHl2fNWsQmTRYODC2kMZHQwfreK6fMv6EwPfD5Xxp7IKrjiM5B03vNCr6',1,1,'x','y1','xy@xy.com',NULL,NULL,5,'2008-11-28 23:01:55',1,NULL,'7',8,'2008-12-30 23:19:21',1,0),
 (16,'mdshannan@gmail.com','B2qK1PvYqWVfVL9kWKsgPOePm9n1jCKRrtvuL9SZ1TCu2SMPH646CY1qmmMcr8vP',1,1,'shannan','md','mdshannan@gmail.com','city',NULL,NULL,'2008-12-20 23:04:48',1,NULL,NULL,9,'2008-12-20 23:04:48',1,0),
 (21,'intesar@ymail.com','FvYL0HSdAezv/8s1fs96m3T3pzlW5CHdwlPf3ocNq4FHh0U7kEhZJC9c4hX53CNO',1,1,'intesar','mohammed','intesar@ymail.com',NULL,NULL,NULL,'2009-01-07 20:13:02',1,NULL,NULL,13,'2009-01-07 20:13:02',2,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
