/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-08-01 23:29:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_1
-- ----------------------------
DROP TABLE IF EXISTS `user_1`;
CREATE TABLE `user_1` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ACCOUNT_ID` varchar(100) DEFAULT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `TOKEN` varchar(36) DEFAULT NULL,
  `GMT_CREATE` bigint(20) DEFAULT NULL,
  `GMT_MODIFIED` bigint(20) DEFAULT NULL,
  `BIO` varchar(256) DEFAULT NULL,
  `avatar_url` varchar(100) DEFAULT NULL COMMENT '图片路径',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
