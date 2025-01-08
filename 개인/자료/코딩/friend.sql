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


-- friends 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `friends` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci */;
USE `friends`;

-- 테이블 friends.calendars 구조 내보내기
CREATE TABLE IF NOT EXISTS `calendars` (
  `cal_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `u_idx2` bigint(20) DEFAULT NULL,
  `c_theme` enum('DARK','HYS','JHI','LIGHT') NOT NULL,
  PRIMARY KEY (`cal_idx`),
  UNIQUE KEY `UKb9nk15i11dgijtykgm17ol12k` (`u_idx2`),
  CONSTRAINT `FK5i41cq0ygdjm9o9w6c0srw8nm` FOREIGN KEY (`u_idx2`) REFERENCES `user` (`u_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- 테이블 데이터 friends.calendars:~0 rows (대략적) 내보내기
DELETE FROM `calendars`;

-- 테이블 friends.diary 구조 내보내기
CREATE TABLE IF NOT EXISTS `diary` (
  `d_date` date NOT NULL,
  `cal_idx` bigint(20) NOT NULL,
  `d_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `d_content` text DEFAULT NULL,
  `d_title` varchar(255) NOT NULL,
  `d_category` enum('DAILY','ETC','EXERCISE','GROWTH','TRIP') NOT NULL,
  PRIMARY KEY (`d_idx`),
  KEY `FKkuc63i71yt3abant0634rd3py` (`cal_idx`),
  CONSTRAINT `FKkuc63i71yt3abant0634rd3py` FOREIGN KEY (`cal_idx`) REFERENCES `calendars` (`cal_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- 테이블 데이터 friends.diary:~0 rows (대략적) 내보내기
DELETE FROM `diary`;

-- 테이블 friends.diary_image 구조 내보내기
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

-- 테이블 데이터 friends.diary_image:~0 rows (대략적) 내보내기
DELETE FROM `diary_image`;

-- 테이블 friends.exchange_diary 구조 내보내기
CREATE TABLE IF NOT EXISTS `exchange_diary` (
  `e_created_at` datetime(6) DEFAULT NULL,
  `ed_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `user1_id` bigint(20) NOT NULL,
  `user2_id` bigint(20) NOT NULL,
  `group_name` varchar(255) NOT NULL,
  `e_status` enum('ACCEPTED','PENDING','REJECTED') NOT NULL,
  PRIMARY KEY (`ed_idx`),
  KEY `FKo6q2jhroi2ai2jvi0af6bwtoy` (`user1_id`),
  KEY `FK6ryow6w7ggudqqtv1fv8e6h67` (`user2_id`),
  CONSTRAINT `FK6ryow6w7ggudqqtv1fv8e6h67` FOREIGN KEY (`user2_id`) REFERENCES `user` (`u_idx`),
  CONSTRAINT `FKo6q2jhroi2ai2jvi0af6bwtoy` FOREIGN KEY (`user1_id`) REFERENCES `user` (`u_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- 테이블 데이터 friends.exchange_diary:~0 rows (대략적) 내보내기
DELETE FROM `exchange_diary`;

-- 테이블 friends.exchange_diary_entry 구조 내보내기
CREATE TABLE IF NOT EXISTS `exchange_diary_entry` (
  `e_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `ed_idx` bigint(20) NOT NULL,
  `ee_created_at` datetime(6) DEFAULT NULL,
  `u_idx` bigint(20) NOT NULL,
  `e_content` text NOT NULL,
  `e_title` varchar(255) NOT NULL,
  PRIMARY KEY (`e_idx`),
  KEY `FK4inphoph0sg0f2o47y8aawoks` (`u_idx`),
  KEY `FKtid0u8qrwujls9bt5q43v81o7` (`ed_idx`),
  CONSTRAINT `FK4inphoph0sg0f2o47y8aawoks` FOREIGN KEY (`u_idx`) REFERENCES `user` (`u_idx`),
  CONSTRAINT `FKtid0u8qrwujls9bt5q43v81o7` FOREIGN KEY (`ed_idx`) REFERENCES `exchange_diary` (`ed_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- 테이블 데이터 friends.exchange_diary_entry:~0 rows (대략적) 내보내기
DELETE FROM `exchange_diary_entry`;

-- 테이블 friends.friends 구조 내보내기
CREATE TABLE IF NOT EXISTS `friends` (
  `created_at` datetime(6) DEFAULT NULL,
  `f_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `rec_idx` bigint(20) NOT NULL,
  `req_idx` bigint(20) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `f_status` enum('ACCEPTED','PENDING') NOT NULL,
  PRIMARY KEY (`f_idx`),
  UNIQUE KEY `UKnqr67djs0j157sv3lgdgm4set` (`req_idx`,`rec_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- 테이블 데이터 friends.friends:~3 rows (대략적) 내보내기
DELETE FROM `friends`;
INSERT INTO `friends` (`created_at`, `f_idx`, `rec_idx`, `req_idx`, `updated_at`, `f_status`) VALUES
	(NULL, 1, 1, 2, NULL, 'ACCEPTED'),
	(NULL, 2, 1, 3, NULL, 'ACCEPTED'),
	(NULL, 3, 2, 3, NULL, 'ACCEPTED');

-- 테이블 friends.profile_image 구조 내보내기
CREATE TABLE IF NOT EXISTS `profile_image` (
  `p_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `u_idx` bigint(20) DEFAULT NULL,
  `p_img_name` varchar(255) NOT NULL,
  `p_img_url` varchar(255) NOT NULL,
  `p_ori_img_name` varchar(255) NOT NULL,
  PRIMARY KEY (`p_idx`),
  UNIQUE KEY `UKfh6rdgf00c2kp2g5r6l8d17er` (`u_idx`),
  CONSTRAINT `FKj2gf8txor2eak5as52ape8k7m` FOREIGN KEY (`u_idx`) REFERENCES `user` (`u_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- 테이블 데이터 friends.profile_image:~0 rows (대략적) 내보내기
DELETE FROM `profile_image`;

-- 테이블 friends.schedule 구조 내보내기
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
  PRIMARY KEY (`s_idx`),
  KEY `FK7cdgry6pnlv63hqardfc2708a` (`cal_idx`),
  CONSTRAINT `FK7cdgry6pnlv63hqardfc2708a` FOREIGN KEY (`cal_idx`) REFERENCES `calendars` (`cal_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- 테이블 데이터 friends.schedule:~0 rows (대략적) 내보내기
DELETE FROM `schedule`;

-- 테이블 friends.schedule_image 구조 내보내기
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

-- 테이블 데이터 friends.schedule_image:~0 rows (대략적) 내보내기
DELETE FROM `schedule_image`;

-- 테이블 friends.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `access_token_expiry` datetime(6) DEFAULT NULL,
  `refresh_token_expiry` datetime(6) DEFAULT NULL,
  `u_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `u_joinday` datetime(6) DEFAULT NULL,
  `access_token` varchar(255) DEFAULT NULL,
  `refresh_token` varchar(255) DEFAULT NULL,
  `u_email` varchar(255) NOT NULL,
  `u_nickname` varchar(255) NOT NULL,
  `u_password` varchar(255) NOT NULL,
  `provider` enum('KAKAO','LOCAL') NOT NULL,
  PRIMARY KEY (`u_idx`),
  UNIQUE KEY `UK16c3bxqq7t0jlm31mupreqntr` (`u_email`),
  UNIQUE KEY `UKdsnf0ypn8p7v66s0lt0j81020` (`u_nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- 테이블 데이터 friends.user:~0 rows (대략적) 내보내기
DELETE FROM `user`;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
