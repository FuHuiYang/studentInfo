/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50515
Source Host           : 127.0.0.1:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2019-05-09 16:55:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` varchar(100) DEFAULT NULL COMMENT '学号',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `cpp` varchar(100) DEFAULT NULL COMMENT 'C++成绩',
  `circuit` varchar(100) DEFAULT NULL COMMENT '电路成绩',
  `Ewrite` varchar(100) DEFAULT NULL COMMENT '英语读写',
  `Elisten` varchar(100) DEFAULT NULL COMMENT '英语听说',
  `physics` varchar(100) DEFAULT NULL COMMENT '大学物理',
  `probability` varchar(100) DEFAULT NULL COMMENT '概率论',
  `history` varchar(100) DEFAULT NULL COMMENT '近代史',
  `xingzheng` varchar(100) DEFAULT NULL COMMENT '形式与政策',
  `pe` varchar(100) DEFAULT NULL COMMENT '体育成绩',
  `discrete` varchar(100) DEFAULT NULL COMMENT '离散数学',
  `overall` varchar(100) DEFAULT NULL COMMENT '总分',
  `gpa` varchar(100) DEFAULT NULL COMMENT 'GPA'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', '12', '13', '14', '15', '16', '17', '18', '19', '11', '111', '1111', '1345.0', '17.358870967741936');
