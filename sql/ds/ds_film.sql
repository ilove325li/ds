/*
 Navicat MySQL Data Transfer

 Source Server         : 测试
 Source Server Type    : MySQL
 Source Server Version : 80037 (8.0.37)
 Source Host           : localhost:3306
 Source Schema         : ds

 Target Server Type    : MySQL
 Target Server Version : 80037 (8.0.37)
 File Encoding         : 65001

 Date: 31/01/2025 12:07:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ds_film
-- ----------------------------
DROP TABLE IF EXISTS `ds_film`;
CREATE TABLE `ds_film`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `annual` datetime NOT NULL COMMENT '年度（以播出时间为准）\r\n\r\n',
  `tv_series` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电视剧',
  `topic_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '主题内容\r\n以内容准确为目标',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '影视类型（0谍战、1悬疑、2刑侦、3历史、4古装、5武侠、6军旅、7战争、8喜剧、9青春、10言情、11偶像、12家庭、13年代、14革命、15农村、16都市、17其他、18传记、19剧情）',
  `director` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '导演',
  `screenwriter` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '编剧',
  `actor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '主要演员（酌情保留4-5人）\r\n',
  `episode_num` int NULL DEFAULT NULL COMMENT '集数（以电视首播版本为准）',
  `reasons` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '提名理由（基础：2024年4月17日版本（奖项修改）\r\n现状：2024年5月7日版本（说明：蓝色内容为核实无误内容；黄色内容为新增、修正和删除「见删除线」内容；红色为「无主流奖项获奖情况」）',
  `chronological_division` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '年代划分',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '海报图',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '链接',
  `kind` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '影视分类（0电影 1电视剧）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
