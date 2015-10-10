/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : integralmall

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-09-10 12:16:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for branch_shop
-- ----------------------------
DROP TABLE IF EXISTS `branch_shop`;
CREATE TABLE `branch_shop` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `shop` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pfe9agurkq7i388goo43b7p7t` (`shop`),
  CONSTRAINT `FK_pfe9agurkq7i388goo43b7p7t` FOREIGN KEY (`shop`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of branch_shop
-- ----------------------------
INSERT INTO `branch_shop` VALUES ('faf08f184f8d4bc5014f8d4f51c30000', '2015-09-02 17:07:09', '\0', '2015-09-02 17:07:09', '北京市', 'xxx', null, '39.897729', '116.518476', 'JEFEN', '1', '123456', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `branch_shop` VALUES ('faf08f184fa58458014fa5c09f27000d', '2015-09-07 11:01:48', '\0', '2015-09-07 11:01:48', '北京市', 'sss', null, '39.92031', '116.469608', '商户1', '1', '123456', 'faf08f184fa58458014fa5bf9ced000c');
INSERT INTO `branch_shop` VALUES ('faf08f184fa58458014fa5c27b9e0013', '2015-09-07 11:03:50', '\0', '2015-09-07 11:03:50', '北京市', 'ddd', null, '39.91367', '116.264938', '商户2', '1', '454365657', 'faf08f184fa58458014fa5c22dca0012');
INSERT INTO `branch_shop` VALUES ('faf08f184fa58458014fa5c866fd0017', '2015-09-07 11:10:18', '\0', '2015-09-07 11:10:18', '北京市', 'fff', null, '39.928278', '116.438563', '商户3', '1', '56436456', 'faf08f184fa58458014fa5c2f4650016');
INSERT INTO `branch_shop` VALUES ('faf08f184fa58458014fa5c9ac2f001b', '2015-09-07 11:11:41', '\0', '2015-09-07 11:11:41', '北京市', 'hgh', null, '39.954389', '116.486856', '商户4', '1', '5435435', 'faf08f184fa58458014fa5c9541f001a');
INSERT INTO `branch_shop` VALUES ('faf08f184fa58458014fa5cb7964001e', '2015-09-07 11:13:39', '\0', '2015-09-07 11:13:39', '北京市', 'gfhgfh', null, '39.958814', '116.403493', '商户5', '1', '54676', 'faf08f184fa58458014fa5cb40ad001d');
INSERT INTO `branch_shop` VALUES ('faf08f184faafe6b014fac27074100af', '2015-09-08 16:51:23', '\0', '2015-09-08 16:51:23', '北京市', '时代', null, '39.92031', '116.432239', '商户7', '1', '123456', 'faf08f184faafe6b014fac267d2600ae');
INSERT INTO `branch_shop` VALUES ('faf08f184faafe6b014fac2d768200b2', '2015-09-08 16:58:24', '\0', '2015-09-08 16:58:24', '北京市', 'fdsf', null, '39.922081', '116.512727', '商户8', '1', '546546', 'faf08f184faafe6b014fac28c13300b1');
INSERT INTO `branch_shop` VALUES ('faf08f184faafe6b014fac2ee99f00b7', '2015-09-08 16:59:59', '\0', '2015-09-08 16:59:59', '北京市', 'dsfds', null, '39.931819', '116.473633', '商户10', '1', '54646546', 'faf08f184faafe6b014fac2e6a8300b6');
INSERT INTO `branch_shop` VALUES ('faf08f184faafe6b014fac2f356200b8', '2015-09-08 17:00:19', '\0', '2015-09-08 17:00:19', '北京市', 'ytuyt', null, '39.899501', '116.375897', '商户9', '9', '67657', 'faf08f184faafe6b014fac2df1ca00b4');
INSERT INTO `branch_shop` VALUES ('faf08f184faafe6b014fac30012300bb', '2015-09-08 17:01:11', '\0', '2015-09-08 17:01:11', '北京市', 'gfhfd', null, '39.869825', '116.441437', '商户11', '1', '6745645', 'faf08f184faafe6b014fac2fb1ad00ba');
INSERT INTO `branch_shop` VALUES ('faf08f184fb07a88014fb09c17c70002', '2015-09-09 13:37:43', '\0', '2015-09-09 13:37:43', '北京朝阳区朝阳北路107号院罗马嘉园商务会所一层105', '', null, '39.930774', '116.52271', '佳美口腔青年中路门诊', '1', '43546546', 'faf08f184faafe6b014fb04be1fd016a');
INSERT INTO `branch_shop` VALUES ('faf08f184fb13015014fb1496541001c', '2015-09-09 16:47:01', '\0', '2015-09-09 16:47:01', '北京市朝阳区将台路芳园南里水岸会所底商', '刘艳', null, '39.975044', '116.489355', '光之树瑜伽中心', '1', '4006806201', 'faf08f184fb13015014fb143cc1c0019');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_c2491gxyu6bsjw346i1fgojqf` (`type`),
  KEY `type_index` (`type`),
  KEY `FK_81thrbnb8c08gua7tvqj7xdqk` (`parent_id`),
  CONSTRAINT `FK_81thrbnb8c08gua7tvqj7xdqk` FOREIGN KEY (`parent_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('123', '2015-08-26 18:26:08', '\0', '2015-08-26 18:26:14', '商家标签分类', null, 'SHOP_TAG', null);
INSERT INTO `category` VALUES ('32423', '2015-07-24 09:49:21', '\0', '2015-07-24 09:49:26', '商品品牌', null, 'MERCHANDISE_BRAND', null);
INSERT INTO `category` VALUES ('345', '2015-07-24 09:47:42', '\0', '2015-07-24 09:47:48', '商品分类', null, 'MERCHANDISE_CLASSIFY', null);
INSERT INTO `category` VALUES ('435', '2015-07-24 12:12:18', '\0', '2015-07-24 12:12:13', '积分来源', null, 'INTEGRAL_ORIGIN', null);

-- ----------------------------
-- Table structure for categoryitem
-- ----------------------------
DROP TABLE IF EXISTS `categoryitem`;
CREATE TABLE `categoryitem` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `attr` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `category_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_qqu62lf8x3ss3a4apwan8v5vo` (`category_id`),
  CONSTRAINT `FK_qqu62lf8x3ss3a4apwan8v5vo` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categoryitem
-- ----------------------------
INSERT INTO `categoryitem` VALUES ('34534', '2015-07-24 09:51:55', '\0', '2015-07-24 09:51:59', null, null, '配饰', null, null, '345');
INSERT INTO `categoryitem` VALUES ('435345', '2015-07-24 09:51:55', '\0', '2015-07-24 09:51:59', null, null, '服装', null, null, '345');
INSERT INTO `categoryitem` VALUES ('43543', '2015-07-24 09:50:51', '\0', '2015-07-24 09:50:53', null, null, 'BURBERRY', null, null, '32423');
INSERT INTO `categoryitem` VALUES ('456546', '2015-07-24 12:13:26', '\0', '2015-07-24 12:13:28', null, null, '兑换商品', null, null, '435');
INSERT INTO `categoryitem` VALUES ('5435', '2015-07-24 12:14:02', '\0', '2015-07-24 12:14:06', null, null, '兑换商品取消', null, null, '435');
INSERT INTO `categoryitem` VALUES ('54645', '2015-07-24 09:49:41', '\0', '2015-07-24 09:49:45', null, null, 'JEFEN', null, null, '32423');
INSERT INTO `categoryitem` VALUES ('67546', '2015-07-24 09:51:03', '\0', '2015-07-24 09:51:06', null, null, '代金券', null, null, '345');
INSERT INTO `categoryitem` VALUES ('676545435', '2015-09-07 11:21:59', '\0', '2015-09-07 11:22:02', null, null, 'xxx', null, null, '32423');
INSERT INTO `categoryitem` VALUES ('faf08f184fa58458014fa5bee5bf0006', '2015-09-07 10:59:55', '\0', '2015-09-07 10:59:55', null, null, '美容/SPA', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184fa58458014fa5bee60f0007', '2015-09-07 10:59:55', '\0', '2015-09-07 10:59:55', null, null, '美发', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184fa58458014fa5bee6670008', '2015-09-07 10:59:55', '\0', '2015-09-07 10:59:55', null, null, '造型', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184fa58458014fa5bee6830009', '2015-09-07 10:59:55', '\0', '2015-09-07 10:59:55', null, null, '美甲', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184fa58458014fa5bf9ced000b', '2015-09-07 11:00:42', '\0', '2015-09-07 11:00:42', null, null, '瑜伽/健身', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184fa58458014fa5c22d8a000f', '2015-09-07 11:03:30', '\0', '2015-09-07 11:03:30', null, null, '干洗', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184fa58458014fa5c22db00010', '2015-09-07 11:03:30', '\0', '2015-09-07 11:03:30', null, null, '改衣', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184fa58458014fa5c22dc90011', '2015-09-07 11:03:30', '\0', '2015-09-07 11:03:30', null, null, '奢侈品保养', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184fa58458014fa5c2f4650015', '2015-09-07 11:04:21', '\0', '2015-09-07 11:04:21', null, null, '健康体检（口腔牙医）', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184fa58458014fa5c9541f0019', '2015-09-07 11:11:19', '\0', '2015-09-07 11:11:19', null, null, '红酒鉴赏', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184faafe6b014fb04123b2014c', '2015-09-09 11:58:23', '\0', '2015-09-09 11:58:23', null, null, '佳美', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184faafe6b014fb04123d5014d', '2015-09-09 11:58:23', '\0', '2015-09-09 11:58:23', null, null, '口腔', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184faafe6b014fb04123ed014e', '2015-09-09 11:58:23', '\0', '2015-09-09 11:58:23', null, null, '门诊', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184faafe6b014fb0412403014f', '2015-09-09 11:58:23', '\0', '2015-09-09 11:58:23', null, null, '牙科', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184faafe6b014fb041241c0150', '2015-09-09 11:58:23', '\0', '2015-09-09 11:58:23', null, null, '洗牙', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184faafe6b014fb04124340151', '2015-09-09 11:58:23', '\0', '2015-09-09 11:58:23', null, null, '整牙', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184faafe6b014fb04be1c30169', '2015-09-09 12:10:07', '\0', '2015-09-09 12:10:07', null, null, '牙齿', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184fb13015014fb143cc140016', '2015-09-09 16:40:54', '\0', '2015-09-09 16:40:54', null, null, '光之树', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184fb13015014fb143cc190017', '2015-09-09 16:40:54', '\0', '2015-09-09 16:40:54', null, null, '瑜伽', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184fb13015014fb143cc1c0018', '2015-09-09 16:40:54', '\0', '2015-09-09 16:40:54', null, null, '健身', null, null, '123');

-- ----------------------------
-- Table structure for integral
-- ----------------------------
DROP TABLE IF EXISTS `integral`;
CREATE TABLE `integral` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `totalcount` bigint(20) NOT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_jwifd1dcfrasvp0ck233e5t69` (`user`),
  CONSTRAINT `FK_jwifd1dcfrasvp0ck233e5t69` FOREIGN KEY (`user`) REFERENCES `jefen`.`userinfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of integral
-- ----------------------------
INSERT INTO `integral` VALUES ('3454', '2015-08-03 10:31:26', '\0', '2015-08-03 10:45:50', '17000', 'faf08f184be41285014c1612a939002e');
INSERT INTO `integral` VALUES ('5656', '2015-07-29 11:43:56', '\0', '2015-08-22 10:33:07', '32', 'faf08f184be41285014c4f457dd70043');
INSERT INTO `integral` VALUES ('faf08f184f3476d6014f357d58700000', '2015-08-16 15:50:51', '\0', '2015-09-10 09:58:54', '25054', '000000004b1fafb1014b1fcf8dc50001');
INSERT INTO `integral` VALUES ('faf08f184f3476d6014f357d873c0001', '2015-08-16 15:51:03', '\0', '2015-08-16 15:51:03', '100000', 'faf08f184b5ab334014bc9002f2c002d');
INSERT INTO `integral` VALUES ('faf08f184f6daa04014f88342c900000', '2015-09-01 17:19:24', '\0', '2015-09-01 17:19:24', '0', '000000004e1cad1c014e8bf4b723000a');

-- ----------------------------
-- Table structure for integral_detail
-- ----------------------------
DROP TABLE IF EXISTS `integral_detail`;
CREATE TABLE `integral_detail` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `count` bigint(20) NOT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `integral` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3x5acto4r6c6nff6iawn13gdm` (`integral`),
  CONSTRAINT `FK_3x5acto4r6c6nff6iawn13gdm` FOREIGN KEY (`integral`) REFERENCES `integral` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of integral_detail
-- ----------------------------
INSERT INTO `integral_detail` VALUES ('4040409e4ed8021c014ed80224060002', '2015-07-29 12:11:36', '\0', '2015-07-29 12:11:36', '-1000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('4040409e4ed8023a014ed80241400002', '2015-07-29 12:11:43', '\0', '2015-07-29 12:11:43', '-1000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('4040409e4ed80590014ed80597060002', '2015-07-29 12:15:22', '\0', '2015-07-29 12:15:22', '-2000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('4040409e4ed8e449014ed8e44f950002', '2015-07-29 16:18:38', '\0', '2015-07-29 16:18:38', '-2000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('4040409e4ed9083b014ed90841f40000', '2015-07-29 16:57:54', '\0', '2015-07-29 16:57:54', '1000', '兑换商品取消', '5656');
INSERT INTO `integral_detail` VALUES ('4040409e4ed90b6e014ed90b75900002', '2015-07-29 17:01:24', '\0', '2015-07-29 17:01:24', '-2000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('4040409e4ede6268014ede626e430002', '2015-07-30 17:54:30', '\0', '2015-07-30 17:54:30', '-2000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('4040409e4ee2c05b014ee2c061560002', '2015-07-31 14:15:36', '\0', '2015-07-31 14:15:36', '-2000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('4040409e4ef166e7014ef166ed0f0002', '2015-08-03 10:32:11', '\0', '2015-08-03 10:32:11', '-2000', '兑换商品', '3454');
INSERT INTO `integral_detail` VALUES ('4040409e4ef17366014ef1736c3b0002', '2015-08-03 10:45:50', '\0', '2015-08-03 10:45:50', '-1000', '兑换商品', '3454');
INSERT INTO `integral_detail` VALUES ('faf08f184f3ec63f014f4043db490003', '2015-08-18 18:03:53', '\0', '2015-08-18 18:03:53', '-10000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f43f2c2e90000', '2015-08-19 11:13:47', '\0', '2015-08-19 11:13:47', '-10000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f43f3d50c0003', '2015-08-19 11:14:57', '\0', '2015-08-19 11:14:57', '-10000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f43f5a61c0006', '2015-08-19 11:16:56', '\0', '2015-08-19 11:16:56', '-10000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f43f615820009', '2015-08-19 11:17:24', '\0', '2015-08-19 11:17:24', '-10000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f43f6b367000c', '2015-08-19 11:18:05', '\0', '2015-08-19 11:18:05', '-10000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f43f6c336000f', '2015-08-19 11:18:09', '\0', '2015-08-19 11:18:09', '-10000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f43f847620012', '2015-08-19 11:19:48', '\0', '2015-08-19 11:19:48', '-10000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f43f859c30015', '2015-08-19 11:19:53', '\0', '2015-08-19 11:19:53', '-10000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f43f8e7f20018', '2015-08-19 11:20:29', '\0', '2015-08-19 11:20:29', '-10000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f440f5c4f001e', '2015-08-19 11:45:01', '\0', '2015-08-19 11:45:01', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f440f7fe90021', '2015-08-19 11:45:10', '\0', '2015-08-19 11:45:10', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f441013a90024', '2015-08-19 11:45:48', '\0', '2015-08-19 11:45:48', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f4411cfbd0027', '2015-08-19 11:47:42', '\0', '2015-08-19 11:47:42', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f4419ea56002a', '2015-08-19 11:56:33', '\0', '2015-08-19 11:56:33', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f441a53ed002d', '2015-08-19 11:57:00', '\0', '2015-08-19 11:57:00', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f441abd8b0030', '2015-08-19 11:57:27', '\0', '2015-08-19 11:57:27', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f441b54c70033', '2015-08-19 11:58:06', '\0', '2015-08-19 11:58:06', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f441f2e740036', '2015-08-19 12:02:18', '\0', '2015-08-19 12:02:18', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f441f39910039', '2015-08-19 12:02:21', '\0', '2015-08-19 12:02:21', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f441f542e003c', '2015-08-19 12:02:28', '\0', '2015-08-19 12:02:28', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f442c09f20045', '2015-08-19 12:16:20', '\0', '2015-08-19 12:16:20', '-5000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f442c41720048', '2015-08-19 12:16:35', '\0', '2015-08-19 12:16:35', '-1000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f442fa5f1004b', '2015-08-19 12:20:17', '\0', '2015-08-19 12:20:17', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f443003b0004f', '2015-08-19 12:20:41', '\0', '2015-08-19 12:20:41', '-2000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f44305ad10052', '2015-08-19 12:21:03', '\0', '2015-08-19 12:21:03', '-1000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f4431d2110055', '2015-08-19 12:22:39', '\0', '2015-08-19 12:22:39', '-1000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f4484c9800058', '2015-08-19 13:53:17', '\0', '2015-08-19 13:53:17', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f4484f660005b', '2015-08-19 13:53:28', '\0', '2015-08-19 13:53:28', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f449ac4f4005e', '2015-08-19 14:17:17', '\0', '2015-08-19 14:17:17', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f44a1d04e0061', '2015-08-19 14:24:59', '\0', '2015-08-19 14:24:59', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f44a2026c0064', '2015-08-19 14:25:12', '\0', '2015-08-19 14:25:12', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f44a279fc0067', '2015-08-19 14:25:42', '\0', '2015-08-19 14:25:42', '-2000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f44a6208e006b', '2015-08-19 14:29:42', '\0', '2015-08-19 14:29:42', '-2000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f44a63126006e', '2015-08-19 14:29:46', '\0', '2015-08-19 14:29:46', '-2000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f44c16c5e0071', '2015-08-19 14:59:31', '\0', '2015-08-19 14:59:31', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f44c509ac0074', '2015-08-19 15:03:27', '\0', '2015-08-19 15:03:27', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f44c57cbe0078', '2015-08-19 15:03:57', '\0', '2015-08-19 15:03:57', '-2000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f45371ba4007b', '2015-08-19 17:08:03', '\0', '2015-08-19 17:08:03', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f456f95d80080', '2015-08-19 18:09:44', '\0', '2015-08-19 18:09:44', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f43f1fb014f457117640083', '2015-08-19 18:11:23', '\0', '2015-08-19 18:11:23', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4a80e83c0001', '2015-08-20 17:46:46', '\0', '2015-08-20 17:46:46', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f246acb000b', '2015-08-21 15:23:50', '\0', '2015-08-21 15:23:50', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f24ed5b000e', '2015-08-21 15:24:24', '\0', '2015-08-21 15:24:24', '-2000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f25f2a70012', '2015-08-21 15:25:31', '\0', '2015-08-21 15:25:31', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f2682c30015', '2015-08-21 15:26:08', '\0', '2015-08-21 15:26:08', '-2000', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f26f9420018', '2015-08-21 15:26:38', '\0', '2015-08-21 15:26:38', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f2d80e3001b', '2015-08-21 15:33:46', '\0', '2015-08-21 15:33:46', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f328046001f', '2015-08-21 15:39:13', '\0', '2015-08-21 15:39:13', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f4461ff0022', '2015-08-21 15:58:45', '\0', '2015-08-21 15:58:45', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f4577930025', '2015-08-21 15:59:56', '\0', '2015-08-21 15:59:56', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f4a8cfc0028', '2015-08-21 16:05:29', '\0', '2015-08-21 16:05:29', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f4a958c002b', '2015-08-21 16:05:32', '\0', '2015-08-21 16:05:32', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f51fee7002e', '2015-08-21 16:13:37', '\0', '2015-08-21 16:13:37', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f52b8f20031', '2015-08-21 16:14:25', '\0', '2015-08-21 16:14:25', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f7ad11f0034', '2015-08-21 16:58:13', '\0', '2015-08-21 16:58:13', '-324', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f87b2da0037', '2015-08-21 17:12:17', '\0', '2015-08-21 17:12:17', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f895459003a', '2015-08-21 17:14:04', '\0', '2015-08-21 17:14:04', '-400', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f89d926003d', '2015-08-21 17:14:38', '\0', '2015-08-21 17:14:38', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f8c74980040', '2015-08-21 17:17:29', '\0', '2015-08-21 17:17:29', '-400', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f8c95870043', '2015-08-21 17:17:37', '\0', '2015-08-21 17:17:37', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f8cd0b10046', '2015-08-21 17:17:52', '\0', '2015-08-21 17:17:52', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f9183200049', '2015-08-21 17:23:00', '\0', '2015-08-21 17:23:00', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f925894004c', '2015-08-21 17:23:55', '\0', '2015-08-21 17:23:55', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f927fdd004f', '2015-08-21 17:24:05', '\0', '2015-08-21 17:24:05', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f92b85c0052', '2015-08-21 17:24:19', '\0', '2015-08-21 17:24:19', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f93a2260055', '2015-08-21 17:25:19', '\0', '2015-08-21 17:25:19', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f9479f50058', '2015-08-21 17:26:14', '\0', '2015-08-21 17:26:14', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f94defd005b', '2015-08-21 17:26:40', '\0', '2015-08-21 17:26:40', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4f950c1c005e', '2015-08-21 17:26:52', '\0', '2015-08-21 17:26:52', '-400', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4fb74a7a0061', '2015-08-21 18:04:16', '\0', '2015-08-21 18:04:16', '-400', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4fb7a30d0064', '2015-08-21 18:04:39', '\0', '2015-08-21 18:04:39', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4fb8ec3f0067', '2015-08-21 18:06:03', '\0', '2015-08-21 18:06:03', '-400', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4fb90d3b006a', '2015-08-21 18:06:11', '\0', '2015-08-21 18:06:11', '-400', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4fbc22a8006d', '2015-08-21 18:09:33', '\0', '2015-08-21 18:09:33', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4fbd09270070', '2015-08-21 18:10:32', '\0', '2015-08-21 18:10:32', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f4fbe74800073', '2015-08-21 18:12:05', '\0', '2015-08-21 18:12:05', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f533282da0076', '2015-08-22 10:17:43', '\0', '2015-08-22 10:17:43', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f533a28280079', '2015-08-22 10:26:04', '\0', '2015-08-22 10:26:04', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f533b072c007c', '2015-08-22 10:27:01', '\0', '2015-08-22 10:27:01', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f4a77e7014f53409bde007f', '2015-08-22 10:33:07', '\0', '2015-08-22 10:33:07', '-100', '兑换商品', '5656');
INSERT INTO `integral_detail` VALUES ('faf08f184f8d8d61014f936083f00001', '2015-09-03 21:23:40', '\0', '2015-09-03 21:23:40', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184f8d8d61014f9380262a0004', '2015-09-03 21:58:13', '\0', '2015-09-03 21:58:13', '-400', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fa5f35c014faac532470000', '2015-09-08 10:24:54', '\0', '2015-09-08 10:24:54', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faadb33014faaeadef5000a', '2015-09-08 11:06:03', '\0', '2015-09-08 11:06:03', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faadb33014faaeb7109000d', '2015-09-08 11:06:40', '\0', '2015-09-08 11:06:40', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faadb33014faaec57260012', '2015-09-08 11:07:39', '\0', '2015-09-08 11:07:39', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faadb33014faafba1960017', '2015-09-08 11:24:21', '\0', '2015-09-08 11:24:21', '-324', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fab0835010003', '2015-09-08 11:38:05', '\0', '2015-09-08 11:38:05', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fab7c9da60007', '2015-09-08 13:45:14', '\0', '2015-09-08 13:45:14', '-1222', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014faba73ac9000b', '2015-09-08 14:31:47', '\0', '2015-09-08 14:31:47', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014faba780c0000e', '2015-09-08 14:32:05', '\0', '2015-09-08 14:32:05', '-1230', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fac5dea9c00bc', '2015-09-08 17:51:20', '\0', '2015-09-08 17:51:20', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fac6e36be00bf', '2015-09-08 18:09:08', '\0', '2015-09-08 18:09:08', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafbebe1300c2', '2015-09-09 09:35:57', '\0', '2015-09-09 09:35:57', '-2000', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafc02f3700c5', '2015-09-09 09:37:31', '\0', '2015-09-09 09:37:31', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafc0863b00c8', '2015-09-09 09:37:54', '\0', '2015-09-09 09:37:54', '-2000', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafc1622b00cb', '2015-09-09 09:38:50', '\0', '2015-09-09 09:38:50', '-2000', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafc23edb00ce', '2015-09-09 09:39:47', '\0', '2015-09-09 09:39:47', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafc30f8100d1', '2015-09-09 09:40:40', '\0', '2015-09-09 09:40:40', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafc3378500d4', '2015-09-09 09:40:50', '\0', '2015-09-09 09:40:50', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafc35ca600d7', '2015-09-09 09:41:00', '\0', '2015-09-09 09:41:00', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafcb73f200da', '2015-09-09 09:49:50', '\0', '2015-09-09 09:49:50', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafcc28fe00dd', '2015-09-09 09:50:36', '\0', '2015-09-09 09:50:36', '-2000', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafcc5e7a00e0', '2015-09-09 09:50:50', '\0', '2015-09-09 09:50:50', '-2000', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafcd87a800e3', '2015-09-09 09:52:06', '\0', '2015-09-09 09:52:06', '-5000', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafcef03f00e6', '2015-09-09 09:53:38', '\0', '2015-09-09 09:53:38', '-1222', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafcf8f3600e9', '2015-09-09 09:54:19', '\0', '2015-09-09 09:54:19', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafd0992f00ec', '2015-09-09 09:55:27', '\0', '2015-09-09 09:55:27', '-10000', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafd2246300ef', '2015-09-09 09:57:08', '\0', '2015-09-09 09:57:08', '-1000', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafd7513f00f2', '2015-09-09 10:02:47', '\0', '2015-09-09 10:02:47', '-1230', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafd8664000f5', '2015-09-09 10:03:58', '\0', '2015-09-09 10:03:58', '-2000', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafdec61000f8', '2015-09-09 10:10:56', '\0', '2015-09-09 10:10:56', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafdf853300fb', '2015-09-09 10:11:45', '\0', '2015-09-09 10:11:45', '-5000', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafe06c1700fe', '2015-09-09 10:12:44', '\0', '2015-09-09 10:12:44', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafe15de60101', '2015-09-09 10:13:46', '\0', '2015-09-09 10:13:46', '-2000', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafe796b60104', '2015-09-09 10:20:34', '\0', '2015-09-09 10:20:34', '-10000', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fafe98c9c0107', '2015-09-09 10:22:42', '\0', '2015-09-09 10:22:42', '-1230', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb0003271010a', '2015-09-09 10:47:27', '\0', '2015-09-09 10:47:27', '-2000', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb000bd40010d', '2015-09-09 10:48:02', '\0', '2015-09-09 10:48:02', '-2000', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb00190b80110', '2015-09-09 10:48:56', '\0', '2015-09-09 10:48:56', '-400', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb0100c010113', '2015-09-09 11:04:45', '\0', '2015-09-09 11:04:45', '-400', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb01046ab0116', '2015-09-09 11:05:00', '\0', '2015-09-09 11:05:00', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb010b6990119', '2015-09-09 11:05:29', '\0', '2015-09-09 11:05:29', '-1222', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb01459a1011c', '2015-09-09 11:09:27', '\0', '2015-09-09 11:09:27', '-2000', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb02b2f5a011f', '2015-09-09 11:34:24', '\0', '2015-09-09 11:34:24', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb02ba67f0122', '2015-09-09 11:34:54', '\0', '2015-09-09 11:34:54', '-400', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb02c76d20125', '2015-09-09 11:35:48', '\0', '2015-09-09 11:35:48', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb02dbde20128', '2015-09-09 11:37:11', '\0', '2015-09-09 11:37:11', '-400', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb02e93c1012b', '2015-09-09 11:38:06', '\0', '2015-09-09 11:38:06', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb03187660130', '2015-09-09 11:41:20', '\0', '2015-09-09 11:41:20', '-400', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb035402c0133', '2015-09-09 11:45:24', '\0', '2015-09-09 11:45:24', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb035bfff0136', '2015-09-09 11:45:56', '\0', '2015-09-09 11:45:56', '-400', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb03614f70139', '2015-09-09 11:46:18', '\0', '2015-09-09 11:46:18', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb03be0eb013c', '2015-09-09 11:52:38', '\0', '2015-09-09 11:52:38', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb03c5796013f', '2015-09-09 11:53:08', '\0', '2015-09-09 11:53:08', '-400', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb03ca7080142', '2015-09-09 11:53:29', '\0', '2015-09-09 11:53:29', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb03cf8c60145', '2015-09-09 11:53:50', '\0', '2015-09-09 11:53:50', '-1000', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb03ddc8f0148', '2015-09-09 11:54:48', '\0', '2015-09-09 11:54:48', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb0415a550153', '2015-09-09 11:58:37', '\0', '2015-09-09 11:58:37', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb041d9690156', '2015-09-09 11:59:09', '\0', '2015-09-09 11:59:09', '-400', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb0452d880159', '2015-09-09 12:02:47', '\0', '2015-09-09 12:02:47', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb0460b9f015c', '2015-09-09 12:03:44', '\0', '2015-09-09 12:03:44', '-400', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb047b1ba015f', '2015-09-09 12:05:32', '\0', '2015-09-09 12:05:32', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb049f72a0162', '2015-09-09 12:08:01', '\0', '2015-09-09 12:08:01', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184faafe6b014fb04a6ad00165', '2015-09-09 12:08:31', '\0', '2015-09-09 12:08:31', '-400', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb112d2014fb11ccf990000', '2015-09-09 15:58:19', '\0', '2015-09-09 15:58:19', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb112d2014fb11d4b210003', '2015-09-09 15:58:51', '\0', '2015-09-09 15:58:51', '-400', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb112d2014fb11d9b360006', '2015-09-09 15:59:11', '\0', '2015-09-09 15:59:11', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb112d2014fb11dfc470009', '2015-09-09 15:59:36', '\0', '2015-09-09 15:59:36', '-400', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb112d2014fb11e1f75000c', '2015-09-09 15:59:45', '\0', '2015-09-09 15:59:45', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb13600df0000', '2015-09-09 16:25:50', '\0', '2015-09-09 16:25:50', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb136f3c10003', '2015-09-09 16:26:52', '\0', '2015-09-09 16:26:52', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb15d4aad0026', '2015-09-09 17:08:45', '\0', '2015-09-09 17:08:45', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb15da6290029', '2015-09-09 17:09:08', '\0', '2015-09-09 17:09:08', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb15ebc25002c', '2015-09-09 17:10:19', '\0', '2015-09-09 17:10:19', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb15ed77a002f', '2015-09-09 17:10:26', '\0', '2015-09-09 17:10:26', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb15f87cd0032', '2015-09-09 17:11:12', '\0', '2015-09-09 17:11:12', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb16961dc0035', '2015-09-09 17:21:57', '\0', '2015-09-09 17:21:57', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb1697bd10038', '2015-09-09 17:22:04', '\0', '2015-09-09 17:22:04', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb16a86b1003b', '2015-09-09 17:23:12', '\0', '2015-09-09 17:23:12', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb17f4d59003e', '2015-09-09 17:45:54', '\0', '2015-09-09 17:45:54', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb1810f5e0041', '2015-09-09 17:47:49', '\0', '2015-09-09 17:47:49', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb1be2b120044', '2015-09-09 18:54:34', '\0', '2015-09-09 18:54:34', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb1c79b8a0047', '2015-09-09 19:04:52', '\0', '2015-09-09 19:04:52', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb1c7cd77004a', '2015-09-09 19:05:05', '\0', '2015-09-09 19:05:05', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb1ca5d4c004d', '2015-09-09 19:07:53', '\0', '2015-09-09 19:07:53', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb1ca94040050', '2015-09-09 19:08:07', '\0', '2015-09-09 19:08:07', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb4e391040053', '2015-09-10 09:34:16', '\0', '2015-09-10 09:34:16', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb4e49cfe0056', '2015-09-10 09:35:25', '\0', '2015-09-10 09:35:25', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb4e53a600059', '2015-09-10 09:36:05', '\0', '2015-09-10 09:36:05', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb4e581b0005c', '2015-09-10 09:36:23', '\0', '2015-09-10 09:36:23', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb4e5e8b2005f', '2015-09-10 09:36:50', '\0', '2015-09-10 09:36:50', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb4e6952e0062', '2015-09-10 09:37:34', '\0', '2015-09-10 09:37:34', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb4e826e10065', '2015-09-10 09:39:17', '\0', '2015-09-10 09:39:17', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb4e8b2a90068', '2015-09-10 09:39:53', '\0', '2015-09-10 09:39:53', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb4e9a59a006b', '2015-09-10 09:40:55', '\0', '2015-09-10 09:40:55', '-1222', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb4ecf30a006e', '2015-09-10 09:44:31', '\0', '2015-09-10 09:44:31', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb4ee1d2c0071', '2015-09-10 09:45:48', '\0', '2015-09-10 09:45:48', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb4f316df0074', '2015-09-10 09:51:14', '\0', '2015-09-10 09:51:14', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb4f353ba0077', '2015-09-10 09:51:29', '\0', '2015-09-10 09:51:29', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb4f6ce6e007a', '2015-09-10 09:55:17', '\0', '2015-09-10 09:55:17', '-1222', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb4f982ce007d', '2015-09-10 09:58:14', '\0', '2015-09-10 09:58:14', '-100', '兑换商品', 'faf08f184f3476d6014f357d58700000');
INSERT INTO `integral_detail` VALUES ('faf08f184fb13015014fb4fa1b3f0080', '2015-09-10 09:58:54', '\0', '2015-09-10 09:58:54', '-1222', '兑换商品', 'faf08f184f3476d6014f357d58700000');

-- ----------------------------
-- Table structure for integral_order
-- ----------------------------
DROP TABLE IF EXISTS `integral_order`;
CREATE TABLE `integral_order` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `order_no` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `address_id` varchar(255) DEFAULT NULL,
  `shop` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tci8j3sandpacflut5rot7ofn` (`user`),
  KEY `FK_j7kpchvhrqkn0ncc4nh0fe5vo` (`shop`),
  CONSTRAINT `FK_tci8j3sandpacflut5rot7ofn` FOREIGN KEY (`user`) REFERENCES `jefen`.`userinfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of integral_order
-- ----------------------------
INSERT INTO `integral_order` VALUES ('4040409e4ee2c05b014ee2c0611e0000', '2015-07-31 14:15:35', '\0', '2015-07-31 14:15:35', '2015-07-31 14:15:35', '400190cf-6823-49f5-b330-3df5ab647c4d', '01', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('4040409e4ef166e7014ef166ece10000', '2015-08-03 10:32:11', '\0', '2015-08-03 10:32:11', '2015-08-03 10:32:11', 'f69ff507-0864-41d8-9747-91661835db97', '00', 'faf08f184be41285014c1612a939002e', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('4040409e4ef17366014ef1736c120000', '2015-08-03 10:45:50', '\0', '2015-08-03 10:45:50', '2015-08-03 10:45:50', 'f8f03ffa-5e9a-4f12-abc5-1bc265c17c98', '10', 'faf08f184be41285014c1612a939002e', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f3ec63f014f4043db0e0001', '2015-08-18 18:03:52', '\0', '2015-08-18 18:03:52', '2015-08-18 18:03:52', '7e553a60-b919-47d5-ab15-8c756166248e', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f43f2c2f40001', '2015-08-19 11:13:47', '\0', '2015-08-19 11:13:47', '2015-08-19 11:13:47', 'c2e90e81-a5a0-4e1a-9767-71b332699a88', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f43f3d50d0004', '2015-08-19 11:14:57', '\0', '2015-08-19 11:14:57', '2015-08-19 11:14:57', 'a717c130-04b2-41eb-8e33-9b868c8262aa', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f43f5a61d0007', '2015-08-19 11:16:56', '\0', '2015-08-19 11:16:56', '2015-08-19 11:16:56', '88cad5e1-faa2-4eba-81e4-5c623a369340', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f43f61583000a', '2015-08-19 11:17:24', '\0', '2015-08-19 11:17:24', '2015-08-19 11:17:24', '1eab734e-4d2e-4a80-a98f-f809227a6bc9', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f43f6b368000d', '2015-08-19 11:18:05', '\0', '2015-08-19 11:18:05', '2015-08-19 11:18:05', 'a5fa73df-3474-40ff-80cb-2f975a47fd64', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f43f6c3370010', '2015-08-19 11:18:09', '\0', '2015-08-19 11:18:09', '2015-08-19 11:18:09', '3d4eca6a-d891-4cc9-8aa2-dbd87d505373', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f43f847630013', '2015-08-19 11:19:48', '\0', '2015-08-19 11:19:48', '2015-08-19 11:19:48', 'e387b3ed-7372-4558-96ba-e148c4802280', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f43f859c40016', '2015-08-19 11:19:53', '\0', '2015-08-19 11:19:53', '2015-08-19 11:19:53', 'b598f98c-e557-4e47-a740-94ca047bd07a', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f43f8e7f20019', '2015-08-19 11:20:29', '\0', '2015-08-19 11:20:29', '2015-08-19 11:20:29', '3849aa67-2164-41bf-af78-ad2715df85e5', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f440f5c4f001f', '2015-08-19 11:45:01', '\0', '2015-08-19 11:45:01', '2015-08-19 11:45:01', '5744fc93-92f3-4f72-9eb3-a59d122115af', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f440f7fe90022', '2015-08-19 11:45:10', '\0', '2015-08-19 11:45:10', '2015-08-19 11:45:10', 'a2259bae-3882-4e8f-be29-0cc409cd39e9', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f441013a90025', '2015-08-19 11:45:48', '\0', '2015-08-19 11:45:48', '2015-08-19 11:45:48', '77937b97-f0ec-440a-bea1-e6df3799bccb', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f4411cfbe0028', '2015-08-19 11:47:42', '\0', '2015-08-19 11:47:42', '2015-08-19 11:47:42', 'f753266c-48a1-4d32-a2c7-4bad43770a0c', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f4419ea56002b', '2015-08-19 11:56:33', '\0', '2015-08-19 11:56:33', '2015-08-19 11:56:33', '1ef02d36-e472-4398-8082-60efe3eee866', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f441a53ee002e', '2015-08-19 11:57:00', '\0', '2015-08-19 11:57:00', '2015-08-19 11:57:00', '1da7027a-e38b-4c8e-a756-3e9981538e66', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f441abd8b0031', '2015-08-19 11:57:27', '\0', '2015-08-19 11:57:27', '2015-08-19 11:57:27', '6f0e408e-7e63-4a05-a642-ed6e18969b08', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f441b54c70034', '2015-08-19 11:58:06', '\0', '2015-08-19 11:58:06', '2015-08-19 11:58:06', '1564f389-23c0-4781-9f8a-9c1d727e5e1c', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f441f2e740037', '2015-08-19 12:02:18', '\0', '2015-08-19 12:02:18', '2015-08-19 12:02:18', '89493099-2f1e-49b6-96e6-3dfad6532ead', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f441f3992003a', '2015-08-19 12:02:21', '\0', '2015-08-19 12:02:21', '2015-08-19 12:02:21', '7c02b4f3-268c-42fd-9bf6-2ddda4ff509a', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f441f542f003d', '2015-08-19 12:02:28', '\0', '2015-08-19 12:02:28', '2015-08-19 12:02:28', 'e012a254-3ec4-43f5-9623-f2b3e09a4b43', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f442c09f20046', '2015-08-19 12:16:20', '\0', '2015-08-19 12:16:20', '2015-08-19 12:16:20', 'ef554bf5-52ab-4472-b90c-64f78e82ae77', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f442c41720049', '2015-08-19 12:16:35', '\0', '2015-08-19 12:16:35', '2015-08-19 12:16:35', '6389760b-e0d4-4c7b-aa40-b2b6ec649ad8', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f442fa5f2004c', '2015-08-19 12:20:17', '\0', '2015-08-19 12:20:17', '2015-08-19 12:20:17', 'cf176690-96dc-42fb-8722-f4a9335ef566', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f443003b10050', '2015-08-19 12:20:41', '\0', '2015-08-19 12:20:41', '2015-08-19 12:20:41', '0b1d41a0-6084-4e0d-a322-9912e2e2005b', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f44305ad10053', '2015-08-19 12:21:03', '\0', '2015-08-19 12:21:03', '2015-08-19 12:21:03', '3e4796c9-1bfd-4487-a957-5fd197efc921', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f4431d2110056', '2015-08-19 12:22:39', '\0', '2015-08-19 12:22:39', '2015-08-19 12:22:39', '1e454169-e23c-4b6a-a3ff-290e585c5408', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f4484c9810059', '2015-08-19 13:53:17', '\0', '2015-08-19 13:53:17', '2015-08-19 13:53:17', '074e2382-12ec-404f-965d-a3c1ce5ad51f', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f4484f660005c', '2015-08-19 13:53:28', '\0', '2015-08-19 13:53:28', '2015-08-19 13:53:28', '55f762c0-5d84-4deb-b056-c6eb2df6f90e', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f449ac4f4005f', '2015-08-19 14:17:17', '\0', '2015-08-19 14:17:17', '2015-08-19 14:17:17', 'b1f3db24-47b3-4ea6-9836-c6b69a0dd7ac', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f44a1d04e0062', '2015-08-19 14:24:59', '\0', '2015-08-19 14:24:59', '2015-08-19 14:24:59', 'f0925df7-b9bb-4c7b-bdf8-eae692086570', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f44a2026c0065', '2015-08-19 14:25:12', '\0', '2015-08-19 14:25:12', '2015-08-19 14:25:12', 'c6d1ea55-ff0f-4f84-8e6d-a813bad17121', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f44a279fc0068', '2015-08-19 14:25:42', '\0', '2015-08-19 14:25:42', '2015-08-19 14:25:42', '11146b20-d801-4cc1-8090-c762ae437766', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f44a6208f006c', '2015-08-19 14:29:42', '\0', '2015-08-19 14:29:42', '2015-08-19 14:29:42', 'cdfb38ee-9886-4829-b79d-f7c79c790b08', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f44a63127006f', '2015-08-19 14:29:46', '\0', '2015-08-19 14:29:46', '2015-08-19 14:29:46', '37c2d9e8-b0b8-4cb1-9260-28b58af30480', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f44c16c5e0072', '2015-08-19 14:59:31', '\0', '2015-08-19 14:59:31', '2015-08-19 14:59:31', '659dd676-ce4a-4a1e-bb2f-c629be0f7067', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f44c509ad0075', '2015-08-19 15:03:27', '\0', '2015-08-19 15:03:27', '2015-08-19 15:03:27', 'e005ed1c-8a97-4659-8576-6725717321eb', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f44c57cbe0079', '2015-08-19 15:03:57', '\0', '2015-08-19 15:03:57', '2015-08-19 15:03:57', '33c5faf6-daec-4779-a716-23e547631e98', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f45371ba5007c', '2015-08-19 17:08:03', '\0', '2015-08-19 17:08:03', '2015-08-19 17:08:03', 'ddbce40b-5fe0-4902-b919-4e4ae8afa5bb', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f456f95d90081', '2015-08-19 18:09:44', '\0', '2015-08-19 18:09:44', '2015-08-19 18:09:44', '13ef5f0e-f69b-4e6c-930c-80f4395fec42', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f43f1fb014f457117640084', '2015-08-19 18:11:23', '\0', '2015-08-19 18:11:23', '2015-08-19 18:11:23', 'd06976e3-29b9-4f91-8937-57713174448d', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4a80e83e0002', '2015-08-20 17:46:46', '\0', '2015-08-20 17:46:46', '2015-08-20 17:46:46', '8e953ee9-150a-4daa-9bc3-2c8a491f589f', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f246acc000c', '2015-08-21 15:23:50', '\0', '2015-08-21 15:23:50', '2015-08-21 15:23:50', '0548f06e-c328-43a6-bf9f-ae1cd2fb390c', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f24ed5d000f', '2015-08-21 15:24:24', '\0', '2015-08-21 15:24:24', '2015-08-21 15:24:24', '14a5692a-08ec-4f34-a204-f275aa37d6f4', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f25f2a70013', '2015-08-21 15:25:31', '\0', '2015-08-21 15:25:31', '2015-08-21 15:25:31', 'fa1f3f8b-46b1-4de7-9d03-41239c923822', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f2682c30016', '2015-08-21 15:26:08', '\0', '2015-08-21 15:26:08', '2015-08-21 15:26:08', '0aa69616-ca45-481c-b9d2-6d4c2af7bf34', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f26f9430019', '2015-08-21 15:26:38', '\0', '2015-08-21 15:26:38', '2015-08-21 15:26:38', 'feeddc14-79c5-4ad2-8ff8-9fd0d4519e7a', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f2d80e4001c', '2015-08-21 15:33:46', '\0', '2015-08-21 15:33:46', '2015-08-21 15:33:46', '7834b75a-eb47-4c0e-a647-d7601f10e560', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f3280470020', '2015-08-21 15:39:13', '\0', '2015-08-21 15:39:13', '2015-08-21 15:39:13', 'c84712bc-2327-447c-aa6e-c1c4e20c6828', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f4461ff0023', '2015-08-21 15:58:45', '\0', '2015-08-21 15:58:45', '2015-08-21 15:58:45', '72b20923-dbaa-42db-9db4-78ff51cf8296', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f4577930026', '2015-08-21 15:59:56', '\0', '2015-08-21 15:59:56', '2015-08-21 15:59:56', '66e5443d-1cd4-4886-9220-d6de159e188d', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f4a8cfc0029', '2015-08-21 16:05:29', '\0', '2015-08-21 16:05:29', '2015-08-21 16:05:29', 'df9f8b9a-da05-4fbe-bfd3-d1bea07d710f', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f4a958c002c', '2015-08-21 16:05:32', '\0', '2015-08-21 16:05:32', '2015-08-21 16:05:32', '6fdfeca2-493b-473d-a3b5-83ca6d97da27', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f51fee7002f', '2015-08-21 16:13:37', '\0', '2015-08-21 16:13:37', '2015-08-21 16:13:37', '1656e08b-2dab-4b69-a45b-712b7f63ce16', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f52b8f20032', '2015-08-21 16:14:25', '\0', '2015-08-21 16:14:25', '2015-08-21 16:14:25', 'b8de316c-3bcb-4d3b-9fc9-ea8243fb237b', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f7ad1200035', '2015-08-21 16:58:13', '\0', '2015-08-21 16:58:13', '2015-08-21 16:58:13', '32323ff5-1be8-44d3-89b6-b027dc0b1cc4', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f87b2da0038', '2015-08-21 17:12:17', '\0', '2015-08-21 17:12:17', '2015-08-21 17:12:17', '7243dd7b-06ad-498d-88b2-8367e8b8b730', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f895459003b', '2015-08-21 17:14:04', '\0', '2015-08-21 17:14:04', '2015-08-21 17:14:04', '602ac06e-e134-42c2-933d-33fec458b1ca', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f89d927003e', '2015-08-21 17:14:38', '\0', '2015-08-21 17:14:38', '2015-08-21 17:14:38', '7df01f34-a81e-458b-9cca-cebf2352bcf4', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f8c74980041', '2015-08-21 17:17:29', '\0', '2015-08-21 17:17:29', '2015-08-21 17:17:29', '46938a88-5bde-48e0-b4df-8a2bbecc4543', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f8c95870044', '2015-08-21 17:17:37', '\0', '2015-08-21 17:17:37', '2015-08-21 17:17:37', 'fe25329b-f518-4e73-a890-62d4c12f5e20', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f8cd0b10047', '2015-08-21 17:17:52', '\0', '2015-08-21 17:17:52', '2015-08-21 17:17:52', 'c57e558c-7e1f-4ad2-92f6-475d7739ad18', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f918321004a', '2015-08-21 17:23:00', '\0', '2015-08-21 17:23:00', '2015-08-21 17:23:00', '190e339e-0aa9-4bbf-b4f7-5175da136cdf', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f925894004d', '2015-08-21 17:23:55', '\0', '2015-08-21 17:23:55', '2015-08-21 17:23:55', '4e326c1e-606e-47c9-90ae-d035604effeb', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f927fdd0050', '2015-08-21 17:24:05', '\0', '2015-08-21 17:24:05', '2015-08-21 17:24:05', '3058d0ae-85e7-4009-ac22-7695cbe0b572', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f92b85d0053', '2015-08-21 17:24:19', '\0', '2015-08-21 17:24:19', '2015-08-21 17:24:19', 'e64ba960-f6ce-40fe-9822-c252c9c785e0', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f93a2270056', '2015-08-21 17:25:19', '\0', '2015-08-21 17:25:19', '2015-08-21 17:25:19', '7f970f67-986e-44b9-88e6-2054a75bbe1f', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f9479f60059', '2015-08-21 17:26:14', '\0', '2015-08-21 17:26:14', '2015-08-21 17:26:14', '0e6cd4de-53ef-425e-ba30-9cd1baa0006c', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f94defe005c', '2015-08-21 17:26:40', '\0', '2015-08-21 17:26:40', '2015-08-21 17:26:40', '61e268ba-894e-4472-ac0c-d8d0913feba2', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4f950c1d005f', '2015-08-21 17:26:52', '\0', '2015-08-21 17:26:52', '2015-08-21 17:26:52', '7f95caec-80d5-4d84-a634-44bb0f0a2e70', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4fb74a7a0062', '2015-08-21 18:04:16', '\0', '2015-08-21 18:04:16', '2015-08-21 18:04:16', '619ea324-056a-4b95-aed3-769688cb646b', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4fb7a30e0065', '2015-08-21 18:04:39', '\0', '2015-08-21 18:04:39', '2015-08-21 18:04:39', '24077e3e-8c46-4c2e-9892-404eb3eb330b', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4fb8ec400068', '2015-08-21 18:06:03', '\0', '2015-08-21 18:06:03', '2015-08-21 18:06:03', 'a2843750-89bd-47c6-be8e-c6c11afeed96', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4fb90d3c006b', '2015-08-21 18:06:11', '\0', '2015-08-21 18:06:11', '2015-08-21 18:06:11', 'ef23e894-6c50-42b7-bb93-d7d4fa808e9c', '10', 'faf08f184be41285014c4f457dd70043', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4fbc22a8006e', '2015-08-21 18:09:33', '\0', '2015-08-21 18:09:33', '2015-08-21 18:09:33', '8fc2aeb5-fab5-42bd-bd54-c5e0c2ff5b15', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4fbd09280071', '2015-08-21 18:10:32', '\0', '2015-08-21 18:10:32', '2015-08-21 18:10:32', '07a20267-4581-46f1-aa6d-d0dea2fa9158', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f4fbe74800074', '2015-08-21 18:12:05', '\0', '2015-08-21 18:12:05', '2015-08-21 18:12:05', '08ddabd2-e20f-4cb7-9304-d7f0053d94a6', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f533282da0077', '2015-08-22 10:17:43', '\0', '2015-08-22 10:17:43', '2015-08-22 10:17:43', '94706fb1-129a-4fdb-96dd-bc8cbff218ef', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f533a2829007a', '2015-08-22 10:26:04', '\0', '2015-08-22 10:26:04', '2015-08-22 10:26:04', '0205d372-1ac2-4777-9c56-c706bf39709a', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f533b072d007d', '2015-08-22 10:27:01', '\0', '2015-08-22 10:27:01', '2015-08-22 10:27:01', '048fa940-3c5c-42f6-bbf8-1498fa1265c0', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f4a77e7014f53409bde0080', '2015-08-22 10:33:07', '\0', '2015-08-22 10:33:07', '2015-08-22 10:33:07', '022d0999-c7e3-40b9-a043-7a4415989732', '00', 'faf08f184be41285014c4f457dd70043', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f8d8d61014f936083f30002', '2015-09-03 21:23:40', '\0', '2015-09-03 21:23:40', '2015-09-03 21:23:40', '58d35070-2d6d-4d5e-8864-519d639320ca', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184f8d8d61014f9380262a0005', '2015-09-03 21:58:13', '\0', '2015-09-03 21:58:13', '2015-09-03 21:58:13', 'e4387eba-f708-44ff-a5e7-e87f4b5fb3d1', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004b458dfa014b4a65cb0d0009', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fa5f35c014faac532530001', '2015-09-08 10:24:54', '\0', '2015-09-08 10:24:54', '2015-09-08 10:24:54', '37b7de07-38ba-418d-afce-368af78ff2c7', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faadb33014faaeadef7000b', '2015-09-08 11:06:03', '\0', '2015-09-08 11:06:03', '2015-09-08 11:06:03', 'ce4f45c3-5a56-4a41-98ea-9aee36d7e518', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faadb33014faaeb710a000e', '2015-09-08 11:06:40', '\0', '2015-09-08 11:06:40', '2015-09-08 11:06:40', 'fa2376bf-b5c2-405a-8970-c6fd35175a31', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faadb33014faaec57270013', '2015-09-08 11:07:39', '\0', '2015-09-08 11:07:39', '2015-09-08 11:07:39', 'd56d3d0b-4f92-4ed2-9d91-0f3b738cf2cc', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faadb33014faafba1970018', '2015-09-08 11:24:21', '\0', '2015-09-08 11:24:21', '2015-09-08 11:24:21', '421ebd19-d612-4273-91ad-9f074908e908', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fab0835040004', '2015-09-08 11:38:05', '\0', '2015-09-08 11:38:05', '2015-09-08 11:38:05', '1e6f03c1-70d5-4928-9706-6404f99a2cd7', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fab7c9da70008', '2015-09-08 13:45:14', '\0', '2015-09-08 13:45:14', '2015-09-08 13:45:14', '1c78ae08-f4c4-4f61-9a67-652be8d90047', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014faba73aca000c', '2015-09-08 14:31:47', '\0', '2015-09-08 14:31:47', '2015-09-08 14:31:47', '6b38c966-d204-4174-bf25-0b3d2191ddc9', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014faba780c2000f', '2015-09-08 14:32:05', '\0', '2015-09-08 14:32:05', '2015-09-08 14:32:05', '227a49be-4b28-4fdf-bcd5-6652cdfe8d12', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fac5dea9c00bd', '2015-09-08 17:51:20', '\0', '2015-09-08 17:51:20', '2015-09-08 17:51:20', '44ab5d69-555d-4c69-99bc-54b95552e794', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fac6e36be00c0', '2015-09-08 18:09:08', '\0', '2015-09-08 18:09:08', '2015-09-08 18:09:08', 'd16459b4-21ba-4019-8478-87b6fc418e50', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafbebe1300c3', '2015-09-09 09:35:57', '\0', '2015-09-09 09:35:57', '2015-09-09 09:35:57', '8182470f-428b-471b-9b2f-c62a2e51b877', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafc02f3800c6', '2015-09-09 09:37:31', '\0', '2015-09-09 09:37:31', '2015-09-09 09:37:31', '2414c820-8c68-48ca-98b8-700486d179bb', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafc0863b00c9', '2015-09-09 09:37:54', '\0', '2015-09-09 09:37:54', '2015-09-09 09:37:54', '91fbcc7e-238c-49f8-b21a-68aa7612bc28', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafc1622c00cc', '2015-09-09 09:38:50', '\0', '2015-09-09 09:38:50', '2015-09-09 09:38:50', '1016cf34-1b3c-4a2a-a417-9e88ab166613', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafc23edc00cf', '2015-09-09 09:39:47', '\0', '2015-09-09 09:39:47', '2015-09-09 09:39:47', 'b1e0364c-e33e-40bb-864b-7ce44b4be160', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafc30f8100d2', '2015-09-09 09:40:40', '\0', '2015-09-09 09:40:40', '2015-09-09 09:40:40', '28c33e4b-dc91-4fd8-83c8-cbad13ebadc9', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafc3378500d5', '2015-09-09 09:40:50', '\0', '2015-09-09 09:40:50', '2015-09-09 09:40:50', '6b1ae030-7e3c-42fb-b620-609bb5b861f6', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafc35ca600d8', '2015-09-09 09:41:00', '\0', '2015-09-09 09:41:00', '2015-09-09 09:41:00', '04958776-fb39-4b10-902b-035397a6a80c', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafcb73f200db', '2015-09-09 09:49:50', '\0', '2015-09-09 09:49:50', '2015-09-09 09:49:50', 'd8f313eb-1168-420d-b6b2-0b9862093226', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafcc28fe00de', '2015-09-09 09:50:36', '\0', '2015-09-09 09:50:36', '2015-09-09 09:50:36', '79acd1fc-b7a9-4dca-a588-9a093198e00f', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafcc5e7a00e1', '2015-09-09 09:50:50', '\0', '2015-09-09 09:50:50', '2015-09-09 09:50:50', 'dc83eaa1-b655-4ad0-884d-96fec755e46f', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafcd87a900e4', '2015-09-09 09:52:06', '\0', '2015-09-09 09:52:06', '2015-09-09 09:52:06', '991c047e-3da7-4f10-b73e-9cca42f0b46e', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafcef03f00e7', '2015-09-09 09:53:38', '\0', '2015-09-09 09:53:38', '2015-09-09 09:53:38', 'a7615bc5-8402-4795-a5f9-1f7bd56b2587', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafcf8f3600ea', '2015-09-09 09:54:19', '\0', '2015-09-09 09:54:19', '2015-09-09 09:54:19', 'e139646c-e9a8-49ee-831b-eac543ecf998', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafd0993000ed', '2015-09-09 09:55:27', '\0', '2015-09-09 09:55:27', '2015-09-09 09:55:27', 'af6a7a72-f7e5-4b70-b398-64c5256befae', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafd2246300f0', '2015-09-09 09:57:08', '\0', '2015-09-09 09:57:08', '2015-09-09 09:57:08', '91449c79-35b4-4c02-840b-497b546c1fc0', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafd7513f00f3', '2015-09-09 10:02:47', '\0', '2015-09-09 10:02:47', '2015-09-09 10:02:47', '11c2915f-2004-402a-bba9-237133688d36', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafd8664000f6', '2015-09-09 10:03:58', '\0', '2015-09-09 10:03:58', '2015-09-09 10:03:58', '2dec4b77-9096-4b61-a501-94aa59d65785', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafdec61100f9', '2015-09-09 10:10:56', '\0', '2015-09-09 10:10:56', '2015-09-09 10:10:56', '76c67fb8-e54b-40da-b3fc-35c296ad633a', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafdf853300fc', '2015-09-09 10:11:45', '\0', '2015-09-09 10:11:45', '2015-09-09 10:11:45', '8117ba67-dae7-4972-a6fb-624fd372addc', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafe06c1700ff', '2015-09-09 10:12:44', '\0', '2015-09-09 10:12:44', '2015-09-09 10:12:44', '58e1962a-66a9-4a22-938c-397628158aa9', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafe15de70102', '2015-09-09 10:13:46', '\0', '2015-09-09 10:13:46', '2015-09-09 10:13:46', '5b69b7d7-6a4d-41e3-a4c7-2e29961e6ddc', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafe796b60105', '2015-09-09 10:20:34', '\0', '2015-09-09 10:20:34', '2015-09-09 10:20:34', 'e0e4b5ed-bf56-4b84-8ec9-935e3142752a', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fafe98c9c0108', '2015-09-09 10:22:42', '\0', '2015-09-09 10:22:42', '2015-09-09 10:22:42', 'a0d4f4d0-a759-4d17-b240-a65ec54c7e86', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb0003271010b', '2015-09-09 10:47:27', '\0', '2015-09-09 10:47:27', '2015-09-09 10:47:27', '491bdef1-ad4a-413a-a620-72b935270d97', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb000bd40010e', '2015-09-09 10:48:02', '\0', '2015-09-09 10:48:02', '2015-09-09 10:48:02', 'ad3c3de1-267f-4574-9f10-e4820566ef0e', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb00190b80111', '2015-09-09 10:48:56', '\0', '2015-09-09 10:48:56', '2015-09-09 10:48:56', '5cdc6f95-5d3e-4f02-a4d9-e0aae1e54a37', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb0100c010114', '2015-09-09 11:04:45', '\0', '2015-09-09 11:04:45', '2015-09-09 11:04:45', 'ebae1e17-c4ac-46c6-be06-3205bf84101d', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb01046ab0117', '2015-09-09 11:05:00', '\0', '2015-09-09 11:05:00', '2015-09-09 11:05:00', '719ea7a5-6dca-4317-9dfd-5b26562cd23f', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb010b69a011a', '2015-09-09 11:05:29', '\0', '2015-09-09 11:05:29', '2015-09-09 11:05:29', '43ee6d3c-31e6-45ed-be3f-2ec57f560d98', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb01459a1011d', '2015-09-09 11:09:27', '\0', '2015-09-09 11:09:27', '2015-09-09 11:09:27', '7960012c-49aa-4f06-881d-f1b82d11ea50', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb02b2f5a0120', '2015-09-09 11:34:24', '\0', '2015-09-09 11:34:24', '2015-09-09 11:34:24', '8d10385c-2ccb-4983-b021-97f40ffd0e68', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb02ba67f0123', '2015-09-09 11:34:54', '\0', '2015-09-09 11:34:54', '2015-09-09 11:34:54', '067ee178-effe-4cb9-9017-4e6cab2993ec', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb02c76d30126', '2015-09-09 11:35:48', '\0', '2015-09-09 11:35:48', '2015-09-09 11:35:48', 'e16ff26a-1495-4854-bd89-1c63ea869a52', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb02dbde20129', '2015-09-09 11:37:11', '\0', '2015-09-09 11:37:11', '2015-09-09 11:37:11', '9b9aa50d-e3e3-4dbd-9bee-2b373aafc6a4', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb02e93c1012c', '2015-09-09 11:38:06', '\0', '2015-09-09 11:38:06', '2015-09-09 11:38:06', '6f32ed03-ce96-41c8-967e-a2f19e8534d8', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb03187660131', '2015-09-09 11:41:20', '\0', '2015-09-09 11:41:20', '2015-09-09 11:41:20', '297958d4-2ef3-463d-987c-ebbf75952c0a', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb035402d0134', '2015-09-09 11:45:24', '\0', '2015-09-09 11:45:24', '2015-09-09 11:45:24', '997c08b2-702a-44df-9f36-3cba317ecd46', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb035c0000137', '2015-09-09 11:45:56', '\0', '2015-09-09 11:45:56', '2015-09-09 11:45:56', '2ffc33e2-e60c-4c69-8cfc-816dcb80b06e', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb03614f7013a', '2015-09-09 11:46:18', '\0', '2015-09-09 11:46:18', '2015-09-09 11:46:18', '35d6b65c-e848-4dd6-ae09-e1ef23bdc993', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb03be0ec013d', '2015-09-09 11:52:38', '\0', '2015-09-09 11:52:38', '2015-09-09 11:52:38', '86ea80e9-7a09-4312-a307-745f87781a0e', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb03c57970140', '2015-09-09 11:53:08', '\0', '2015-09-09 11:53:08', '2015-09-09 11:53:08', '006cbe19-4cba-4587-b2d3-faa6356ede23', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb03ca7090143', '2015-09-09 11:53:29', '\0', '2015-09-09 11:53:29', '2015-09-09 11:53:29', 'b9b27484-7f9e-4fcd-a00b-749d773e5b49', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb03cf8c60146', '2015-09-09 11:53:50', '\0', '2015-09-09 11:53:50', '2015-09-09 11:53:50', 'f899134f-96fe-475d-af62-ead0fc099545', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb03ddc8f0149', '2015-09-09 11:54:48', '\0', '2015-09-09 11:54:48', '2015-09-09 11:54:48', 'fd200178-53d7-4457-bfc6-b4b30854dd69', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb0415a560154', '2015-09-09 11:58:37', '\0', '2015-09-09 11:58:37', '2015-09-09 11:58:37', '1b2e79b5-8622-401e-a77c-167815c5b029', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb041d9690157', '2015-09-09 11:59:09', '\0', '2015-09-09 11:59:09', '2015-09-09 11:59:09', '51c472e7-8ad6-4601-82f8-e10d565d0587', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb0452d89015a', '2015-09-09 12:02:47', '\0', '2015-09-09 12:02:47', '2015-09-09 12:02:47', 'f71d1dc4-ff34-465d-9ebe-bc3e83761b4b', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb0460ba0015d', '2015-09-09 12:03:44', '\0', '2015-09-09 12:03:44', '2015-09-09 12:03:44', '1f22d369-14d9-43c2-b181-d718cf4db85b', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb047b1ba0160', '2015-09-09 12:05:32', '\0', '2015-09-09 12:05:32', '2015-09-09 12:05:32', 'd2bf8295-7c5f-4684-a0f0-0babb3fb340d', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb049f72b0163', '2015-09-09 12:08:01', '\0', '2015-09-09 12:08:01', '2015-09-09 12:08:01', '46b5f16f-74df-4c69-ae29-160cbd59dd71', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184faafe6b014fb04a6ad00166', '2015-09-09 12:08:31', '\0', '2015-09-09 12:08:31', '2015-09-09 12:08:31', 'c59cd075-82c4-497b-a64c-5f71f71544ad', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fa5f69c014fa6985f9a0004', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb112d2014fb11ccfa40001', '2015-09-09 15:58:19', '\0', '2015-09-09 15:58:19', '2015-09-09 15:58:19', 'd3fe6a0b-6cbb-4b94-bcf6-3b88a8d1e5c1', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb112d2014fb11d4b220004', '2015-09-09 15:58:51', '\0', '2015-09-09 15:58:51', '2015-09-09 15:58:51', '65470f3d-09c0-45ed-b863-8f35fa8a8f08', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fb080f6014fb0fae95b0006', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb112d2014fb11d9b370007', '2015-09-09 15:59:11', '\0', '2015-09-09 15:59:11', '2015-09-09 15:59:11', '8ef3777d-1e70-4ee5-a3f2-5b0c05cc9808', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb112d2014fb11dfc47000a', '2015-09-09 15:59:36', '\0', '2015-09-09 15:59:36', '2015-09-09 15:59:36', '83f403b9-6504-47a2-9477-a066d2f82e18', '10', '000000004b1fafb1014b1fcf8dc50001', '000000004fb080f6014fb0fae95b0006', 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb112d2014fb11e1f76000d', '2015-09-09 15:59:45', '\0', '2015-09-09 15:59:45', '2015-09-09 15:59:45', '305a82c7-266d-46d2-9d65-d8ef7427f78f', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb13600ea0001', '2015-09-09 16:25:50', '\0', '2015-09-09 16:25:50', '2015-09-09 16:25:50', '72913847-fcaf-46a0-ad33-4d00fdbd0115', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb136f3c20004', '2015-09-09 16:26:52', '\0', '2015-09-09 16:26:52', '2015-09-09 16:26:52', '4a4af4af-3707-4903-bd16-fcd22c59852c', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb15d4aae0027', '2015-09-09 17:08:45', '\0', '2015-09-09 17:08:45', '2015-09-09 17:08:45', 'c1061487-a24a-415d-8009-cccfde0aba18', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb15da62a002a', '2015-09-09 17:09:08', '\0', '2015-09-09 17:09:08', '2015-09-09 17:09:08', 'e2ca6341-11be-42d7-9a19-176aab83d9e8', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb15ebc26002d', '2015-09-09 17:10:19', '\0', '2015-09-09 17:10:19', '2015-09-09 17:10:19', 'd7660f5f-9894-4d34-b962-7373a7930bc6', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb15ed77b0030', '2015-09-09 17:10:26', '\0', '2015-09-09 17:10:26', '2015-09-09 17:10:26', '4f2e3c55-a0c2-4cd1-bdf7-64c86c2cc92a', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb15f87ce0033', '2015-09-09 17:11:12', '\0', '2015-09-09 17:11:12', '2015-09-09 17:11:12', 'd4c5ebcb-5039-40ae-b51c-be4c13da6b50', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb16961dd0036', '2015-09-09 17:21:57', '\0', '2015-09-09 17:21:57', '2015-09-09 17:21:57', '2dffb3af-0839-40ff-a049-97d2e4395a9b', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb1697bd10039', '2015-09-09 17:22:04', '\0', '2015-09-09 17:22:04', '2015-09-09 17:22:04', '6f2d132c-082a-43cd-85e8-a33c8ec857f9', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb16a86b2003c', '2015-09-09 17:23:12', '\0', '2015-09-09 17:23:12', '2015-09-09 17:23:12', '86976563-e5fa-4589-a2dd-e05ab5a68915', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb17f4d5a003f', '2015-09-09 17:45:54', '\0', '2015-09-09 17:45:54', '2015-09-09 17:45:54', '5ee22dc2-bb0b-439f-b7a5-e6a5b11e275a', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb1810f5e0042', '2015-09-09 17:47:49', '\0', '2015-09-09 17:47:49', '2015-09-09 17:47:49', '18561903-a9e5-4640-b00d-21778e36344f', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb1be2b120045', '2015-09-09 18:54:34', '\0', '2015-09-09 18:54:34', '2015-09-09 18:54:34', '3622965f-0b2a-4b41-a83f-1e33af38ccd3', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb1c79b8b0048', '2015-09-09 19:04:52', '\0', '2015-09-09 19:04:52', '2015-09-09 19:04:52', 'e30a57c4-bab5-45f1-b90d-caf3de6e9e02', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb1c7cd77004b', '2015-09-09 19:05:05', '\0', '2015-09-09 19:05:05', '2015-09-09 19:05:05', 'ea4bc687-1fda-47cb-9508-45703f4c96c9', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb1ca5d4d004e', '2015-09-09 19:07:53', '\0', '2015-09-09 19:07:53', '2015-09-09 19:07:53', 'e29bf567-413d-475d-a3da-c16557746ec6', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb1ca94040051', '2015-09-09 19:08:07', '\0', '2015-09-09 19:08:07', '2015-09-09 19:08:07', 'a74a1116-7e38-45ca-ad54-7de4efcd3eff', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb4e391050054', '2015-09-10 09:34:16', '\0', '2015-09-10 09:34:16', '2015-09-10 09:34:16', 'e9026ad3-49c9-4541-82e5-9804e73f03d5', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb4e49cff0057', '2015-09-10 09:35:25', '\0', '2015-09-10 09:35:25', '2015-09-10 09:35:25', '697e807a-ef6c-402f-a6e9-5a7debd20d66', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb4e53a60005a', '2015-09-10 09:36:05', '\0', '2015-09-10 09:36:05', '2015-09-10 09:36:05', 'fa8f4431-cda0-45d7-94a1-37d151fadb53', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb4e581b0005d', '2015-09-10 09:36:23', '\0', '2015-09-10 09:36:23', '2015-09-10 09:36:23', '5524fb66-829c-45c9-80bb-e4b207cf2806', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb4e5e8b30060', '2015-09-10 09:36:50', '\0', '2015-09-10 09:36:50', '2015-09-10 09:36:50', '42019959-1f1b-4404-8d04-f82b423e1997', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb4e6952f0063', '2015-09-10 09:37:34', '\0', '2015-09-10 09:37:34', '2015-09-10 09:37:34', '02f114f9-1be7-4126-80be-63f6bc0642a5', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb4e826e20066', '2015-09-10 09:39:17', '\0', '2015-09-10 09:39:17', '2015-09-10 09:39:17', 'e0adc3f9-3824-4cce-acd4-ad94f4c02b44', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb4e8b2aa0069', '2015-09-10 09:39:53', '\0', '2015-09-10 09:39:53', '2015-09-10 09:39:53', 'ca21c751-11c2-4dc3-9efd-4217891a3e22', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb4e9a59b006c', '2015-09-10 09:40:55', '\0', '2015-09-10 09:40:55', '2015-09-10 09:40:55', 'fb30d05a-f618-4a43-afb9-042f4ab0e0f8', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb4ecf30b006f', '2015-09-10 09:44:31', '\0', '2015-09-10 09:44:31', '2015-09-10 09:44:31', '847eb390-9958-4930-8f74-3f4545e2e9f1', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb4ee1d2d0072', '2015-09-10 09:45:48', '\0', '2015-09-10 09:45:48', '2015-09-10 09:45:48', '834d7dd0-2be9-4cd0-b2f1-7479f5de0a81', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb4f316df0075', '2015-09-10 09:51:14', '\0', '2015-09-10 09:51:14', '2015-09-10 09:51:14', 'ae87a6a4-30d9-455a-beaa-4ac320c41d51', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb4f353bb0078', '2015-09-10 09:51:29', '\0', '2015-09-10 09:51:29', '2015-09-10 09:51:29', 'aaa5d620-5b6d-4d9a-b071-35a99c1979df', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb4f6ce6e007b', '2015-09-10 09:55:17', '\0', '2015-09-10 09:55:17', '2015-09-10 09:55:17', '53a65cf7-694c-4ecb-a85d-bcb6bfa0e1b0', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb4f982ce007e', '2015-09-10 09:58:14', '\0', '2015-09-10 09:58:14', '2015-09-10 09:58:14', 'd2c47eb7-b5d7-48cb-9717-3cedab1f852c', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');
INSERT INTO `integral_order` VALUES ('faf08f184fb13015014fb4fa1b3f0081', '2015-09-10 09:58:54', '\0', '2015-09-10 09:58:54', '2015-09-10 09:58:54', 'e8824a9f-48a9-4a47-9377-cfcd4f7fb963', '00', '000000004b1fafb1014b1fcf8dc50001', null, 'faf08f184f69691e014f698429e3000d');

-- ----------------------------
-- Table structure for medias
-- ----------------------------
DROP TABLE IF EXISTS `medias`;
CREATE TABLE `medias` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `content_type` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_size` bigint(20) DEFAULT NULL,
  `origin_file_name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `server_address` varchar(255) DEFAULT NULL,
  `server_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medias
-- ----------------------------
INSERT INTO `medias` VALUES ('4040409e4fb53475014fb539ba900000', '2015-09-10 11:08:24', '\0', '2015-09-10 11:08:24', 'image/jpeg', '0d4f3d64-a6d3-4d39-93f7-b15d39c5abce.jpg', '7197', '123.jpg', '/resources/image/0d4f3d64-a6d3-4d39-93f7-b15d39c5abce.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('4040409e4fb53475014fb539ba950001', '2015-09-10 11:08:24', '\0', '2015-09-10 11:08:24', 'image/jpeg', 'eca5bb72-5edd-4776-826e-a311ba919746.jpeg', '78582', 'fdaef1ea2eea7ff3d539c904.jpeg', '/resources/image/eca5bb72-5edd-4776-826e-a311ba919746.jpeg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('4040409e4fb53475014fb53a20fd0002', '2015-09-10 11:08:50', '\0', '2015-09-10 11:08:50', 'image/jpeg', '5d33c95f-a468-443b-b992-fc5e63d6aed0.jpg', '7197', '123.jpg', '/resources/image/5d33c95f-a468-443b-b992-fc5e63d6aed0.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('4040409e4fb53475014fb53a20fe0003', '2015-09-10 11:08:50', '\0', '2015-09-10 11:08:50', 'image/jpeg', '0be20276-be17-4418-9970-9a1b169cd35e.jpeg', '92100', '20140319211347_QYst5.jpeg', '/resources/image/0be20276-be17-4418-9970-9a1b169cd35e.jpeg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('4040409e4fb53475014fb53a79d50004', '2015-09-10 11:09:13', '\0', '2015-09-10 11:09:13', 'image/jpeg', '83cf062a-bff6-4361-9621-8693f230b949.jpg', '7197', '123.jpg', '/resources/image/83cf062a-bff6-4361-9621-8693f230b949.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('4040409e4fb53475014fb53a79d60005', '2015-09-10 11:09:13', '\0', '2015-09-10 11:09:13', 'image/jpeg', 'aedda7d1-d9bc-4147-9902-c68a8fe8032b.jpeg', '69530', '20130907222849_CF2Bv.jpeg', '/resources/image/aedda7d1-d9bc-4147-9902-c68a8fe8032b.jpeg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('4040409e4fb53475014fb53b6c940006', '2015-09-10 11:10:15', '\0', '2015-09-10 11:10:15', 'image/jpeg', 'db48c39a-74fa-4dde-8325-d70e2397f58b.jpg', '15751', '1-140H6103113.jpg', '/resources/image/db48c39a-74fa-4dde-8325-d70e2397f58b.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('4040409e4fb53475014fb53b6c950007', '2015-09-10 11:10:15', '\0', '2015-09-10 11:10:15', 'image/jpeg', 'a833e222-1eed-41fe-a631-9e44ead2c77a.jpg', '346627', '37a.jpg', '/resources/image/a833e222-1eed-41fe-a631-9e44ead2c77a.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('4040409e4fb53475014fb53bc0600008', '2015-09-10 11:10:36', '\0', '2015-09-10 11:10:36', 'image/jpeg', 'e8c6bd8e-a386-45e6-931f-8d83ffad9eac.jpg', '6568', '5019d66eef7ed_200x200_3.jpg', '/resources/image/e8c6bd8e-a386-45e6-931f-8d83ffad9eac.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('4040409e4fb53475014fb53bc0610009', '2015-09-10 11:10:36', '\0', '2015-09-10 11:10:36', 'image/jpeg', '5f41fcb4-9303-41cd-84e8-b1f4fdbd5062.jpeg', '184762', '20120516121232_djirU.jpeg', '/resources/image/5f41fcb4-9303-41cd-84e8-b1f4fdbd5062.jpeg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('4040409e4fb53475014fb53c25ee000a', '2015-09-10 11:11:02', '\0', '2015-09-10 11:11:02', 'image/jpeg', '79fbf057-b4e0-411e-8659-0a0501a9bad0.jpg', '15751', '1-140H6103113.jpg', '/resources/image/79fbf057-b4e0-411e-8659-0a0501a9bad0.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('4040409e4fb53475014fb53c25ef000b', '2015-09-10 11:11:02', '\0', '2015-09-10 11:11:02', 'image/jpeg', 'c61ff226-ca4b-43a7-8804-b6378a521399.jpg', '97266', 'benbenla-04b.jpg', '/resources/image/c61ff226-ca4b-43a7-8804-b6378a521399.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('4040409e4fb54196014fb5456a430000', '2015-09-10 11:21:09', '\0', '2015-09-10 11:21:09', 'image/jpeg', 'e4f386e7-4a21-47ed-aed2-81e9f8e8a393.jpg', '7197', '123.jpg', '/resources/image/e4f386e7-4a21-47ed-aed2-81e9f8e8a393.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('4040409e4fb54196014fb5456a5d0001', '2015-09-10 11:21:09', '\0', '2015-09-10 11:21:09', 'image/jpeg', '8ebad977-eccf-4957-a75a-5064504c4ab0.jpg', '178890', '102T3J63-4.jpg', '/resources/image/8ebad977-eccf-4957-a75a-5064504c4ab0.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184efba4cb014efbaa6c9e0000', '2015-08-05 10:22:06', '\0', '2015-08-05 10:22:06', 'image/jpeg', '678b276a-5528-432b-b894-0f5e3a80e7bf.jpg', '43257', '20110722164343_SzYdV.thumb.600_0.jpg', '/resources/image/678b276a-5528-432b-b894-0f5e3a80e7bf.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184efba4cb014efbaab5750002', '2015-08-05 10:22:25', '\0', '2015-08-05 10:22:25', 'image/jpeg', '0b8215c8-1a09-458c-b2e2-67d5fbc60d70.jpg', '52471', '3181141_233425002_2.jpg', '/resources/image/0b8215c8-1a09-458c-b2e2-67d5fbc60d70.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184efba4cb014efbab1e840004', '2015-08-05 10:22:52', '\0', '2015-08-05 10:22:52', 'image/jpeg', 'e27a0e01-e220-4668-993f-535667f61c1e.jpg', '7197', '123.jpg', '/resources/image/e27a0e01-e220-4668-993f-535667f61c1e.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184efba4cb014efbab5c780007', '2015-08-05 10:23:08', '\0', '2015-08-05 10:23:08', 'image/jpeg', 'ca13010e-812d-489f-a6f7-8050b890333a.jpg', '15751', '1-140H6103113.jpg', '/resources/image/ca13010e-812d-489f-a6f7-8050b890333a.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184efba4cb014efbab9ffd0009', '2015-08-05 10:23:25', '\0', '2015-08-05 10:23:25', 'image/jpeg', '41979013-4485-4102-8dc6-530d3d6a027e.jpg', '67926', 'f1ae46b3-a062-41ef-b7df-15fe20ac68b4.jpg', '/resources/image/41979013-4485-4102-8dc6-530d3d6a027e.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184efba4cb014efbabf510000c', '2015-08-05 10:23:47', '\0', '2015-08-05 10:23:47', 'image/jpeg', '10191485-3147-465d-a2c7-afe288677d4c.jpg', '7197', '123.jpg', '/resources/image/10191485-3147-465d-a2c7-afe288677d4c.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184efba4cb014efbac81e6000f', '2015-08-05 10:24:23', '\0', '2015-08-05 10:24:23', 'image/jpeg', '21afe45c-59e4-4fa6-b0fc-23fcfe25f2af.jpg', '8069', 'u=1061909903,1693641070&fm=21&gp=0.jpg', '/resources/image/21afe45c-59e4-4fa6-b0fc-23fcfe25f2af.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184f2bb57e014f2bb699e00000', '2015-08-14 18:17:11', '\0', '2015-08-14 18:17:11', 'image/jpeg', '3518f44b-d448-4346-b321-7c183533a2f4.jpg', '7197', '123.jpg', '/resources/image/3518f44b-d448-4346-b321-7c183533a2f4.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184f3ec63f014f3fb49b980000', '2015-08-18 15:27:25', '\0', '2015-08-18 15:27:25', 'image/jpeg', '37c613ce-f074-4884-a720-ef25223be785.jpg', '43257', '20110722164343_SzYdV.thumb.600_0.jpg', '/resources/image/37c613ce-f074-4884-a720-ef25223be785.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184f43f1fb014f442425f3003f', '2015-08-19 12:07:43', '\0', '2015-08-19 12:07:43', 'image/jpeg', '7816690d-0d79-407f-9418-1ddd7000efe3.jpg', '23727', '1576296051.jpg', '/resources/image/7816690d-0d79-407f-9418-1ddd7000efe3.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184f43f1fb014f44263e650042', '2015-08-19 12:10:01', '\0', '2015-08-19 12:10:01', 'image/jpeg', '9d82c2f9-329c-41b6-ae6c-5897932d8601.jpg', '6568', '5019d66eef7ed_200x200_3.jpg', '/resources/image/9d82c2f9-329c-41b6-ae6c-5897932d8601.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184f4a77e7014f4a88d3d20004', '2015-08-20 17:55:25', '\0', '2015-08-20 17:55:25', 'image/jpeg', '5f36cb46-be4f-40a7-8fec-a6eec18647f3.jpg', '7197', '123.jpg', '/resources/image/5f36cb46-be4f-40a7-8fec-a6eec18647f3.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184f4a77e7014f4a8b45b60007', '2015-08-20 17:58:05', '\0', '2015-08-20 17:58:05', 'image/jpeg', '56ec9cb9-845b-4e12-9be9-f50f1f05771c.jpg', '8069', 'u=1061909903,1693641070&fm=21&gp=0.jpg', '/resources/image/56ec9cb9-845b-4e12-9be9-f50f1f05771c.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184f69691e014f698429c3000c', '2015-08-26 18:18:33', '\0', '2015-08-26 18:18:33', 'image/jpeg', 'b7cbd311-c432-4ced-a66b-bfb9eb1653c4.jpg', '6568', '5019d66eef7ed_200x200_3.jpg', '/resources/image/b7cbd311-c432-4ced-a66b-bfb9eb1653c4.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fa58458014fa5bf9c92000a', '2015-09-07 11:00:42', '\0', '2015-09-07 11:00:42', 'image/jpeg', '2aec449b-3a00-4564-bc93-8ed7959a7cbd.jpg', '6568', '5019d66eef7ed_200x200_3.jpg', '/resources/image/2aec449b-3a00-4564-bc93-8ed7959a7cbd.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fa58458014fa5c22d5f000e', '2015-09-07 11:03:30', '\0', '2015-09-07 11:03:30', 'image/jpeg', 'd7975068-4242-4749-97bf-3b9100b9067a.jpg', '23727', '1576296051.jpg', '/resources/image/d7975068-4242-4749-97bf-3b9100b9067a.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fa58458014fa5c2f43c0014', '2015-09-07 11:04:21', '\0', '2015-09-07 11:04:21', 'image/jpeg', '22f3c650-cd44-41a0-a3b0-6256c12a64b1.jpg', '8069', 'u=1061909903,1693641070&fm=21&gp=0.jpg', '/resources/image/22f3c650-cd44-41a0-a3b0-6256c12a64b1.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fa58458014fa5c953f20018', '2015-09-07 11:11:19', '\0', '2015-09-07 11:11:19', 'image/jpeg', 'fdb7a3ad-b02c-46ef-9301-08f26abebd87.jpg', '52471', '3181141_233425002_2.jpg', '/resources/image/fdb7a3ad-b02c-46ef-9301-08f26abebd87.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fa58458014fa5cb3ff5001c', '2015-09-07 11:13:24', '\0', '2015-09-07 11:13:24', 'image/jpeg', '1362133e-ea9c-4b49-8192-a4a2fc849ee1.jpg', '43257', '20110722164343_SzYdV.thumb.600_0.jpg', '/resources/image/1362133e-ea9c-4b49-8192-a4a2fc849ee1.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faacc80014faad1bcbc0003', '2015-09-08 10:38:36', '\0', '2015-09-08 10:38:36', 'image/jpeg', 'aef97ba7-6cd5-490a-a9bb-74e6aebf85af.jpg', '19542', '015130.69385977_500.jpg', '/resources/image/aef97ba7-6cd5-490a-a9bb-74e6aebf85af.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faacc80014faad240ff0004', '2015-09-08 10:39:10', '\0', '2015-09-08 10:39:10', 'image/jpeg', '892d0da3-07cd-48be-90d4-42980a518dd2.jpg', '7197', '123.jpg', '/resources/image/892d0da3-07cd-48be-90d4-42980a518dd2.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faacc80014faad2cfdb0006', '2015-09-08 10:39:46', '\0', '2015-09-08 10:39:46', 'image/jpeg', 'f165ce48-4d9c-43b8-a1c4-7d314ba03b79.jpeg', '92100', '20140319211347_QYst5.jpeg', '/resources/image/f165ce48-4d9c-43b8-a1c4-7d314ba03b79.jpeg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faacc80014faad370be0007', '2015-09-08 10:40:27', '\0', '2015-09-08 10:40:27', 'image/jpeg', 'e2747d41-6716-46f3-8921-e459dea86c44.jpg', '6568', '5019d66eef7ed_200x200_3.jpg', '/resources/image/e2747d41-6716-46f3-8921-e459dea86c44.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faacc80014faad370bf0008', '2015-09-08 10:40:27', '\0', '2015-09-08 10:40:27', 'image/jpeg', 'b4c0d216-7f66-4b21-967a-6e15166c4589.jpeg', '78582', 'fdaef1ea2eea7ff3d539c904.jpeg', '/resources/image/b4c0d216-7f66-4b21-967a-6e15166c4589.jpeg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faacc80014faad449510009', '2015-09-08 10:41:23', '\0', '2015-09-08 10:41:23', 'image/jpeg', '4ba6f89e-6fbf-4c87-b39a-236b556312fd.jpg', '8069', 'u=1061909903,1693641070&fm=21&gp=0.jpg', '/resources/image/4ba6f89e-6fbf-4c87-b39a-236b556312fd.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faacc80014faad4aca6000b', '2015-09-08 10:41:48', '\0', '2015-09-08 10:41:48', 'image/jpeg', '78939bdf-28a0-4858-8383-2f68cbf46472.jpeg', '92100', '20140319211347_QYst5.jpeg', '/resources/image/78939bdf-28a0-4858-8383-2f68cbf46472.jpeg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faacc80014faad57af5000d', '2015-09-08 10:42:41', '\0', '2015-09-08 10:42:41', 'image/jpeg', 'e2b34924-dcf5-4c94-9105-be1e5f681a52.jpg', '15751', '1-140H6103113.jpg', '/resources/image/e2b34924-dcf5-4c94-9105-be1e5f681a52.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faacc80014faad5cfe3000f', '2015-09-08 10:43:03', '\0', '2015-09-08 10:43:03', 'image/jpeg', '4b61f2c5-3cce-4d9e-8b62-1a07f31bcaae.jpg', '178890', '102T3J63-4.jpg', '/resources/image/4b61f2c5-3cce-4d9e-8b62-1a07f31bcaae.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faacc80014faad68d750010', '2015-09-08 10:43:51', '\0', '2015-09-08 10:43:51', 'image/jpeg', '51eac8ba-9d5d-499d-9107-467b121ddc6d.jpeg', '78582', 'fdaef1ea2eea7ff3d539c904.jpeg', '/resources/image/51eac8ba-9d5d-499d-9107-467b121ddc6d.jpeg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faadb33014faadbba5e0000', '2015-09-08 10:49:30', '\0', '2015-09-08 10:49:30', 'image/jpeg', '67caf549-a841-4cae-b89c-0a62968c7843.jpg', '346627', '37a.jpg', '/resources/image/67caf549-a841-4cae-b89c-0a62968c7843.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faadb33014faadbe9360001', '2015-09-08 10:49:42', '\0', '2015-09-08 10:49:42', 'image/jpeg', '337f884d-c03b-464d-8d78-19d9405ff88e.jpeg', '92100', '20140319211347_QYst5.jpeg', '/resources/image/337f884d-c03b-464d-8d78-19d9405ff88e.jpeg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faadb33014faadc1b140002', '2015-09-08 10:49:55', '\0', '2015-09-08 10:49:55', 'image/jpeg', '01c76cbc-2575-46e7-81e6-6585c9132989.jpg', '178890', '102T3J63-4.jpg', '/resources/image/01c76cbc-2575-46e7-81e6-6585c9132989.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faadb33014faadc460c0003', '2015-09-08 10:50:06', '\0', '2015-09-08 10:50:06', 'image/jpeg', 'e02afe1c-b315-4bfe-b4af-382bb71c6385.jpg', '19542', '015130.69385977_500.jpg', '/resources/image/e02afe1c-b315-4bfe-b4af-382bb71c6385.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faadb33014faadc6cf50004', '2015-09-08 10:50:16', '\0', '2015-09-08 10:50:16', 'image/jpeg', 'b2d34406-8ca8-4c0d-88fe-ee505f752f7c.jpeg', '78582', 'fdaef1ea2eea7ff3d539c904.jpeg', '/resources/image/b2d34406-8ca8-4c0d-88fe-ee505f752f7c.jpeg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faadb33014faae31c510005', '2015-09-08 10:57:34', '\0', '2015-09-08 10:57:34', 'image/jpeg', 'e1fea2ec-ace8-4e58-a2eb-a542d4abe30f.jpg', '215337', 'aHR0cDovL2ltYWdlLnRpYW5qaW1lZGlhLmNvbS91cGxvYWRJbWFnZXMvMjAxMy8xNTYvUjFKODE0NTlRSVFLLmpwZw==.jpg', '/resources/image/e1fea2ec-ace8-4e58-a2eb-a542d4abe30f.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faadb33014faae36dd40006', '2015-09-08 10:57:55', '\0', '2015-09-08 10:57:55', 'image/jpeg', 'e2818770-2821-4dcb-866b-e12e2fa347be.jpeg', '68232', '20140519211855_kPNSf.jpeg', '/resources/image/e2818770-2821-4dcb-866b-e12e2fa347be.jpeg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faadb33014faae39bea0007', '2015-09-08 10:58:07', '\0', '2015-09-08 10:58:07', 'image/jpeg', 'b152c767-33b7-477b-8720-c161d9fd0b05.jpeg', '184762', '20120516121232_djirU.jpeg', '/resources/image/b152c767-33b7-477b-8720-c161d9fd0b05.jpeg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faadb33014faae3d12c0008', '2015-09-08 10:58:21', '\0', '2015-09-08 10:58:21', 'image/jpeg', '76ce46d9-5338-4deb-a1ea-6e6fc576726b.jpg', '3675', 'u=533133598,3228141497&fm=21&gp=0.jpg', '/resources/image/76ce46d9-5338-4deb-a1ea-6e6fc576726b.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faafe6b014fac267ce000ad', '2015-09-08 16:50:47', '\0', '2015-09-08 16:50:47', 'image/jpeg', '40511395-8e7f-4688-9a0c-596d0d29344d.jpg', '19542', '015130.69385977_500.jpg', '/resources/image/40511395-8e7f-4688-9a0c-596d0d29344d.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faafe6b014fac28be5000b0', '2015-09-08 16:53:15', '\0', '2015-09-08 16:53:15', 'image/jpeg', 'ad049543-1d1d-4201-848b-fb0245650353.jpeg', '69530', '20130907222849_CF2Bv.jpeg', '/resources/image/ad049543-1d1d-4201-848b-fb0245650353.jpeg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faafe6b014fac2df13300b3', '2015-09-08 16:58:56', '\0', '2015-09-08 16:58:56', 'image/jpeg', '44234d68-6c43-4b78-bc38-df94ddca737e.jpeg', '68232', '20140519211855_kPNSf.jpeg', '/resources/image/44234d68-6c43-4b78-bc38-df94ddca737e.jpeg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faafe6b014fac2e6a3600b5', '2015-09-08 16:59:27', '\0', '2015-09-08 16:59:27', 'image/jpeg', 'fa0be6a6-ad83-44fd-94a5-18c8b7b3b411.jpg', '3675', 'u=533133598,3228141497&fm=21&gp=0.jpg', '/resources/image/fa0be6a6-ad83-44fd-94a5-18c8b7b3b411.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faafe6b014fac2fb16800b9', '2015-09-08 17:00:50', '\0', '2015-09-08 17:00:50', 'image/jpeg', 'ac711f08-b045-41e9-ae42-96fb68979ad7.jpg', '60019', 'b3cb16ce823c6e311c1f50279abe1cc5.jpg', '/resources/image/ac711f08-b045-41e9-ae42-96fb68979ad7.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faafe6b014fb0412378014b', '2015-09-09 11:58:23', '\0', '2015-09-09 11:58:23', 'image/jpeg', '8873589f-79e7-41c2-8956-c319fcf461db.jpg', '17936', 'logo.jpg', '/resources/image/8873589f-79e7-41c2-8956-c319fcf461db.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184faafe6b014fb04be1590168', '2015-09-09 12:10:07', '\0', '2015-09-09 12:10:07', 'image/jpeg', '55557046-e832-4de6-92a3-742266ddf624.jpg', '17936', 'logo.jpg', '/resources/image/55557046-e832-4de6-92a3-742266ddf624.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb07a88014fb0a346130003', '2015-09-09 13:45:34', '\0', '2015-09-09 13:45:34', 'image/jpeg', '94dcf9cb-d0bf-4102-98d0-148a64e39233.jpg', '46307', '洗牙.jpg', '/resources/image/94dcf9cb-d0bf-4102-98d0-148a64e39233.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb07a88014fb0a360fa0008', '2015-09-09 13:45:41', '\0', '2015-09-09 13:45:41', 'image/jpeg', 'ed0e2004-0891-4b20-8035-42f70b38689a.jpg', '46307', '洗牙.jpg', '/resources/image/ed0e2004-0891-4b20-8035-42f70b38689a.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb07a88014fb0a360fb0009', '2015-09-09 13:45:41', '\0', '2015-09-09 13:45:41', 'image/jpeg', '001ecfda-171d-45ce-b502-7c2aebeb597f.jpg', '47871', '1.jpg', '/resources/image/001ecfda-171d-45ce-b502-7c2aebeb597f.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb07a88014fb0a360fc000a', '2015-09-09 13:45:41', '\0', '2015-09-09 13:45:41', 'image/jpeg', 'ac800027-e7a9-4611-9795-a7915df0ec88.jpg', '40594', '2.jpg', '/resources/image/ac800027-e7a9-4611-9795-a7915df0ec88.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb07a88014fb0a360fd000b', '2015-09-09 13:45:41', '\0', '2015-09-09 13:45:41', 'image/jpeg', '73bff7f4-6939-4b5d-b214-db5d9fdacdc2.jpg', '34545', '未标题-2.jpg', '/resources/image/73bff7f4-6939-4b5d-b214-db5d9fdacdc2.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb07a88014fb0a37f51000d', '2015-09-09 13:45:49', '\0', '2015-09-09 13:45:49', 'image/jpeg', '2536091e-6596-4614-9a7a-c980ff86b7c3.jpg', '46307', '洗牙.jpg', '/resources/image/2536091e-6596-4614-9a7a-c980ff86b7c3.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb07a88014fb0a37f52000e', '2015-09-09 13:45:49', '\0', '2015-09-09 13:45:49', 'image/jpeg', '83356d28-2fb6-43b5-be3f-aedab467e746.jpg', '47871', '1.jpg', '/resources/image/83356d28-2fb6-43b5-be3f-aedab467e746.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb07a88014fb0a37f54000f', '2015-09-09 13:45:49', '\0', '2015-09-09 13:45:49', 'image/jpeg', 'aa691c59-2ffa-4f2e-840c-9709a13a2291.jpg', '40594', '2.jpg', '/resources/image/aa691c59-2ffa-4f2e-840c-9709a13a2291.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb07a88014fb0a37f550010', '2015-09-09 13:45:49', '\0', '2015-09-09 13:45:49', 'image/jpeg', '80b1a52c-4ab8-4d37-b3ab-90d20d460ac8.jpg', '34545', '未标题-2.jpg', '/resources/image/80b1a52c-4ab8-4d37-b3ab-90d20d460ac8.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb13015014fb143cc0c0015', '2015-09-09 16:40:54', '\0', '2015-09-09 16:40:54', 'image/jpeg', '6c5ebf1e-6a48-4b24-b0de-d8615ec06f39.jpg', '23413', 'logo.jpg', '/resources/image/6c5ebf1e-6a48-4b24-b0de-d8615ec06f39.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb13015014fb143df03001a', '2015-09-09 16:40:59', '\0', '2015-09-09 16:40:59', 'image/jpeg', '0d601252-6dcd-4e82-afe6-ad872f43f4e3.jpg', '23413', 'logo.jpg', '/resources/image/0d601252-6dcd-4e82-afe6-ad872f43f4e3.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb13015014fb15533f6001d', '2015-09-09 16:59:55', '\0', '2015-09-09 16:59:55', 'image/jpeg', '77337807-f955-4503-86db-59d91b8eae4b.jpg', '28803', '0.jpg', '/resources/image/77337807-f955-4503-86db-59d91b8eae4b.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb13015014fb15533f7001e', '2015-09-09 16:59:55', '\0', '2015-09-09 16:59:55', 'image/jpeg', 'edde818c-666e-4a83-9ff6-9f3e734e8fd0.jpg', '46346', '1.jpg', '/resources/image/edde818c-666e-4a83-9ff6-9f3e734e8fd0.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb13015014fb15533f8001f', '2015-09-09 16:59:55', '\0', '2015-09-09 16:59:55', 'image/jpeg', '9eeb3856-b53e-4d9f-86e8-fbde62b32a37.jpg', '54166', '2.jpg', '/resources/image/9eeb3856-b53e-4d9f-86e8-fbde62b32a37.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb13015014fb15533f80020', '2015-09-09 16:59:55', '\0', '2015-09-09 16:59:55', 'image/jpeg', '18daa147-0462-4716-b51a-e9a8e77d7f91.jpg', '45386', '3.jpg', '/resources/image/18daa147-0462-4716-b51a-e9a8e77d7f91.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb13015014fb15533f90021', '2015-09-09 16:59:55', '\0', '2015-09-09 16:59:55', 'image/jpeg', '196213bf-e0bd-4f6a-99c8-7d8eb8ff53d0.jpg', '69236', '4.jpg', '/resources/image/196213bf-e0bd-4f6a-99c8-7d8eb8ff53d0.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb13015014fb15533fa0022', '2015-09-09 16:59:55', '\0', '2015-09-09 16:59:55', 'image/jpeg', '5bda9d20-0079-40e7-a2b4-926d10963a94.jpg', '25315', '5.jpg', '/resources/image/5bda9d20-0079-40e7-a2b4-926d10963a94.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb13015014fb15533fb0023', '2015-09-09 16:59:55', '\0', '2015-09-09 16:59:55', 'image/jpeg', 'af81eae4-1d76-4f04-8f48-9196e2b611a9.jpg', '39945', '6.jpg', '/resources/image/af81eae4-1d76-4f04-8f48-9196e2b611a9.jpg', null, 'http://localhost:8080/integralmall', 'localhost');
INSERT INTO `medias` VALUES ('faf08f184fb13015014fb15534040024', '2015-09-09 16:59:55', '\0', '2015-09-09 16:59:55', 'image/jpeg', '6917acd1-928c-4ee3-b0ea-502f4da0c259.jpg', '38864', '7.jpg', '/resources/image/6917acd1-928c-4ee3-b0ea-502f4da0c259.jpg', null, 'http://localhost:8080/integralmall', 'localhost');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parent` varchar(255) DEFAULT NULL,
  `tab` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ahevo3im3pnpk8ke9tqyuiaxh` (`parent`),
  CONSTRAINT `FK_ahevo3im3pnpk8ke9tqyuiaxh` FOREIGN KEY (`parent`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '2015-08-27 15:40:27', '\0', '2015-08-27 15:40:30', '渠道管理', '/admin/shop', null, 'shop');
INSERT INTO `menu` VALUES ('10', '2015-08-28 18:42:23', '\0', '2015-08-28 18:42:26', '角色列表', '/admin/role', '4', 'role');
INSERT INTO `menu` VALUES ('11', '2015-08-28 18:42:23', '\0', '2015-08-28 18:42:26', '权限列表', '/admin/perm', '4', 'perm');
INSERT INTO `menu` VALUES ('12', '2015-09-02 14:10:20', '\0', '2015-09-02 14:10:22', '路径列表', '/admin/url', '4', 'url');
INSERT INTO `menu` VALUES ('2', '2015-08-27 15:41:35', '\0', '2015-08-27 15:41:39', '商品管理', '/admin/merchandise', null, 'merchandise');
INSERT INTO `menu` VALUES ('3', '2015-08-27 15:42:04', '\0', '2015-08-27 15:42:07', '积分订单管理', '/admin/integralOrder', null, 'integralOrder');
INSERT INTO `menu` VALUES ('4', '2015-08-27 15:42:25', '\0', '2015-08-27 15:42:28', '用户管理', '/admin/user', null, 'user');
INSERT INTO `menu` VALUES ('5', '2015-08-27 15:43:37', '\0', '2015-08-27 15:43:40', '商家信息', '/admin/shop', '1', 'shop');
INSERT INTO `menu` VALUES ('7', '2015-08-28 18:41:45', '\0', '2015-08-28 18:41:47', '上架商品', '/admin/merchandise', '2', 'shelve');
INSERT INTO `menu` VALUES ('8', '2015-08-28 18:42:01', '\0', '2015-08-28 18:42:04', '积分订单列表', '/admin/integralOrder', '3', 'integralOrder');
INSERT INTO `menu` VALUES ('9', '2015-08-28 18:42:23', '\0', '2015-08-28 18:42:26', '用户列表', '/admin/user', '4', 'user');

-- ----------------------------
-- Table structure for merchandise
-- ----------------------------
DROP TABLE IF EXISTS `merchandise`;
CREATE TABLE `merchandise` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `integral_count` bigint(20) NOT NULL,
  `is_shelve` varchar(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `original` varchar(255) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `seq` varchar(255) DEFAULT NULL,
  `stock` bigint(20) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `classify` varchar(255) DEFAULT NULL,
  `main_pic_media` varchar(255) DEFAULT NULL,
  `type` varchar(31) NOT NULL,
  `brief` varchar(255) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `shops` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fluipnudy4b30fh0q6imjf94a` (`brand`),
  KEY `FK_ieqpfuir6uq9oamwrgt0dhcl4` (`classify`),
  KEY `FK_rokvdq3lb9souda84pocqwndk` (`main_pic_media`),
  KEY `FK_hwupj79d2ov9ecw6tglb0ia6y` (`shops`),
  CONSTRAINT `FK_fluipnudy4b30fh0q6imjf94a` FOREIGN KEY (`brand`) REFERENCES `categoryitem` (`id`),
  CONSTRAINT `FK_hwupj79d2ov9ecw6tglb0ia6y` FOREIGN KEY (`shops`) REFERENCES `branch_shop` (`id`),
  CONSTRAINT `FK_ieqpfuir6uq9oamwrgt0dhcl4` FOREIGN KEY (`classify`) REFERENCES `categoryitem` (`id`),
  CONSTRAINT `FK_rokvdq3lb9souda84pocqwndk` FOREIGN KEY (`main_pic_media`) REFERENCES `medias` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of merchandise
-- ----------------------------
INSERT INTO `merchandise` VALUES ('4040409e4ed7e888014ed7ecbbf50001', '2015-07-29 11:48:13', '\0', '2015-09-09 11:53:50', '北京市', null, '1000', '1', '丝巾', '', '200.00', '真丝面料', '1', '3', '54645', '435345', 'faf08f184efba4cb014efbac81e6000f', '1', '活动火热进行中', '2015-09-30 00:00:00', '2015-09-07 00:00:00', null);
INSERT INTO `merchandise` VALUES ('4040409e4ed801d6014ed803ae0d0000', '2015-07-29 12:13:17', '\0', '2015-09-10 11:11:02', '北京市中关村大街40号当代商城中关村店2层', '2015-08-09 23:59:59', '2000', '1', '100元代金券', '', '0.00', 'xxxxxxxxxx', '3', '85', '54645', '67546', '4040409e4fb53475014fb53c25ee000a', '0', '活动火热进行中', '2015-09-30 00:00:00', '2015-09-07 00:00:00', null);
INSERT INTO `merchandise` VALUES ('4040409e4ed941b6014ed944a03e0000', '2015-07-29 18:03:50', '\0', '2015-09-10 11:10:36', '北京市亮马桥路52号燕莎友谊商城3F吉芬专柜 ', '2015-08-01 23:59:59', '1222', '1', '1000元代金券', '', '0.00', 'xxxxxxxxxx', '2', '6', '54645', '67546', '4040409e4fb53475014fb53bc0600008', '0', '活动火热进行中', '2015-09-30 00:00:00', '2015-09-07 00:00:00', null);
INSERT INTO `merchandise` VALUES ('4040409e4ef21b7d014ef21d7d590002', '2015-08-03 13:51:36', '\0', '2015-09-08 10:43:03', '北京市', null, '1000', '1', '裙子', '', '100.00', 'xxxxxxxxxx', '4', '0', '54645', '435345', 'faf08f184efba4cb014efbab5c780007', '1', '活动火热进行中', '2015-09-30 00:00:00', '2015-09-07 00:00:00', null);
INSERT INTO `merchandise` VALUES ('4040409e4ef2392c014ef23cec1b0003', '2015-08-03 14:25:56', '\0', '2015-09-09 10:22:42', '北京市', null, '1230', '1', '太阳镜', '', '100.00', 'xxxxxxxxxx', '5', '97', '43543', '34534', 'faf08f184efba4cb014efbab1e840004', '1', '活动火热进行中', '2015-09-30 00:00:00', '2015-09-07 00:00:00', null);
INSERT INTO `merchandise` VALUES ('4040409e4ef31284014ef313f1710001', '2015-08-03 18:20:47', '\0', '2015-09-10 11:21:09', '北京市海淀区翠微路12号凯德MALL(翠微路)3层', '2015-09-01 23:59:59', '100', '1', '111代金券', '', '0.00', 'xxxxxxxxxx', '6', '987', '676545435', '67546', '4040409e4fb54196014fb5456a430000', '0', '活动火热进行中', '2015-09-30 00:00:00', '2015-09-07 00:00:00', null);
INSERT INTO `merchandise` VALUES ('4040409e4ef31284014ef314eff50004', '2015-08-03 18:21:52', '\0', '2015-09-08 11:24:21', '北京市', null, '324', '1', '帽子', '222222222222', '1900.00', 'xxxxxxxxxx', '7', '0', '54645', '34534', 'faf08f184faacc80014faad370be0007', '1', '活动火热进行中', '2015-09-30 00:00:00', '2015-09-07 00:00:00', null);
INSERT INTO `merchandise` VALUES ('faf08f184f2bb57e014f2bb699f20002', '2015-08-14 18:17:11', '\0', '2015-09-09 10:20:34', null, null, '10000', '1', '手包', '345435435', '1100.00', '顶顶顶顶顶顶顶顶', '8', '997', '54645', '34534', 'faf08f184f2bb57e014f2bb699e00000', '1', '活动火热进行中', '2015-09-30 00:00:00', '2015-09-07 00:00:00', null);
INSERT INTO `merchandise` VALUES ('faf08f184f43f1fb014f4424262b0041', '2015-08-19 12:07:43', '\0', '2015-09-10 11:10:15', '北京市朝阳区七圣中街１２号院１号楼百盛购物中心B1楼（太阳宫桥东侧）2层 ', '2015-09-01 23:59:59', '2000', '1', '200元代金券', '', '200.00', '代金券，可到指定门店消费', '9', '991', '54645', '67546', '4040409e4fb53475014fb53b6c940006', '0', '活动火热进行中', '2015-09-30 00:00:00', '2015-09-07 00:00:00', null);
INSERT INTO `merchandise` VALUES ('faf08f184f43f1fb014f44263e9d0044', '2015-08-19 12:10:01', '\0', '2015-09-09 10:11:45', null, null, '5000', '1', '打底衫', '', '700.00', '白色打底衫，真丝面料', '10', '120', '54645', '34534', 'faf08f184f43f1fb014f44263e650042', '1', '活动火热进行中', '2015-09-30 00:00:00', '2015-09-07 00:00:00', null);
INSERT INTO `merchandise` VALUES ('faf08f184f4a77e7014f4a88d40b0006', '2015-08-20 17:55:25', '\0', '2015-09-10 11:09:13', '北京市亮马桥路52号燕莎友谊商城3F吉芬专柜', '2015-12-31 23:59:59', '100', '1', '100元代金券', 'qdzx1', '200.00', '优惠券可抵现金', '11', '805', '54645', '67546', '4040409e4fb53475014fb53a79d50004', '0', '活动火热进行中', '2015-09-30 00:00:00', '2015-09-07 00:00:00', null);
INSERT INTO `merchandise` VALUES ('faf08f184f4a77e7014f4a8b45f3000a', '2015-08-20 17:58:05', '\0', '2015-09-10 11:08:50', null, null, '400', '1', '围巾', '', '400.00', '羊绒围巾', '12', '81', '43543', '34534', '4040409e4fb53475014fb53a20fd0002', '1', '活动火热进行中', '2015-09-30 00:00:00', '2015-09-07 00:00:00', null);
INSERT INTO `merchandise` VALUES ('faf08f184fb07a88014fb0a346660007', '2015-09-09 13:45:34', '\0', '2015-09-10 11:08:24', null, null, '700', '1', '洗牙套餐', '', '200.00', '洗牙+口腔体检+免费建档+3D拍片+专家免费咨询', '13', '15', '676545435', '67546', '4040409e4fb53475014fb539ba900000', '0', '洗牙+口腔体检+免费建档+3D拍片+专家免费咨询', '2015-11-30 00:00:00', '2015-09-02 00:00:00', null);
INSERT INTO `merchandise` VALUES ('faf08f184fb07a88014fb0a36112000c', '2015-09-09 13:45:41', '\0', '2015-09-09 13:46:10', null, null, '700', '0', '洗牙套餐', '', '0.00', '洗牙+口腔体检+免费建档+3D拍片+专家免费咨询', '13', '15', '676545435', '67546', 'faf08f184fb07a88014fb0a360fa0008', '0', '洗牙+口腔体检+免费建档+3D拍片+专家免费咨询', '2015-11-30 00:00:00', '2015-09-02 00:00:00', null);
INSERT INTO `merchandise` VALUES ('faf08f184fb07a88014fb0a37fa30011', '2015-09-09 13:45:49', '\0', '2015-09-09 13:46:07', null, null, '700', '0', '洗牙套餐', '', '0.00', '洗牙+口腔体检+免费建档+3D拍片+专家免费咨询', '13', '15', '676545435', '67546', 'faf08f184fb07a88014fb0a37f51000d', '0', '洗牙+口腔体检+免费建档+3D拍片+专家免费咨询', '2015-11-30 00:00:00', '2015-09-02 00:00:00', null);
INSERT INTO `merchandise` VALUES ('faf08f184fb13015014fb15534090025', '2015-09-09 16:59:55', '\0', '2015-09-10 11:05:00', null, null, '1000', '1', '光之树瑜伽周卡', '', '1000.00', '', '14', '10', '676545435', '67546', 'faf08f184fb13015014fb15533f6001d', '0', '光之树瑜伽周卡', '2015-11-30 00:00:00', '2015-09-02 00:00:00', null);

-- ----------------------------
-- Table structure for merchandise_medias
-- ----------------------------
DROP TABLE IF EXISTS `merchandise_medias`;
CREATE TABLE `merchandise_medias` (
  `merchandise` varchar(255) NOT NULL,
  `medias` varchar(255) NOT NULL,
  PRIMARY KEY (`merchandise`,`medias`),
  UNIQUE KEY `UK_4ykggbbyv249mawx0tj3v5t86` (`medias`),
  CONSTRAINT `FK_4ykggbbyv249mawx0tj3v5t86` FOREIGN KEY (`medias`) REFERENCES `medias` (`id`),
  CONSTRAINT `FK_tgfbhmtha0eegudp7m64tbv1i` FOREIGN KEY (`merchandise`) REFERENCES `merchandise` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of merchandise_medias
-- ----------------------------
INSERT INTO `merchandise_medias` VALUES ('faf08f184fb07a88014fb0a346660007', '4040409e4fb53475014fb539ba950001');
INSERT INTO `merchandise_medias` VALUES ('faf08f184f4a77e7014f4a8b45f3000a', '4040409e4fb53475014fb53a20fe0003');
INSERT INTO `merchandise_medias` VALUES ('faf08f184f4a77e7014f4a88d40b0006', '4040409e4fb53475014fb53a79d60005');
INSERT INTO `merchandise_medias` VALUES ('faf08f184f43f1fb014f4424262b0041', '4040409e4fb53475014fb53b6c950007');
INSERT INTO `merchandise_medias` VALUES ('4040409e4ed941b6014ed944a03e0000', '4040409e4fb53475014fb53bc0610009');
INSERT INTO `merchandise_medias` VALUES ('4040409e4ed801d6014ed803ae0d0000', '4040409e4fb53475014fb53c25ef000b');
INSERT INTO `merchandise_medias` VALUES ('4040409e4ef31284014ef313f1710001', '4040409e4fb54196014fb5456a5d0001');
INSERT INTO `merchandise_medias` VALUES ('faf08f184f43f1fb014f44263e9d0044', 'faf08f184faacc80014faad1bcbc0003');
INSERT INTO `merchandise_medias` VALUES ('faf08f184f2bb57e014f2bb699f20002', 'faf08f184faacc80014faad2cfdb0006');
INSERT INTO `merchandise_medias` VALUES ('4040409e4ef31284014ef314eff50004', 'faf08f184faacc80014faad370bf0008');
INSERT INTO `merchandise_medias` VALUES ('4040409e4ed7e888014ed7ecbbf50001', 'faf08f184faacc80014faad4aca6000b');
INSERT INTO `merchandise_medias` VALUES ('4040409e4ef21b7d014ef21d7d590002', 'faf08f184faacc80014faad5cfe3000f');
INSERT INTO `merchandise_medias` VALUES ('4040409e4ef2392c014ef23cec1b0003', 'faf08f184faacc80014faad68d750010');
INSERT INTO `merchandise_medias` VALUES ('faf08f184fb07a88014fb0a36112000c', 'faf08f184fb07a88014fb0a360fb0009');
INSERT INTO `merchandise_medias` VALUES ('faf08f184fb07a88014fb0a36112000c', 'faf08f184fb07a88014fb0a360fc000a');
INSERT INTO `merchandise_medias` VALUES ('faf08f184fb07a88014fb0a36112000c', 'faf08f184fb07a88014fb0a360fd000b');
INSERT INTO `merchandise_medias` VALUES ('faf08f184fb07a88014fb0a37fa30011', 'faf08f184fb07a88014fb0a37f52000e');
INSERT INTO `merchandise_medias` VALUES ('faf08f184fb07a88014fb0a37fa30011', 'faf08f184fb07a88014fb0a37f54000f');
INSERT INTO `merchandise_medias` VALUES ('faf08f184fb07a88014fb0a37fa30011', 'faf08f184fb07a88014fb0a37f550010');
INSERT INTO `merchandise_medias` VALUES ('faf08f184fb13015014fb15534090025', 'faf08f184fb13015014fb15533f7001e');
INSERT INTO `merchandise_medias` VALUES ('faf08f184fb13015014fb15534090025', 'faf08f184fb13015014fb15533f8001f');
INSERT INTO `merchandise_medias` VALUES ('faf08f184fb13015014fb15534090025', 'faf08f184fb13015014fb15533f80020');
INSERT INTO `merchandise_medias` VALUES ('faf08f184fb13015014fb15534090025', 'faf08f184fb13015014fb15533f90021');
INSERT INTO `merchandise_medias` VALUES ('faf08f184fb13015014fb15534090025', 'faf08f184fb13015014fb15533fa0022');
INSERT INTO `merchandise_medias` VALUES ('faf08f184fb13015014fb15534090025', 'faf08f184fb13015014fb15533fb0023');
INSERT INTO `merchandise_medias` VALUES ('faf08f184fb13015014fb15534090025', 'faf08f184fb13015014fb15534040024');

-- ----------------------------
-- Table structure for merch_branchshop
-- ----------------------------
DROP TABLE IF EXISTS `merch_branchshop`;
CREATE TABLE `merch_branchshop` (
  `merchandise` varchar(255) NOT NULL,
  `shops` varchar(255) NOT NULL,
  PRIMARY KEY (`merchandise`,`shops`),
  KEY `FK_l1jfd5ppjp3bajxcke3wwqk6i` (`shops`),
  CONSTRAINT `FK_7um09nbbv3rduj3hqr9r8ul3q` FOREIGN KEY (`merchandise`) REFERENCES `merchandise` (`id`),
  CONSTRAINT `FK_l1jfd5ppjp3bajxcke3wwqk6i` FOREIGN KEY (`shops`) REFERENCES `branch_shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of merch_branchshop
-- ----------------------------
INSERT INTO `merch_branchshop` VALUES ('4040409e4fb5110e014fb5152a540002', '4040409e4f8bbe23014f8bc197630002');
INSERT INTO `merch_branchshop` VALUES ('4040409e4fb0c5ff014fb0c684940002', '4040409e4fb051ac014fb052b3250001');
INSERT INTO `merch_branchshop` VALUES ('4040409e4fb0c5ff014fb0c684940002', '4040409e4fb051ac014fb0536a6d0002');
INSERT INTO `merch_branchshop` VALUES ('4040409e4fab16f8014fab1e9ff00002', '4040409e4fb051ac014fb05642720003');
INSERT INTO `merch_branchshop` VALUES ('4040409e4ed801d6014ed803ae0d0000', 'faf08f184f8d4bc5014f8d4f51c30000');
INSERT INTO `merch_branchshop` VALUES ('4040409e4ed941b6014ed944a03e0000', 'faf08f184f8d4bc5014f8d4f51c30000');
INSERT INTO `merch_branchshop` VALUES ('faf08f184f43f1fb014f4424262b0041', 'faf08f184f8d4bc5014f8d4f51c30000');
INSERT INTO `merch_branchshop` VALUES ('faf08f184fb13015014fb15534090025', 'faf08f184f8d4bc5014f8d4f51c30000');
INSERT INTO `merch_branchshop` VALUES ('faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184fa58458014fa5c09f27000d');
INSERT INTO `merch_branchshop` VALUES ('faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fa58458014fa5c866fd0017');
INSERT INTO `merch_branchshop` VALUES ('4040409e4ef31284014ef313f1710001', 'faf08f184fa58458014fa5c9ac2f001b');
INSERT INTO `merch_branchshop` VALUES ('faf08f184fb07a88014fb0a346660007', 'faf08f184fb07a88014fb09c17c70002');

-- ----------------------------
-- Table structure for order_merchandise
-- ----------------------------
DROP TABLE IF EXISTS `order_merchandise`;
CREATE TABLE `order_merchandise` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `count` int(11) NOT NULL,
  `coupon_code` varchar(255) DEFAULT NULL,
  `integral_count` bigint(20) NOT NULL,
  `usage_date` datetime DEFAULT NULL,
  `merchandise` varchar(255) DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3v4amtx6um6hllgwfgrfkit1s` (`merchandise`),
  KEY `FK_jv0b5xbhdsqkeay8va6fygg07` (`order_id`),
  CONSTRAINT `FK_3v4amtx6um6hllgwfgrfkit1s` FOREIGN KEY (`merchandise`) REFERENCES `merchandise` (`id`),
  CONSTRAINT `FK_jv0b5xbhdsqkeay8va6fygg07` FOREIGN KEY (`order_id`) REFERENCES `integral_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_merchandise
-- ----------------------------
INSERT INTO `order_merchandise` VALUES ('4040409e4ee2c05b014ee2c061260001', '2015-07-31 14:15:35', '\0', '2015-07-31 14:15:35', '1', '1b88d9ef-7553-4d0c-a780-1c05a9c8f471', '2000', '2015-08-04 10:34:25', '4040409e4ed801d6014ed803ae0d0000', '4040409e4ee2c05b014ee2c0611e0000');
INSERT INTO `order_merchandise` VALUES ('4040409e4ef166e7014ef166ece80001', '2015-08-03 10:32:11', '\0', '2015-08-03 10:32:11', '1', '047902c9-9bdc-48cb-b301-1a5b7b5c0bf1', '2000', null, '4040409e4ed801d6014ed803ae0d0000', '4040409e4ef166e7014ef166ece10000');
INSERT INTO `order_merchandise` VALUES ('4040409e4ef17366014ef1736c180001', '2015-08-03 10:45:50', '\0', '2015-08-03 10:45:50', '1', null, '1000', null, '4040409e4ed7e888014ed7ecbbf50001', '4040409e4ef17366014ef1736c120000');
INSERT INTO `order_merchandise` VALUES ('faf08f184f3ec63f014f4043db120002', '2015-08-18 18:03:52', '\0', '2015-08-18 18:03:52', '1', '8bf9798f-4bd8-4aae-9559-744d778344ca', '10000', null, '4040409e4ef31284014ef313f1710001', 'faf08f184f3ec63f014f4043db0e0001');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f43f2c2f50002', '2015-08-19 11:13:47', '\0', '2015-08-19 11:13:47', '1', '18d46276-26d0-4c47-85d8-321acbfa7150', '10000', null, '4040409e4ef31284014ef313f1710001', 'faf08f184f43f1fb014f43f2c2f40001');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f43f3d50e0005', '2015-08-19 11:14:57', '\0', '2015-08-19 11:14:57', '1', 'c0530e16-b41a-471c-8235-440c8aa7dfa0', '10000', null, '4040409e4ef31284014ef313f1710001', 'faf08f184f43f1fb014f43f3d50d0004');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f43f5a61d0008', '2015-08-19 11:16:56', '\0', '2015-08-19 11:16:56', '1', '67b08be7-246b-426c-aa9b-40b94cee16e5', '10000', null, '4040409e4ef31284014ef313f1710001', 'faf08f184f43f1fb014f43f5a61d0007');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f43f61583000b', '2015-08-19 11:17:24', '\0', '2015-08-19 11:17:24', '1', '162ff0f8-3a8d-4e24-a289-70ca564dc064', '10000', null, '4040409e4ef31284014ef313f1710001', 'faf08f184f43f1fb014f43f61583000a');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f43f6b368000e', '2015-08-19 11:18:05', '\0', '2015-08-19 11:18:05', '1', '1de626d6-7307-4d22-a82b-1c93bb781024', '10000', null, '4040409e4ef31284014ef313f1710001', 'faf08f184f43f1fb014f43f6b368000d');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f43f6c3380011', '2015-08-19 11:18:09', '\0', '2015-08-19 11:18:09', '1', '147d7fa2-cc5f-4d5a-a3e9-eb1ef5486cc6', '10000', null, '4040409e4ef31284014ef313f1710001', 'faf08f184f43f1fb014f43f6c3370010');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f43f847630014', '2015-08-19 11:19:48', '\0', '2015-08-19 11:19:48', '1', 'dcc5a8d8-d627-43eb-902a-f34f9290b4b2', '10000', null, '4040409e4ef31284014ef313f1710001', 'faf08f184f43f1fb014f43f847630013');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f43f859c40017', '2015-08-19 11:19:53', '\0', '2015-08-19 11:19:53', '1', '1e69c0c0-1c52-4c0a-9aa4-4a5c598b6f24', '10000', null, '4040409e4ef31284014ef313f1710001', 'faf08f184f43f1fb014f43f859c40016');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f43f8e7f3001a', '2015-08-19 11:20:29', '\0', '2015-08-19 11:20:29', '1', 'c3453b7d-3f28-49c6-b483-9e9fd9c97a67', '10000', null, '4040409e4ef31284014ef313f1710001', 'faf08f184f43f1fb014f43f8e7f20019');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f440f5c500020', '2015-08-19 11:45:01', '\0', '2015-08-19 11:45:01', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f440f5c4f001f');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f440f7fea0023', '2015-08-19 11:45:10', '\0', '2015-08-19 11:45:10', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f440f7fe90022');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f441013aa0026', '2015-08-19 11:45:48', '\0', '2015-08-19 11:45:48', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f441013a90025');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f4411cfbe0029', '2015-08-19 11:47:42', '\0', '2015-08-19 11:47:42', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f4411cfbe0028');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f4419ea57002c', '2015-08-19 11:56:33', '\0', '2015-08-19 11:56:33', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f4419ea56002b');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f441a53ee002f', '2015-08-19 11:57:00', '\0', '2015-08-19 11:57:00', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f441a53ee002e');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f441abd8b0032', '2015-08-19 11:57:27', '\0', '2015-08-19 11:57:27', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f441abd8b0031');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f441b54c80035', '2015-08-19 11:58:06', '\0', '2015-08-19 11:58:06', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f441b54c70034');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f441f2e740038', '2015-08-19 12:02:18', '\0', '2015-08-19 12:02:18', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f441f2e740037');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f441f3992003b', '2015-08-19 12:02:21', '\0', '2015-08-19 12:02:21', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f441f3992003a');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f441f542f003e', '2015-08-19 12:02:28', '\0', '2015-08-19 12:02:28', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f441f542f003d');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f442c09f30047', '2015-08-19 12:16:20', '\0', '2015-08-19 12:16:20', '1', null, '5000', null, 'faf08f184f43f1fb014f44263e9d0044', 'faf08f184f43f1fb014f442c09f20046');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f442c4172004a', '2015-08-19 12:16:35', '\0', '2015-08-19 12:16:35', '1', null, '1000', null, '4040409e4ef21b7d014ef21d7d590002', 'faf08f184f43f1fb014f442c41720049');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f442fa5f2004d', '2015-08-19 12:20:17', '\0', '2015-08-19 12:20:17', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f442fa5f2004c');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f443003b10051', '2015-08-19 12:20:41', '\0', '2015-08-19 12:20:41', '1', '67f272d9-d13b-47b0-aed0-e7130869ecf0', '2000', null, 'faf08f184f43f1fb014f4424262b0041', 'faf08f184f43f1fb014f443003b10050');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f44305ad20054', '2015-08-19 12:21:03', '\0', '2015-08-19 12:21:03', '1', null, '1000', null, '4040409e4ef21b7d014ef21d7d590002', 'faf08f184f43f1fb014f44305ad10053');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f4431d2120057', '2015-08-19 12:22:39', '\0', '2015-08-19 12:22:39', '1', null, '1000', null, '4040409e4ed7e888014ed7ecbbf50001', 'faf08f184f43f1fb014f4431d2110056');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f4484c981005a', '2015-08-19 13:53:17', '\0', '2015-08-19 13:53:17', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f4484c9810059');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f4484f660005d', '2015-08-19 13:53:28', '\0', '2015-08-19 13:53:28', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f4484f660005c');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f449ac4f50060', '2015-08-19 14:17:17', '\0', '2015-08-19 14:17:17', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f449ac4f4005f');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f44a1d04f0063', '2015-08-19 14:24:59', '\0', '2015-08-19 14:24:59', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f44a1d04e0062');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f44a2026d0066', '2015-08-19 14:25:12', '\0', '2015-08-19 14:25:12', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f44a2026c0065');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f44a279fc0069', '2015-08-19 14:25:42', '\0', '2015-08-19 14:25:42', '1', '9df60792-711b-4291-8826-651049ee9394', '2000', null, 'faf08f184f43f1fb014f4424262b0041', 'faf08f184f43f1fb014f44a279fc0068');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f44a6208f006d', '2015-08-19 14:29:42', '\0', '2015-08-19 14:29:42', '1', '065088a9-4747-4f5c-8776-6662bf78eb75', '2000', null, 'faf08f184f43f1fb014f4424262b0041', 'faf08f184f43f1fb014f44a6208f006c');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f44a631270070', '2015-08-19 14:29:46', '\0', '2015-08-19 14:29:46', '1', '100dae43-2d94-4c4d-8449-4bcfcb34b6d7', '2000', null, 'faf08f184f43f1fb014f4424262b0041', 'faf08f184f43f1fb014f44a63127006f');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f44c16c5e0073', '2015-08-19 14:59:31', '\0', '2015-08-19 14:59:31', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f44c16c5e0072');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f44c509ad0076', '2015-08-19 15:03:27', '\0', '2015-08-19 15:03:27', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f44c509ad0075');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f44c57cbe007a', '2015-08-19 15:03:57', '\0', '2015-08-19 15:03:57', '1', '14a9f555-c980-43a3-8198-304c11f813f5', '2000', null, 'faf08f184f43f1fb014f4424262b0041', 'faf08f184f43f1fb014f44c57cbe0079');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f45371ba5007d', '2015-08-19 17:08:03', '\0', '2015-08-19 17:08:03', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f45371ba5007c');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f456f95d90082', '2015-08-19 18:09:44', '\0', '2015-08-19 18:09:44', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f456f95d90081');
INSERT INTO `order_merchandise` VALUES ('faf08f184f43f1fb014f457117640085', '2015-08-19 18:11:23', '\0', '2015-08-19 18:11:23', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f43f1fb014f457117640084');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4a80e83f0003', '2015-08-20 17:46:46', '\0', '2015-08-20 17:46:46', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f4a77e7014f4a80e83e0002');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f246acc000d', '2015-08-21 15:23:50', '\0', '2015-08-21 15:23:50', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f4a77e7014f4f246acc000c');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f24ed5d0010', '2015-08-21 15:24:24', '\0', '2015-08-21 15:24:24', '1', '08c27519-fe86-4b58-bd6a-be77840ed1f2', '2000', null, 'faf08f184f43f1fb014f4424262b0041', 'faf08f184f4a77e7014f4f24ed5d000f');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f25f2a70014', '2015-08-21 15:25:31', '\0', '2015-08-21 15:25:31', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f4a77e7014f4f25f2a70013');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f2682c30017', '2015-08-21 15:26:08', '\0', '2015-08-21 15:26:08', '1', '407ee833-1c8a-435a-8e06-dd61961afc2c', '2000', null, 'faf08f184f43f1fb014f4424262b0041', 'faf08f184f4a77e7014f4f2682c30016');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f26f943001a', '2015-08-21 15:26:38', '\0', '2015-08-21 15:26:38', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f4a77e7014f4f26f9430019');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f2d80e4001d', '2015-08-21 15:33:46', '\0', '2015-08-21 15:33:46', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f4a77e7014f4f2d80e4001c');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f3280470021', '2015-08-21 15:39:13', '\0', '2015-08-21 15:39:13', '1', '70c5a04e-159d-4984-b087-5f15bd2cafd2', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4f3280470020');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f4461ff0024', '2015-08-21 15:58:45', '\0', '2015-08-21 15:58:45', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f4a77e7014f4f4461ff0023');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f4577940027', '2015-08-21 15:59:56', '\0', '2015-08-21 15:59:56', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f4a77e7014f4f4577930026');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f4a8cfc002a', '2015-08-21 16:05:29', '\0', '2015-08-21 16:05:29', '1', 'a8e02668-25e0-4774-aa52-123b98fce046', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4f4a8cfc0029');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f4a958d002d', '2015-08-21 16:05:32', '\0', '2015-08-21 16:05:32', '1', 'c52dc94c-4779-40c6-abc8-8524e634b359', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4f4a958c002c');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f51fee80030', '2015-08-21 16:13:37', '\0', '2015-08-21 16:13:37', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f4a77e7014f4f51fee7002f');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f52b8f20033', '2015-08-21 16:14:25', '\0', '2015-08-21 16:14:25', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f4a77e7014f4f52b8f20032');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f7ad1200036', '2015-08-21 16:58:13', '\0', '2015-08-21 16:58:13', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184f4a77e7014f4f7ad1200035');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f87b2db0039', '2015-08-21 17:12:17', '\0', '2015-08-21 17:12:17', '1', '76b20724-b25d-4946-ad35-24df9626d367', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4f87b2da0038');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f895459003c', '2015-08-21 17:14:04', '\0', '2015-08-21 17:14:04', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184f4a77e7014f4f895459003b');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f89d927003f', '2015-08-21 17:14:38', '\0', '2015-08-21 17:14:38', '1', '87f533a3-38ae-4bd3-9e8e-6e3a56a6b161', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4f89d927003e');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f8c74980042', '2015-08-21 17:17:29', '\0', '2015-08-21 17:17:29', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184f4a77e7014f4f8c74980041');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f8c95870045', '2015-08-21 17:17:37', '\0', '2015-08-21 17:17:37', '1', 'a8ff8d93-049c-479f-8dc9-b8c9cbdc8b0a', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4f8c95870044');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f8cd0b10048', '2015-08-21 17:17:52', '\0', '2015-08-21 17:17:52', '1', '0a1c93c9-0d73-4dd2-af7a-ad83ddd28653', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4f8cd0b10047');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f918321004b', '2015-08-21 17:23:00', '\0', '2015-08-21 17:23:00', '1', '7ffb6169-3a37-4420-b67b-92a3c27a65c5', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4f918321004a');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f925894004e', '2015-08-21 17:23:55', '\0', '2015-08-21 17:23:55', '1', '69a254d3-e5a9-44d2-b235-00ca715de783', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4f925894004d');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f927fdd0051', '2015-08-21 17:24:05', '\0', '2015-08-21 17:24:05', '1', '86e73e8e-300b-4431-a3e8-d48b788b0d35', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4f927fdd0050');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f92b85d0054', '2015-08-21 17:24:19', '\0', '2015-08-21 17:24:19', '1', '4ed677f6-238f-4df1-96b2-f784f486d961', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4f92b85d0053');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f93a2270057', '2015-08-21 17:25:19', '\0', '2015-08-21 17:25:19', '1', '88c0e959-c97a-4d3b-b599-3de5db5e7c37', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4f93a2270056');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f9479f6005a', '2015-08-21 17:26:14', '\0', '2015-08-21 17:26:14', '1', '735b4588-43e1-46e4-822a-d9b9760a0283', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4f9479f60059');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f94defe005d', '2015-08-21 17:26:40', '\0', '2015-08-21 17:26:40', '1', '4ce777d6-413c-488f-a31b-0457b31fb2d3', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4f94defe005c');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4f950c1d0060', '2015-08-21 17:26:52', '\0', '2015-08-21 17:26:52', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184f4a77e7014f4f950c1d005f');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4fb74a7a0063', '2015-08-21 18:04:16', '\0', '2015-08-21 18:04:16', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184f4a77e7014f4fb74a7a0062');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4fb7a30e0066', '2015-08-21 18:04:39', '\0', '2015-08-21 18:04:39', '1', 'd84cd5ce-35be-409b-9347-704885b50408', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4fb7a30e0065');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4fb8ec400069', '2015-08-21 18:06:03', '\0', '2015-08-21 18:06:03', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184f4a77e7014f4fb8ec400068');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4fb90d3c006c', '2015-08-21 18:06:11', '\0', '2015-08-21 18:06:11', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184f4a77e7014f4fb90d3c006b');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4fbc22a8006f', '2015-08-21 18:09:33', '\0', '2015-08-21 18:09:33', '1', '818c0769-8f7c-4989-8425-4024737f0573', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4fbc22a8006e');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4fbd09280072', '2015-08-21 18:10:32', '\0', '2015-08-21 18:10:32', '1', 'b646161f-0828-4ba1-af62-d0322d2afc4b', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4fbd09280071');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f4fbe74810075', '2015-08-21 18:12:05', '\0', '2015-08-21 18:12:05', '1', '8cfd8f7f-365c-4076-8369-ae47914ee26b', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f4fbe74800074');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f533282da0078', '2015-08-22 10:17:43', '\0', '2015-08-22 10:17:43', '1', 'ec7b79e3-e2ad-4175-ab6a-d58814e49523', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f533282da0077');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f533a2829007b', '2015-08-22 10:26:04', '\0', '2015-08-22 10:26:04', '1', '1233bb65-d4ed-48b8-a1e3-2ebdadc55a6f', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f533a2829007a');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f533b072d007e', '2015-08-22 10:27:01', '\0', '2015-08-22 10:27:01', '1', 'd3af78dd-aed1-4e48-bcdf-a0f1fbb09e26', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f533b072d007d');
INSERT INTO `order_merchandise` VALUES ('faf08f184f4a77e7014f53409bdf0081', '2015-08-22 10:33:07', '\0', '2015-08-22 10:33:07', '1', '9d72746f-3aa1-4fd9-8356-67ee8a1efaf7', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f4a77e7014f53409bde0080');
INSERT INTO `order_merchandise` VALUES ('faf08f184f8d8d61014f936083f40003', '2015-09-03 21:23:40', '\0', '2015-09-03 21:23:40', '1', '5ee2e9ed-b2c9-49d8-b128-c86e126131da', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184f8d8d61014f936083f30002');
INSERT INTO `order_merchandise` VALUES ('faf08f184f8d8d61014f9380262b0006', '2015-09-03 21:58:13', '\0', '2015-09-03 21:58:13', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184f8d8d61014f9380262a0005');
INSERT INTO `order_merchandise` VALUES ('faf08f184fa5f35c014faac532550002', '2015-09-08 10:24:54', '\0', '2015-09-08 10:24:54', '1', '5711d160-c278-4ce5-8a40-8e92e648b517', '100', null, '4040409e4ef31284014ef313f1710001', 'faf08f184fa5f35c014faac532530001');
INSERT INTO `order_merchandise` VALUES ('faf08f184faadb33014faaeadef9000c', '2015-09-08 11:06:03', '\0', '2015-09-08 11:06:03', '1', 'b55c2142-22d4-4aba-a441-cbb0b53831ea', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faadb33014faaeadef7000b');
INSERT INTO `order_merchandise` VALUES ('faf08f184faadb33014faaeb710b000f', '2015-09-08 11:06:40', '\0', '2015-09-08 11:06:40', '1', 'da339188-fda0-446d-8aa1-664279cf41c2', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faadb33014faaeb710a000e');
INSERT INTO `order_merchandise` VALUES ('faf08f184faadb33014faaec57280014', '2015-09-08 11:07:39', '\0', '2015-09-08 11:07:39', '1', 'f214ef27-e3fa-4118-87bb-d8d11f6fdbb3', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faadb33014faaec57270013');
INSERT INTO `order_merchandise` VALUES ('faf08f184faadb33014faafba1970019', '2015-09-08 11:24:21', '\0', '2015-09-08 11:24:21', '1', null, '324', null, '4040409e4ef31284014ef314eff50004', 'faf08f184faadb33014faafba1970018');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fab0835050005', '2015-09-08 11:38:05', '\0', '2015-09-08 11:38:05', '1', '7665bfdf-7cc7-4c63-99b2-cd25314ab854', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fab0835040004');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fab7c9da70009', '2015-09-08 13:45:14', '\0', '2015-09-08 13:45:14', '1', '9d30cfec-3ca1-492b-be94-b803027cd394', '1222', null, '4040409e4ed941b6014ed944a03e0000', 'faf08f184faafe6b014fab7c9da70008');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014faba73aca000d', '2015-09-08 14:31:47', '\0', '2015-09-08 14:31:47', '1', '54feb9a7-1099-4b1c-a14d-430bbd70c5a1', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014faba73aca000c');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014faba780c20010', '2015-09-08 14:32:05', '\0', '2015-09-08 14:32:05', '1', null, '1230', null, '4040409e4ef2392c014ef23cec1b0003', 'faf08f184faafe6b014faba780c2000f');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fac5dea9c00be', '2015-09-08 17:51:20', '\0', '2015-09-08 17:51:20', '1', 'e3de9050-d855-4a04-b2eb-afd085a2eb8d', '100', null, '4040409e4ef31284014ef313f1710001', 'faf08f184faafe6b014fac5dea9c00bd');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fac6e36bf00c1', '2015-09-08 18:09:08', '\0', '2015-09-08 18:09:08', '1', '8a84b289-3db9-4a26-b043-f15e4f12c401', '100', null, '4040409e4ef31284014ef313f1710001', 'faf08f184faafe6b014fac6e36be00c0');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafbebe1300c4', '2015-09-09 09:35:57', '\0', '2015-09-09 09:35:57', '1', 'd877f0dc-95cf-4daa-974f-a2084894351e', '2000', null, 'faf08f184f43f1fb014f4424262b0041', 'faf08f184faafe6b014fafbebe1300c3');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafc02f3800c7', '2015-09-09 09:37:31', '\0', '2015-09-09 09:37:31', '1', '9cffb984-c853-45f3-b470-e54cd20055ef', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fafc02f3800c6');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafc0863c00ca', '2015-09-09 09:37:54', '\0', '2015-09-09 09:37:54', '1', '13939b4e-047f-404e-84bc-cfe7586ae337', '2000', null, '4040409e4ed801d6014ed803ae0d0000', 'faf08f184faafe6b014fafc0863b00c9');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafc1622c00cd', '2015-09-09 09:38:50', '\0', '2015-09-09 09:38:50', '1', 'd008a252-e140-4ff1-914d-4a898a23a00a', '2000', null, '4040409e4ed801d6014ed803ae0d0000', 'faf08f184faafe6b014fafc1622c00cc');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafc23edc00d0', '2015-09-09 09:39:47', '\0', '2015-09-09 09:39:47', '1', '651909ca-c107-4102-bff0-5b871150e53d', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fafc23edc00cf');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafc30f8100d3', '2015-09-09 09:40:40', '\0', '2015-09-09 09:40:40', '1', '7eda2cd2-8793-449a-b303-c8a57e9ff7b2', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fafc30f8100d2');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafc3378600d6', '2015-09-09 09:40:50', '\0', '2015-09-09 09:40:50', '1', 'f60f7ca4-3107-4b50-8086-5153259a2547', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fafc3378500d5');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafc35ca600d9', '2015-09-09 09:41:00', '\0', '2015-09-09 09:41:00', '1', 'c8e2e310-99df-4684-8160-f04f1f386687', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fafc35ca600d8');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafcb73f200dc', '2015-09-09 09:49:50', '\0', '2015-09-09 09:49:50', '1', '40917373-8159-44c1-b853-72f1a53d0c94', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fafcb73f200db');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafcc28ff00df', '2015-09-09 09:50:36', '\0', '2015-09-09 09:50:36', '1', 'd2205b58-10e3-48a9-9fcf-26b448d06ebf', '2000', null, '4040409e4ed801d6014ed803ae0d0000', 'faf08f184faafe6b014fafcc28fe00de');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafcc5e7a00e2', '2015-09-09 09:50:50', '\0', '2015-09-09 09:50:50', '1', 'b25ba790-43cb-4396-ac94-3225c3099203', '2000', null, '4040409e4ed801d6014ed803ae0d0000', 'faf08f184faafe6b014fafcc5e7a00e1');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafcd87a900e5', '2015-09-09 09:52:06', '\0', '2015-09-09 09:52:06', '1', null, '5000', null, 'faf08f184f43f1fb014f44263e9d0044', 'faf08f184faafe6b014fafcd87a900e4');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafcef04000e8', '2015-09-09 09:53:38', '\0', '2015-09-09 09:53:38', '1', '7eee6ff4-a8ad-4792-b22d-36fadb0385c4', '1222', null, '4040409e4ed941b6014ed944a03e0000', 'faf08f184faafe6b014fafcef03f00e7');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafcf8f3700eb', '2015-09-09 09:54:19', '\0', '2015-09-09 09:54:19', '1', 'e96ae7fc-7bbc-4dd7-8edd-5b29d655379c', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fafcf8f3600ea');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafd0993000ee', '2015-09-09 09:55:27', '\0', '2015-09-09 09:55:27', '1', null, '10000', null, 'faf08f184f2bb57e014f2bb699f20002', 'faf08f184faafe6b014fafd0993000ed');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafd2246300f1', '2015-09-09 09:57:08', '\0', '2015-09-09 09:57:08', '1', null, '1000', null, '4040409e4ed7e888014ed7ecbbf50001', 'faf08f184faafe6b014fafd2246300f0');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafd7513f00f4', '2015-09-09 10:02:47', '\0', '2015-09-09 10:02:47', '1', null, '1230', null, '4040409e4ef2392c014ef23cec1b0003', 'faf08f184faafe6b014fafd7513f00f3');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafd8664100f7', '2015-09-09 10:03:58', '\0', '2015-09-09 10:03:58', '1', 'f346d101-3078-4547-b39d-14290c729877', '2000', null, '4040409e4ed801d6014ed803ae0d0000', 'faf08f184faafe6b014fafd8664000f6');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafdec61100fa', '2015-09-09 10:10:56', '\0', '2015-09-09 10:10:56', '1', 'eba6271e-db45-4029-880b-769c226f954e', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fafdec61100f9');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafdf853300fd', '2015-09-09 10:11:45', '\0', '2015-09-09 10:11:45', '1', null, '5000', null, 'faf08f184f43f1fb014f44263e9d0044', 'faf08f184faafe6b014fafdf853300fc');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafe06c180100', '2015-09-09 10:12:44', '\0', '2015-09-09 10:12:44', '1', '4d79ff9a-768d-40a5-bc53-b879dcffe973', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fafe06c1700ff');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafe15de70103', '2015-09-09 10:13:46', '\0', '2015-09-09 10:13:46', '1', '9ed2d194-6a63-42a2-910d-3dec0b1b6b89', '2000', null, '4040409e4ed801d6014ed803ae0d0000', 'faf08f184faafe6b014fafe15de70102');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafe796b70106', '2015-09-09 10:20:34', '\0', '2015-09-09 10:20:34', '1', null, '10000', null, 'faf08f184f2bb57e014f2bb699f20002', 'faf08f184faafe6b014fafe796b60105');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fafe98c9d0109', '2015-09-09 10:22:42', '\0', '2015-09-09 10:22:42', '1', null, '1230', null, '4040409e4ef2392c014ef23cec1b0003', 'faf08f184faafe6b014fafe98c9c0108');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb0003271010c', '2015-09-09 10:47:27', '\0', '2015-09-09 10:47:27', '1', 'b3351172-55b1-4a48-843c-afa93189036c', '2000', null, '4040409e4ed801d6014ed803ae0d0000', 'faf08f184faafe6b014fb0003271010b');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb000bd41010f', '2015-09-09 10:48:02', '\0', '2015-09-09 10:48:02', '1', 'a2991bb8-4e35-4116-b945-15cd096b4ad2', '2000', null, '4040409e4ed801d6014ed803ae0d0000', 'faf08f184faafe6b014fb000bd40010e');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb00190b90112', '2015-09-09 10:48:56', '\0', '2015-09-09 10:48:56', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184faafe6b014fb00190b80111');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb0100c010115', '2015-09-09 11:04:45', '\0', '2015-09-09 11:04:45', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184faafe6b014fb0100c010114');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb01046ab0118', '2015-09-09 11:05:00', '\0', '2015-09-09 11:05:00', '1', 'c517d594-d0e2-4dd1-8ea3-d40064b6f0ce', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fb01046ab0117');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb010b69a011b', '2015-09-09 11:05:29', '\0', '2015-09-09 11:05:29', '1', 'b7efaeb6-a2d8-4822-a594-cdfee1217c58', '1222', null, '4040409e4ed941b6014ed944a03e0000', 'faf08f184faafe6b014fb010b69a011a');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb01459a1011e', '2015-09-09 11:09:27', '\0', '2015-09-09 11:09:27', '1', '30dca671-5837-4eec-bf8b-c33fec635bb6', '2000', null, '4040409e4ed801d6014ed803ae0d0000', 'faf08f184faafe6b014fb01459a1011d');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb02b2f5b0121', '2015-09-09 11:34:24', '\0', '2015-09-09 11:34:24', '1', '4474e00a-ee4a-47a5-b4ff-40f62ca76c89', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fb02b2f5a0120');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb02ba6800124', '2015-09-09 11:34:54', '\0', '2015-09-09 11:34:54', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184faafe6b014fb02ba67f0123');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb02c76d30127', '2015-09-09 11:35:48', '\0', '2015-09-09 11:35:48', '1', '142ccfa1-a543-4a9c-8213-eb26d82b159a', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fb02c76d30126');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb02dbde2012a', '2015-09-09 11:37:11', '\0', '2015-09-09 11:37:11', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184faafe6b014fb02dbde20129');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb02e93c1012d', '2015-09-09 11:38:06', '\0', '2015-09-09 11:38:06', '1', 'e1e7d5ef-a67f-404f-95d3-30a33d79f0c5', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fb02e93c1012c');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb03187660132', '2015-09-09 11:41:20', '\0', '2015-09-09 11:41:20', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184faafe6b014fb03187660131');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb035402d0135', '2015-09-09 11:45:24', '\0', '2015-09-09 11:45:24', '1', '72e35ec5-dbed-43ad-a531-0373465e456e', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fb035402d0134');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb035c0000138', '2015-09-09 11:45:56', '\0', '2015-09-09 11:45:56', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184faafe6b014fb035c0000137');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb03614f8013b', '2015-09-09 11:46:18', '\0', '2015-09-09 11:46:18', '1', 'e0fc7a54-50cc-4b1c-81f9-33a0e4193e84', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fb03614f7013a');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb03be0ec013e', '2015-09-09 11:52:38', '\0', '2015-09-09 11:52:38', '1', '981c8268-32b7-487e-9c5d-5d2a9ef925f5', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fb03be0ec013d');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb03c57970141', '2015-09-09 11:53:08', '\0', '2015-09-09 11:53:08', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184faafe6b014fb03c57970140');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb03ca7090144', '2015-09-09 11:53:29', '\0', '2015-09-09 11:53:29', '1', 'a28d9882-f56e-4390-9cc9-052c6ea80b84', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fb03ca7090143');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb03cf8c70147', '2015-09-09 11:53:50', '\0', '2015-09-09 11:53:50', '1', null, '1000', null, '4040409e4ed7e888014ed7ecbbf50001', 'faf08f184faafe6b014fb03cf8c60146');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb03ddc90014a', '2015-09-09 11:54:48', '\0', '2015-09-09 11:54:48', '1', '17bad7c9-ac43-4a29-8dbe-c5176b36b647', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fb03ddc8f0149');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb0415a560155', '2015-09-09 11:58:37', '\0', '2015-09-09 11:58:37', '1', 'b0692701-1afd-4308-a5b6-b35e4d3d8d56', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fb0415a560154');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb041d9690158', '2015-09-09 11:59:09', '\0', '2015-09-09 11:59:09', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184faafe6b014fb041d9690157');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb0452d89015b', '2015-09-09 12:02:47', '\0', '2015-09-09 12:02:47', '1', '0b95143d-cf7f-41b6-bd6b-2d2ce2e7a5f1', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fb0452d89015a');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb0460ba0015e', '2015-09-09 12:03:44', '\0', '2015-09-09 12:03:44', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184faafe6b014fb0460ba0015d');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb047b1ba0161', '2015-09-09 12:05:32', '\0', '2015-09-09 12:05:32', '1', '5374b799-af54-4f56-b91a-f736e7eadd5c', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fb047b1ba0160');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb049f72b0164', '2015-09-09 12:08:01', '\0', '2015-09-09 12:08:01', '1', '39c764bc-353a-495b-b15a-324cc123a400', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184faafe6b014fb049f72b0163');
INSERT INTO `order_merchandise` VALUES ('faf08f184faafe6b014fb04a6ad00167', '2015-09-09 12:08:31', '\0', '2015-09-09 12:08:31', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184faafe6b014fb04a6ad00166');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb112d2014fb11ccfa50002', '2015-09-09 15:58:19', '\0', '2015-09-09 15:58:19', '1', '0573a9e1-3c7a-428e-a369-8eec0dfb74ad', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb112d2014fb11ccfa40001');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb112d2014fb11d4b220005', '2015-09-09 15:58:51', '\0', '2015-09-09 15:58:51', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184fb112d2014fb11d4b220004');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb112d2014fb11d9b370008', '2015-09-09 15:59:11', '\0', '2015-09-09 15:59:11', '1', '51a2167d-2b33-4699-9dd2-1f7e8b1cc882', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb112d2014fb11d9b370007');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb112d2014fb11dfc48000b', '2015-09-09 15:59:36', '\0', '2015-09-09 15:59:36', '1', null, '400', null, 'faf08f184f4a77e7014f4a8b45f3000a', 'faf08f184fb112d2014fb11dfc47000a');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb112d2014fb11e1f76000e', '2015-09-09 15:59:45', '\0', '2015-09-09 15:59:45', '1', '92bffcbd-9eea-4d88-9460-977242c4776e', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb112d2014fb11e1f76000d');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb13600ec0002', '2015-09-09 16:25:50', '\0', '2015-09-09 16:25:50', '1', 'aadf5163-940d-4418-9534-4d958179572c', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb13600ea0001');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb136f3c20005', '2015-09-09 16:26:52', '\0', '2015-09-09 16:26:52', '1', '5f5fe630-0027-4717-ab9b-0fce63b0c30d', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb136f3c20004');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb15d4aae0028', '2015-09-09 17:08:45', '\0', '2015-09-09 17:08:45', '1', '8dc40722-3b33-4943-8946-d663f8687062', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb15d4aae0027');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb15da62a002b', '2015-09-09 17:09:08', '\0', '2015-09-09 17:09:08', '1', '2ce67e4e-d7b5-494b-8a33-97fe126cd89c', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb15da62a002a');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb15ebc26002e', '2015-09-09 17:10:19', '\0', '2015-09-09 17:10:19', '1', '345ce52a-be24-4343-8f59-8a07738f0baf', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb15ebc26002d');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb15ed77b0031', '2015-09-09 17:10:26', '\0', '2015-09-09 17:10:26', '1', 'a56786d9-3177-4204-9916-8771698443e4', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb15ed77b0030');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb15f87ce0034', '2015-09-09 17:11:12', '\0', '2015-09-09 17:11:12', '1', 'f855b5dc-4b53-4a0e-b223-5d871eb69a5f', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb15f87ce0033');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb16961dd0037', '2015-09-09 17:21:57', '\0', '2015-09-09 17:21:57', '1', '09e0a3b0-d778-439b-8708-507338a8dd9e', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb16961dd0036');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb1697bd2003a', '2015-09-09 17:22:04', '\0', '2015-09-09 17:22:04', '1', '6f07168d-8dde-46a6-af3f-8e24651616cd', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb1697bd10039');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb16a86b2003d', '2015-09-09 17:23:12', '\0', '2015-09-09 17:23:12', '1', '6d934f57-719a-4a0d-b02f-335278934fe8', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb16a86b2003c');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb17f4d5a0040', '2015-09-09 17:45:54', '\0', '2015-09-09 17:45:54', '1', 'ac42b380-3c70-4157-b139-1daf2a7615be', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb17f4d5a003f');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb1810f5e0043', '2015-09-09 17:47:49', '\0', '2015-09-09 17:47:49', '1', 'e29a805a-1d2c-452b-a810-d05306415867', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb1810f5e0042');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb1be2b120046', '2015-09-09 18:54:34', '\0', '2015-09-09 18:54:34', '1', '494e11f4-3f46-4387-924f-c8d6d7a6573e', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb1be2b120045');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb1c79b8b0049', '2015-09-09 19:04:52', '\0', '2015-09-09 19:04:52', '1', '67aed405-5e61-4401-8543-b12dcc0d0ea0', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb1c79b8b0048');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb1c7cd78004c', '2015-09-09 19:05:05', '\0', '2015-09-09 19:05:05', '1', 'd4ad07c3-628e-4ce8-a524-531ba667fe31', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb1c7cd77004b');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb1ca5d4d004f', '2015-09-09 19:07:53', '\0', '2015-09-09 19:07:53', '1', '5b536149-acbb-49c6-bcef-0a8d3132f0b5', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb1ca5d4d004e');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb1ca94040052', '2015-09-09 19:08:07', '\0', '2015-09-09 19:08:07', '1', 'ccefdf81-4a69-4de9-86df-299a67d16bd1', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb1ca94040051');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb4e391050055', '2015-09-10 09:34:16', '\0', '2015-09-10 09:34:16', '1', '01005c36-f363-4bb0-b41a-a40f809d0dd1', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb4e391050054');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb4e49cff0058', '2015-09-10 09:35:25', '\0', '2015-09-10 09:35:25', '1', '9ae9ba51-c413-4d31-bbef-d5224a737b7d', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb4e49cff0057');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb4e53a60005b', '2015-09-10 09:36:05', '\0', '2015-09-10 09:36:05', '1', '063855eb-7afc-471d-8456-a44b97dccb53', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb4e53a60005a');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb4e581b1005e', '2015-09-10 09:36:23', '\0', '2015-09-10 09:36:23', '1', '6019bc5f-c062-4239-8e6c-80b04683b3a0', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb4e581b0005d');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb4e5e8b30061', '2015-09-10 09:36:50', '\0', '2015-09-10 09:36:50', '1', 'fd0d4f0c-5f32-428b-8970-589c2d232e0e', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb4e5e8b30060');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb4e6952f0064', '2015-09-10 09:37:34', '\0', '2015-09-10 09:37:34', '1', '5c4130b4-549a-4cfa-981b-755fe80c1c9d', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb4e6952f0063');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb4e826e20067', '2015-09-10 09:39:17', '\0', '2015-09-10 09:39:17', '1', 'b956a040-b6da-4ba3-ac42-32b744543725', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb4e826e20066');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb4e8b2aa006a', '2015-09-10 09:39:53', '\0', '2015-09-10 09:39:53', '1', '219dd0aa-2eab-46dc-a237-2e4677b0adb7', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb4e8b2aa0069');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb4e9a59b006d', '2015-09-10 09:40:55', '\0', '2015-09-10 09:40:55', '1', '61705237-9b68-4144-81e1-8c42df650e8f', '1222', null, '4040409e4ed941b6014ed944a03e0000', 'faf08f184fb13015014fb4e9a59b006c');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb4ecf30b0070', '2015-09-10 09:44:31', '\0', '2015-09-10 09:44:31', '1', 'd96d5a2b-c9b6-4976-a1aa-9458db79d1c0', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb4ecf30b006f');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb4ee1d2d0073', '2015-09-10 09:45:48', '\0', '2015-09-10 09:45:48', '1', 'd98a3d28-2c80-447a-b7ce-26195a5a7913', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb4ee1d2d0072');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb4f316df0076', '2015-09-10 09:51:14', '\0', '2015-09-10 09:51:14', '1', '299188eb-9fbf-4ef4-bce7-5f0bddbe5f41', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb4f316df0075');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb4f353bb0079', '2015-09-10 09:51:29', '\0', '2015-09-10 09:51:29', '1', '2ca79307-ba25-4b09-b423-dbe2ef706a49', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb4f353bb0078');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb4f6ce6e007c', '2015-09-10 09:55:17', '\0', '2015-09-10 09:55:17', '1', '34ead101-73f6-4fcd-9b0a-a7917933e3cc', '1222', null, '4040409e4ed941b6014ed944a03e0000', 'faf08f184fb13015014fb4f6ce6e007b');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb4f982cf007f', '2015-09-10 09:58:14', '\0', '2015-09-10 09:58:14', '1', '27798148-ac3a-4da4-a544-f2d4472d8116', '100', null, 'faf08f184f4a77e7014f4a88d40b0006', 'faf08f184fb13015014fb4f982ce007e');
INSERT INTO `order_merchandise` VALUES ('faf08f184fb13015014fb4fa1b400082', '2015-09-10 09:58:54', '\0', '2015-09-10 09:58:54', '1', '104bfec7-a212-42e3-9972-68b50757db00', '1222', null, '4040409e4ed941b6014ed944a03e0000', 'faf08f184fb13015014fb4fa1b3f0081');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'user:*', '用户', '用户所有操作权限', '2015-08-26 15:39:32', '\0', '2015-08-26 15:39:46');
INSERT INTO `permission` VALUES ('2', 'merchandise:*', '商品', '商品所有操作权限', '2015-08-26 15:39:33', '\0', '2015-08-26 15:40:46');
INSERT INTO `permission` VALUES ('4', 'integralOrder:*', '积分订单', '积分订单所有操作权限', '2015-08-26 15:39:35', '\0', '2015-08-26 15:41:46');
INSERT INTO `permission` VALUES ('4040409e4f824f62014f825319820000', 'shop:*', '商户', '商户所有操作权限', '2015-08-31 13:55:28', '\0', '2015-09-02 12:24:49');
INSERT INTO `permission` VALUES ('4040409e4f8c4513014f8c4b00a00000', 'shop:branch:*', '商户-分店', '商户的分店所有操作权限', '2015-09-02 12:22:50', '\0', '2015-09-02 12:25:05');
INSERT INTO `permission` VALUES ('4040409e4f8cb0f4014f8cb30b420000', 'role:*', '角色', '', '2015-09-02 14:16:28', '\0', '2015-09-02 14:16:41');
INSERT INTO `permission` VALUES ('4040409e4f8cb0f4014f8cb3aa4d0001', 'perm:*', '权限', '', '2015-09-02 14:17:09', '\0', '2015-09-02 14:17:09');
INSERT INTO `permission` VALUES ('4040409e4f8cb0f4014f8cb3e16c0002', 'url:*', '路径', '', '2015-09-02 14:17:23', '\0', '2015-09-02 14:17:23');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', 'ROLE_SYSTEM', '', '2015-08-26 15:39:46', '\0', '2015-09-02 14:17:34');
INSERT INTO `role` VALUES ('4040409e4f699206014f6992ac4b0000', '管理员', 'ROLE_ADMIN', '', '2015-08-26 18:34:24', '\0', '2015-09-02 14:17:54');
INSERT INTO `role` VALUES ('4040409e4f8c4513014f8c4dd10d0001', '分店权限角色', 'ROLE_BRANCH', '', '2015-09-02 12:25:54', '\0', '2015-09-08 15:41:20');
INSERT INTO `role` VALUES ('4040409e4f8c4513014f8c4e4b660002', '总店权限角色', 'ROLE_SHOP', '', '2015-09-02 12:26:26', '\0', '2015-09-08 15:41:32');

-- ----------------------------
-- Table structure for role_perm
-- ----------------------------
DROP TABLE IF EXISTS `role_perm`;
CREATE TABLE `role_perm` (
  `role` varchar(255) NOT NULL,
  `perms` varchar(255) NOT NULL,
  PRIMARY KEY (`role`,`perms`),
  KEY `FK_i8bl83k96mmt1yljjsa7tbrpa` (`perms`),
  CONSTRAINT `FK_i8bl83k96mmt1yljjsa7tbrpa` FOREIGN KEY (`perms`) REFERENCES `permission` (`id`),
  CONSTRAINT `FK_jvcxgeley3hv26ckoahuuo02v` FOREIGN KEY (`role`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_perm
-- ----------------------------
INSERT INTO `role_perm` VALUES ('1', '1');
INSERT INTO `role_perm` VALUES ('4040409e4f699206014f6992ac4b0000', '1');
INSERT INTO `role_perm` VALUES ('1', '2');
INSERT INTO `role_perm` VALUES ('4040409e4f699206014f6992ac4b0000', '2');
INSERT INTO `role_perm` VALUES ('4040409e4f8c4513014f8c4dd10d0001', '2');
INSERT INTO `role_perm` VALUES ('4040409e4f8c4513014f8c4e4b660002', '2');
INSERT INTO `role_perm` VALUES ('1', '4');
INSERT INTO `role_perm` VALUES ('4040409e4f699206014f6992ac4b0000', '4');
INSERT INTO `role_perm` VALUES ('4040409e4f8c4513014f8c4dd10d0001', '4');
INSERT INTO `role_perm` VALUES ('4040409e4f8c4513014f8c4e4b660002', '4');
INSERT INTO `role_perm` VALUES ('1', '4040409e4f824f62014f825319820000');
INSERT INTO `role_perm` VALUES ('4040409e4f699206014f6992ac4b0000', '4040409e4f824f62014f825319820000');
INSERT INTO `role_perm` VALUES ('4040409e4f8c4513014f8c4e4b660002', '4040409e4f824f62014f825319820000');
INSERT INTO `role_perm` VALUES ('1', '4040409e4f8c4513014f8c4b00a00000');
INSERT INTO `role_perm` VALUES ('4040409e4f699206014f6992ac4b0000', '4040409e4f8c4513014f8c4b00a00000');
INSERT INTO `role_perm` VALUES ('4040409e4f8c4513014f8c4dd10d0001', '4040409e4f8c4513014f8c4b00a00000');
INSERT INTO `role_perm` VALUES ('1', '4040409e4f8cb0f4014f8cb30b420000');
INSERT INTO `role_perm` VALUES ('1', '4040409e4f8cb0f4014f8cb3aa4d0001');
INSERT INTO `role_perm` VALUES ('1', '4040409e4f8cb0f4014f8cb3e16c0002');

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `description` text,
  `shop_name` varchar(255) DEFAULT NULL,
  `classify` varchar(255) DEFAULT NULL,
  `main_pic` varchar(255) DEFAULT NULL,
  `integral` bigint(20) NOT NULL,
  `num` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4u8t7n440xeh8xpkedx2xkllq` (`classify`),
  KEY `FK_nhh2is8f57gbanh3yyma3so7k` (`main_pic`),
  CONSTRAINT `FK_4u8t7n440xeh8xpkedx2xkllq` FOREIGN KEY (`classify`) REFERENCES `categoryitem` (`id`),
  CONSTRAINT `FK_nhh2is8f57gbanh3yyma3so7k` FOREIGN KEY (`main_pic`) REFERENCES `medias` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('faf08f184f69691e014f698429e3000d', '2015-08-26 18:18:33', '\0', '2015-09-08 10:50:16', '高端定制女装', 'JEFEN', null, 'faf08f184faadb33014faadc6cf50004', '10000', '1');
INSERT INTO `shop` VALUES ('faf08f184fa58458014fa5bf9ced000c', '2015-09-07 11:00:42', '\0', '2015-09-08 10:57:34', '业内知名', '商户1', null, 'faf08f184faadb33014faae31c510005', '12300', '2');
INSERT INTO `shop` VALUES ('faf08f184fa58458014fa5c22dca0012', '2015-09-07 11:03:30', '\0', '2015-09-08 10:57:55', '', '商户2', null, 'faf08f184faadb33014faae36dd40006', '100000', '3');
INSERT INTO `shop` VALUES ('faf08f184fa58458014fa5c2f4650016', '2015-09-07 11:04:21', '\0', '2015-09-08 10:58:07', '', '商户3', null, 'faf08f184faadb33014faae39bea0007', '100000', '4');
INSERT INTO `shop` VALUES ('faf08f184fa58458014fa5c9541f001a', '2015-09-07 11:11:19', '\0', '2015-09-09 16:30:52', 'sssssssssssssssssssss', '商户4', null, 'faf08f184faadb33014faae3d12c0008', '160000', '5');
INSERT INTO `shop` VALUES ('faf08f184fa58458014fa5cb40ad001d', '2015-09-07 11:13:24', '\0', '2015-09-09 16:30:41', 'dfdfdsf', '商户5', null, 'faf08f184faadb33014faadbba5e0000', '100000', '6');
INSERT INTO `shop` VALUES ('faf08f184faafe6b014fac267d2600ae', '2015-09-08 16:50:47', '\0', '2015-09-08 16:50:47', 'sadd', '商户7', null, 'faf08f184faafe6b014fac267ce000ad', '10000', '7');
INSERT INTO `shop` VALUES ('faf08f184faafe6b014fac28c13300b1', '2015-09-08 16:53:15', '\0', '2015-09-08 16:53:15', 'fgfg', '商户8', null, 'faf08f184faafe6b014fac28be5000b0', '100000', '8');
INSERT INTO `shop` VALUES ('faf08f184faafe6b014fac2df1ca00b4', '2015-09-08 16:58:56', '\0', '2015-09-08 16:58:56', 'asfdf', '商户9', null, 'faf08f184faafe6b014fac2df13300b3', '90000', '9');
INSERT INTO `shop` VALUES ('faf08f184faafe6b014fac2e6a8300b6', '2015-09-08 16:59:27', '\0', '2015-09-08 16:59:27', 'fdfgfdsad', '商户10', null, 'faf08f184faafe6b014fac2e6a3600b5', '90000', '10');
INSERT INTO `shop` VALUES ('faf08f184faafe6b014fac2fb1ad00ba', '2015-09-08 17:00:50', '\0', '2015-09-08 17:00:50', 'dsf', '商户11', null, 'faf08f184faafe6b014fac2fb16800b9', '10000', '11');
INSERT INTO `shop` VALUES ('faf08f184faafe6b014fb04be1fd016a', '2015-09-09 12:10:07', '\0', '2015-09-09 16:44:31', '佳美口腔隶属于北京佳美医院管理有限责任公司，成立于1993年，是国内第一个连锁经营的大型现代化口腔门诊体系。\r\n佳美采用当今世界口腔医疗前沿技术，拥有系列自主知识产权和国内高水平医疗队伍，突破了传统的国内口腔医疗服务模式，以超过二十年的从业背景和雄厚的医护技术资源，开展口腔内科、口腔外科、口腔正畸、烤瓷牙、种植牙等业务。\r\n佳美以先进的医疗设备、人性化的服务、科学安全的消毒技术等特点受到广大患者的认可，已成为业界领先的知名品牌。\r\n佳美目前在北京、上海、大连多个中心城市建立了数十家直营连锁门诊，终身会员突破百万。 ', '佳美口腔', null, 'faf08f184faafe6b014fb04be1590168', '10500', '12');
INSERT INTO `shop` VALUES ('faf08f184fb13015014fb143cc1c0019', '2015-09-09 16:40:54', '\0', '2015-09-09 16:44:55', '北京光之树瑜伽中心是京城第一家艾扬格瑜伽中心，提供了综合的瑜伽学习课程，包括常规课程，密集课程，工作坊，以及艾扬格瑜 教师培训，瑜伽的习练遵循艾扬格大师的方式。我们的目标是去鼓励学生以艾扬格瑜伽的精神去习练，让身体轻盈健康，心理健康并获得灵性的成长。 \r\n光之树艾扬格瑜伽中心教师团队的老师都参加过严格的艾扬格教师培训，并获得教学认证资格。他们自律谦卑，并坚持每日习练，除了这些持续的教师培训课程以外，教师们会规律的去印度艾扬格学院及瑞诗凯诗参加更深入的学习。\r\n正因为如此老师们将会给中心的学生的高质量的指导和个人的关注。\r\n我们的中心位于北京市朝阳区东四环霄云桥芳园南里9号院7号楼108底商，场馆面积达600平。辅助工具配备齐全。环境简洁宽敞明亮。\r\n光之树，愿成为你瑜伽之路上的那盏明灯，照亮旅途中的每个暗角。', '光之树瑜伽中心', null, 'faf08f184fb13015014fb143cc0c0015', '10000', '13');

-- ----------------------------
-- Table structure for shop_tag
-- ----------------------------
DROP TABLE IF EXISTS `shop_tag`;
CREATE TABLE `shop_tag` (
  `shop` varchar(255) NOT NULL,
  `tags` varchar(255) NOT NULL,
  PRIMARY KEY (`shop`,`tags`),
  KEY `FK_itexrmky8sx8gewoyr5fyxwga` (`tags`),
  CONSTRAINT `FK_mi1r5xnvv4r4pqivhiqrkqm5q` FOREIGN KEY (`shop`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_tag
-- ----------------------------
INSERT INTO `shop_tag` VALUES ('faf08f184f69691e014f698429e3000d', 'faf08f184fa58458014fa5bee5bf0006');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fac28c13300b1', 'faf08f184fa58458014fa5bee5bf0006');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fac2df1ca00b4', 'faf08f184fa58458014fa5bee5bf0006');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fac2e6a8300b6', 'faf08f184fa58458014fa5bee5bf0006');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fac2fb1ad00ba', 'faf08f184fa58458014fa5bee5bf0006');
INSERT INTO `shop_tag` VALUES ('faf08f184f69691e014f698429e3000d', 'faf08f184fa58458014fa5bee60f0007');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fac28c13300b1', 'faf08f184fa58458014fa5bee60f0007');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fac2df1ca00b4', 'faf08f184fa58458014fa5bee60f0007');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fac2e6a8300b6', 'faf08f184fa58458014fa5bee60f0007');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fac2fb1ad00ba', 'faf08f184fa58458014fa5bee60f0007');
INSERT INTO `shop_tag` VALUES ('faf08f184f69691e014f698429e3000d', 'faf08f184fa58458014fa5bee6670008');
INSERT INTO `shop_tag` VALUES ('faf08f184fa58458014fa5c9541f001a', 'faf08f184fa58458014fa5bee6670008');
INSERT INTO `shop_tag` VALUES ('faf08f184fa58458014fa5cb40ad001d', 'faf08f184fa58458014fa5bee6670008');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fac28c13300b1', 'faf08f184fa58458014fa5bee6670008');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fac2df1ca00b4', 'faf08f184fa58458014fa5bee6670008');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fac2e6a8300b6', 'faf08f184fa58458014fa5bee6670008');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fac2fb1ad00ba', 'faf08f184fa58458014fa5bee6670008');
INSERT INTO `shop_tag` VALUES ('faf08f184f69691e014f698429e3000d', 'faf08f184fa58458014fa5bee6830009');
INSERT INTO `shop_tag` VALUES ('faf08f184fa58458014fa5cb40ad001d', 'faf08f184fa58458014fa5bee6830009');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fac267d2600ae', 'faf08f184fa58458014fa5bee6830009');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fac28c13300b1', 'faf08f184fa58458014fa5bee6830009');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fac2df1ca00b4', 'faf08f184fa58458014fa5bee6830009');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fac2e6a8300b6', 'faf08f184fa58458014fa5bee6830009');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fac2fb1ad00ba', 'faf08f184fa58458014fa5bee6830009');
INSERT INTO `shop_tag` VALUES ('faf08f184fa58458014fa5bf9ced000c', 'faf08f184fa58458014fa5bf9ced000b');
INSERT INTO `shop_tag` VALUES ('faf08f184fa58458014fa5c22dca0012', 'faf08f184fa58458014fa5c22d8a000f');
INSERT INTO `shop_tag` VALUES ('faf08f184fa58458014fa5c22dca0012', 'faf08f184fa58458014fa5c22db00010');
INSERT INTO `shop_tag` VALUES ('faf08f184fa58458014fa5c22dca0012', 'faf08f184fa58458014fa5c22dc90011');
INSERT INTO `shop_tag` VALUES ('faf08f184fa58458014fa5c2f4650016', 'faf08f184fa58458014fa5c2f4650015');
INSERT INTO `shop_tag` VALUES ('faf08f184fa58458014fa5c9541f001a', 'faf08f184fa58458014fa5c9541f0019');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fb04be1fd016a', 'faf08f184faafe6b014fb04123b2014c');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fb04be1fd016a', 'faf08f184faafe6b014fb04123d5014d');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fb04be1fd016a', 'faf08f184faafe6b014fb0412403014f');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fb04be1fd016a', 'faf08f184faafe6b014fb041241c0150');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fb04be1fd016a', 'faf08f184faafe6b014fb04124340151');
INSERT INTO `shop_tag` VALUES ('faf08f184faafe6b014fb04be1fd016a', 'faf08f184faafe6b014fb04be1c30169');
INSERT INTO `shop_tag` VALUES ('faf08f184fb13015014fb143cc1c0019', 'faf08f184fb13015014fb143cc140016');
INSERT INTO `shop_tag` VALUES ('faf08f184fb13015014fb143cc1c0019', 'faf08f184fb13015014fb143cc190017');
INSERT INTO `shop_tag` VALUES ('faf08f184fb13015014fb143cc1c0019', 'faf08f184fb13015014fb143cc1c0018');

-- ----------------------------
-- Table structure for url_perm
-- ----------------------------
DROP TABLE IF EXISTS `url_perm`;
CREATE TABLE `url_perm` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `perm` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of url_perm
-- ----------------------------
INSERT INTO `url_perm` VALUES ('1', '2015-09-02 11:26:53', '\0', '2015-09-02 11:26:57', 'user:*', '/admin/user/**', '');
INSERT INTO `url_perm` VALUES ('2', '2015-09-02 11:32:03', '\0', '2015-09-02 11:32:06', 'merchandise:*', '/admin/merchandise/**', '');
INSERT INTO `url_perm` VALUES ('3', '2015-09-02 11:32:32', '\0', '2015-09-02 11:32:35', 'integralOrder:*', '/admin/integralOrder/**', '');
INSERT INTO `url_perm` VALUES ('4', '2015-09-02 11:33:08', '\0', '2015-09-02 11:33:14', 'shop:*', '/admin/shop/**', '');
INSERT INTO `url_perm` VALUES ('4040409e4f8cb0f4014f8cb60ec20003', '2015-09-02 14:19:46', '\0', '2015-09-02 14:19:46', 'role:*', '/admin/role/**', '');
INSERT INTO `url_perm` VALUES ('4040409e4f8cb0f4014f8cb95cc10004', '2015-09-02 14:23:22', '\0', '2015-09-02 14:23:22', 'perm:*', '/admin/perm/**', '');
INSERT INTO `url_perm` VALUES ('4040409e4f8cb0f4014f8cb994dc0005', '2015-09-02 14:23:37', '\0', '2015-09-02 14:23:37', 'url:*', '/admin/url/**', '');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4040409e4f4a7076014f4a71b2ed0000', '123', 'test', '2015-08-26 15:39:46', '\0', '2015-09-02 12:49:09');
INSERT INTO `user` VALUES ('4040409e4f5d9364014f5d953eb70000', '123', 'fd', '2015-08-26 15:39:46', '\0', '2015-09-02 12:27:51');
INSERT INTO `user` VALUES ('4040409e4f63868e014f6387b4be0000', '123', 'zd', '2015-08-26 15:39:46', '\0', '2015-09-02 12:27:59');
INSERT INTO `user` VALUES ('999', 'admin', 'admin', '2015-08-26 15:39:46', '\0', '2015-09-02 12:48:17');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `users` varchar(255) NOT NULL,
  `roles` varchar(255) NOT NULL,
  PRIMARY KEY (`users`,`roles`),
  KEY `FK_jkxpywaiv5wun80y6eh0lhv6n` (`roles`),
  CONSTRAINT `FK_ayvj6lx62cg2fc3ca8m0qh7ig` FOREIGN KEY (`users`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_jkxpywaiv5wun80y6eh0lhv6n` FOREIGN KEY (`roles`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('999', '1');
INSERT INTO `user_role` VALUES ('4040409e4f4a7076014f4a71b2ed0000', '4040409e4f699206014f6992ac4b0000');
INSERT INTO `user_role` VALUES ('4040409e4f5d9364014f5d953eb70000', '4040409e4f8c4513014f8c4dd10d0001');
INSERT INTO `user_role` VALUES ('4040409e4f63868e014f6387b4be0000', '4040409e4f8c4513014f8c4e4b660002');

-- ----------------------------
-- Table structure for user_token
-- ----------------------------
DROP TABLE IF EXISTS `user_token`;
CREATE TABLE `user_token` (
  `id` varchar(255) NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2spl1jv3vep3g4fqr1kf6a38y` (`user`),
  CONSTRAINT `FK_2spl1jv3vep3g4fqr1kf6a38y` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_token
-- ----------------------------
