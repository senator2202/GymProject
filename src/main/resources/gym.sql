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
) ENGINE=InnoDB AUTO_INCREMENT=354 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.accounts: ~71 rows (приблизительно)
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
	(301, 'trainer', '9Vrgph\\g', 'romashka@tut.by', 'TRAINER', '2020-09-29 13:35:56', 'RUSSIAN', 1),
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
	(333, 'tratata', '9Vrgph\\g', 'tratata@mail.ru', 'TRAINER', '2020-10-20 22:33:47', 'RUSSIAN', 1),
	(334, 'mulan', '9Vrgph\\g', 'mulan@mail.ru', 'CLIENT', '2020-10-20 23:02:57', 'ENGLISH', 0),
	(335, 'gena228', '9Vrgph\\g', 'gena_bukin@tut.by', 'TRAINER', '2020-10-20 23:04:28', 'ENGLISH', 1),
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
	(347, 'bublik', '9Vrgph\\g', 'bublik@mail.ru', 'CLIENT', '2020-10-30 21:08:12', 'RUSSIAN', 1),
	(348, 'tarantaika', '9Vrgph\\g', 'tarantaika@rambler.ru', 'CLIENT', '2020-11-02 14:10:15', 'RUSSIAN', 0),
	(349, 'dedushka', '9Vrgph\\g', 'babushka@mail.ru', 'CLIENT', '2020-11-10 00:19:44', 'RUSSIAN', 0),
	(350, 'ded322', '9Vrgph\\g', 'ded322@tut.by', 'CLIENT', '2020-11-10 00:22:00', 'RUSSIAN', 1),
	(351, 'aaaaaaa', '9Vrgph\\g', 'yaw13078@cuoly.com', 'CLIENT', '2020-11-10 01:03:51', 'RUSSIAN', 1),
	(352, 'bbbbbbb', '9Vrgph\\g', 'dqa87266@bcaoo.com', 'CLIENT', '2020-11-10 01:06:58', 'RUSSIAN', 1),
	(353, 'asasddsa', '9Vrgph\\g', 'hsw71420@bcaoo.com', 'CLIENT', '2020-11-10 01:11:53', 'RUSSIAN', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы gym.feedbacks: ~40 rows (приблизительно)
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
	(27, 'Тарас', 'taras@mail.ru', 'спортпит', 'начните продавать на входе спортивное питание, Спасибо!', '2020-10-29 15:25:09', NULL),
	(28, 'Бургомистр', 'den228@tut.by', 'плохой тренр', 'Аркадий Райкин - так себе тренер', '2020-11-03 10:11:28', NULL),
	(29, 'Денис', 'goodwin@tut.by', '', 'хотелось бы заниматься ночью, а нельзя(((', '2020-11-03 10:18:40', NULL),
	(30, 'den', 'saratov@tut.by', 'hi', 'hello, how much is the fish?', '2020-11-05 10:41:13', 'hello, dude'),
	(31, 'Абдула', 'abdula@tut.by', 'как сам?', 'как сам, брат?', '2020-11-05 18:51:01', 'норм, а ты?'),
	(32, 'Федор', 'dart@mail.ru', 'Bad condition', 'wassup, bro?', '2020-11-06 21:28:45', NULL),
	(33, 'alex', 'tartar@mai.ru', '', 'message', '2020-11-09 21:59:55', NULL),
	(34, 'alex', 'tartar@mai.ru', '', 'message', '2020-11-09 22:01:18', NULL),
	(35, 'alalalal', 'alalal@tut.by', 'alalal', 'alalalalal', '2020-11-09 22:06:40', NULL),
	(36, 'Azis', 'azis@tut.by', 'azaza', 'azaza', '2020-11-09 22:14:06', NULL),
	(37, 'alex', 'tartar@mai.ru', '', 'message', '2020-11-09 22:57:11', NULL),
	(38, 'alex', 'tartar@mai.ru', '', 'message', '2020-11-09 23:00:21', NULL),
	(39, 'alex', 'tartar@mai.ru', '', 'message', '2020-11-09 23:03:51', NULL),
	(40, '', 'tartar@mai.ru', '', 'message', '2020-11-09 23:03:51', NULL),
	(41, '', 'tartar@mai.ru', 'bad', 'message', '2020-11-09 23:03:51', NULL),
	(42, 'alex', 'tartar@mai.ru', '', 'message', '2020-11-09 23:17:14', NULL),
	(43, '', 'tartar@mai.ru', '', 'message', '2020-11-09 23:18:00', NULL),
	(44, '', 'tartar@mai.ru', 'bad', 'message', '2020-11-09 23:18:00', NULL),
	(45, 'alex', 'tartar@mai.ru', 'bad', 'message', '2020-11-09 23:18:00', NULL),
	(46, 'alex', 'tartar@mai.ru', '', 'message', '2020-11-09 23:18:50', NULL),
	(47, '', 'tartar@mai.ru', '', 'message', '2020-11-09 23:18:50', NULL),
	(48, '', 'tartar@mai.ru', 'bad', 'message', '2020-11-09 23:18:50', 'asdasasdasd'),
	(49, 'alex', 'tartar@mai.ru', 'bad', 'message', '2020-11-09 23:18:50', 'asdasdasdasd'),
	(50, '', 'senator220291@gmail.com', '', 'asasdasd', '2020-11-10 00:57:06', 'asdasasdasd'),
	(51, 'dantes', 'azaza@tut.by', 'azaza', 'how much is the fish?', '2020-11-10 15:45:19', '200 br'),
	(52, '', 'alex222@tut.by', 'allert("h")', 'allert("hello")', '2020-11-16 09:55:08', 'ах ты, взломщик!!!!');
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

-- Дамп данных таблицы gym.trainer_applications: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `trainer_applications` DISABLE KEYS */;
REPLACE INTO `trainer_applications` (`user_id`, `app_institution`, `app_graduation`, `app_instagram`, `application_date`) VALUES
	(288, 'MGU', 2015, 'https://www.instagram.com/xzibit', '2020-09-29 11:10:54'),
	(284, 'БГУФК', 2013, 'https://www.instagram.com/senator2202', '2020-10-30 22:46:48'),
	(312, 'БГТУ', 2016, 'https://www.instagram.com/vitaliyklitschko', '2020-11-16 15:14:55'),
	(289, 'BSEU', 2012, 'https://www.instagram.com/mattdamonteam', '2020-11-16 15:17:58'),
	(263, 'RSFU', 2019, 'https://www.instagram.com/sarychevkirill', '2020-11-16 15:21:38'),
	(334, 'Кельнский Университет', 2009, 'https://www.instagram.com/bundeskanzlerin', '2020-11-16 15:22:40');
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
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.trainings: ~11 rows (приблизительно)
/*!40000 ALTER TABLE `trainings` DISABLE KEYS */;
REPLACE INTO `trainings` (`training_id`, `trainer_id`, `client_id`, `training_date`, `training_time`, `done`, `description`, `training_rating`) VALUES
	(9, 301, 284, '2020-10-25', '17:00:00', 1, 'Кардио разминка 10 мин, тяга грифа широким хватом сверху, тяга штанги в наклоне,  французский жим, подъем ног на пресс.', 5),
	(12, 301, 284, '2020-10-23', '12:00:00', 1, 'Пресс, бицепс, трицепс', 4),
	(13, 301, 284, '2020-11-05', '17:00:00', 1, 'Бег на дорожке 10 мин. Жим лежа 3 подхода на 12 повторений', 4),
	(14, 301, 303, '2020-10-25', '12:00:00', 1, 'Пресс, бицепс, трицепс', 3),
	(17, 301, 288, '2020-10-21', '12:00:00', 1, 'Кардио тренировка: бег на дорожке 20 мин, велотренажер 20 мин, степ тренажер 20 мин', 3),
	(23, 301, 343, '2020-10-24', '14:30:00', 1, 'Пока 2 кг не скинешь, из зала не выйдешь!!!!', 3),
	(27, 301, 284, '2020-11-21', '15:05:00', 0, 'Отжимания на брусьях, 5х15, разводка гантелей 4x10, пресс 2х20', 0),
	(28, 301, 284, '2020-11-02', '04:00:00', 1, 'бег на дорожке 10 мин;\r\nподтягивания с весом + 15 кг 4 подхода на максимум повторений;\r\nтяга штанги в наклоне 5 подходов по 8-10 повторений;\r\nгипер экстензии, 5 подходов по 12 повторений', 5),
	(38, 301, 284, '2020-11-20', '14:25:00', 0, 'Прыгать, бегать, отжиматься', 0),
	(40, 333, 284, '2020-11-22', '15:00:00', 0, 'Очень серьезный кач', 0),
	(42, 274, 284, '2020-11-19', '15:30:00', 0, 'Серьезный кач', 0),
	(45, 335, 284, '2020-11-22', '13:00:00', 0, NULL, 0),
	(46, 302, 284, '2020-11-23', '15:30:00', 0, NULL, 0),
	(47, 274, 284, '2020-11-24', '15:30:00', 0, NULL, 0),
	(48, 333, 284, '2020-11-25', '15:30:00', 0, NULL, 0),
	(49, 301, 261, '2020-11-19', '17:30:00', 0, 'Будем бегать и прыгать', 0),
	(50, 301, 258, '2020-11-20', '18:30:00', 0, NULL, 0),
	(51, 301, 341, '2020-11-20', '13:30:00', 0, NULL, 0),
	(52, 301, 313, '2020-11-20', '15:30:00', 0, NULL, 0),
	(53, 301, 339, '2020-11-21', '20:30:00', 0, NULL, 0),
	(54, 301, 277, '2020-11-21', '10:30:00', 0, NULL, 0),
	(55, 301, 282, '2020-11-21', '15:30:00', 0, NULL, 0),
	(56, 301, 280, '2020-11-22', '15:30:00', 0, NULL, 0),
	(57, 301, 286, '2020-11-22', '17:30:00', 0, NULL, 0),
	(58, 301, 353, '2020-11-22', '19:30:00', 0, NULL, 0),
	(59, 301, 341, '2020-11-23', '19:30:00', 0, NULL, 0),
	(60, 301, 278, '2020-11-23', '17:30:00', 0, NULL, 0),
	(61, 301, 276, '2020-11-23', '15:30:00', 0, NULL, 0),
	(62, 301, 345, '2020-11-24', '15:30:00', 0, NULL, 0),
	(63, 301, 281, '2020-11-24', '11:30:00', 0, NULL, 0),
	(64, 301, 269, '2020-11-25', '14:30:00', 0, NULL, 0),
	(65, 301, 340, '2020-11-25', '11:30:00', 0, NULL, 0),
	(66, 301, 274, '2020-11-25', '17:30:00', 0, NULL, 0),
	(67, 302, 284, '2020-11-26', '15:30:00', 0, NULL, 0),
	(68, 335, 284, '2020-11-26', '19:30:00', 0, NULL, 0),
	(69, 333, 284, '2020-11-27', '19:30:00', 0, NULL, 0);
/*!40000 ALTER TABLE `trainings` ENABLE KEYS */;

-- Дамп структуры для таблица gym.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int NOT NULL,
  `first_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `last_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `rating` double(22,1) DEFAULT '0.0',
  `institution` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `graduation` int DEFAULT NULL,
  `instagram` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `discount` double(22,1) DEFAULT '0.0',
  `image_name` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `money_balance` int DEFAULT '100',
  `bought_trainings` int DEFAULT '0',
  `short_summary` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id` (`user_id`),
  CONSTRAINT `FK_users_accounts` FOREIGN KEY (`user_id`) REFERENCES `accounts` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы gym.users: ~71 rows (приблизительно)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
REPLACE INTO `users` (`user_id`, `first_name`, `last_name`, `phone`, `rating`, `institution`, `graduation`, `instagram`, `discount`, `image_name`, `money_balance`, `bought_trainings`, `short_summary`) VALUES
	(243, '', '', '', NULL, NULL, NULL, NULL, 0.0, '/uploads/690a7d42-2122-4e1f-8baf-b9eba3cb881b.jpg', 100, 0, NULL),
	(254, 'Виталий', 'Кличко', '+375334569871', NULL, NULL, NULL, NULL, 0.0, NULL, 100, 0, NULL),
	(255, '', '', '', NULL, NULL, NULL, NULL, 0.0, '/uploads/690a7d42-2122-4e1f-8baf-b9eba3cb881b.jpg', 100, 0, NULL),
	(256, 'Бард', 'Симпсон', '', NULL, NULL, NULL, NULL, 0.0, NULL, 100, 0, NULL),
	(257, '', '', '', NULL, NULL, NULL, NULL, 0.0, '/uploads/690a7d42-2122-4e1f-8baf-b9eba3cb881b.jpg', 100, 0, NULL),
	(258, 'Лара', 'Крофт', '80445569878', NULL, NULL, NULL, NULL, 0.0, NULL, 100, 0, NULL),
	(259, '', '', '', NULL, NULL, NULL, NULL, 0.0, '/uploads/690a7d42-2122-4e1f-8baf-b9eba3cb881b.jpg', 100, 0, NULL),
	(260, 'Arkasha', 'Ukupnik', '80333456789', NULL, NULL, NULL, NULL, 0.0, NULL, 100, 0, NULL),
	(261, 'Джордж', 'Вашингтон', '+375336547896', NULL, NULL, NULL, NULL, 0.0, '/uploads/690a7d42-2122-4e1f-8baf-b9eba3cb881b.jpg', 100, 0, NULL),
	(262, '', '', '', NULL, NULL, NULL, NULL, 0.0, NULL, 100, 0, NULL),
	(263, 'Liza', 'Tailor', '+375332254478', NULL, NULL, NULL, NULL, 0.0, '/uploads/690a7d42-2122-4e1f-8baf-b9eba3cb881b.jpg', 100, 0, NULL),
	(264, '', '', '', NULL, NULL, NULL, NULL, 0.0, NULL, 100, 0, NULL),
	(265, 'Chuck', 'Norris', '+375336559898', NULL, NULL, NULL, NULL, 0.0, '/uploads/690a7d42-2122-4e1f-8baf-b9eba3cb881b.jpg', 100, 0, NULL),
	(266, '', '', '', NULL, NULL, NULL, NULL, 0.0, NULL, 100, 0, NULL),
	(267, 'Donald', 'Trump', '80296578931', NULL, NULL, NULL, NULL, 0.0, '/uploads/690a7d42-2122-4e1f-8baf-b9eba3cb881b.jpg', 100, 0, NULL),
	(268, '', '', '', NULL, NULL, NULL, NULL, 0.0, NULL, 100, 0, NULL),
	(269, 'Yellow', 'Submarine', '+375296395847', NULL, NULL, NULL, NULL, 0.0, '/uploads/690a7d42-2122-4e1f-8baf-b9eba3cb881b.jpg', 100, 0, NULL),
	(270, '', '', '', NULL, NULL, NULL, NULL, 0.0, NULL, 100, 0, NULL),
	(271, 'Magic', 'Five', '+357339966554', NULL, NULL, NULL, NULL, 0.0, '/uploads/690a7d42-2122-4e1f-8baf-b9eba3cb881b.jpg', 100, 0, NULL),
	(272, '', '', '', NULL, NULL, NULL, NULL, 0.0, NULL, 100, 0, NULL),
	(273, 'Бастурма', 'Шахиризадовна', '', NULL, NULL, NULL, NULL, 0.0, '/uploads/690a7d42-2122-4e1f-8baf-b9eba3cb881b.jpg', 100, 0, NULL),
	(274, 'Джек', 'Николсон', '+375296459988', 4.0, 'BSUFC', 2019, 'https://www.instagram.com/jacknicholsonofficial', 0.0, '/uploads/808234c5-92ae-4e41-9c6a-d69c3a325fb2.jpg', 100, 0, 'Спортивные достижения:\r\nМастер спорта по жиму лежа.\r\nЛичный девиз:\r\nЖизнь начинается за пределами твоей зоны комфорта'),
	(275, '', '', '', NULL, NULL, NULL, NULL, 0.0, '/uploads/690a7d42-2122-4e1f-8baf-b9eba3cb881b.jpg', 100, 0, NULL),
	(276, 'Катамаран', 'Василевский', '80296554468', NULL, NULL, NULL, NULL, 0.0, NULL, 100, 0, NULL),
	(277, 'Уилл', 'Брюсис', '', NULL, NULL, NULL, NULL, 0.0, '/uploads/690a7d42-2122-4e1f-8baf-b9eba3cb881b.jpg', 100, 0, NULL),
	(278, 'Лариса', 'Гузеева', '+375445552198', NULL, NULL, NULL, NULL, 0.0, NULL, 100, 0, NULL),
	(279, 'Барак', 'Обама', '+375296665522', NULL, NULL, NULL, NULL, 0.0, '/uploads/690a7d42-2122-4e1f-8baf-b9eba3cb881b.jpg', 100, 0, NULL),
	(280, 'Скотти', 'Пиппен', '', NULL, NULL, NULL, NULL, 0.0, NULL, 100, 0, NULL),
	(281, 'Бен', 'Аффлек', '', NULL, NULL, NULL, NULL, 0.0, '/uploads/c9574808-91aa-456f-ab11-af7fef3fc966.jpg', 100, 0, NULL),
	(282, 'Ярослава', 'Тринадцатко', '80175554466', NULL, NULL, NULL, NULL, 0.0, '/uploads/c2b2b6da-e2df-4e2b-a19b-d6d0aa397022.jpg', 100, 0, NULL),
	(283, 'Oleg', 'Beton', '', NULL, NULL, NULL, NULL, 0.0, '/uploads/bbf38f89-e040-436c-a798-690b77b6f738.jpg', 100, 0, NULL),
	(284, 'Александр', 'Шмюгельсон', '+375335678962', NULL, NULL, NULL, NULL, 12.0, '/uploads/3600b076-8a45-4564-bbc8-6b6eb52d2a85.png', 490, 23, NULL),
	(285, 'Екатерина', 'Шитикова', '+375336991236', 0.0, NULL, NULL, NULL, 0.0, '/uploads/913afcc5-f9ee-418f-a618-56d5c19bb843.jpg', 100, 0, NULL),
	(286, 'Олег', 'Бориков', '', 0.0, NULL, NULL, NULL, 0.0, '/uploads/777d9f5e-ccb5-4085-9f22-0e370ec09f95.jpg', 100, 0, NULL),
	(288, 'Chef', 'Ivlev', '80295554466', 0.0, NULL, NULL, NULL, 0.0, '/uploads/690a7d42-2122-4e1f-8baf-b9eba3cb881b.jpg', 100, 0, NULL),
	(289, 'Глеб', 'Балашевич', '', 0.0, NULL, NULL, NULL, 0.0, '/uploads/239bbd6b-3b1d-4bd5-b806-935cb79cad2d.png', 100, 0, NULL),
	(301, 'Anastacia', 'Lipinskaya', '+375441234598', 4.2, 'MSLU', 2012, 'https://www.instagram.com/monicabellucciofficiel', 0.0, '/uploads/161221b0-f018-4dae-b149-26a3a06fba34.jpg', 100, 0, 'Сертифицированный персональный тренер\r\n• Силовой тренинг\r\n• Функциональный тренинг\r\n• Снижение веса\r\n• Набор мышечной массы\r\n								'),
	(302, 'Аркадий', 'Райкин', '80296558891', 4.8, 'BSUIR', 2008, 'https://www.instagram.com/pavelbabich8', 0.0, '/uploads/65252e71-bdb1-4ec6-a199-ad06bb5ad5f2.jpg', 100, 0, 'Персональный тренер\r\nНаправление: Зона боевых искусств\r\nСургутский профессиональный колледж. '),
	(303, 'Bill', 'Perkins', '80291111111', 0.0, NULL, NULL, NULL, 0.0, '/uploads/197fce3c-e19b-421b-be12-491adc4b881d.jpg', 100, 0, NULL),
	(304, 'Perr', 'Billkins', '80292222222', 0.0, NULL, NULL, NULL, 0.0, '/uploads/94ce9ef4-1f5d-460e-9597-711be19d41af.jpg', 100, 0, NULL),
	(308, 'Peter', 'Parker', '', 0.0, NULL, NULL, NULL, 0.0, '/uploads/43f83b29-10a2-4f27-b32e-ce18bb62fc92.jpg', 100, 0, NULL),
	(309, 'Клинт', 'Иствуд', '+372644646464', 0.0, NULL, NULL, NULL, 0.0, '/uploads/19b8df2f-7e0e-4a08-86b3-d177f2662f2d.jpg', 100, 0, NULL),
	(312, 'Дон', 'Савеньон', '80172669988', 0.0, NULL, NULL, NULL, 6.5, '/uploads/11fefd33-6935-418a-9d06-385dcdf6c16f.png', 100, 0, NULL),
	(313, 'Энрике', 'Иглесиас', '', 0.0, NULL, NULL, NULL, 0.0, '/uploads/6f12d701-5f55-45a5-806f-5e56e7fe9f40.jpg', 100, 0, NULL),
	(314, 'Рэй', 'Чарльз', '80296558877', 0.0, NULL, NULL, NULL, 0.0, '/uploads/2f8d3fef-352f-47a0-97b6-1637a315aeb5.jpg', 100, 0, NULL),
	(315, 'Doctor', 'Watson', '+37500699887', 0.0, NULL, NULL, NULL, 0.0, '/uploads/1d982118-aa87-419c-b73f-43d07c049da2.jpg', 100, 0, NULL),
	(316, 'Jim', 'Carry', '', 0.0, NULL, NULL, NULL, 0.0, '/uploads/0f07a4e0-8281-4386-8bd8-b4b0123d90c1.jpg', 100, 0, NULL),
	(317, 'Евгений', 'Голубь', '+37544987798', 0.0, NULL, NULL, NULL, 0.0, '/uploads/e97467d3-004b-4e2f-a89e-e768f52ece70.jpg', 100, 0, NULL),
	(318, 'Sergei', 'Snatovich', '', 0.0, NULL, NULL, NULL, 0.0, '/uploads/e8dba640-5939-4ccf-a199-af97743189d8.jpg', 100, 0, NULL),
	(319, 'Lera', 'Kutumova', '', 0.0, NULL, NULL, NULL, 0.0, '/uploads/dfdbdb87-2139-4682-a789-4a1c3fae0380.jpg', 100, 0, NULL),
	(333, 'Михаил', 'Дуглас', '+375292223344', 3.9, 'BSUFC', 2017, 'https://www.instagram.com/l_one_mars/', 0.0, '/uploads/2449e660-c11e-4bd0-b2c7-23791e636c11.jpg', 100, 0, 'so-so'),
	(334, 'Валентин', 'Петуховский', '+375442316598', 0.0, NULL, NULL, NULL, 0.0, '/uploads/d3c00009-f81f-4c85-bad7-c1f4fe6dd9dc.jpg', 100, 0, NULL),
	(335, 'Elena', 'Vorobei', '+375299876543', 3.8, 'Envila', 2008, 'https://www.instagram.com/buzova86/', 0.0, '/uploads/429aab5d-6925-4131-a4de-11325b01314e.jpg', 100, 0, 'not bad '),
	(336, 'Самсон', 'Петрович', '+375297884412', 0.0, NULL, NULL, NULL, 0.0, '/uploads/c9574808-91aa-456f-ab11-af7fef3fc966.jpg', 100, 0, NULL),
	(337, 'Apple', 'Juice', '+375336778919', 0.0, NULL, NULL, NULL, 0.0, '/uploads/c2b2b6da-e2df-4e2b-a19b-d6d0aa397022.jpg', 100, 0, NULL),
	(338, 'Cherry', 'Tomato', '', 0.0, NULL, NULL, NULL, 0.0, '/uploads/64919dc8-fb88-49cc-bf58-0a31d8c66cd8.jpg', 100, 0, NULL),
	(339, 'Эдгар', 'Запашный', '80293336688', 0.0, NULL, NULL, NULL, 0.0, '/uploads/3600b076-8a45-4564-bbc8-6b6eb52d2a85.jpg', 100, 0, NULL),
	(340, 'Аскольд', 'Запашный', '', 0.0, NULL, NULL, NULL, 0.0, '/uploads/913afcc5-f9ee-418f-a618-56d5c19bb843.jpg', 100, 0, NULL),
	(341, 'Матвей', 'Занозин', '+375444366988', 0.0, NULL, NULL, NULL, 0.0, '/uploads/777d9f5e-ccb5-4085-9f22-0e370ec09f95.jpg', 100, 0, NULL),
	(342, 'Егор', 'Прокшин', '', 0.0, NULL, NULL, NULL, 0.0, '/uploads/690a7d42-2122-4e1f-8baf-b9eba3cb881b.jpg', 100, 0, NULL),
	(343, 'Абдурахман', 'Петрович', '80172306303', 0.0, NULL, NULL, NULL, 0.0, '/uploads/913afcc5-f9ee-418f-a618-56d5c19bb843.jpg', 173, 9, NULL),
	(344, 'Вадим', 'Галыгин', '', 0.0, NULL, NULL, NULL, 0.0, '/uploads/239bbd6b-3b1d-4bd5-b806-935cb79cad2d.png', 100, 0, NULL),
	(345, 'Дарья', 'Курто', '+375443654498', 0.0, NULL, NULL, NULL, 6.0, '/uploads/197fce3c-e19b-421b-be12-491adc4b881d.jpg', 100, 0, NULL),
	(346, 'Павел', 'Трушкевич', '+375176645533', 0.0, NULL, NULL, NULL, 0.0, '/uploads/94ce9ef4-1f5d-460e-9597-711be19d41af.jpg', 100, 0, NULL),
	(347, 'Daniil', 'Ishutin', '80334412536', 0.0, NULL, NULL, NULL, 27.0, '/uploads/43f83b29-10a2-4f27-b32e-ce18bb62fc92.png', 0, 4, NULL),
	(348, 'Alena', 'Apina', '+375446662233', 0.0, NULL, NULL, NULL, 7.5, '/uploads/11fefd33-6935-418a-9d06-385dcdf6c16f.png', 100, 0, NULL),
	(349, 'Prapor', 'Schmatko', '', 0.0, NULL, NULL, NULL, 0.0, '/uploads/9b510a77-d369-43fc-a0f4-6005efb1e4f2.jpg', 100, 0, NULL),
	(350, 'Ярик', 'Фонарик', '+375336447799', 0.0, NULL, NULL, NULL, 0.0, '/uploads/6f12d701-5f55-45a5-806f-5e56e7fe9f40.png', 100, 0, NULL),
	(351, 'Arnold', 'Kabachok', '80296665522', 0.0, NULL, NULL, NULL, 0.0, '/uploads/2f8d3fef-352f-47a0-97b6-1637a315aeb5.jpg', 100, 0, NULL),
	(352, 'Alex', 'Mahoney', '', 0.0, NULL, NULL, NULL, 0.0, '/uploads/1d982118-aa87-419c-b73f-43d07c049da2.png', 100, 0, NULL),
	(353, 'Джессика', 'Симпсон', '+355296665544', 0.0, NULL, NULL, NULL, 0.0, '/uploads/0f07a4e0-8281-4386-8bd8-b4b0123d90c1.jpg', 100, 0, NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
