-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.21-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for codeplay
DROP DATABASE IF EXISTS `codeplay`;
CREATE DATABASE IF NOT EXISTS `codeplay` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `codeplay`;

-- Dumping structure for table codeplay.auto_sequence
DROP TABLE IF EXISTS `auto_sequence`;
CREATE TABLE IF NOT EXISTS `auto_sequence` (
  `sequence_name` char(255) NOT NULL,
  `init_val` bigint(20) NOT NULL,
  `next_val` bigint(20) NOT NULL,
  `increment_factor` int(11) DEFAULT '1',
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table codeplay.auto_sequence: ~0 rows (approximately)
/*!40000 ALTER TABLE `auto_sequence` DISABLE KEYS */;
INSERT INTO `auto_sequence` (`sequence_name`, `init_val`, `next_val`, `increment_factor`) VALUES
	('prime_seq', 1, 1, 1);
/*!40000 ALTER TABLE `auto_sequence` ENABLE KEYS */;

-- Dumping structure for table codeplay.contact_query
DROP TABLE IF EXISTS `contact_query`;
CREATE TABLE IF NOT EXISTS `contact_query` (
  `query_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contact_email_address` varchar(255) DEFAULT NULL,
  `contact_name` varchar(255) DEFAULT NULL,
  `query_subject` varchar(255) DEFAULT NULL,
  `query_txt` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `user_type_cd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`query_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table codeplay.contact_query: ~0 rows (approximately)
/*!40000 ALTER TABLE `contact_query` DISABLE KEYS */;
INSERT INTO `contact_query` (`query_id`, `contact_email_address`, `contact_name`, `query_subject`, `query_txt`, `user_id`, `user_type_cd`) VALUES
	(1, 'shramdc@gmail.com', 'Ram Sharma', 'hello', 'I want to connect', NULL, NULL);
/*!40000 ALTER TABLE `contact_query` ENABLE KEYS */;

-- Dumping structure for table codeplay.guest_user_info
DROP TABLE IF EXISTS `guest_user_info`;
CREATE TABLE IF NOT EXISTS `guest_user_info` (
  `user_id` bigint(20) NOT NULL,
  `user_type_cd` char(10) NOT NULL DEFAULT 'GUEST',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table codeplay.guest_user_info: ~0 rows (approximately)
/*!40000 ALTER TABLE `guest_user_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `guest_user_info` ENABLE KEYS */;

-- Dumping structure for table codeplay.login_tracker
DROP TABLE IF EXISTS `login_tracker`;
CREATE TABLE IF NOT EXISTS `login_tracker` (
  `login_tracker_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `login_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `logout_time` datetime DEFAULT NULL,
  PRIMARY KEY (`login_tracker_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table codeplay.login_tracker: ~0 rows (approximately)
/*!40000 ALTER TABLE `login_tracker` DISABLE KEYS */;
/*!40000 ALTER TABLE `login_tracker` ENABLE KEYS */;

-- Dumping structure for table codeplay.registered_user_info
DROP TABLE IF EXISTS `registered_user_info`;
CREATE TABLE IF NOT EXISTS `registered_user_info` (
  `user_id` bigint(20) NOT NULL,
  `user_type_cd` char(10) NOT NULL DEFAULT 'REG',
  `user_first_name` char(255) NOT NULL,
  `user_middle_name` char(255) DEFAULT NULL,
  `user_last_name` char(255) DEFAULT NULL,
  `user_email_address` char(255) DEFAULT NULL,
  `user_phone_number` char(255) DEFAULT NULL,
  `user_registeration_date` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table codeplay.registered_user_info: ~0 rows (approximately)
/*!40000 ALTER TABLE `registered_user_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `registered_user_info` ENABLE KEYS */;

-- Dumping structure for table codeplay.social_poll
DROP TABLE IF EXISTS `social_poll`;
CREATE TABLE IF NOT EXISTS `social_poll` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `closed_on_dt` datetime DEFAULT NULL,
  `created_on_dt` datetime DEFAULT NULL,
  `edit_by_user_id` varchar(255) DEFAULT NULL,
  `edited_on_dt` datetime DEFAULT NULL,
  `status_now` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `submit_by_user_id` varchar(255) DEFAULT NULL,
  `submitted_on_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5029 DEFAULT CHARSET=utf8;

-- Dumping data for table codeplay.social_poll: ~26 rows (approximately)
/*!40000 ALTER TABLE `social_poll` DISABLE KEYS */;
INSERT INTO `social_poll` (`id`, `closed_on_dt`, `created_on_dt`, `edit_by_user_id`, `edited_on_dt`, `status_now`, `subject`, `submit_by_user_id`, `submitted_on_dt`) VALUES
	(5003, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'Should the Human Being step up!', '30001', '2017-03-06 23:08:14'),
	(5004, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'Will this war stop!', '30001', '2017-03-06 23:08:14'),
	(5005, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'Should Trumt step down!', '30001', '2017-03-06 23:08:14'),
	(5006, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'Would there be Destruction again!', '30001', '2017-03-06 23:08:14'),
	(5007, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'Is Gay marriage legal!', '30001', '2017-03-06 23:08:14'),
	(5008, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'What should be the life!', '30001', '2017-03-06 23:08:14'),
	(5009, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'Now and Then!', '30001', '2017-03-06 23:08:14'),
	(5010, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'Are there perfect human beings!', '30001', '2017-03-06 23:08:14'),
	(5011, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'Is LOve true!', '30001', '2017-03-06 23:08:14'),
	(5012, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'Why Mind takes over your fear!', '30001', '2017-03-06 23:08:14'),
	(5013, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'What should be the life!', '30001', '2017-03-06 23:08:14'),
	(5014, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'What should be the life!', '30001', '2017-03-06 23:08:14'),
	(5015, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'What should be the life!', '30001', '2017-03-06 23:08:14'),
	(5016, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'What should be the life!', '30001', '2017-03-06 23:08:14'),
	(5017, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'What should be the life!', '30001', '2017-03-06 23:08:14'),
	(5018, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'What should be the life!', '30001', '2017-03-06 23:08:14'),
	(5019, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'What should be the life!', '30001', '2017-03-06 23:08:14'),
	(5020, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'What should be the life!', '30001', '2017-03-06 23:08:14'),
	(5021, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'What should be the life!', '30001', '2017-03-06 23:08:14'),
	(5022, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'What should be the life!', '30001', '2017-03-06 23:08:14'),
	(5023, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'What should be the life!', '30001', '2017-03-06 23:08:14'),
	(5024, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'What should be the life!', '30001', '2017-03-06 23:08:14'),
	(5025, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'What should be the life!', '30001', '2017-03-06 23:08:14'),
	(5026, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'What should be the life!', '30001', '2017-03-06 23:08:14'),
	(5027, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'What should be the life!', '30001', '2017-03-06 23:08:14'),
	(5028, '2017-03-06 23:08:14', '2017-03-06 23:08:14', '30001', '2017-03-06 23:08:14', 'ALIVE', 'What should be the life!', '30001', '2017-03-06 23:08:14');
/*!40000 ALTER TABLE `social_poll` ENABLE KEYS */;

-- Dumping structure for table codeplay.social_poll_option
DROP TABLE IF EXISTS `social_poll_option`;
CREATE TABLE IF NOT EXISTS `social_poll_option` (
  `id` char(255) NOT NULL,
  `social_poll_id` char(255) DEFAULT NULL,
  `option_txt` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table codeplay.social_poll_option: ~12 rows (approximately)
/*!40000 ALTER TABLE `social_poll_option` DISABLE KEYS */;
INSERT INTO `social_poll_option` (`id`, `social_poll_id`, `option_txt`) VALUES
	('300010', '5006', 'Yes'),
	('300011', '5006', 'NO'),
	('300012', '5007', 'YES'),
	('300013', '5007', 'NO'),
	('300014', '5008', 'Yes'),
	('300015', '5008', 'NO'),
	('300016', '5009', 'YES'),
	('300017', '5009', 'NO'),
	('300018', '5010', 'Yes'),
	('300019', '5010', 'NO'),
	('300020', '5011', 'YES'),
	('300021', '5011', 'NO');
/*!40000 ALTER TABLE `social_poll_option` ENABLE KEYS */;

-- Dumping structure for table codeplay.social_poll_response
DROP TABLE IF EXISTS `social_poll_response`;
CREATE TABLE IF NOT EXISTS `social_poll_response` (
  `id` char(255) NOT NULL,
  `social_poll_id` char(255) DEFAULT NULL,
  `social_poll_option_id` char(255) DEFAULT NULL,
  `response_by_user_id` char(255) DEFAULT NULL,
  `response_on_dt` datetime DEFAULT NULL,
  `response_edit_on_dt` datetime DEFAULT NULL,
  `response_withdraw_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table codeplay.social_poll_response: ~21 rows (approximately)
/*!40000 ALTER TABLE `social_poll_response` DISABLE KEYS */;
INSERT INTO `social_poll_response` (`id`, `social_poll_id`, `social_poll_option_id`, `response_by_user_id`, `response_on_dt`, `response_edit_on_dt`, `response_withdraw_dt`) VALUES
	('200001', '5006', '300010', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200002', '5006', '300010', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200003', '5006', '300010', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200004', '5006', '300010', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200005', '5006', '300010', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200006', '5006', '300010', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200007', '5006', '300010', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200008', '5006', '300010', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200009', '5006', '300010', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200010', '5006', '300010', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200011', '5006', '300011', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200012', '5006', '300011', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200013', '5006', '300011', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200014', '5006', '300011', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200015', '5006', '300011', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200016', '5006', '300011', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200017', '5006', '300011', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200018', '5006', '300011', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200019', '5006', '300011', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200020', '5006', '300011', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29'),
	('200021', '5006', '300010', '30001', '2017-03-06 23:28:29', '2017-03-06 23:28:29', '2017-03-06 23:28:29');
/*!40000 ALTER TABLE `social_poll_response` ENABLE KEYS */;

-- Dumping structure for table codeplay.user_info
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE IF NOT EXISTS `user_info` (
  `id` char(255) NOT NULL,
  `name` char(255) DEFAULT NULL,
  `email` char(255) DEFAULT NULL,
  `passwd` char(255) DEFAULT NULL,
  `phone` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table codeplay.user_info: ~10 rows (approximately)
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`id`, `name`, `email`, `passwd`, `phone`) VALUES
	('40009', 'test_user_1', 'testuser1@test.com', 'root', '8096745368'),
	('40010', 'test_user_2', 'testuser2@test.com', 'root', '8043245368'),
	('40011', 'test_user_3', 'testuser3@test.com', 'root', '8023145368'),
	('40012', 'test_user_4', 'testuser4@test.com', 'root', '8564645368'),
	('40013', 'test_user_5', 'testuser5@test.com', 'root', '3432445368'),
	('40014', 'test_user_6', 'testuser6@test.com', 'root', '8093432432'),
	('40015', 'test_user_7', 'testuser7@test.com', 'root', '8093423432'),
	('40016', 'test_user_8', 'testuser8@test.com', 'root', '8096744234'),
	('40017', 'test_user_9', 'testuser9@test.com', 'root', '8096745654'),
	('40018', 'test_user_10', 'testuser10@test.com', 'root', '8096744534');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
