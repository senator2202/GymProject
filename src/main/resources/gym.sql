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
  `login` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `email` varchar(50) NOT NULL,
  `role` enum('ADMIN','TRAINER','CLIENT') NOT NULL DEFAULT 'CLIENT',
  `registration_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `locale` enum('ENGLISH','RUSSIAN') CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT 'RUSSIAN',
  `active` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`account_id`) USING BTREE,
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `id` (`account_id`) USING BTREE,
  UNIQUE KEY `name` (`login`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=348 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.accounts: ~64 rows (приблизительно)
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
REPLACE INTO `accounts` (`account_id`, `login`, `password`, `email`, `role`, `registration_date`, `locale`, `active`) VALUES
	(243, 'admin', 'A8[exV[]', 'gym.project.epam@gmail.com', 'ADMIN', '2020-09-09 21:12:50', 'RUSSIAN', 1),
	(254, 'client7371660', 'AAER9Uqgzh7g~JKg', 'email4056426@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(255, 'client2361832', 'AoHQ~Uqgzh7g~JKg', 'email3396525@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(256, 'client6704641', 'AQHQ~Uqgzh7g~JKg', 'email222817@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(257, 'client8349252', 'AEnR8Uqgzh7g~JKg', 'email9611103@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(258, 'client6346423', 'AUHR7Uqgzh7g~JKg', 'email325113@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(259, 'client5533317', 'A]XR|Uqgzh7g~JKg', 'email3363978@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 1),
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
	(274, 'client5924971', 'AQnQ7Uqgzh7g~JKg', 'email5099860@gmail.com', 'TRAINER', '2020-09-09 21:29:37', 'RUSSIAN', 1),
	(275, 'client9013111', 'AUXS6Uqgzh7g~JKg', 'email2401095@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(276, 'client7357829', 'AMHQ9Uqgzh7g~JKg', 'email1597539@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(277, 'client4959663', 'AEXS|Uqgzh7g~JKg', 'email5838100@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(278, 'client8868321', 'AEnQ}Uqgzh7g~JKg', 'email333149@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(279, 'client3426229', 'AEXQ8Uqgzh7g~JKg', 'email9912052@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(280, 'client4520749', 'AU~R~Uqgzh7g~JKg', 'email5670315@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(281, 'client5052467', 'AQXR9Uqgzh7g~JKg', 'email5591607@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(282, 'client4738890', 'AEXQ6Uqgzh7g~JKg', 'email8151779@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 0),
	(283, 'client289959', 'Ak~R7Uqgzh7g~JKg', 'email794059@gmail.com', 'CLIENT', '2020-09-09 21:29:37', 'RUSSIAN', 1),
	(284, 'senator2202', '9Vrgph\\g', 'senator220291@gmail.com', 'CLIENT', '2020-09-10 10:17:40', 'RUSSIAN', 1),
	(285, 'client3826502', 'A]~Q}Uqgzh7g~JKg', 'email2463376@gmail.com', 'CLIENT', '2020-09-17 09:11:08', 'RUSSIAN', 0),
	(286, 'client9528772', 'AIXQ|Uqgzh7g~JKg', 'email1443461@gmail.com', 'CLIENT', '2020-09-17 09:11:08', 'RUSSIAN', 0),
	(288, 'abra', '9Vrgph\\g', 'abracadabra@gmail.com', 'CLIENT', '2020-09-17 12:06:52', 'RUSSIAN', 1),
	(289, 'tuchi', '9Vrgph\\g', 'tuchikakludi@mail.ru', 'CLIENT', '2020-09-17 12:09:46', 'RUSSIAN', 0),
	(301, 'trainer', '9Vrgph\\g', 'romashka@tut.by', 'TRAINER', '2020-09-29 13:35:56', 'ENGLISH', 1),
	(302, 'kentavr', '9Vrgph\\g', 'kentavr@mail.ru', 'TRAINER', '2020-09-29 13:37:49', 'ENGLISH', 1),
	(303, 'recent_user', '9Vrgph\\g', 'recent@mail.ru', 'CLIENT', '2020-10-07 16:07:32', 'ENGLISH', 1),
	(304, 'recent_user2', '9Vrgph\\g', 'recent2@mail.ru', 'CLIENT', '2020-10-07 16:08:09', 'ENGLISH', 1),
	(308, 'babushka', '9Vrgph\\g', 'babushka@tut.by', 'CLIENT', '2020-10-14 14:17:38', 'ENGLISH', 1),
	(309, 'clint', '9Vrgph\\g', 'clint@mail.ru', 'CLIENT', '2020-10-16 22:05:05', 'RUSSIAN', 1),
	(312, 'bam', '9Vrgph\\g', 'abrams@tut.by', 'CLIENT', '2020-10-18 00:17:16', 'ENGLISH', 0),
	(313, 'borov', '9Vrgph\\g', 'borov@mail.ru', 'CLIENT', '2020-10-18 00:35:21', 'ENGLISH', 0),
	(314, 'zubr', 'AAER~MXQ9Vrgph\\g', 'z1@maul.ru', 'CLIENT', '2020-10-18 00:36:33', 'ENGLISH', 1),
	(315, 'terminator', 'AA{Q}I~Q}I~Q}InQ', 'sam@tut.by', 'CLIENT', '2020-10-18 01:17:06', 'ENGLISH', 0),
	(316, 'kaban', '9Vrgph\\g', 'kaban@mail.ru', 'CLIENT', '2020-10-18 01:34:33', 'ENGLISH', 1),
	(317, 'banana', '9Vrgph\\g', 'banana@tut.by', 'CLIENT', '2020-10-18 01:46:35', 'ENGLISH', 0),
	(318, 'dunda', '9Vrgph\\g', 'dunda@tut.by', 'CLIENT', '2020-10-18 03:27:34', 'ENGLISH', 0),
	(319, 'bugaga', '9Vrgph\\g', 'bugaga@tut.by', 'CLIENT', '2020-10-18 03:37:29', 'ENGLISH', 0),
	(333, 'tratata', '9Vrgph\\g', 'tratata@mail.ru', 'TRAINER', '2020-10-20 22:33:47', 'RUSSIAN', 0),
	(334, 'mulan', '9Vrgph\\g', 'mulan@mail.ru', 'CLIENT', '2020-10-20 23:02:57', 'ENGLISH', 0),
	(335, 'gena228', '9Vrgph\\g', 'gena_bukin@tut.by', 'TRAINER', '2020-10-20 23:04:28', 'ENGLISH', 0),
	(336, 'buratino', '9Vrgph\\g', 't34@gmail.com', 'CLIENT', '2020-10-20 23:14:28', 'ENGLISH', 0),
	(337, 'dinamit', '9Vrgph\\g', 'dinamit@rambler.ru', 'CLIENT', '2020-10-20 23:15:27', 'RUSSIAN', 1),
	(338, 'tarakan', '9Vrgph\\g', 'ybl38408@eoopy.com', 'CLIENT', '2020-10-20 23:16:40', 'RUSSIAN', 1),
	(339, 'bot_petrovich', '9Vrgph\\g', 'ljx56125@cuoly.com', 'CLIENT', '2020-10-20 23:46:18', 'RUSSIAN', 1),
	(340, 'badnitos', '9Vrgph\\g', 'vtj36183@cuoly.com', 'CLIENT', '2020-10-21 00:47:59', 'RUSSIAN', 1),
	(341, 'tarantul322', '9Vrgph\\g', 'wdj72065@cuoly.com', 'CLIENT', '2020-10-21 00:54:32', 'RUSSIAN', 1),
	(342, 'badumba', '9Vrgph\\g', 'viq89486@bcaoo.com', 'CLIENT', '2020-10-22 11:13:36', 'RUSSIAN', 1),
	(343, 'tomat', '9Vrgph\\g', 'quj16414@bcaoo.com', 'CLIENT', '2020-10-22 11:21:43', 'ENGLISH', 1),
	(344, 'bomba_pushka', '9Vrgph\\g', 'bomba@pushka.ru', 'CLIENT', '2020-10-26 15:34:12', 'RUSSIAN', 0),
	(345, 'gradusnik', '9Vrgph\\g', 'temperature@tut.by', 'CLIENT', '2020-10-26 15:36:44', 'RUSSIAN', 0),
	(346, 'woody', '9Vrgph\\g', 'tarantul@gmail.com', 'CLIENT', '2020-10-29 14:24:47', 'RUSSIAN', 1),
	(347, 'bublik', '9Vrgph\\g', 'bublik@mail.ru', 'CLIENT', '2020-10-30 21:08:12', 'RUSSIAN', 1);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;

-- Дамп структуры для таблица gym.feedbacks
DROP TABLE IF EXISTS `feedbacks`;
CREATE TABLE IF NOT EXISTS `feedbacks` (
  `feedback_id` int NOT NULL AUTO_INCREMENT,
  `sender_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sender_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `feedback_subject` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `feedback_message` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `feedback_datetime` datetime DEFAULT CURRENT_TIMESTAMP,
  `reply_message` mediumtext,
  PRIMARY KEY (`feedback_id`),
  UNIQUE KEY `report_id` (`feedback_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы gym.feedbacks: ~15 rows (приблизительно)
/*!40000 ALTER TABLE `feedbacks` DISABLE KEYS */;
REPLACE INTO `feedbacks` (`feedback_id`, `sender_name`, `sender_email`, `feedback_subject`, `feedback_message`, `feedback_datetime`, `reply_message`) VALUES
	(1, 'Alex', 'alex222@mail.ru', 'service', 'service is good', '2020-10-16 12:56:51', 'thank you for your feedback'),
	(2, 'Serj', 'serg333@gmail.com', 'trainer', 'all trainers are so stupid', '2020-10-17 12:56:51', NULL),
	(3, 'Анатолий', 'tolik@rambler.ru', NULL, 'дороговатые тренировки', '2020-10-18 12:56:51', NULL),
	(4, 'Аноним', 'anonimous@gmail.com', 'Отзыв', 'Хороший сервис, приятные тренера, адекватные цены.\r\nХороший сервис, приятные тренера, адекватные цены.\r\nХороший сервис, приятные тренера, адекватные цены.\r\nХороший сервис, приятные тренера, адекватные цены.\r\nХороший сервис, приятные тренера, адекватные цены.\r\nХороший сервис, приятные тренера, адекватные цены.\r\nХороший сервис, приятные тренера, адекватные цены.\r\nХороший сервис, приятные тренера, адекватные цены.\r\nХороший сервис, приятные тренера, адекватные цены.\r\nХороший сервис, приятные тренера, адекватные цены.\r\n', '2020-10-19 12:56:51', NULL),
	(9, 'Admiral', 'buldog@tut.by', 'conditions', 'two hot in gym', '2020-10-20 12:56:51', NULL),
	(15, 'alex', 'petrenko', 'good staff', 'all good, staff is good too!', '2020-10-21 12:56:51', 'understand understand understand understand understand understand understand understand \r\nunderstand understand understand understand understand \r\nunderstand understand understand understand understand \r\nunderstand understand understand understand '),
	(16, 'Федор Двинятин', 'senator220291@gmail.com', 'кондиционер в зале', 'Не работает кондиционер в зале и раздевалке!', '2020-10-24 17:27:47', 'Спасибо за сообщение, постараемся быстро это исправить!'),
	(17, 'Дмитрий', 'mail222@tut.by', 'Вода', 'Поставьте питьевую воду в зале, спасибо!', '2020-10-26 10:26:42', NULL),
	(19, 'Алексей', 'tratata@mail.ru', 'Предъява', 'не, ну вы нормальные?', '2020-10-26 10:33:09', NULL),
	(20, 'Федор', 'azaza@tut.by', '', 'дайте скидку постоянному клиенту', '2020-10-26 10:41:00', NULL),
	(21, 'Goodwin', 'goodwin@tut.by', 'brain', 'need some brain, could u help me?', '2020-10-26 10:43:09', NULL),
	(24, '', 'mail222@tut.by', '', 'how much is the fish?', '2020-10-28 16:22:23', NULL),
	(25, 'Andrei', 'andrei@tut.by', 'Время работы', 'начните работать 24/7!', '2020-10-29 15:15:25', NULL),
	(26, 'Вася', 'abra@yahoo.com', '', 'Че по чем, пацанчики?', '2020-10-29 15:18:01', NULL),
	(27, 'Тарас', 'taras@mail.ru', 'спортпит', 'начните продавать на входе спортивное питание, Спасибо!', '2020-10-29 15:25:09', NULL);
/*!40000 ALTER TABLE `feedbacks` ENABLE KEYS */;

-- Дамп структуры для таблица gym.trainer_applications
DROP TABLE IF EXISTS `trainer_applications`;
CREATE TABLE IF NOT EXISTS `trainer_applications` (
  `user_id` int NOT NULL DEFAULT '0',
  `app_institution` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `app_graduation` int NOT NULL,
  `app_instagram` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '',
  `application_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `FK_trainer_applications_users` (`user_id`),
  CONSTRAINT `FK_trainer_applications_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы gym.trainer_applications: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `trainer_applications` DISABLE KEYS */;
REPLACE INTO `trainer_applications` (`user_id`, `app_institution`, `app_graduation`, `app_instagram`, `application_date`) VALUES
	(288, 'MGU', 2015, 'https://www.instagram.com/xzibit', '2020-09-29 11:10:54'),
	(284, 'БГУФК', 2013, 'https://www.instagram.com/senator2202', '2020-10-30 22:46:48');
/*!40000 ALTER TABLE `trainer_applications` ENABLE KEYS */;

-- Дамп структуры для таблица gym.trainings
DROP TABLE IF EXISTS `trainings`;
CREATE TABLE IF NOT EXISTS `trainings` (
  `training_id` int NOT NULL AUTO_INCREMENT,
  `trainer_id` int NOT NULL,
  `client_id` int NOT NULL,
  `training_date` date DEFAULT NULL,
  `training_time` time DEFAULT '12:00:00',
  `done` tinyint DEFAULT '0',
  `description` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `training_rating` int DEFAULT '0',
  PRIMARY KEY (`training_id`) USING BTREE,
  UNIQUE KEY `id` (`training_id`) USING BTREE,
  KEY `FK_trainings_users` (`trainer_id`),
  KEY `FK_trainings_users_2` (`client_id`),
  CONSTRAINT `FK_trainings_users` FOREIGN KEY (`trainer_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_trainings_users_2` FOREIGN KEY (`client_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.trainings: ~11 rows (приблизительно)
/*!40000 ALTER TABLE `trainings` DISABLE KEYS */;
REPLACE INTO `trainings` (`training_id`, `trainer_id`, `client_id`, `training_date`, `training_time`, `done`, `description`, `training_rating`) VALUES
	(9, 301, 284, '2020-10-25', '17:00:00', 1, 'Кардио разминка 10 мин, тяга грифа широким хватом сверху, тяга штанги в наклоне,  французский жим, подъем ног на пресс.', 2),
	(12, 301, 284, '2020-10-23', '12:00:00', 1, 'Пресс, бицепс, трицепс', 4),
	(13, 301, 284, '2020-11-05', '17:00:00', 0, 'Бег на дорожке 10 мин. Жим лежа 4 подхода на 10 повторений', 0),
	(14, 301, 303, '2020-10-25', '12:00:00', 0, 'Тест на ошибку\r\nСработает\r\nИли нет?', 0),
	(17, 301, 288, '2020-10-21', '12:00:00', 1, 'Кардио тренировка: бег на дорожке 20 мин, велотренажер 20 мин, степ тренажер 20 мин', 3),
	(23, 301, 343, '2020-10-24', '14:30:00', 1, NULL, 3),
	(24, 274, 284, '2020-11-01', '17:20:00', 0, NULL, 0),
	(27, 301, 284, '2020-10-31', '15:05:00', 0, 'Отжимания на брусьях, 5х15, разводка гантелей 4x10, пресс 2х20', 0),
	(28, 301, 284, '2020-11-02', '04:00:00', 0, NULL, 0),
	(29, 302, 284, '2020-11-07', '11:36:00', 0, NULL, 0),
	(35, 301, 284, '2020-11-08', '17:15:00', 0, NULL, 0),
	(37, 301, 347, '2020-11-13', '15:00:00', 0, NULL, 0);
/*!40000 ALTER TABLE `trainings` ENABLE KEYS */;

-- Дамп структуры для таблица gym.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int NOT NULL,
  `first_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `last_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `rating` double(22,0) DEFAULT '0',
  `institution` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `graduation` int DEFAULT NULL,
  `instagram` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `discount` double(22,0) DEFAULT '0',
  `diet_id_fk` int DEFAULT NULL,
  `image_name` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `money_balance` int DEFAULT '100',
  `bought_trainings` int DEFAULT '0',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id` (`user_id`),
  KEY `FK_users_diets` (`diet_id_fk`),
  CONSTRAINT `FK_users_accounts` FOREIGN KEY (`user_id`) REFERENCES `accounts` (`account_id`),
  CONSTRAINT `FK_users_diets` FOREIGN KEY (`diet_id_fk`) REFERENCES `diets` (`diet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы gym.users: ~64 rows (приблизительно)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
REPLACE INTO `users` (`user_id`, `first_name`, `last_name`, `phone`, `rating`, `institution`, `graduation`, `instagram`, `discount`, `diet_id_fk`, `image_name`, `money_balance`, `bought_trainings`) VALUES
	(243, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(254, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(255, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(256, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(257, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(258, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(259, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(260, '', '', '', NULL, 'BSU', 2009, 'instagram.com/none', NULL, NULL, NULL, 100, 0),
	(261, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(262, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(263, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(264, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(265, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(266, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(267, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(268, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(269, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(270, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(271, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(272, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(273, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(274, 'Sveta', 'Tuhto', '+375296459988', NULL, 'BSUFC', 2019, 'instagram.com/arni', NULL, NULL, NULL, 100, 0),
	(275, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(276, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(277, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(278, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(279, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(280, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(281, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(282, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 0),
	(283, '', '', '', NULL, NULL, NULL, NULL, NULL, 1, NULL, 100, 0),
	(284, 'Александр', 'Шмюгельсон', '+375335678962', NULL, NULL, NULL, NULL, 12, 1, '/uploads/882ff907-c294-423b-9b0f-13dd4b019cea.jpg', 320, 8),
	(285, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(286, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(288, 'Chef', 'Ivlev', '80295554466', 0, NULL, NULL, NULL, 0, 2, '/uploads/86a6627b-4a7c-4834-b3d5-983058734a6c.jpg', 100, 0),
	(289, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(301, 'Anastacia', 'Lipinskaya', '+375441234598', 3, 'MSLU', 2012, 'instagram.com/mslu', 0, NULL, '/uploads/b051928f-4703-48ad-a6ba-47c407005a80.jpg', 100, 0),
	(302, 'Pipko', 'Dmitrii', '80296558891', 0, 'BSUIR', 2008, 'instagram.com/pipko', 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(303, 'Bill', 'Perkins', '80291111111', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(304, 'Perr', 'Billkins', '80292222222', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(308, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(309, 'Клинт', 'Иствуд', '+372644646464', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(312, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(313, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(314, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(315, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(316, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(317, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(318, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(319, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(333, '', '', '', 0, 'BSUFC', 2017, 'https://www.instagram.com/l_one_mars/', 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(334, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(335, '', '', '', 0, 'Envila', 2008, 'https://www.instagram.com/buzova86/', 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(336, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(337, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(338, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(339, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(340, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(341, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(342, '', '', '', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 100, 0),
	(343, 'Абдурахман', 'Петрович', '80172306303', 0, NULL, NULL, NULL, 0, NULL, '/uploads/75ae7dfe-11d7-429e-a540-87e67cf3bc24.jpg', 173, 9),
	(344, '', '', '', 0, NULL, NULL, NULL, 0, NULL, NULL, 100, 0),
	(345, '', '', '', 0, NULL, NULL, NULL, 6, NULL, NULL, 100, 0),
	(346, '', '', '', 0, NULL, NULL, NULL, 0, NULL, NULL, 100, 0),
	(347, '', '', '', 0, NULL, NULL, NULL, 27, NULL, NULL, 0, 4);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
