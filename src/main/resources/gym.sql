-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.31-log - MySQL Community Server (GPL)
-- Операционная система:         Win32
-- HeidiSQL Версия:              11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных gym
DROP DATABASE IF EXISTS `gym`;
CREATE DATABASE IF NOT EXISTS `gym` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gym`;

-- Дамп структуры для таблица gym.account
DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `password` varbinary(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `role` enum('ADMIN','TRAINER','CLIENT') NOT NULL DEFAULT 'CLIENT',
  `registration_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.account: ~106 rows (приблизительно)
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
REPLACE INTO `account` (`id`, `name`, `password`, `email`, `role`, `registration_date`) VALUES
	(24, 'admin', _binary 0xF446EAAAED61385EEF431F06B26BA260, 'admin@gmail.com', 'ADMIN', '2020-09-07 13:30:30'),
	(25, 'trainer16399', _binary 0xFD06549BF6CC4609AE7F3E377E4EE065, 'email156446@gmail.com', 'TRAINER', '2020-09-07 13:32:07'),
	(26, 'trainer47708', _binary 0xB7BF5ECFF4D6F2EA0871B2D664D1848E, 'email73871@gmail.com', 'TRAINER', '2020-09-07 13:32:07'),
	(27, 'trainer54602', _binary 0x43583CD7B0DDFE2382B16E7F2465446C, 'email837729@gmail.com', 'TRAINER', '2020-09-07 13:32:08'),
	(28, 'trainer46413', _binary 0xA699682CE0ED54009DD39D94512DBFAA, 'email587605@gmail.com', 'TRAINER', '2020-09-07 13:32:08'),
	(29, 'client34524', _binary 0x572816BAD18A9DF4C2F2D7EDDC9E3F42, 'email564721@gmail.com', 'CLIENT', '2020-09-07 13:32:51'),
	(30, 'client74942', _binary 0x4AF4DECCCE2A207DD699A126A7CDBE06, 'email545260@gmail.com', 'CLIENT', '2020-09-07 13:32:52'),
	(31, 'client48574', _binary 0xDDCAB30D7BCDE9C4C3DAF947A54243DF, 'email635093@gmail.com', 'CLIENT', '2020-09-07 13:32:53'),
	(32, 'client78757', _binary 0xECC4E6D590365CB2430597B77F93EBF3, 'email689299@gmail.com', 'CLIENT', '2020-09-07 13:32:53'),
	(33, 'client2275', _binary 0xB0147F2D3A4F3B7E0B95567836026B5D, 'email882504@gmail.com', 'CLIENT', '2020-09-07 13:32:53'),
	(34, 'client75521', _binary 0x1CF2E147D147A70A3285B02A29D3FDBF, 'email685745@gmail.com', 'CLIENT', '2020-09-07 13:33:43'),
	(35, 'client50081', _binary 0xEEA216E72CCD6CA6856912A4EBC1DF58, 'email560087@gmail.com', 'CLIENT', '2020-09-07 13:33:43'),
	(36, 'client82095', _binary 0xFBA8D70E31D6AE8005EB075657BA7801, 'email68787@gmail.com', 'CLIENT', '2020-09-07 13:33:43'),
	(37, 'client66153', _binary 0xE3F6A16595648CD0706D6803E9691D2D, 'email592000@gmail.com', 'CLIENT', '2020-09-07 13:33:43'),
	(38, 'client60557', _binary 0x2EAB738AE82A52EE379651EDEB7CB083, 'email950190@gmail.com', 'CLIENT', '2020-09-07 13:33:43'),
	(39, 'client20973', _binary 0x150599D25CF39968A4674FBE93A3F55E, 'email960265@gmail.com', 'CLIENT', '2020-09-07 13:35:18'),
	(40, 'client11026', _binary 0xF5709C47B9226E748B36D4431C05C77C, 'email237234@gmail.com', 'CLIENT', '2020-09-07 13:35:39'),
	(41, 'client13330', _binary 0x9F4576B2537CA608FA96E4C9AE852241, 'email953672@gmail.com', 'CLIENT', '2020-09-07 13:35:40'),
	(42, 'client24084', _binary 0x3DF90D62CAB3D280A14A1144ADBA1AD8, 'email439424@gmail.com', 'CLIENT', '2020-09-07 13:35:41'),
	(43, 'client9307', _binary 0x7DB93943235DF83C0449E7B1CCDF73AE, 'email760424@gmail.com', 'CLIENT', '2020-09-07 13:35:42'),
	(44, 'client69634', _binary 0x8D869E095A5C2BF5A3787016BDB675FE, 'email626720@gmail.com', 'CLIENT', '2020-09-07 13:36:17'),
	(45, 'client42551', _binary 0xD34CE73ABF31B142C98F6F17AC545BF8, 'email328898@gmail.com', 'CLIENT', '2020-09-07 13:36:18'),
	(46, 'client16502', _binary 0x5425A130A94F0EA8DF593E5E4DCDFA95, 'email335891@gmail.com', 'CLIENT', '2020-09-07 13:36:19'),
	(47, 'client75700', _binary 0xD0EFEBC8E90AAD2099BC6D26E90489C3, 'email423938@gmail.com', 'CLIENT', '2020-09-07 13:36:19'),
	(48, 'client56044', _binary 0xB0E6806D32C8E8E0DAA80B803F387B5B, 'email315236@gmail.com', 'CLIENT', '2020-09-07 13:36:50'),
	(49, 'client7299', _binary 0xD1D04179655063E6FC05F0B1B8C6D636, 'email238396@gmail.com', 'CLIENT', '2020-09-07 13:37:27'),
	(50, 'client35850', _binary 0xFD6EDCB7713994639AE14F0B8EB46C24, 'email515953@gmail.com', 'CLIENT', '2020-09-07 13:37:27'),
	(51, 'client19782', _binary 0xB625F7AB0FFD420B2D6E5DE453BE00AF, 'email666491@gmail.com', 'CLIENT', '2020-09-07 13:37:28'),
	(52, 'client69623', _binary 0x2D970D5F4641DCA226369C535EF33E47, 'email149951@gmail.com', 'CLIENT', '2020-09-07 13:37:28'),
	(53, 'client86140', _binary 0x35F3F5C1822836BD979ECC621195C5D0, 'email415441@gmail.com', 'CLIENT', '2020-09-07 13:37:29'),
	(54, 'client15549', _binary 0x339A2FF780476E5F2C1ADDCB43A2D3C3, 'email960004@gmail.com', 'CLIENT', '2020-09-07 13:38:14'),
	(55, 'client16130', _binary 0x109E41A297D1BBB5512594698086B5A9, 'email222171@gmail.com', 'CLIENT', '2020-09-07 13:38:15'),
	(56, 'client7837', _binary 0x8CECD5493B770D7EA6B5A355B6085AC6, 'email538481@gmail.com', 'CLIENT', '2020-09-07 13:38:16'),
	(57, 'client22362', _binary 0x7C9F2EF86586ADB761EC299D54198BAF, 'email257470@gmail.com', 'CLIENT', '2020-09-07 13:38:17'),
	(58, 'client75511', _binary 0xC41E61E210EA8B9D7C9CDCAC632AAA6A, 'email256085@gmail.com', 'CLIENT', '2020-09-07 13:38:46'),
	(59, 'client86848', _binary 0x237EE906527DE49A7AB9A60C04E97A02, 'email328594@gmail.com', 'CLIENT', '2020-09-07 13:40:58'),
	(60, 'client13661', _binary 0xB8A59C3F5C1CFC4C5B9D8C3E76BFC265, 'email910382@gmail.com', 'CLIENT', '2020-09-07 13:40:59'),
	(61, 'client32485', _binary 0xA35C4E55681BFFC7056A80CA05E6475A, 'email602445@gmail.com', 'CLIENT', '2020-09-07 13:41:00'),
	(62, 'client17419', _binary 0x47015AC723C7514C9DB2F9F44EA82A13, 'email723190@gmail.com', 'CLIENT', '2020-09-07 13:41:01'),
	(63, 'client46842', _binary 0x61AD4CC4F71BBDA0AC970771BD522A45, 'email270941@gmail.com', 'CLIENT', '2020-09-07 13:41:01'),
	(64, 'client79304', _binary 0x848A264EE79C5A96581BD8E7B1A946A8, 'email415040@gmail.com', 'CLIENT', '2020-09-07 13:44:57'),
	(65, 'client634', _binary 0x90E4189BEF00FE1347D4A34B9507632F, 'email237197@gmail.com', 'CLIENT', '2020-09-07 13:44:57'),
	(66, 'client94137', _binary 0xB990AA02FCB14D8D185E59F463279DA7, 'email595461@gmail.com', 'CLIENT', '2020-09-07 13:44:57'),
	(67, 'client18201', _binary 0xF36F4634C0282824800C8CC1E60407F7, 'email194822@gmail.com', 'CLIENT', '2020-09-07 13:44:58'),
	(68, 'client2652', _binary 0xC0E386CE7DACCAE6FC2137DBA3A7E10C, 'email736426@gmail.com', 'CLIENT', '2020-09-07 13:44:58'),
	(69, 'client24555', _binary 0xE02D8DB3D8DA180AF8C0F051A1988FA0, 'email710382@gmail.com', 'CLIENT', '2020-09-07 13:49:44'),
	(70, 'client83000', _binary 0x7F374F0B1726848C6EC87C004F5F1224, 'email540302@gmail.com', 'CLIENT', '2020-09-07 13:49:45'),
	(71, 'client12343', _binary 0xE050E94D846F3BCEF298C6105D7C5B4E, 'email268906@gmail.com', 'CLIENT', '2020-09-07 13:49:45'),
	(72, 'client27196', _binary 0x39E1717775C61FC247970516C7C8F836, 'email34753@gmail.com', 'CLIENT', '2020-09-07 13:49:46'),
	(73, 'client28801', _binary 0xECC8CFFE0B18E085EEAF281A26796507, 'email557206@gmail.com', 'CLIENT', '2020-09-07 13:49:47'),
	(74, 'client74272', _binary 0x08A8881B929A2E809003B97DB8650BAC, 'email42924@gmail.com', 'CLIENT', '2020-09-07 14:00:50'),
	(75, 'client52617', _binary 0x3FDE5B164169993CB2C13B939D8B43AC, 'email587842@gmail.com', 'CLIENT', '2020-09-07 14:00:51'),
	(76, 'client25340', _binary 0x0FF8FD550254D0DDCAF4758A61F3C8B5, 'email144130@gmail.com', 'CLIENT', '2020-09-07 14:00:54'),
	(77, 'client67391', _binary 0x1774716442E2B3F5D9EF76941E518B7F, 'email137787@gmail.com', 'CLIENT', '2020-09-07 14:00:58'),
	(78, 'client89397', _binary 0x231C5CA21655B0104FBC7FE94014AF93, 'email441943@gmail.com', 'CLIENT', '2020-09-07 14:01:19'),
	(79, 'client87709', _binary 0xC9E749988028E53061A18272220A9F4F, 'email704218@gmail.com', 'CLIENT', '2020-09-07 14:04:09'),
	(80, 'client37987', _binary 0xDB78C09C2DADF166F593E5F07D451D8B, 'email82857@gmail.com', 'CLIENT', '2020-09-07 14:08:16'),
	(81, 'client87177', _binary 0x9AEEDC178E4506E5870FD6D486220E2F, 'email786260@gmail.com', 'CLIENT', '2020-09-07 14:08:25'),
	(82, 'client6209', _binary 0x89F00E1EC24B52D5824BABF000A1D174, 'email325135@gmail.com', 'CLIENT', '2020-09-07 14:08:25'),
	(83, 'client93223', _binary 0x124CB1B7D28817A9B04A4A6F7715BE46, 'email889731@gmail.com', 'CLIENT', '2020-09-07 14:08:26'),
	(84, 'client41858', _binary 0x1D5E21E71B1336857D1ED570B46B786C, 'email374111@gmail.com', 'CLIENT', '2020-09-07 14:10:35'),
	(85, 'client66116', _binary 0xA59810B1A2AD476F00FC9B1026821E29, 'email174109@gmail.com', 'CLIENT', '2020-09-07 14:13:10'),
	(86, 'client95823', _binary 0x1C071258F97F9265D7BCD15A88AAD93E, 'email864269@gmail.com', 'CLIENT', '2020-09-07 14:19:24'),
	(87, 'client12279', _binary 0x290C9D977BA1A9560720DBB44C533487, 'email539885@gmail.com', 'CLIENT', '2020-09-07 14:19:58'),
	(88, 'client26146', _binary 0xE050E94D846F3BCEF298C6105D7C5B4E, 'email842035@gmail.com', 'CLIENT', '2020-09-07 14:19:58'),
	(89, 'client99661', _binary 0x3C3E7FC4E8489F6AA9E0D135DA504DF9, 'email162959@gmail.com', 'CLIENT', '2020-09-07 14:19:59'),
	(90, 'client24909', _binary 0x12E6093A5E7859DF78D01AB70A5DF617, 'email923199@gmail.com', 'CLIENT', '2020-09-07 14:19:59'),
	(91, 'client25776', _binary 0x5CF3A5260F2F828F27B814D3943DBE12, 'email235441@gmail.com', 'CLIENT', '2020-09-07 14:19:59'),
	(92, 'client81357', _binary 0x4D4D089212706DE2646B9182E9FDB76B, 'email323625@gmail.com', 'CLIENT', '2020-09-07 14:22:25'),
	(93, 'client38759', _binary 0x574746DB808BBEB2882C268052D61D9C, 'email710276@gmail.com', 'CLIENT', '2020-09-07 14:22:40'),
	(94, 'client63532', _binary 0x857F6EE30891773133E26CE7CB00E297, 'email561197@gmail.com', 'CLIENT', '2020-09-07 14:24:55'),
	(95, 'client63261', _binary 0x652A4F32B02F9C042BEDE97D07B83221, 'email901865@gmail.com', 'CLIENT', '2020-09-07 14:26:05'),
	(96, 'client76294', _binary 0xCCA89A31C8B2202B6970CFBA5A674D02, 'email134073@gmail.com', 'CLIENT', '2020-09-07 14:26:15'),
	(97, 'client52717', _binary 0xB0E6806D32C8E8E0DAA80B803F387B5B, 'email809772@gmail.com', 'CLIENT', '2020-09-07 14:26:16'),
	(98, 'client18713', _binary 0x9FEF464251C2B9F6B897C0FC95E1D20D, 'email626753@gmail.com', 'CLIENT', '2020-09-07 14:28:50'),
	(99, 'client82580', _binary 0x7005D08C4251CB4855391E7313B37695, 'email907363@gmail.com', 'CLIENT', '2020-09-07 14:29:49'),
	(100, 'client1723', _binary 0xD1D04179655063E6FC05F0B1B8C6D636, 'email204064@gmail.com', 'CLIENT', '2020-09-07 14:30:20'),
	(101, 'client20994', _binary 0x90158F195F487C6888715C2438FB7453, 'email351093@gmail.com', 'CLIENT', '2020-09-07 14:32:35'),
	(102, 'client32413', _binary 0x2E986F5D6416C127D3BE86B03D885AAD, 'email579817@gmail.com', 'CLIENT', '2020-09-07 14:33:22'),
	(103, 'client55671', _binary 0xA5B9B1E7DF42B8EF6A7D50AEA0678BFA, 'email667532@gmail.com', 'CLIENT', '2020-09-07 14:36:34'),
	(104, 'client20771', _binary 0xDDCBF8AE2893A2DEF186796418A7BCB4, 'email224873@gmail.com', 'CLIENT', '2020-09-07 14:38:05'),
	(105, 'client16413', _binary 0x08265C69090BEFE2C9FFB88193F830B4, 'email633377@gmail.com', 'CLIENT', '2020-09-07 14:39:08'),
	(106, 'client75486', _binary 0xB0E6806D32C8E8E0DAA80B803F387B5B, 'email304987@gmail.com', 'CLIENT', '2020-09-07 14:39:08'),
	(107, 'client10830', _binary 0xFFA0E87DADEDFB95A2F198C2D54F3287, 'email951357@gmail.com', 'CLIENT', '2020-09-07 14:39:08'),
	(108, 'client79504', _binary 0x2362AECA15365B1A12B9C50F7112612A, 'email7528@gmail.com', 'CLIENT', '2020-09-07 14:39:10'),
	(109, 'client23121', _binary 0x1DEB7BFBD7EE86BA18D0CF13E3152F29, 'email524939@gmail.com', 'CLIENT', '2020-09-07 14:39:10'),
	(110, 'client37697', _binary 0xF36E383734879E710DD9CBFE06D02660, 'email653280@gmail.com', 'CLIENT', '2020-09-07 14:39:10'),
	(111, 'client26415', _binary 0xF537883402946CEFA95624BB8E35AEE4, 'email876356@gmail.com', 'CLIENT', '2020-09-07 14:39:45'),
	(112, 'client47887', _binary 0x1BC5970749EFD6169E19FAAE6CAAB14F, 'email429036@gmail.com', 'CLIENT', '2020-09-07 14:42:12'),
	(113, 'trainer7499', _binary 0xA2D1872CBF2D904CFFF2BB9D921C57AC, 'email212726@gmail.com', 'TRAINER', '2020-09-07 15:44:51'),
	(114, 'trainer60966', _binary 0x3F4F62968282096AE6AFB70C1B514125, 'email760416@gmail.com', 'TRAINER', '2020-09-07 15:48:19'),
	(115, 'trainer87245', _binary 0xA374A153E8257465B3BFD6119781FAF5, 'email342875@gmail.com', 'TRAINER', '2020-09-07 15:49:17'),
	(116, 'trainer99032', _binary 0xE395B8A2720DD0E1D9208DD6D2B99862, 'email925020@gmail.com', 'TRAINER', '2020-09-07 15:49:20'),
	(117, 'trainer46999', _binary 0xEB5652E222FF7FA87113CF3F93C94AA6, 'email322419@gmail.com', 'TRAINER', '2020-09-07 15:49:21'),
	(118, 'trainer96325', _binary 0x869DDA0AF3AC700CFD572DEE89DE51B5, 'email798120@gmail.com', 'TRAINER', '2020-09-07 15:49:32'),
	(119, 'client45743', _binary 0xD521B029C00AB523CD10B5B133F8F2CD, 'email253624@gmail.com', 'CLIENT', '2020-09-07 15:57:07'),
	(120, 'client9290', _binary 0x65A63AEAC0A8BCBEBFA508EB387E90AE, 'email269519@gmail.com', 'CLIENT', '2020-09-07 15:57:08'),
	(121, 'client78722', _binary 0xA93E39CC8FBD2D586846A9864654B8CC, 'email26263@gmail.com', 'CLIENT', '2020-09-07 15:57:08'),
	(122, 'client37714', _binary 0x3E1A0A2F00F1622DACF48FF75ACD846F, 'email674085@gmail.com', 'CLIENT', '2020-09-07 15:57:08'),
	(123, 'client87368', _binary 0x920EEE84E13E7C95C54D0E5B845D8A95, 'email289081@gmail.com', 'CLIENT', '2020-09-07 15:57:08'),
	(124, 'client90446', _binary 0x8779E1365BF03FAD4F83E51F701FEA0C, 'email248575@gmail.com', 'CLIENT', '2020-09-07 15:57:08'),
	(125, 'client64712', _binary 0x2362AECA15365B1A12B9C50F7112612A, 'email805958@gmail.com', 'CLIENT', '2020-09-07 15:57:08'),
	(126, 'client30759', _binary 0x5D83D02D9C5D5CAA8084D25920612816, 'email802667@gmail.com', 'CLIENT', '2020-09-07 15:57:09'),
	(127, 'client43128', _binary 0xD6EB8F38B7C22C5EA65E41B0F95DC65E, 'email431270@gmail.com', 'CLIENT', '2020-09-07 15:57:09'),
	(128, 'client12887', _binary 0xF4654046A33548B0B884859BC22A8DCE, 'email467597@gmail.com', 'CLIENT', '2020-09-07 15:57:09');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;

