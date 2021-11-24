/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : hmanage

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 05/11/2021 15:34:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cms_subject
-- ----------------------------
DROP TABLE IF EXISTS `cms_subject`;
CREATE TABLE `cms_subject`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) NULL DEFAULT NULL,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专题主图',
  `recommend_status` int(1) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `collect_count` int(11) NULL DEFAULT NULL,
  `read_count` int(11) NULL DEFAULT NULL,
  `comment_count` int(11) NULL DEFAULT NULL,
  `album_pics` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '画册图片用逗号分割',
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `show_status` int(1) NULL DEFAULT NULL COMMENT '显示状态：0->不显示；1->显示',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `forward_count` int(11) NULL DEFAULT NULL COMMENT '转发数',
  `category_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专题分类名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '专题表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_subject
-- ----------------------------
INSERT INTO `cms_subject` VALUES (27, 1, '111', '', NULL, '2021-11-04 20:50:40', 0, 0, 0, NULL, '1111', 1, NULL, NULL, '精选专题');

-- ----------------------------
-- Table structure for cms_subject_category
-- ----------------------------
DROP TABLE IF EXISTS `cms_subject_category`;
CREATE TABLE `cms_subject_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类图标',
  `subject_count` int(11) NULL DEFAULT NULL COMMENT '专题数量',
  `show_status` int(2) NULL DEFAULT NULL,
  `sort` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '专题分类表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_subject_category
-- ----------------------------
INSERT INTO `cms_subject_category` VALUES (1, '精选专题', 'null', 4, 1, 101);
INSERT INTO `cms_subject_category` VALUES (2, '运动专题', 'null', 7, 1, 0);
INSERT INTO `cms_subject_category` VALUES (3, '美食专题', 'null', 3, 1, 0);
INSERT INTO `cms_subject_category` VALUES (4, '健康专题', 'null', 1, 1, 0);

-- ----------------------------
-- Table structure for cms_subject_comment
-- ----------------------------
DROP TABLE IF EXISTS `cms_subject_comment`;
CREATE TABLE `cms_subject_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subject_id` bigint(20) NULL DEFAULT NULL,
  `member_nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `member_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `show_status` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '专题评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_subject_comment
