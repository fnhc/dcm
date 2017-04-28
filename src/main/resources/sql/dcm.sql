/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : dcm

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-04-16 22:36:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `dept_name` varchar(100) NOT NULL COMMENT '部门名称',
  `dept_desc` varchar(300) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('69a8f0c4260f4bb7adeebdaeee4e6ca6', '风控部', '风险控制部');
INSERT INTO `sys_dept` VALUES ('98819860429e435898d7a0652ed9c5a2', '运营部', '运营部');
INSERT INTO `sys_dept` VALUES ('9eede976904e49b99d7ec416004b7e01', 'aaa', 'aaaaaa');
INSERT INTO `sys_dept` VALUES ('b2574c4028cf4a11b62e1fe430761128', 'bbbb', 'bbb');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `user_id` varchar(50) NOT NULL COMMENT '用户',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `title` varchar(300) DEFAULT NULL COMMENT '日志',
  `url` varchar(300) DEFAULT NULL COMMENT '地址',
  `params` text COMMENT '参数',
  `create_time` datetime DEFAULT NULL COMMENT '日志时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('011004c88ed14e7c965cc662d9341d8a', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户退出系统', '/login/logout', '******', '2017-04-25 16:28:11');
INSERT INTO `sys_log` VALUES ('05260a8d77604a8fbdee195f612e0ba4', '549d321508db446e9bcaa477835fe5f1', 'admin', '删除部门', '/system/dept/delete', '{\"id\":[\"a6da1963ea4847579c0408a91795c6e7\"]}', '2017-04-27 21:36:47');
INSERT INTO `sys_log` VALUES ('053414f8964e4dec8b2d9a3299cc0ee6', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-26 18:26:21');
INSERT INTO `sys_log` VALUES ('0ab60c142ad64b62baaf5abe87d87644', '549d321508db446e9bcaa477835fe5f1', 'admin', '创建部门', '/system/dept/doAdd', '{\"deptName\":[\"aaa\"],\"deptDesc\":[\"aaaaaa\"]}', '2017-04-28 09:56:33');
INSERT INTO `sys_log` VALUES ('0db0d544fe0b4d5680d6b6ee6c2827dd', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-28 10:42:50');
INSERT INTO `sys_log` VALUES ('0dbfa4eb654f4f04b826641f49703e8b', '549d321508db446e9bcaa477835fe5f1', 'admin', '角色分配权限', '/system/role/doAuth', '{\"mid\":[\"d2bc30feb5474a1bb7e02d48d39a3f8a\"],\"roleId\":[\"3b09434ea21d44af98759c112348c725\"]}', '2017-04-17 13:59:47');
INSERT INTO `sys_log` VALUES ('0deeba8723784dbdb5620f3321066dd9', '549d321508db446e9bcaa477835fe5f1', 'admin', '角色分配权限', '/system/role/doAuth', '{\"mid\":[\"d2bc30feb5474a1bb7e02d48d39a3f8a\"],\"roleId\":[\"3b09434ea21d44af98759c112348c725\"]}', '2017-04-17 13:59:43');
INSERT INTO `sys_log` VALUES ('0e04da0ffe0846e59679f47f753ab3f6', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户退出系统', '/login/logout', '******', '2017-04-18 18:05:12');
INSERT INTO `sys_log` VALUES ('0ece7e93dddf4a72b9901a4680ccc3fe', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-25 19:58:11');
INSERT INTO `sys_log` VALUES ('0f200160328547d188c47c3c8f61b2b7', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-20 11:03:45');
INSERT INTO `sys_log` VALUES ('10e3120456c54f0f9e959e1daf982a6f', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-18 15:48:22');
INSERT INTO `sys_log` VALUES ('1143c5583b10484a9679b6b0d04565d0', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-18 18:05:23');
INSERT INTO `sys_log` VALUES ('11bae35914be4f24b997d2288c71417a', '549d321508db446e9bcaa477835fe5f1', 'admin', '删除部门', '/system/dept/delete', '{\"id\":[\"c46a3f14f0444d5a9f9d78617e5ef90c\",\"c46a3f14f0444d5a9f9d78617e5ef90c\"]}', '2017-04-27 21:27:28');
INSERT INTO `sys_log` VALUES ('1e2defd183f24b6bb2a1d5be2746f659', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-18 10:48:27');
INSERT INTO `sys_log` VALUES ('1f5a2630fdc042eaa13dc63bb689fcfe', '549d321508db446e9bcaa477835fe5f1', 'admin', '删除部门', '/system/dept/delete', '{\"id\":[\"7fe8bea86d074bccbf1fd2dbc5b08b7a\"]}', '2017-04-17 14:17:11');
INSERT INTO `sys_log` VALUES ('2219b6886d4743ee9d73db7b649fe3b6', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-17 11:41:43');
INSERT INTO `sys_log` VALUES ('23745d06676d4593862286410a44b2e4', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-17 10:41:57');
INSERT INTO `sys_log` VALUES ('23cf2247b85142cba678409889d573da', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-26 14:35:48');
INSERT INTO `sys_log` VALUES ('271e9dc5548845879c48eb0eb014d97d', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-27 16:00:11');
INSERT INTO `sys_log` VALUES ('2809699e645f4a568a6ed66a36945cfc', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-25 17:47:42');
INSERT INTO `sys_log` VALUES ('2c9bcb9b9b9e41128aca3f773b1a3009', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-26 14:00:30');
INSERT INTO `sys_log` VALUES ('2cfded48572045baa4d30897f9826c76', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-17 13:41:05');
INSERT INTO `sys_log` VALUES ('30efd8ea1af043e097b90068885dd8f5', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-24 18:53:44');
INSERT INTO `sys_log` VALUES ('31464c8b6c3a484c8cb06b82dcafda1c', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-18 17:48:37');
INSERT INTO `sys_log` VALUES ('39fbca9ea4cb43f7afe58d1716001f7b', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-26 13:39:01');
INSERT INTO `sys_log` VALUES ('3e9517dc806c49a7baf0fa033feb8f84', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户退出系统', '/login/logout', '******', '2017-04-26 13:01:57');
INSERT INTO `sys_log` VALUES ('3fc74f15a442438e8b592200f9cfb312', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-25 16:32:08');
INSERT INTO `sys_log` VALUES ('4179b0b5c7094057ad38d67fad15e25d', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-17 10:22:18');
INSERT INTO `sys_log` VALUES ('425fb4dca71841e3ac245cd0f9ab9416', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-27 16:17:17');
INSERT INTO `sys_log` VALUES ('468fa31a454e401fa085498e05d00528', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户退出系统', '/login/logout', '******', '2017-04-21 16:09:00');
INSERT INTO `sys_log` VALUES ('4b17adc59d204c14af4d9c87d53993ca', '549d321508db446e9bcaa477835fe5f1', 'admin', 'sfadsflds', '/system/log/list/1', '{\"cur\":[\"5\"],\"res\":[\"1\"]}', '2017-04-18 17:38:13');
INSERT INTO `sys_log` VALUES ('4b38f35c1a9e4627ba0dae6ffe7ac0de', '549d321508db446e9bcaa477835fe5f1', 'admin', '删除用户', '/system/user/delete', '{\"id\":[\"0737922e1bf04573bec4cb14b8ee1c11\"]}', '2017-04-17 13:48:06');
INSERT INTO `sys_log` VALUES ('4fc6b0e7856d4a84b0f6582e84bd545b', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-24 13:53:02');
INSERT INTO `sys_log` VALUES ('50251d7bcebe413f83a8a2a50e32ea61', '549d321508db446e9bcaa477835fe5f1', 'admin', '删除部门', '/system/dept/delete', '{\"id\":[\"1\"]}', '2017-04-27 21:30:32');
INSERT INTO `sys_log` VALUES ('5058383e92f044c2b2070532e209e325', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-26 17:35:05');
INSERT INTO `sys_log` VALUES ('55a6e0bed30840aa863521b90d63a9b9', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-27 18:57:43');
INSERT INTO `sys_log` VALUES ('55ad6b2d5f524f2a8fa7ac01e0596018', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户退出系统', '/login/logout', '******', '2017-04-17 10:51:27');
INSERT INTO `sys_log` VALUES ('57553f02fbb84c8c9c0a1d8d4430a6ed', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户退出系统', '/login/logout', '******', '2017-04-18 15:48:00');
INSERT INTO `sys_log` VALUES ('57dc9f50d25f4659848d9051f99efd0f', '549d321508db446e9bcaa477835fe5f1', 'admin', '创建部门', '/system/dept/doAdd', '{\"deptDesc\":[\"afdsf\"],\"deptName\":[\"asdf\"]}', '2017-04-17 14:17:04');
INSERT INTO `sys_log` VALUES ('5e44e7267af24b1199fcc7277b40fc52', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-25 18:44:16');
INSERT INTO `sys_log` VALUES ('60337ad4665245e8847cf4ccb071e1ee', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-26 13:53:19');
INSERT INTO `sys_log` VALUES ('612ee6a9f2d243eca897799ac7e76cf9', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-26 18:04:17');
INSERT INTO `sys_log` VALUES ('631f60f5a35345cc982d3ad5b3d560b2', '549d321508db446e9bcaa477835fe5f1', 'admin', '创建部门', '/system/dept/doAdd', '{\"deptName\":[\"bbbb\"],\"deptDesc\":[\"bbb\"]}', '2017-04-28 09:56:58');
INSERT INTO `sys_log` VALUES ('6387feeb1a76469f9a6d5bf42fc13784', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-24 16:02:26');
INSERT INTO `sys_log` VALUES ('63e591fee4874979a699978fc6e9363a', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-16 22:24:42');
INSERT INTO `sys_log` VALUES ('64a03c82b582469c89d01d4f9889c503', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-17 10:41:57');
INSERT INTO `sys_log` VALUES ('653d616aabcd47e9a0e16b8ee8704e2f', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户退出系统', '/login/logout', '******', '2017-04-27 14:50:38');
INSERT INTO `sys_log` VALUES ('6580225f4933455fb735a5f4254d9bd8', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-27 16:09:10');
INSERT INTO `sys_log` VALUES ('6765e7f308da41c0a1da096fe7d4e8fd', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-28 09:55:33');
INSERT INTO `sys_log` VALUES ('689867cd160b482dab3271f90db76ca3', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-17 10:16:22');
INSERT INTO `sys_log` VALUES ('699b3439be4549d49ad99881bbc75483', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-28 11:20:03');
INSERT INTO `sys_log` VALUES ('6b39312c43c344bc84dc78643a8c009a', '549d321508db446e9bcaa477835fe5f1', 'admin', '创建用户', '/system/user/doAdd', '{\"deptId\":[\"1\"],\"password\":[\"123456\"],\"password2\":[\"123456\"],\"roleId\":[\"2a9b728a431246b08f853c2529e6ba84\",\"ab840c7c80a441748aafc6334ee18b01\"],\"userDesc\":[\"test\"],\"userName\":[\"testzf\"],\"userState\":[\"1\"]}', '2017-04-17 13:47:12');
INSERT INTO `sys_log` VALUES ('6b48266c8c284d3aa9dcdc3d9fa05932', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-24 20:19:11');
INSERT INTO `sys_log` VALUES ('6d9150653c884d5598b0f5c73f542e31', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户退出系统', '/login/logout', '******', '2017-04-25 16:44:56');
INSERT INTO `sys_log` VALUES ('6e4e1c451b354c9d83c08a12a6d912d1', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-25 19:32:40');
INSERT INTO `sys_log` VALUES ('70820b1c4e5c411197ad626a4d9e2e61', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-20 10:06:17');
INSERT INTO `sys_log` VALUES ('71c3a8814ad64331b8700a75215e92e1', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户退出系统', '/login/logout', '******', '2017-04-16 22:24:14');
INSERT INTO `sys_log` VALUES ('71f9f7d36b644aeeb460ec8a38fce43f', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-17 10:54:06');
INSERT INTO `sys_log` VALUES ('7a3467fa0af84c6aa57a13cc65d885c6', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-24 15:18:57');
INSERT INTO `sys_log` VALUES ('7f69a148fddc45f592809b57ad43158a', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-25 18:22:55');
INSERT INTO `sys_log` VALUES ('8241941578d24809b930053273f80016', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户退出系统', '/login/logout', '******', '2017-04-25 16:27:49');
INSERT INTO `sys_log` VALUES ('82527513aa28493689babd10776dc0dd', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-25 18:53:30');
INSERT INTO `sys_log` VALUES ('828bfe142ad745109f14b30f3bf1009a', '549d321508db446e9bcaa477835fe5f1', 'admin', '删除部门', '/system/dept/delete', '{\"id\":[\"c46a3f14f0444d5a9f9d78617e5ef90c\"]}', '2017-04-27 21:30:20');
INSERT INTO `sys_log` VALUES ('85ca42d0012841f8af562568648c80ed', '549d321508db446e9bcaa477835fe5f1', 'admin', '编辑部门', '/system/dept/doEdit', '{\"deptDesc\":[\"2222\"],\"deptName\":[\"产品部\"],\"id\":[\"1\"]}', '2017-04-17 14:14:56');
INSERT INTO `sys_log` VALUES ('870ddbb791054d848bff25634411578a', '549d321508db446e9bcaa477835fe5f1', 'admin', '创建用户', '/system/user/doAdd', '{\"deptId\":[\"1\"],\"password\":[\"111111\"],\"password2\":[\"111111\"],\"roleId\":[\"3b09434ea21d44af98759c112348c725\"],\"userDesc\":[\"\"],\"userName\":[\"zhangsan12\"],\"userState\":[\"1\"]}', '2017-04-17 14:01:22');
INSERT INTO `sys_log` VALUES ('89f0d226cdac4a5a98eab5d0c149396a', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-24 14:45:35');
INSERT INTO `sys_log` VALUES ('8acef1f26d954138a911760a5eed3eae', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-27 19:16:41');
INSERT INTO `sys_log` VALUES ('8b58bab784fa406e8a4abdd3b3f11ebf', '549d321508db446e9bcaa477835fe5f1', 'admin', '删除部门', '/system/dept/delete', '{\"id\":[\"aebe7d9b427643feb9c5a66c65fb9a81\"]}', '2017-04-27 21:33:00');
INSERT INTO `sys_log` VALUES ('8c6a5f8bd28340448fd3d487b05bc1c2', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-19 17:44:57');
INSERT INTO `sys_log` VALUES ('8c96df279c6c4a8498b7e63b40471769', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-24 10:23:18');
INSERT INTO `sys_log` VALUES ('9105907a00c848ca9a28579f3a236def', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-26 11:21:20');
INSERT INTO `sys_log` VALUES ('988c0c41a3c14851a0ed2ef84bcae6a1', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-18 17:11:20');
INSERT INTO `sys_log` VALUES ('9a8ec10db03041a983154ce05fd4fe2e', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-18 18:40:39');
INSERT INTO `sys_log` VALUES ('9b9bda5ff1814b3d93e0b3c7f71eb0f1', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-21 16:09:08');
INSERT INTO `sys_log` VALUES ('9ba010a557884d78ac2c25c2f5ef5d7f', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-25 15:02:29');
INSERT INTO `sys_log` VALUES ('9fc6aebf40ff488084220670baa10530', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户退出系统', '/login/logout', '******', '2017-04-18 17:48:14');
INSERT INTO `sys_log` VALUES ('a05c8de05c284afabde099896db4bc6b', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-24 18:57:03');
INSERT INTO `sys_log` VALUES ('a16175a5fd9e446da6d6e5bcec1716d5', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户退出系统', '/login/logout', '******', '2017-04-19 17:49:03');
INSERT INTO `sys_log` VALUES ('a53267ba1c9f49dc84f1ae9d23c719a3', '549d321508db446e9bcaa477835fe5f1', 'admin', '创建用户', '/system/user/doAdd', '{\"deptId\":[\"1\"],\"password\":[\"111111\"],\"password2\":[\"111111\"],\"roleId\":[\"2a9b728a431246b08f853c2529e6ba84\"],\"userDesc\":[\"fsafds\"],\"userName\":[\"aaa\"],\"userState\":[\"1\"]}', '2017-04-18 17:30:53');
INSERT INTO `sys_log` VALUES ('a64db273c2e04609a192cda42d57aeb7', '549d321508db446e9bcaa477835fe5f1', 'admin', '编辑部门', '/system/dept/doEdit', '{\"deptDesc\":[\"订单dd\"],\"deptName\":[\"几点开始\"],\"id\":[\"3d2cd829c0e74221b806a3b49c7e2e05\"]}', '2017-04-17 14:16:44');
INSERT INTO `sys_log` VALUES ('a771a24628084dbf9b6f849e8fb0fe4c', '549d321508db446e9bcaa477835fe5f1', 'admin', '删除用户', '/system/user/delete', '{\"id\":[\"42932bb049ac4e1d95c230870e6e8b95\"]}', '2017-04-17 11:14:48');
INSERT INTO `sys_log` VALUES ('a81a81cded45476fb0dda852ab4d8e63', '549d321508db446e9bcaa477835fe5f1', 'admin', '删除部门', '/system/dept/delete', '{\"id\":[\"3d2cd829c0e74221b806a3b49c7e2e05\"]}', '2017-04-17 14:16:50');
INSERT INTO `sys_log` VALUES ('a9f2ab089aaf4526b52ce10f01a50248', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户退出系统', '/login/logout', '******', '2017-04-26 18:04:14');
INSERT INTO `sys_log` VALUES ('a9ff3d931b8145b7b3ca1637bc4101b2', '549d321508db446e9bcaa477835fe5f1', 'admin', '创建部门', '/system/dept/doAdd', '{\"deptName\":[\"d\"],\"deptDesc\":[\"okk\"]}', '2017-04-27 16:11:45');
INSERT INTO `sys_log` VALUES ('ad05adaf818149cbb10977a5110f9b82', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-27 11:14:55');
INSERT INTO `sys_log` VALUES ('b096757607f34a5598a0eb8b3d640430', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-28 10:02:57');
INSERT INTO `sys_log` VALUES ('b3bc5695bd254a7db972d221761f44d6', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-18 16:19:09');
INSERT INTO `sys_log` VALUES ('b5b2d7d481444e238e858a2ea19c15a5', '549d321508db446e9bcaa477835fe5f1', 'admin', '删除部门', '/system/dept/delete', '{\"id\":[\"1\",\"1\"]}', '2017-04-27 21:24:58');
INSERT INTO `sys_log` VALUES ('ba927ea6cff9400daa91692fc234f0ab', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-18 15:27:02');
INSERT INTO `sys_log` VALUES ('bd9e8393e4414129ab09e58aef53face', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-27 19:07:52');
INSERT INTO `sys_log` VALUES ('c1bca92670924b039d335d8cb12f5546', '549d321508db446e9bcaa477835fe5f1', 'admin', '角色分配权限', '/system/role/doAuth', '{\"mid\":[\"d2bc30feb5474a1bb7e02d48d39a3f8a\"],\"roleId\":[\"3b09434ea21d44af98759c112348c725\"]}', '2017-04-17 13:59:34');
INSERT INTO `sys_log` VALUES ('c1de5fe279754ac08f4b10e8f7802470', '549d321508db446e9bcaa477835fe5f1', 'admin', '删除部门', '/system/dept/delete', '{\"id\":[\"e6481cd9f33542959f2daa2f495e34e8\"]}', '2017-04-17 14:15:07');
INSERT INTO `sys_log` VALUES ('c2588df9843947ae9fdd64fa52d09d7f', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-19 15:18:59');
INSERT INTO `sys_log` VALUES ('c47bd0845d464cc9bc188dd8e7f9fb15', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-25 17:34:30');
INSERT INTO `sys_log` VALUES ('c4b5da54186745639cdf7b2f433f6881', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-17 10:51:39');
INSERT INTO `sys_log` VALUES ('c855c3c35a154349ad1dac6f4d6178c1', '549d321508db446e9bcaa477835fe5f1', 'admin', '编辑角色', '/system/role/doEdit', '{\"id\":[\"3b09434ea21d44af98759c112348c725\"],\"roleDesc\":[\"测试角色222\"],\"roleName\":[\"test\"],\"roleState\":[\"1\"]}', '2017-04-17 13:58:43');
INSERT INTO `sys_log` VALUES ('c8fd3f5434c1489ea38bf5fca0093801', '549d321508db446e9bcaa477835fe5f1', 'admin', '创建角色', '/system/role/doAdd', '{\"roleDesc\":[\"测试角色\"],\"roleName\":[\"test\"],\"roleState\":[\"1\"]}', '2017-04-17 13:58:22');
INSERT INTO `sys_log` VALUES ('c979e6b2737b4e969f407dc76a342ed8', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-27 13:59:21');
INSERT INTO `sys_log` VALUES ('cdbf87c4a1ea4da49283b09d48677bed', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-16 22:32:20');
INSERT INTO `sys_log` VALUES ('ce7fe64e508143b3b82d494fa888ac26', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-27 15:47:01');
INSERT INTO `sys_log` VALUES ('d01ecbafbaf64799a1a9c8fba176de25', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-25 16:25:03');
INSERT INTO `sys_log` VALUES ('d3103ca37f6f44b5b1aab2e737a5ade1', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-27 10:56:33');
INSERT INTO `sys_log` VALUES ('d71693c88cd74bc186da9c62a0bfee48', '549d321508db446e9bcaa477835fe5f1', 'admin', '删除部门', '/system/dept/delete', '{\"id\":[\"c46a3f14f0444d5a9f9d78617e5ef90c\",\"c46a3f14f0444d5a9f9d78617e5ef90c\"]}', '2017-04-27 21:30:07');
INSERT INTO `sys_log` VALUES ('d8e98b0bd3c342148cf52b95d12520b0', '549d321508db446e9bcaa477835fe5f1', 'admin', '删除角色', '/system/role/delete', '{\"id\":[\"3b09434ea21d44af98759c112348c725\"]}', '2017-04-17 14:01:59');
INSERT INTO `sys_log` VALUES ('dcb7ea83bcd94c098ee822507b5619a1', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-25 19:19:51');
INSERT INTO `sys_log` VALUES ('dd21615d08324a648b4345a57a4cbef3', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户退出系统', '/login/logout', '******', '2017-04-25 16:24:55');
INSERT INTO `sys_log` VALUES ('ddaaea9ff08c43429d42cec05f49b13c', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-24 17:41:12');
INSERT INTO `sys_log` VALUES ('df07d27ed0ed45918eb49e65f1c25d0e', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-26 10:19:02');
INSERT INTO `sys_log` VALUES ('e045d66f48bb4d328386e821b6465e8c', '549d321508db446e9bcaa477835fe5f1', 'admin', '编辑用户', '/system/user/doEdit', '{\"deptId\":[\"1\"],\"id\":[\"0737922e1bf04573bec4cb14b8ee1c11\"],\"roleId\":[\"2a9b728a431246b08f853c2529e6ba84\"],\"userDesc\":[\"testaaaa\"],\"userName\":[\"testzf\"],\"userState\":[\"1\"]}', '2017-04-17 13:47:26');
INSERT INTO `sys_log` VALUES ('e2c8145a6d2b45b697f2f6ca7aed3bb6', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-27 18:44:07');
INSERT INTO `sys_log` VALUES ('e69bc6b61188491e981a75f9646622cd', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-21 16:04:27');
INSERT INTO `sys_log` VALUES ('e79c66c7468f4e7f9a4b3f0b99b948d7', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-27 15:52:41');
INSERT INTO `sys_log` VALUES ('e9bffc510589421fb1032e848bcf8db0', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-17 11:33:14');
INSERT INTO `sys_log` VALUES ('eca3ec586b484b2190846af00cf66794', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-25 18:38:39');
INSERT INTO `sys_log` VALUES ('ef8c07b3a680471c9fc283763de691c1', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-25 17:04:28');
INSERT INTO `sys_log` VALUES ('f1b2bcb91f4043d6a0a52284f1fcadc6', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-26 16:35:45');
INSERT INTO `sys_log` VALUES ('f36fc4c9bb664088a507295dbbb242e0', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-25 16:27:59');
INSERT INTO `sys_log` VALUES ('f86b8f57567648148479e4a6139ea9b5', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-26 12:50:25');
INSERT INTO `sys_log` VALUES ('f9fc600099d94cec8e2d23700dea450c', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-25 18:41:22');
INSERT INTO `sys_log` VALUES ('fce256060d334fb885508c50517bf571', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-27 18:58:06');
INSERT INTO `sys_log` VALUES ('fe0b163ae04c494cb42e6034d42adb49', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-26 13:02:15');
INSERT INTO `sys_log` VALUES ('ff2339d4a7a34464a5dc4f8133262bdd', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-17 10:28:05');
INSERT INTO `sys_log` VALUES ('ff334d09e87147549c36e5ddd68f006c', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-27 20:29:39');
INSERT INTO `sys_log` VALUES ('ffc429b3d0104d6e962fa96f2d92101d', '549d321508db446e9bcaa477835fe5f1', 'admin', '用户登录成功', '/login/doLogin', '******', '2017-04-26 14:17:42');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `pid` varchar(50) NOT NULL COMMENT '父级菜单ID',
  `url` varchar(255) DEFAULT NULL COMMENT '连接地址',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `deep` int(11) DEFAULT NULL COMMENT '深度',
  `code` varchar(50) DEFAULT NULL COMMENT '编码',
  `resource` varchar(50) DEFAULT NULL COMMENT '资源名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('0818e1c76bbd44eba3a698547ec4e637', '查询系统设置', '10', null, null, '0', '3', '010600', 'listSetting');
INSERT INTO `sys_menu` VALUES ('0c9b5fc8b44b41d1871a8fc8300247ec', '删除菜单', '4', null, null, '4', '3', '010303', 'deleteMenu');
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', null, 'fa fa-cogs', '1', '1', '01', null);
INSERT INTO `sys_menu` VALUES ('10', '系统配置', '1', '/system/setting', ' fa-cog', '6', '2', '0106', 'setting');
INSERT INTO `sys_menu` VALUES ('1db9105008404a3485b6fac30dba3c0e', '查看角色列表', '3', null, null, '0', '3', '010200', 'listRole');
INSERT INTO `sys_menu` VALUES ('2', '用户管理', '1', '/system/user', 'fa-user-circle-o', '1', '2', '0101', 'user');
INSERT INTO `sys_menu` VALUES ('22e38e885f9b40b9aae6a36deb78e89c', '部门管理', '1', '/system/dept', 'fa-graduation-cap', '4', '2', '0104', 'dept');
INSERT INTO `sys_menu` VALUES ('3', '角色管理', '1', '/system/role', 'fa-users', '2', '2', '0102', 'role');
INSERT INTO `sys_menu` VALUES ('363a778e78a346a68210b2590163a943', '编辑部门', '22e38e885f9b40b9aae6a36deb78e89c', null, null, '2', '3', '010402', 'editDept');
INSERT INTO `sys_menu` VALUES ('3f26102ef0e04c3c9328cb97067cc5fa', '创建菜单', '4', null, null, '1', '3', '010301', 'addMenu');
INSERT INTO `sys_menu` VALUES ('3fb6a7a5935b4efabf3de82e7e1baeb6', '新增部门', '22e38e885f9b40b9aae6a36deb78e89c', null, null, '1', '3', '010401', 'addDept');
INSERT INTO `sys_menu` VALUES ('4', '菜单管理', '1', '/system/menu', 'fa-list', '3', '2', '0103', 'menu');
INSERT INTO `sys_menu` VALUES ('4253190001c1480fb0d631d64d150535', '编辑用户', '2', null, null, '2', '3', '010102', 'editUser');
INSERT INTO `sys_menu` VALUES ('42dd5ae31e3a43b3a197440e8ec19a94', '监控列表', 'f5a20c82110b4a3ea9e30ca01a038680', null, null, '1', '3', '010701', 'monitorList');
INSERT INTO `sys_menu` VALUES ('488ef1eff57b4827acade7c0744278ce', '查看菜单列表', '4', null, null, '0', '3', '010300', 'listMenu');
INSERT INTO `sys_menu` VALUES ('4e816a9854714d24b0413d929d637a2b', '查看部门列表', '22e38e885f9b40b9aae6a36deb78e89c', null, null, '0', '3', '010400', 'listDept');
INSERT INTO `sys_menu` VALUES ('5', '业务日志', '1', '/system/log', 'fa-info-circle', '5', '2', '0105', 'log');
INSERT INTO `sys_menu` VALUES ('5d3dd56c16ff4e32aecae1b3228159c7', '查看日志列表', '5', null, null, '0', '3', '010500', 'listLog');
INSERT INTO `sys_menu` VALUES ('60dda993d87647f5989c15f14f866df9', '新增角色', '3', null, null, '1', '3', '010201', 'addRole');
INSERT INTO `sys_menu` VALUES ('649b484b58414d91aefa5a26143e6557', '删除用户', '2', null, null, '3', '3', '010103', 'deleteUser');
INSERT INTO `sys_menu` VALUES ('686630c7cb624cc786dcdc9958971a6b', '编辑角色', '3', null, null, '2', '3', '010202', 'editRole');
INSERT INTO `sys_menu` VALUES ('79d78b8357174cac8f44abd275dec597', '删除部门', '22e38e885f9b40b9aae6a36deb78e89c', null, null, '3', '3', '010403', 'deleteDept');
INSERT INTO `sys_menu` VALUES ('915c309ebe5047b68645b3eb777dd8c9', '操作系统设置', '10', null, null, '1', '3', '010601', 'doSetting');
INSERT INTO `sys_menu` VALUES ('a5ebf29168234406939856bc6890c86b', '角色授权', '3', null, null, '4', '3', '010204', 'authRole');
INSERT INTO `sys_menu` VALUES ('a73802e513cc4465883530ec8074abbb', '新增用户', '2', null, null, '1', '3', '010101', 'addUser');
INSERT INTO `sys_menu` VALUES ('b4e7232189b14cf3ba160cf7b0d3bf37', '删除角色', '3', null, null, '3', '3', '010203', 'deleteRole');
INSERT INTO `sys_menu` VALUES ('d2bc30feb5474a1bb7e02d48d39a3f8a', '查看用户列表', '2', null, null, '0', '3', '010100', 'listUser');
INSERT INTO `sys_menu` VALUES ('dc5f478d98ed4297a8ae638fe90df050', '编辑菜单', '4', null, null, '3', '3', '010302', 'editMenu');
INSERT INTO `sys_menu` VALUES ('f5a20c82110b4a3ea9e30ca01a038680', '系统监控', '1', '/system/monitor', 'fa-eye', '7', '2', '0107', null);
INSERT INTO `sys_menu` VALUES ('f899f3d3baec4571b1c786717f9906fd', '批量删除角色', '3', null, null, '5', '3', '010205', 'deleteBatchRole');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `role_desc` varchar(300) DEFAULT NULL COMMENT '角色描述',
  `role_state` int(2) DEFAULT '1' COMMENT '状态,1-启用,-1禁用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('2a9b728a431246b08f853c2529e6ba84', '测试角色', '测试', '1', '2017-02-28 15:15:41');
INSERT INTO `sys_role` VALUES ('737933bffef640329a4f864c4e2746ba', '超级管理员', 'ut', '1', '2016-12-14 10:22:34');
INSERT INTO `sys_role` VALUES ('a21876314a764438b6af6bfa422ec09a', '系统管理员', '111118455', '1', '2016-12-14 17:53:25');
INSERT INTO `sys_role` VALUES ('ab7e4b34e5d141fa8566fdbb5d3e66f7', '报表管理员', 'dasdasdas', '-1', '2016-12-15 20:00:21');
INSERT INTO `sys_role` VALUES ('ab840c7c80a441748aafc6334ee18b01', '合伙人', '合伙人', '1', '2017-02-28 15:16:03');
INSERT INTO `sys_role` VALUES ('fdce142ce7554e30b3274c6d8844b13e', '商品管理员', 'fdfdfdf', '-1', '2016-12-15 19:59:59');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `role_id` varchar(50) NOT NULL COMMENT '角色主键',
  `menu_id` varchar(50) NOT NULL COMMENT '菜单主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('0685b1490a3a4e62a2b69199f964de2a', 'ab7e4b34e5d141fa8566fdbb5d3e66f7', 'd2bc30feb5474a1bb7e02d48d39a3f8a');
INSERT INTO `sys_role_menu` VALUES ('094cd616baff446abe596eeb1840655d', '737933bffef640329a4f864c4e2746ba', '488ef1eff57b4827acade7c0744278ce');
INSERT INTO `sys_role_menu` VALUES ('0fe299991729490998507b76c74157f4', '737933bffef640329a4f864c4e2746ba', 'f5a20c82110b4a3ea9e30ca01a038680');
INSERT INTO `sys_role_menu` VALUES ('121b1db2c51d4d3ba7b8c0ebc3e1e32e', 'a21876314a764438b6af6bfa422ec09a', '2');
INSERT INTO `sys_role_menu` VALUES ('184410493f344d66b91f716f37e6b4d1', '737933bffef640329a4f864c4e2746ba', '3f26102ef0e04c3c9328cb97067cc5fa');
INSERT INTO `sys_role_menu` VALUES ('1c6642cb915442359d9fc2543b5a8c79', 'a21876314a764438b6af6bfa422ec09a', '488ef1eff57b4827acade7c0744278ce');
INSERT INTO `sys_role_menu` VALUES ('1d28941baa004444914d35f6df998f06', '737933bffef640329a4f864c4e2746ba', '3fb6a7a5935b4efabf3de82e7e1baeb6');
INSERT INTO `sys_role_menu` VALUES ('1e0e01a71b8842e7ac203036f7384685', 'ab7e4b34e5d141fa8566fdbb5d3e66f7', '4253190001c1480fb0d631d64d150535');
INSERT INTO `sys_role_menu` VALUES ('1e6708761c724b98bbf5fb6de94e5c92', '737933bffef640329a4f864c4e2746ba', 'b4e7232189b14cf3ba160cf7b0d3bf37');
INSERT INTO `sys_role_menu` VALUES ('215221a2475f41ffb35d0e2429236a43', '737933bffef640329a4f864c4e2746ba', '5e81d5e44e87489486c0bc9982f80953');
INSERT INTO `sys_role_menu` VALUES ('21629df3640f4ccdb74c597142840ddd', 'a21876314a764438b6af6bfa422ec09a', '3f26102ef0e04c3c9328cb97067cc5fa');
INSERT INTO `sys_role_menu` VALUES ('2206b8a75e484ccabfce6a086e14bb43', 'ab7e4b34e5d141fa8566fdbb5d3e66f7', '2');
INSERT INTO `sys_role_menu` VALUES ('2e5f414e1c2a4cf689a29579a070f300', '737933bffef640329a4f864c4e2746ba', '3');
INSERT INTO `sys_role_menu` VALUES ('30b8decf6dc8472b924cc42bc7ba8b22', '737933bffef640329a4f864c4e2746ba', '4e816a9854714d24b0413d929d637a2b');
INSERT INTO `sys_role_menu` VALUES ('35c27b37c89c4e6ca7160ef320329961', '1d0d43b9fbbe4c078beb4a732309fe64', '1');
INSERT INTO `sys_role_menu` VALUES ('3aceb6111772490e9887904fb54949e3', 'eb2e1fa3caa448658da909cf141788f8', '9');
INSERT INTO `sys_role_menu` VALUES ('3b6b089b7c5b41a6ac9d8ae131e9f6e6', '737933bffef640329a4f864c4e2746ba', '915c309ebe5047b68645b3eb777dd8c9');
INSERT INTO `sys_role_menu` VALUES ('47266e284424443e9b5f9f9fe520d2af', '737933bffef640329a4f864c4e2746ba', '79d78b8357174cac8f44abd275dec597');
INSERT INTO `sys_role_menu` VALUES ('47f27767c3dd4a04b9a5c8ed1c85a0a8', '737933bffef640329a4f864c4e2746ba', '2');
INSERT INTO `sys_role_menu` VALUES ('48dd8350fb7a4c3cb4406cbfa78aa524', 'a21876314a764438b6af6bfa422ec09a', '1');
INSERT INTO `sys_role_menu` VALUES ('4ebaa3233b8d4a85a7bfd102648e3d24', '737933bffef640329a4f864c4e2746ba', '686630c7cb624cc786dcdc9958971a6b');
INSERT INTO `sys_role_menu` VALUES ('50b1ad1b1a2f4665bc836a84fea6c03b', '737933bffef640329a4f864c4e2746ba', 'a5ebf29168234406939856bc6890c86b');
INSERT INTO `sys_role_menu` VALUES ('537af500a6b9442eb71e0d77a1ea4841', '1d0d43b9fbbe4c078beb4a732309fe64', '9');
INSERT INTO `sys_role_menu` VALUES ('56176877b80a44a99748394a9a22eb81', '737933bffef640329a4f864c4e2746ba', '4');
INSERT INTO `sys_role_menu` VALUES ('587532069c02418c85ebed37efdda36c', '737933bffef640329a4f864c4e2746ba', '4253190001c1480fb0d631d64d150535');
INSERT INTO `sys_role_menu` VALUES ('5b9d3b6ce4fb451593609f4c20cfaa46', '737933bffef640329a4f864c4e2746ba', '5');
INSERT INTO `sys_role_menu` VALUES ('5ed4753090bc42b5bbc364e52352ebaa', '737933bffef640329a4f864c4e2746ba', 'cfba837d402c4bf89fe46977bbfb1a29');
INSERT INTO `sys_role_menu` VALUES ('5fd8b7b90b0145e3b866272ee3507dd9', '737933bffef640329a4f864c4e2746ba', '0c9b5fc8b44b41d1871a8fc8300247ec');
INSERT INTO `sys_role_menu` VALUES ('613112d120d642bbb83810d07a96e477', '2a9b728a431246b08f853c2529e6ba84', '2');
INSERT INTO `sys_role_menu` VALUES ('6c4d931cca3e45a2ad057dd0ee572921', '737933bffef640329a4f864c4e2746ba', '363a778e78a346a68210b2590163a943');
INSERT INTO `sys_role_menu` VALUES ('6f41c85dd5174f78ad2db183db359b55', 'a21876314a764438b6af6bfa422ec09a', '4');
INSERT INTO `sys_role_menu` VALUES ('712118e6fe374f92b3beaffc1019952a', 'f08487637b0d4bfc9accc14cbca6f1cd', '3');
INSERT INTO `sys_role_menu` VALUES ('750868dfc79a4a32841da56d1601a8d1', 'f08487637b0d4bfc9accc14cbca6f1cd', '1');
INSERT INTO `sys_role_menu` VALUES ('751c70822c264d079fa6ec042e086294', '737933bffef640329a4f864c4e2746ba', '42dd5ae31e3a43b3a197440e8ec19a94');
INSERT INTO `sys_role_menu` VALUES ('77fd54d3ab0d4eaa8605346d93095eb9', 'eb2e1fa3caa448658da909cf141788f8', '8');
INSERT INTO `sys_role_menu` VALUES ('7a995a34d76f458189e0833202b39377', '737933bffef640329a4f864c4e2746ba', '60dda993d87647f5989c15f14f866df9');
INSERT INTO `sys_role_menu` VALUES ('829dc9e65dba4a3a9e3f76a906151205', 'ab7e4b34e5d141fa8566fdbb5d3e66f7', '1');
INSERT INTO `sys_role_menu` VALUES ('8a4c7fb5afe049cc8e4d965a785a20cd', '3b09434ea21d44af98759c112348c725', 'd2bc30feb5474a1bb7e02d48d39a3f8a');
INSERT INTO `sys_role_menu` VALUES ('8a6381f1ddf943a2a3bc42629c339f15', '1d0d43b9fbbe4c078beb4a732309fe64', '8');
INSERT INTO `sys_role_menu` VALUES ('976499d229b349dba84d804986b5a598', 'a21876314a764438b6af6bfa422ec09a', '4253190001c1480fb0d631d64d150535');
INSERT INTO `sys_role_menu` VALUES ('aad8290942334ab8ae924eec121246e5', 'ab7e4b34e5d141fa8566fdbb5d3e66f7', '649b484b58414d91aefa5a26143e6557');
INSERT INTO `sys_role_menu` VALUES ('adff36f9a7b34e1aa0cef6ba66398e46', 'a21876314a764438b6af6bfa422ec09a', '3');
INSERT INTO `sys_role_menu` VALUES ('ae206c19b7aa48eeacf3665cded4f306', 'a21876314a764438b6af6bfa422ec09a', '686630c7cb624cc786dcdc9958971a6b');
INSERT INTO `sys_role_menu` VALUES ('afee6635bae9403a85097631d76ad7ad', 'f08487637b0d4bfc9accc14cbca6f1cd', '2');
INSERT INTO `sys_role_menu` VALUES ('b1ca22686cef42abad6a7b6d1ffb3a62', '737933bffef640329a4f864c4e2746ba', '1db9105008404a3485b6fac30dba3c0e');
INSERT INTO `sys_role_menu` VALUES ('b3541f0cf6f14d5fa265c78879497bed', '737933bffef640329a4f864c4e2746ba', '5d3dd56c16ff4e32aecae1b3228159c7');
INSERT INTO `sys_role_menu` VALUES ('b71cea3a72d545ad9d1fb5f302c0d035', 'a21876314a764438b6af6bfa422ec09a', '60dda993d87647f5989c15f14f866df9');
INSERT INTO `sys_role_menu` VALUES ('b7373fd87a114423b3a9eac80513b155', '737933bffef640329a4f864c4e2746ba', '1');
INSERT INTO `sys_role_menu` VALUES ('ba7efdab7cb64eaf9f27d7cdefd187ec', '737933bffef640329a4f864c4e2746ba', '10');
INSERT INTO `sys_role_menu` VALUES ('c015003b62a84e44aa678bdd9d9ce99b', 'a21876314a764438b6af6bfa422ec09a', 'a73802e513cc4465883530ec8074abbb');
INSERT INTO `sys_role_menu` VALUES ('c0984fb5c5584aa3af6fd538d9c3535b', '737933bffef640329a4f864c4e2746ba', 'd2bc30feb5474a1bb7e02d48d39a3f8a');
INSERT INTO `sys_role_menu` VALUES ('c280e565620442f988ceb829289f60c1', 'ab7e4b34e5d141fa8566fdbb5d3e66f7', 'a73802e513cc4465883530ec8074abbb');
INSERT INTO `sys_role_menu` VALUES ('c68b4baf5efb4979b2445338b8be6e28', '737933bffef640329a4f864c4e2746ba', '649b484b58414d91aefa5a26143e6557');
INSERT INTO `sys_role_menu` VALUES ('cb7db78bc7a045b4a82ac8487e9d3ebb', '737933bffef640329a4f864c4e2746ba', '22e38e885f9b40b9aae6a36deb78e89c');
INSERT INTO `sys_role_menu` VALUES ('d727276c096a48ae9bc42be383423f7e', '737933bffef640329a4f864c4e2746ba', '0818e1c76bbd44eba3a698547ec4e637');
INSERT INTO `sys_role_menu` VALUES ('e045bf84cd0345a2811d3906de5f7b40', 'a21876314a764438b6af6bfa422ec09a', 'dc5f478d98ed4297a8ae638fe90df050');
INSERT INTO `sys_role_menu` VALUES ('edfe6e122ca94eda9e2592c1a4a7f6f8', '737933bffef640329a4f864c4e2746ba', 'a73802e513cc4465883530ec8074abbb');
INSERT INTO `sys_role_menu` VALUES ('eeb39456492a402f830e683d80282dbd', '737933bffef640329a4f864c4e2746ba', 'dc5f478d98ed4297a8ae638fe90df050');
INSERT INTO `sys_role_menu` VALUES ('f04026b694364cb19e1b2b6a4133f635', '737933bffef640329a4f864c4e2746ba', 'f899f3d3baec4571b1c786717f9906fd');
INSERT INTO `sys_role_menu` VALUES ('f0ff3269b1994d76b015c59bed009386', 'a21876314a764438b6af6bfa422ec09a', 'd2bc30feb5474a1bb7e02d48d39a3f8a');
INSERT INTO `sys_role_menu` VALUES ('f85b67e9af3d42afa018b8790d660189', 'a21876314a764438b6af6bfa422ec09a', '1db9105008404a3485b6fac30dba3c0e');
INSERT INTO `sys_role_menu` VALUES ('fcb96010307e4c82bef6b8f0f59f17a3', '2a9b728a431246b08f853c2529e6ba84', 'd2bc30feb5474a1bb7e02d48d39a3f8a');

-- ----------------------------
-- Table structure for sys_setting
-- ----------------------------
DROP TABLE IF EXISTS `sys_setting`;
CREATE TABLE `sys_setting` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `sys_key` varchar(50) NOT NULL COMMENT 'KEY',
  `sys_name` varchar(50) NOT NULL COMMENT '名称',
  `sys_value` varchar(300) DEFAULT NULL COMMENT '值',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `sys_desc` varchar(300) DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统设置表';

-- ----------------------------
-- Records of sys_setting
-- ----------------------------
INSERT INTO `sys_setting` VALUES ('1', 'systemName', '系统名称', '数据采集系统', '0', null);
INSERT INTO `sys_setting` VALUES ('2', 'systemSubName', '系统简称', 'DCM', '1', null);
INSERT INTO `sys_setting` VALUES ('3', 'bottomCopyright', '许可说明', 'Copyright © 2017 勤智数码. All rights reserved.', '2', null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `user_state` int(2) NOT NULL DEFAULT '1' COMMENT '用户状态,1-启用,-1禁用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `user_desc` varchar(300) DEFAULT NULL COMMENT '描述',
  `user_img` varchar(300) DEFAULT NULL COMMENT '头像',
  `dept_id` varchar(50) DEFAULT NULL COMMENT '部门主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1860a3b918764a589d5ddd381fd3c083', 'aaa', 'e10adc3949ba59abbe56e057f20f883e', '1', '2017-04-18 17:30:53', 'fsafds', null, '1');
INSERT INTO `sys_user` VALUES ('4754f010ef344c59b728ea60809ab926', 'JamesZhou', 'e10adc3949ba59abbe56e057f20f883e', '1', '2016-12-12 13:43:59', '普通管理员', 'http://news.mydrivers.com/Img/20110518/04481549.png', 'aebe7d9b427643feb9c5a66c65fb9a81');
INSERT INTO `sys_user` VALUES ('549d321508db446e9bcaa477835fe5f1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '1', '2016-12-14 14:35:08', '所有权限', '/images/userImg/avatar5.png', '1');
INSERT INTO `sys_user` VALUES ('629ba7eb1d8944d2873ecfc6896288e7', 'zhangsan', 'e10adc3949ba59abbe56e057f20f883e', '1', '2016-12-12 11:49:21', '张三负责系统运维', 'http://news.mydrivers.com/Img/20110518/04481549.png', '1');
INSERT INTO `sys_user` VALUES ('b4dd99d984c64fe488e3ec6e9390dabc', 'webadmin', 'e10adc3949ba59abbe56e057f20f883e', '1', '2017-02-28 15:20:21', '123456', 'http://news.mydrivers.com/Img/20110518/04481549.png', '1');
INSERT INTO `sys_user` VALUES ('cd56d302326544479e5e7380081d835c', 'zhangsan12', 'e10adc3949ba59abbe56e057f20f883e', '1', '2017-04-17 14:01:22', null, null, '1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `user_id` varchar(50) NOT NULL COMMENT '用户主键',
  `role_id` varchar(50) NOT NULL COMMENT '角色主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1025415191074c3f8e515ea7b4720ac1', '6e6594f930054f1297f93ea626db9500', 'on');
INSERT INTO `sys_user_role` VALUES ('20ed992f08004ae0ab293349807e6f9e', 'cd56d302326544479e5e7380081d835c', '3b09434ea21d44af98759c112348c725');
INSERT INTO `sys_user_role` VALUES ('210e680232964f94acc73b402483192d', '9df9f873d44a460fae8b2d4ffc726808', '1');
INSERT INTO `sys_user_role` VALUES ('3afdaa0330fa471694216234da1ed94d', 'f62307be393d4f5a9a61ed9116629b03', 'a21876314a764438b6af6bfa422ec09a');
INSERT INTO `sys_user_role` VALUES ('3e3841367e644fbb8bbc44deaa179516', '3b3fc94b2c064cd5839d0184e6be4857', '2');
INSERT INTO `sys_user_role` VALUES ('41465180cbc448df8051df798c186a6a', '4754f010ef344c59b728ea60809ab926', 'a21876314a764438b6af6bfa422ec09a');
INSERT INTO `sys_user_role` VALUES ('5a36b11c165044dbbd834e21cbee77aa', '09c63f873a9e472ca464accb61cd5e51', 'a21876314a764438b6af6bfa422ec09a');
INSERT INTO `sys_user_role` VALUES ('5d5b40c094cd4a67bc85173811b25214', '549d321508db446e9bcaa477835fe5f1', '737933bffef640329a4f864c4e2746ba');
INSERT INTO `sys_user_role` VALUES ('8b990b3b7fe74ce0b9bf81b966a67b9d', '3b3fc94b2c064cd5839d0184e6be4857', '1');
INSERT INTO `sys_user_role` VALUES ('9cbd08ed61624d40bb2e8ef4885e9e74', 'b55a9c253c83412aaf15aeb044899230', '3');
INSERT INTO `sys_user_role` VALUES ('cc2854885461426fa16431ce30986079', '629ba7eb1d8944d2873ecfc6896288e7', 'a21876314a764438b6af6bfa422ec09a');
INSERT INTO `sys_user_role` VALUES ('d2cc10c108164ab582c3a201492b5092', '9df9f873d44a460fae8b2d4ffc726808', '2');
INSERT INTO `sys_user_role` VALUES ('ee00efefc7be4db89eaf56ca3dfd5709', 'b4dd99d984c64fe488e3ec6e9390dabc', 'ab840c7c80a441748aafc6334ee18b01');
INSERT INTO `sys_user_role` VALUES ('f4a6696fde4f4406a6a9749d46b37e53', '9df9f873d44a460fae8b2d4ffc726808', '3');
INSERT INTO `sys_user_role` VALUES ('f4c549066f9c442782a166da6aa65654', '6e6594f930054f1297f93ea626db9500', 'on');
INSERT INTO `sys_user_role` VALUES ('f5079c4420df4693abf44f28ed890608', '1860a3b918764a589d5ddd381fd3c083', '2a9b728a431246b08f853c2529e6ba84');
