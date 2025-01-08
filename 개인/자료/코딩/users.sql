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


-- users 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `users` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci */;
USE `users`;

-- 테이블 users.profile_image 구조 내보내기
CREATE TABLE IF NOT EXISTS `profile_image` (
  `p_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `u_idx` bigint(20) DEFAULT NULL,
  `p_img_name` varchar(255) NOT NULL,
  `p_img_url` varchar(255) NOT NULL,
  `p_ori_img_name` varchar(255) NOT NULL,
  PRIMARY KEY (`p_idx`),
  UNIQUE KEY `UKfh6rdgf00c2kp2g5r6l8d17er` (`u_idx`),
  CONSTRAINT `FKgjhb7su2dg1owba0dtby2687e` FOREIGN KEY (`u_idx`) REFERENCES `users` (`u_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- 테이블 데이터 users.profile_image:~0 rows (대략적) 내보내기
DELETE FROM `profile_image`;

-- 테이블 users.users 구조 내보내기
CREATE TABLE IF NOT EXISTS `users` (
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
  UNIQUE KEY `UK9x5ggf0eh3flo5f3wsqur3vjc` (`u_email`),
  UNIQUE KEY `UKeai1vn3ij52rrotndetpos5u7` (`u_nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- 테이블 데이터 users.users:~3 rows (대략적) 내보내기
DELETE FROM `users`;
INSERT INTO `users` (`access_token_expiry`, `refresh_token_expiry`, `u_idx`, `u_joinday`, `access_token`, `refresh_token`, `u_email`, `u_nickname`, `u_password`, `provider`) VALUES
	(NULL, NULL, 1, '2024-12-27 09:53:25.000000', NULL, NULL, 'aa@naver.com', 'aa', '1234', 'LOCAL'),
	(NULL, NULL, 2, '2024-12-27 09:53:48.000000', NULL, NULL, 'bb@naver.com', 'bb', '1234', 'LOCAL'),
	(NULL, NULL, 3, '2024-12-27 09:54:02.000000', NULL, NULL, 'cc@naver.com', 'cc', '1234', 'LOCAL');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