-- ----------------------------
INSERT INTO `cms_subject_comment` VALUES (1, 1, 'jonyon', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png', '对身体非常有好处！推荐！！', '2021-11-02 13:39:43', 1);
INSERT INTO `cms_subject_comment` VALUES (2, 1, 'adger', 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20211005/cat.jpg', '我也非常推荐！！', '2021-11-02 13:41:07', 1);
INSERT INTO `cms_subject_comment` VALUES (3, 1, 'wzj', NULL, '推荐！推荐！！', '2021-11-02 13:41:59', 1);
INSERT INTO `cms_subject_comment` VALUES (4, 2, 'adger', 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20211005/cat.jpg', '马克一下', '2021-11-02 13:42:49', 1);
INSERT INTO `cms_subject_comment` VALUES (5, 3, 'adger', 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20211005/cat.jpg', '马克两下', '2021-11-02 13:43:24', 1);
INSERT INTO `cms_subject_comment` VALUES (6, 6, 'adger', 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20211005/cat.jpg', '冒个泡', '2021-11-02 13:44:08', 1);
INSERT INTO `cms_subject_comment` VALUES (7, 12, 'adger', 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20211005/cat.jpg', '芜湖起飞！', '2021-11-02 13:44:46', 1);
INSERT INTO `cms_subject_comment` VALUES (8, 14, 'adger', 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20211005/cat.jpg', 'mark', '2021-11-02 13:45:30', 1);
INSERT INTO `cms_subject_comment` VALUES (9, 15, 'adger', 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20211005/cat.jpg', '到此一游', '2021-11-02 13:46:02', 1);

-- ----------------------------
-- Table structure for fms_food
-- ----------------------------
DROP TABLE IF EXISTS `fms_food`;
CREATE TABLE `fms_food`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `food_category_id` bigint(20) NULL DEFAULT NULL COMMENT '食品分类id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `food_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '食品编号',
  `recommand_status` int(1) NULL DEFAULT NULL COMMENT '推荐状态；0->不推荐；1->推荐',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `food_category_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运动分类名称',
  `calorie` int(20) NULL DEFAULT NULL COMMENT '卡路里',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '描述',
  `unit` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关键字',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `album_pics` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '画册图片，图片限制为5张，以逗号分割',
  `detail_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情标题',
  `detail_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '详情描述',
  `detail_html` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '产品详情网页内容',
  `detail_mobile_html` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '移动端网页详情',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fms_food
-- ----------------------------
INSERT INTO `fms_food` VALUES (1, 9, '木瓜', 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20211026/木瓜.jpg', '20001', 1, 0, '木瓜', 300, '木瓜富有营养，低卡路里，以致对进行减肥的人大有益处。', '卡/克', '木瓜', NULL, '', '木瓜', NULL, NULL, NULL);
INSERT INTO `fms_food` VALUES (2, 10, '西瓜', NULL, '20002', 1, 0, '西瓜', 300, '可以大量补充人体所需要的水分，在天气炎热的时候，多吃西瓜或西瓜汁可以排出体内多余的热量和毒素，去热解暑。含有很多营养成分，相对于其他水果，西瓜汁含水量非常丰富，可以补充人体所需要的营养成分。可以延缓衰老。西瓜中含有蛋白酶，可以帮助人体蛋白质很好地吸收。西瓜含有少量的盐类，有助于起到治疗肾炎的作用;还有利于降低血压和排尿。可以预防坏血病，心血管系统疾病，提高人体免疫力，促进新陈代谢，减少胆固醇的沉积。还可以治疗一些口腔疾病，咽喉肿痛，口舌生疮等等口腔疾病。', '卡/克', '西瓜', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fms_food` VALUES (3, 11, '草莓', NULL, '20003', 1, 0, '草莓', 300, '清凉止渴、健胃消食。草莓的功效主要有以下几方面：1、可以清凉止渴，因为从中医食疗的角度上来讲，草莓性味甘、凉，对于内火、阴虚火旺所导致的口渴、口干、咽喉疼痛的人，适当吃草莓有很好的清凉止渴作用。2、能够健胃消食，因为从中医食疗的角度上来讲草莓入脾经和胃经，对于消化不良、食欲较差、脘腹胀满的人，适当吃草莓有很好的健胃消食作用。草莓的禁忌就是其中含有的碳水化合物，也就是糖分比较多，对于血糖较高或者糖尿病的人，在食用草莓时一定要控制量，否则可能会引起血糖增高。', '卡/克', '草莓', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fms_food` VALUES (4, 12, '黑米粥', NULL, '20004', 1, 0, '黑米粥', 300, '黑豆黑色素还含有黄酮类化合物、多糖类活性物质，是高梁米的5倍之多，对防止动脉硬化有非常大的功效。黑豆中的钾、镁等矿物还有益于控制血压、降低患心脑血管病症的风险性。黑豆具备降低胆固醇、改进缺铁性贫血、抗现象及其激素调节等多种多样生理作用。黑豆带有很多的粗脂肪维他命和营养元素等。碳水化合物的成分也很高，黑豆能够 熬粥吃，黑豆具备非常好的补气补血功效，黑豆也是有健脾胃暖肝的作用，能够 清目活血化瘀。', '卡/克', '黑米粥', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fms_food` VALUES (5, 13, '煮面条', NULL, '20005', 1, 0, '煮面条', 300, '1、面条含有丰富的碳水化合物，能提供足够的能量。2、富含铜，铜是人体健康不可缺少的微量营养素，对于血液、中枢神经和免疫系统，头发、皮肤和骨骼组织以及脑子和肝、心等内脏的发育和功能有重要影响。', '卡/克', '煮面条', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fms_food` VALUES (6, 14, '芋头', NULL, '20006', 1, 0, '芋头', 300, '氟的含量较高因此芋头有洁齿防龋，保护牙齿的功效。能增强人体的免疫功能，对于癌症手术后放射化疗以及康复，有辅助治疗作用。芋头含有大量的钾，能够调节机体内的电解质平衡，帮助机体排除多余的钠，并促进血压的降低，对高血压患者来说，芋头是一种很好的保健食品。芋头为碱性食品，能中和体内积存的酸性物质，协调人体的酸碱平衡，达到美容养颜，乌黑头发的效果，还可以用来防治胃酸过多。芋头含有丰富的黏液皂素及多种微量元素，可帮助机体纠正微量元素缺乏导致的生理异常，同时能增进食欲，帮助消化，故中医认为芋艿可补中益气。\r\n\r\n芋头中含有一种粘液蛋白，在被人体吸收后能产生免疫球蛋白，提高身体的抵抗力，因此芋头可以解毒，对人体的癌毒有抑制消解作用，可以用来防治肿瘤等疾病。', '卡/克', '芋头', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fms_food` VALUES (7, 15, '柚子', NULL, '20007', 1, 0, '柚子', 300, '柚子的营养价值很高，含有非常丰富的蛋白质、有机酸、维生素以及钙、磷、镁、钠等人体必需的元素，这是其他水果所难以比拟的。它还含有非常丰富的维他命C和柚子酸，每100克柚子中富含150毫克的维他命C含量是柠檬和脐橙的3倍。这就是柚子被普遍认为有效防治一般感冒的原因。众所周知，维他命C对一般感冒和神经痛有特别的效果。同时柚子富含的橙皮柑，其功效类于维他命P对于保护和强化毛细血管，预防脑溢血功效显著。柚子的金黄色外皮含有胡萝卜素，是维他命A的主要来源。一个柚子以胡萝卜素的形式富含1500IU的维他命。此外，柚子酸的成分使柚子口感略酸，对于消除疲劳和促进消化分泌有很大的帮助。', '卡/克', '柚子', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fms_food` VALUES (8, 16, '小米粥', NULL, '20008', 1, 0, '小米粥', 300, '1、能够和中益胃，因为从中医食疗的角度上来讲小米粥性味甘、咸、凉，入脾、胃经，对于脾胃虚弱所导致的反复呕吐、恶心、腹胀、消化不良、腹泻的人，如果适当常吃小米粥有很好的和中益胃、促进消化的好处；2、能够滋阴补肾，对于肾虚所导致的四肢无力、腰膝酸软、腰腿疼、须发早白、耳鸣的人。如果适当常吃小米粥，通过滋补肾经而有很好的缓解上述症状的好处。', '卡/克', '小米粥', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fms_food` VALUES (9, 17, '鳕鱼', NULL, '20009', 1, 0, '鳕鱼', 300, '经常吃鳕鱼对人体有很多的益处。鳕鱼中含有丰富的蛋白质、维生素、微量元素等成分，可以为人体补充营养，经常食用，还可以提高呼吸系统及机体的免疫力；鳕鱼中含有的镁元素，可以保护心脏和血管健康，对骨骼和肌肉的发育也有很好的促进作用；而且，鳕鱼还能够提高鼻粘膜的抵抗力，可以减少鼻炎的发生率。鳕鱼还能活血，化瘀，止痛，对铁打损伤有一定的食疗作用。', '卡/克', '鳕鱼', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fms_food` VALUES (10, 18, '挂面', NULL, '20010', 1, 0, '挂面', 300, '•1、预防心血管病。挂面中含有大豆蛋白质和豆固醇,这些物质能明显地改善和降低体内血脂、胆固醇,从而降低患心血管疾病的概率。\r\n•2、增强免疫力。挂面所含的蛋白质较多,而蛋白质是维持免疫机能最重要的营养素,为构成白血球和抗体的主要成份,故食用挂面具有增强免疫力的功效。\r\n•3、防癌抗癌。挂面中富含皂角苷、蛋白酶抑制剂、异黄酮、钼、硒等抗癌成分,这些物质对前列腺癌、皮肤癌、肠癌、食道癌等癌症都有抑制作用。\r\n•4、预防骨质疏松。挂面主要由小麦粉、高粱等粮食制作而成,经常食用这些食物,有利于缓解体内钙质的消耗,故挂面对预防骨质疏松有一定的帮助。\r\n•5、养胃。经过煮沸的挂面,口感软糯,易于被人体消化吸收,可大大减少肠胃疾病的发生,故起到养胃的作用。', '卡/克', '挂面', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fms_food` VALUES (11, 19, '黄豆', NULL, '20011', 1, 0, '黄豆', 300, '1、能够宽中导滞，对于食积泻痢、腹胀食呆的人，适当吃黄豆有很好的宽中导滞的好处。2、能够健脾利水，对于脾虚水肿、腹水的人，适当多吃黄豆有很好的健脾利水的作用。3、能够为机体补充丰富的蛋白质，在预防肌肉减少症方面的好处非常明显。多吃黄豆的坏处就是有可能会引起腹胀、排气增多的情况高发。', '卡/克', '黄豆', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fms_food` VALUES (12, 20, '鸡胸肉', NULL, '20012', 1, 0, '鸡胸肉', 300, '1、鸡肉中的高蛋白可以帮助肌肉增长，对于在健身想锻炼肌肉的人来说，是一个很好的营养补充。\r\n\r\n2、高蛋白，低脂肪，鸡肉还是减肥和健身人士很好的一种食物。\r\n\r\n3、可以降低胆固醇，为高胆固醇患者的身体健康更好地保驾护航。鸡肉，特别是鸡脯肉中的脂肪含量非常低，维生素比较高，非常有利于降低胆固醇。\r\n\r\n4、可以帮助排出身体内的毒素，还有抗氧化的功效。\r\n\r\n5、对于身体虚弱的人，可以补充很好的营养，还可以缓解头晕等症状。\r\n\r\n6、鸡汤非常有利于补充肝血，提供营养。\r\n\r\n7、可以增强身体的免疫力。强身健体，预防和减少感冒等疾病。\r\n\r\n', '卡/克', '鸡胸肉', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for fms_food_category
-- ----------------------------
DROP TABLE IF EXISTS `fms_food_category`;
CREATE TABLE `fms_food_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '上级分类的编号：0表示一级分类',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `level` int(1) NULL DEFAULT NULL COMMENT '分类级别：0->1级；1->2级',
  `nav_status` int(1) NULL DEFAULT NULL COMMENT '是否显示在导航栏：0->不显示；1->显示',
  `show_status` int(1) NULL DEFAULT NULL COMMENT '显示状态：0->不显示；1->显示',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关键字',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fms_food_category
-- ----------------------------
INSERT INTO `fms_food_category` VALUES (1, 0, '低热量-水果类', 0, 1, 1, 1, NULL, '低热量', '水果类');
INSERT INTO `fms_food_category` VALUES (2, 0, '低GI-主食类', 0, 1, 1, 2, NULL, '低GI', '主食类');
INSERT INTO `fms_food_category` VALUES (3, 0, '低GI-水果类', 0, 1, 1, 3, NULL, '低GI', '水果类');
INSERT INTO `fms_food_category` VALUES (4, 0, '低GL-主食类', 0, 1, 1, 5, NULL, '低GI', '主食类');
INSERT INTO `fms_food_category` VALUES (5, 0, '高蛋白-海鲜类', 0, 1, 1, 4, NULL, '高蛋白', '海鲜类');
INSERT INTO `fms_food_category` VALUES (6, 0, '高蛋白-主食类', 0, 1, 1, 6, NULL, '高蛋白', '主食类');
INSERT INTO `fms_food_category` VALUES (7, 0, '高蛋白-豆类', 0, 1, 1, 7, NULL, '高蛋白', '豆类');
INSERT INTO `fms_food_category` VALUES (8, 0, '高蛋白-肉类', 0, 1, 1, 8, NULL, '高蛋白', '肉类');
INSERT INTO `fms_food_category` VALUES (9, 1, '木瓜', 1, 1, 1, 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20211024/木瓜.jpg', '低热量', '水果类');
INSERT INTO `fms_food_category` VALUES (10, 1, '西瓜', 1, 1, 1, 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20211024/西瓜.jpg', '低热量', '水果类');
INSERT INTO `fms_food_category` VALUES (11, 1, '草莓', 1, 1, 1, 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20211024/草莓.jpg', '低热量', '水果类');
INSERT INTO `fms_food_category` VALUES (12, 2, '黑米粥', 1, 1, 1, 1, NULL, '低GI', '主食类');
INSERT INTO `fms_food_category` VALUES (13, 2, '煮面条', 1, 1, 1, 1, NULL, '低GI', '主食类');
INSERT INTO `fms_food_category` VALUES (14, 2, '芋头', 1, 1, 1, 1, NULL, '低GI', '主食类');
INSERT INTO `fms_food_category` VALUES (15, 3, '柚子', 1, 1, 1, 1, NULL, '低GI', '水果类');
INSERT INTO `fms_food_category` VALUES (16, 4, '小米粥', 1, 1, 1, 1, NULL, '低GI', '主食类');
INSERT INTO `fms_food_category` VALUES (17, 5, '鳕鱼', 1, 1, 1, 1, NULL, '高蛋白', '海鲜类');
INSERT INTO `fms_food_category` VALUES (18, 6, '挂面', 1, 1, 1, 1, NULL, '高蛋白', '主食类');
INSERT INTO `fms_food_category` VALUES (19, 7, '黄豆', 1, 1, 1, 1, NULL, '高蛋白', '豆类');
INSERT INTO `fms_food_category` VALUES (20, 8, '鸡胸肉', 1, 1, 1, 1, NULL, '高蛋白', '肉类');

-- ----------------------------
-- Table structure for home_advertise
-- ----------------------------
DROP TABLE IF EXISTS `home_advertise`;
CREATE TABLE `home_advertise`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `type` int(1) NULL DEFAULT NULL COMMENT '轮播位置：0->PC首页轮播；1->app首页轮播',
  `pic` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `status` int(1) NULL DEFAULT NULL COMMENT '上下线状态：0->下线；1->上线',
  `click_count` int(11) NULL DEFAULT NULL COMMENT '点击数',
  `url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接地址',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `sort` int(11) NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of home_advertise
-- ----------------------------
INSERT INTO `home_advertise` VALUES (2, '广告1', 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '2018-11-01 14:01:37', '2021-10-14 14:01:37', 1, 0, NULL, '夏季大热促销', 0);
INSERT INTO `home_advertise` VALUES (3, '广告2', 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '2018-11-13 14:01:37', '2021-10-14 14:01:37', 0, 0, NULL, '夏季大热促销1', 0);
INSERT INTO `home_advertise` VALUES (4, '广告3', 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '2018-11-13 14:01:37', '2021-10-14 14:01:37', 1, 0, NULL, '夏季大热促销2', 0);
INSERT INTO `home_advertise` VALUES (9, '广告4', 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '2018-11-01 00:00:00', '2021-10-14 00:00:00', 1, 0, 'www.baidu.com', '电影推荐广告', 100);
INSERT INTO `home_advertise` VALUES (10, '广告5', 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '2018-11-13 00:00:00', '2021-10-14 00:00:00', 1, 0, 'xxx', NULL, 99);
INSERT INTO `home_advertise` VALUES (11, '广告6', 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '2018-11-13 00:00:00', '2021-10-14 00:00:00', 1, 0, 'xxx', NULL, 98);

-- ----------------------------
-- Table structure for home_recommend_subject
-- ----------------------------
DROP TABLE IF EXISTS `home_recommend_subject`;
CREATE TABLE `home_recommend_subject`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subject_id` bigint(20) NULL DEFAULT NULL COMMENT '专题id',
  `subject_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专题名称',
  `recommend_status` int(1) NULL DEFAULT NULL COMMENT '推荐状态：0->不推荐;1->推荐',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for plan_item
-- ----------------------------
DROP TABLE IF EXISTS `plan_item`;
CREATE TABLE `plan_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sf_id` bigint(20) NULL DEFAULT NULL COMMENT '运动或食品的id',
  `member_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `quantity` int(11) NULL DEFAULT NULL COMMENT '数量',
  `calorie` decimal(10, 2) NULL DEFAULT NULL COMMENT '添加到计划的卡路里',
  `sf_pic` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主图',
  `sf_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `sf_sn` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '条码',
  `member_nickname` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `delete_status` int(1) NULL DEFAULT 0 COMMENT '是否删除',
  `sf_category_id` bigint(20) NULL DEFAULT NULL COMMENT '分类',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan_item
-- ----------------------------
INSERT INTO `plan_item` VALUES (26, 1, 2, 1, 350.00, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '慢跑', '10001', 'adger', '2021-10-12 18:05:06', NULL, 0, 2);

-- ----------------------------
-- Table structure for pms_order
-- ----------------------------
DROP TABLE IF EXISTS `pms_order`;
CREATE TABLE `pms_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '计划id',
  `member_id` bigint(20) NOT NULL COMMENT '用户id',
  `plan_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '计划编号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `member_username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户帐号',
  `total_calorie` decimal(10, 2) NULL DEFAULT NULL COMMENT '计划总卡路里',
  `total_time` decimal(10, 2) NULL DEFAULT NULL COMMENT '计划总时长',
  `source_type` int(1) NULL DEFAULT NULL COMMENT '来源：0->PC；1->app',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态：0->待执行；1->正在执行；2->已完成；3->已关闭；4->无效计划',
  `auto_confirm_day` int(11) NULL DEFAULT NULL COMMENT '自动确认时间（天）',
  `integration` int(11) NULL DEFAULT NULL COMMENT '可以获得的积分',
  `growth` int(11) NULL DEFAULT NULL COMMENT '可以活动的成长值',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `confirm_status` int(1) NULL DEFAULT NULL COMMENT '确认状态：0->未确认；1->已确认',
  `delete_status` int(1) NOT NULL DEFAULT 0 COMMENT '删除状态：0->未删除；1->已删除',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '执行时间',
  `confirm_time` datetime(0) NULL DEFAULT NULL COMMENT '确认完成时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_order
-- ----------------------------
INSERT INTO `pms_order` VALUES (1, 2, '21010091656', '2021-10-09 16:56:42', '2284233647', 2125.00, 4.50, 0, 4, 1, 0, 0, '该计划有错误', 1, 0, '2021-10-09 16:58:49', '2021-10-10 16:58:55');
INSERT INTO `pms_order` VALUES (31, 2, '2021101101000014', '2021-10-11 15:20:55', '2284233647', 2125.00, 4.50, 1, 1, 1, NULL, NULL, NULL, 0, 0, '2021-10-11 15:20:55', '2021-10-11 15:20:55');
INSERT INTO `pms_order` VALUES (32, 2, '2021101101000015', '2021-10-11 15:27:07', '2284233647', 2125.00, 4.50, 1, 3, 1, NULL, NULL, NULL, 0, 0, '2021-10-11 15:27:07', '2021-10-11 15:27:07');
INSERT INTO `pms_order` VALUES (33, 2, '2021101101000016', '2021-10-11 15:27:08', '2284233647', 2125.00, 4.50, 1, 3, 1, NULL, NULL, NULL, 0, 0, '2021-10-11 15:27:08', '2021-10-11 15:27:08');
INSERT INTO `pms_order` VALUES (34, 2, '2021101101000017', '2021-10-11 15:27:08', '2284233647', 2125.00, 4.50, 1, 3, 1, NULL, NULL, NULL, 0, 0, '2021-10-11 15:27:08', '2021-10-11 15:27:08');
INSERT INTO `pms_order` VALUES (35, 2, '2021101201000002', '2021-10-12 16:07:26', '2284233647', 725.00, 2.50, 1, 0, 1, NULL, NULL, NULL, 0, 0, '2021-10-12 16:07:26', '2021-10-12 16:07:26');
INSERT INTO `pms_order` VALUES (37, 2, '2021101201000004', '2021-10-12 17:55:05', '2284233647', 250.00, 0.50, 1, 2, 1, NULL, NULL, NULL, 0, 0, '2021-10-12 17:55:05', '2021-10-12 17:55:05');
INSERT INTO `pms_order` VALUES (40, 2, '2021101201000007', '2021-10-12 18:00:48', '2284233647', 750.00, 1.50, 1, 0, 1, NULL, NULL, NULL, 0, 0, '2021-10-12 18:00:48', '2021-10-12 18:00:48');
INSERT INTO `pms_order` VALUES (41, 2, '2021101201000008', '2021-10-12 18:03:21', '2284233647', 350.00, 0.50, 1, 0, 1, NULL, NULL, NULL, 0, 0, '2021-10-12 18:03:21', '2021-10-12 18:03:21');
INSERT INTO `pms_order` VALUES (42, 2, '2021101201000009', '2021-10-12 18:04:37', '2284233647', 525.00, 1.00, 1, 0, 1, NULL, NULL, NULL, 0, 0, '2021-10-12 18:04:37', '2021-10-12 18:04:37');

-- ----------------------------
-- Table structure for pms_order_item
-- ----------------------------
DROP TABLE IF EXISTS `pms_order_item`;
CREATE TABLE `pms_order_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '计划id',
  `order_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `sf_id` bigint(20) NULL DEFAULT NULL COMMENT 'sf的id',
  `sf_pic` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `sf_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `sf_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '条码',
  `sf_calorie` decimal(10, 2) NULL DEFAULT NULL COMMENT '卡路里',
  `sf_quantity` int(11) NULL DEFAULT NULL COMMENT '数量',
  `sf_category_id` bigint(20) NULL DEFAULT NULL COMMENT '分类id',
  `gift_integration` int(11) NOT NULL DEFAULT 0 COMMENT '商品赠送积分',
  `gift_growth` int(11) NOT NULL DEFAULT 0 COMMENT '商品赠送成长值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_order_item
-- ----------------------------
INSERT INTO `pms_order_item` VALUES (1, 1, '21010091656', 1, '1', '慢跑', '10001', 350.00, 4, 2, 0, 0);
INSERT INTO `pms_order_item` VALUES (2, 1, '21010091656', 2, NULL, '散步', '10002', 75.00, 3, 6, 0, 0);
INSERT INTO `pms_order_item` VALUES (3, 1, '21010091656', 4, NULL, '篮球', '10004', 250.00, 2, 8, 0, 0);
INSERT INTO `pms_order_item` VALUES (7, 31, '2021101101000014', 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '慢跑', '10001', 350.00, 4, 2, 0, 0);
INSERT INTO `pms_order_item` VALUES (8, 31, '2021101101000014', 2, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '散步', '10002', 75.00, 3, 6, 0, 0);
INSERT INTO `pms_order_item` VALUES (9, 31, '2021101101000014', 4, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '篮球', '10004', 250.00, 2, 8, 0, 0);
INSERT INTO `pms_order_item` VALUES (10, 32, '2021101101000015', 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '慢跑', '10001', 350.00, 4, 2, 0, 0);
INSERT INTO `pms_order_item` VALUES (11, 32, '2021101101000015', 2, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '散步', '10002', 75.00, 3, 6, 0, 0);
INSERT INTO `pms_order_item` VALUES (12, 32, '2021101101000015', 4, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '篮球', '10004', 250.00, 2, 8, 0, 0);
INSERT INTO `pms_order_item` VALUES (13, 33, '2021101101000016', 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '慢跑', '10001', 350.00, 4, 2, 0, 0);
INSERT INTO `pms_order_item` VALUES (14, 33, '2021101101000016', 2, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '散步', '10002', 75.00, 3, 6, 0, 0);
INSERT INTO `pms_order_item` VALUES (15, 33, '2021101101000016', 4, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '篮球', '10004', 250.00, 2, 8, 0, 0);
INSERT INTO `pms_order_item` VALUES (16, 34, '2021101101000017', 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '慢跑', '10001', 350.00, 4, 2, 0, 0);
INSERT INTO `pms_order_item` VALUES (17, 34, '2021101101000017', 2, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '散步', '10002', 75.00, 3, 6, 0, 0);
INSERT INTO `pms_order_item` VALUES (18, 34, '2021101101000017', 4, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '篮球', '10004', 250.00, 2, 8, 0, 0);
INSERT INTO `pms_order_item` VALUES (19, 35, '2021101201000002', 2, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '散步', '10002', 75.00, 3, 6, 0, 0);
INSERT INTO `pms_order_item` VALUES (20, 35, '2021101201000002', 4, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '篮球', '10004', 250.00, 2, 8, 0, 0);
INSERT INTO `pms_order_item` VALUES (21, 36, '2021101201000003', 4, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '篮球', '10004', 250.00, 2, 8, 0, 0);
INSERT INTO `pms_order_item` VALUES (22, 37, '2021101201000004', 4, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '篮球', '10004', 250.00, 1, 8, 0, 0);
INSERT INTO `pms_order_item` VALUES (23, 38, '2021101201000005', 2, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '散步', '10002', 75.00, 1, 6, 0, 0);
INSERT INTO `pms_order_item` VALUES (24, 39, '2021101201000006', 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '慢跑', '10001', 350.00, 1, 2, 0, 0);
INSERT INTO `pms_order_item` VALUES (25, 39, '2021101201000006', 3, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '游泳', '10003', 175.00, 1, 5, 0, 0);
INSERT INTO `pms_order_item` VALUES (26, 40, '2021101201000007', 4, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '篮球', '10004', 250.00, 3, 8, 0, 0);
INSERT INTO `pms_order_item` VALUES (27, 41, '2021101201000008', 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '慢跑', '10001', 350.00, 1, 2, 0, 0);
INSERT INTO `pms_order_item` VALUES (28, 42, '2021101201000009', 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '慢跑', '10001', 350.00, 1, 2, 0, 0);
INSERT INTO `pms_order_item` VALUES (29, 42, '2021101201000009', 3, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '游泳', '10003', 175.00, 1, 5, 0, 0);

-- ----------------------------
-- Table structure for pms_order_operate_history
-- ----------------------------
DROP TABLE IF EXISTS `pms_order_operate_history`;
CREATE TABLE `pms_order_operate_history`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '计划id',
  `operate_man` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人：用户；系统；后台管理员',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `order_status` int(1) NULL DEFAULT NULL COMMENT '状态：0->待执行；1->正在执行；2->已完成；3->已关闭；4->无效计划',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_order_operate_history
-- ----------------------------
INSERT INTO `pms_order_operate_history` VALUES (1, 36, '后台管理员', '2021-10-20 17:10:38', 0, '修改备注信息：健康');
INSERT INTO `pms_order_operate_history` VALUES (2, 1, '后台管理员', '2021-10-20 17:11:48', 2, '修改备注信息：该计划有错误');

-- ----------------------------
-- Table structure for sms_sport
-- ----------------------------
DROP TABLE IF EXISTS `sms_sport`;
CREATE TABLE `sms_sport`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sport_category_id` bigint(20) NULL DEFAULT NULL COMMENT '运动分类id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `sport_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '运动编号',
  `recommand_status` int(1) NULL DEFAULT NULL COMMENT '推荐状态；0->不推荐；1->推荐',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `sport_category_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运动分类名称',
  `calorie` int(20) NULL DEFAULT NULL COMMENT '卡路里',
  `gift_growth` int(11) NULL DEFAULT 0 COMMENT '赠送的成长值',
  `gift_point` int(11) NULL DEFAULT 0 COMMENT '赠送的积分',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '运动描述',
  `unit` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关键字',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `album_pics` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '画册图片，图片限制为5张，以逗号分割',
  `detail_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情标题',
  `detail_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '详情描述',
  `detail_html` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '产品详情网页内容',
  `detail_mobile_html` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '移动端网页详情',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sms_sport
-- ----------------------------
INSERT INTO `sms_sport` VALUES (1, 2, '慢跑', 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '10001', 1, 0, '跑步', 350, 100, 10, '有益于心肺和血液循环。跑的路程越长，消耗的热量越大', '卡/半小时', '慢跑', '记录', NULL, NULL, '1', '1', '');
INSERT INTO `sms_sport` VALUES (2, 6, '散步', 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20211016/走.jpg', '10002', 1, 0, '行走', 75, 60, 7, '对心肺功能的增强有益，它能改善血液循环，活动关节和有助于减肥', '卡/半小时', '散步', NULL, '', NULL, NULL, NULL, NULL);
INSERT INTO `sms_sport` VALUES (3, 5, '游泳', 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20211016/游泳.jpg', '10003', 1, 0, '游泳', 175, 120, 15, '它是一项全身协调动作的运动，对增强心肺功能，锻炼灵活性和力量都很有好处。它还有利于病人恢复健康，妇女生育后恢复体形，对老年人和身体瘦弱的人都是一项很好的运动', '卡/半小时', '游', NULL, '', NULL, NULL, NULL, NULL);
INSERT INTO `sms_sport` VALUES (4, 8, '篮球', 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20211016/篮球.jpg', '10004', 1, 0, '篮球', 250, 110, 12, '它可增强灵活性，加强心肺功能', '卡/半小时', '篮球', NULL, '', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sms_sport_category
-- ----------------------------
DROP TABLE IF EXISTS `sms_sport_category`;
CREATE TABLE `sms_sport_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '上级分类的编号：0表示一级分类',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `level` int(1) NULL DEFAULT NULL COMMENT '分类级别：0->1级；1->2级',
  `nav_status` int(1) NULL DEFAULT NULL COMMENT '是否显示在导航栏：0->不显示；1->显示',
  `show_status` int(1) NULL DEFAULT NULL COMMENT '显示状态：0->不显示；1->显示',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关键字',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sms_sport_category
-- ----------------------------
INSERT INTO `sms_sport_category` VALUES (1, 0, '速度力量型', 0, 1, 1, 1, NULL, '速度力量', NULL);
INSERT INTO `sms_sport_category` VALUES (2, 1, '跑步', 1, 1, 1, 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/跑步.jpg', '跑', NULL);
INSERT INTO `sms_sport_category` VALUES (3, 1, '举重', 1, 1, 1, 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/举重.jpg', '举', NULL);
INSERT INTO `sms_sport_category` VALUES (4, 0, '耐力型', 0, 1, 1, 1, NULL, '耐力', NULL);
INSERT INTO `sms_sport_category` VALUES (5, 4, '游泳', 1, 1, 1, 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/游泳.jpg', '游', NULL);
INSERT INTO `sms_sport_category` VALUES (6, 4, '行走', 1, 1, 1, 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/走.jpg', '走', NULL);
INSERT INTO `sms_sport_category` VALUES (7, 0, '同场对抗型', 0, 1, 1, 1, NULL, '对抗', NULL);
INSERT INTO `sms_sport_category` VALUES (8, 7, '篮球', 1, 1, 1, 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/篮球.jpg', '篮球', NULL);
INSERT INTO `sms_sport_category` VALUES (9, 7, '足球', 1, 1, 1, 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/足球.jpg', '足球', NULL);
INSERT INTO `sms_sport_category` VALUES (10, 7, '橄榄球', 1, 1, 1, 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/橄榄球.jpg', '橄榄球', NULL);
INSERT INTO `sms_sport_category` VALUES (11, 0, '隔网对抗型', 0, 1, 1, 1, NULL, '网', NULL);
INSERT INTO `sms_sport_category` VALUES (12, 11, '乒乓球', 1, 1, 1, 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/兵兵球.jpg', '乒乓球', NULL);
INSERT INTO `sms_sport_category` VALUES (13, 11, '排球', 1, 1, 1, 1, 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20210817/排球.jpg', '排球', NULL);
INSERT INTO `sms_sport_category` VALUES (14, 11, '网球', 1, 1, 1, 1, NULL, '网球', NULL);
INSERT INTO `sms_sport_category` VALUES (15, 0, '格斗对抗型', 0, 1, 1, 1, NULL, '格斗', NULL);
INSERT INTO `sms_sport_category` VALUES (16, 15, '击剑', 1, 1, 1, 1, NULL, '击剑', NULL);
INSERT INTO `sms_sport_category` VALUES (17, 15, '柔道', 1, 1, 1, 1, NULL, '柔道', NULL);
INSERT INTO `sms_sport_category` VALUES (18, 15, '摔跤', 1, 1, 1, 1, NULL, '摔跤', NULL);
INSERT INTO `sms_sport_category` VALUES (19, 15, '拳击', 1, 1, 1, 1, NULL, '拳击', NULL);
INSERT INTO `sms_sport_category` VALUES (20, 0, '技能准确型', 0, 1, 1, 1, NULL, '准确', NULL);
INSERT INTO `sms_sport_category` VALUES (21, 20, '射击', 1, 1, 1, 1, NULL, '射击', NULL);
INSERT INTO `sms_sport_category` VALUES (22, 20, '射箭', 1, 1, 1, 1, NULL, '射箭', '射箭');

-- ----------------------------
-- Table structure for ums_admin
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin`;
CREATE TABLE `ums_admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) NULL DEFAULT 1 COMMENT '状态：0->禁用；1->启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_admin
-- ----------------------------
INSERT INTO `ums_admin` VALUES (1, 'test', '$2a$10$Xayfs5O537VLWZm6H74wxe5VPQWx5uBvPLAqJZDu0L1RpHeKar26C', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png', '994057864@qq.com', '测试账号', NULL, '2021-05-30 19:48:42', '2021-05-30 19:48:49', 1);
INSERT INTO `ums_admin` VALUES (2, 'admin', '$2a$10$Xayfs5O537VLWZm6H74wxe5VPQWx5uBvPLAqJZDu0L1RpHeKar26C', NULL, 'admin@163.com', '系统管理员', NULL, '2021-05-30 19:49:29', '2021-05-30 19:50:10', 0);
INSERT INTO `ums_admin` VALUES (3, 'adger', '$2a$10$wkyL/mE3ELJfTR5ZeHFHme4MenpFpz6djZuAVJWVdj.ihOr.PvhDi', '', '994857864@gmail.com', '普通管理员', '', '2021-06-20 18:11:18', '2021-06-20 18:11:18', 1);
INSERT INTO `ums_admin` VALUES (4, 'jonyon', '$2a$10$krpbkmMeZlX3fUuzHcHUCutZBMETqVJwwvMsGLsdUOJb.56m/mK06', NULL, '9905181632@gmail.com', 'jonyon', NULL, '2021-06-21 16:16:07', '2021-06-21 16:16:07', 1);

-- ----------------------------
-- Table structure for ums_admin_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_role_relation`;
CREATE TABLE `ums_admin_role_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_admin_role_relation
-- ----------------------------
INSERT INTO `ums_admin_role_relation` VALUES (2, 2, 2);
INSERT INTO `ums_admin_role_relation` VALUES (4, 3, 3);
INSERT INTO `ums_admin_role_relation` VALUES (6, 2, 3);
INSERT INTO `ums_admin_role_relation` VALUES (11, 4, 1);
INSERT INTO `ums_admin_role_relation` VALUES (17, 1, 1);

-- ----------------------------
-- Table structure for ums_member
-- ----------------------------
DROP TABLE IF EXISTS `ums_member`;
CREATE TABLE `ums_member`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_level_id` bigint(20) NULL DEFAULT NULL,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `phone` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态：0->禁用；1->启用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `gender` int(1) NULL DEFAULT NULL COMMENT '性别：0->未知；1->男；2->女',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '生日',
  `integration` int(255) NULL DEFAULT NULL COMMENT '积分',
  `growth` int(255) NULL DEFAULT NULL COMMENT '成长值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_member
-- ----------------------------
INSERT INTO `ums_member` VALUES (1, 4, '994057864', '$2a$10$Xayfs5O537VLWZm6H74wxe5VPQWx5uBvPLAqJZDu0L1RpHeKar26C', 'jonyon', '18788631885', 1, '2021-09-08 17:19:05', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png', 1, '2020-09-01 17:19:19', 10000, 10000);
INSERT INTO `ums_member` VALUES (2, 0, '2284233647', '$2a$10$Xayfs5O537VLWZm6H74wxe5VPQWx5uBvPLAqJZDu0L1RpHeKar26C', 'adger', '18085239001', 1, '2021-10-04 16:07:37', 'http://adger-oss.oss-cn-beijing.aliyuncs.com/adger/images/20211005/cat.jpg', 0, '2021-10-04 00:00:00', 0, 0);
INSERT INTO `ums_member` VALUES (3, 4, '56445651', '$2a$10$Xayfs5O537VLWZm6H74wxe5VPQWx5uBvPLAqJZDu0L1RpHeKar26C', 'wzj', '16578889621', 1, '2021-09-08 17:22:30', NULL, 0, '2009-09-08 17:22:36', 1000, 1000);

-- ----------------------------
-- Table structure for ums_menu
-- ----------------------------
DROP TABLE IF EXISTS `ums_menu`;
CREATE TABLE `ums_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `level` int(4) NULL DEFAULT NULL COMMENT '菜单级数',
  `sort` int(4) NULL DEFAULT NULL COMMENT '菜单排序',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端名称',
  `icon` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端图标',
  `hidden` int(1) NULL DEFAULT NULL COMMENT '前端隐藏',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_menu
-- ----------------------------
INSERT INTO `ums_menu` VALUES (1, 0, '2021-05-30 20:00:33', '权限', 0, 0, 'ums', 'ums', 0);
INSERT INTO `ums_menu` VALUES (2, 1, '2021-05-30 20:02:03', '角色列表', 1, 0, 'role', 'ums-role', 0);
INSERT INTO `ums_menu` VALUES (3, 1, '2021-05-30 20:03:50', '用户列表', 1, 0, 'admin', 'ums-admin', 0);
INSERT INTO `ums_menu` VALUES (4, 1, '2021-05-30 20:04:33', '菜单列表', 1, 0, 'menu', 'ums-menu', 0);
INSERT INTO `ums_menu` VALUES (5, 1, '2021-05-30 20:04:52', '资源列表', 1, 0, 'resource', 'ums-resource', 0);
INSERT INTO `ums_menu` VALUES (6, 0, '2021-07-08 17:30:04', '商品', 0, 0, 'pms', 'pms', 0);
INSERT INTO `ums_menu` VALUES (8, 6, '2021-08-11 18:42:47', '商品列表', 1, 0, 'product', 'pms-product', 0);
INSERT INTO `ums_menu` VALUES (10, 6, '2021-08-11 19:29:05', '添加商品', 1, 0, 'addProduct', 'pms-addProduct', 0);
INSERT INTO `ums_menu` VALUES (11, 0, '2021-08-11 20:11:52', '运动', 0, 0, 'sms', 'sms', 0);
INSERT INTO `ums_menu` VALUES (12, 0, '2021-08-11 20:12:25', '食品', 0, 0, 'fms', 'fms', 0);
INSERT INTO `ums_menu` VALUES (13, 11, '2021-08-11 20:12:58', '运动列表', 1, 0, 'sport', 'sms-sport', 0);
INSERT INTO `ums_menu` VALUES (14, 11, '2021-08-11 20:13:15', '运动分类', 1, 0, 'sportCompose', 'sms-SportCompose', 0);
INSERT INTO `ums_menu` VALUES (15, 11, '2021-08-11 20:13:36', '运动记录', 1, 0, 'calorie', 'sms-history', 0);
INSERT INTO `ums_menu` VALUES (16, 12, '2021-08-11 20:13:56', '食品列表', 1, 0, 'food', 'fms-food', 0);
INSERT INTO `ums_menu` VALUES (17, 12, '2021-08-11 20:14:19', '营养搭配', 1, 0, 'foodCompose', 'fms-FoodCompose', 0);
INSERT INTO `ums_menu` VALUES (18, 11, '2021-08-12 12:43:22', '添加运动', 1, 0, 'addSport', 'sms-addSport', 0);
INSERT INTO `ums_menu` VALUES (19, 12, '2021-10-21 15:19:44', '添加食品', 1, 0, 'addFood', 'fms-add', 0);
INSERT INTO `ums_menu` VALUES (20, 12, '2021-10-21 15:21:19', '食品分类', 1, 0, 'foodCate', 'fms-foodCate', 0);
INSERT INTO `ums_menu` VALUES (21, 0, '2021-10-21 18:49:08', '社区', 0, 0, 'hms', 'hms', 0);
INSERT INTO `ums_menu` VALUES (22, 21, '2021-10-21 18:55:55', '主题管理', 1, 0, 'subject', 'hms-subject', 0);
INSERT INTO `ums_menu` VALUES (25, 21, '2021-10-26 16:07:15', '广告列表', 1, 0, 'advertise', 'hms-advertise', 0);
INSERT INTO `ums_menu` VALUES (26, 21, '2021-11-02 15:41:52', '用户管理', 1, 0, 'member', 'hms-member', 0);

-- ----------------------------
-- Table structure for ums_resource
-- ----------------------------
DROP TABLE IF EXISTS `ums_resource`;
CREATE TABLE `ums_resource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) NULL DEFAULT NULL COMMENT '资源分类ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源URL',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_resource
-- ----------------------------
INSERT INTO `ums_resource` VALUES (1, 1, '2021-05-30 20:07:36', '后台用户管理', '/admin/**', '');
INSERT INTO `ums_resource` VALUES (2, 1, '2021-05-30 20:08:26', '后台角色管理', '/role/**', NULL);
INSERT INTO `ums_resource` VALUES (3, 1, '2021-05-30 20:08:55', '后台菜单管理', '/menu/**', NULL);
INSERT INTO `ums_resource` VALUES (4, 1, '2021-05-30 20:09:18', '后台资源管理', '/resource/**', NULL);
INSERT INTO `ums_resource` VALUES (5, 1, '2021-05-30 20:09:44', '后台资源分类管理', '/resourceCategory/**', NULL);
INSERT INTO `ums_resource` VALUES (6, 4, '2021-10-21 17:10:41', '运动管理', '/sport/**', '');
INSERT INTO `ums_resource` VALUES (7, 4, '2021-10-21 17:11:43', '运动分类管理', '/sportCategory/**', '');
INSERT INTO `ums_resource` VALUES (10, 4, '2021-10-21 18:29:46', '运动记录管理', '/order/**', '可以进行运动记录模块下的所有操作');
INSERT INTO `ums_resource` VALUES (11, 4, '2021-10-21 18:31:54', '查看运动记录管理', '/order/list', '仅仅只能查看运动记录，无法进行其它操作。当然，也无法查看计划详情');

-- ----------------------------
-- Table structure for ums_resource_category
-- ----------------------------
DROP TABLE IF EXISTS `ums_resource_category`;
CREATE TABLE `ums_resource_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `sort` int(4) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_resource_category
-- ----------------------------
INSERT INTO `ums_resource_category` VALUES (1, '2021-05-30 20:06:58', '权限模块', 0);
INSERT INTO `ums_resource_category` VALUES (3, '2021-10-21 17:08:46', '商品模块', 0);
INSERT INTO `ums_resource_category` VALUES (4, '2021-10-21 17:08:56', '运动模块', 0);
INSERT INTO `ums_resource_category` VALUES (5, '2021-10-21 17:09:07', '食品模块', 0);

-- ----------------------------
-- Table structure for ums_role
-- ----------------------------
DROP TABLE IF EXISTS `ums_role`;
CREATE TABLE `ums_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `admin_count` int(11) NULL DEFAULT NULL COMMENT '用户数',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` int(1) NULL DEFAULT 1 COMMENT '状态：0->禁用；1->启用',
  `sort` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_role
-- ----------------------------
INSERT INTO `ums_role` VALUES (1, '超级管理员', '拥有所有的权限', 0, '2021-05-30 19:51:25', 1, 0);
INSERT INTO `ums_role` VALUES (2, '权限管理员', '只能查看及操作权限列表', 0, '2021-05-30 19:52:01', 1, 0);
INSERT INTO `ums_role` VALUES (3, '普通管理员', '只能查看首页', 0, '2021-05-30 19:52:51', 1, 0);
INSERT INTO `ums_role` VALUES (15, '首页管理员', '对首页进行管理', 0, '2021-06-28 19:17:19', 0, 0);

-- ----------------------------
-- Table structure for ums_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_menu_relation`;
CREATE TABLE `ums_role_menu_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 328 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_role_menu_relation
-- ----------------------------
INSERT INTO `ums_role_menu_relation` VALUES (16, 2, 2);
INSERT INTO `ums_role_menu_relation` VALUES (17, 2, 1);
INSERT INTO `ums_role_menu_relation` VALUES (18, 2, 5);
INSERT INTO `ums_role_menu_relation` VALUES (306, 1, 1);
INSERT INTO `ums_role_menu_relation` VALUES (307, 1, 2);
INSERT INTO `ums_role_menu_relation` VALUES (308, 1, 3);
INSERT INTO `ums_role_menu_relation` VALUES (309, 1, 4);
INSERT INTO `ums_role_menu_relation` VALUES (310, 1, 5);
INSERT INTO `ums_role_menu_relation` VALUES (311, 1, 6);
INSERT INTO `ums_role_menu_relation` VALUES (312, 1, 8);
INSERT INTO `ums_role_menu_relation` VALUES (313, 1, 10);
INSERT INTO `ums_role_menu_relation` VALUES (314, 1, 11);
INSERT INTO `ums_role_menu_relation` VALUES (315, 1, 13);
INSERT INTO `ums_role_menu_relation` VALUES (316, 1, 14);
INSERT INTO `ums_role_menu_relation` VALUES (317, 1, 15);
INSERT INTO `ums_role_menu_relation` VALUES (318, 1, 18);
INSERT INTO `ums_role_menu_relation` VALUES (319, 1, 12);
INSERT INTO `ums_role_menu_relation` VALUES (320, 1, 16);
INSERT INTO `ums_role_menu_relation` VALUES (321, 1, 17);
INSERT INTO `ums_role_menu_relation` VALUES (322, 1, 19);
INSERT INTO `ums_role_menu_relation` VALUES (323, 1, 20);
INSERT INTO `ums_role_menu_relation` VALUES (324, 1, 21);
INSERT INTO `ums_role_menu_relation` VALUES (325, 1, 22);
INSERT INTO `ums_role_menu_relation` VALUES (326, 1, 25);
INSERT INTO `ums_role_menu_relation` VALUES (327, 1, 26);

-- ----------------------------
-- Table structure for ums_role_resource_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_resource_relation`;
CREATE TABLE `ums_role_resource_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `resource_id` bigint(20) NULL DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 115 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_role_resource_relation
-- ----------------------------
INSERT INTO `ums_role_resource_relation` VALUES (8, 2, 4);
INSERT INTO `ums_role_resource_relation` VALUES (9, 2, 3);
INSERT INTO `ums_role_resource_relation` VALUES (10, 2, 1);
INSERT INTO `ums_role_resource_relation` VALUES (19, 3, 2);
INSERT INTO `ums_role_resource_relation` VALUES (20, 3, 3);
INSERT INTO `ums_role_resource_relation` VALUES (21, 3, 5);
INSERT INTO `ums_role_resource_relation` VALUES (107, 1, 1);
INSERT INTO `ums_role_resource_relation` VALUES (108, 1, 2);
INSERT INTO `ums_role_resource_relation` VALUES (109, 1, 3);
INSERT INTO `ums_role_resource_relation` VALUES (110, 1, 4);
INSERT INTO `ums_role_resource_relation` VALUES (111, 1, 5);
INSERT INTO `ums_role_resource_relation` VALUES (112, 1, 6);
INSERT INTO `ums_role_resource_relation` VALUES (113, 1, 7);
INSERT INTO `ums_role_resource_relation` VALUES (114, 1, 11);

SET FOREIGN_KEY_CHECKS = 1;
