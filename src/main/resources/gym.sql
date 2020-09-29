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
  `login` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `role` enum('ADMIN','TRAINER','CLIENT') NOT NULL DEFAULT 'CLIENT',
  `registration_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `locale` enum('ENGLISH','RUSSIAN') CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT 'ENGLISH',
  `active` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`account_id`) USING BTREE,
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `id` (`account_id`) USING BTREE,
  UNIQUE KEY `name` (`login`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=303 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.accounts: ~46 rows (приблизительно)
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
REPLACE INTO `accounts` (`account_id`, `login`, `password`, `email`, `role`, `registration_date`, `locale`, `active`) VALUES
	(243, 'admin', 'A8[exV[]', 'admin@gmail.com', 'ADMIN', '2020-09-09 21:12:50', 'RUSSIAN', 1),
	(244, 'trainer71859', 'AonR|Uqgzh7g~JKg', 'email7284605@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 'RUSSIAN', 0),
	(245, 'trainer645552', 'AoHQ}Uqgzh7g~JKg', 'email6685704@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 'RUSSIAN', 0),
	(246, 'trainer2029481', 'AQHQ7Uqgzh7g~JKg', 'email5884185@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 'RUSSIAN', 0),
	(247, 'trainer4221846', 'AkHS9Uqgzh7g~JKg', 'email8160483@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 'RUSSIAN', 0),
	(248, 'trainer8841979', 'AU~R9Uqgzh7g~JKg', 'email248612@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 'RUSSIAN', 0),
	(249, 'trainer6324127', 'AonQ|Uqgzh7g~JKg', 'email5628617@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 'RUSSIAN', 0),
	(250, 'trainer6046214', 'AgXQ8Uqgzh7g~JKg', 'email6963601@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 'RUSSIAN', 0),
	(251, 'trainer7928486', 'A]HQ7Uqgzh7g~JKg', 'email2738387@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 'RUSSIAN', 0),
	(252, 'trainer3340977', 'AknQ6Uqgzh7g~JKg', 'email2965659@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 'RUSSIAN', 0),
	(253, 'trainer7525224', 'AUXS8Uqgzh7g~JKg', 'email2822410@gmail.com', 'TRAINER', '2020-09-09 21:29:17', 'RUSSIAN', 0),
	(254, 'client7371660', 'AAER9Uqgzh7g~JKg', 'email4056426@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(255, 'client2361832', 'AoHQ~Uqgzh7g~JKg', 'email3396525@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(256, 'client6704641', 'AQHQ~Uqgzh7g~JKg', 'email222817@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(257, 'client8349252', 'AEnR8Uqgzh7g~JKg', 'email9611103@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(258, 'client6346423', 'AUHR7Uqgzh7g~JKg', 'email325113@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(259, 'client5533317', 'A]XR|Uqgzh7g~JKg', 'email3363978@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(260, 'client7657470', 'AU~R4Uqgzh7g~JKg', 'email599744@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(261, 'client1358051', 'A]HR}Uqgzh7g~JKg', 'email3783797@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(262, 'client6507838', 'AInR|Uqgzh7g~JKg', 'email8795236@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(263, 'client4917933', 'AMnQ5Uqgzh7g~JKg', 'email1941702@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(264, 'client1614015', 'AMnQ7Uqgzh7g~JKg', 'email9659230@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(265, 'client7472113', 'AkXQ4Uqgzh7g~JKg', 'email9791347@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(266, 'client1156353', 'AkHQ~Uqgzh7g~JKg', 'email6479627@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(267, 'client7540930', 'AQHS6Uqgzh7g~JKg', 'email9580039@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(268, 'client4830895', 'AYXR|Uqgzh7g~JKg', 'email4256902@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(269, 'client3455451', 'AIXQ~Uqgzh7g~JKg', 'email2989882@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(270, 'client5316899', 'AgXQ|Uqgzh7g~JKg', 'email5296567@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(271, 'client9546088', 'AEHS~Uqgzh7g~JKg', 'email4773351@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(272, 'client7350415', 'AoXS4Uqgzh7g~JKg', 'email6841707@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(273, 'client4194999', 'AQ~R7Uqgzh7g~JKg', 'email8651424@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(274, 'client5924971', 'AQnQ7Uqgzh7g~JKg', 'email5099860@gmail.com', 'TRAINER', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(275, 'client9013111', 'AUXS6Uqgzh7g~JKg', 'email2401095@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(276, 'client7357829', 'AMHQ9Uqgzh7g~JKg', 'email1597539@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(277, 'client4959663', 'AEXS|Uqgzh7g~JKg', 'email5838100@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(278, 'client8868321', 'AEnQ}Uqgzh7g~JKg', 'email333149@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(279, 'client3426229', 'AEXQ8Uqgzh7g~JKg', 'email9912052@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(280, 'client4520749', 'AU~R~Uqgzh7g~JKg', 'email5670315@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(281, 'client5052467', 'AQXR9Uqgzh7g~JKg', 'email5591607@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(282, 'client4738890', 'AEXQ6Uqgzh7g~JKg', 'email8151779@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(283, 'client289959', 'Ak~R7Uqgzh7g~JKg', 'email794059@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 1),
	(284, 'senator2202', 'AAER~MXQ9Vrgph\\g', 'senator220291@gmail.com', 'CLIENT', '2020-09-10 10:17:40', 'RUSSIAN', 1),
	(285, 'client3826502', 'A]~Q}Uqgzh7g~JKg', 'email2463376@gmail.com', 'CLIENT', '2020-09-17 09:11:08', 'RUSSIAN', 0),
	(286, 'client9528772', 'AIXQ|Uqgzh7g~JKg', 'email1443461@gmail.com', 'CLIENT', '2020-09-17 09:11:08', 'RUSSIAN', 0),
	(288, 'abra', '9Vrgph\\g', 'abracadabra@gmail.com', 'CLIENT', '2020-09-17 12:06:52', 'RUSSIAN', 1),
	(289, 'tuchi', '9Vrgph\\g', 'tuchikakludi@mail.ru', 'CLIENT', '2020-09-17 12:09:46', 'RUSSIAN', 0),
	(301, 'romashka', '9Vrgph\\g', 'romashka@tut.by', 'TRAINER', '2020-09-29 13:35:56', 'RUSSIAN', 0),
	(302, 'kentavr', '9Vrgph\\g', 'kentavr@mail.ru', 'TRAINER', '2020-09-29 13:37:49', 'ENGLISH', 0);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;

-- Дамп структуры для таблица gym.diets
DROP TABLE IF EXISTS `diets`;
CREATE TABLE IF NOT EXISTS `diets` (
  `diet_id` int NOT NULL AUTO_INCREMENT,
  `diet_type` enum('SLIMMING','WEIGHT_GAIN','KEEPING_SHAPE') NOT NULL DEFAULT 'KEEPING_SHAPE',
  PRIMARY KEY (`diet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.diets: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `diets` DISABLE KEYS */;
