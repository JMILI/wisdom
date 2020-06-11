/*
 Navicat Premium Data Transfer

 Source Server         : smartPatry
 Source Server Type    : MySQL
 Source Server Version : 50641
 Source Host           : localhost:3306
 Source Schema         : wisdom

 Target Server Type    : MySQL
 Target Server Version : 50641
 File Encoding         : 65001

 Date: 23/05/2020 15:52:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for external_student
-- ----------------------------
DROP TABLE IF EXISTS `external_student`;
CREATE TABLE `external_student`  (
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生学号',
  `student_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `student_sex` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `student_hometown` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '籍贯',
  `student_education` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学历',
  `student_homeAddress` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '家庭住址',
  `student_unit` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学习单位',
  `loginIdentity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录身份',
  `student_email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `student_phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号码',
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of external_student
-- ----------------------------
INSERT INTO `external_student` VALUES ('100001', '学生张三', '$2a$10$.9KNkRjmZcqgoygiUARi/O2WeiRxR9pSatAvR5dbWfzd..nQ2CzTm', '男', '陕西省咸阳', '本科', '陕西省咸阳韦曲南', '西安建筑科技大学', '学生', '923749851@qq.com', '17691086155');
INSERT INTO `external_student` VALUES ('100002', '李四', '100002', '女', '陕西省西安', '研究生', '陕西省西安曲江', '西安建筑科技大学', '学生', '923749851@qq.com', '17691086155');
INSERT INTO `external_student` VALUES ('100003', '王3', '$2a$10$PuE20tm31Uvq0EVP8psgB.XMwnqYS1OyHOlyjwrACqlHApB9Sbw06', '男', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100004', '王4', '$2a$10$Tm17wHdoW7LeeXKjX.nCleV4OP3QSQnUoZd/HmfQH4AkZX.o9WP7W', '男', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100005', '王5', '$2a$10$102UOfAPBOipK0zR0nruzOmm.smU.SXym.0BSwsEWlddfARtwTVhe', '男', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100006', '王6', '$2a$10$1h307Z9NjLX/I4kpzGX.EuHnc0D5il6vOsLfTnbp1QGOVdf6dFoDm', '男', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100007', '王7', '$2a$10$rtOKQpbQ/T5/Kc5bDabCBe1N8nZOKa58F3G102sCB0jKqYjVwOp/q', '男', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100008', '王8', '$2a$10$Kz10.jEzgr40/HFhamqTUOQ2KI9fhYujgx/Ug9MNC1cCv8sylCXTG', '男', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100009', '王9', '$2a$10$dQR3cvhs6KGmWeVh6zXWCu4KgAyIeBDSOTZe2zQ6r1sHSRGKcYqWK', '男', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100010', '刘10', '$2a$10$phfOOSquhZlpSX8OMrZvzeS3PbJv7IKpyMr79JkhZlPyT.1Fh7UO2', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100011', '刘11', '$2a$10$4MeuAcNRqzMjhnbSi.CEEeOhEWjBXe4/8ui1r4GhVM0z5EFAN7s02', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100012', '刘12', '$2a$10$vx8Mu4DI.obRuWe9jq0U1u47pgB/RTy0L56SRq2REJi6k3NYs1SxW', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100013', '刘13', '$2a$10$2tkkKOJI31e4CwggtDKGUO2r4w4j4gNxFmHQlQdY.cGHOHJov4q/2', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100014', '刘14', '$2a$10$5nAX0clTqcHiFhFN7YBqo.tnVfSPyqBavGU6drP3EPLCxAOFOfPN2', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100015', '刘15', '$2a$10$Y9V/3NMQMMQSe6SMNMJfOOdb7kZ9V04unvdUTQlfnrNoKhC3NU20i', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100016', '刘16', '$2a$10$vGBS4ZURn5RiRn6emVA0Qu1Krru5so74YxiZNvmD6HBySQ4xARgKO', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100017', '刘17', '$2a$10$QWGQBRGKjJY31xWO4WiireuOcbZtHc5eGuvqdHyZ9l17k.ETHQa3e', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100018', '刘18', '$2a$10$4/Eti4YbyWvIcIeD7uNw5.wsdbQd9cGffmGCda1hcj8vDNOagM3W2', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100019', '刘19', '$2a$10$gTaPqzwxnwS.kjMOydLDAO3a8JkzHpHppYkOGlBLiJ9whxo8mjKOC', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100020', '刘20', '$2a$10$fgYVY8Vb8BzpVw2QoHoKw.CiRlKQ9jXN.7cWzWxZQjFKylSUMY1Sy', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100021', '刘21', '$2a$10$9rNEAl1kUO7L8D3yYBgyxe4E9ua4DkIYRCbzb.Z7AUvOXiFj6/Mo6', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100022', '刘22', '$2a$10$weBNHPd2j6VBq7x8MOmre.dPxMvOCDdRbZc3cRPcUONgLr2uE72iC', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100023', '刘23', '$2a$10$XjzhYsIcCkIEmldxgK9.SeV6uUZyfGu0umAwU3Qa6PqB0kkkwMh76', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100024', '刘24', '$2a$10$Yu2500G856KIs0dMB22Zl.zjsJDsZS5rhYOtqnHfHOYKf16RgD3ou', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100025', '刘25', '$2a$10$Qgc4qzmo/AzjFHFCTruLAu7Ytnt0bWFyi1kaTJFeXJqtycDGzB4xy', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100026', '刘26', '$2a$10$OsFVd468jHeiw7AQeHpNMuqhsUU0b0L/0MPhQX9BmLWgw5iJ3uYce', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100027', '刘27', '$2a$10$bvwLt69zYi.yf0YLw6luQ.LPbJjqm14H2KkTSZGZvCEFxDKrInXRq', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100028', '刘28', '$2a$10$pz6JLVVPz4W8Q7I79Q0HsO81mnrQMNYgjIFDV6YZpayQeVhdoCFXy', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100029', '刘29', '$2a$10$8lQ.SkdHQfuZkBN334QYJOvW1ftY3b7UvDpy.Y498r.jDuglcZY1G', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100030', '刘30', '$2a$10$vknOnmnaxnFN0qPBQJqMROqyqcc13OnKk6zRzokYe/cfA50W.e.ia', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100031', '刘31', '$2a$10$sqGWUCaTs7FCaupEVKPfIuC1qWXDxMZVfiKjXlEDLLbswJTaobYby', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100032', '刘32', '$2a$10$iAtrm0QgtaY1TsVjIC1Pp.6fFDGcXAay4t7e2uQbS/lFvfUNoGRL6', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100033', '刘33', '$2a$10$PPtnjDgThH1UXeWNNgYjqOp8yXqRHBt.0H8ZiqXbfI1jHJVvepXfK', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100034', '刘34', '$2a$10$6mWqNZd4pVD5NIAVGf4HSOZWd5k6MOE7KX4CGd24qRhXwV7Ikywm.', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100035', '刘35', '$2a$10$hJfJeF12KkDvO5xy3.PWQOIEhrD4iMXpT7yJluNt/HjXGaFRseLKy', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100036', '刘36', '$2a$10$.3HzpBUpGzoJpVn8/vS4lunb7JobH/YnN9KwnLI4wG6xck44iHjzG', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100037', '刘37', '$2a$10$5a5fqqXXksVmRPqldDlaUOtHAE5QSq5dqvHaOnUiZCzLo8wZViETC', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100038', '刘38', '$2a$10$V.dzqASRz2npWopDlyTrheOaxwYtSftbaxdVXl9iXLkKjfLSzRyRa', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');
INSERT INTO `external_student` VALUES ('100039', '刘39', '$2a$10$pbTSCjAkuMxMr4UVJFxK9uMgD6lItnEq6/jR.nh3wOYmHNeutwjXW', '女', '陕西省延安市', '本科', '陕西省延安市洛川县果果镇锅锅乡', '西安建筑科技大学嘻嘻与控制工程学院', '学生', '923749851@qq.com', '12456454861');

-- ----------------------------
-- Table structure for external_teacher
-- ----------------------------
DROP TABLE IF EXISTS `external_teacher`;
CREATE TABLE `external_teacher`  (
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教职工号',
  `teacher_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师姓名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `teacher_sex` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `teacher_hometown` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '籍贯',
  `teacher_education` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学历',
  `teacher_homeAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '家庭住址',
  `teacher_unit` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作或学习单位',
  `loginIdentity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录身份，表中可以没有',
  `teacher_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `teacher_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of external_teacher
-- ----------------------------
INSERT INTO `external_teacher` VALUES ('200001', '教师王老', '$2a$10$zlwkGZa.0VmiR.QcGPOtfu592Op78Hk7213AsPZvI5Qyqfzm4aEQu', '男', '西安建筑科技大学', '博士生', '西安建筑科技大学', '西安建筑科技大学', '教师', '923749851@qq.com', '18109210242');
INSERT INTO `external_teacher` VALUES ('200002', '刘老', '200002', '女', '西安建筑科技大学', '博士生', '西安建筑科技大学', '西安建筑科技大学', '教师', '923749851@qq.com', '18109210242');
INSERT INTO `external_teacher` VALUES ('200003', '李3', '$2a$10$8OGH/3qJFMywAsSVGhlVDeWvwaghO/Swrn7W0dVYGPf.ZFmfgq4lu', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200004', '李4', '$2a$10$3n6wBBMjMqntio0BaOrZZu8igSDANwCFgFPG/bbN0Jwak2awfltZ.', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200005', '李5', '$2a$10$HJJ1RsAhqiemsVeffb68xOdQgowOCHfwetzO07Xv7II8Vno4qRpYS', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200006', '李6', '$2a$10$cTPI.tPnPpTBKk1Vt3C5COqTJ4H6i8JF9cwTGaU9Mvx2J.ArI4D.y', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200007', '李7', '$2a$10$LweL74gsXdcClD1ZlatceO7wZ2FzMnyJKoPowL7wfjUSXl9ASRbdy', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200008', '李8', '$2a$10$Ts/ACJB.Ba6fxmuMi34pOOA71RKEW22X4W/EkqlOG3tQ0LhKS4CSG', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200009', '李9', '$2a$10$vNPkhzdf8TITgZnWovjg.O4H34CmZE9Sk3Ns2T7ToAzT6kKu1I0Vu', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200010', '李10', '$2a$10$fxQi0WqGsHv7gsLi7E3RyukAQ49EQa7dGCS/ORWE7XsNAqr1rueGe', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200011', '李11', '$2a$10$hHX1MKZ.vtWJDa7iFYJQ3eHWe26ohrpmvtywjWFj5nSQipH.HwE5a', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200012', '李12', '$2a$10$pMrbSWVXYm8J/qgkzUgYHeQCdm5954rR1TRQ8d2wYQZfojIPkteJW', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200013', '李13', '$2a$10$4x8u2vs9YoXyWnB4/rQz9u8dzYCgD3AM1Qqa/D.gHgeqUw0ZZAFeu', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200014', '李14', '$2a$10$SDV/o1s1eMV1WRhhR5.GGed.fFs1SVanZ5QmGAGhRBNb2Lcamy1/a', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200015', '李15', '$2a$10$xoKhyL2fNEfVAGz27CSjIOVZmJAoaL8rdi1yjj/NqcHXrlWTYOCVy', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200016', '李16', '$2a$10$p67X6HVAS7sGmmt9SQBaTOzWICZ4RxQkaJtMvOKIRGEbq16W7Lb9.', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200017', '李17', '$2a$10$E1lCyxcddUjkctLn3BCOZ.5AjjPL8uRHD4Nf0KgqCP/NON8fL7goG', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200018', '李18', '$2a$10$sXj3QWGqjl9hcQnpz3/zdehPbhuzDCkjaLxO8WlErdBKO.FTatfUG', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200019', '李19', '$2a$10$0/u1XVo/iPsLQ0/n0uyqieRi68RGDg.8zq.DqOWMRv.0K5OuSvSVy', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200020', '李20', '$2a$10$2Md.Yll6vfoVlMNTHiIkwOLY2nWwqjW4AjAA9X65GT6cnLUWCYC52', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200021', '李21', '$2a$10$7Z9ziafRiKhOks9XvC.HdOKE2v24tdKMK/Y7mr70QttIQkGu9SuuG', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200022', '李22', '$2a$10$H38cz5D9eRfQwOs3Si1AU.697nC9tRew/nGyImstXLRu6Sb99fBdK', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200023', '李23', '$2a$10$J0ZN.ZcPXANbI75ubNpXbu08UJAYTXtkBn9sVVusszhGpgPrvFi9u', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200024', '李24', '$2a$10$8As0E8PtOoBVYutiIonAr.OvlHJ3DUJvPfg//3UEA77.M/s6lBt6G', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200025', '李25', '$2a$10$o5lcshgWBJ5KjCOgsk46O.ssIvBsG0iyNdJ6F8oAATxX6mKgKlPwG', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200026', '李26', '$2a$10$wLFY4CC4agnhLsRW/w5lJ.Z3gB5aumGdNoZUlUh3tkUj7Dn8KZeCC', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200027', '李27', '$2a$10$35KTpAj0E.kcLv2Q2cH6uusxKCN.CuvOzpmwxSgGuFnqHkybdGaMa', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200028', '李28', '$2a$10$IVWNcPLOkagAi/.ESqDcj.TXqZisUVK6o2S0OLPxwTdMc8KNJKffm', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200029', '李29', '$2a$10$KMhkeBEpxPOpV0BpDhkK2.JUAcFnLAG.0aBZsMXNeFCSGn29fC4jO', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200030', '李30', '$2a$10$lLU3Zvio/5OrYB6CRilidOcePupxqRCyYhlhYGimDi/DLW3nuYybC', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200031', '李31', '$2a$10$O2OuCEA9oTj1VkTamOvze.hIPmRYw7hR/zdu75nBw0B41vth3P8H6', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200032', '李32', '$2a$10$jd2KZkZqQWZSVjoTjxccwOUxZJj/3mB0d6FuLgi7zhNXNN1pLCaZe', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200033', '李33', '$2a$10$v.ZKGbGp3/RSY30wufJgX.Mdhab.ZLQxyMnZHe.PkELVeMcF7pFrq', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200034', '李34', '$2a$10$jdHSCfUYB.6nxdM9upvDluOeliBnNLxaJfXUftmq7qm952d7I4YLC', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200035', '李35', '$2a$10$TCbWYadRXTpHag/4aZyjZeORX4Tu8ok04ry8ONJDzPZ/wNUuBvU2C', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200036', '李36', '$2a$10$tLRAEdSkC4sfMn1uUVskTuJbZ3XLFDde1vA72DFl8gjPMRc3XbfNu', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200037', '李37', '$2a$10$A1zX5yenX.YR3URec.5v.ONyyW./w9Eb9G6v4NGUz.3odMQOuZob2', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200038', '李38', '$2a$10$6pS3Fcj76l1ltHq.HX0vReoHEkMZ3KD6jMXRuJQOevioFAZz1a9pa', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');
INSERT INTO `external_teacher` VALUES ('200039', '李39', '$2a$10$GCVkB3iyZDpEUrXsKLMqkOz35XcmvV7imv7sQmis6R7CMI4ANzuxm', '男', '陕西咸阳', '博士', '陕西省咸阳市彬州市新民镇', '西南建筑科技大学', '教师', '923456871@qq.com', '12345678974');

-- ----------------------------
-- Table structure for patry_activity
-- ----------------------------
DROP TABLE IF EXISTS `patry_activity`;
CREATE TABLE `patry_activity`  (
  `patry_activity_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动id：年月日时分',
  `patry_activity_theme` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动主题',
  `patry_activity_peopleNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预计参加人数，默认为空',
  `patry_activity_budget` double(255, 0) NULL DEFAULT NULL COMMENT '预算，默认为空',
  `patry_activity_cost` double(255, 0) NULL DEFAULT NULL COMMENT '实际花销',
  `patry_activity_activityTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动时间：这里的时间是描述性文字',
  `patry_activity_loaction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动地理范围',
  `patry_activity_activitySteps` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动步骤',
  `patry_activity_patryUnit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请单位：党支部',
  `patry_activity_applyReason` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请理由',
  `patry_activity_principal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '负责人',
  `patry_activity_principalCall` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '负责人电话',
  `patry_activity_annex` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件',
  `patry_activity_applyTime` datetime(0) NULL DEFAULT NULL COMMENT '申请时间，系统生成',
  `patry_activity_headOpinion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '党总支意见',
  `patry_activity_headHandler` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '党总支审批人',
  `patry_activity_personOpinion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '人事处意见',
  `patry_activity_personHandler` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '人事处审批人',
  `patry_activity_denialReason` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '驳回理由',
  `patry_activity_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态：审核中/审核通过',
  PRIMARY KEY (`patry_activity_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of patry_activity
-- ----------------------------
INSERT INTO `patry_activity` VALUES ('20200511200100', '信控学院党员党员培训', '参与人员：党支部各书记，信控学院团员86人', 2610, 3000, '2020年8月2日到8月10日', '延安', '1.出发，2.出发，3.参观.4.写观后感', '信控学院党总支下属党支部', '增强同学们的红色精神，学习历史，勿忘国耻', '小猪佩奇', '18546987721', '', '2020-05-11 12:01:01', '同意', '哪咤', '同意', '王六码子', '', '审核通过');
INSERT INTO `patry_activity` VALUES ('20200511200103', '青年大学习之延安红色行', '参与人员：党支部各书记，信控学院团员86人', 2610, 3000, '2020年8月2日到8月10日', '延安', '1.出发，2.出发，3.参观.4.写观后感', '信控学院团总支下属党支部', '增强同学们的红色精神，学习历史，勿忘国耻', '小猪佩奇', '18546987721', '', '2020-05-11 12:01:03', '同意', '娜扎', '同意', '华晨宇', '', '审核通过');
INSERT INTO `patry_activity` VALUES ('20200511200105', '青年大学习之延安红色行', '参与人员：党支部各书记，信控学院团员86人', 2610, 3000, '2020年8月2日到8月10日', '延安', '1.出发，2.出发，3.参观.4.写观后感', '信控学院团总支下属党支部', '增强同学们的红色精神，学习历史，勿忘国耻', '小猪佩奇', '18546987721', '', '2020-05-11 12:01:05', '同意', '娜扎', '同意', '小猪洛奇', '', '审核通过');
INSERT INTO `patry_activity` VALUES ('20200511200107', '青年大学习之延安红色行', '参与人员：党支部各书记，信控学院团员86人', 2610, 3000, '2020年8月2日到8月10日', '延安', '1.出发，2.出发，3.参观.4.写观后感', '信控学院团总支下属党支部', '增强同学们的红色精神，学习历史，勿忘国耻', '小猪佩奇', '18546987721', '', '2020-05-11 12:01:08', '不同意', '', '不同意', '', '', '审核中');
INSERT INTO `patry_activity` VALUES ('20200511200109', '青年大学习之延安红色行', '参与人员：党支部各书记，信控学院团员86人', 2610, 3000, '2020年8月2日到8月10日', '延安', '1.出发，2.出发，3.参观.4.写观后感', '信控学院团总支下属党支部', '增强同学们的红色精神，学习历史，勿忘国耻', '小猪佩奇', '18546987721', '', '2020-05-11 12:01:10', '不同意', '', '不同意', '', '', '审核中');

-- ----------------------------
-- Table structure for patry_admin
-- ----------------------------
DROP TABLE IF EXISTS `patry_admin`;
CREATE TABLE `patry_admin`  (
  `patry_admin_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员姓名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '可以是用户名，也可以是id账号，这里用id',
  `patry_admin_unit` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门的全称单位名，如：西安建筑科技大学信控党委下属党支部',
  `loginIdentity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录身份：党总支，人事处，党支部，用于分辨是那个系统',
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of patry_admin
-- ----------------------------
INSERT INTO `patry_admin` VALUES ('300001', '300001', '300001', '信控党总支下属党支部', '党支部');
INSERT INTO `patry_admin` VALUES ('300002', '300002', '300002', '信控党总支', '党总支');
INSERT INTO `patry_admin` VALUES ('300003', '300003', '300003', '信控党总支下属人事处', '人事处');
INSERT INTO `patry_admin` VALUES ('党委李四', '$2a$10$Cep0Ln.tyKWVvRMH6gHbGecq.L2xzUceQrglhA0Qi/Nc0EsYExUcS', '300004', 'topsale@vip.qq.com', '党委');
INSERT INTO `patry_admin` VALUES ('党支部王麻子', '$2a$10$BvGY6Ntf2Qwc6DN1P.fdZ.Kyrp08uAB5VFJdAhxsycw5l7XXbkn1K', '300005', '信息与控制工程学院党总支下属党支部', '党支部');
INSERT INTO `patry_admin` VALUES ('党总支赵大胖', '$2a$10$f/m5rf78RSanCdE/xVwOZeYZNbF4x2B9LRINU70TTSeCf6AsVwGLi', '300006', '建筑学院党总支', '党总支');

-- ----------------------------
-- Table structure for patry_apply
-- ----------------------------
DROP TABLE IF EXISTS `patry_apply`;
CREATE TABLE `patry_apply`  (
  `patry_apply_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '党内申请的id，类似于订单号',
  `patry_apply_username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学工号，注意这包含学生和教师.学生表的username',
  `patry_apply_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请人姓名',
  `patry_apply_workUnit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作或学习单位',
  `patry_apply_patryIdentity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '党内身份：群众/积极分子',
  `patry_apply_call` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `patry_apply_theme` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请主题：积极分子申请，预备党员申请，组织转接申请',
  `patry_apply_patryUnit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所在党部门',
  `patry_apply_applyReason` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请理由',
  `patry_apply_applyAnnex` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请附件',
  `patry_apply_applyTime` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '申请时间',
  `patry_apply_patryPeriod` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '党期：',
  `patry_apply_branchOpinion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '党支部意见',
  `patry_apply_branchHandler` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '党支部审批人',
  `patry_apply_headOpinon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '党总支意见',
  `patry_apply_headHandler` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '党总支审批人',
  `patry_apply_personOpinon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '人事处意见',
  `patry_apply_personHandler` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '人事处审批人',
  `patry_apply_otherOpinion` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '其他部门意见',
  `patry_apply_denialReason` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '驳回理由',
  `patry_apply_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `patry_apply_identity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述申请人身份：教师，学生',
  PRIMARY KEY (`patry_apply_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of patry_apply
-- ----------------------------
INSERT INTO `patry_apply` VALUES ('20200523130645', '100004', '支建1', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:06:45', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130646', '100004', '支建2', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:06:47', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130647', '100004', '支建3', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:06:48', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130648', '100004', '支建4', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:06:49', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130649', '100004', '支建5', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:06:50', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130650', '100004', '支建6', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:06:51', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130651', '100004', '支建7', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:06:52', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130652', '100004', '支建8', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:06:53', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130653', '100004', '支建9', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:06:54', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130654', '100004', '支建10', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:06:55', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130655', '100004', '支建11', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:06:56', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130656', '100004', '支建12', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:06:57', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130657', '100004', '支建13', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:06:58', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130658', '100004', '支建14', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:06:59', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130659', '100004', '支建15', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:00', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130700', '100004', '支建16', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:01', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130701', '100004', '支建17', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:02', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130702', '100004', '支建18', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:03', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130703', '100004', '支建19', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:04', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130704', '100004', '支建20', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:05', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130705', '100004', '支建21', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:06', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130706', '100004', '支建22', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:07', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130707', '100004', '支建23', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:08', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130708', '100004', '支建24', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:09', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130709', '100004', '支建25', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:10', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130710', '100004', '支建26', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:11', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130711', '100004', '支建27', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:12', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130712', '100004', '支建28', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:13', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130713', '100004', '支建29', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:14', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130714', '100004', '支建30', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:15', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130715', '100004', '支建31', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:16', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130716', '100004', '支建32', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:17', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130717', '100004', '支建33', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:18', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130718', '100004', '支建34', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:19', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523130719', '100004', '支建35', '西安安建筑科技大学', '党员', '18109210242', '申请成为积极分子', '建筑学院党总支', '由于本人转学需要，党组织转接', '', '2020-05-23 05:07:20', '201803', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523145503', '100001', '学生张三', '西安建筑科技大学', '预备党员', '17691086155', '申请成为预备党员', '信息与控制工程学院党总支下属党支部', '<div id=\"i4c-draggable-container\" style=\"position: fixed; z-index: 1499; width: 0px; height: 0px;\">\n<div class=\"resolved\" style=\"all: initial;\" data-reactroot=\"\">&nbsp;</div>\n</div>\n<p>&nbsp;</p>\n<div id=\"i4c-dialogs-container\">&nbsp;</div>', NULL, '2020-05-23 06:55:03', '', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');
INSERT INTO `patry_apply` VALUES ('20200523145523', '100001', '学生张三', '西安建筑科技大学', '预备党员', '17691086155', '党内组织关系转接', '信息与控制工程学院党总支下属党支部', '<div id=\"i4c-draggable-container\" style=\"position: fixed; z-index: 1499; width: 0px; height: 0px;\">\n<div class=\"resolved\" style=\"all: initial;\" data-reactroot=\"\">&nbsp;</div>\n</div>\n<p>&nbsp;</p>\n<div id=\"i4c-dialogs-container\">&nbsp;</div>', NULL, '2020-05-23 06:55:23', '', '不同意', '', '不同意', '', '不同意', '', '', '', '审核中', '学生');

-- ----------------------------
-- Table structure for patry_member
-- ----------------------------
DROP TABLE IF EXISTS `patry_member`;
CREATE TABLE `patry_member`  (
  `patry_member_id` bigint(100) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '党员党号',
  `ptray_member_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '党员姓名',
  `ptray_member_sex` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `ptray_member_identity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '党员身份：积极分子，预备党员',
  `ptray_member_period` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年+第几期：（每一个季度一期，取每个季度的首月为第几期，例如201801）',
  `ptray_member_workUnit` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作或学习单位',
  `ptray_member_oldPatryUnit` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原来的工作学习单位',
  `ptray_member_nowPatryUnit` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '现在的工作学习单位',
  `ptray_member_call` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '党员联系方式，电话',
  `patry_member_username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学工号，教职工号',
  PRIMARY KEY (`patry_member_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 400006 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of patry_member
-- ----------------------------
INSERT INTO `patry_member` VALUES (0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000400001, '李四', '男', '积极分子', '', '西安安建筑科技大学', '信息与控制部', '清华大学信科团委', '18109210242', '100013');
INSERT INTO `patry_member` VALUES (0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000400002, '李四', '男', '预备党员', '', '西安安建筑科技大学', '', '信息与控制工程学院党总支下属党支部', '18109210242', '100002');
INSERT INTO `patry_member` VALUES (0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000400003, '李四', '男', '预备党员', '', '西安安建筑科技大学', '', '信息与控制工程学院党总支下属党支部', '18109210242', '100001');
INSERT INTO `patry_member` VALUES (0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000400004, '李四', '男', '积极分子', '', '西安安建筑科技大学', '', '信息与控制工程学院党总支下属党支部', '18109210242', '1000012');
INSERT INTO `patry_member` VALUES (0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000400005, '李四', '男', '积极分子', '', '西安安建筑科技大学', '', '信息与控制工程学院党总支下属党支部', '18109210242', '1000016');

-- ----------------------------
-- Table structure for patry_news
-- ----------------------------
DROP TABLE IF EXISTS `patry_news`;
CREATE TABLE `patry_news`  (
  `patry_new_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告id：年月日时分',
  `patry_new_theme` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告主题',
  `patry_new_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主要内容',
  `patry_new_annex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件：学习材料，可为空',
  `patry_new_time` datetime(0) NOT NULL COMMENT '发布时间，系统时间',
  `patry_new_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发布，未发布',
  PRIMARY KEY (`patry_new_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of patry_news
-- ----------------------------
INSERT INTO `patry_news` VALUES ('20200513204329', '2018年秋季积极分子党员培训0', '主要是积极分子的入党前培训，关于近期党委学习，学习强国，等一系列知识', '', '2020-05-13 12:43:29', '发布');
INSERT INTO `patry_news` VALUES ('20200513204331', '2018年秋季积极分子党员培训2', '主要是积极分子的入党前培训，关于近期党委学习，学习强国，等一系列知识', '', '2020-05-13 12:43:31', '发布');
INSERT INTO `patry_news` VALUES ('20200513204333', '2018年秋季积极分子党员培训4', '主要是积极分子的入党前培训，关于近期党委学习，学习强国，等一系列知识', '', '2020-05-13 12:43:33', '发布');
INSERT INTO `patry_news` VALUES ('20200513204335', '2018年秋季积极分子党员培训6', '主要是积极分子的入党前培训，关于近期党委学习，学习强国，等一系列知识', '', '2020-05-13 12:43:35', '发布');
INSERT INTO `patry_news` VALUES ('20200513204337', '2018年秋季积极分子党员培训8', '主要是积极分子的入党前培训，关于近期党委学习，学习强国，等一系列知识', '', '2020-05-13 12:43:37', '发布');
INSERT INTO `patry_news` VALUES ('20200513204339', '2018年秋季积极分子党员培训10', '主要是积极分子的入党前培训，关于近期党委学习，学习强国，等一系列知识', '', '2020-05-13 12:43:39', '发布');
INSERT INTO `patry_news` VALUES ('20200513204341', '2018年秋季积极分子党员培训12', '主要是积极分子的入党前培训，关于近期党委学习，学习强国，等一系列知识', '', '2020-05-13 12:43:41', '发布');
INSERT INTO `patry_news` VALUES ('20200513204343', '2018年秋季积极分子党员培训14', '主要是积极分子的入党前培训，关于近期党委学习，学习强国，等一系列知识', '', '2020-05-13 12:43:43', '发布');
INSERT INTO `patry_news` VALUES ('20200513204345', '2018年秋季积极分子党员培训16', '主要是积极分子的入党前培训，关于近期党委学习，学习强国，等一系列知识', '', '2020-05-13 12:43:45', '发布');
INSERT INTO `patry_news` VALUES ('20200513204347', '2018年秋季积极分子党员培训18', '主要是积极分子的入党前培训，关于近期党委学习，学习强国，等一系列知识', '', '2020-05-13 12:43:47', '发布');

-- ----------------------------
-- Table structure for patry_organization
-- ----------------------------
DROP TABLE IF EXISTS `patry_organization`;
CREATE TABLE `patry_organization`  (
  `patry_organization_id` bigint(8) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `patry_organization_structureDiagram` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '结构图',
  `patry_organization_staffDistribution` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '人员分布图',
  `patry_organization_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门邮箱',
  `patry_organization_call` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门电话',
  `patry_organization_unit` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门',
  PRIMARY KEY (`patry_organization_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门组织结构图' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
