/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : integralmall

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-09-16 18:32:35
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
INSERT INTO `categoryitem` VALUES ('faf08f184fb5e098014fb64b2bef000c', '2015-09-10 16:07:03', '\0', '2015-09-10 16:07:03', null, null, '高端定制', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184fb5e098014fb64b2bf6000d', '2015-09-10 16:07:03', '\0', '2015-09-10 16:07:03', null, null, '女装', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184fb5e098014fb64b2bf9000e', '2015-09-10 16:07:03', '\0', '2015-09-10 16:07:03', null, null, 'jefen', null, null, '123');
INSERT INTO `categoryitem` VALUES ('faf08f184fb5e098014fb64b2bfc000f', '2015-09-10 16:07:03', '\0', '2015-09-10 16:07:03', null, null, '吉芬', null, null, '123');

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
  `integral` varchar(255) DEFAULT NULL,
  `origin` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3x5acto4r6c6nff6iawn13gdm` (`integral`),
  CONSTRAINT `FK_3x5acto4r6c6nff6iawn13gdm` FOREIGN KEY (`integral`) REFERENCES `integral` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of integral_detail
-- ----------------------------

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
  `seq` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ahevo3im3pnpk8ke9tqyuiaxh` (`parent`),
  CONSTRAINT `FK_ahevo3im3pnpk8ke9tqyuiaxh` FOREIGN KEY (`parent`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '2015-08-27 15:40:27', '\0', '2015-08-27 15:40:30', '渠道管理', '/admin/shop', null, 'shop', '3');
INSERT INTO `menu` VALUES ('10', '2015-08-28 18:42:23', '\0', '2015-08-28 18:42:26', '角色列表', '/admin/role', '4', 'role', '2');
INSERT INTO `menu` VALUES ('11', '2015-08-28 18:42:23', '\0', '2015-08-28 18:42:26', '权限列表', '/admin/perm', '4', 'perm', '3');
INSERT INTO `menu` VALUES ('12', '2015-09-02 14:10:20', '\0', '2015-09-02 14:10:22', '路径列表', '/admin/url', '4', 'url', '4');
INSERT INTO `menu` VALUES ('13', '2015-09-02 14:10:20', '\0', '2015-09-02 14:10:22', '积分管理', '/admin/integral', null, 'integral', '2');
INSERT INTO `menu` VALUES ('14', '2015-09-11 11:59:54', '\0', '2015-09-11 11:59:59', '用户积分', '/admin/integral', '13', 'integral', '1');
INSERT INTO `menu` VALUES ('2', '2015-08-27 15:41:35', '\0', '2015-08-27 15:41:39', '商品管理', '/admin/merchandise', null, 'merchandise', '4');
INSERT INTO `menu` VALUES ('3', '2015-08-27 15:42:04', '\0', '2015-08-27 15:42:07', '积分订单管理', '/admin/integralOrder', null, 'integralOrder', '5');
INSERT INTO `menu` VALUES ('4', '2015-08-27 15:42:25', '\0', '2015-08-27 15:42:28', '用户管理', '/admin/user', null, 'user', '1');
INSERT INTO `menu` VALUES ('5', '2015-08-27 15:43:37', '\0', '2015-08-27 15:43:40', '商家信息', '/admin/shop', '1', 'shop', '1');
INSERT INTO `menu` VALUES ('7', '2015-08-28 18:41:45', '\0', '2015-08-28 18:41:47', '上架商品', '/admin/merchandise', '2', 'shelve', '1');
INSERT INTO `menu` VALUES ('8', '2015-08-28 18:42:01', '\0', '2015-08-28 18:42:04', '积分订单列表', '/admin/integralOrder', '3', 'integralOrder', '1');
INSERT INTO `menu` VALUES ('9', '2015-08-28 18:42:23', '\0', '2015-08-28 18:42:26', '用户列表', '/admin/user', '4', 'user', '1');

