-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.18-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema hris
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ hris;
USE hris;

--
-- Table structure for table `hris`.`account_detail`
--

DROP TABLE IF EXISTS `account_detail`;
CREATE TABLE `account_detail` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `header_id` int(10) unsigned NOT NULL default '0',
  `name_first` varchar(100) NOT NULL default '',
  `name_middle` varchar(100) NOT NULL default '',
  `name_last` varchar(100) NOT NULL default '',
  `gender` varchar(50) NOT NULL default '',
  `email` varchar(100) NOT NULL default '',
  `phone_1` varchar(50) NOT NULL default '',
  `phone_2` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`id`),
  KEY `FK_ACCT_HDR_ID` (`header_id`),
  CONSTRAINT `FK_ACCT_HDR_ID` FOREIGN KEY (`header_id`) REFERENCES `account_header` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB; (`header_id`) REFER `hris/account_data';

--
-- Dumping data for table `hris`.`account_detail`
--

/*!40000 ALTER TABLE `account_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_detail` ENABLE KEYS */;


--
-- Table structure for table `hris`.`account_header`
--

DROP TABLE IF EXISTS `account_header`;
CREATE TABLE `account_header` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(100) NOT NULL default '',
  `password` varchar(250) NOT NULL default '',
  `acct_type_id` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`id`),
  KEY `FK_ACCT_TYPE_ID` (`acct_type_id`),
  CONSTRAINT `FK_ACCT_TYPE_ID` FOREIGN KEY (`acct_type_id`) REFERENCES `account_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hris`.`account_header`
--

/*!40000 ALTER TABLE `account_header` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_header` ENABLE KEYS */;


--
-- Table structure for table `hris`.`account_type`
--

DROP TABLE IF EXISTS `account_type`;
CREATE TABLE `account_type` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `code` varchar(25) NOT NULL default '',
  `name` varchar(100) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hris`.`account_type`
--

/*!40000 ALTER TABLE `account_type` DISABLE KEYS */;
INSERT INTO `account_type` (`id`,`code`,`name`) VALUES 
 (0,'MASTR','Master Account'),
 (1,'ADMIN','Administrator'),
 (2,'USER','User Account'),
 (3,'GUEST','Guest');
/*!40000 ALTER TABLE `account_type` ENABLE KEYS */;


--
-- Table structure for table `hris`.`employee_detail`
--

DROP TABLE IF EXISTS `employee_detail`;
CREATE TABLE `employee_detail` (
  `header_id` int(10) unsigned NOT NULL auto_increment,
  `date_birth` datetime NOT NULL default '0000-00-00 00:00:00',
  `gender` varchar(25) NOT NULL default '',
  `address_1` varchar(150) NOT NULL default '',
  `address_2` varchar(150) NOT NULL default '',
  `email` varchar(100) NOT NULL default '',
  `civil_status` varchar(100) NOT NULL default '',
  `religion` varchar(100) NOT NULL default '',
  `nationality` varchar(100) NOT NULL default '',
  `phone_tele` int(10) unsigned NOT NULL default '0',
  `phone_cell` int(10) unsigned NOT NULL default '0',
  `phone_others` int(10) unsigned NOT NULL default '0',
  `code_GSIS` varchar(45) NOT NULL default '',
  `code_PAGIBIG` varchar(45) NOT NULL default '',
  `code_PHIC` varchar(45) NOT NULL default '',
  `code_SSS` varchar(45) NOT NULL default '',
  `code_TIN` varchar(45) NOT NULL default '',
  `dependents` longtext NOT NULL,
  `eligibility` longtext NOT NULL,
  `trainings` longtext NOT NULL,
  PRIMARY KEY  (`header_id`),
  CONSTRAINT `FK_employee_header_id` FOREIGN KEY (`header_id`) REFERENCES `employee_header` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hris`.`employee_detail`
--

/*!40000 ALTER TABLE `employee_detail` DISABLE KEYS */;
INSERT INTO `employee_detail` (`header_id`,`date_birth`,`gender`,`address_1`,`address_2`,`email`,`civil_status`,`religion`,`nationality`,`phone_tele`,`phone_cell`,`phone_others`,`code_GSIS`,`code_PAGIBIG`,`code_PHIC`,`code_SSS`,`code_TIN`,`dependents`,`eligibility`,`trainings`) VALUES 
 (1,'2015-01-01 00:00:00','','','','','','','',0,0,0,'','','','','','','','');
/*!40000 ALTER TABLE `employee_detail` ENABLE KEYS */;


--
-- Table structure for table `hris`.`employee_header`
--

