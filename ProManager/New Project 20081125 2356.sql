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
  PRIMARY KEY  (`username`,`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` (`username`,`authority`) VALUES 
 ('intesar','ROLE_ADMIN');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `organization`
--

/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` (`id`,`name`,`website_url`,`create_user`,`create_ip`,`create_date`) VALUES 
 (1,'bizintelapps',NULL,NULL,NULL,'2008-10-10 00:00:00');
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;


--
-- Definition of table `project`
--

DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) default NULL,
  `_status` varchar(45) NOT NULL default '',
  `create_user` varchar(45) NOT NULL,
  `create_date` datetime NOT NULL,
  `visibility` varchar(45) NOT NULL,
  `parent_project` int(10) unsigned default NULL,
  `organization` int(10) unsigned NOT NULL,
  `last_update_user` int(10) unsigned default NULL,
  `last_update_date` datetime default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_project_organization` (`organization`),
  CONSTRAINT `FK_project_1` FOREIGN KEY (`organization`) REFERENCES `organization` (`id`),
  CONSTRAINT `FK_project_organization` FOREIGN KEY (`organization`) REFERENCES `organization` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project`
--

/*!40000 ALTER TABLE `project` DISABLE KEYS */;
/*!40000 ALTER TABLE `project` ENABLE KEYS */;


--
-- Definition of table `project_users`
--

DROP TABLE IF EXISTS `project_users`;
CREATE TABLE `project_users` (
  `id` int(11) NOT NULL,
  `is_enabled` tinyint(1) NOT NULL default '0',
  `expiration_date` datetime default NULL,
  `_role` varchar(255) NOT NULL,
  `create_date` datetime NOT NULL,
  `project` int(11) default NULL,
  `create_user` int(11) default NULL,
  `users` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project_users`
--

/*!40000 ALTER TABLE `project_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_users` ENABLE KEYS */;


--
-- Definition of table `task`
--

DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int(11) NOT NULL,
  `parent_task` int(11) default NULL,
  `sequence_number` double default NULL,
  `title` varchar(255) NOT NULL,
  `context` varchar(255) default NULL,
  `deadline` datetime default NULL,
  `completed_date` datetime default NULL,
  `visibility` varchar(255) NOT NULL,
  `last_status_changed_date` datetime default NULL,
  `_status` varchar(255) NOT NULL,
  `create_date` datetime NOT NULL,
  `percentage_completed` int(11) NOT NULL,
  `description` varchar(255) default NULL,
  `priority` varchar(255) NOT NULL,
  `project` int(11) default NULL,
  `owner` int(11) default NULL,
  `assigned_to` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task`
--

/*!40000 ALTER TABLE `task` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`,`username`,`password`,`is_encrypted`,`enabled`,`firstname`,`lastname`,`email`,`city`,`country`,`create_user`,`create_date`,`is_administrator`,`expiration_date`,`last_update_user`,`organization`,`last_update_date`) VALUES 
 (1,'intesar','shannan',0,1,'intesar','mohammed','intesar.mohammed@bizintelapps.com','hyderabad','india',NULL,'2008-11-25 00:00:00',0,NULL,NULL,1,'2008-11-11 00:00:00');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