-- ----------------------------
-- Table structure for merchandise
-- ----------------------------
DROP TABLE IF EXISTS `merchandise`;
CREATE TABLE `merchandise` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `integral_count` bigint(20) NOT NULL,
  `is_shelve` varchar(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `original` varchar(255) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `remark` text,
  `seq` varchar(255) DEFAULT NULL,
  `stock` bigint(20) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `classify` varchar(255) DEFAULT NULL,
  `main_pic_media` varchar(255) DEFAULT NULL,
  `type` varchar(31) NOT NULL,
  `brief` varchar(255) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fluipnudy4b30fh0q6imjf94a` (`brand`),
  KEY `FK_ieqpfuir6uq9oamwrgt0dhcl4` (`classify`),
  KEY `FK_rokvdq3lb9souda84pocqwndk` (`main_pic_media`),
  CONSTRAINT `FK_fluipnudy4b30fh0q6imjf94a` FOREIGN KEY (`brand`) REFERENCES `categoryitem` (`id`),
  CONSTRAINT `FK_ieqpfuir6uq9oamwrgt0dhcl4` FOREIGN KEY (`classify`) REFERENCES `categoryitem` (`id`),
  CONSTRAINT `FK_rokvdq3lb9souda84pocqwndk` FOREIGN KEY (`main_pic_media`) REFERENCES `medias` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of merchandise
-- ----------------------------

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

-- ----------------------------
-- Table structure for merch_branchshop
-- ----------------------------
DROP TABLE IF EXISTS `merch_branchshop`;
CREATE TABLE `merch_branchshop` (
  `merchs` varchar(255) NOT NULL,
  `shops` varchar(255) NOT NULL,
  PRIMARY KEY (`merchs`,`shops`),
  KEY `FK_l1jfd5ppjp3bajxcke3wwqk6i` (`shops`),
  CONSTRAINT `FK_7um09nbbv3rduj3hqr9r8ul3q` FOREIGN KEY (`merchs`) REFERENCES `merchandise` (`id`),
  CONSTRAINT `FK_l1jfd5ppjp3bajxcke3wwqk6i` FOREIGN KEY (`shops`) REFERENCES `branch_shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of merch_branchshop
-- ----------------------------

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
INSERT INTO `permission` VALUES ('4040409e4fba997e014fba9bd64f0001', 'integral:*', '积分管理', '', '2015-09-11 12:13:39', '\0', '2015-09-11 12:13:39');

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
INSERT INTO `role` VALUES ('1', '超级管理员', 'ROLE_SYSTEM', '', '2015-08-26 15:39:46', '\0', '2015-09-11 12:13:49');
INSERT INTO `role` VALUES ('4040409e4f699206014f6992ac4b0000', '管理员', 'ROLE_ADMIN', '', '2015-08-26 18:34:24', '\0', '2015-09-11 14:32:21');
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
INSERT INTO `role_perm` VALUES ('1', '4040409e4fba997e014fba9bd64f0001');
INSERT INTO `role_perm` VALUES ('4040409e4f699206014f6992ac4b0000', '4040409e4fba997e014fba9bd64f0001');

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
INSERT INTO `url_perm` VALUES ('4040409e4fba997e014fba9b7c9b0000', '2015-09-11 12:13:16', '\0', '2015-09-11 12:13:16', 'integral:*', '/admin/integral/**', '');

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
INSERT INTO `user` VALUES ('999', 'admin', 'admin', '2015-08-26 15:39:46', '\0', '2015-09-15 14:03:41');
INSERT INTO `user` VALUES ('faf08f184fcf1fdd014fcf9baa8e0003', '123456', 'sys', '2015-09-15 14:05:29', '\0', '2015-09-15 14:05:29');

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
INSERT INTO `user_role` VALUES ('faf08f184fcf1fdd014fcf9baa8e0003', '1');
INSERT INTO `user_role` VALUES ('4040409e4f4a7076014f4a71b2ed0000', '4040409e4f699206014f6992ac4b0000');
INSERT INTO `user_role` VALUES ('999', '4040409e4f699206014f6992ac4b0000');
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