DROP TABLE IF EXISTS `employee_header`;
CREATE TABLE `employee_header` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name_first` varchar(100) NOT NULL default '',
  `name_middle` varchar(100) NOT NULL default '',
  `name_last` varchar(100) NOT NULL default '',
  `plantilla_id` int(10) unsigned NOT NULL default '0',
  `emp_cat` varchar(50) NOT NULL default '',
  `emp_off` varchar(50) NOT NULL default '',
  `emp_pos` varchar(50) NOT NULL default '',
  `salary` int(10) unsigned NOT NULL default '0',
  `date_hired` datetime NOT NULL default '0000-00-00 00:00:00',
  `leave_used_sick` int(10) unsigned NOT NULL default '0',
  `leave_used_vac` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hris`.`employee_header`
--

/*!40000 ALTER TABLE `employee_header` DISABLE KEYS */;
INSERT INTO `employee_header` (`id`,`name_first`,`name_middle`,`name_last`,`plantilla_id`,`emp_cat`,`emp_off`,`emp_pos`,`salary`,`date_hired`,`leave_used_sick`,`leave_used_vac`) VALUES 
 (1,'Shaggy','Scooba','Doo',1234567890,'A','A','A',20000,'2013-01-01 00:00:00',0,0);
/*!40000 ALTER TABLE `employee_header` ENABLE KEYS */;


--
-- Table structure for table `hris`.`settings_list_category`
--

DROP TABLE IF EXISTS `settings_list_category`;
CREATE TABLE `settings_list_category` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(50) NOT NULL default '',
  `img_src` varchar(500) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hris`.`settings_list_category`
--

/*!40000 ALTER TABLE `settings_list_category` DISABLE KEYS */;
INSERT INTO `settings_list_category` (`id`,`name`,`img_src`) VALUES 
 (1,'Faculty',NULL),
 (2,'Staff',NULL),
 (3,'Job Order',NULL);
/*!40000 ALTER TABLE `settings_list_category` ENABLE KEYS */;


--
-- Table structure for table `hris`.`settings_list_eligibility`
--

DROP TABLE IF EXISTS `settings_list_eligibility`;
CREATE TABLE `settings_list_eligibility` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(50) NOT NULL default '',
  `img_src` varchar(500) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hris`.`settings_list_eligibility`
--

/*!40000 ALTER TABLE `settings_list_eligibility` DISABLE KEYS */;
INSERT INTO `settings_list_eligibility` (`id`,`name`,`img_src`) VALUES 
 (1,'Primary Eligibility',NULL),
 (2,'Secondary Eligibility',NULL),
 (3,'Tertiary Eligibility',NULL),
 (4,'Fourth Eligibility',NULL),
 (5,'Fifth Eligibility',NULL),
 (6,'Civil Service',NULL);
/*!40000 ALTER TABLE `settings_list_eligibility` ENABLE KEYS */;


--
-- Table structure for table `hris`.`settings_list_office`
--

DROP TABLE IF EXISTS `settings_list_office`;
CREATE TABLE `settings_list_office` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(50) NOT NULL default '',
  `img_src` varchar(500) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hris`.`settings_list_office`
--

/*!40000 ALTER TABLE `settings_list_office` DISABLE KEYS */;
INSERT INTO `settings_list_office` (`id`,`name`,`img_src`) VALUES 
 (1,'Office of the Campus Director',NULL),
 (2,'Finance and Administrative Division',NULL),
 (3,'Curriculum and Instructional Services Division',NULL),
 (4,'Student\'s Services Division',NULL);
/*!40000 ALTER TABLE `settings_list_office` ENABLE KEYS */;


--
-- Table structure for table `hris`.`settings_list_position`
--

DROP TABLE IF EXISTS `settings_list_position`;
CREATE TABLE `settings_list_position` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(50) NOT NULL default '',
  `img_src` varchar(500) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hris`.`settings_list_position`
--

/*!40000 ALTER TABLE `settings_list_position` DISABLE KEYS */;
INSERT INTO `settings_list_position` (`id`,`name`,`img_src`) VALUES 
 (1,'Accountant I',NULL),
 (2,'Accountant II',NULL),
 (3,'Accountant III',NULL),
 (5,'Administrative Aide',NULL),
 (11,'Programmer',NULL),
 (12,'IT Specialist',NULL);
/*!40000 ALTER TABLE `settings_list_position` ENABLE KEYS */;


--
-- Table structure for table `hris`.`settings_list_training`
--

DROP TABLE IF EXISTS `settings_list_training`;
CREATE TABLE `settings_list_training` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(50) NOT NULL default '',
  `img_src` varchar(500) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hris`.`settings_list_training`
--

/*!40000 ALTER TABLE `settings_list_training` DISABLE KEYS */;
INSERT INTO `settings_list_training` (`id`,`name`,`img_src`) VALUES 
 (1,'Primary Training',NULL),
 (2,'Secondary Training',NULL),
 (3,'Tertiary Training',NULL),
 (4,'Fourth Training',NULL),
 (5,'Fifth Training',NULL);
/*!40000 ALTER TABLE `settings_list_training` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
