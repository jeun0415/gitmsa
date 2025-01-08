-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        11.6.2-MariaDB-ubu2404 - mariadb.org binary distribution
-- 서버 OS:                        debian-linux-gnu
-- HeidiSQL 버전:                  12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- calendar 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `calendar` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci */;
USE `calendar`;

-- 테이블 calendar.calendar 구조 내보내기
CREATE TABLE IF NOT EXISTS `calendar` (
  `cal_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `u_idx` bigint(20) NOT NULL,
  `c_theme` enum('DARK','HYS','JHI','LIGHT') NOT NULL,
  PRIMARY KEY (`cal_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- 테이블 데이터 calendar.calendar:~3 rows (대략적) 내보내기
DELETE FROM `calendar`;
INSERT INTO `calendar` (`cal_idx`, `u_idx`, `c_theme`) VALUES
	(1, 1, 'LIGHT'),
	(2, 2, 'LIGHT'),
	(3, 3, 'LIGHT');

-- 테이블 calendar.comments 구조 내보내기
CREATE TABLE IF NOT EXISTS `comments` (
  `com_date_time` datetime(6) NOT NULL,
  `com_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `sh_idx` bigint(20) DEFAULT NULL,
  `u_idx` bigint(20) DEFAULT NULL,
  `com_content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`com_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- 테이블 데이터 calendar.comments:~0 rows (대략적) 내보내기
DELETE FROM `comments`;

-- 테이블 calendar.diary 구조 내보내기
CREATE TABLE IF NOT EXISTS `diary` (
  `d_date` date NOT NULL,
  `cal_idx` bigint(20) NOT NULL,
  `d_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `d_content` text DEFAULT NULL,
  `d_title` varchar(255) NOT NULL,
  `d_category` enum('DAILY','ETC','EXERCISE','GROWTH','TRIP') NOT NULL,
  `d_share` enum('ALL','CHOOSE','NONE') NOT NULL,
  PRIMARY KEY (`d_idx`),
  KEY `FKeifvy8qqym6a5840njr5t0mjf` (`cal_idx`),
  CONSTRAINT `FKeifvy8qqym6a5840njr5t0mjf` FOREIGN KEY (`cal_idx`) REFERENCES `calendar` (`cal_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- 테이블 데이터 calendar.diary:~4 rows (대략적) 내보내기
DELETE FROM `diary`;
INSERT INTO `diary` (`d_date`, `cal_idx`, `d_idx`, `d_content`, `d_title`, `d_category`, `d_share`) VALUES
	('2024-12-27', 1, 1, 'g', 'aaa', 'EXERCISE', 'ALL'),
	('2024-12-27', 2, 2, 'fd', 'bbb', 'GROWTH', 'CHOOSE'),
	('2024-12-27', 1, 6, 'string', 'string', 'DAILY', 'ALL'),
	('2024-12-27', 1, 7, 'ㅎㅇ', 'ㅎㅇㅎㅇ', 'DAILY', 'CHOOSE');

-- 테이블 calendar.diary_image 구조 내보내기
CREATE TABLE IF NOT EXISTS `diary_image` (
  `d_idx` bigint(20) NOT NULL,
  `i_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `img_name` varchar(255) NOT NULL,
  `img_url` varchar(255) NOT NULL,
  `ori_img_name` varchar(255) NOT NULL,
  PRIMARY KEY (`i_idx`),
  KEY `FKcn7i19m8gixmxlwwr073aasjj` (`d_idx`),
  CONSTRAINT `FKcn7i19m8gixmxlwwr073aasjj` FOREIGN KEY (`d_idx`) REFERENCES `diary` (`d_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- 테이블 데이터 calendar.diary_image:~0 rows (대략적) 내보내기
DELETE FROM `diary_image`;

-- 테이블 calendar.schedule 구조 내보내기
CREATE TABLE IF NOT EXISTS `schedule` (
  `repeat_end_date` date DEFAULT NULL,
  `cal_idx` bigint(20) NOT NULL,
  `repeat_group_id` bigint(20) NOT NULL,
  `s_end` datetime(6) NOT NULL,
  `s_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `s_start` datetime(6) NOT NULL,
  `s_content` text DEFAULT NULL,
  `s_location` varchar(255) DEFAULT NULL,
  `s_title` varchar(255) NOT NULL,
  `repeat_type` enum('DAILY','MONTHLY','NONE','WEEKLY','YEARLY') NOT NULL,
  `s_color` enum('BLUE','GRAY','GREEN','ORANGE','PINK','VIOLET','YELLOW') NOT NULL,
  `s_share` enum('ALL','CHOOSE','NONE') NOT NULL,
  PRIMARY KEY (`s_idx`),
  KEY `FK77uvqgyekpsxa4bbon2l8d30a` (`cal_idx`),
  CONSTRAINT `FK77uvqgyekpsxa4bbon2l8d30a` FOREIGN KEY (`cal_idx`) REFERENCES `calendar` (`cal_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- 테이블 데이터 calendar.schedule:~1 rows (대략적) 내보내기
DELETE FROM `schedule`;
INSERT INTO `schedule` (`repeat_end_date`, `cal_idx`, `repeat_group_id`, `s_end`, `s_idx`, `s_start`, `s_content`, `s_location`, `s_title`, `repeat_type`, `s_color`, `s_share`) VALUES
	(NULL, 1, 5, '2024-12-27 09:55:49.000000', 1, '2024-12-27 09:55:48.000000', 'ewf', NULL, 'aaaaa', 'NONE', 'GREEN', 'ALL');

-- 테이블 calendar.schedule_image 구조 내보내기
CREATE TABLE IF NOT EXISTS `schedule_image` (
  `i_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `s_idx` bigint(20) NOT NULL,
  `img_name` varchar(255) NOT NULL,
  `img_url` varchar(255) NOT NULL,
  `ori_img_name` varchar(255) NOT NULL,
  PRIMARY KEY (`i_idx`),
  KEY `FK8mk6tio7ryykmw7i8a6v3o727` (`s_idx`),
  CONSTRAINT `FK8mk6tio7ryykmw7i8a6v3o727` FOREIGN KEY (`s_idx`) REFERENCES `schedule` (`s_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- 테이블 데이터 calendar.schedule_image:~0 rows (대략적) 내보내기
DELETE FROM `schedule_image`;

-- 테이블 calendar.shared 구조 내보내기
CREATE TABLE IF NOT EXISTS `shared` (
  `d_idx` bigint(20) DEFAULT NULL,
  `friend_idx` bigint(20) DEFAULT NULL,
  `s_idx` bigint(20) DEFAULT NULL,
  `sh_date_time` datetime(6) NOT NULL,
  `sh_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`sh_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- 테이블 데이터 calendar.shared:~5 rows (대략적) 내보내기
DELETE FROM `shared`;
INSERT INTO `shared` (`d_idx`, `friend_idx`, `s_idx`, `sh_date_time`, `sh_idx`) VALUES
	(NULL, NULL, 1, '2024-12-27 09:57:32.000000', 1),
	(1, NULL, NULL, '2024-12-27 09:57:43.000000', 2),
	(2, 3, NULL, '2024-12-27 09:57:53.000000', 3),
	(6, 0, NULL, '2024-12-27 10:04:55.015247', 7),
	(7, 3, NULL, '2024-12-27 17:21:21.681839', 9);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
