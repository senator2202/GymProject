-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               8.0.21 - MySQL Community Server - GPL
-- Операционная система:         Win64
-- HeidiSQL Версия:              11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных gym
DROP DATABASE IF EXISTS `gym`;
CREATE DATABASE IF NOT EXISTS `gym` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gym`;

-- Дамп структуры для таблица gym.accounts
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE IF NOT EXISTS `accounts` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `login` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `email` varchar(50) NOT NULL,
  `role` enum('ADMIN','TRAINER','CLIENT') NOT NULL DEFAULT 'CLIENT',
  `registration_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`account_id`) USING BTREE,
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `id` (`account_id`) USING BTREE,
  UNIQUE KEY `name` (`login`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=284 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.accounts: ~5 rows (приблизительно)
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
REPLACE INTO `accounts` (`account_id`, `login`, `password`, `email`, `role`, `registration_date`, `active`) VALUES
	(243, 'admin', 'A8[exV[]', 'admin@gmail.com', 'ADMIN', '2020-09-09 21:12:50', 0),
	(244, 'trainer71859', 'AonR|Uqgzh7g~JKg', 'email7284605@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 0),
	(245, 'trainer645552', 'AoHQ}Uqgzh7g~JKg', 'email6685704@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 0),
	(246, 'trainer2029481', 'AQHQ7Uqgzh7g~JKg', 'email5884185@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 0),
	(247, 'trainer4221846', 'AkHS9Uqgzh7g~JKg', 'email8160483@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 0),
	(248, 'trainer8841979', 'AU~R9Uqgzh7g~JKg', 'email248612@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 0),
	(249, 'trainer6324127', 'AonQ|Uqgzh7g~JKg', 'email5628617@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 0),
	(250, 'trainer6046214', 'AgXQ8Uqgzh7g~JKg', 'email6963601@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 0),
	(251, 'trainer7928486', 'A]HQ7Uqgzh7g~JKg', 'email2738387@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 0),
	(252, 'trainer3340977', 'AknQ6Uqgzh7g~JKg', 'email2965659@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 0),
	(253, 'trainer7525224', 'AUXS8Uqgzh7g~JKg', 'email2822410@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 0),
	(254, 'client7371660', 'AAER9Uqgzh7g~JKg', 'email4056426@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(255, 'client2361832', 'AoHQ~Uqgzh7g~JKg', 'email3396525@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(256, 'client6704641', 'AQHQ~Uqgzh7g~JKg', 'email222817@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(257, 'client8349252', 'AEnR8Uqgzh7g~JKg', 'email9611103@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(258, 'client6346423', 'AUHR7Uqgzh7g~JKg', 'email325113@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(259, 'client5533317', 'A]XR|Uqgzh7g~JKg', 'email3363978@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(260, 'client7657470', 'AU~R4Uqgzh7g~JKg', 'email599744@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(261, 'client1358051', 'A]HR}Uqgzh7g~JKg', 'email3783797@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(262, 'client6507838', 'AInR|Uqgzh7g~JKg', 'email8795236@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(263, 'client4917933', 'AMnQ5Uqgzh7g~JKg', 'email1941702@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(264, 'client1614015', 'AMnQ7Uqgzh7g~JKg', 'email9659230@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(265, 'client7472113', 'AkXQ4Uqgzh7g~JKg', 'email9791347@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(266, 'client1156353', 'AkHQ~Uqgzh7g~JKg', 'email6479627@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(267, 'client7540930', 'AQHS6Uqgzh7g~JKg', 'email9580039@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(268, 'client4830895', 'AYXR|Uqgzh7g~JKg', 'email4256902@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(269, 'client3455451', 'AIXQ~Uqgzh7g~JKg', 'email2989882@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(270, 'client5316899', 'AgXQ|Uqgzh7g~JKg', 'email5296567@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(271, 'client9546088', 'AEHS~Uqgzh7g~JKg', 'email4773351@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(272, 'client7350415', 'AoXS4Uqgzh7g~JKg', 'email6841707@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(273, 'client4194999', 'AQ~R7Uqgzh7g~JKg', 'email8651424@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(274, 'client5924971', 'AQnQ7Uqgzh7g~JKg', 'email5099860@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(275, 'client9013111', 'AUXS6Uqgzh7g~JKg', 'email2401095@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(276, 'client7357829', 'AMHQ9Uqgzh7g~JKg', 'email1597539@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(277, 'client4959663', 'AEXS|Uqgzh7g~JKg', 'email5838100@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(278, 'client8868321', 'AEnQ}Uqgzh7g~JKg', 'email333149@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(279, 'client3426229', 'AEXQ8Uqgzh7g~JKg', 'email9912052@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(280, 'client4520749', 'AU~R~Uqgzh7g~JKg', 'email5670315@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(281, 'client5052467', 'AQXR9Uqgzh7g~JKg', 'email5591607@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(282, 'client4738890', 'AEXQ6Uqgzh7g~JKg', 'email8151779@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0),
	(283, 'client289959', 'Ak~R7Uqgzh7g~JKg', 'email794059@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 0);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;

-- Дамп структуры для таблица gym.clients
DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `client_id` int NOT NULL,
  `discount` double(22,0) DEFAULT '0',
  PRIMARY KEY (`client_id`),
  UNIQUE KEY `client_id` (`client_id`),
  CONSTRAINT `FK_clients_users` FOREIGN KEY (`client_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.clients: ~133 rows (приблизительно)
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
REPLACE INTO `clients` (`client_id`, `discount`) VALUES
	(254, 0),
	(255, 0),
	(256, 0),
	(257, 0),
	(258, 0),
	(259, 0),
	(260, 0),
	(261, 0),
	(262, 0),
	(263, 0),
	(264, 0),
	(265, 0),
	(266, 0),
	(267, 0),
	(268, 0),
	(269, 0),
	(270, 0),
	(271, 0),
	(272, 0),
	(273, 0),
	(274, 0),
	(275, 0),
	(276, 0),
	(277, 0),
	(278, 0),
	(279, 0),
	(280, 0),
	(281, 0),
	(282, 0),
	(283, 0);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;

-- Дамп структуры для таблица gym.exercises
DROP TABLE IF EXISTS `exercises`;
CREATE TABLE IF NOT EXISTS `exercises` (
  `training_id` int NOT NULL,
  `type` enum('BENCH_PRESS','DEADLIFT','SQUATS') NOT NULL,
  `weight` double DEFAULT NULL,
  KEY `FK_exercises_trainings` (`training_id`),
  CONSTRAINT `FK_exercises_trainings` FOREIGN KEY (`training_id`) REFERENCES `trainings` (`training_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.exercises: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `exercises` DISABLE KEYS */;
/*!40000 ALTER TABLE `exercises` ENABLE KEYS */;

-- Дамп структуры для таблица gym.trainers
DROP TABLE IF EXISTS `trainers`;
CREATE TABLE IF NOT EXISTS `trainers` (
  `trainer_id` int NOT NULL,
  `rating` double(22,0) DEFAULT '0',
  PRIMARY KEY (`trainer_id`),
  UNIQUE KEY `trainer_id` (`trainer_id`),
  CONSTRAINT `FK_trainers_users` FOREIGN KEY (`trainer_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.trainers: ~18 rows (приблизительно)
/*!40000 ALTER TABLE `trainers` DISABLE KEYS */;
REPLACE INTO `trainers` (`trainer_id`, `rating`) VALUES
	(244, 0),
	(245, 0),
	(246, 0),
	(247, 0),
	(248, 0),
	(249, 0),
	(250, 0),
	(251, 0),
	(252, 0),
	(253, 0);
/*!40000 ALTER TABLE `trainers` ENABLE KEYS */;

-- Дамп структуры для таблица gym.trainings
DROP TABLE IF EXISTS `trainings`;
CREATE TABLE IF NOT EXISTS `trainings` (
  `training_id` int NOT NULL AUTO_INCREMENT,
  `trainer_id` int NOT NULL,
  `client_id` int NOT NULL,
  `cost` double NOT NULL DEFAULT '0',
  `date` date NOT NULL,
  `start` time NOT NULL,
  `end` time NOT NULL,
  `bought` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`training_id`) USING BTREE,
  UNIQUE KEY `id` (`training_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.trainings: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `trainings` DISABLE KEYS */;
/*!40000 ALTER TABLE `trainings` ENABLE KEYS */;

-- Дамп структуры для таблица gym.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int NOT NULL,
  `first_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `last_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `phone` varchar(30) DEFAULT '',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id` (`user_id`),
  CONSTRAINT `FK_users_accounts` FOREIGN KEY (`user_id`) REFERENCES `accounts` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.users: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
REPLACE INTO `users` (`user_id`, `first_name`, `last_name`, `phone`) VALUES
	(243, '', '', ''),
	(244, '', '', ''),
	(245, '', '', ''),
	(246, '', '', ''),
	(247, '', '', ''),
	(248, '', '', ''),
	(249, '', '', ''),
	(250, '', '', ''),
	(251, '', '', ''),
	(252, '', '', ''),
	(253, '', '', ''),
	(254, '', '', ''),
	(255, '', '', ''),
	(256, '', '', ''),
	(257, '', '', ''),
	(258, '', '', ''),
	(259, '', '', ''),
	(260, '', '', ''),
	(261, '', '', ''),
	(262, '', '', ''),
	(263, '', '', ''),
	(264, '', '', ''),
	(265, '', '', ''),
	(266, '', '', ''),
	(267, '', '', ''),
	(268, '', '', ''),
	(269, '', '', ''),
	(270, '', '', ''),
	(271, '', '', ''),
	(272, '', '', ''),
	(273, '', '', ''),
	(274, '', '', ''),
	(275, '', '', ''),
	(276, '', '', ''),
	(277, '', '', ''),
	(278, '', '', ''),
	(279, '', '', ''),
	(280, '', '', ''),
	(281, '', '', ''),
	(282, '', '', ''),
	(283, '', '', '');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Дамп структуры для таблица gym.users_trainings
DROP TABLE IF EXISTS `users_trainings`;
CREATE TABLE IF NOT EXISTS `users_trainings` (
  `user_id_fk` int NOT NULL,
  `training_id_fk` int NOT NULL,
  `done` tinyint NOT NULL DEFAULT '0',
  KEY `FK_users_trainings_users` (`user_id_fk`),
  KEY `FK_users_trainings_trainings` (`training_id_fk`),
  CONSTRAINT `FK_users_trainings_trainings` FOREIGN KEY (`training_id_fk`) REFERENCES `trainings` (`training_id`),
  CONSTRAINT `FK_users_trainings_users` FOREIGN KEY (`user_id_fk`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.users_trainings: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `users_trainings` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_trainings` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
