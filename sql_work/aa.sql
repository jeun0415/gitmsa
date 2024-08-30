-- --------------------------------------------------------
-- 호스트:                          192.168.0.23
-- 서버 버전:                        9.0.0 - MySQL Community Server - GPL
-- 서버 OS:                        Linux
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

-- 테이블 aaa.member 구조 내보내기
CREATE TABLE IF NOT EXISTS `member` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `regdate` datetime DEFAULT (now()),
  `mydate` datetime DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 aaa.member:~14 rows (대략적) 내보내기
DELETE FROM `member`;
INSERT INTO `member` (`idx`, `name`, `age`, `email`, `password`, `regdate`, `mydate`) VALUES
	(1, '홍길동', 20, NULL, NULL, NULL, NULL),
	(2, '홍길동', 20, NULL, NULL, NULL, NULL),
	(5, '홍길동', 20, NULL, NULL, NULL, NULL),
	(6, '김길동', 30, NULL, NULL, NULL, NULL),
	(7, '박길동', 50, NULL, NULL, NULL, NULL),
	(8, NULL, NULL, 'bbb@naver.com', '1234', NULL, NULL),
	(9, NULL, NULL, 'ccc@naver.com', '9632', NULL, NULL),
	(12, NULL, NULL, 'ccc@naver.com', '9632', NULL, NULL),
	(14, NULL, NULL, 'ㅎㅇㅎㅎ', '1234', NULL, NULL),
	(15, NULL, NULL, 'ㅎㅇㅎㅎ', '1234', NULL, NULL),
	(17, '임예서', 1, 'a@naver.com', 'asdf', NULL, NULL),
	(18, '최포미', 7, 'hi@naver.com', '0123', NULL, NULL),
	(19, '새로운이름', 20, 'abc@naver.com', 'qwerqwer', '2024-08-30 02:41:09', NULL);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