REPLACE INTO `diets` (`diet_id`, `diet_type`) VALUES
	(1, 'SLIMMING'),
	(2, 'KEEPING_SHAPE'),
	(3, 'WEIGHT_GAIN');
/*!40000 ALTER TABLE `diets` ENABLE KEYS */;

-- Дамп структуры для таблица gym.diet_meals
DROP TABLE IF EXISTS `diet_meals`;
CREATE TABLE IF NOT EXISTS `diet_meals` (
  `diet_id` int NOT NULL AUTO_INCREMENT,
  `meal_type` enum('BREAKFAST','LUNCH','DINNER','SUPPER') NOT NULL,
  `meal_description` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  KEY `FK_meals_diets` (`diet_id`),
  CONSTRAINT `FK_meals_diets` FOREIGN KEY (`diet_id`) REFERENCES `diets` (`diet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.diet_meals: ~11 rows (приблизительно)
/*!40000 ALTER TABLE `diet_meals` DISABLE KEYS */;
REPLACE INTO `diet_meals` (`diet_id`, `meal_type`, `meal_description`) VALUES
	(1, 'BREAKFAST', 'Яичница с сыром, 2 тоста с арахисовым маслом, кофе с молоком'),
	(1, 'DINNER', 'Рис отварной без масла, куриная грудка'),
	(1, 'SUPPER', 'Салат "Цезарь с курицей", апельсиновый сок '),
	(2, 'BREAKFAST', 'Гречневая каша с кусочком масла, жареные куриные крылышки, кофе, творожный пудинг'),
	(2, 'LUNCH', 'Творожная паста "Снежок" с желатином, чай '),
	(2, 'DINNER', 'Куриный суп, рисовая каша, куриное филе'),
	(2, 'SUPPER', 'Салат из овощей, консервированный тунец, стакан апельсинового сока'),
	(3, 'BREAKFAST', 'Хлопья "Nesquick" с молоком, яичница с ветчиной и сыром, кофе со сливками'),
	(3, 'LUNCH', 'Блинчики с кленовым сиропом, молоко'),
	(3, 'DINNER', 'Куриный бульон, паста болоньезе, молочный коктейль'),
	(3, 'SUPPER', 'Салат "Цезарь с курицей", протеиновый коктейль');
/*!40000 ALTER TABLE `diet_meals` ENABLE KEYS */;

-- Дамп структуры для таблица gym.marks
DROP TABLE IF EXISTS `marks`;
CREATE TABLE IF NOT EXISTS `marks` (
  `client_id` int NOT NULL,
  `trainer_id` int NOT NULL,
  `mark` int NOT NULL DEFAULT '0',
  `mark_date` datetime NOT NULL,
  KEY `FK__users` (`client_id`),
  KEY `FK__users_2` (`trainer_id`),
  CONSTRAINT `FK__users` FOREIGN KEY (`client_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK__users_2` FOREIGN KEY (`trainer_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.marks: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
REPLACE INTO `marks` (`client_id`, `trainer_id`, `mark`, `mark_date`) VALUES
	(260, 250, 5, '2020-09-16 15:34:06'),
	(255, 253, 3, '2020-09-16 15:35:23');
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;

-- Дамп структуры для таблица gym.trainer_applications
DROP TABLE IF EXISTS `trainer_applications`;
CREATE TABLE IF NOT EXISTS `trainer_applications` (
  `user_id` int NOT NULL DEFAULT '0',
  `app_institution` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `app_graduation` int NOT NULL,
  `app_instagram` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '',
  `application_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `FK_trainer_applications_users` (`user_id`),
  CONSTRAINT `FK_trainer_applications_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы gym.trainer_applications: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `trainer_applications` DISABLE KEYS */;
REPLACE INTO `trainer_applications` (`user_id`, `app_institution`, `app_graduation`, `app_instagram`, `application_date`) VALUES
	(288, 'MGU', 2015, 'instagram.com/xzibit', '2020-09-29 11:10:54');
/*!40000 ALTER TABLE `trainer_applications` ENABLE KEYS */;

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
  UNIQUE KEY `id` (`training_id`) USING BTREE,
  KEY `FK_trainings_users` (`trainer_id`),
  KEY `FK_trainings_users_2` (`client_id`),
  CONSTRAINT `FK_trainings_users` FOREIGN KEY (`trainer_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_trainings_users_2` FOREIGN KEY (`client_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.trainings: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `trainings` DISABLE KEYS */;
REPLACE INTO `trainings` (`training_id`, `trainer_id`, `client_id`, `cost`, `date`, `start`, `end`, `bought`) VALUES
	(1, 253, 254, 20, '2020-09-20', '16:00:00', '17:00:00', 1),
	(2, 253, 255, 20, '2020-09-20', '18:00:00', '19:00:00', 0),
	(3, 250, 260, 25, '2020-09-18', '12:00:00', '13:00:00', 0);
/*!40000 ALTER TABLE `trainings` ENABLE KEYS */;

-- Дамп структуры для таблица gym.training_exercises
DROP TABLE IF EXISTS `training_exercises`;
CREATE TABLE IF NOT EXISTS `training_exercises` (
  `training_id` int NOT NULL,
  `type` enum('BENCH_PRESS','DEADLIFT','SQUATS') NOT NULL,
  `weight` double DEFAULT NULL,
  KEY `FK_exercises_trainings` (`training_id`),
  CONSTRAINT `FK_exercises_trainings` FOREIGN KEY (`training_id`) REFERENCES `trainings` (`training_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.training_exercises: ~5 rows (приблизительно)
/*!40000 ALTER TABLE `training_exercises` DISABLE KEYS */;
REPLACE INTO `training_exercises` (`training_id`, `type`, `weight`) VALUES
	(1, 'BENCH_PRESS', 100),
	(1, 'DEADLIFT', 150),
	(1, 'SQUATS', 140),
	(2, 'BENCH_PRESS', 60),
	(2, 'SQUATS', 100);
/*!40000 ALTER TABLE `training_exercises` ENABLE KEYS */;

-- Дамп структуры для таблица gym.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int NOT NULL,
  `first_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `last_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `phone` varchar(30) DEFAULT '',
  `rating` double(22,0) DEFAULT '0',
  `institution` varchar(30) DEFAULT NULL,
  `graduation` int DEFAULT NULL,
  `instagram` varchar(30) DEFAULT NULL,
  `discount` double(22,0) DEFAULT '0',
  `diet_id` int DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id` (`user_id`),
  KEY `FK_users_diets` (`diet_id`),
  CONSTRAINT `FK_users_accounts` FOREIGN KEY (`user_id`) REFERENCES `accounts` (`account_id`),
  CONSTRAINT `FK_users_diets` FOREIGN KEY (`diet_id`) REFERENCES `diets` (`diet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.users: ~46 rows (приблизительно)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
REPLACE INTO `users` (`user_id`, `first_name`, `last_name`, `phone`, `rating`, `institution`, `graduation`, `instagram`, `discount`, `diet_id`) VALUES
	(243, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(244, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(245, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(246, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(247, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(248, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(249, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(250, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(251, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(252, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(253, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(254, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(255, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(256, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(257, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(258, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(259, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(260, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(261, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(262, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(263, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(264, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(265, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(266, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(267, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(268, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(269, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(270, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(271, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(272, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(273, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(274, 'Sveta', 'Tuhto', '+375296459988', NULL, 'BSUFC', 2019, 'instagram.com/arni', NULL, NULL),
	(275, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(276, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(277, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(278, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(279, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(280, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(281, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(282, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
	(283, '', '', '', NULL, NULL, NULL, NULL, NULL, 1),
	(284, 'Angela', 'Merkel', '+375335678962', NULL, NULL, NULL, NULL, NULL, 1),
	(285, '', '', '', 0, NULL, NULL, NULL, 0, NULL),
	(286, '', '', '', 0, NULL, NULL, NULL, 0, NULL),
	(288, 'Chef', 'Ivlev', '80295554466', 0, NULL, NULL, NULL, 0, 2),
	(289, '', '', '', 0, NULL, NULL, NULL, 0, NULL),
	(301, 'Anastacia', 'Lipinskaya', '+375441234598', 0, 'MSLU', 2012, 'instagram.com/mslu', 0, NULL),
	(302, 'Pipko', 'Dmitrii', '80296558891', 0, 'BSUIR', 2008, 'instagram.com/pipko', 0, NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
