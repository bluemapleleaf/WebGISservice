/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : webservice

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2021-12-08 01:10:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '注释',
  `apply_id` int NOT NULL COMMENT '上传人id',
  `check_id` int DEFAULT NULL COMMENT '审核人id',
  `apply_date` datetime NOT NULL COMMENT '上传日期',
  `publish_date` datetime DEFAULT NULL COMMENT '发布日期',
  `state` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ann_fk_apply_id` (`apply_id`),
  KEY `ann_fk_check_id` (`check_id`),
  CONSTRAINT `ann_fk_apply_id` FOREIGN KEY (`apply_id`) REFERENCES `user` (`id`),
  CONSTRAINT `ann_fk_check_id` FOREIGN KEY (`check_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('1', '武汉大学你猜猜停不停水', '内容', '待发布', '1', '2', '2020-01-06 16:00:00', '2020-01-06 16:00:00', '2');
INSERT INTO `announcement` VALUES ('2', '武汉大学停电通知', '内容', '待发布', '1', null, '2020-01-06 16:00:00', null, '1');

-- ----------------------------
-- Table structure for lost_and_found
-- ----------------------------
DROP TABLE IF EXISTS `lost_and_found`;
CREATE TABLE `lost_and_found` (
  `id` int NOT NULL AUTO_INCREMENT,
  `apply_id` int NOT NULL COMMENT '申报人的id',
  `finish_id` int DEFAULT NULL COMMENT '找到人的id或者领物品的人的id',
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '问题描述',
  `latitude` double DEFAULT NULL COMMENT '纬度（可以不定位）',
  `longitude` double DEFAULT NULL COMMENT '经度',
  `place` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '申报地点',
  `apply_date` datetime NOT NULL,
  `finish_date` datetime DEFAULT NULL,
  `state` int NOT NULL COMMENT '完成状态',
  `type` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_apply_id` (`apply_id`),
  KEY `lost_fk_finish_id` (`finish_id`),
  CONSTRAINT `lost_fk_apply_id` FOREIGN KEY (`apply_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `lost_fk_finish_id` FOREIGN KEY (`finish_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of lost_and_found
-- ----------------------------
INSERT INTO `lost_and_found` VALUES ('2', '1', '2', '这是一个测试的失物招领事件', '可选的内容', '0', '0', '某个地点', '2020-01-07 13:21:55', '2020-01-07 14:00:55', '1', '0');
INSERT INTO `lost_and_found` VALUES ('3', '1', null, '这是一个测试的发布丢失物品事件', '可选的内容', '0', '0', '某个地点', '2020-01-07 13:21:55', null, '0', '1');
INSERT INTO `lost_and_found` VALUES ('4', '1', null, '这是一个测试的失物招领事件', '可选的内容', '0', '0', '某个地点', '2020-01-07 13:21:55', null, '0', '1');

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `id` int NOT NULL AUTO_INCREMENT,
  `repair_id` int DEFAULT NULL COMMENT '维修人员的id',
  `apply_id` int NOT NULL COMMENT '申报人的id',
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '问题描述',
  `latitude` double DEFAULT NULL COMMENT '纬度（可以不定位）',
  `longitude` double DEFAULT NULL COMMENT '经度',
  `place` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '报修地点',
  `apply_date` datetime NOT NULL,
  `finish_date` datetime DEFAULT NULL,
  `repair_type` int NOT NULL,
  `state` int NOT NULL COMMENT '完成状态',
  PRIMARY KEY (`id`),
  KEY `fk_repair_id` (`repair_id`),
  KEY `fk_apply_id` (`apply_id`),
  CONSTRAINT `fk_apply_id` FOREIGN KEY (`apply_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_repair_id` FOREIGN KEY (`repair_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES ('3', '2', '1', '这是一个测试的维修事件', '可选的内容', '0', '0', '某个地点', '2020-01-07 13:21:55', '2020-01-07 14:00:55', '0', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '工号/学号',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone_number` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` int NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '地址',
  `affiliation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '淇', '123456', '徐淇', '21567', '1', '武汉大学', '12567');
INSERT INTO `user` VALUES ('2', '鸣', '123456', '王一鸣', '431551', '2', '武汉大学', '43256');
INSERT INTO `user` VALUES ('3', '2019302130011', '123456', '吴弘博', '16164684', '1', '武汉大学信息学部竹园7舍', '');
INSERT INTO `user` VALUES ('4', '测试数据修改用户名', '123456', '测试数据修改真实名', '12345678', '1', '信息学部竹园7舍', '');
