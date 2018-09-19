/*
Navicat MySQL Data Transfer

Source Server         : lrp_wd
Source Server Version : 50626
Source Host           : 118.89.34.94:3306
Source Database       : graduation_design

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-06-14 12:16:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `province` varchar(200) NOT NULL COMMENT '省份',
  `detailaddr` varchar(300) DEFAULT NULL COMMENT '详细地址',
  `zipcode` varchar(255) DEFAULT NULL COMMENT '邮编',
  `receiptname` varchar(255) DEFAULT NULL COMMENT '收货人姓名',
  `receipphone` varchar(255) DEFAULT NULL COMMENT '收货人电话',
  `userid` int(11) NOT NULL COMMENT '用户ID',
  `defauladdress` int(1) DEFAULT '0' COMMENT '是否默认地址 0：不是 1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='购物收货地址';

-- ----------------------------
-- Records of t_address
-- ----------------------------
INSERT INTO `t_address` VALUES ('22', '重庆市沙坪坝', '重庆市沙坪坝大学城', '400000', 'Joe', '13509000000', '19', '0');
INSERT INTO `t_address` VALUES ('23', '重庆市沙坪坝', '重庆市沙坪坝', '400000', 'Joe', '13509000000', '20', '1');
INSERT INTO `t_address` VALUES ('24', '重庆市沙坪坝', '重庆市沙坪坝', '400000', 'Joe', '13509000000', '20', '0');

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(20) NOT NULL,
  `adminPsswd` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员';

-- ----------------------------
-- Records of t_admin
-- ----------------------------

-- ----------------------------
-- Table structure for t_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `total` double DEFAULT NULL COMMENT '总金额',
  `userId` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='购物车';

-- ----------------------------
-- Records of t_cart
-- ----------------------------
INSERT INTO `t_cart` VALUES ('28', '0', '19');
INSERT INTO `t_cart` VALUES ('29', '0', '21');
INSERT INTO `t_cart` VALUES ('30', '0', '20');

-- ----------------------------
-- Table structure for t_cartitem
-- ----------------------------
DROP TABLE IF EXISTS `t_cartitem`;
CREATE TABLE `t_cartitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pname` varchar(255) NOT NULL,
  `pprice` double(10,2) NOT NULL COMMENT '单价',
  `ppic` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `count` int(11) NOT NULL COMMENT '商品数量',
  `subTotal` double NOT NULL COMMENT '商品金额小计',
  `cartId` int(11) NOT NULL COMMENT '购物车id',
  `sid` int(11) NOT NULL COMMENT '商家id',
  `pid` int(11) NOT NULL COMMENT '商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8 COMMENT='购物项';

-- ----------------------------
-- Records of t_cartitem
-- ----------------------------

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `categoryName` varchar(50) NOT NULL COMMENT '分类 蔬菜、水果、肉类、熟食、小吃等',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='食材分类：蔬菜、水果、肉类、熟食、小吃等\r\n';

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('1', '蔬菜类');
INSERT INTO `t_category` VALUES ('2', '水果类');
INSERT INTO `t_category` VALUES ('3', '肉类');
INSERT INTO `t_category` VALUES ('4', '熟食');
INSERT INTO `t_category` VALUES ('5', '谷物');

-- ----------------------------
-- Table structure for t_content
-- ----------------------------
DROP TABLE IF EXISTS `t_content`;
CREATE TABLE `t_content` (
  `id` int(11) NOT NULL COMMENT '主键',
  `userId` int(11) NOT NULL COMMENT '会员编号',
  `dietitianId` int(11) NOT NULL COMMENT '营养师编号',
  `zxTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '咨询时间',
  `zxText` varchar(200) NOT NULL COMMENT '资讯内容',
  `is_read` int(11) NOT NULL COMMENT '0：未阅读、1：已阅读',
  `zxIdentity` int(11) NOT NULL COMMENT '1：营养师回复、0：会员回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='高级会员向营养师咨询留言';

-- ----------------------------
-- Records of t_content
-- ----------------------------

-- ----------------------------
-- Table structure for t_dietapplication
-- ----------------------------
DROP TABLE IF EXISTS `t_dietapplication`;
CREATE TABLE `t_dietapplication` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` int(11) NOT NULL COMMENT '用户id',
  `userName` varchar(50) NOT NULL COMMENT '姓名',
  `uID` varchar(30) NOT NULL COMMENT '身份证号',
  `uIDImagesUrl` varchar(255) DEFAULT NULL COMMENT '身份证照片',
  `dietLicense` varchar(100) NOT NULL COMMENT '营养师执照 证书编号',
  `dietImageUrl` varchar(255) DEFAULT NULL COMMENT '营养师证书图片地址',
  `sqDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '申请日期',
  `sqStatus` int(11) NOT NULL COMMENT '申请状态 0：未成功，1：申请成功 ，2：待审核',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='营养师申请表';

-- ----------------------------
-- Records of t_dietapplication
-- ----------------------------
INSERT INTO `t_dietapplication` VALUES ('9', '19', 'super', '500228000000000000', 'http://118.89.34.94/images/userinfoimages/2017/06/06/1496683047431556.jpg', '000098976', 'http://118.89.34.94/images/userinfoimages/2017/06/06/1496683048207886.jpg', '2017-06-07 04:04:21', '1');
INSERT INTO `t_dietapplication` VALUES ('10', '21', 'lhb', '500228000000000000', 'http://118.89.34.94/images/userinfoimages/2017/06/06/1496683047431556.jpg', '000098976', 'http://118.89.34.94/images/userinfoimages/2017/06/06/1496683048207886.jpg', '2017-06-08 02:20:27', '2');

-- ----------------------------
-- Table structure for t_dietitian
-- ----------------------------
DROP TABLE IF EXISTS `t_dietitian`;
CREATE TABLE `t_dietitian` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` int(11) NOT NULL COMMENT '用户id',
  `userName` varchar(50) NOT NULL COMMENT '姓名',
  `uID` varchar(20) NOT NULL COMMENT '身份证号',
  `uidimageurl` varchar(255) DEFAULT NULL COMMENT '身份证图片url',
  `dietLicense` varchar(50) NOT NULL COMMENT '营养师执照',
  `dietImageUrl` varchar(255) DEFAULT NULL COMMENT '营养师执照图片url',
  `sqDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请日期',
  `status` int(11) NOT NULL COMMENT '1：可使用、0：不可使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='营养师表';

-- ----------------------------
-- Records of t_dietitian
-- ----------------------------
INSERT INTO `t_dietitian` VALUES ('3', '20', 'super', '500228000000000000', 'http://118.89.34.94/images/userinfoimages/2017/06/06/1496683047431556.jpg', '000098976', 'http://118.89.34.94/images/userinfoimages/2017/06/06/1496683048207886.jpg', '2017-06-06 01:17:29', '1');

-- ----------------------------
-- Table structure for t_dietitioncomment
-- ----------------------------
DROP TABLE IF EXISTS `t_dietitioncomment`;
CREATE TABLE `t_dietitioncomment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comText` varchar(200) NOT NULL COMMENT '评论内容',
  `comLevel` int(11) NOT NULL COMMENT '评论星级1-5级',
  `userId` int(11) NOT NULL COMMENT '用户id',
  `conTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `userName` varchar(50) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='营养师评价';

-- ----------------------------
-- Records of t_dietitioncomment
-- ----------------------------

-- ----------------------------
-- Table structure for t_dietplan
-- ----------------------------
DROP TABLE IF EXISTS `t_dietplan`;
CREATE TABLE `t_dietplan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL COMMENT '用户id',
  `foodid` int(11) NOT NULL COMMENT '食物id',
  `nutritionistid` int(11) NOT NULL COMMENT '营养师id',
  `foodname` varchar(200) NOT NULL COMMENT '食物名称',
  `foodquantity` double NOT NULL COMMENT '食物的参考摄入量',
  `actualweight` double DEFAULT NULL COMMENT '实际食用重量',
  `type` varchar(255) NOT NULL COMMENT '哪一餐？早，中，晚',
  `plandate` date NOT NULL COMMENT '计划日期',
  `planid` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='饮食计划表中具体体现';

-- ----------------------------
-- Records of t_dietplan
-- ----------------------------
INSERT INTO `t_dietplan` VALUES ('18', '20', '4', '19', '鸡肉', '50', '0', '早餐', '2017-06-08', '21');
INSERT INTO `t_dietplan` VALUES ('19', '20', '3', '19', '牛肉', '100', '0', '午餐', '2017-06-09', '21');
INSERT INTO `t_dietplan` VALUES ('20', '20', '4', '19', '鸡肉', '50', '0', '午餐', '2017-06-09', '21');
INSERT INTO `t_dietplan` VALUES ('21', '20', '5', '19', '鸭肉', '50', '0', '午餐', '2017-06-09', '21');
INSERT INTO `t_dietplan` VALUES ('22', '20', '8', '19', '鸭蛋', '20', '0', '晚餐', '2017-06-10', '21');
INSERT INTO `t_dietplan` VALUES ('23', '20', '10', '19', '鹅蛋', '25', '0', '晚餐', '2017-06-11', '21');
INSERT INTO `t_dietplan` VALUES ('24', '20', '8', '19', '鸭蛋', '20', '0', '晚餐', '2017-06-12', '21');
INSERT INTO `t_dietplan` VALUES ('25', '20', '17', '19', '西瓜', '50', '0', '早餐', '2017-06-13', '21');
INSERT INTO `t_dietplan` VALUES ('26', '20', '24', '19', '玉米', '9', '0', '午餐', '2017-06-14', '21');
INSERT INTO `t_dietplan` VALUES ('27', '20', '30', '19', '水蜜桃', '10', '0', '早餐', '2017-06-08', '23');
INSERT INTO `t_dietplan` VALUES ('28', '20', '29', '19', '芒果', '20', '0', '早餐', '2017-06-08', '23');

-- ----------------------------
-- Table structure for t_dietplanbyself
-- ----------------------------
DROP TABLE IF EXISTS `t_dietplanbyself`;
CREATE TABLE `t_dietplanbyself` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL COMMENT '用户id',
  `foodid` int(11) NOT NULL COMMENT '食物id',
  `foodname` varchar(200) NOT NULL COMMENT '食物名称',
  `foodquantity` double NOT NULL COMMENT '食物的参考摄入量',
  `actualweight` double DEFAULT NULL COMMENT '实际食用重量',
  `type` varchar(255) NOT NULL COMMENT '哪一餐？早，中，晚',
  `plandate` date NOT NULL COMMENT '计划日期',
  `planid` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='饮食计划表中具体体现';

-- ----------------------------
-- Records of t_dietplanbyself
-- ----------------------------
INSERT INTO `t_dietplanbyself` VALUES ('17', '20', '2', '花生奶', '200', '0', '早餐', '2017-06-01', '8');
INSERT INTO `t_dietplanbyself` VALUES ('18', '20', '1', '巧克力牛奶', '300', '0', '早餐', '2017-06-01', '8');
INSERT INTO `t_dietplanbyself` VALUES ('19', '20', '1', '巧克力牛奶', '300', '0', '早餐', '2017-06-02', '8');
INSERT INTO `t_dietplanbyself` VALUES ('20', '20', '2', '花生奶', '200', '0', '晚餐', '2017-06-02', '8');
INSERT INTO `t_dietplanbyself` VALUES ('21', '20', '1', '巧克力牛奶', '300', '0', '晚餐', '2017-06-02', '8');
INSERT INTO `t_dietplanbyself` VALUES ('22', '20', '1', '巧克力牛奶', '300', '0', '午餐', '2017-06-03', '8');
INSERT INTO `t_dietplanbyself` VALUES ('23', '20', '2', '花生奶', '200', '0', '早餐', '2017-06-03', '8');
INSERT INTO `t_dietplanbyself` VALUES ('24', '20', '1', '巧克力牛奶', '300', '0', '早餐', '2017-06-03', '8');
INSERT INTO `t_dietplanbyself` VALUES ('25', '21', '12', '绿豆', '20', '0', '早餐', '2017-06-06', '11');
INSERT INTO `t_dietplanbyself` VALUES ('26', '21', '11', '黄豆', '30', '0', '早餐', '2017-06-06', '11');
INSERT INTO `t_dietplanbyself` VALUES ('27', '21', '3', '牛肉', '100', '0', '午餐', '2017-06-07', '11');
INSERT INTO `t_dietplanbyself` VALUES ('28', '21', '3', '牛肉', '100', '0', '午餐', '2017-06-07', '11');
INSERT INTO `t_dietplanbyself` VALUES ('29', '21', '3', '牛肉', '100', '0', '午餐', '2017-06-07', '11');
INSERT INTO `t_dietplanbyself` VALUES ('30', '20', '24', '玉米', '9', '0', '早餐', '2017-06-06', '13');
INSERT INTO `t_dietplanbyself` VALUES ('31', '20', '25', '大米', '80', '0', '早餐', '2017-06-07', '13');
INSERT INTO `t_dietplanbyself` VALUES ('32', '20', '24', '玉米', '9', '0', '早餐', '2017-06-04', '14');
INSERT INTO `t_dietplanbyself` VALUES ('33', '20', '27', '巧克力牛奶', '100', '0', '早餐', '2017-06-05', '14');
INSERT INTO `t_dietplanbyself` VALUES ('34', '20', '5', '鸭肉', '50', '0', '晚餐', '2017-06-06', '14');
INSERT INTO `t_dietplanbyself` VALUES ('35', '20', '3', '牛肉', '100', '0', '早餐', '2017-06-06', '14');
INSERT INTO `t_dietplanbyself` VALUES ('36', '20', '17', '西瓜', '50', '0', '午餐', '2017-06-07', '14');
INSERT INTO `t_dietplanbyself` VALUES ('37', '20', '13', '牛奶', '100', '0', '早餐', '2017-06-06', '15');
INSERT INTO `t_dietplanbyself` VALUES ('38', '20', '14', '羊奶', '100', '0', '早餐', '2017-06-06', '15');
INSERT INTO `t_dietplanbyself` VALUES ('39', '20', '13', '牛奶', '100', '0', '早餐', '2017-06-06', '15');
INSERT INTO `t_dietplanbyself` VALUES ('40', '20', '6', '鱼肉', '110', '0', '早餐', '2017-06-06', '15');
INSERT INTO `t_dietplanbyself` VALUES ('41', '20', '14', '羊奶', '100', '0', '早餐', '2017-06-06', '15');
INSERT INTO `t_dietplanbyself` VALUES ('42', '20', '13', '牛奶', '100', '0', '早餐', '2017-06-06', '15');

-- ----------------------------
-- Table structure for t_food
-- ----------------------------
DROP TABLE IF EXISTS `t_food`;
CREATE TABLE `t_food` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `foodname` varchar(255) NOT NULL COMMENT '食物名称',
  `foodquantity` double(11,0) NOT NULL COMMENT '该种食物的参考摄入量(以克为单位)',
  `materialid` int(11) NOT NULL COMMENT '所属食材种类id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_food
-- ----------------------------
INSERT INTO `t_food` VALUES ('3', '牛肉', '100', '3');
INSERT INTO `t_food` VALUES ('4', '鸡肉', '50', '3');
INSERT INTO `t_food` VALUES ('5', '鸭肉', '50', '3');
INSERT INTO `t_food` VALUES ('6', '鱼肉', '110', '3');
INSERT INTO `t_food` VALUES ('8', '鸭蛋', '20', '4');
INSERT INTO `t_food` VALUES ('9', '鹌鹑蛋', '30', '4');
INSERT INTO `t_food` VALUES ('10', '鹅蛋', '25', '4');
INSERT INTO `t_food` VALUES ('11', '黄豆', '30', '2');
INSERT INTO `t_food` VALUES ('12', '绿豆', '20', '2');
INSERT INTO `t_food` VALUES ('13', '牛奶', '100', '5');
INSERT INTO `t_food` VALUES ('14', '羊奶', '100', '5');
INSERT INTO `t_food` VALUES ('15', '苹果', '10', '6');
INSERT INTO `t_food` VALUES ('16', '橘子', '20', '6');
INSERT INTO `t_food` VALUES ('17', '西瓜', '50', '6');
INSERT INTO `t_food` VALUES ('18', '鸭梨', '40', '6');
INSERT INTO `t_food` VALUES ('19', '白菜', '30', '7');
INSERT INTO `t_food` VALUES ('20', '菠菜', '15', '7');
INSERT INTO `t_food` VALUES ('21', '生菜', '16', '7');
INSERT INTO `t_food` VALUES ('22', '茄子', '17', '7');
INSERT INTO `t_food` VALUES ('23', '豆角', '13', '7');
INSERT INTO `t_food` VALUES ('24', '玉米', '9', '1');
INSERT INTO `t_food` VALUES ('25', '大米', '80', '1');
INSERT INTO `t_food` VALUES ('26', '小米', '70', '1');
INSERT INTO `t_food` VALUES ('27', '巧克力牛奶', '100', '5');
INSERT INTO `t_food` VALUES ('29', '芒果', '20', '6');
INSERT INTO `t_food` VALUES ('30', '水蜜桃', '10', '6');
INSERT INTO `t_food` VALUES ('32', '水蜜桃1', '10', '6');

-- ----------------------------
-- Table structure for t_foodnutrition
-- ----------------------------
DROP TABLE IF EXISTS `t_foodnutrition`;
CREATE TABLE `t_foodnutrition` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `foodid` int(11) NOT NULL COMMENT '食物id',
  `eatPart` varchar(32) DEFAULT NULL COMMENT '可食用部分每一百克',
  `energy` varchar(32) DEFAULT NULL COMMENT '能量',
  `waterContent` varchar(32) DEFAULT NULL COMMENT '水分',
  `protein` varchar(32) DEFAULT NULL COMMENT '蛋白质',
  `fat` varchar(32) DEFAULT NULL COMMENT '脂肪',
  `dietaryFiber` varchar(32) DEFAULT NULL COMMENT '膳食纤维',
  `carbohydrate` varchar(32) DEFAULT NULL COMMENT '碳水化物',
  `vitaminsA` varchar(32) DEFAULT NULL COMMENT '维生素A',
  `vitaminsB1` varchar(32) DEFAULT NULL COMMENT '维生素B1',
  `vitaminsB2` varchar(32) DEFAULT NULL COMMENT '维生素B2',
  `vitaminsC` varchar(32) DEFAULT NULL COMMENT '维生素C',
  `vitaminsE` varchar(32) DEFAULT NULL COMMENT '维生素E',
  `niacin` varchar(32) DEFAULT NULL COMMENT '烟酸',
  `na` varchar(32) DEFAULT NULL COMMENT '钠',
  `calcium` varchar(32) DEFAULT NULL COMMENT '钙',
  `iron` varchar(32) DEFAULT NULL COMMENT '铁',
  `cholesterol` varchar(32) DEFAULT NULL COMMENT '胆固醇\r\n            ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='食物营养表';

-- ----------------------------
-- Records of t_foodnutrition
-- ----------------------------
INSERT INTO `t_foodnutrition` VALUES ('2', '27', null, '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `t_foodnutrition` VALUES ('4', '3', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `t_foodnutrition` VALUES ('5', '4', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO `t_foodnutrition` VALUES ('6', '5', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `t_foodnutrition` VALUES ('7', '6', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4');
INSERT INTO `t_foodnutrition` VALUES ('8', '8', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5');
INSERT INTO `t_foodnutrition` VALUES ('9', '9', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6');
INSERT INTO `t_foodnutrition` VALUES ('10', '10', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_foodnutrition` VALUES ('11', '11', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8');
INSERT INTO `t_foodnutrition` VALUES ('12', '12', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9');
INSERT INTO `t_foodnutrition` VALUES ('13', '29', null, '10', '50', '0.2', '0.4', '0.3', '0.5', '0.3', '0.2', '0.3', '0.1', '0.6', '0.8', '0.5', '0.6', '0.4', '0.6');
INSERT INTO `t_foodnutrition` VALUES ('14', '30', null, '4', '2', '2', '2', '8', '1', '2', '36', '9', '5', '7', '5', '7', '9', '9', '7');
INSERT INTO `t_foodnutrition` VALUES ('16', '32', null, '4', '2', '2', '2', '8', '1', '2', '36', '9', '5', '7', '5', '', '9', '9', '7');

-- ----------------------------
-- Table structure for t_healthinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_healthinfo`;
CREATE TABLE `t_healthinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `zixuntext` text NOT NULL COMMENT '资讯内容',
  `author` varchar(255) DEFAULT NULL,
  `zixuntype` int(2) NOT NULL COMMENT '资讯类型',
  `show` int(2) DEFAULT NULL COMMENT '是否展示  1展示  0不展示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='健康资讯';

-- ----------------------------
-- Records of t_healthinfo
-- ----------------------------

-- ----------------------------
-- Table structure for t_hotsearch
-- ----------------------------
DROP TABLE IF EXISTS `t_hotsearch`;
CREATE TABLE `t_hotsearch` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '每一条热搜记录的id',
  `hotName` varchar(10) NOT NULL COMMENT '热搜商品的名字',
  `hotCount` int(11) NOT NULL COMMENT '热搜商品的搜索次数',
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '搜索日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hotsearch
-- ----------------------------
INSERT INTO `t_hotsearch` VALUES ('1', '牛排', '9', '2017-04-14 10:18:48');
INSERT INTO `t_hotsearch` VALUES ('2', '百香果', '8', '2017-04-14 10:19:06');
INSERT INTO `t_hotsearch` VALUES ('3', '苹果', '7', '2017-04-14 10:19:17');
INSERT INTO `t_hotsearch` VALUES ('4', '秋葵', '6', '2017-04-14 10:19:27');
INSERT INTO `t_hotsearch` VALUES ('5', '小龙虾', '5', '2017-04-14 10:19:36');
INSERT INTO `t_hotsearch` VALUES ('6', '皮蛋', '4', '2017-04-14 10:19:45');
INSERT INTO `t_hotsearch` VALUES ('7', '火龙果', '3', '2017-04-14 10:19:49');
INSERT INTO `t_hotsearch` VALUES ('8', '菠萝', '2', '2017-04-14 10:20:00');
INSERT INTO `t_hotsearch` VALUES ('9', '脆谷乐', '2', '2017-04-14 10:20:22');
INSERT INTO `t_hotsearch` VALUES ('10', '西红柿', '1', '2017-04-14 10:20:27');

-- ----------------------------
-- Table structure for t_itemcollocation
-- ----------------------------
DROP TABLE IF EXISTS `t_itemcollocation`;
CREATE TABLE `t_itemcollocation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` int(11) NOT NULL COMMENT '商品ID',
  `collocation` varchar(1000) DEFAULT NULL COMMENT 'json 格式的 pid ',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_itemcollocation
-- ----------------------------
INSERT INTO `t_itemcollocation` VALUES ('1', '5', '{\"code\":200,\"list\":[]}');
INSERT INTO `t_itemcollocation` VALUES ('2', '1', '{\"code\":200,\"list\":[]}');
INSERT INTO `t_itemcollocation` VALUES ('3', '2', '{\"code\":200,\"list\":[1]}');
INSERT INTO `t_itemcollocation` VALUES ('4', '4', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('5', '6', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('6', '7', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('7', '8', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('8', '9', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('9', '10', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('10', '11', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('11', '12', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('12', '13', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('13', '14', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('14', '15', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('15', '16', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('16', '17', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('17', '18', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('18', '19', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('19', '20', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('20', '21', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('21', '22', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('22', '23', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('23', '24', '{\"code\":200,\"list\":[9,21,3,6]}');
INSERT INTO `t_itemcollocation` VALUES ('27', '10005', '{\"code\":200,\"list\":[\"1\",\"3\",\"5\"]}');
INSERT INTO `t_itemcollocation` VALUES ('28', '10006', '{\"code\":200,\"list\":[\"1\",\"3\",\"5\",\"9\"]}');
INSERT INTO `t_itemcollocation` VALUES ('29', '10007', '{\"code\":200,\"list\":[\"1\",\"2\",\"3\",\"5\"]}');
INSERT INTO `t_itemcollocation` VALUES ('30', '30', '{\"code\":200,\"list\":[\"1\",\"2\",\"3\",\"5\"]}');
INSERT INTO `t_itemcollocation` VALUES ('31', '10008', '{\"code\":200,\"list\":[\"1\",\"2\",\"3\",\"5\"]}');
INSERT INTO `t_itemcollocation` VALUES ('123', '10009', '{\"code\":200,\"list\":[\"2\",\"3\",\"4\",\"5\"]}');
INSERT INTO `t_itemcollocation` VALUES ('124', '10010', '{\"code\":200,\"list\":[\"2\",\"3\",\"4\",\"6\"]}');

-- ----------------------------
-- Table structure for t_material
-- ----------------------------
DROP TABLE IF EXISTS `t_material`;
CREATE TABLE `t_material` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `materialname` varchar(255) NOT NULL COMMENT '食材种类名称',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_material
-- ----------------------------
INSERT INTO `t_material` VALUES ('1', '五谷');
INSERT INTO `t_material` VALUES ('2', '豆类');
INSERT INTO `t_material` VALUES ('3', '肉类');
INSERT INTO `t_material` VALUES ('4', '蛋类');
INSERT INTO `t_material` VALUES ('5', '奶类');
INSERT INTO `t_material` VALUES ('6', '水果');
INSERT INTO `t_material` VALUES ('7', '蔬菜');

-- ----------------------------
-- Table structure for t_messageremind
-- ----------------------------
DROP TABLE IF EXISTS `t_messageremind`;
CREATE TABLE `t_messageremind` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL COMMENT '用户id',
  `nid` int(11) NOT NULL COMMENT '营养师id',
  `message` varchar(255) NOT NULL COMMENT '发送的消息内容',
  `messagetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发送消息的时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_messageremind
-- ----------------------------
INSERT INTO `t_messageremind` VALUES ('4', '20', '19', 'azgsxfdxhfgh', '2017-06-06 01:40:56');
INSERT INTO `t_messageremind` VALUES ('5', '20', '19', 'rweetrwtwtwet', '2017-06-08 14:09:37');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `total` double NOT NULL COMMENT '订单总金额',
  `orderTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  `orderStates` int(11) NOT NULL DEFAULT '1' COMMENT '订单状态 1:待商家接单 2商家拒接单   3：商家已接单待配送 4：已收货待评价  5：交易完成',
  `userName` varchar(50) NOT NULL COMMENT '收货人姓名',
  `userPhone` varchar(20) NOT NULL COMMENT '收货人电话',
  `userAddr` varchar(200) NOT NULL COMMENT '收货地址',
  `userId` int(11) NOT NULL COMMENT '用户id',
  `storeid` int(11) NOT NULL COMMENT '商家id',
  `message` varchar(1000) DEFAULT NULL COMMENT '留言',
  `delstatus` int(11) DEFAULT '0' COMMENT '0:未删除可用、1：已删除不可用',
  `ordercomment` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10028 DEFAULT CHARSET=utf8 COMMENT='订单';

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('10022', '279.3', '2017-06-06 10:30:17', '5', 'wan', '13509000000', '重庆市沙坪坝大学城', '19', '9', '', '0', '');
INSERT INTO `t_order` VALUES ('10023', '119.6', '2017-06-06 10:31:51', '2', 'lisi', '13509000000', '重庆市沙坪坝大学城', '19', '9', '2017年6月6日10:31:49', '0', null);
INSERT INTO `t_order` VALUES ('10024', '103.2', '2017-06-06 10:35:21', '2', 'wan', '13509000000', '重庆市沙坪坝大学城', '19', '9', '2017年6月6日10:35:18', '0', null);
INSERT INTO `t_order` VALUES ('10025', '238', '2017-06-06 13:56:09', '1', 'wan', '13509000000', '重庆市沙坪坝', '20', '9', '2017年6月6日13:56:05', '0', null);
INSERT INTO `t_order` VALUES ('10026', '39.9', '2017-06-06 14:23:09', '1', 'Joe', '13509000000', '重庆市沙坪坝', '20', '9', '', '0', null);
INSERT INTO `t_order` VALUES ('10027', '20.2', '2017-06-06 14:23:24', '1', 'Joe', '13509000000', '重庆市沙坪坝', '20', '9', '', '0', null);

-- ----------------------------
-- Table structure for t_orderitem
-- ----------------------------
DROP TABLE IF EXISTS `t_orderitem`;
CREATE TABLE `t_orderitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pname` varchar(255) NOT NULL COMMENT '商品名称',
  `ppic` varchar(255) DEFAULT NULL COMMENT '商品图片地址',
  `pprice` double(10,2) NOT NULL,
  `count` int(11) NOT NULL COMMENT '商品数量',
  `subtotal` double NOT NULL COMMENT '商品小计',
  `orderId` int(11) NOT NULL COMMENT '订单号',
  `pid` int(11) NOT NULL COMMENT '商品id',
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `status` int(2) DEFAULT '1' COMMENT '订单状态 1:商家接单  2：商家拒接单 3：已发货  4：交易完成',
  `sid` int(11) NOT NULL COMMENT '商家ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8 COMMENT='购物订单项';

-- ----------------------------
-- Records of t_orderitem
-- ----------------------------
INSERT INTO `t_orderitem` VALUES ('100', '美仑达 四川蒲江丑柑丑橘 5斤装 不知火 柑/橘/桔 自营水果', 'https://img14.360buyimg.com/cms/jfs/t4288/329/1863774451/244141/48f1ac05/58c790d7Nea890361.jpg', '39.90', '4', '159.6', '10022', '2', '19', '5', '9');
INSERT INTO `t_orderitem` VALUES ('101', '1114斤包邮无公害新鲜蔬菜黄秋葵 新鲜秋葵 新鲜黄秋葵蔬菜秋葵', 'https://gd4.alicdn.com/imgextra/i4/196493112/TB2nG1eXS0jpuFjy0FlXXc0bpXa_!!196493112.jpg_400x400.jpg_.webp', '39.90', '3', '119.69999999999999', '10022', '1', '19', '5', '9');
INSERT INTO `t_orderitem` VALUES ('102', '1114斤包邮无公害新鲜蔬菜黄秋葵 新鲜秋葵 新鲜黄秋葵蔬菜秋葵', 'https://gd4.alicdn.com/imgextra/i4/196493112/TB2nG1eXS0jpuFjy0FlXXc0bpXa_!!196493112.jpg_400x400.jpg_.webp', '39.90', '3', '119.69999999999999', '10023', '1', '19', '2', '9');
INSERT INTO `t_orderitem` VALUES ('103', '鲜农乐云南新鲜水果玉米 约2.25kg 4-6根 甜玉米 新鲜蔬菜', 'http://img14.360buyimg.com/n7/jfs/t4273/40/2602428795/250154/317a60c0/58d383e2N6f04f427.jpg', '25.80', '4', '103.2', '10024', '8', '19', '2', '9');
INSERT INTO `t_orderitem` VALUES ('104', '名家厨房 牛排10片装1520g 黑椒 菲力西冷 顺丰包邮 赠2刀叉油酱包', 'http://img11.360buyimg.com/n1/jfs/t2446/19/2787779510/257805/1bf07374/571888c6N83029e68.jpg', '119.00', '2', '238', '10025', '19', '20', '1', '9');
INSERT INTO `t_orderitem` VALUES ('105', '美仑达 四川蒲江丑柑丑橘 5斤装 不知火 柑/橘/桔 自营水果', 'https://img14.360buyimg.com/cms/jfs/t4288/329/1863774451/244141/48f1ac05/58c790d7Nea890361.jpg', '39.90', '1', '39.9', '10026', '2', '20', '1', '9');
INSERT INTO `t_orderitem` VALUES ('106', '【京东超市】雀巢(Nestle)脆谷乐谷物早餐300g(新老包装交替发货)', 'http://img20.360buyimg.com/vc/jfs/t3844/101/4163616464/82841/bed684a9/58aa71e3N07c77f76.jpg', '20.20', '1', '20.2', '10027', '7', '20', '1', '9');

-- ----------------------------
-- Table structure for t_orderstatistics
-- ----------------------------
DROP TABLE IF EXISTS `t_orderstatistics`;
CREATE TABLE `t_orderstatistics` (
  `id` int(11) NOT NULL,
  `storeSqCount` int(11) NOT NULL COMMENT '商家申请量',
  `totalOrderCount` int(11) NOT NULL COMMENT '每日订单总量',
  `cancelOrderCount` int(11) NOT NULL COMMENT '每日取消订单总量',
  `complOrderCount` int(11) NOT NULL COMMENT '每日交易完成量',
  `totalAmount` double NOT NULL COMMENT '每日成交额',
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单金额统计';

-- ----------------------------
-- Records of t_orderstatistics
-- ----------------------------

-- ----------------------------
-- Table structure for t_pbrowserecord
-- ----------------------------
DROP TABLE IF EXISTS `t_pbrowserecord`;
CREATE TABLE `t_pbrowserecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL COMMENT '商品ID',
  `uid` int(11) DEFAULT NULL COMMENT '浏览商品的用户ID',
  `username` varchar(255) DEFAULT NULL COMMENT '浏览商品的用户名',
  `browsetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '浏览时间',
  `usertype` int(2) DEFAULT NULL COMMENT '浏览商品的用户类型: 1游客 2登陆用户',
  `userip` varchar(255) DEFAULT NULL COMMENT '用户的IP地址',
  `sid` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pbrowserecord
-- ----------------------------
INSERT INTO `t_pbrowserecord` VALUES ('104', '2', '0', '游客', '2017-06-06 10:15:36', '1', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('105', '2', '19', 'admin', '2017-06-06 10:16:15', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('106', '1', '19', 'admin', '2017-06-06 10:16:23', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('107', '1', '19', 'admin', '2017-06-06 10:31:38', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('108', '8', '19', 'admin', '2017-06-06 10:35:12', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('109', '19', '20', 'Joe', '2017-06-06 13:54:59', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('110', '19', '20', 'Joe', '2017-06-06 14:05:21', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('111', '19', '20', 'Joe', '2017-06-06 14:05:30', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('112', '19', '20', 'Joe', '2017-06-06 14:05:34', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('113', '19', '20', 'Joe', '2017-06-06 14:05:38', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('114', '19', '20', 'Joe', '2017-06-06 14:06:36', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('115', '19', '20', 'Joe', '2017-06-06 14:07:15', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('116', '1', '20', 'Joe', '2017-06-06 14:07:34', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('117', '1', '20', 'Joe', '2017-06-06 14:07:40', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('118', '1', '20', 'Joe', '2017-06-06 14:08:13', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('119', '1', '20', 'Joe', '2017-06-06 14:12:39', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('120', '2', '20', 'Joe', '2017-06-06 14:12:56', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('121', '2', '20', 'Joe', '2017-06-06 14:20:26', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('122', '2', '20', 'Joe', '2017-06-06 14:21:33', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('123', '2', '20', 'Joe', '2017-06-06 14:22:41', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('124', '2', '20', 'Joe', '2017-06-06 14:22:46', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('125', '2', '20', 'Joe', '2017-06-06 14:22:48', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('126', '2', '20', 'Joe', '2017-06-06 14:23:13', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('127', '7', '20', 'Joe', '2017-06-06 14:23:17', '2', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('128', '9', '0', '游客', '2017-06-08 00:47:22', '1', '0:0:0:0:0:0:0:1', '9');
INSERT INTO `t_pbrowserecord` VALUES ('129', '1', '0', '游客', '2017-06-08 01:37:17', '1', '106.91.181.34', '10');

-- ----------------------------
-- Table structure for t_pcomment
-- ----------------------------
DROP TABLE IF EXISTS `t_pcomment`;
CREATE TABLE `t_pcomment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comText` varchar(1000) NOT NULL COMMENT '评论内容 文本',
  `comType` int(11) DEFAULT NULL COMMENT '评论等级 1：好评，2：中评，3：差评',
  `comLevel` int(11) NOT NULL COMMENT '五星 1-5星',
  `pId` int(11) NOT NULL COMMENT '商品id',
  `userName` varchar(50) NOT NULL COMMENT '用户姓名',
  `time` datetime NOT NULL,
  `userId` int(11) NOT NULL COMMENT '用户id',
  `orderitemid` int(11) NOT NULL COMMENT '订单项id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='商品评论';

-- ----------------------------
-- Records of t_pcomment
-- ----------------------------
INSERT INTO `t_pcomment` VALUES ('20', '橘子不错！', '2', '4', '2', 'admin', '2017-06-06 10:39:07', '19', '100');
INSERT INTO `t_pcomment` VALUES ('21', '秋葵不错！', '1', '5', '1', 'admin', '2017-06-06 10:41:01', '19', '101');
INSERT INTO `t_pcomment` VALUES ('22', '秋葵不错！', '1', '5', '1', 'admin', '2017-06-06 10:41:01', '19', '101');

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL COMMENT '主键',
  `name` varchar(128) NOT NULL COMMENT '资源名称',
  `type` varchar(128) NOT NULL COMMENT '资源类型：menu,button,',
  `url` varchar(128) NOT NULL COMMENT '访问url地址',
  `percode` varchar(128) NOT NULL COMMENT '权限代码字符串',
  `parentid` int(11) NOT NULL COMMENT '父结点id',
  `parentids` varchar(128) NOT NULL COMMENT '父结点id列表串',
  `sortstring` varchar(128) NOT NULL COMMENT '排序号',
  `available` int(11) NOT NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源权限表';

-- ----------------------------
-- Records of t_permission
-- ----------------------------

-- ----------------------------
-- Table structure for t_picture
-- ----------------------------
DROP TABLE IF EXISTS `t_picture`;
CREATE TABLE `t_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '每一条记录的id',
  `purl` varchar(500) NOT NULL COMMENT '图片的存储地址',
  `url` varchar(255) DEFAULT NULL COMMENT '鏈接地址',
  `type` varchar(10) NOT NULL COMMENT '图片的类型',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_picture
-- ----------------------------
INSERT INTO `t_picture` VALUES ('1', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490076873&di=fc3ce00eb6bb76b0c6e984f402284a3d&imgtype=jpg&er=1&src=http%3A%2F%2Fpic.90sjimg.com%2Fback_pic%2Fqk%2Fback_origin_pic%2F00%2F03%2F53%2F6a1b8611d1c424ef1a0085fb29d8d886.jpg', 'http://localhost:8880/zixun/%E5%AD%A3%E8%8A%82%E8%B5%84%E8%AE%AF/2017/06/07/8.html', '资讯', '2017-06-08 01:50:46');
INSERT INTO `t_picture` VALUES ('2', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489485839919&di=a63c6aa1154f1d1cc223996e35301d03&imgtype=0&src=http%3A%2F%2Fp.yjbys.com%2Fimage%2F20160725%2F1469426765927937.jpg', 'http://localhost:8880/zixun/%E5%AD%A3%E8%8A%82%E8%B5%84%E8%AE%AF/2017/05/20/3.html', '资讯', '2017-06-08 01:50:58');
INSERT INTO `t_picture` VALUES ('3', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489485334875&di=092f8a775ce7e7ff8fb2f9be2348fe55&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F14%2F12%2F24%2F47n58PICthZ_1024.jpg', 'http://localhost:8880/zixun/%E5%AD%A3%E8%8A%82%E8%B5%84%E8%AE%AF/2017/06/05/13.html', '资讯', '2017-06-08 01:51:20');
INSERT INTO `t_picture` VALUES ('4', 'http://file06.16sucai.com/2016/0405/9ffa238e4e02b331cf97f99f8b05ffe3.jpg', 'http://localhost:8880/zixun/%E5%AD%A3%E8%8A%82%E8%B5%84%E8%AE%AF/2017/06/08/17.html', '资讯', '2017-06-08 01:51:33');
INSERT INTO `t_picture` VALUES ('5', 'http://pic.90sjimg.com/back_pic/00/04/20/33/6fd044e345df5e50ba27182b4d27a611.jpg', 'http://localhost:8881/zixun/seasoninfo/5.htmlhttp://localhost:8880/zixun/%E5%AD%A3%E8%8A%82%E8%B5%84%E8%AE%AF/2017/05/29/14.html', '资讯', '2017-06-08 01:51:37');
INSERT INTO `t_picture` VALUES ('6', 'http://cdn7.staztic.com/app/a/6836/6836762/vegetables-puzzle-1-2-s-307x512.jpg', 'http://localhost:8883/list.html?itemtype=%E8%94%AC%E8%8F%9C', '商品', '2017-06-08 01:48:45');
INSERT INTO `t_picture` VALUES ('7', 'http://pic.58pic.com/58pic/13/89/12/83g58PICV76_1024.jpg', 'http://localhost:8883/list.html?itemtype=%E6%B0%B4%E6%9E%9C', '商品', '2017-06-08 01:49:16');
INSERT INTO `t_picture` VALUES ('8', 'http://img.51daifu.com/image/201510/20151028/20151028091838_69849.png', 'http://localhost:8883/list.html?itemtype=%E8%82%89%E7%B1%BB', '商品', '2017-04-21 09:51:39');
INSERT INTO `t_picture` VALUES ('9', 'http://pic24.photophoto.cn/20120812/0020033083855183_b.jpg', 'http://localhost:8883/list.html?itemtype=%E7%86%9F%E9%A3%9F', '商品', '2017-06-08 01:49:40');
INSERT INTO `t_picture` VALUES ('10', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489484660420&di=ed208adbb56128a308a63915bbf49c06&imgtype=0&src=http%3A%2F%2Fimg.ys137.com%2Fuploads%2Fallimg%2F150422%2F1054291243-1.jpg', 'http://localhost:8883/list.html?itemtype=%E8%B0%B7%E7%89%A9', '商品', '2017-06-08 01:49:54');

-- ----------------------------
-- Table structure for t_planindex
-- ----------------------------
DROP TABLE IF EXISTS `t_planindex`;
CREATE TABLE `t_planindex` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL COMMENT '用户id',
  `nutritionistid` int(11) NOT NULL COMMENT '营养师id',
  `startdate` date DEFAULT NULL COMMENT '起始日期',
  `enddate` date DEFAULT NULL,
  `plantype` int(11) NOT NULL COMMENT '0代表饮食计划，1运动计划',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_planindex
-- ----------------------------
INSERT INTO `t_planindex` VALUES ('21', '20', '19', '2017-06-08', '2017-06-14', '0');
INSERT INTO `t_planindex` VALUES ('22', '20', '19', '2017-06-08', '2017-06-08', '1');
INSERT INTO `t_planindex` VALUES ('23', '20', '19', '2017-06-08', '2017-06-08', '0');
INSERT INTO `t_planindex` VALUES ('24', '20', '19', '2017-06-08', '2017-06-08', '1');

-- ----------------------------
-- Table structure for t_planindexbyself
-- ----------------------------
DROP TABLE IF EXISTS `t_planindexbyself`;
CREATE TABLE `t_planindexbyself` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL COMMENT '用户id',
  `startdate` date DEFAULT NULL COMMENT '起始日期',
  `enddate` date DEFAULT NULL,
  `plantype` int(11) NOT NULL COMMENT '0代表饮食计划，1运动计划',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_planindexbyself
-- ----------------------------
INSERT INTO `t_planindexbyself` VALUES ('8', '20', '2017-06-01', '2017-06-03', '0');
INSERT INTO `t_planindexbyself` VALUES ('9', '20', '2017-06-06', '2017-06-06', '1');
INSERT INTO `t_planindexbyself` VALUES ('10', '20', '2017-06-06', '2017-06-12', '1');
INSERT INTO `t_planindexbyself` VALUES ('11', '21', '2017-06-06', '2017-06-07', '0');
INSERT INTO `t_planindexbyself` VALUES ('12', '21', '2017-06-06', '2017-06-07', '1');
INSERT INTO `t_planindexbyself` VALUES ('13', '20', '2017-06-06', '2017-06-07', '0');
INSERT INTO `t_planindexbyself` VALUES ('14', '20', '2017-06-04', '2017-06-07', '0');
INSERT INTO `t_planindexbyself` VALUES ('15', '20', '2017-06-06', '2017-06-06', '0');

-- ----------------------------
-- Table structure for t_potalbrowserecord
-- ----------------------------
DROP TABLE IF EXISTS `t_potalbrowserecord`;
CREATE TABLE `t_potalbrowserecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `browsetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `usertype` int(2) DEFAULT NULL COMMENT '浏览商品的用户类型: 1登录用户 2游客',
  `userip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_potalbrowserecord
-- ----------------------------
INSERT INTO `t_potalbrowserecord` VALUES ('59', '0', '游客', '2017-06-06 01:04:27', '2', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('60', '19', 'admin', '2017-06-06 01:05:53', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('61', '19', 'admin', '2017-06-06 01:07:43', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('62', '19', 'admin', '2017-06-06 01:09:37', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('63', '20', 'Joe', '2017-06-06 01:09:55', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('64', '19', 'admin', '2017-06-06 01:15:28', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('65', '20', 'Joe', '2017-06-06 01:16:39', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('66', '20', 'Joe', '2017-06-06 01:19:14', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('67', '19', 'admin', '2017-06-06 01:26:53', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('68', '20', 'Joe', '2017-06-06 01:27:06', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('69', '20', 'Joe', '2017-06-06 01:57:16', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('70', '0', '游客', '2017-06-06 10:04:51', '2', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('71', '0', '游客', '2017-06-06 10:08:35', '2', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('72', '0', '游客', '2017-06-06 10:09:49', '2', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('73', '19', 'admin', '2017-06-06 11:07:33', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('74', '19', 'admin', '2017-06-06 11:20:28', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('75', '19', 'admin', '2017-06-06 11:22:10', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('76', '21', '李海滨', '2017-06-06 12:31:17', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('77', '21', '李海滨', '2017-06-06 12:31:28', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('78', '21', '李海滨', '2017-06-06 12:45:30', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('79', '21', '李海滨', '2017-06-06 12:47:55', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('80', '20', 'Joe', '2017-06-06 13:54:43', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('81', '20', 'Joe', '2017-06-06 14:07:24', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('82', '0', '游客', '2017-06-06 18:56:01', '2', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('83', '0', '游客', '2017-06-07 23:22:05', '2', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('84', '19', 'admin', '2017-06-07 23:24:52', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('85', '19', 'admin', '2017-06-07 23:51:07', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('86', '20', 'Joe', '2017-06-07 23:51:39', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('87', '0', '游客', '2017-06-08 00:07:44', '2', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('88', '0', '游客', '2017-06-08 00:09:44', '2', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('89', '20', 'Joe', '2017-06-08 00:11:50', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('90', '20', 'Joe', '2017-06-08 00:40:57', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('91', '0', '游客', '2017-06-08 00:46:51', '2', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('92', '0', '游客', '2017-06-08 01:13:42', '2', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('93', '0', '游客', '2017-06-08 01:26:23', '2', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('94', '0', '游客', '2017-06-08 01:34:55', '2', '106.91.181.34');
INSERT INTO `t_potalbrowserecord` VALUES ('95', '0', '游客', '2017-06-08 01:36:16', '2', '106.91.181.34');
INSERT INTO `t_potalbrowserecord` VALUES ('96', '0', '游客', '2017-06-08 01:36:58', '2', '106.91.181.34');
INSERT INTO `t_potalbrowserecord` VALUES ('97', '0', '游客', '2017-06-08 01:46:34', '2', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('98', '0', '游客', '2017-06-08 01:48:10', '2', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('99', '20', 'Joe', '2017-06-08 01:51:56', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('100', '0', '游客', '2017-06-08 02:03:49', '2', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('101', '0', '游客', '2017-06-08 02:36:05', '2', '0:0:0:0:0:0:0:1');
INSERT INTO `t_potalbrowserecord` VALUES ('102', '0', '游客', '2017-06-08 09:11:43', '2', '0:0:0:0:0:0:0:1');

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `storeid` int(11) NOT NULL COMMENT '商品所属商家id',
  `pName` varchar(100) NOT NULL COMMENT '商品名称',
  `pms` varchar(255) DEFAULT NULL COMMENT '简单描述',
  `pPrice` double NOT NULL COMMENT '商品价格',
  `pPic` varchar(400) NOT NULL COMMENT '图片',
  `pDesc` text NOT NULL COMMENT '商品描述',
  `pCreatTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上架时间',
  `is_hot` int(11) NOT NULL COMMENT '是否热门商品 1:热门  ，0：不是热门',
  `pStock` int(11) NOT NULL COMMENT '库存',
  `pSellNum` int(11) NOT NULL COMMENT '销量',
  `is_sell` int(11) NOT NULL COMMENT '上下架  1：上架， 0：下架',
  `pType` varchar(50) NOT NULL COMMENT '商品分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10011 DEFAULT CHARSET=utf8 COMMENT='商品信息';

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('1', '10', '1114斤包邮无公害新鲜蔬菜黄秋葵 新鲜秋葵 新鲜黄秋葵蔬菜秋葵', '品质就是生命，我们不需要等待，新鲜采摘，品质保证。为确保新鲜，当天下单，次日采摘发货，一般下单后当天发货。果蔬码头与市面所售的黄秋葵的区别在于，我们是鲜采鲜发，保证新鲜，不打农药，使用农肥，不使用化学肥料，基地当天摘现发货无停留，确保新鲜！可以生吃', '39.9', 'https://gd4.alicdn.com/imgextra/i4/196493112/TB2nG1eXS0jpuFjy0FlXXc0bpXa_!!196493112.jpg_400x400.jpg_.webp', '暂无   1   1   1', '2017-06-08 00:10:29', '1', '10', '0', '1', '蔬菜类');
INSERT INTO `t_product` VALUES ('2', '9', '美仑达 四川蒲江丑柑丑橘 5斤装 不知火 柑/橘/桔 自营水果', '【人气火爆，天府直采，好评过万】蒲江丑柑不知火，外表虽丑内心却甜，供港央企品质保证，自然美味，香甜可口【三峡稀有品种，秭归伦晚鲜橙】【双重品质保证：绿色食品认证 出口备案果园认证】', '39.9', 'https://img14.360buyimg.com/cms/jfs/t4288/329/1863774451/244141/48f1ac05/58c790d7Nea890361.jpg', '美仑达蒲江丑柑不知火', '2017-06-06 03:08:40', '1', '22', '22', '1', '水果类');
INSERT INTO `t_product` VALUES ('3', '9', '佳农 菲律宾菠萝 2个装 单果1KG以上 自营水果', '【京东自营】京东生鲜自营产品 211限时达 清甜滋味，无需盐水浸泡，稍放至泛黄后食用口感更佳！', '20', 'https://img20.360buyimg.com/vc/jfs/t3436/107/2240017469/886859/f464e258/584a0826N8ebb683e.jpg', '菠萝', '2017-06-06 03:08:43', '1', '2', '2', '1', '水果类');
INSERT INTO `t_product` VALUES ('4', '9', '【冷鲜肉】高金食品 黑猪肉土猪腿肉300g 林间散养山黑猪', '【5件顺丰包邮】山林放养黑猪冷鲜肉 狠土狠香狠好吃 先领券再下单', '26.9', 'http://img12.360buyimg.com/n1/jfs/t3994/35/1239989791/204519/ff73a00c/58be2bc8Nbe26175f.jpg', '野猪肉', '2017-06-06 03:08:45', '1', '1', '1', '0', '肉类');
INSERT INTO `t_product` VALUES ('5', '9', '红功夫 麻辣小龙虾 十三香7-9钱16-20只1.5kg净虾量750g', '活虾烧制◆大个虾 腮白黄多◆多仓齐发 快速直达◆加热即食 赠品虾套装', '89', 'https://img10.360buyimg.com/n1/jfs/t2761/158/2632141179/642688/db4e53fe/576cc6e8N8a90c620.jpg', '<div class=\"detail-content-wrap\">\r\n                                                                                    \r\n                            <div class=\"detail-content-item\">\r\n                                                                                                <div id=\"activity_header\" clstag=\"shangpin|keycount|product|activityheader\"><div style=\"text-align: center;\"><a href=\"https://sale.jd.com/act/YF7h6q5tcmA2UI.html\" target=\"_blank\"><img data-lazyload=\"done\" alt=\"\" src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t4882/359/700447948/64039/14cab90a/58e6ee07N219320a0.jpg\"></a></div></div>\r\n                                                                                                <div id=\"J-detail-content\"><style>/*C-B*/\r\n\r\n.ssd-module-wrap {width: 750px; margin: 0 auto; position: relative; text-align: left; background-color: #ffffff;}\r\n.ssd-module-wrap .ssd-module,.ssd-module-wrap .ssd-module-heading{ width: 750px; position:relative; overflow: hidden;  }\r\n.ssd-module{background-repeat:no-repeat; background-position:left center; background-size:100% 100%;}\r\n.ssd-module .ssd-widget-pic{ position: absolute; overflow: hidden; }\r\n.ssd-module .ssd-widget-pic img{display: block; width:100%; height:100% }\r\n.ssd-module .ssd-widget-text{ position: absolute; overflow: hidden;}\r\n.ssd-module .ssd-widget-text span{display:block;overflow:hidden; width:100%;  height:100%; padding:0; margin: 0; word-break:break-all; word-wrap:break-word; white-space:normal;}\r\n.ssd-module .ssd-widget-link{ position: absolute; left: 0; top: 0; width: 100%; height: 100%; background: transparent;z-index:100 }\r\n.ssd-widget-text{ line-height: 1.5; }\r\n.ssd-module-heading{background-repeat:no-repeat; background-position:left center; background-size:100% 100%; }\r\n.ssd-module-heading .ssd-module-heading-layout{display:inline-block;}\r\n.ssd-module-heading .ssd-widget-heading-ch{float: left;display: inline-block;margin-left: 15px; margin-right:6px; height: 100%;}\r\n.ssd-module-heading .ssd-widget-heading-en{float: left;display: inline-block;margin-left: 6px; margin-right:15px; height: 100%;}\r\n/*C-E*/.M14884616570231{height:400px; width:750px; background-color:#e3ddee; background-image:url(//img30.360buyimg.com/sku/jfs/t4297/257/670742298/113228/6f1b705d/58b81ef3Nfa797376.jpg)}\r\n.M14884616667902{height:400px; width:750px; background-color:#f9e2b1; background-image:url(//img30.360buyimg.com/sku/jfs/t3211/196/7433427334/209709/df961319/58b81ef8N9877d559.jpg)}\r\n.M14884616813093{height:400px; width:750px; background-color:#ceb8d9; background-image:url(//img30.360buyimg.com/sku/jfs/t4384/359/1100971545/109097/571f6bbf/58bd66a7Nd02dbc16.jpg)}\r\n.M14884616930144{height:400px; width:750px; background-color:#f9e2b1; background-image:url(//img30.360buyimg.com/sku/jfs/t4336/256/720944430/104899/487c7eb6/58b81ef6Nb2d8e9e5.jpg)}\r\n.M14884617033735{height:400px; width:750px; background-color:#f4ab9b; background-image:url(//img30.360buyimg.com/sku/jfs/t3277/240/7622705162/143513/afce60c1/58b81ef7Ndaf09b3f.jpg)}\r\n.M14884617137736{height:400px; width:750px; background-color:#f9e2b1; background-image:url(//img30.360buyimg.com/sku/jfs/t3301/262/7473948131/170485/4b461cb1/58b81ef6Ncba28f31.jpg)}\r\n.M14884617243587{height:400px; width:750px; background-color:#e3ddee; background-image:url(//img30.360buyimg.com/sku/jfs/t3262/5/7569776922/158446/c1264921/58b81ef4Nc108ae53.jpg)}\r\n.M14884617391028{height:400px; width:750px; background-color:#ceb8d9; background-image:url(//img30.360buyimg.com/sku/jfs/t3202/159/7507379775/166216/d6022f4f/58b81ef6N9a3a25ef.jpg)}\r\n.M14884617497029{height:400px; width:750px; background-color:#a7d7e8; background-image:url(//img30.360buyimg.com/sku/jfs/t4219/192/713613780/126975/4fc2ee3d/58b81ef8N67e08220.jpg)}\r\n.M148846175961410{height:400px; width:750px; background-color:#c9e4d9; background-image:url(//img30.360buyimg.com/sku/jfs/t3049/175/7597327115/70165/520f520d/58b81ef8N8fb0d6f5.jpg)}\r\n.M148846177245411{height:400px; width:750px; background-color:#fef2e1; background-image:url(//img30.360buyimg.com/sku/jfs/t3202/112/7492218315/120302/5d111d77/58b81ef8N224e6777.jpg)}\r\n.M148846178274212{height:400px; width:750px; background-color:#a7d7e8; background-image:url(//img30.360buyimg.com/sku/jfs/t4297/275/685216057/90702/752f56ae/58b81ef9N31b9a52c.jpg)}\r\n.M148846179485413{height:400px; width:750px; background-color:#c9e4d9; background-image:url(//img30.360buyimg.com/sku/jfs/t4063/274/800560014/140483/2f832a02/58b81ef7N197483ce.jpg)}\r\n.M148846180961314{height:400px; width:750px; background-color:#f4ab9b; background-image:url(//img30.360buyimg.com/sku/jfs/t3091/143/7387343574/127168/b23a16a7/58b81ef9N335dc85e.jpg)}\r\n.M148846181938115{height:400px; width:750px; background-color:#a7d7e8; background-image:url(//img30.360buyimg.com/sku/jfs/t3205/229/7566599519/77253/2a1d97ca/58b81ef9Nf28568b1.jpg)}\r\n.M148846183663716{height:400px; width:750px; background-color:#f9e2b1; background-image:url(//img30.360buyimg.com/sku/jfs/t3298/92/7551278735/71466/d84b991a/58b81ef8N8840c645.jpg)}\r\n.M148846184601317{height:400px; width:750px; background-color:#f4ab9b; background-image:url(//img30.360buyimg.com/sku/jfs/t4162/202/693581146/114505/8e2dbcec/58b81ef9N9f20aca8.jpg)}\r\n.M148846187942318{height:400px; width:750px; background-color:#e3ddee; background-image:url(//img30.360buyimg.com/sku/jfs/t4351/252/728232030/106224/7fe256ee/58b81ef9N4d44781b.jpg)}\r\n.M148846189563819{height:400px; width:750px; background-color:#fbdcd1; background-image:url(//img30.360buyimg.com/sku/jfs/t4270/221/713777366/64553/f7f0229b/58b81efaN21edee56.jpg)}\r\n.M148846192705320{height:400px; width:750px; background-color:#a7d7e8; background-image:url(//img30.360buyimg.com/sku/jfs/t3250/347/7595126717/84349/2296ad94/58b81efbN98022b52.jpg)}\r\n.M148846194894921{height:400px; width:750px; background-color:#fbdcd1; background-image:url(//img30.360buyimg.com/sku/jfs/t3955/322/787575525/94757/4351060a/58b81efaNbe8c72ed.jpg)}\r\n.M148846195949422{height:400px; width:750px; background-color:#fcfbdb; background-image:url(//img30.360buyimg.com/sku/jfs/t4336/272/713062751/57021/1c954479/58b81efaN5b5638f2.jpg)}\r\n.M148846196940523{height:400px; width:750px; background-color:#f9e2b1; background-image:url(//img30.360buyimg.com/sku/jfs/t4216/194/702672932/99958/fd381f0d/58b81efbN09abac21.jpg)}\r\n.M148846197840524{height:400px; width:750px; background-color:#e3ddee; background-image:url(//img30.360buyimg.com/sku/jfs/t4267/238/710431076/96892/98bb4493/58b81efbN8c9b69ef.jpg)}\r\n.M148846198508625{height:400px; width:750px; background-color:#fbdcd1; background-image:url(//img30.360buyimg.com/sku/jfs/t3130/68/7564280775/94890/9b755a75/58b81efbNe6b93f17.jpg)}\r\n.M148846199346226{height:400px; width:750px; background-color:#f4ab9b; background-image:url(//img30.360buyimg.com/sku/jfs/t3058/136/7541600400/71537/8b730bb1/58b81efcN416f7953.jpg)}\r\n.M148846200056627{height:400px; width:750px; background-color:#e3ddee; background-image:url(//img30.360buyimg.com/sku/jfs/t4027/238/787569851/56124/9c5816e1/58b81efbN81a90d66.jpg)}\r\n.M148846200963828{height:400px; width:750px; background-color:#b9deeb; background-image:url(//img30.360buyimg.com/sku/jfs/t3304/229/7392833643/81274/eaf0c8e/58b81efbN15b72c66.jpg)}\r\n.M148846201619029{height:200px; width:750px; background-color:#fbdcd1; background-image:url(//img30.360buyimg.com/sku/jfs/t4027/261/775573185/22940/4494cca1/58b81efbN5e728da6.jpg)}\r\n</style><br><div id=\"zbViewModulesH\" value=\"11400\"></div><input id=\"zbViewModulesHeight\" type=\"hidden\" value=\"11400\"><div skudesign=\"100010\"></div><div class=\"ssd-module-wrap\">\r\n    <div class=\"ssd-module M14884616570231 animate-M14884616570231\"></div>\r\n<div class=\"ssd-module M14884616667902 animate-M14884616667902\"></div>\r\n<div class=\"ssd-module M14884616813093 animate-M14884616813093\"></div>\r\n<div class=\"ssd-module M14884616930144 animate-M14884616930144\"></div>\r\n<div class=\"ssd-module M14884617033735 animate-M14884617033735\"></div>\r\n<div class=\"ssd-module M14884617137736 animate-M14884617137736\"></div>\r\n<div class=\"ssd-module M14884617243587 animate-M14884617243587\"></div>\r\n<div class=\"ssd-module M14884617391028 animate-M14884617391028\"></div>\r\n<div class=\"ssd-module M14884617497029 animate-M14884617497029\"></div>\r\n<div class=\"ssd-module M148846175961410 animate-M148846175961410\"></div>\r\n<div class=\"ssd-module M148846177245411 animate-M148846177245411\"></div>\r\n<div class=\"ssd-module M148846178274212 animate-M148846178274212\"></div>\r\n<div class=\"ssd-module M148846179485413 animate-M148846179485413\"></div>\r\n<div class=\"ssd-module M148846180961314 animate-M148846180961314\"></div>\r\n<div class=\"ssd-module M148846181938115 animate-M148846181938115\"></div>\r\n<div class=\"ssd-module M148846183663716 animate-M148846183663716\"></div>\r\n<div class=\"ssd-module M148846184601317 animate-M148846184601317\"></div>\r\n<div class=\"ssd-module M148846187942318 animate-M148846187942318\"></div>\r\n<div class=\"ssd-module M148846189563819 animate-M148846189563819\"></div>\r\n<div class=\"ssd-module M148846192705320 animate-M148846192705320\"></div>\r\n<div class=\"ssd-module M148846194894921 animate-M148846194894921\"></div>\r\n<div class=\"ssd-module M148846195949422 animate-M148846195949422\"></div>\r\n<div class=\"ssd-module M148846196940523 animate-M148846196940523\"></div>\r\n<div class=\"ssd-module M148846197840524 animate-M148846197840524\"></div>\r\n<div class=\"ssd-module M148846198508625 animate-M148846198508625\"></div>\r\n<div class=\"ssd-module M148846199346226 animate-M148846199346226\"></div>\r\n<div class=\"ssd-module M148846200056627 animate-M148846200056627\"></div>\r\n<div class=\"ssd-module M148846200963828 animate-M148846200963828\"></div>\r\n<div class=\"ssd-module M148846201619029 animate-M148846201619029\"></div>\r\n\r\n</div><!-- 2017-03-06 09:40:07 --> <br></div><!-- #J-detail-content -->\r\n                                                                                                <div id=\"activity_footer\" clstag=\"shangpin|keycount|product|activityfooter\"><div class=\"formwork_img\"><img data-lazyload=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3697/65/2057866242/350671/994d8247/583d235dN0f9e6eb6.jpg\" alt=\"\"><br></div><div class=\"formwork_img\"><img data-lazyload=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3637/247/2056924298/311211/d2265588/583d2363Nc6cfe1c7.jpg\" alt=\"\"><br></div></div>\r\n                                                            </div>\r\n                        </div>', '2017-06-06 03:08:48', '1', '32', '23', '0', '熟食');
INSERT INTO `t_product` VALUES ('6', '10', '展卉 越南进口红心火龙果 2个装 总重约1kg 自营水果', '富含天然花青素。漂洋过海的完美水果，清凉美味浑然天成。【四川丑橘不知火】丑的有特点，内心很甘甜，京东生鲜产地直采，清新柑香，美味爽口，惊艳你的味蕾。', '32', 'http://img20.360buyimg.com/vc/jfs/t4660/70/499359113/124151/392e49e4/58d0a207Nd43a2815.jpg', '火龙果', '2017-06-08 00:10:36', '1', '1', '1', '1', '蔬菜类');
INSERT INTO `t_product` VALUES ('7', '9', '【京东超市】雀巢(Nestle)脆谷乐谷物早餐300g(新老包装交替发货)', '营养早餐不只有麦片，雀巢谷物，欢乐多多，非油炸，更健康！详情请点击', '20.2', 'http://img20.360buyimg.com/vc/jfs/t3844/101/4163616464/82841/bed684a9/58aa71e3N07c77f76.jpg', '营养早餐', '2017-06-06 03:08:59', '1', '22', '32', '1', '谷物类');
INSERT INTO `t_product` VALUES ('8', '9', '鲜农乐云南新鲜水果玉米 约2.25kg 4-6根 甜玉米 新鲜蔬菜', '2017年春季新鲜玉米，每天现砍现发，非常新鲜，香甜爆浆 坏包赔 每份4-6根', '25.8', 'http://img14.360buyimg.com/n7/jfs/t4273/40/2602428795/250154/317a60c0/58d383e2N6f04f427.jpg', '鲜农乐云南新鲜水果玉米', '2017-06-06 03:09:03', '1', '11', '211', '0', '蔬菜类');
INSERT INTO `t_product` VALUES ('9', '9', '天目山 小香薯 红薯 5斤装 临安 板栗薯番薯 小蕃薯 红暑紫薯新鲜蔬菜 地瓜', '天目山小香薯 5斤装，香糯粉，红薯 新鲜现挖', '38', 'http://img12.360buyimg.com/n1/jfs/t4225/357/1683643690/371208/99d0f254/58c54906N4af9bf7c.jpg', '天目山 小香薯 红薯 5斤装 临安 板栗薯番薯 小蕃薯 红暑紫薯新鲜蔬菜 地瓜', '2017-06-06 03:09:15', '1', '34', '2', '1', '蔬菜类');
INSERT INTO `t_product` VALUES ('10', '9', '【京东直赔】密园小农 北京密云当地西红柿 番茄 新鲜蔬菜 约2kg', '【包装升级】破损包赔，全程农家肥种植的农家番茄，没有催红剂，小时候的味道。会员礼包', '45', 'http://img14.360buyimg.com/n1/jfs/t3133/275/5154026666/135627/2e12e625/58647ebeN3763a8b1.jpg', '【包装升级】破损包赔，全程农家肥种植的农家番茄，没有催红剂，小时候的味道。会员礼包', '2017-06-06 03:09:16', '1', '23', '6', '1', '蔬菜类');
INSERT INTO `t_product` VALUES ('11', '9', '爱奇果 陕西眉县 猕猴桃 12粒装 单果90-110g 自营水果', '【自营水果】【陕西猕猴桃 产地直采】【10万好评 见证品质】【价格PK全网】深入产地，全程监控！爆款皇冠梨 Crown Pear【价格PK全网】清甜润肺', '29.9', 'http://img13.360buyimg.com/n7/jfs/t3655/151/1971152678/274261/fb508f8c/5840d683Na2190edd.jpg', '爱奇果 陕西眉县 猕猴桃 12粒装 单果90-110g 自营水果', '2017-06-06 03:09:18', '1', '32', '32', '1', '水果类');
INSERT INTO `t_product` VALUES ('12', '9', '展卉 百香果西番莲 12个 单果50-80g 自营水果', '优选“酸甜可口、果肉多汁”,举世闻名的香料水果。【四川丑橘不知火】丑的有特点，内心很甘甜，京东生鲜产地直采，惊艳你的味蕾。(此商品不参加上述活动)', '21.9', 'http://img12.360buyimg.com/n7/jfs/t4249/299/1787013554/1398162/765fb60/58c74838N1e6366c5.jpg', '优选“酸甜可口、果肉多汁”,举世闻名的香料水果。【四川丑橘不知火】丑的有特点，内心很甘甜，京东生鲜产地直采，惊艳你的味蕾。(此商品不参加上述活动)', '2017-06-06 03:09:19', '1', '3', '2', '1', '水果类');
INSERT INTO `t_product` VALUES ('13', '9', '潘苹果 甘肃天水红富士苹果 9粒 礼盒装 80mm 总重量约4斤 自营水果', '【自营水果】 【天水苹果 产地直采】【精美礼盒】潘石屹亲情代言！礼品要选放心的！【维C之王】爆款猕猴桃【价格PK全网】', '29.9', 'http://img11.360buyimg.com/n7/jfs/t3217/140/4931702832/182465/156a9302/585cfbd5Ncc557db5.jpg', '潘苹果 甘肃天水红富士苹果 9粒 礼盒装 80mm 总重量约4斤 自营水果', '2017-06-06 03:09:21', '1', '34', '34', '1', '水果类');
INSERT INTO `t_product` VALUES ('14', '9', '3斤包邮无公害新鲜蔬菜黄秋葵 新鲜秋葵 新鲜黄秋葵蔬菜秋葵', '品质就是生命，我们不需要等待，新鲜采摘，品质保证。为确保新鲜，当天下单，次日采摘发货，一般下单后当天发货。果蔬码头与市面所售的黄秋葵的区别在于，我们是鲜采鲜发，保证新鲜，不打农药，使用农肥，不使用化学肥料，基地当天摘现发货无停留，确保新鲜！可以生吃', '39.9', 'https://gd4.alicdn.com/imgextra/i4/196493112/TB2nG1eXS0jpuFjy0FlXXc0bpXa_!!196493112.jpg_400x400.jpg_.webp', '暂无', '2017-06-06 03:09:23', '1', '10', '12', '1', '蔬菜类');
INSERT INTO `t_product` VALUES ('15', '9', '展卉 百香果西番莲 12个 单果50-80g 自营水果', '优选“酸甜可口、果肉多汁”,举世闻名的香料水果。【四川丑橘不知火】丑的有特点，内心很甘甜，京东生鲜产地直采，惊艳你的味蕾。(此商品不参加上述活动)', '21.9', 'http://img12.360buyimg.com/n7/jfs/t4249/299/1787013554/1398162/765fb60/58c74838N1e6366c5.jpg', '优选“酸甜可口、果肉多汁”,举世闻名的香料水果。【四川丑橘不知火】丑的有特点，内心很甘甜，京东生鲜产地直采，惊艳你的味蕾。(此商品不参加上述活动)', '2017-06-06 03:09:25', '1', '3', '2', '1', '水果类');
INSERT INTO `t_product` VALUES ('16', '9', '名家厨房 牛排10片装1520g 黑椒 菲力西冷 顺丰包邮 赠2刀叉油酱包', '名家厨房 牛排10片装1520g 黑椒 菲力西冷 顺丰包邮 赠2刀叉油酱包', '119', 'http://img11.360buyimg.com/n1/jfs/t2446/19/2787779510/257805/1bf07374/571888c6N83029e68.jpg', '名家厨房 牛排10片装1520g 黑椒 菲力西冷 顺丰包邮 赠2刀叉油酱包', '2017-06-06 03:09:28', '1', '3', '3', '1', '肉类');
INSERT INTO `t_product` VALUES ('17', '9', '名家厨房 牛排10片装1520g 黑椒 菲力西冷 顺丰包邮 赠2刀叉油酱包', '名家厨房 牛排10片装1520g 黑椒 菲力西冷 顺丰包邮 赠2刀叉油酱包', '119', 'http://img11.360buyimg.com/n1/jfs/t2446/19/2787779510/257805/1bf07374/571888c6N83029e68.jpg', '名家厨房 牛排10片装1520g 黑椒 菲力西冷 顺丰包邮 赠2刀叉油酱包', '2017-06-06 03:09:30', '1', '3', '3', '1', '肉类');
INSERT INTO `t_product` VALUES ('18', '9', '名家厨房 牛排10片装1520g 黑椒 菲力西冷 顺丰包邮 赠2刀叉油酱包', '名家厨房 牛排10片装1520g 黑椒 菲力西冷 顺丰包邮 赠2刀叉油酱包', '119', 'http://img11.360buyimg.com/n1/jfs/t2446/19/2787779510/257805/1bf07374/571888c6N83029e68.jpg', '名家厨房 牛排10片装1520g 黑椒 菲力西冷 顺丰包邮 赠2刀叉油酱包', '2017-06-06 03:09:32', '1', '3', '3', '1', '肉类');
INSERT INTO `t_product` VALUES ('19', '9', '名家厨房 牛排10片装1520g 黑椒 菲力西冷 顺丰包邮 赠2刀叉油酱包', '名家厨房 牛排10片装1520g 黑椒 菲力西冷 顺丰包邮 赠2刀叉油酱包', '119', 'http://img11.360buyimg.com/n1/jfs/t2446/19/2787779510/257805/1bf07374/571888c6N83029e68.jpg', '名家厨房 牛排10片装1520g 黑椒 菲力西冷 顺丰包邮 赠2刀叉油酱包', '2017-06-06 03:09:35', '1', '3', '3', '1', '肉类');
INSERT INTO `t_product` VALUES ('20', '9', '【冷鲜肉】高金食品 黑猪肉土猪腿肉300g 林间散养山黑猪', '【5件顺丰包邮】山林放养黑猪冷鲜肉 狠土狠香狠好吃 先领券再下单', '26.9', 'http://img12.360buyimg.com/n1/jfs/t3994/35/1239989791/204519/ff73a00c/58be2bc8Nbe26175f.jpg', '野猪肉', '2017-06-06 03:09:37', '1', '1', '1', '1', '肉类');
INSERT INTO `t_product` VALUES ('21', '9', '神丹 鸟王皮蛋松花蛋 20枚 1kg', '神丹 鸟王皮蛋松花蛋 20枚 1kg', '38.9', 'http://img10.360buyimg.com/n1/jfs/t3415/153/397083130/194095/699867c0/58098760N7773e25e.jpg', '神丹 鸟王皮蛋松花蛋 20枚 1kg', '2017-06-06 03:09:38', '1', '21', '22', '1', '熟食');
INSERT INTO `t_product` VALUES ('22', '9', '百年栗园 北京油鸡酱香鸡 750g/袋 整只装', '百年栗园 北京油鸡酱香鸡 750g/袋 整只装', '128.2', 'http://img14.360buyimg.com/n1/jfs/t3004/82/2292230438/377124/a7efcdb2/57d6001cN208162de.jpg', '百年栗园 北京油鸡酱香鸡 750g/袋 整只装', '2017-06-06 03:09:41', '1', '212', '12', '1', '熟食');
INSERT INTO `t_product` VALUES ('23', '9', '一字鲜无骨凤爪 醉香泡椒凤爪 鸡爪零食凤爪手工凉菜脱骨鸡爪250g', '手工去骨，当天现做', '19.8', 'http://img10.360buyimg.com/n1/jfs/t4129/68/63288360/345455/b15ec6a7/58aea0c9Nc304ffb6.jpg', '手工去骨，当天现做', '2017-06-06 03:09:45', '1', '22', '12', '1', '熟食');
INSERT INTO `t_product` VALUES ('24', '9', '一字鲜无骨凤爪 醉香泡椒凤爪 鸡爪零食凤爪手工凉菜脱骨鸡爪250g', '手工去骨，当天现做', '19.8', 'http://img10.360buyimg.com/n1/jfs/t4129/68/63288360/345455/b15ec6a7/58aea0c9Nc304ffb6.jpg', '手工去骨，当天现做', '2017-06-06 03:09:46', '1', '22', '12', '1', '熟食');
INSERT INTO `t_product` VALUES ('30', '9', '红功夫 麻辣小龙虾 十三香7-9钱16-20只1.5kg净虾量750g', '活虾烧制◆大个虾 腮白黄多◆多仓齐发 快速直达◆加热即食 赠品虾套装', '100', 'http://118.89.34.94/images/shopimages/2017/06/01/1496318374700417.jpg', '<a href=\"https://sale.jd.com/act/YF7h6q5tcmA2UI.html\" target=\"_blank\"><img alt=\"\" src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t4882/359/700447948/64039/14cab90a/58e6ee07N219320a0.jpg\" _src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t4882/359/700447948/64039/14cab90a/58e6ee07N219320a0.jpg\">', '2017-06-06 03:09:48', '1', '1', '0', '1', '熟食');
INSERT INTO `t_product` VALUES ('10005', '9', '皇纯 威海淡干海参 一级品 50g 8-10只 简装 海鲜水产', '【跨品牌2件8折】端午佳节送健康，送父母、送领导、送朋友、送爱人！高端大气有面子，实实在在养身体。让爱马上到身边！', '278', 'http://118.89.34.94/images/shopimages/2017/05/26/1495770354489468.jpg', '', '2017-06-06 03:09:49', '1', '1', '0', '1', '肉类');
INSERT INTO `t_product` VALUES ('10006', '9', '皇纯 威海淡干海参 一级品 50g 8-10只 简装 海鲜水产', '端午节给吃货宝宝们发福利啦，风味粽子买1赠1，还有麻辣小龙虾、双黄咸鸭蛋、当季新鲜水果，美味多多，优惠多多，快来抢购吧！一见粽情', '278', 'http://118.89.34.94/images/shopimages/2017/05/26/1495770990103311.jpg', '<a href=\"https://sale.jd.com/act/e8EFfOqRTB.html\" target=\"_blank\"><img alt=\"\" class=\"\" src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t5734/55/1270305609/60111/646f27e4/59254a48N21305900.jpg\" _src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t5734/55/1270305609/60111/646f27e4/59254a48N21305900.jpg\">\r\n<img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t4612/327/2354972083/116727/e5c614eb/58f06f6fN586c00cd.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t4612/327/2354972083/116727/e5c614eb/58f06f6fN586c00cd.jpg\">\r\n<img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    <img id=\"detail-tag-id-11\" alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    \r\n    <img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    <img id=\"detail-tag-id-12\" alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    \r\n    <img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    <img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    <img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    <img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    <img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    <img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    <img id=\"detail-tag-id-6\" alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    \r\n    <img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    <img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    <img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    \r\n    <img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    <img id=\"detail-tag-id-5\" alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    \r\n    <img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    <img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    <img id=\"detail-tag-id-2\" alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    \r\n    <img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    <img id=\"detail-tag-id-8\" alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">    \r\n    <img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">\r\n\r\n<img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">\r\n<img id=\"detail-tag-id-1\" alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">\r\n<img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">\r\n<img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">\r\n<img alt=\"\" class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">\r\n                                                                    生鲜-产品信息        \r\n                                                                    生鲜-产品特色        \r\n                                                                    生鲜-食用方法        \r\n                                                                    生鲜-特殊说明        \r\n                                                                    生鲜-运输包装        \r\n                                                                    生鲜-品牌介绍        \r\n                                                                    平台优势', '2017-06-06 03:09:52', '1', '100', '0', '1', '肉类');
INSERT INTO `t_product` VALUES ('10007', '9', '皇纯 威海淡干海参 一级品 50g 8-10只 简装 海鲜水产', '端午节给吃货宝宝们发福利啦，风味粽子买1赠1，还有麻辣小龙虾、双黄咸鸭蛋、当季新鲜水果，美味多多，优惠多多，快来抢购吧！一见粽情', '278', 'http://118.89.34.94/images/shopimages/2017/05/26/1495787581107985.jpg', '<img src=\"http://118.89.34.94/images/shopimages/2017/05/26/1495787556147838.jpg\" title=\"1495787556147838.jpg\" _src=\"http://118.89.34.94/images/shopimages/2017/05/26/1495787556147838.jpg\" alt=\"1495787556147838.jpg\" width=\"846\" height=\"334\">    					  <a href=\"https://sale.jd.com/act/e8EFfOqRTB.html\" target=\"_blank\"><img alt=\"\" class=\"\" src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t5734/55/1270305609/60111/646f27e4/59254a48N21305900.jpg\" _src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t5734/55/1270305609/60111/646f27e4/59254a48N21305900.jpg\"><img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t4612/327/2354972083/116727/e5c614eb/58f06f6fN586c00cd.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t4612/327/2354972083/116727/e5c614eb/58f06f6fN586c00cd.jpg\"><img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t3241/148/687565581/26675/53b87d1c/57bd6232N1c77b009.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t3241/148/687565581/26675/53b87d1c/57bd6232N1c77b009.jpg\">    <img id=\"detail-tag-id-11\" alt=\"\" class=\"\" src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3184/90/689186096/8015/f07ef321/57bd438eN09c5b77e.jpg\" _src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3184/90/689186096/8015/f07ef321/57bd438eN09c5b77e.jpg\">        <img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t3076/264/699172310/61205/102560c2/57bd63f1Nae634da3.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t3076/264/699172310/61205/102560c2/57bd63f1Nae634da3.jpg\">    <img id=\"detail-tag-id-12\" alt=\"\" class=\"\" src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3280/181/694726480/7521/f96d06b8/57bd4397Na11bd069.jpg\" _src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3280/181/694726480/7521/f96d06b8/57bd4397Na11bd069.jpg\">        <img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t3031/21/1088169602/95054/fa6c2b5b/57bd624bNb4ee98c3.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t3031/21/1088169602/95054/fa6c2b5b/57bd624bNb4ee98c3.jpg\">    <img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t3187/320/708104832/67703/5b5093d1/57bd6251N6ad23371.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t3187/320/708104832/67703/5b5093d1/57bd6251N6ad23371.jpg\">    <img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t3265/323/707928442/92470/14bb085d/57bd6257N78938702.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t3265/323/707928442/92470/14bb085d/57bd6257N78938702.jpg\">    <img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t3175/284/693381722/84910/4aa9bbbe/57bd6260N7840ed32.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t3175/284/693381722/84910/4aa9bbbe/57bd6260N7840ed32.jpg\">    <img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t3256/228/740052744/115070/645bef6e/57bd6267N2c027314.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t3256/228/740052744/115070/645bef6e/57bd6267N2c027314.jpg\">    <img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t2998/157/1122031580/75868/2b70f08/57bd626dNd63d55a0.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t2998/157/1122031580/75868/2b70f08/57bd626dNd63d55a0.jpg\">    <img id=\"detail-tag-id-6\" alt=\"\" class=\"\" src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3259/137/683657929/6633/b3c4419/57bd435fN3719de1a.jpg\" _src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3259/137/683657929/6633/b3c4419/57bd435fN3719de1a.jpg\">        <img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t3055/275/731273503/32674/e0ff2f38/57bd6274N8fc78329.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t3055/275/731273503/32674/e0ff2f38/57bd6274N8fc78329.jpg\">    <img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t3037/21/1140531408/86645/1f70cc6/57bd627aNa920c652.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t3037/21/1140531408/86645/1f70cc6/57bd627aNa920c652.jpg\">    <img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t3019/139/1095528057/88592/236c5cfb/57bd627fN7e9f3d34.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t3019/139/1095528057/88592/236c5cfb/57bd627fN7e9f3d34.jpg\">        <img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t3214/337/678659071/101629/a03050e8/57bd6288N5d2f6dc2.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t3214/337/678659071/101629/a03050e8/57bd6288N5d2f6dc2.jpg\">    <img id=\"detail-tag-id-5\" alt=\"\" class=\"\" src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3250/268/697004509/7845/719a4124/57bd4357N3683e126.jpg\" _src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3250/268/697004509/7845/719a4124/57bd4357N3683e126.jpg\">        <img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t3112/47/683947405/51929/dc54ca9c/57bd628eNd62313e0.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t3112/47/683947405/51929/dc54ca9c/57bd628eNd62313e0.jpg\">    <img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t3082/36/695864716/52437/1093973b/57bd6294N94f27f57.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t3082/36/695864716/52437/1093973b/57bd6294N94f27f57.jpg\">    <img id=\"detail-tag-id-2\" alt=\"\" class=\"\" src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3205/209/688590182/7723/df5fffbf/57bd432eNb20124f7.jpg\" _src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3205/209/688590182/7723/df5fffbf/57bd432eNb20124f7.jpg\">        <img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t3244/268/679932902/34382/647b3dde/57bd629eN52d95f85.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t3244/268/679932902/34382/647b3dde/57bd629eN52d95f85.jpg\">    <img id=\"detail-tag-id-8\" alt=\"\" class=\"\" src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3190/304/674993542/7809/54272362/57bd4370N99ad0401.jpg\" _src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3190/304/674993542/7809/54272362/57bd4370N99ad0401.jpg\">        <img alt=\"\" class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t2941/86/2501346009/88543/de5195fa/57bd62a9N675ec04e.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t2941/86/2501346009/88543/de5195fa/57bd62a9N675ec04e.jpg\"><img alt=\"\" class=\"\" src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3304/180/4882611153/50471/e54bcab3/58636f34N6a7151f2.jpg\" _src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3304/180/4882611153/50471/e54bcab3/58636f34N6a7151f2.jpg\"><img id=\"detail-tag-id-1\" alt=\"\" class=\"\" src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3532/53/1496957710/11901/bf64d020/58297b52Nc34a8aae.jpg\" _src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3532/53/1496957710/11901/bf64d020/58297b52Nc34a8aae.jpg\"><img alt=\"\" class=\"\" src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3697/65/2057866242/350671/994d8247/583d235dN0f9e6eb6.jpg\" _src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3697/65/2057866242/350671/994d8247/583d235dN0f9e6eb6.jpg\"><img alt=\"\" class=\"\" src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3637/247/2056924298/311211/d2265588/583d2363Nc6cfe1c7.jpg\" _src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t3637/247/2056924298/311211/d2265588/583d2363Nc6cfe1c7.jpg\"><img alt=\"\" class=\"\" src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t2683/51/1710476599/68324/5a06a508/574651a0N3f1077f5.jpg\" _src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t2683/51/1710476599/68324/5a06a508/574651a0N3f1077f5.jpg\">', '2017-06-06 03:09:53', '1', '100', '0', '1', '肉类');
INSERT INTO `t_product` VALUES ('10008', '9', '展卉 越南进口红心火龙果 3个装总重约1kg 新鲜水果', '富含天然花青素。漂洋过海的完美水果，清凉美味浑然天成。【越南红心火龙果】京东生鲜产地直采，清新柑香，美味爽口，惊艳你的味蕾，价格pk全网。', '27.9', 'http://118.89.34.94/images/shopimages/2017/06/05/1496671055267495.jpg', '<a href=\"https://sale.jd.com/act/e8EFfOqRTB.html\" target=\"_blank\"><img alt=\"\" class=\"\" src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t5668/78/2520069778/81786/7a8301df/5931324aNb0c1f2b5.jpg\" _src=\"//img30.360buyimg.com/jgsq-productsoa/jfs/t5668/78/2520069778/81786/7a8301df/5931324aNb0c1f2b5.jpg\">\r\n<img class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t4384/256/2388868233/89453/1e786e29/58d0c36fNfc726c31.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t4384/256/2388868233/89453/1e786e29/58d0c36fNfc726c31.jpg\">\r\n<img class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t4318/299/2383915837/124151/7cb35018/58d0c376Nc7b08dba.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t4318/299/2383915837/124151/7cb35018/58d0c376Nc7b08dba.jpg\">\r\n<img class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t4570/134/493577986/136936/6b2a05a6/58d0c379Ne264327f.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t4570/134/493577986/136936/6b2a05a6/58d0c379Ne264327f.jpg\">\r\n<img class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t4177/75/2414504201/32672/913314ea/58d0c37eN2989a9c9.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t4177/75/2414504201/32672/913314ea/58d0c37eN2989a9c9.jpg\">\r\n<img class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t4126/238/2345246170/130491/e61ab6cd/58d0c383N49fa2e7b.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t4126/238/2345246170/130491/e61ab6cd/58d0c383N49fa2e7b.jpg\">\r\n<img class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t4303/321/2402938549/121441/823efe0/58d0c387N8350ecad.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t4303/321/2402938549/121441/823efe0/58d0c387N8350ecad.jpg\">\r\n<img class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t4471/269/504384754/131944/38fa0b7e/58d0c3afN1ae737a8.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t4471/269/504384754/131944/38fa0b7e/58d0c3afN1ae737a8.jpg\">\r\n<img class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t4150/19/2392168580/132509/5299cd29/58d0c3b4N1caecdc0.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t4150/19/2392168580/132509/5299cd29/58d0c3b4N1caecdc0.jpg\">\r\n<img class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t4375/68/2422019378/166244/b2b33a3b/58d0c3b4N3c3c8ac7.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t4375/68/2422019378/166244/b2b33a3b/58d0c3b4N3c3c8ac7.jpg\">\r\n<img class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t3160/334/9253631727/131957/108b0f6c/58d0c3bcN02bc4ef9.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t3160/334/9253631727/131957/108b0f6c/58d0c3bcN02bc4ef9.jpg\">\r\n<img class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t3097/357/9283293339/94276/d60c9f85/58d0c3c5Nd0f4b546.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t3097/357/9283293339/94276/d60c9f85/58d0c3c5Nd0f4b546.jpg\">\r\n<img class=\"\" src=\"//img20.360buyimg.com/vc/jfs/t4639/315/506793899/87887/a18dfa3/58d0c3caN66a20d5d.jpg\" _src=\"//img20.360buyimg.com/vc/jfs/t4639/315/506793899/87887/a18dfa3/58d0c3caN66a20d5d.jpg\">\r\n<img class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">\r\n<img class=\"ELazy-loading\" src=\"//misc.360buyimg.com/lib/img/e/blank.gif\" _src=\"//misc.360buyimg.com/lib/img/e/blank.gif\">', '2017-06-06 03:09:57', '1', '100', '0', '1', '水果类');
INSERT INTO `t_product` VALUES ('10009', '9', '农家非转基因新鲜花糯玉米6根/ 水果玉米玉米棒子粘玉米 甜玉米', '真空包装，高温杀菌，新鲜蔬菜', '28', 'http://118.89.34.94/images/shopimages/2017/06/08/1496856103241089.jpg', '<a href=\"https://sale.jd.com/act/6du1SIg4QnT.html\" target=\"_blank\" title=\"618\"><img src=\"//img30.360buyimg.com/popWaterMark/jfs/t5671/246/3209732831/358704/14132e23/5937779aN508b2adb.jpg\" alt=\"海报专场期.jpg\" _src=\"//img30.360buyimg.com/popWaterMark/jfs/t5671/246/3209732831/358704/14132e23/5937779aN508b2adb.jpg\">\r\n<img src=\"//img10.360buyimg.com/imgzone/jfs/t5947/126/1954047898/729171/bf4fa7e9/593772b6N3f5f1b89.jpg\" _src=\"//img10.360buyimg.com/imgzone/jfs/t5947/126/1954047898/729171/bf4fa7e9/593772b6N3f5f1b89.jpg\"><img src=\"//img10.360buyimg.com/imgzone/jfs/t5953/261/1679145158/170092/57f7e234/5934c2aeN16171125.jpg\" _src=\"//img10.360buyimg.com/imgzone/jfs/t5953/261/1679145158/170092/57f7e234/5934c2aeN16171125.jpg\">', '2017-06-08 01:21:44', '1', '100', '0', '1', '蔬菜类');
INSERT INTO `t_product` VALUES ('10010', '9', '【秦安馆】红薯 新鲜蜜薯板栗薯爆皮王六鳌地瓜山芋番薯芋头紫薯农产品 5斤装 一份', '新鲜蜜薯，板栗薯，口感香甜，美味可口，健康食品', '39.9', 'http://118.89.34.94/images/shopimages/2017/06/08/1496856353674174.jpg', '<img alt=\"\" id=\"c216d12393964136a4a287d50e113c0d\" class=\"\" src=\"//img30.360buyimg.com/popWareDetail/jfs/t4174/263/2565341765/507848/5e44f816/58d33af3N81b7ead4.jpg\" _src=\"//img30.360buyimg.com/popWareDetail/jfs/t4174/263/2565341765/507848/5e44f816/58d33af3N81b7ead4.jpg\">\r\n<img alt=\"\" id=\"21f1c244c6f14f87b8030a2dd681ce33\" class=\"\" src=\"//img30.360buyimg.com/popWareDetail/jfs/t3058/269/9531429513/539943/e0b22fe/58d33af1N0c842144.jpg\" _src=\"//img30.360buyimg.com/popWareDetail/jfs/t3058/269/9531429513/539943/e0b22fe/58d33af1N0c842144.jpg\">\r\n<img alt=\"\" id=\"67dba30bffcf43709153f789c53c8d14\" class=\"\" src=\"//img30.360buyimg.com/popWareDetail/jfs/t4603/290/653093400/585111/9492172c/58d33af1N4abea55b.jpg\" _src=\"//img30.360buyimg.com/popWareDetail/jfs/t4603/290/653093400/585111/9492172c/58d33af1N4abea55b.jpg\">\r\n<img alt=\"\" id=\"f950ce83e40d4feda86467a7c2a28d76\" class=\"\" src=\"//img30.360buyimg.com/popWareDetail/jfs/t4399/273/659027574/796575/f7be32c2/58d33af5N46ec0eb8.jpg\" _src=\"//img30.360buyimg.com/popWareDetail/jfs/t4399/273/659027574/796575/f7be32c2/58d33af5N46ec0eb8.jpg\">\r\n<img alt=\"\" id=\"170e77938c8744ab96bcfcad68ec2a99\" class=\"\" src=\"//img30.360buyimg.com/popWareDetail/jfs/t4270/294/2508450485/1104944/a5104aff/58d33afbN9e0b956e.jpg\" _src=\"//img30.360buyimg.com/popWareDetail/jfs/t4270/294/2508450485/1104944/a5104aff/58d33afbN9e0b956e.jpg\">\r\n<img alt=\"\" id=\"97cd05a063734f8e9a19b7ebddd1f6c2\" class=\"\" src=\"//img30.360buyimg.com/popWareDetail/jfs/t4192/343/2610204756/1051330/317c3c7f/58d33af7N01cb875a.jpg\" _src=\"//img30.360buyimg.com/popWareDetail/jfs/t4192/343/2610204756/1051330/317c3c7f/58d33af7N01cb875a.jpg\">\r\n<img alt=\"\" id=\"fd423ffa8b304f418ef8ed1a45236c14\" class=\"\" src=\"//img30.360buyimg.com/popWareDetail/jfs/t4132/212/2571407937/713093/4f146924/58d33af9Nbd946869.jpg\" _src=\"//img30.360buyimg.com/popWareDetail/jfs/t4132/212/2571407937/713093/4f146924/58d33af9Nbd946869.jpg\">', '2017-06-08 01:25:54', '1', '100', '0', '1', '蔬菜类');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL,
  `roleName` varchar(64) NOT NULL,
  `available` int(11) NOT NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表 ';

-- ----------------------------
-- Records of t_role
-- ----------------------------

-- ----------------------------
-- Table structure for t_rolepermission
-- ----------------------------
DROP TABLE IF EXISTS `t_rolepermission`;
CREATE TABLE `t_rolepermission` (
  `id` int(11) NOT NULL,
  `roleId` int(11) NOT NULL COMMENT '角色id',
  `permissId` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of t_rolepermission
-- ----------------------------

-- ----------------------------
-- Table structure for t_searchrecord
-- ----------------------------
DROP TABLE IF EXISTS `t_searchrecord`;
CREATE TABLE `t_searchrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `searchword` varchar(255) NOT NULL,
  `searchtime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `usertype` int(2) DEFAULT NULL COMMENT '搜索商品的用户类型: 1登录用户 2游客',
  `userip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_searchrecord
-- ----------------------------
INSERT INTO `t_searchrecord` VALUES ('50', '0', '游客', '', '2017-06-06 10:13:45', '2', '0:0:0:0:0:0:0:1');
INSERT INTO `t_searchrecord` VALUES ('51', '19', 'admin', '', '2017-06-06 11:07:41', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_searchrecord` VALUES ('52', '20', 'Joe', '', '2017-06-06 13:54:50', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_searchrecord` VALUES ('53', '20', 'Joe', '小龙虾', '2017-06-06 13:54:36', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_searchrecord` VALUES ('54', '20', 'Joe', '', '2017-06-06 14:05:24', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_searchrecord` VALUES ('55', '20', 'Joe', '', '2017-06-06 14:07:29', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_searchrecord` VALUES ('56', '20', 'Joe', '', '2017-06-06 14:12:42', '1', '0:0:0:0:0:0:0:1');
INSERT INTO `t_searchrecord` VALUES ('57', '0', '游客', '', '2017-06-08 01:38:43', '2', '106.91.181.34');
INSERT INTO `t_searchrecord` VALUES ('58', '0', '游客', '', '2017-06-08 01:47:08', '2', '0:0:0:0:0:0:0:1');

-- ----------------------------
-- Table structure for t_season
-- ----------------------------
DROP TABLE IF EXISTS `t_season`;
CREATE TABLE `t_season` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timeName` varchar(50) NOT NULL COMMENT '时令名称',
  `startDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
  `endDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='时令';

-- ----------------------------
-- Records of t_season
-- ----------------------------

-- ----------------------------
-- Table structure for t_seasoninfor
-- ----------------------------
DROP TABLE IF EXISTS `t_seasoninfor`;
CREATE TABLE `t_seasoninfor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `season` varchar(20) NOT NULL COMMENT '所属季节',
  `inforText` varchar(5000) NOT NULL COMMENT '资讯内容',
  `updatedTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='季节资讯';

-- ----------------------------
-- Records of t_seasoninfor
-- ----------------------------

-- ----------------------------
-- Table structure for t_sportplan
-- ----------------------------
DROP TABLE IF EXISTS `t_sportplan`;
CREATE TABLE `t_sportplan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL COMMENT '用户id',
  `nutritionistid` int(11) NOT NULL COMMENT '营养师id',
  `sportid` int(11) NOT NULL COMMENT '运动项目id',
  `sportname` varchar(255) NOT NULL COMMENT '运动项目名称',
  `sportdescribe` varchar(500) NOT NULL COMMENT '运动项目的具体描述',
  `plandate` date NOT NULL COMMENT '运动计划日期',
  `planid` int(11) NOT NULL COMMENT '运动计划周期id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sportplan
-- ----------------------------
INSERT INTO `t_sportplan` VALUES ('1', '20', '19', '1', '跑步', '1000米', '2017-06-06', '13');
INSERT INTO `t_sportplan` VALUES ('2', '20', '19', '1', '跑步', '跑步一小时（尽量快跑，可休息，可以分组做）', '2017-06-07', '20');
INSERT INTO `t_sportplan` VALUES ('3', '20', '19', '3', '哑铃卧推', '哑铃卧推 2× 16-20', '2017-06-07', '20');
INSERT INTO `t_sportplan` VALUES ('4', '20', '19', '4', '腹肌锻炼', '仰卧起坐 250个左右', '2017-06-08', '22');
INSERT INTO `t_sportplan` VALUES ('5', '20', '19', '1', '跑步', '跑步一小时（尽量快跑，可休息，可以分组做）hfshds', '2017-06-08', '24');

-- ----------------------------
-- Table structure for t_sportplanbyself
-- ----------------------------
DROP TABLE IF EXISTS `t_sportplanbyself`;
CREATE TABLE `t_sportplanbyself` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL COMMENT '用户id',
  `sportid` int(11) NOT NULL COMMENT '运动项目id',
  `sportname` varchar(255) NOT NULL COMMENT '运动项目名称',
  `sportdescribe` varchar(500) NOT NULL COMMENT '运动项目的具体描述',
  `plandate` date NOT NULL COMMENT '运动计划日期',
  `planid` int(11) NOT NULL COMMENT '运动计划周期id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sportplanbyself
-- ----------------------------
INSERT INTO `t_sportplanbyself` VALUES ('23', '20', '2', '游泳', '10000米 不能停！', '2017-06-06', '9');
INSERT INTO `t_sportplanbyself` VALUES ('24', '20', '1', '跑步', '1000米  要快！', '2017-06-06', '9');
INSERT INTO `t_sportplanbyself` VALUES ('25', '20', '2', '跳绳', '跳绳45分钟（分组做）', '2017-06-06', '10');
INSERT INTO `t_sportplanbyself` VALUES ('26', '20', '2', '跳绳', '跳绳45分钟（分组做）', '2017-06-07', '10');
INSERT INTO `t_sportplanbyself` VALUES ('27', '20', '2', '跳绳', '跳绳45分钟（分组做）', '2017-06-08', '10');
INSERT INTO `t_sportplanbyself` VALUES ('28', '20', '2', '跳绳', '跳绳45分钟（分组做）', '2017-06-09', '10');
INSERT INTO `t_sportplanbyself` VALUES ('29', '20', '2', '跳绳', '跳绳45分钟（分组做）', '2017-06-10', '10');
INSERT INTO `t_sportplanbyself` VALUES ('30', '20', '2', '跳绳', '跳绳45分钟（分组做）', '2017-06-11', '10');
INSERT INTO `t_sportplanbyself` VALUES ('31', '20', '2', '跳绳', '跳绳45分钟（分组做）', '2017-06-12', '10');
INSERT INTO `t_sportplanbyself` VALUES ('32', '21', '2', '跳绳', '跳绳45分钟（分组做）', '2017-06-06', '12');
INSERT INTO `t_sportplanbyself` VALUES ('33', '21', '1', '跑步', '跑步一小时（尽量快跑，可休息，可以分组做）', '2017-06-06', '12');
INSERT INTO `t_sportplanbyself` VALUES ('34', '21', '3', '哑铃卧推', '哑铃卧推 2× 16-20', '2017-06-07', '12');
INSERT INTO `t_sportplanbyself` VALUES ('35', '21', '1', '跑步', '跑步一小时（尽量快跑，可休息，可以分组做）', '2017-06-07', '12');

-- ----------------------------
-- Table structure for t_sportsoption
-- ----------------------------
DROP TABLE IF EXISTS `t_sportsoption`;
CREATE TABLE `t_sportsoption` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sportname` varchar(200) NOT NULL COMMENT '运动项目名称',
  `energy` double DEFAULT NULL COMMENT '消耗能量',
  `sportdescribe` varchar(500) NOT NULL COMMENT '运动项目的具体内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='运动项目';

-- ----------------------------
-- Records of t_sportsoption
-- ----------------------------
INSERT INTO `t_sportsoption` VALUES ('1', '跑步', null, '跑步一小时（尽量快跑，可休息，可以分组做）');
INSERT INTO `t_sportsoption` VALUES ('2', '跳绳', null, '跳绳45分钟（分组做）');
INSERT INTO `t_sportsoption` VALUES ('3', '哑铃卧推', null, '哑铃卧推 2× 16-20');
INSERT INTO `t_sportsoption` VALUES ('4', '腹肌锻炼', null, '仰卧起坐 250个左右 ');

-- ----------------------------
-- Table structure for t_storeapplication
-- ----------------------------
DROP TABLE IF EXISTS `t_storeapplication`;
CREATE TABLE `t_storeapplication` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户id',
  `ownname` varchar(255) NOT NULL COMMENT '店主名字',
  `phone` varchar(15) NOT NULL,
  `uId` varchar(20) NOT NULL COMMENT '身份id',
  `uidimageurl` varchar(255) DEFAULT '' COMMENT '身份证图片地址',
  `storeName` varchar(50) NOT NULL COMMENT '商家名称',
  `storeAddr` varchar(400) NOT NULL COMMENT '商家地址 省市区',
  `detailaddr` varchar(255) NOT NULL COMMENT '商家地址 详细地址',
  `storeLicenseid` varchar(200) DEFAULT NULL COMMENT '营业执照id',
  `licenseimageurl` varchar(255) DEFAULT '' COMMENT '营业执照图片地址',
  `storeType` int(2) NOT NULL COMMENT '商家类型',
  `sqDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请日期',
  `sqStatus` int(2) NOT NULL COMMENT '申请状态 0：未成功，1：申请成功 ，2：待审核',
  `storelogoimg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='商家申请表';

-- ----------------------------
-- Records of t_storeapplication
-- ----------------------------
INSERT INTO `t_storeapplication` VALUES ('10', '20', 'wande', '13509000000', '500228000000000000', 'http://118.89.34.94/images/userinfoimages/2017/06/06/1496688890416459.jpg', '大爷店铺', '重庆市/重庆市/渝中区', '重庆市沙坪坝大学城', '000098976', 'http://118.89.34.94/images/userinfoimages/2017/06/06/1496688891171796.jpg', '6', '2017-06-06 02:54:52', '1', 'http://118.89.34.94/images/userinfoimages/2017/06/06/1496688891764513.jpg');
INSERT INTO `t_storeapplication` VALUES ('11', '21', 'lhb', '13509000000', '500228000000000000', 'http://118.89.34.94/images/userinfoimages/2017/06/06/1496688890416459.jpg', '大爷店铺', '重庆市/重庆市/渝中区', '重庆市沙坪坝大学城', '000098976', 'http://118.89.34.94/images/userinfoimages/2017/06/06/1496688891171796.jpg', '6', '2017-06-06 02:54:52', '2', 'http://118.89.34.94/images/userinfoimages/2017/06/06/1496688891764513.jpg');

-- ----------------------------
-- Table structure for t_storecomment
-- ----------------------------
DROP TABLE IF EXISTS `t_storecomment`;
CREATE TABLE `t_storecomment` (
  `id` int(11) NOT NULL,
  `commentText` varchar(200) DEFAULT NULL COMMENT '评论内容',
  `commentLevel` int(11) DEFAULT NULL COMMENT '评论星级 1-5星',
  `commentTime` datetime DEFAULT NULL,
  `userId` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户对商家的评论';

-- ----------------------------
-- Records of t_storecomment
-- ----------------------------

-- ----------------------------
-- Table structure for t_storeinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_storeinfo`;
CREATE TABLE `t_storeinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `storelogoimg` varchar(255) DEFAULT NULL,
  `storeName` varchar(200) NOT NULL COMMENT '商家名称',
  `sName` varchar(50) NOT NULL COMMENT '店主姓名',
  `sPhone` varchar(20) NOT NULL COMMENT '电话',
  `sID` varchar(20) NOT NULL COMMENT '身份证',
  `sLicense` varchar(50) DEFAULT NULL COMMENT '营业执照',
  `sdz` varchar(255) DEFAULT NULL COMMENT '商家坐标 省市区',
  `sAddr` varchar(200) NOT NULL COMMENT '商家地址',
  `is_check` int(11) NOT NULL COMMENT ' 是否审核 1：已审核、0：未审核',
  `sType` varchar(50) NOT NULL COMMENT '商家类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='商家信息';

-- ----------------------------
-- Records of t_storeinfo
-- ----------------------------
INSERT INTO `t_storeinfo` VALUES ('9', '20', 'http://118.89.34.94/images/userinfoimages/2017/06/06/1496688891764513.jpg', '健康购', 'wande', '13509000000', '500228000000000000', '000098976', '重庆市/重庆市/渝中区', '重庆市沙坪坝大学城', '1', '综合');
INSERT INTO `t_storeinfo` VALUES ('10', '22', 'http://118.89.34.94/images/userinfoimages/2017/06/06/s1.jpg\r\n', '健康购分店', 'wande', '13509000000', '500228000000000000', '000098976', '重庆市/重庆市/渝中区', '重庆市沙坪坝大学城', '1', '蔬菜类');
INSERT INTO `t_storeinfo` VALUES ('11', '23', 'http://118.89.34.94/images/userinfoimages/2017/06/06/s2.jpg\r\n', '健康购分店', 'wande', '13509000000', '500228000000000000', '000098976', '重庆市/重庆市/沙坪坝区', '重庆市沙坪坝大学城', '1', '蔬菜类');
INSERT INTO `t_storeinfo` VALUES ('12', '24', 'http://118.89.34.94/images/userinfoimages/2017/06/06/s3.jpg\r\n', '健康购分店', 'wande', '13509000000', '500228000000000000', '000098976', '重庆市/重庆市/渝中区', '重庆市沙坪坝大学城', '1', '蔬菜类');
INSERT INTO `t_storeinfo` VALUES ('13', '25', 'http://118.89.34.94/images/userinfoimages/2017/06/06/s4.jpg\r\n', '健康购分店', 'wande', '13509000000', '500228000000000000', '000098976', '重庆市/重庆市/沙坪坝区', '重庆市沙坪坝大学城', '1', '蔬菜类');
INSERT INTO `t_storeinfo` VALUES ('14', '26', 'http://118.89.34.94/images/userinfoimages/2017/06/06/s5.jpg\r\n', '健康购分店', 'wande', '13509000000', '500228000000000000', '000098976', '重庆市/重庆市/渝中区', '重庆市沙坪坝大学城', '1', '蔬菜类');
INSERT INTO `t_storeinfo` VALUES ('15', '27', 'http://118.89.34.94/images/userinfoimages/2017/06/06/s6.jpg\r\n', '健康购分店', 'wande', '13509000000', '500228000000000000', '000098976', '重庆市/重庆市/沙坪坝区', '重庆市沙坪坝大学城', '1', '蔬菜类');

-- ----------------------------
-- Table structure for t_storetuisong
-- ----------------------------
DROP TABLE IF EXISTS `t_storetuisong`;
CREATE TABLE `t_storetuisong` (
  `id` int(11) NOT NULL,
  `storeId` int(11) NOT NULL COMMENT '商家id',
  `storeName` varchar(50) NOT NULL COMMENT '商家名称',
  `tsTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '推送时间',
  `tsText` varchar(2000) NOT NULL COMMENT '推送内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家推送';

-- ----------------------------
-- Records of t_storetuisong
-- ----------------------------

-- ----------------------------
-- Table structure for t_storetype
-- ----------------------------
DROP TABLE IF EXISTS `t_storetype`;
CREATE TABLE `t_storetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `storeType` varchar(50) NOT NULL COMMENT '商家类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='商家类型：';

-- ----------------------------
-- Records of t_storetype
-- ----------------------------
INSERT INTO `t_storetype` VALUES ('1', '蔬菜类');
INSERT INTO `t_storetype` VALUES ('2', '水果类');
INSERT INTO `t_storetype` VALUES ('3', '肉类');
INSERT INTO `t_storetype` VALUES ('4', '熟食类');
INSERT INTO `t_storetype` VALUES ('5', '谷物');
INSERT INTO `t_storetype` VALUES ('6', '综合');

-- ----------------------------
-- Table structure for t_uncomment
-- ----------------------------
DROP TABLE IF EXISTS `t_uncomment`;
CREATE TABLE `t_uncomment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nid` int(11) NOT NULL COMMENT '营养师id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `commentcontent` text NOT NULL COMMENT '留言的内容',
  `replycontent` text COMMENT '回复的内容',
  `commenttime` datetime NOT NULL COMMENT '留言的时间',
  `replytime` datetime DEFAULT NULL COMMENT '回复时间',
  `isreply` int(11) NOT NULL DEFAULT '0' COMMENT '是否回复留言 0：未回复；1：已回复',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_uncomment
-- ----------------------------
INSERT INTO `t_uncomment` VALUES ('16', '19', '20', '<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/0b/wabi_thumb.gif\" height=\"22\" width=\"22\" /><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/cc/haqianv2_thumb.gif\" height=\"22\" width=\"22\" />fafafafa', 'qrqwtwyyyeeyetyey<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/20/huanglianse_thumb.gif\" height=\"22\" width=\"22\" /><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/5c/yw_thumb.gif\" height=\"22\" width=\"22\" /><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/a6/x_thumb.gif\" height=\"22\" width=\"22\" /><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/3a/moren_xiaoerbuyu_thumb.png\" height=\"22\" width=\"22\" /><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/49/hatea_thumb.gif\" height=\"22\" width=\"22\" /><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/0c/sw_thumb.gif\" height=\"22\" width=\"22\" /><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6e/shamea_thumb.gif\" height=\"22\" width=\"22\" />', '2017-06-08 09:59:25', '2017-06-08 10:00:24', '1');
INSERT INTO `t_uncomment` VALUES ('17', '19', '20', 'hakafknakf<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/3a/moren_xiaoerbuyu_thumb.png\" height=\"22\" width=\"22\" /><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/37/moren_chongjing_thumb.png\" height=\"22\" width=\"22\" /><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/9d/sada_thumb.gif\" height=\"22\" width=\"22\" />', 'dhgdhdh<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/71/bs2_thumb.gif\" height=\"22\" width=\"22\" /><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/5c/yw_thumb.gif\" height=\"22\" width=\"22\" /><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6d/lovea_thumb.gif\" height=\"22\" width=\"22\" />', '2017-06-08 14:08:09', '2017-06-08 14:08:48', '1');

-- ----------------------------
-- Table structure for t_userdietplan
-- ----------------------------
DROP TABLE IF EXISTS `t_userdietplan`;
CREATE TABLE `t_userdietplan` (
  `id` int(11) NOT NULL COMMENT 'id',
  `userId` int(11) NOT NULL COMMENT '用户id',
  `dietitionId` int(11) DEFAULT NULL COMMENT '营养师id  如果为营养师制定的计划 营养师id必须存在',
  `dietDay` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '日期',
  `breakfast` varbinary(64) NOT NULL COMMENT '早餐饮食',
  `lunch` varbinary(64) NOT NULL COMMENT '午餐饮食',
  `dinner` varbinary(64) NOT NULL COMMENT '晚餐饮食',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员饮食计划';

-- ----------------------------
-- Records of t_userdietplan
-- ----------------------------

-- ----------------------------
-- Table structure for t_userhealthinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_userhealthinfo`;
CREATE TABLE `t_userhealthinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `height` double NOT NULL COMMENT '身高',
  `weight` double NOT NULL COMMENT '体重',
  `sex` int(11) NOT NULL COMMENT '性别 1:男 、2：女',
  `birthday` date NOT NULL COMMENT '出生日期',
  `dietPrefe` varchar(200) NOT NULL COMMENT '饮食偏好',
  `notLikeFoods` varchar(200) NOT NULL COMMENT '不喜欢食物',
  `healStatus` varchar(20) NOT NULL COMMENT '健康状况',
  `medHis` varchar(200) NOT NULL COMMENT '病史',
  `SenFoods` varchar(200) NOT NULL COMMENT '过敏食物',
  PRIMARY KEY (`id`,`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userhealthinfo
-- ----------------------------
INSERT INTO `t_userhealthinfo` VALUES ('3', '20', 'Joe', '180', '60', '1', '2017-06-06', '辣', '阿法', '健康', '无', '无');
INSERT INTO `t_userhealthinfo` VALUES ('4', '21', '李海滨', '185', '60', '1', '1995-02-08', '酸辣', '芹菜', '健康', '无', '无');

-- ----------------------------
-- Table structure for t_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_userinfo`;
CREATE TABLE `t_userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `image` varchar(255) DEFAULT NULL COMMENT '头像',
  `sex` int(11) DEFAULT NULL,
  `userName` varchar(32) NOT NULL COMMENT '用户名',
  `passWord` varchar(255) DEFAULT NULL COMMENT '密码',
  `name` varchar(255) NOT NULL COMMENT '会员姓名',
  `phone` varchar(255) NOT NULL COMMENT '电话',
  `email` varchar(255) NOT NULL COMMENT '邮箱',
  `createdTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatedTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `state` int(11) NOT NULL COMMENT '激活状态  1:已激活  ，2：未激活',
  `stateCode` varchar(255) NOT NULL COMMENT '激活码',
  `dietitianId` int(11) DEFAULT NULL COMMENT '选择营养师id',
  `is_vip` int(11) NOT NULL DEFAULT '0' COMMENT '是否高级会员0:不是、1：高级会员',
  `isstore` int(1) NOT NULL DEFAULT '0' COMMENT '是否是店家身份  不是 1是',
  `isdiet` int(1) NOT NULL DEFAULT '0' COMMENT '是否是营养师 0 不是 1是',
  `isadmin` int(1) NOT NULL DEFAULT '0' COMMENT '是否是管理员 0 不是 1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='会员信息';

-- ----------------------------
-- Records of t_userinfo
-- ----------------------------
INSERT INTO `t_userinfo` VALUES ('19', 'http://118.89.34.94/images/headimages/2017/06/07/1496850020837979.jpg', '1', 'admin', 'c4ca4238a0b923820dcc509a6f75849b', 'admin', '18883987810', '2360654222@qq.com', '2017-06-06 01:05:40', '2017-06-06 11:19:56', '1', '', '0', '1', '1', '1', '1');
INSERT INTO `t_userinfo` VALUES ('20', 'http://118.89.34.94/images/headimages/2017/06/06/1496682414428603.jpg', '1', 'Joe', 'c4ca4238a0b923820dcc509a6f75849b', 'Joe', '13509000000', 'admin@qq.com', '2017-06-06 01:05:40', '2017-06-06 02:56:26', '1', '', '19', '1', '1', '1', '0');
INSERT INTO `t_userinfo` VALUES ('21', 'http://118.89.34.94/images/headimages/2017/06/06/1496723547586401.jpg', '1', '李海滨', 'c4ca4238a0b923820dcc509a6f75849b', 'lhb', '188846464646', '2360654@acadf', '2017-06-06 11:59:54', '2017-06-06 12:02:18', '1', '', '0', '0', '0', '0', '0');
INSERT INTO `t_userinfo` VALUES ('22', 'http://118.89.34.94/images/headimages/2017/06/06/1496682414428603.jpg', '1', 'wan', 'c4ca4238a0b923820dcc509a6f75849b', '张三', '13509000000', 'wan@qq.com', '2017-06-06 01:05:40', '2017-06-06 02:56:26', '1', '', '19', '1', '1', '1', '0');
INSERT INTO `t_userinfo` VALUES ('23', 'http://118.89.34.94/images/headimages/2017/06/06/1496682414428603.jpg', '1', 'wande', 'c4ca4238a0b923820dcc509a6f75849b', '李四', '13509000000', 'wande@qq.com', '2017-06-06 01:05:40', '2017-06-06 02:56:26', '1', '', '19', '1', '1', '1', '0');
INSERT INTO `t_userinfo` VALUES ('24', 'http://118.89.34.94/images/headimages/2017/06/06/1496682414428603.jpg', '1', 'zs', 'c4ca4238a0b923820dcc509a6f75849b', '大爷', '13509000000', 'zs@qq.com', '2017-06-06 01:05:40', '2017-06-06 02:56:26', '1', '', '19', '1', '1', '1', '0');
INSERT INTO `t_userinfo` VALUES ('25', 'http://118.89.34.94/images/headimages/2017/06/06/1496682414428603.jpg', '1', 'ls', 'c4ca4238a0b923820dcc509a6f75849b', '二大爷', '13509000000', 'ls@qq.com', '2017-06-06 01:05:40', '2017-06-06 02:56:26', '1', '', '19', '1', '1', '1', '0');
INSERT INTO `t_userinfo` VALUES ('26', 'http://118.89.34.94/images/headimages/2017/06/06/1496682414428603.jpg', '1', 'ww', 'c4ca4238a0b923820dcc509a6f75849b', '三大爷', '13509000000', 'ww@qq.com', '2017-06-06 01:05:40', '2017-06-06 02:56:26', '1', '', '19', '1', '1', '1', '0');
INSERT INTO `t_userinfo` VALUES ('27', 'http://118.89.34.94/images/headimages/2017/06/06/1496682414428603.jpg', '1', 'zl', 'c4ca4238a0b923820dcc509a6f75849b', '小弟', '13509000000', 'zl@qq.com', '2017-06-06 01:05:40', '2017-06-06 02:56:26', '1', '', '19', '1', '1', '1', '0');

-- ----------------------------
-- Table structure for t_userlog
-- ----------------------------
DROP TABLE IF EXISTS `t_userlog`;
CREATE TABLE `t_userlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'z主键',
  `uid` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `loginDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '登录时间',
  `loginIP` varchar(15) NOT NULL COMMENT '登录ip',
  `loginstatus` int(1) DEFAULT NULL COMMENT '登录成功 1 登录失败 2',
  `loginps` varchar(255) DEFAULT NULL COMMENT '登录备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=783 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userlog
-- ----------------------------
INSERT INTO `t_userlog` VALUES ('707', '19', 'admin', '2017-06-06 01:05:48', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('708', '19', 'admin', '2017-06-06 01:07:40', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('709', '19', 'admin', '2017-06-06 01:09:34', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('710', '20', 'Joe', '2017-06-06 01:09:53', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('711', '19', 'admin', '2017-06-06 01:12:02', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('712', '19', 'admin', '2017-06-06 01:15:25', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('713', '20', 'Joe', '2017-06-06 01:16:32', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('714', '19', 'admin', '2017-06-06 01:18:56', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('715', '20', 'Joe', '2017-06-06 01:19:13', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('716', '19', 'admin', '2017-06-06 01:20:04', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('717', '19', 'admin', '2017-06-06 01:26:48', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('718', '20', 'Joe', '2017-06-06 01:27:04', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('719', '20', 'Joe', '2017-06-06 01:39:00', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('720', '19', 'admin', '2017-06-06 01:56:58', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('721', '20', 'Joe', '2017-06-06 01:57:13', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('722', '19', 'admin', '2017-06-06 02:25:17', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('723', '19', 'admin', '2017-06-06 02:48:55', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('724', '20', 'Joe', '2017-06-06 02:53:41', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('725', '19', 'admin', '2017-06-06 02:55:51', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('726', '20', 'Joe', '2017-06-06 02:56:50', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('727', '20', 'Joe', '2017-06-06 10:14:36', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('728', '19', 'admin', '2017-06-06 10:16:12', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('729', '20', 'Joe', '2017-06-06 11:12:55', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('730', '19', 'admin', '2017-06-06 11:19:18', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('731', '19', 'admin', '2017-06-06 11:19:25', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('732', '19', 'admin', '2017-06-06 11:20:05', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('733', '19', 'admin', '2017-06-06 11:20:26', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('734', '19', 'admin', '2017-06-06 11:22:08', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('735', '19', 'admin', '2017-06-06 11:23:51', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('736', '19', 'admin', '2017-06-06 11:27:14', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('737', '20', 'Joe', '2017-06-06 11:30:05', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('738', '21', '李海滨', '2017-06-06 12:00:05', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('739', '19', 'admin', '2017-06-06 12:01:32', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('740', '21', '李海滨', '2017-06-06 12:02:48', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('741', '21', '李海滨', '2017-06-06 12:06:31', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('742', '19', 'admin', '2017-06-06 12:15:50', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('743', '21', '李海滨', '2017-06-06 12:30:55', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('744', '21', '李海滨', '2017-06-06 12:31:06', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('745', '21', '李海滨', '2017-06-06 12:45:29', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('746', '21', '李海滨', '2017-06-06 12:47:53', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('747', '19', 'admin', '2017-06-06 13:15:56', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('748', '19', 'admin', '2017-06-06 13:16:01', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('749', '20', 'Joe', '2017-06-06 13:52:56', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('750', '20', 'Joe', '2017-06-06 17:08:51', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('751', '20', 'Joe', '2017-06-06 18:56:02', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('752', '19', 'admin', '2017-06-07 00:05:24', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('753', '19', 'admin', '2017-06-07 00:09:40', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('754', '19', 'admin', '2017-06-07 00:19:49', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('755', '19', 'admin', '2017-06-07 00:19:49', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('756', '20', 'Joe', '2017-06-07 00:26:25', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('757', '19', 'admin', '2017-06-07 00:26:39', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('758', '20', 'Joe', '2017-06-07 00:31:10', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('759', '19', 'admin', '2017-06-07 00:32:46', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('760', '20', 'Joe', '2017-06-07 00:48:07', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('761', '20', 'Joe', '2017-06-07 03:34:53', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('762', '19', 'admin', '2017-06-07 03:37:03', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('763', '19', 'admin', '2017-06-07 03:44:52', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('764', '19', 'admin', '2017-06-07 03:44:59', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('765', '19', 'admin', '2017-06-07 04:23:09', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('766', '19', 'admin', '2017-06-07 04:23:20', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('767', '19', 'admin', '2017-06-07 10:45:18', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('768', '19', 'admin', '2017-06-07 11:10:26', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('769', null, 'admin', '2017-06-07 11:40:16', '0:0:0:0:0:0:0:1', '2', '密码错误');
INSERT INTO `t_userlog` VALUES ('770', '19', 'admin', '2017-06-07 11:39:08', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('771', null, 'admin', '2017-06-07 23:23:46', '0:0:0:0:0:0:0:1', '2', '密码错误');
INSERT INTO `t_userlog` VALUES ('772', null, 'admin', '2017-06-07 23:23:54', '0:0:0:0:0:0:0:1', '2', '密码错误');
INSERT INTO `t_userlog` VALUES ('773', '19', 'admin', '2017-06-07 23:24:49', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('774', '19', 'admin', '2017-06-07 23:25:17', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('775', '20', 'Joe', '2017-06-07 23:45:17', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('776', '20', 'Joe', '2017-06-07 23:51:36', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('777', '20', 'Joe', '2017-06-08 00:11:29', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('778', '20', 'Joe', '2017-06-08 00:11:48', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('779', '20', 'Joe', '2017-06-08 01:18:56', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('780', '20', 'Joe', '2017-06-08 01:51:54', '0:0:0:0:0:0:0:1', '1', '登录成功！');
INSERT INTO `t_userlog` VALUES ('781', null, 'adminin', '2017-06-08 02:13:20', '0:0:0:0:0:0:0:1', '2', '用户名错误');
INSERT INTO `t_userlog` VALUES ('782', '19', 'admin', '2017-06-08 02:13:26', '0:0:0:0:0:0:0:1', '1', '登录成功！');

-- ----------------------------
-- Table structure for t_userrole
-- ----------------------------
DROP TABLE IF EXISTS `t_userrole`;
CREATE TABLE `t_userrole` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL COMMENT '用户id',
  `roleId` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of t_userrole
-- ----------------------------

-- ----------------------------
-- Table structure for t_usersportsplan
-- ----------------------------
DROP TABLE IF EXISTS `t_usersportsplan`;
CREATE TABLE `t_usersportsplan` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL COMMENT '会员id',
  `dietitionId` int(11) NOT NULL COMMENT '营养师id',
  `soprtsDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '日期',
  `planSportsId` varchar(64) NOT NULL COMMENT '运动项目id',
  `remarks` varchar(200) DEFAULT NULL COMMENT '每天的备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员运动计划';

-- ----------------------------
-- Records of t_usersportsplan
-- ----------------------------

-- ----------------------------
-- Table structure for t_userstatistics
-- ----------------------------
DROP TABLE IF EXISTS `t_userstatistics`;
CREATE TABLE `t_userstatistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dates` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'id',
  `accessCount` int(11) NOT NULL COMMENT '网站访问量',
  `registerCount` int(11) NOT NULL COMMENT '用户注册量',
  `loginCount` int(11) NOT NULL COMMENT '用户登录量',
  `addVipUserCount` int(11) NOT NULL COMMENT '新增高级会员量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户统计';

-- ----------------------------
-- Records of t_userstatistics
-- ----------------------------

-- ----------------------------
-- Table structure for t_vipapplication
-- ----------------------------
DROP TABLE IF EXISTS `t_vipapplication`;
CREATE TABLE `t_vipapplication` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sqDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '申请日期',
  `userId` int(11) NOT NULL COMMENT '会员id',
  `userName` varchar(50) NOT NULL COMMENT '会员姓名',
  `sqStatus` int(11) NOT NULL COMMENT '申请状态 0：未成功，1：申请成功 ，2：待审核',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='高级会员申请表';

-- ----------------------------
-- Records of t_vipapplication
-- ----------------------------
INSERT INTO `t_vipapplication` VALUES ('14', '2017-06-06 11:20:00', '19', 'admin', '1');
INSERT INTO `t_vipapplication` VALUES ('15', '2017-06-06 01:14:39', '20', 'Joe', '1');
INSERT INTO `t_vipapplication` VALUES ('16', '2017-06-08 02:19:27', '21', 'lhb', '2');

-- ----------------------------
-- Table structure for t_vipdietapplication
-- ----------------------------
DROP TABLE IF EXISTS `t_vipdietapplication`;
CREATE TABLE `t_vipdietapplication` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户id',
  `userName` varchar(20) NOT NULL COMMENT '用户名',
  `sqDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
  `sqStatus` int(11) NOT NULL COMMENT '申请状态 0：拒绝；1：同意；2：待审核',
  `dietitianId` int(11) NOT NULL COMMENT '营养师id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='高级会员向营养师制定表申请';

-- ----------------------------
-- Records of t_vipdietapplication
-- ----------------------------
INSERT INTO `t_vipdietapplication` VALUES ('2', '20', 'Joe', '2017-06-06 01:19:49', '1', '19');
INSERT INTO `t_vipdietapplication` VALUES ('4', '21', '李海滨', '2017-06-06 12:08:18', '2', '19');

-- ----------------------------
-- Table structure for t_zixun
-- ----------------------------
DROP TABLE IF EXISTS `t_zixun`;
CREATE TABLE `t_zixun` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `zixuntext` text NOT NULL COMMENT '资讯内容',
  `author` varchar(255) DEFAULT NULL,
  `zixuntype` int(2) NOT NULL COMMENT '资讯类型',
  `show` int(2) DEFAULT '1' COMMENT '是否展示  1展示  0不展示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='健康资讯';

-- ----------------------------
-- Records of t_zixun
-- ----------------------------

-- ----------------------------
-- Table structure for t_zxbrowserecord
-- ----------------------------
DROP TABLE IF EXISTS `t_zxbrowserecord`;
CREATE TABLE `t_zxbrowserecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `usertype` int(11) DEFAULT NULL COMMENT '浏览商品的用户类型: 1登录用户 2游客',
  `zxid` int(11) NOT NULL COMMENT '资讯的ID',
  `zxtitle` varchar(255) NOT NULL COMMENT '浏览的资讯title',
  `browsetime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '浏览资讯的时间',
  `userip` varchar(255) DEFAULT NULL COMMENT '浏览资讯的用户IP地址',
  `zxtype` int(2) DEFAULT NULL COMMENT '资讯类型 1 健康资讯 2 季节资讯',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_zxbrowserecord
-- ----------------------------
INSERT INTO `t_zxbrowserecord` VALUES ('40', '0', '游客', '2', '7', '职场白领提高记1', '2017-06-06 10:08:50', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `t_zxbrowserecord` VALUES ('41', '0', '游客', '2', '7', '职场白领', '2017-06-07 23:22:43', '0:0:0:0:0:0:0:1', null);
INSERT INTO `t_zxbrowserecord` VALUES ('42', '0', '游客', '2', '1', '健康资讯1', '2017-06-08 00:15:39', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `t_zxbrowserecord` VALUES ('43', '0', '游客', '2', '7', '什么食物生吃会更有营养价值', '2017-06-08 00:26:52', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `t_zxbrowserecord` VALUES ('44', '0', '游客', '2', '7', '什么食物生吃会更有营养价值', '2017-06-08 00:27:42', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `t_zxbrowserecord` VALUES ('45', '0', '游客', '2', '7', '什么食物生吃会更有营养价值', '2017-06-08 00:29:54', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `t_zxbrowserecord` VALUES ('46', '0', '游客', '2', '1', '毒豆芽中含有哪些有毒物质？', '2017-06-08 00:31:10', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `t_zxbrowserecord` VALUES ('47', '0', '游客', '2', '10', '吃小龙虾要注意这些误区', '2017-06-08 00:48:58', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `t_zxbrowserecord` VALUES ('48', '0', '游客', '2', '8', '夏季清凉消暑十个不宜', '2017-06-08 01:50:08', '0:0:0:0:0:0:0:1', null);
INSERT INTO `t_zxbrowserecord` VALUES ('49', '0', '游客', '2', '3', '秋天是排毒最好的季节', '2017-06-08 01:50:34', '0:0:0:0:0:0:0:1', null);
INSERT INTO `t_zxbrowserecord` VALUES ('50', '0', '游客', '2', '13', '寒凉季节健康养胃四步走', '2017-06-08 01:50:48', '0:0:0:0:0:0:0:1', null);
INSERT INTO `t_zxbrowserecord` VALUES ('51', '0', '游客', '2', '17', '果王榴莲怎样吃更营养', '2017-06-08 01:51:05', '0:0:0:0:0:0:0:1', '2');
INSERT INTO `t_zxbrowserecord` VALUES ('52', '0', '游客', '2', '14', '困乏打盹睡不醒 夏季如何避开“夏打盹”', '2017-06-08 01:51:20', '0:0:0:0:0:0:0:1', '2');

-- ----------------------------
-- Table structure for t_zxinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_zxinfo`;
CREATE TABLE `t_zxinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  `updatetime` timestamp NULL DEFAULT NULL,
  `infortext` text,
  `author` varchar(255) DEFAULT NULL,
  `zxtypeid` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_zxinfo
-- ----------------------------
INSERT INTO `t_zxinfo` VALUES ('7', '食物生吃更有营养价值', '2017-06-06 02:13:01', '2017-06-08 01:48:57', '<p>健康饮食专家提示，有一些食材在烹饪之后，其营养价值会有流失，所以说，这些食物会比较适合你来生吃。究竟，会适合生吃的食材都有哪些呢?下文就具体介绍了一些可以经常生吃的蔬菜。　　1、豆芽　　在传统做法中，豆芽通常用来炖汤或者炒菜，即使凉拌也会先用滚水焯烫后再过凉凉拌，但是国外在做沙拉的时候常常生吃豆芽，越南料理中也常出现生豆芽佐食的吃法。生吃豆芽不但维生素C保留较多，口感也爽脆可口。　　2、花椰菜　　一般认为，花椰菜都是要焯烫过后才能食用的，但是在欧美，将花椰菜撕成小片后直接加上蛋黄酱拌匀后生吃的做法很常见。不但口感清爽，还会给人一种类似吃胡萝卜和生菜的感觉，喜欢吃沙拉的人不妨尝试一下。　　3、蘑菇　　蘑菇切薄片后加入沙拉中拌匀吃的做法在国外也很常见，因为蘑菇本身的味道非常鲜美。但是需要注意的是蘑菇很容易变色的，最好在吃之前再切片，切片过后可以加一点柠檬汁防止蘑菇氧化变色，口感和视觉上都会更加良好。　　4、秋葵　　将秋葵切薄片，加少许纳豆后铺在乌冬面上食用是日本常有的吃法，再加少许酱油和鲣鱼干就会成为常见的下酒菜之一。　　今天介绍的四种蔬菜，其营养价值丰富，适合你来经常食用。如果将这些食材烹饪之后再吃，可能会破坏它们里面的营养，因此，当你在吃这些食物的时候，最好选择生吃的方法。　　推荐阅读：海带应该怎样挑选</p>', 'admin', '1');
INSERT INTO `t_zxinfo` VALUES ('8', '夏季清凉消暑十个不宜', '2017-06-07 11:32:18', '2017-06-07 11:33:32', '内容提示：因此，消暑也要讲科学，切不可掉以轻心。不宜多吃冷食在炎热的夏季，如果胃肠受到大量冷食的刺激，会加快蠕动，缩短食物在小肠里的停留时间，影响人体对食物营养的吸收。同时，由于夏季气温高，体内热量不易散发，胃肠内的温度也较高，如果骤然受冷刺激可导致胃肠痉挛，引起腹痛。不宜缺少午睡夏季昼长夜短，气温高，人的..\r\n盛夏，酷暑难当，人们为求得一份凉爽，往往忽视了防病保健，而诱发各种不适感，甚至导致病痛发生。因此，消暑也要讲科学，切不可掉以轻心。\r\n\r\n不宜坐木\r\n\r\n俗话说：“冬不坐石，夏不坐木”。夏天气温高，湿度大，木头，尤其是久置露天里的木料，椅凳等，露打雨淋，含水分较多，太阳一晒，温度升高，会向外散发出湿热，使人易患皮肤病、风湿和关节炎等。\r\n\r\n不宜多吃冷食\r\n\r\n在炎热的夏季，如果胃肠受到大量冷食的刺激，会加快蠕动，缩短食物在小肠里的停留时间，影响人体对食物营养的吸收。同时，由于夏季气温高，体内热量不易散发，胃肠内的温度也较高，如果骤然受冷刺激可导致胃肠痉挛，引起腹痛。\r\n\r\n不宜夜晚露宿\r\n\r\n盛夏时节，身上的汗腺不断向外分泌汗液，以散发体内的热量，睡着后，机体处于放松状态，抵抗力暂时下降。此时如果正值夜晚，气温下降，再遇冷风袭来，露水加身，容易导致头痛、腹痛、关节不适，并引起消化不良和腹泻。夜晚露宿还易被蚊虫叮咬，可能染上疾症，如大脑炎等病。\r\n\r\n不宜缺少午睡\r\n\r\n夏季昼长夜短，气温高，人的新陈代谢旺盛，消耗量也大，容易疲劳。加上夜间炎热，睡不安稳，导致睡眠不足。因此，中午睡上一二个小时，对健康大有裨益。可使身体各系统得到休息，也是防止中暑的一项好措施。\r\n\r\n电风扇不宜吹得过久\r\n\r\n电扇吹得过久会破坏出汗的均衡状态，使人感到头痛、头昏、腿酸手软、全身不适，严重者还可能诱发其他疾病。盛夏之夜开着电扇入睡，更容易受凉。尤其老年人和儿童更应注意。', 'admin', '2');
INSERT INTO `t_zxinfo` VALUES ('1', '豆芽有哪些有毒物质', '2017-05-19 23:19:01', '2017-06-08 02:03:10', '<p>豆芽是餐桌上常见的一种蔬菜，也算是一种平民蔬菜。近几年，中国的食品安全问题十分受人关注，就连平民蔬菜豆芽都无法逃脱“含有毒性”的厄运。毒豆芽吃了之后肯定达不到<a href=\"http://www.wenkang.cn/yspd/\" target=\"_blank\">健康饮食</a>的要求，那么问题来了，毒豆芽中含有哪些毒性成分呢?</p><p>　　近年来媒体关于“毒豆芽”的报道，使人们对食用豆芽增加了疑虑。什么是“毒豆芽”?误食会对身体产生什么危害?……等等，成为人们关注的热点问题之一。</p><p>　　媒体2013年7月15日报道，河南省三门峡市湖滨区的不法分子，在近两年时间里，生产销售毒豆芽56万公斤，销往学校、机关、工厂的食堂及各大饭店，上了老百姓的餐桌。农业部食品质量监督检验测试中心的鉴定结果表明，其生产的豆芽中含有亚硫酸盐、6-苄基腺嘌呤等禁止在食品加工中使用的添加剂。</p><p>　　媒体报道，2013年5月26日，河南省灵宝市检察院以涉嫌生产销售有毒、有害食品罪批准逮捕犯罪嫌疑人吴某，因其从2010年11月份开始在家中生产豆芽，为了生产的豆芽卖相好、产量高，在生产豆芽时多次添加4-氯苯氧乙酸钠。</p><p>　　何为“毒豆芽”?2004年4月18日中央电视台每周质量报告曾经报道，部分小作坊式豆芽生产加工企业为了牟取经济利益, 通过改变豆芽的孵化方法及缩短生产周期来增加豆芽产量，可能采取三种违规生产方式：1、为缩短孵化周期而滥用植物生长调节剂如 4-氯苯氧乙酸钠、6-苄基腺嘌呤、乙烯利等。2、为防止烂豆或烂芽违规使用农药或兽药，如多菌灵、百菌清、福美双、诺氟沙星、青霉素等。3、为改变变色发黄的豆芽外观而使用漂白剂、连二亚硫酸钠等。</p><p>　　4-氯苯氧乙酸钠为苯氧乙酸类化合物,是一种植物生长调节剂;其急性毒性实验表明，小鼠经口半数致死量为794mg/kg，属于低毒物质。我国科技工作者在上世纪80年代进行的致突变试验结果表明，4-氯苯氧乙酸钠经沙门氏菌和大肠杆菌/微粒体酶试验，未发现其具备明显的致突变性。在生殖毒性方面，累积剂量1000 mg/kg时，未见对子代繁殖的不良影响;此剂量约相当无作用量(16 mg/kg)持续给药9周的剂量。GBZ760-1996食品添加剂使用卫生标准曾经允许将4-氯苯氧乙酸钠用于豆芽孵育过程，但是残留剂量须≤1mg/kg。</p><p>　　6-苄基腺嘌呤是第一个人工合成的细胞分裂素，属广谱性植物生长调节剂。上世纪80年代我国科技工作者对6-苄基腺嘌呤的安全性开展过毒理学评价研究，以37.5-300mg/kg给小鼠灌胃染毒，小鼠骨髓多染红细胞微核，精原细胞染色体试验结果均未显示病理效应。GB2760-1996食品添加剂使用卫生标准曾经允许将6-苄基腺嘌呤用于豆芽孵育过程，但是残留剂量须≤0.2mg/kg。</p><p>　　基于对食品安全的关注，2011年以后的国家食品添加剂使用卫生标准均未将4-氯苯氧乙酸钠和6-苄基腺嘌呤纳入使用名录，因此无论二者生物学效应结果如何，二者均不得再作为食品添加剂使用。</p><p>　　一般来讲，大型的生产厂家生产出来的豆芽往往不容易出现问题，因为都是正规厂商，如果生产出毒豆芽，不但砸了自己的招牌，还有可能触犯法律。而市面上很多毒豆芽都是小作坊生产出来的，所以尽量还是不要购买小作坊生产的豆芽为好。</p><p>推荐阅读：<strong><a href=\"http://www.wenkang.cn/yspd/jksw/sc/2127300.html\">浑身都是宝贝的“萝卜”</a></strong></p><p> \n		</p>', 'admin', '1');
INSERT INTO `t_zxinfo` VALUES ('3', '秋天是排毒最好的季节', '2017-05-20 00:25:26', '2017-05-20 00:25:29', '温馨提示：\r\n喝水时，如果在水中加一样东西，有助排光体内毒素，外表年轻10岁。具体加什么，关注微信公众号 39健康网 ，发送 白开水 了解详情。\r\n　　秋季是进补的季节，更是排毒的大好季节。因为秋季之前是炎热的夏季，夏季骄阳似火，中医认为“热生湿”，湿热之邪作为“毒素”在体内潜藏下来，逐渐增多，而且秋季主“收”，万物趋向于以收藏为用，毒素也容易在体内蓄积，如果不能得到很好的排泄，就会堆积在体内，导致各种疾病。所以，秋天养生的一项重要内容就是：排毒。\r\n　　那么人体中到底都有哪些“毒素”呢？主要有水毒、脂毒、淤毒、痰毒、湿毒等，都是由于排除不畅、体内的毒素堆积过多所引起。体内毒素蓄积过多的信号主要有，头晕、烦躁不安、疲劳乏力、昏昏欲睡、食欲不振、大便秘结、睡眠不佳等。\r\n　　那么，我们应该怎样充分调动体内的自然排毒系统呢？首先，要注意排毒的时间，按照中医一天十二时辰的养生规律，卯时（早晨5~7点）、午时（中午11~下午1点）、酉时（午后5~7点）分别为大肠经、小肠经、肾经当令的时间，可通过饮食的方法定时排便，多饮水增加排尿量，以达到排毒的作用。\r\n\r\n　　还要注意保持身体的三通，即大便通、小便通、汗液通，这是人体自然排出毒素的重要管道，必须要保持通畅。其中大便能将人体50%的毒素排出体外，所以，一定要养成定时排便的习惯。一般来说，最好的排便习惯是每两天三次排便。正常人每天吃500克左右的蔬菜、适量粗粮是远离便秘的好方法。\r\n　　秋季时热时凉，热时人体出汗较多，要注意多饮水，绿豆汤是不错的选择，还可以多吃一些含水分高的果蔬，如鸭梨、冬瓜等。蜂蜜味甘、性平，自古就是滋补强身、排毒养颜的佳品，还具有润肺部止咳、润肠通便的作用。每天喝一杯蜂蜜水，能够唤起身体器官的排毒功能，开启一天的排毒计划。饮食疗法是非常有效的，秋季还可经常食用蘑菇、木耳、黄瓜、胡萝卜、苦瓜、海带、血豆腐等排毒食物。', 'admin', '2');
INSERT INTO `t_zxinfo` VALUES ('4', '草酸多的蔬菜怎样吃', '2017-05-22 09:59:50', '2017-06-08 01:09:52', '<p>现在因为农业比较发达，所以不论是春季还是寒冷的冬季，我们都可以吃到大量的新鲜<a href=\"http://www.wenkang.cn/yspd/jksw/\" target=\"_blank\">蔬菜</a>。从<a href=\"http://www.wenkang.cn/yspd/\" target=\"_blank\">健康饮食</a>方面来讲，并不是所有的蔬菜人们吃了都利于健康，例如一些含草酸较多的蔬菜，就需要经过特殊处理才可以吃。</p><p>　　食品专家表示，有研究表明，75%的肾结石都是由草酸钙造成的，因此这样的担心也不算空穴来风。</p><p>　　食品专家指出，当草酸和钙相遇时，会形成难溶的草酸钙。正常情况下，人体中形成的草酸钙并不多，会被肾过滤掉，随着尿液排出体外。但如果尿液太少太浓缩，或有大量的草酸和钙相遇，就会导致草酸钙逐渐聚集，在储存尿液的地方形成结晶，最后发展成为肾结石。</p><p>　　对于预防肾结石来说，减少尿中的草酸和钙确实很重要。但食品专家提醒，这两种物质，并不是“多吃就患上肾结石，少吃就不会患上肾结石”那么简单。因此要弄清以下几件事实。</p><p>　　首先，虽然食物中广泛含有草酸，但人体正常代谢也会产生草酸。</p><p>　　其次，食物中的草酸并不能全部被吸收。烹调加工会除去一部分草酸(例如焯煮的时候，草酸会溶于水)，在胃肠道中，草酸与钙、镁、蛋白质等其他物质结合之后，真正进入血液的数量还会减少。此外，每个人对草酸的吸收能力也不一样。所以，即便吃同样多的蔬菜，蔬菜中的草酸也一样多，因为烹调加工不同，食物组合不同，肠胃功能不同，最终进入体内的草酸量，也会有很大的差异。</p><p>　　然后，饮食中的草酸摄入量，并不是肾结石发生的主要风险因素。研究发现，肾结石患者的饮食，和无结石健康人的饮食相比，草酸摄入量并不更多。</p><p>　　此外，大量草酸在肾脏中遇到大量钙，才有可能形成草酸钙结石。尿液中排出的钙越少，结石风险越小。多吃绿叶蔬菜，摄入丰富的钾镁元素，能够提升钙的利用效率，减少尿钙的排出。而吃太多的盐、肉类、甜饮料等，会增加尿钙的排出量，不利于预防肾结石。</p><p>　　当人体摄入草酸过多时，就很容易患上肾结石等疾病。那么，有没有什么食物可以解决这一问题呢?小编从营养专家那里得知，平日里多吃一些含有钙质的食物，就可以起到预防肾结石这样的疾病。因为钙质能够与草酸结合，形成草酸钙。</p><p>推荐阅读：<strong><a href=\"http://www.wenkang.cn/yspd/jksw/sc/2127300.html\">浑身都是宝贝的“萝卜”</a></strong></p><p> \n		</p>', 'admin', '1');
INSERT INTO `t_zxinfo` VALUES ('10', '吃小龙虾要注意这些误区', '2017-06-06 00:33:23', '2017-06-08 00:33:26', '<div class=\"content\" deep=\"3\"><p>　　小龙虾是<a href=\"http://www.wenkang.cn/yspd/sjys/xjys/\" target=\"_blank\">夏季饮食</a>之一，很多人到了夏季，就会特别爱吃小龙虾。不可否认，小龙虾的美味让很多人欲罢不能，但小龙虾的“脏”，也是很多人都知道的。<a href=\"http://www.wenkang.cn/yspd/\" target=\"_blank\">健康饮食</a>专家提示，小龙虾虽然好吃，我们在吃小龙虾的时候，也要注意健康问题。下文介绍了一些吃小龙虾的误区，一定要注意。</p>\r\n\r\n<p>　　小龙虾也称克氏原螯虾、红螯虾和淡水小龙虾。形似虾而甲壳坚硬。成体长约5.6~11.9厘米，暗红色，甲壳部分近黑色，腹部背面有一楔形条纹。</p>\r\n\r\n<p>　　小龙虾体内的蛋白质含量很高，且肉质松软，易消化，对身体虚弱以及病后需要调养的人是极好的食物;虾肉内还富含镁、锌、碘、硒等，镁对心脏活动具有重要的调节作用，能保护心血管系统，它可减少血液中胆固醇含量，防止动脉硬化，同时还能扩张冠状动脉，有利于预防高血压及心肌梗塞。小龙虾含有虾青素，虾青素是一种很强的抗氧化剂，虾青素有助消除因时差反应而产生的“时差症”。</p>\r\n\r\n<p><strong>　　小龙虾的危害</strong></p>\r\n\r\n<p>　　吃小龙虾也存在一定的危害，小龙虾里有肺吸虫，容易造成“横纹肌溶解症”。一般来讲小龙虾和蟹这类动物都携带肺吸虫，而且用烤、炒或者腌的方法不能保证将肺吸虫的幼虫杀死。所以，吃小龙虾一定要煮熟煮透才行。</p>\r\n\r\n<p>　　<strong>夏季食用小龙虾误区</strong></p>\r\n\r\n<p><strong>　　1 、看颜色识别生熟</strong></p>\r\n\r\n<p>　　专家说，市民在家烹饪小龙虾时，一定要高温煮熟煮透，可通过观察虾仁横截面颜色是否一致来判断是否煮熟。建议在烹饪加工前，一定要清水喂养24小时左右，让虾体吐出代谢物。</p>\r\n\r\n<p>　<strong>　2、莫吃虾头毒素多</strong></p>\r\n\r\n<p>　　“小龙虾的虾头部分千万不能食用。”专家提醒，小龙虾的头部是吸收并处理毒素最多的地方，也是最易积聚病原菌和寄生虫的部分。</p>\r\n\r\n<p>　　此外，吃虾时也要有节制，不要一次食用过多，因为虾是高蛋白食物，部分过敏体质者会对小龙虾产生过敏症状，如身上起红点、起疙瘩等等，最好不要食用小龙虾。小龙虾是含嘌呤较高的水产品，痛风病人也不要食用。</p>\r\n\r\n<p><strong>　　3 、烧龙虾一定要煮熟煮透</strong></p>\r\n\r\n<p>　　饭店的龙虾都是连头一起烧的。在被污染的环境中，小龙虾吸附的能力特别强，它有可能把对人体有害的重金属吸附进去，当它吸附重金属元素后，头部会自然产生一个“囊”，把重金属包裹起来。同样，龙虾头部是最易积聚寄生虫的部分，所以吃的时候要去头。因为高温烧煮才能完全杀死寄生虫，小龙虾蒸煮时间必须要达到30-40分钟，才能杀死寄生虫。如果采用烤、炒或腌、醉等方法加工小龙虾，在食用后就有可能感染肺吸虫病。</p>\r\n\r\n<p><strong>　　4 、龙虾一定要清洗干净</strong></p>\r\n\r\n<p>　　活龙虾在买来后，最好放在清水里养24—36小时，使其吐净体内的泥沙等杂质，杀死细菌。在加工龙虾时，是两腮里的脏东西要清除，因为腮毛里面吸附了很多细菌，虾壳最好用刷子刷洗。龙虾细爪的根部最容易藏污纳垢，一定要剪掉。另外要用刷子洗净其身体上的脏物，同时隐藏了大量泥沙和细菌的肠线也必须剔除干净，再用清水充分地清洗2-3次。</p>\r\n\r\n<p><strong>　　5 、看虾钳是否很容易脱落</strong></p>\r\n\r\n<p>　　经过洗虾粉洗过的小龙虾，往往看上去非常干净，色泽也很光鲜。小龙虾是否用洗虾粉洗过靠吃是无法品尝出的，只有通过仔细观察。</p>\r\n\r\n<p>　　被腐蚀过后的小龙虾虾钳很容易脱落，如果餐桌上的小龙虾虾钳普遍比较少的话，使用洗虾粉的可能性就比较大。此外，经过腐蚀后的小龙虾颜色会很鲜艳，市民也应当注意这一点。</p>\r\n\r\n<p>　<strong>　6、小龙虾并非人人都能食用</strong></p>\r\n\r\n<p>　　小龙虾并非人人都能食用，某些过敏性疾病的患者，如支气管哮喘、反复发作的过敏性皮炎、过敏性腹泻等等，约有20%的病员可由食虾激起发作。因此，已明确对虾过敏的，在缓解期和发作期都不要进食。</p>\r\n\r\n<p>　<strong>　不能和小龙虾同吃的食物</strong></p>\r\n\r\n<p>　　1、龙虾中的蛋白质与维生素C结合后会生成三价砷，会造成人体食物中毒。所以吃虾时最好不要吃富含维生素C的<a href=\"http://www.wenkang.cn/yspd/jksw/sg/\" target=\"_blank\">水果</a>，要吃水果，最好在吃完龙虾2小时后。例如，与葡萄、山楂、柿子之类同食，很可能会导致头晕、恶心、腹泻等。</p>\r\n\r\n<p>　　2、不宜与猪肉、狗肉、南瓜等同食。</p>\r\n\r\n<p>　　3、不宜与鸡蛋等同食。</p>\r\n\r\n<p>　　4、不宜与啤酒同食，龙虾作为一种高蛋白食物，在人体内分解后变成尿酸，而饮酒会阻挡身体尿酸的排泄，要是两者相互作用会增加患痛风病的风险。</p>\r\n\r\n<p>　　这些就是关于小龙虾的介绍了，可见，吃小龙虾还是很有讲究的。专家提示小龙虾虽然好吃，但不能贪吃，如果你一次性吃太多的小龙虾，就能引起肠胃不适，甚至出现疾病隐患。我们在吃小龙虾的时候，不要吃维生素高的水果，以免引起身体不适。吃小龙虾的学问有不少，你要认真了解。</p>\r\n\r\n<p>　　推荐阅读：<a href=\"http://www.wenkang.cn/yspd/jbys/qtys/2132600.html\" target=\"_blank\">可以消除脂肪肝的食物</a></p>\r\n		</div>', 'Joe', '1');
INSERT INTO `t_zxinfo` VALUES ('11', '吃醋时间不同 功效也不同', '2017-06-01 00:35:00', '2017-06-08 00:35:04', '<div class=\"content\" deep=\"3\"><p>　　作为调味品，我们做饭时会用到醋。在<a href=\"http://www.wenkang.cn/yspd/\" target=\"_blank\">健康饮食</a>专家看来，醋不仅能做菜时使用，直接食用对健康也大有益处。在不同的时间段吃醋，会得到不同的养生功效。接下来，专家就介绍了几个吃醋的最佳时间点，告诉你这个时候吃醋会有怎样的好处。让我们一起来学习关于醋的养生知识吧。</p>\r\n\r\n<p>　<strong>　1.空腹一匙陈醋，通便</strong></p>\r\n\r\n<p>　　许多被痤疮或色斑困扰的女性朋友常常存在不同程度的便秘。</p>\r\n\r\n<p>　　现代医学研究表明，老陈醋中含有丰富的氨基酸和某些酵解酶类，以及多种不饱和脂肪酸，可促进肠道蠕动，维持肠道内环境的生态菌群平衡，保持大便通畅。</p>\r\n\r\n<p>　　如果便秘较重，可每天早晨空腹服一匙老陈醋，再喝上一杯凉开水，服用一周后即可见效。</p>\r\n\r\n<p><strong>　　2.睡前15毫升，减肥</strong></p>\r\n\r\n<p>　　减肥是女性朋友们的永恒话题，醋中含有20多种氨基酸和16种有机酸，可促进糖代谢，降低胆固醇。</p>\r\n\r\n<p>　　经常食用醋中所含的氨基酸，不但可以消耗体内脂肪，还能促进糖、蛋白质等新陈代谢顺利进行，起到减肥效果。</p>\r\n\r\n<p>　　因此，想瘦身的朋友不妨每晚睡前饮用10—15毫升米醋。</p>\r\n\r\n<p>　　<strong>3.晨起喝醋，防感冒</strong></p>\r\n\r\n<p>　　果汁醋能提高机体免疫力，还含有丰富的维生素C，维生素C是一种强大的抗氧化剂，能防止细胞癌变和细胞衰老，增加身体的抵抗力。</p>\r\n\r\n<p>　　此外，醋酸有抗菌消炎的作用，可以预防感冒。对于爱感冒的人来说，可以在早饭后出门前喝一瓶果汁醋，可以抵御早晨上班路上的寒冷，不得感冒。</p>\r\n\r\n<p>　　尤其是在冬天，可以把果汁醋加热来喝，这样对胃没有什么刺激，也让醋的消毒杀菌效果更好一些。</p>\r\n\r\n<p><strong>　　4.下午喝果醋，防疲劳</strong></p>\r\n\r\n<p>　　对于上班族来说，果汁醋是能够消除疲劳的最佳饮品。</p>\r\n\r\n<p>　　果醋中含有十种以上的有机酸和人体所需的多种氨基酸。它们使有氧代谢顺畅，有利于清除沉积的乳酸，起到消除疲劳的作用。</p>\r\n\r\n<p>　　通常来说，下午3点左右的时间，是一天中最容易疲劳的一个时段，可以选择在此时喝250毫升果汁醋，可以起到非常好的效果。</p>\r\n\r\n<p>　<strong>　5.夜晚喝醋，美容</strong></p>\r\n\r\n<p>　　夜晚的时候往往是油脂分泌最旺盛的时刻，尤其是过氧化脂的分泌，在夜晚尤其增多，这也是导致皮肤细胞衰老的主要因素。</p>\r\n\r\n<p>　　此外，在晚间的时候多数状态下皮肤的PH值失衡，血液循环不畅，往往有皮肤紧绷或者是干涩的情况。晚上临睡前喝一些果汁醋会缓解这种情况。</p>\r\n\r\n<p>　　果醋中所含有的有机酸、甘油和醛类物质可以平衡皮肤的PH值，控制油脂分泌，扩张血管，加快皮肤血液循环，有益于清除沉积物，使皮肤光润。</p>\r\n\r\n<p>　　其中含有丰富的氨基酸，可以促进体内脂肪分解，还能起到减肥的作用。</p>\r\n\r\n<p>　　所以说，在不同的时间点吃醋，会有不同的养生功效。小编提示市面上的醋分两种，一种是调配的，一种是酿造的。从营养价值的角度来说，酿造的醋口感会更好，营养也会更丰富。因此，如果你想吃醋，比如直接食用的话，最好选择酿造的醋，如果直接饮用接受不了，也可以用它做菜哦。</p>\r\n\r\n<p>　　推荐阅读：<a href=\"http://www.wenkang.cn/yspd/jkcf/scxg/2131198.html\" target=\"_blank\">买健康食物不要“以貌取人”</a></p>\r\n		</div>', 'Joe', '1');
INSERT INTO `t_zxinfo` VALUES ('12', '美食专家教你如何挑选食用油', '2017-06-01 00:36:11', '2017-06-08 00:36:13', '<div class=\"content\" deep=\"3\"><p>　　不论是做什么菜，一般都会用到食用油，而且食用油的种类也非常多，味道也会有所不同。但是考虑到<a href=\"http://www.wenkang.cn/yspd/\" target=\"_blank\">健康饮食</a>，因此食用油的挑选十分关键。今天，小编为大家请来了美食专家，让专家教大家如何挑选食用油。</p> <p style=\"text-align: center;\"><a href=\"http://www.wenkang.cn/yspd/\" target=\"_blank\"><img alt=\"美食专家教你如何挑选食用油\" src=\"http://xs3.op.xywy.com/api.iu1.xywy.com/cms/20160728/011f1d1372e9fc33073f3c7f0500b49594785.jpg\" style=\"height: 300px; width: 400px;\"></a></p> <p>　<strong>　A、每次购买3种油</strong></p> <p>　　食用油的种类很多，选择的面很大。最好同时购买玉米油、橄榄油、亚麻籽油这3种油。炒菜用玉米油，凉拌菜淋点橄榄油，煲好的汤滴点亚麻籽油，相互搭配，营养互补，对健康有益。</p> <p>　　有人怕一次买3瓶油不利于储存，那就买250-1000毫升小瓶装的，且在选购时查看好生产日期。</p> <p>　<strong>　B、油桶外面套黑袋</strong></p> <p>　　食用油的存放，除了大家都知道的4大原则：干燥、避光、低温、密封外，还有个加护法：在油桶的外面套个黑塑料袋，加强避光性。这样可防止油脂氧化变质。</p> <p>　　买油时要买小瓶的，每次用完油后也一定拧紧瓶盖。另外，存储油时还得远离3个“台”——灶台、阳台、窗台，以防油变质。</p> <p>　<strong>　C、自己配瓶调和油</strong></p> <p>　　调和油是将两种或以上的植物油调配而成，要学会自己配制调和油。</p> <p>　　中国营养学会推荐，食用油单不饱和脂肪酸和多不饱和脂肪酸的比例是1∶1，而多不饱和脂肪酸中α-亚麻酸和亚油酸的比例为1∶4-6。</p> <p>　　调配时，准备500毫升山茶籽油、100毫升亚麻籽油、400毫升葵花籽油，掺在一起，就成了一瓶1000毫升的营养调和油了，但每次别调太多，可据家里人口的多少，每次配一周的量(每人每日25-30克)。</p> <p>　　在用食用油炒菜的时候，很多人的做法就是等到锅底的油冒烟的时候再炒菜，这是很错误的做法。因为油温过高的时候，就会产生一些对人体有害的物质。因此，建议大家使用食用油的时候，油温一定要控制在六成热之下。</p> <p>推荐阅读：<strong><a href=\"http://www.wenkang.cn/yspd/ask/2127373.html\">低血压病人能喝果汁吗</a></strong></p> \r\n		</div>', 'lhb', '1');
INSERT INTO `t_zxinfo` VALUES ('13', '寒凉季节健康养胃四步走', '2017-06-05 00:41:32', '2017-06-08 01:24:07', '第一步，要纠正不良的饮食习惯多食清淡，少食肥甘及各种刺激性食物，如含酒精及香料的食物。谨防食物中的过酸、过甜、过咸、过苦、过辛，不可使五味有所偏嗜，也不吃过冷、过烫、过硬的食物，更忌暴饮暴食，戒烟禁酒。    第二步，饮食定时定量    长期胃痛的病人每日三餐或加餐均应定时，间隔时间要合理。急性胃痛的病人应尽量少食多餐，使胃中经常有食物和胃酸进行中和，从而防止侵蚀胃粘膜和溃疡面而加重病情。    第三步，注意营养平衡    平素的饮食应供给富含维生素的食物，以利于保护胃黏膜和提高其防御能力，并促进局部病变的修复。    第四步，饮食宜软、温、暖、素、鲜    烹调宜用蒸、煮、熬、烩，少吃坚硬、粗糙的食物。进食时不急不躁，使食物在口腔中充分咀嚼，与唾液充分混合后慢慢咽下，这样有利于消化和病后的修复。要注意四季饮食温度的调节，脾胃虚寒者尤应禁食生冷食物，肝郁气滞者忌在生气后立即进食。', 'admin', '2');
INSERT INTO `t_zxinfo` VALUES ('14', '困乏打盹睡不醒 夏季如何避开“夏打盹”', '2017-05-29 00:42:19', '2017-06-08 00:42:50', '<div class=\"newsc_con1\">\r\n<div class=\"dibu1\"></div>\r\n<div id=\"zoom\" deep=\"4\">\r\n<p style=\"text-indent:2em;\">\r\n	人们常说“春困秋乏夏打盹”，夏天人体的新陈代谢加快，耗氧量加大，大脑一时无法调节对氧的依赖性，结果是人体机能暂时不能适应环境而感到困乏疲倦。\r\n</p>\r\n<p style=\"text-align:center;\">\r\n	<img src=\"http://image.tech-food.com/images/news/bpic/201706/20170602111603_0619.jpg\" title=\"儿童\" alt=\"儿童\"> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	夏打盹到底是为啥?\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	1夏季消化功能减弱，易脾虚易疲劳\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	夏天暑热会减弱人的食欲及肠胃的消化功能，从而影响到人体对营养的摄入量。营养摄入少了，人自然就会感觉没精神，易疲劳。主要表现为乏力、困倦、头重、头晕，有的甚至会有恶心、食欲减退等症状。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	2夏季钾、钙等微量元素大量流失\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	夏天气温高，人体出汗多，人体中的钙、钾、钠等微量元素随之大量流失，从而造成人体对这些元素的缺乏，这也是导致夏季精神疲劳和“夏打盹”最主要的原因。比如，如果钙流失过多，就很容易出现低血钙现象，人就会很经常地感到腰背和腿部酸痛;如果人体内的钾流失过多，则会造成低血钾现象，从而引起人体倦怠无力、头昏头痛、食欲不振等症状。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	如何防止夏打盹\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	1、调补胃口：在长夏或夏季时常打瞌睡是因脾虚湿阻引起的，所以饮食方面，食用米仁绿豆汤、山药米仁粥等，起到健脾化湿开胃的作用；中成药方面有藿香正气胶囊、纯阳正气丸、玉枢丹等；中草药如藿香、佩兰、菖蒲、砂仁、蔻仁、扁豆、荷叶、菊花、决明子、莲子等，可清热化湿。胃口有了，饮食摄入增加，精神倍增，就不容易打瞌睡了。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	2、补充营养：夏季人体新陈代谢加快，能量消耗增加，加之因胃口不佳而摄入减少，营养就相对不足，所以补充足够的营养物质，使人体兴奋性增加，能够提升精神面貌，对夏季打瞌睡也有一定的改善作用。尤其是老年人，是体乏的主要人群，容易疲劳，补充营养更是必须。但是夏季的“补”，应以清补为宜，饮食清淡，少油腻，多吃瓜果蔬菜，比如冬瓜、西瓜、番茄等。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	3、适当补睡：夏天日长夜短，睡眠规律通常都是晚睡早起，睡眠时间相对减少，中午睡个午觉是适当的补充，我们的体会是“午睡一刻钟，夜补一小时”。但是，午睡时间也不宜过长，一般半小时为宜。因为白天睡得时间过长的话，晚上就会睡不着，造成不良循环，影响健康。有些人即使午睡了较长时间，午后仍频频打瞌睡，就要细查原因了，可能是夜间缺乏睡眠或睡眠状况不佳引起的，应先从根本原因着手，解决夜间睡眠的问题后，白天的瞌睡问题也就迎刃而解了。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	需要提醒的是，有些老年人及少数中青年晚上睡眠正常，白天还是不停打瞌睡的话，应该到医院仔细检查，是否由器质性疾病引起，以免延误治疗。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	如何补钾\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	1、新鲜蔬菜中，菌类（如口蘑、鲜蘑等）、豆角、小萝卜、菜花、黄花菜、苦瓜、南瓜、丝瓜、油菜、菠菜、苋菜、芹菜等钾含量比较高。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	2、在水果中，香蕉的钾含量最高。此外，现在时令的水果，如樱桃、杏、荔枝、草莓等含钾也很丰富。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	3、海产品也是补钾的重要来源，比如海带、紫菜、海鱼、虾皮等。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	4、可适量吃些坚果，如花生、核桃、开心果等，来补充流失的钾。当然，也可多喝些绿豆汤，一来防暑降温，二来可以补充钾元素。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	5、人体在大量出汗后，也可补充一些含有钾、钠离子的饮料，但不要马上喝过量的白开水或糖水，防止血钾过分降低。\r\n</p>\r\n</div><br>\r\n<div class=\"dibu2\"></div>\r\n<div class=\"dibu_sl\">相关搜索： <a href=\"http://search.tech-food.com/ns_%e5%a4%8f%e6%89%93%e7%9b%b9.html\">夏打盹</a></div>\r\n<div style=\"margin-left:0px;margin-right:0px;margin-top:10px;margin-bottom:10px;text-align:center;\"><script type=\"text/javascript\">adsid(\"neirong_c1\");</script><!-- 广告位：新闻_内容_左1_600*120 -->\r\n<script>\r\n(function() {\r\n    var s = \"_\" + Math.random().toString(36).slice(2);\r\n    document.write(\'<div id=\"\' + s + \'\"></div>\');\r\n    (window.slotbydup=window.slotbydup || []).push({\r\n        id: \'2085997\',\r\n        container: s,\r\n        size: \'600,120\',\r\n        display: \'inlay-fix\'\r\n    });\r\n})();\r\n</script><div id=\"_87k86nighdl8juhrtzv1nyiudi\"></div><script charset=\"utf-8\" src=\"http://pos.baidu.com/ncgm?di=2085997&amp;dri=0&amp;dis=0&amp;dai=3&amp;ps=2535x207&amp;dcb=___adblockplus&amp;dtm=SSP_JSONP&amp;dvi=0.0&amp;dci=-1&amp;dpt=none&amp;tsr=0&amp;tpr=1496853728455&amp;ti=%E5%9B%B0%E4%B9%8F%E6%89%93%E7%9B%B9%E7%9D%A1%E4%B8%8D%E9%86%92%20%E5%A4%8F%E5%AD%A3%E5%A6%82%E4%BD%95%E9%81%BF%E5%BC%80%E2%80%9C%E5%A4%8F%E6%89%93%E7%9B%B9%E2%80%9D_%E5%81%A5%E5%BA%B7%E7%9F%A5%E8%AF%86_%E5%81%A5%E5%BA%B7%E8%B5%84%E8%AE%AF&amp;ari=2&amp;dbv=2&amp;drs=1&amp;pcs=1349x574&amp;pss=1349x2570&amp;cfv=0&amp;cpl=29&amp;chi=1&amp;cce=true&amp;cec=UTF-8&amp;tlm=1496853728&amp;rw=574&amp;ltu=http%3A%2F%2Fwww.tech-food.com%2Fnews%2Fdetail%2Fn1343997.htm&amp;ltr=http%3A%2F%2Fwww.tech-food.com%2Fnews%2Fc17%2F&amp;lcr=https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3DJeU1ccNQlFj_2lWqn3k2Ej87cs7O_aFif0T0oCy9tdCGJLE-G859VzICxaXbHuquC3qMOlwTyZ65Tj3TPe8b5q%26wd%3D%26eqid%3D90446872000169b20000000559382bbf&amp;ecd=1&amp;uc=1366x728&amp;pis=-1x-1&amp;sr=1366x768&amp;tcn=1496853729\"></script><script type=\"text/javascript\">\r\nvar cpro_id=\"u2389711\";\r\n(window[\"cproStyleApi\"] = window[\"cproStyleApi\"] || {})[cpro_id]={at:\"3\",rsi0:\"600\",rsi1:\"120\",pat:\"3\",tn:\"baiduCustNativeAD\",rss1:\"#FFFFFF\",conBW:\"0\",adp:\"1\",ptt:\"2\",ptc:\"%E7%8C%9C%E4%BD%A0%E5%96%9C%E6%AC%A2%EF%BC%9A\",ptFS:\"14\",ptFC:\"#000000\",ptBC:\"#cc0000\",titFF:\"%E5%BE%AE%E8%BD%AF%E9%9B%85%E9%BB%91\",titFS:\"14\",rss2:\"#000000\",titSU:\"0\",tft:\"0\",tlt:\"1\"}\r\n</script>\r\n<script src=\"http://cpro.baidustatic.com/cpro/ui/c.js\" type=\"text/javascript\"></script><div id=\"BAIDU_SSP__wrapper_u2389711_0\"><iframe id=\"iframeu2389711_0\" src=\"http://pos.baidu.com/ncgm?sz=600x120&amp;rdid=2389711&amp;dc=3&amp;di=u2389711&amp;dri=0&amp;dis=0&amp;dai=4&amp;ps=2535x207&amp;coa=at%3D3%26rsi0%3D600%26rsi1%3D120%26pat%3D3%26tn%3DbaiduCustNativeAD%26rss1%3D%2523FFFFFF%26conBW%3D0%26adp%3D1%26ptt%3D2%26ptc%3D%2525E7%25258C%25259C%2525E4%2525BD%2525A0%2525E5%252596%25259C%2525E6%2525AC%2525A2%2525EF%2525BC%25259A%26ptFS%3D14%26ptFC%3D%2523000000%26ptBC%3D%2523cc0000%26titFF%3D%2525E5%2525BE%2525AE%2525E8%2525BD%2525AF%2525E9%25259B%252585%2525E9%2525BB%252591%26titFS%3D14%26rss2%3D%2523000000%26titSU%3D0%26tft%3D0%26tlt%3D1&amp;dcb=___adblockplus&amp;dtm=HTML_POST&amp;dvi=0.0&amp;dci=-1&amp;dpt=none&amp;tsr=0&amp;tpr=1496853728455&amp;ti=%E5%9B%B0%E4%B9%8F%E6%89%93%E7%9B%B9%E7%9D%A1%E4%B8%8D%E9%86%92%20%E5%A4%8F%E5%AD%A3%E5%A6%82%E4%BD%95%E9%81%BF%E5%BC%80%E2%80%9C%E5%A4%8F%E6%89%93%E7%9B%B9%E2%80%9D_%E5%81%A5%E5%BA%B7%E7%9F%A5%E8%AF%86_%E5%81%A5%E5%BA%B7%E8%B5%84%E8%AE%AF&amp;ari=2&amp;dbv=2&amp;drs=1&amp;pcs=1349x574&amp;pss=1349x2570&amp;cfv=0&amp;cpl=29&amp;chi=1&amp;cce=true&amp;cec=UTF-8&amp;tlm=1496853729&amp;rw=574&amp;ltu=http%3A%2F%2Fwww.tech-food.com%2Fnews%2Fdetail%2Fn1343997.htm&amp;ltr=http%3A%2F%2Fwww.tech-food.com%2Fnews%2Fc17%2F&amp;ecd=1&amp;uc=1366x728&amp;pis=-1x-1&amp;sr=1366x768&amp;tcn=1496853729&amp;qn=ffb685593ab6be6e&amp;tt=1496853728419.581.581.583\" width=\"600\" height=\"120\" align=\"center,center\" vspace=\"0\" hspace=\"0\" marginwidth=\"0\" marginheight=\"0\" scrolling=\"no\" frameborder=\"0\" style=\"border:0;vertical-align:bottom;margin:0;width:600px;height:120px\" allowtransparency=\"true\"></iframe></div>\r\n</div>\r\n<div style=\"margin-left:0px;margin-right:0px;margin-top:10px;margin-bottom:20px;overflow:hidden;\"><script type=\"text/javascript\">adsid(\"neirong_c\");</script><!-- 广告位：新闻_内容_左4_640*90 -->\r\n<script>\r\n(function() {\r\n    var s = \"_\" + Math.random().toString(36).slice(2);\r\n    document.write(\'<div id=\"\' + s + \'\"></div>\');\r\n    (window.slotbydup=window.slotbydup || []).push({\r\n        id: \'193099\',\r\n        container: s,\r\n        size: \'616,60\',\r\n        display: \'inlay-fix\'\r\n    });\r\n})();\r\n</script><div id=\"_gunabr2ifil5ghwe7126pf1or\"></div><script charset=\"utf-8\" src=\"http://pos.baidu.com/ncgm?di=193099&amp;dri=0&amp;dis=0&amp;dai=5&amp;ps=2700x207&amp;dcb=___adblockplus&amp;dtm=SSP_JSONP&amp;dvi=0.0&amp;dci=-1&amp;dpt=none&amp;tsr=0&amp;tpr=1496853728455&amp;ti=%E5%9B%B0%E4%B9%8F%E6%89%93%E7%9B%B9%E7%9D%A1%E4%B8%8D%E9%86%92%20%E5%A4%8F%E5%AD%A3%E5%A6%82%E4%BD%95%E9%81%BF%E5%BC%80%E2%80%9C%E5%A4%8F%E6%89%93%E7%9B%B9%E2%80%9D_%E5%81%A5%E5%BA%B7%E7%9F%A5%E8%AF%86_%E5%81%A5%E5%BA%B7%E8%B5%84%E8%AE%AF&amp;ari=2&amp;dbv=2&amp;drs=1&amp;pcs=1349x574&amp;pss=1349x2721&amp;cfv=0&amp;cpl=29&amp;chi=1&amp;cce=true&amp;cec=UTF-8&amp;tlm=1496853729&amp;rw=574&amp;ltu=http%3A%2F%2Fwww.tech-food.com%2Fnews%2Fdetail%2Fn1343997.htm&amp;ltr=http%3A%2F%2Fwww.tech-food.com%2Fnews%2Fc17%2F&amp;lcr=https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3DJeU1ccNQlFj_2lWqn3k2Ej87cs7O_aFif0T0oCy9tdCGJLE-G859VzICxaXbHuquC3qMOlwTyZ65Tj3TPe8b5q%26wd%3D%26eqid%3D90446872000169b20000000559382bbf&amp;ecd=1&amp;uc=1366x728&amp;pis=-1x-1&amp;sr=1366x768&amp;tcn=1496853729\"></script>\r\n</div>\r\n<div style=\"margin-left:0px;margin-right:0px;margin-top:10px;margin-bottom:10px;text-align:center;\"><script type=\"text/javascript\">QQkj();</script><iframe width=\"130\" height=\"24\" frameborder=\"0\" allowtransparency=\"true\" marginwidth=\"0\" marginheight=\"0\" scrolling=\"no\" border=\"0\" src=\"http://widget.weibo.com/relationship/followbutton.php?language=zh_cn&amp;width=136&amp;height=24&amp;uid=2131213192&amp;style=2&amp;btn=red&amp;dpc=1\" style=\"width:136px;height:24px;border:none;overflow:hidden;text-align:center;\"></iframe></div>\r\n</div>', 'Joe', '2');
INSERT INTO `t_zxinfo` VALUES ('15', '春生夏长 夏季增高好季节 儿童如何正确补钙', '2017-04-24 00:43:58', '2017-05-30 00:44:03', '<div class=\"TRS_Editor\" deep=\"6\">\r\n<p>　　又到了挥汗如雨的炎炎夏日，对于处在快速发育期的孩子来说，在阳光下尽情奔跑玩耍十分利于其成长。充足的日照会促进体内维生素D的合成，促进钙质吸收，加快骨骼生长;同时，流汗越多，新陈代谢就越快，孩子的生长发育自然也就越旺盛。但是，当孩子汗流浃背的回到家里时，妈妈一定要 特别注意：随汗液流失的不仅是水分，还有体内宝贵的钙、锌等矿物质元素，每天从汗液中排出的钙多达15mg。钙的加速流失，容易造成孩子身体机能的紊乱， 对成长发育产生不利影响。</p>\r\n<p>　　同时，夏季炎热的天气还会让孩子体内的消化酶活性降低，导致食欲下降，原本就弱小的脾胃功能随着气温的不断升高而逐渐失调，甚至出现偏食、厌食的症状，严重影响了日常膳食中营养物质的补充和吸收，特别是钙质的摄取，无法满足孩子们的成长所需。</p>\r\n<p>　　据世界卫生组织的一项研究表明，每年4至7月身高增长值相当于9至12月身高增长值的2～2.5倍，在这样一个黄金季节给处在快速生长期的孩子补钙，可以达到事半功倍的效果，妈妈们一定要给孩子适时适量补好钙，为孩子一生的健康奠定坚实的基础!只有钙质充足，孩子夏季才长得快。</p>\r\n<p align=\"center\" style=\"position: relative; width: 100%;\"><em class=\"ny\" title=\"下一页\" style=\"height: 220px; width: 286.5px;\"></em><em class=\"qy\" title=\"上一页\" style=\"height: 220px; width: 286.5px;\"></em><img style=\"border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border-left-width: 0px\" alt=\"\" src=\"./W020170602410782570930.jpg\" oldsrc=\"W020170602410782570930.jpg\"><p class=\"box-show\">点击查看高清原图</p></p>\r\n<p>　　宝宝补钙的几个小妙招</p>\r\n<p>　　1、奶品是宝宝最好的补钙来源，就钙容易吸收的程度来看，母乳最佳，次之是配方奶，最后是鲜奶。</p>\r\n<p>　　2、避免把钙剂放到牛奶、米汤或稀粥等食物中，食物中的植酸会影响钙吸收，导致体内钙吸收下降。</p>\r\n<p>　　3、补钙时一定要同时补充维生素D，促进钙在肠道吸收和利用，理想的补钙方法是服用含有维生素D的钙剂。</p>\r\n<p>　　4、婴幼儿补钙可选择含钙量较丰富的无机钙，如碳酸钙。</p>\r\n<p>　　5、烹调鱼或排骨放些醋，用小火长久焐焖，使鱼骨、排骨中的钙充分溶出，钙与蛋白质在一起也最容易被吸收。</p>\r\n<p>　　6、大米和白面中含有很多植酸，影响钙的吸收。制作前，最好先将面粉发酵或把大米放在温水里浸泡一下。</p>\r\n<p>　　7、黄豆(大豆)植酸含量很高，可采用发芽方法去掉，以促进钙的吸收和利用。</p>\r\n<p>　　8、菠菜、苋菜等绿色蔬菜先焯一下好，除去草酸，再和豆腐一起炒，以免影响本身及其他食物中的钙吸收。</p>\r\n<p>　　9、食物中蛋黄或动物肉维生素D含量相对较高，可给4-5个月的宝贝喂一些熟蛋黄，10个月时添猪肝粥或羊肝粥。</p>\r\n<p>　　10、把豆腐和鱼一起炖，鱼肉中含有的维生素D促进豆腐中的钙吸收;把西红柿与鸡蛋同炒，西红柿中的维生素C促进鸡蛋中的钙吸收;把雪里蕻与黄豆同食，都可使钙的吸收和利用率大为提高。</p>\r\n<p>　　11、少吃高盐、高油、高蛋白饮食，如汉堡、炸鸡、洋芋片、虾味鲜、蚕豆酥等;少吃高磷食品，如汽水、可乐等。前者增加钙的排出，后者妨碍钙的吸收。</p>\r\n<p>　　12、宝宝可尽量多进行户外活动，增加体内维生素D的合成。</p>\r\n<p>　　13、钙剂最好在两餐之间服用，这样可使钙被体内更好利用，进餐时服用容易影响钙的吸收率。</p>\r\n<p>　　14、晒太阳时不要隔着玻璃窗，阳光中的紫外线很少能穿透玻璃窗。而且，要尽量多露出皮肤，增加皮肤对维生素D的合成。</p>\r\n<p>　　一天24小时，补钙最佳时间在早晚。</p>\r\n<p>　　早晨补钙??因为上午一般日照不会很强，可以带孩子多进行户外运动，多晒太阳，适当的运动更有益于钙质的吸收利用。</p>\r\n<p>　　晚睡前补钙??孩子在一日三餐饮食中，可从食物中摄入300毫克～400毫克甚至更多的钙，当体内通过钙调节机制从尿液排出钙时，血液可以随时从食物中得到补充来维持血钙的水平。到了夜间，人体不再进食，而尿液照常会形成，血液中的一部分钙还是不断地进入尿液，于是为了维持正常的血钙水平，人体就不得不动用钙库??骨骼中的钙。这种体内自行调节的结果就使得每天清晨尿液中的钙几乎大部分来自骨钙。另一方面，人体内调节血钙水平的各种激素在白天和夜间的分泌量不同，因而血钙水平一般在夜间较低，白天较高。夜间的低血钙水平也可刺激甲状旁腺素分泌，使骨钙分解加快。持续地消耗骨钙，会出现手脚抽搐等症状。临睡前补钙可以为夜间的这种钙调节提供钙源，阻断体内动用骨钙，有助于孩子更好的成长发育。</p>\r\n<p>　　“春生夏长”从来都是不变的道理，妈妈们一定要抓住孩子补钙的黄金季节。夏季，为孩子科学的补充钙质，让孩子拥有一个受益无穷的成长季。</p>\r\n</div>', 'Joe', '2');
INSERT INTO `t_zxinfo` VALUES ('16', '饮食养生要顺应季节', '2017-05-31 00:45:01', '2017-05-31 00:45:03', '<div class=\"news-content\" deep=\"5\"><p>养生要顺应天时</p><p>一年中有四个季节、二十四个节气，我们生活在大自然中，就一定要顺应大自然的规 律，顺应季节和节气的交替变化。只有顺应了天时，才能保证人的身体健康。早在古代，中 医理论中就有“天人合一”的思想，将大自然的规律与人的生理、病理紧密地联系起来，认 为自然界的变化与人的健康是息息相关的。《黄帝内经》有云：“故智者之养生也，必须顺四 时而适寒暑……如是，则僻邪不至、长生久视。”也就是说，我们的饮食要与当时的气候条 件相适应，达到天与人的协调统一，只有这样才能使人更健康、更长寿。早在两千多年前成 书的《周礼?天官》中就对四季饮食宜忌做了具体的说明，如认为夏季多汗，应多进食羹汤 类饮食，冬季多寒，应适当多用些辛辣的饮料等。</p><p>此外，食性还要与四时气候相适应。《素问?六元正纪大论》指出：“用凉远凉，用寒远 寒，用温远温，用热远热，食宜同法，此其道也。”这就是说，寒冷季节要少吃寒凉性食物， 炎热高温季节要少吃温热性食物，食物要随四季气温而变化。我们在夏天的时候喜欢喝绿豆 粥以消暑解热，冬天的时候喜欢吃涮羊肉以御寒暖体等，就是这个道理。</p><p>四季养生原则</p><p>春季是万物复苏的季节，天气由寒转暖，阳气开始生发，所以春季养生应以平补、清补 为宜。由于春季的气温变化比较大，所以在饮食上，应以高热量的食物为主。此外，冷热刺 激可加速人体内的蛋白质分解，所以还应该注意补充足够的优质蛋白质。.春季，各种细菌和 病毒都开始繁殖，很容易侵犯人体而导致疾病。所以，我们一定要保证摄入充足的维生素和 矿物质，增强抵抗力，防止病毒和细菌的人侵。</p><p>春季是“百草回芽，百病发作”的季节，很容易导致旧病复发，因此身体虚弱的人更应 该特别注意。祖国医学认为：“春日宜省酸增甘，以养脾气。”古人云，春应在肝。春季是肝 气最旺盛的季节，肝亢则伤脾，所以人在春季特别容易出现<a class=\"internal-chain\" href=\"https://www.quyiyuan.com/diseases/4687/\" target=\"_blank\">脾胃虚弱</a>的症状。酸食可使肝功 能偏亢，所以不宜食用，应食用一些具有辛甘升散作用的食品，不但可以健脾益气，还可防止肝气过盛。</p><p>夏季烈日炎炎，气候炎热潮湿，是阳气最盛的季节，应以清淡、苦寒、有营养、易消化 的食物为主。由于夏季的气温比较高，所以特别容易出汗，可是在流汗的过程中，大量的钾 也随着汗液排出了体外。而且大多数人在夏季的时候都没有什么食欲，所摄入的钾也就相对 减少，这样就很容易造成人体缺钾。我们所出现的精神不振、四肢无力、头昏眼花等症状都 是由于缺钾所引起的，严重者还可出现呼吸困难、心跳骤停等症状，甚至威胁生命。</p><p>夏季是病毒和细菌繁殖最快、活动力最强的季节，也是胃肠道疾病的多发季节，因此要 特别注意饮食的卫生与质量问题。此外，在高温环境下，人体内的蛋白质代谢加快，<a class=\"internal-chain\" href=\"https://www.quyiyuan.com/diseases/6090/\" target=\"_blank\">能量</a>消 耗增大，所以应该适量地补充蛋白质。营养学家还建议，高温季节最好每人每天能补充维生 素B1、维生素氏各2毫克，钙1克，这样可减少体内糖类和组织蛋白的消耗，有益于人体 健康。</p><p>秋季天高云淡，气候干燥，气温逐渐下降，天气忽冷忽热，属于阳消阴长的过渡阶段， 因此应以润燥益气为养生要点。由于秋季气候干燥，因此要特别注意补充水分，以防止皮肤 干裂，邪火上侵。秋季的干燥可以分为两种：一是夏末秋初的温燥，二是秋末冬初的<a class=\"internal-chain\" href=\"https://www.quyiyuan.com/diseases/3597/\" target=\"_blank\">凉燥</a>。 温燥应以清热滋润的饮食为主，凉燥应以祛寒滋润的饮食为主。此外，秋季的干燥很容易使 肺受到伤害，发生<a class=\"internal-chain\" href=\"https://www.quyiyuan.com/diseases/387/\" target=\"_blank\">肺炎</a>、<a class=\"internal-chain\" href=\"https://www.quyiyuan.com/diseases/1105/\" target=\"_blank\">哮喘</a>等病症，所以要特别注意保持肺的滋润。</p><p>冬季天气寒冷，在饮食上应以温热、滋补的食物为主，以达到驱寒保暖的目的。俗话说 得好：“三九补一冬，来年无病痛。”这句话虽然有些夸张，但却也有一定的道理。这是因为 在冬季进补可以调节体内的物质代谢，使营养物质转化的能量最大限度地储存在体内，为第 二年的身体健康打好基础。</p><p>在冬季，由于受到寒冷天气的影响，人的甲状腺和肾上腺等分泌腺的分泌量都有所增 加，以促使机体产生热量来抵抗严寒。所以，我们一定要保证能量的供给，适当增加高热量 的食物。医学研究表明，人怕冷与体内缺少矿物质有关，所以保证矿物质的充足也是很重要 的。此外，冬季的气候也很干燥，还应该注意多摄人维生素B2和维生素C。</p><p>四季与疾病</p><p>因为四季的特点各不相同，因此，不同季节的易发疾病也是不同的。每个季节都有一个 相应的脏腑主事，如春季肝脏为主脏、夏季心脏为主脏、长夏脾脏为主脏、秋季肺脏为主 脏、冬季肾脏为主脏。如果人体在某个季节受到外邪的侵犯，那么最先发生病变的一定是与 这个季节相应的主脏。</p><p>此外，四季不同的气候条件也决定了易发疾病的不同。如春季多风，因此多发风病；夏 季炎热，故多发暑病；长夏湿气最重，因此多发湿病；秋季天气干燥，故多发燥病；冬季寒 冷，故寒病比较常见。了解每个季节的易发疾病，就可以采取恰当的预防措施，减小自己的 患病概率。</p><p></p><p>对于那些患有慢<a class=\"internal-chain\" href=\"https://www.quyiyuan.com/diseases/4646/\" target=\"_blank\">性病</a>的人来说，了解各个季节的易发疾病显然更加重要。有些疾病可能 仅在某个特定的季节发病，对于这种季节性疾病，就可以根据四季所主之气推断出发病的季 节，并根据四季与疾病的关系，顺应四季采取有效的治疗措施。《黄帝内经?素问?五常政 大论》曰：“圣人治病，必知天地阴阳四时经纪。”由此可知晓四季在治疗疾病中的重要性。 病人在一天之内的病情是不稳定的，这种病情的起伏也与一天之中的四时变化有关。</p><p>《黄帝内经?灵枢?顺气一日分为四时》中记载了黄帝和岐伯的对话，黄帝问：“夫百病者， 多以旦慧，昼安，夕加，夜甚。何也？ ”意思是病人大多在早晨的时候病情较轻，神智比较 清醒，白天也比较安静，但到傍晚的时候就开始加重，夜晚的时候更加严重，这是什么原因 呢？岐伯答道：“以一日分为四时，朝则为春，日中为夏，日入为秋，夜半为冬。朝则人气 始生，病气衰，故旦慧；日中人气长，长则胜邪，故安；夕则人气始衰，邪气始生，故加； 夜半人气人藏，邪气独居于身，故甚也。”意思是将一天分为四时，早晨有如春天，中午有 如夏天，傍晚有如秋天，夜晚有如冬天。早晨是人体阳气初生的时候，此时病气衰微，因此 病人的神智比较清醒，病情也较轻；中午是人体阳气增长的时候，阳气可以战胜病气，所以 比较安稳；傍晚时人体的阳气开始衰弱，病气开始上涨，因此病情有所加重；到了半夜，人 体的阳气收藏起来，只有病气独存于体内，因此病情是最为严重的。</p><p>四季的饮食宜忌</p><p>了解了四季的气候特点，我们就可以根据不同时期的不同状况，来进行饮食的调理与进 补，顺应天时而促进健康。下面是四季的饮食宜忌，以供参考。</p><p>春季：宜食用花生、豆类、乳制品等热量较高的食物；宜食用奶类、蛋类、鱼类等富含 优质蛋白质的食物；宜食用青菜和水果等维生素含量较高的食物；宜食用大枣、虾仁、香 菜、葱、姜等具有辛甘升散作用的食物；忌食生冷油腻食品和酸食。</p><p>夏季：宜食用苦瓜、芹菜、莴笋、绿茶等苦寒的食物；宜食用水果和蔬菜等富含维生素 和矿物质的食物；宜食用草莓、荔枝、李子等富含钾的食物；忌食肥甘厚味及燥热的食物； 忌食生冷的食物。</p><p>秋季：宜食用黄瓜、梨等清凉多汁的蔬菜和水果；宜食用豆类等高蛋白植物性食物；宜 食用蜂蜜、芝麻、银耳、香蕉等补肺润燥的甘润食物；忌食葱、蒜、姜、辣椒等辛味食品； 忌食烧烤。</p></div>', 'lhb', '2');

-- ----------------------------
-- Table structure for t_zxtype
-- ----------------------------
DROP TABLE IF EXISTS `t_zxtype`;
CREATE TABLE `t_zxtype` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `zxtypename` varchar(255) NOT NULL,
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `author` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_zxtype
-- ----------------------------
INSERT INTO `t_zxtype` VALUES ('1', '健康资讯', '2017-05-19 10:44:36', '2017-05-19 10:44:40', 'Joe');
INSERT INTO `t_zxtype` VALUES ('2', '季节资讯', '2017-05-19 10:44:58', '2017-05-19 10:45:00', 'Joe');
INSERT INTO `t_zxtype` VALUES ('3', '饮食健康', '2017-05-19 10:45:21', '2017-05-19 10:45:23', 'Joe');