-- Дамп структуры для таблица gym.client
DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `account_id` int(11) NOT NULL,
  `discount` double(22,0) DEFAULT '0',
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `account_id` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.client: ~79 rows (приблизительно)
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
REPLACE INTO `client` (`account_id`, `discount`) VALUES
	(29, 0),
	(30, 0),
	(31, 0),
	(32, 0),
	(33, 0),
	(34, 0),
	(35, 0),
	(36, 0),
	(37, 0),
	(38, 0),
	(39, 0),
	(40, 0),
	(41, 0),
	(42, 0),
	(43, 0),
	(44, 0),
	(45, 0),
	(46, 0),
	(47, 0),
	(49, 0),
	(50, 0),
	(51, 0),
	(52, 0),
	(53, 0),
	(54, 0),
	(55, 0),
	(56, 0),
	(57, 0),
	(58, 0),
	(59, 0),
	(60, 0),
	(61, 0),
	(62, 0),
	(63, 0),
	(64, 0),
	(65, 0),
	(66, 0),
	(67, 0),
	(68, 0),
	(69, 0),
	(70, 0),
	(71, 0),
	(72, 0),
	(73, 0),
	(74, 0),
	(75, 0),
	(76, 0),
	(77, 0),
	(78, 0),
	(79, 0),
	(80, 0),
	(81, 0),
	(82, 0),
	(83, 0),
	(84, 0),
	(85, 0),
	(87, 0),
	(88, 0),
	(89, 0),
	(90, 0),
	(91, 0),
	(92, 0),
	(93, 0),
	(94, 0),
	(96, 0),
	(98, 0),
	(99, 0),
	(100, 0),
	(102, 0),
	(103, 0),
	(105, 0),
	(106, 0),
	(107, 0),
	(108, 0),
	(109, 0),
	(110, 0),
	(111, 0),
	(119, 0),
	(120, 0),
	(121, 0),
	(122, 0),
	(123, 0),
	(124, 0),
	(125, 0),
	(126, 0),
	(127, 0),
	(128, 0);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Дамп структуры для таблица gym.trainer
DROP TABLE IF EXISTS `trainer`;
CREATE TABLE IF NOT EXISTS `trainer` (
  `account_id` int(11) NOT NULL,
  `rating` double(22,0) DEFAULT '0',
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `account_id` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.trainer: ~8 rows (приблизительно)
/*!40000 ALTER TABLE `trainer` DISABLE KEYS */;
REPLACE INTO `trainer` (`account_id`, `rating`) VALUES
	(25, 0),
	(26, 0),
	(27, 0),
	(28, 0),
	(113, 0),
	(115, 0),
	(116, 0),
	(117, 0);
/*!40000 ALTER TABLE `trainer` ENABLE KEYS */;

-- Дамп структуры для таблица gym.training
DROP TABLE IF EXISTS `training`;
CREATE TABLE IF NOT EXISTS `training` (
  `id` int(11) NOT NULL,
  `trainer_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `cost` double NOT NULL DEFAULT '0',
  `date` date NOT NULL,
  `start` time NOT NULL,
  `end` time NOT NULL,
  `bought` tinyint(4) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.training: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `training` DISABLE KEYS */;
/*!40000 ALTER TABLE `training` ENABLE KEYS */;

-- Дамп структуры для таблица gym.training_exercise
DROP TABLE IF EXISTS `training_exercise`;
CREATE TABLE IF NOT EXISTS `training_exercise` (
  `training_id` int(11) NOT NULL,
  `type` enum('BENCH_PRESS','DEADLIFT','SQUATS') NOT NULL,
  `weight` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.training_exercise: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `training_exercise` DISABLE KEYS */;
/*!40000 ALTER TABLE `training_exercise` ENABLE KEYS */;

-- Дамп структуры для таблица gym.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `account_id` int(11) NOT NULL,
  `first_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `last_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `phone` varchar(30) DEFAULT '',
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `account_id` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы gym.user: ~98 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`account_id`, `first_name`, `last_name`, `phone`) VALUES
	(24, 'Алексей', 'Харитонов', '+375296984636'),
	(25, '', '', ''),
	(26, '', '', ''),
	(27, '', '', ''),
	(28, '', '', ''),
	(29, '', '', ''),
	(30, '', '', ''),
	(31, '', '', ''),
	(32, '', '', ''),
	(33, '', '', ''),
	(34, '', '', ''),
	(35, '', '', ''),
	(36, '', '', ''),
	(37, '', '', ''),
	(38, '', '', ''),
	(39, '', '', ''),
	(40, '', '', ''),
	(41, '', '', ''),
	(42, '', '', ''),
	(43, '', '', ''),
	(44, '', '', ''),
	(45, '', '', ''),
	(46, '', '', ''),
	(47, '', '', ''),
	(49, '', '', ''),
	(50, '', '', ''),
	(51, '', '', ''),
	(52, '', '', ''),
	(53, '', '', ''),
	(54, '', '', ''),
	(55, '', '', ''),
	(56, '', '', ''),
	(57, '', '', ''),
	(58, '', '', ''),
	(59, '', '', ''),
	(60, '', '', ''),
	(61, '', '', ''),
	(62, '', '', ''),
	(63, '', '', ''),
	(64, '', '', ''),
	(65, '', '', ''),
	(66, '', '', ''),
	(67, '', '', ''),
	(68, '', '', ''),
	(69, '', '', ''),
	(70, '', '', ''),
	(71, '', '', ''),
	(72, '', '', ''),
	(73, '', '', ''),
	(74, '', '', ''),
	(75, '', '', ''),
	(76, '', '', ''),
	(77, '', '', ''),
	(78, '', '', ''),
	(79, '', '', ''),
	(80, '', '', ''),
	(81, '', '', ''),
	(82, '', '', ''),
	(83, '', '', ''),
	(84, '', '', ''),
	(85, '', '', ''),
	(87, '', '', ''),
	(88, '', '', ''),
	(89, '', '', ''),
	(90, '', '', ''),
	(91, '', '', ''),
	(92, '', '', ''),
	(93, '', '', ''),
	(94, '', '', ''),
	(96, '', '', ''),
	(98, '', '', ''),
	(99, '', '', ''),
	(100, '', '', ''),
	(102, '', '', ''),
	(103, '', '', ''),
	(105, '', '', ''),
	(106, '', '', ''),
	(107, '', '', ''),
	(108, '', '', ''),
	(109, '', '', ''),
	(110, '', '', ''),
	(111, '', '', ''),
	(112, '', '', ''),
	(113, '', '', ''),
	(115, '', '', ''),
	(116, '', '', ''),
	(117, '', '', ''),
	(119, '', '', ''),
	(120, '', '', ''),
	(121, '', '', ''),
	(122, '', '', ''),
	(123, '', '', ''),
	(124, '', '', ''),
	(125, '', '', ''),
	(126, '', '', ''),
	(127, '', '', ''),
	(128, '', '', '');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
