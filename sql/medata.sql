/*
Navicat MySQL Data Transfer

Source Server         : K
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : medata

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2020-10-19 12:50:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `client`
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `cid` int NOT NULL COMMENT '客户ID',
  `clientName` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '客户姓名',
  `clientAddress` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '客户住址',
  `phoneNumber` char(11) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  `bankCard` char(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '银行卡号',
  `​credibility` decimal(3,1) DEFAULT NULL COMMENT '信用率',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('20200002', '鄂生', '大连支街61号-7-8', '15701804004', '5222097220556531', '5.7', ' ');
INSERT INTO `client` VALUES ('20200003', '幸芝君', '嘉祥路87号-9-6', '13800632903', '5106677384154966', '5.5', ' ');
INSERT INTO `client` VALUES ('20200004', '汪刚', '河城大厦115号-6-4', '13107457214', '5438680482941333', '8.9', ' ');
INSERT INTO `client` VALUES ('20200005', '曾华', '长安南路38号-16-10', '13604111600', '5324173979089292', '0.9', ' ');
INSERT INTO `client` VALUES ('20200006', '韶君宜', '四方街109号-1-10', '13605530505', '5515052426435424', '9.1', ' ');
INSERT INTO `client` VALUES ('20200007', '隗茜叶', '珠海支街48号-6-5', '15303814209', '5299181779867057', '1.9', ' ');
INSERT INTO `client` VALUES ('20200008', '屠琰', '莒县路74号-2-10', '13402318251', '5265261068073441', '5.5', ' ');
INSERT INTO `client` VALUES ('20200009', '巩欣', '逍遥三大厦108号-7-9', '15203524610', '5516896326987507', '3.1', ' ');
INSERT INTO `client` VALUES ('20200010', '慕安刚', '海江街133号-13-10', '15106240895', '5516289688545891', '7.6', ' ');
INSERT INTO `client` VALUES ('20200011', '羊柔', '历城广场121号-3-4', '15605990446', '5480546732875232', '0.8', ' ');
INSERT INTO `client` VALUES ('20200012', '雍发', '鹊山广场76号-17-8', '15201120560', '5328474741234539', '5.1', ' ');
INSERT INTO `client` VALUES ('20200013', '居栋启', '邹平路20号-12-3', '15302917955', '5405010585838385', '5.1', ' ');
INSERT INTO `client` VALUES ('20200014', '蓬昭爽', '仙游路59号-6-7', '15707761874', '5417124659399996', '9.3', ' ');
INSERT INTO `client` VALUES ('20200015', '殴卿', '奉化街52号-5-8', '13907228348', '5437432719951185', '6.4', ' ');
INSERT INTO `client` VALUES ('20200016', '诸震腾', '堂邑路54号-19-1', '13005773179', '5382261195587048', '5.3', ' ');
INSERT INTO `client` VALUES ('20200017', '吕媛妹', '城阳街46号-12-8', '15104614436', '5290681873421684', '7.7', ' ');
INSERT INTO `client` VALUES ('20200018', '庄安伦', '荷泽三大厦117号-7-3', '15901035058', '5294429351353540', '3.1', ' ');
INSERT INTO `client` VALUES ('20200019', '阳筠岚', '伏龙山路137号-11-10', '13002298116', '5128929225512959', '8.8', ' ');
INSERT INTO `client` VALUES ('20200020', '方杰启', '黑龙江路123号-11-9', '15303415941', '5254141595311626', '8.6', ' ');
INSERT INTO `client` VALUES ('20200021', '墨洁', '德阳路130号-16-10', '15804823158', '5253131751606464', '9.6', ' ');
INSERT INTO `client` VALUES ('20200022', '台荷', '乐清广场70号-4-10', '15905885643', '5498910190356087', '3.2', ' ');
INSERT INTO `client` VALUES ('20200023', '羊琼苑', '团岛二路54号-18-4', '15905161639', '5330313400707581', '7.3', ' ');
INSERT INTO `client` VALUES ('20200024', '游冰', '珠海一广场132号-7-4', '15300458183', '5175030622232051', '2.7', ' ');
INSERT INTO `client` VALUES ('20200025', '禹林', '龙泉路17号-17-4', '13108431005', '5374166409523624', '5.6', ' ');
INSERT INTO `client` VALUES ('20200026', '施雄炎', '山海关路86号-2-6', '15205525632', '5288052503591177', '1.3', ' ');
INSERT INTO `client` VALUES ('20200027', '和林', '鱼山广场89号-12-8', '15608102707', '5516021588554370', '2.7', ' ');
INSERT INTO `client` VALUES ('20200028', '后婉', '清平路76号-13-6', '13204076357', '5371701874043659', '9.2', ' ');
INSERT INTO `client` VALUES ('20200029', '鄂泰朗', '钜野广场147号-9-5', '13005411627', '5202477562739016', '2.6', ' ');
INSERT INTO `client` VALUES ('20200030', '贲爽', '宁武关广场78号-3-4', '13303967966', '5449620172626809', '1.8', ' ');
INSERT INTO `client` VALUES ('20200031', '冯亨', '长兴街32号-3-4', '13204835630', '5451237006516091', '9.3', ' ');
INSERT INTO `client` VALUES ('20200032', '郭巧琬', '澳门一路68号-16-5', '15507808744', '5421073418009301', '9.2', ' ');
INSERT INTO `client` VALUES ('20200033', '西咏', '益都街19号-20-1', '15503053113', '5555429686542597', '1.8', ' ');
INSERT INTO `client` VALUES ('20200034', '哈冠', '沂水路128号-14-2', '15102928177', '5394765813816338', '5.7', ' ');
INSERT INTO `client` VALUES ('20200035', '扈民', '无棣三街56号-5-3', '13702650225', '5533577967090269', '5.2', ' ');
INSERT INTO `client` VALUES ('20200036', '仇宁伦', '大港一广场141号-7-8', '15103523274', '5122344009566146', '3.8', ' ');
INSERT INTO `client` VALUES ('20200037', '充彪若', '武昌路118号-20-9', '13507664243', '5186094983756055', '9.0', ' ');
INSERT INTO `client` VALUES ('20200038', '充冠', '高雄广场126号-18-7', '15005631688', '5461758193443847', '9.9', ' ');
INSERT INTO `client` VALUES ('20200039', '车贵松', '咸阳支街27号-13-6', '13705520560', '5214068238070864', '1.1', ' ');
INSERT INTO `client` VALUES ('20200040', '迟鸣和', '鄱阳湖大厦87号-7-4', '13801113839', '5221163688007788', '9.9', ' ');
INSERT INTO `client` VALUES ('20200041', '池瑞', '仙山东路88号-2-9', '15705187402', '5265198631110393', '7.4', ' ');
INSERT INTO `client` VALUES ('20200042', '耿壮', '秋阳路84号-3-7', '15702688100', '5548744237857389', '6.7', ' ');
INSERT INTO `client` VALUES ('20200043', '文琦', '吉林支路90号-17-4', '15707883775', '5253207157695069', '2.8', ' ');
INSERT INTO `client` VALUES ('20200044', '薛霞', '明水路78号-18-4', '13705112513', '5132319128120809', '2.9', ' ');
INSERT INTO `client` VALUES ('20200045', '爱君', '山口路90号-10-8', '15601340144', '5563435047199506', '6.5', ' ');
INSERT INTO `client` VALUES ('20200046', '鲜娜锦', '夏津大厦93号-7-10', '13704587206', '5105641129070383', '8.8', ' ');
INSERT INTO `client` VALUES ('20200047', '关德', '嘉祥路39号-8-9', '13604550578', '5153573406767061', '8.6', ' ');
INSERT INTO `client` VALUES ('20200048', '徐邦学', '海阳路127号-1-9', '13902442230', '5480638916969830', '9.1', ' ');
INSERT INTO `client` VALUES ('20200049', '宇东', '宝山广场64号-13-2', '15004111940', '5103392548216114', '7.4', ' ');
INSERT INTO `client` VALUES ('20200050', '温晴', '利津路62号-13-7', '13300315760', '5369113101225287', '8.9', ' 她');
INSERT INTO `client` VALUES ('20200051', '端凝思', '仙山西大厦96号-19-10', '13107585998', '5304497877160606', '2.8', ' ');
INSERT INTO `client` VALUES ('20200052', '台菁滢', '海门路138号-14-2', '13008448686', '5207871459803585', '3.8', ' ');
INSERT INTO `client` VALUES ('20200053', '高之', '太平角二广场148号-17-6', '15101293626', '5216705072418406', '9.3', ' ');
INSERT INTO `client` VALUES ('20200054', '宦欣薇', '泰山支路85号-10-3', '15804484853', '5217596196480029', '9.8', ' ');
INSERT INTO `client` VALUES ('20200055', '戎琰', '泰州五街144号-13-7', '15102334681', '5124049072330969', '0.3', ' ');
INSERT INTO `client` VALUES ('20200056', '葛乐顺', '华阳路141号-1-8', '15503946776', '5156182695901089', '2.1', ' ');
INSERT INTO `client` VALUES ('20200057', '岑爽', '红山峡支路128号-14-10', '15900406094', '5264128634722077', '7.6', ' ');
INSERT INTO `client` VALUES ('20200058', '季平康', '昌乐街14号-1-9', '13007548497', '5345146359087750', '4.3', ' ');
INSERT INTO `client` VALUES ('20200059', '佟伯', '郧阳路49号-2-3', '13603804049', '5536735985096067', '0.8', ' ');
INSERT INTO `client` VALUES ('20200060', '廉功', '冠县路75号-13-1', '15204652270', '5243345080014124', '3.8', ' ');
INSERT INTO `client` VALUES ('20200061', '明翔', '天台二路82号-16-8', '13600945757', '5499981267701355', '0.5', ' ');
INSERT INTO `client` VALUES ('20200062', '吴群', '锦州街63号-10-1', '15603735478', '5574021424262856', '6.5', ' ');
INSERT INTO `client` VALUES ('20200063', '武真玲', '观象二路31号-6-10', '13906241266', '5563101798574632', '1.5', ' ');
INSERT INTO `client` VALUES ('20200064', '卞璧璐', '城武支大厦82号-14-2', '13402291540', '5387762561324648', '5.5', ' ');
INSERT INTO `client` VALUES ('20200065', '桑璐', '广州路145号-14-3', '15107361321', '5191305916413850', '2.6', ' ');
INSERT INTO `client` VALUES ('20200066', '庚群震', '沛县路84号-4-5', '13400818975', '5209805679709220', '7.1', ' ');
INSERT INTO `client` VALUES ('20200067', '皮航', '长城南路60号-3-4', '13002821795', '5151363797931910', '7.0', ' ');
INSERT INTO `client` VALUES ('20200068', '雍启保', '长清街13号-8-9', '13707550253', '5386265925389779', '7.4', ' ');
INSERT INTO `client` VALUES ('20200069', '骆子林', '兴安支街103号-4-9', '13901988249', '5323433523885954', '9.8', ' ');
INSERT INTO `client` VALUES ('20200070', '侯蓉霄', '大港纬二路66号-9-10', '13108043716', '5369690782208963', '7.3', ' ');
INSERT INTO `client` VALUES ('20200071', '宇贵', '嘉峪关路69号-3-6', '13203450668', '5378905532546572', '8.4', ' ');
INSERT INTO `client` VALUES ('20200072', '正时', '港联路80号-20-4', '13408807216', '5273144031329811', '4.6', ' ');
INSERT INTO `client` VALUES ('20200073', '郗信力', '泰州街18号-11-1', '13201328700', '5168347997548559', '1.3', ' ');
INSERT INTO `client` VALUES ('20200074', '令毅致', '广州路136号-20-8', '15208125424', '5116775809706465', '8.7', ' ');
INSERT INTO `client` VALUES ('20200075', '戎君', '定陶街37号-6-9', '13500111176', '5168557356229712', '3.3', ' ');
INSERT INTO `client` VALUES ('20200076', '狄会雄', '基隆广场55号-6-8', '15602624612', '5595264992210510', '8.4', ' ');
INSERT INTO `client` VALUES ('20200077', '陈惠岚', '花莲街35号-4-8', '15602279047', '5373251378420647', '1.7', ' ');
INSERT INTO `client` VALUES ('20200078', '微富', '四平路20号-17-3', '15604280913', '5584499337566217', '1.3', ' ');
INSERT INTO `client` VALUES ('20200079', '巩达', '城武大厦61号-16-10', '13905414174', '5118351695508296', '3.8', ' ');
INSERT INTO `client` VALUES ('20200080', '郭枫香', '晓望街43号-10-10', '15306757723', '5453665775705701', '6.5', ' ');
INSERT INTO `client` VALUES ('20200081', '俞鸣鸣', '大港二路74号-19-3', '13706432784', '5172901343866802', '8.6', ' ');
INSERT INTO `client` VALUES ('20200082', '文裕', '大港纬一路77号-9-6', '13904608151', '5219520127466368', '1.0', ' ');
INSERT INTO `client` VALUES ('20200083', '窦娅', '费县路35号-14-5', '15307867151', '5187356818122087', '5.3', ' ');
INSERT INTO `client` VALUES ('20200084', '辕利', '太平角一街85号-20-3', '13205954858', '5298914107782684', '5.0', ' ');
INSERT INTO `client` VALUES ('20200085', '姜雁英', '嫩江广场90号-19-5', '13807188812', '5472192477407434', '5.9', ' ');
INSERT INTO `client` VALUES ('20200086', '牛政', '绍兴广场146号-14-2', '15300680132', '5288632592278404', '6.0', ' ');
INSERT INTO `client` VALUES ('20200087', '束兰', '莒县路31号-7-8', '13107541606', '5347545090921896', '1.9', ' ');
INSERT INTO `client` VALUES ('20200088', '曾兰琳', '埕口路133号-15-3', '15807058034', '5132475719734364', '1.5', ' ');
INSERT INTO `client` VALUES ('20200089', '咸爽莲', '泰州四路27号-14-10', '13507096587', '5575282611958461', '3.7', ' ');
INSERT INTO `client` VALUES ('20200090', '裘柔莲', '苏州街104号-8-2', '13306476410', '5386173940976184', '2.0', ' ');
INSERT INTO `client` VALUES ('20200091', '禄群轮', '松江路34号-15-10', '15600308159', '5157179660881352', '5.0', ' ');
INSERT INTO `client` VALUES ('20200092', '司翰', '南海支路134号-18-6', '15604806056', '5105591230383623', '2.6', ' ');
INSERT INTO `client` VALUES ('20200093', '权善', '逍遥三大厦75号-7-10', '13807074860', '5249644591924431', '9.8', ' ');
INSERT INTO `client` VALUES ('20200094', '笪之', '郭口大厦114号-18-2', '13101982643', '5228472288914993', '1.6', ' ');
INSERT INTO `client` VALUES ('20200095', '伍伊丹', '延安二广场96号-15-6', '13402247069', '5186025928619156', '7.5', ' ');
INSERT INTO `client` VALUES ('20200096', '国华', '台西一大厦23号-17-3', '15500651964', '5252602934241776', '5.8', ' ');
INSERT INTO `client` VALUES ('20200097', '路承', '澄海路12号-1-3', '15306912336', '5277375667430327', '9.9', ' ');
INSERT INTO `client` VALUES ('20200098', '公倩妍', '青岛路85号-6-4', '15806078781', '5157380492676636', '8.2', ' ');
INSERT INTO `client` VALUES ('20200099', '葛舒', '丹阳街134号-6-2', '15208473834', '5345578192052379', '5.5', ' ');
INSERT INTO `client` VALUES ('20200100', '巫锦', '南海大厦146号-15-8', '13104937217', '5292907592986360', '9.4', ' ');
INSERT INTO `client` VALUES ('20200200', '李彦宏', '', '13306780991', '5515052426435424', '0.0', '');

-- ----------------------------
-- Table structure for `factory`
-- ----------------------------
DROP TABLE IF EXISTS `factory`;
CREATE TABLE `factory` (
  `fid` int NOT NULL COMMENT '厂家ID',
  `factoryName` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '厂家名称',
  `factoryAddress` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '厂家地址',
  `postCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '邮政编码',
  `telephoneNumber` char(11) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of factory
-- ----------------------------
INSERT INTO `factory` VALUES ('20200001', '天子药业', '光谷大道1#-1皓月大厦', '430000', '13306780991', ' ');
INSERT INTO `factory` VALUES ('20200002', '康康药业', '光谷大道1#-2小康大厦', '430000', '13006562361', ' ');
INSERT INTO `factory` VALUES ('20200003', '富贵药业', '光谷大道1#-3天河大厦', '430000', '15701015437', ' ');
INSERT INTO `factory` VALUES ('20200004', '升升药业', '光谷大道1#-4升辰大厦', '430000', '15900382405', '');
INSERT INTO `factory` VALUES ('20200005', '内涵药业', '光谷大道1#-5傲日大厦', '430000', '15607770934', '');
INSERT INTO `factory` VALUES ('20200006', '成成药业', '光谷大道1#-6成才大厦', '430000', '15100588561', '');
INSERT INTO `factory` VALUES ('20200007', '亿兆药业', '光谷大道1#-7光兆大厦', '430000', '15606113399', '');
INSERT INTO `factory` VALUES ('20200008', '坤坤大厦', '光谷大道1#-8乾坤大厦', '430000', '13206156364', '');
INSERT INTO `factory` VALUES ('20200009', '白云山药业', '光谷大道1#-9白云大厦', '430000', '15100055533', '');
INSERT INTO `factory` VALUES ('20200010', '风云药业', '白云大道1#-1风云大厦', '430000', '13306780991', 'TEST');
INSERT INTO `factory` VALUES ('20200011', '1', '', '111111', '13306780991', '');
INSERT INTO `factory` VALUES ('20200012', '1', '', '111111', '13306780991', '');
INSERT INTO `factory` VALUES ('20200013', '1', '', '111111', '13306780991', '');
INSERT INTO `factory` VALUES ('20200014', '1', '', '111111', '13306780991', '');

-- ----------------------------
-- Table structure for `ledger`
-- ----------------------------
DROP TABLE IF EXISTS `ledger`;
CREATE TABLE `ledger` (
  `recordId` varchar(23) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '记录ID',
  `type` int DEFAULT NULL COMMENT '类型',
  `​transactionAmount` decimal(10,2) DEFAULT NULL COMMENT '交易金额',
  PRIMARY KEY (`recordId`),
  FULLTEXT KEY `id` (`recordId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ledger
-- ----------------------------
INSERT INTO `ledger` VALUES ('12020052501100800010001', '1', '1080.00');
INSERT INTO `ledger` VALUES ('12020052509025200030001', '1', '108000.00');
INSERT INTO `ledger` VALUES ('12020052509072000060027', '1', '108000.00');
INSERT INTO `ledger` VALUES ('12020052509511700060027', '1', '180000.00');
INSERT INTO `ledger` VALUES ('12020052510173200020002', '1', '180000.00');
INSERT INTO `ledger` VALUES ('12020052514411300020001', '1', '0.00');
INSERT INTO `ledger` VALUES ('12020053021090200030001', '1', '16206.00');
INSERT INTO `ledger` VALUES ('12020061420273800010001', '1', '1210.00');
INSERT INTO `ledger` VALUES ('22020052600023700100001', '2', '1300000.00');
INSERT INTO `ledger` VALUES ('22020052600083900030001', '2', '2600000.00');
INSERT INTO `ledger` VALUES ('22020052600114800050001', '2', '2600000.00');
INSERT INTO `ledger` VALUES ('32020052611013100480002', '3', '1100000.00');
INSERT INTO `ledger` VALUES ('32020052611040100030002', '3', '165.00');

-- ----------------------------
-- Table structure for `medicine`
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine` (
  `mid` int NOT NULL COMMENT '药品ID',
  `medicineName` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '药品名称',
  `manufacturer` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '生产厂家',
  `purchasePrice` decimal(8,2) DEFAULT NULL COMMENT '进货价格',
  `retailPrice` decimal(8,2) DEFAULT NULL COMMENT '零售价格',
  `salePrice` decimal(8,2) DEFAULT NULL COMMENT '批发价格',
  `produceDate` date DEFAULT NULL COMMENT '生产日期',
  `shelfLife` int DEFAULT NULL COMMENT '保质期',
  `character` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '无' COMMENT '性状',
  `dosageForm` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '无' COMMENT '剂型',
  `qualityStandard` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '无' COMMENT '成分',
  `indication` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '无' COMMENT '适应症',
  `aboutUse` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '无' COMMENT '用法用量',
  `taboo` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '无' COMMENT '禁忌',
  `adverseReactions` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '无' COMMENT '不良反应',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES ('20200001', '999感冒灵颗粒', '康康药业', '8.00', '15.00', '10.00', '2010-01-01', '360', '浅棕色至深棕色的颗粒，味甜、微苦。', '颗粒剂', '三叉苦、岗梅、金盏银盘、薄荷油、野菊花、马来酸氯苯那敏、咖啡因、对乙酰氨基酚。辅料为蔗糖粉。', '本品解热镇痛。用于感冒引起的头痛，发热，鼻塞，流涕，咽痛等。', '开水冲服，一次1袋，一日3次。小儿减量或遵医嘱。', '严重肝肾功能不全者禁用。', '偶见皮疹、荨麻疹、药热及粒细胞减少；可见困倦、嗜睡、口渴、虚弱感；长期大量用药会导致肝肾功能异常。');
INSERT INTO `medicine` VALUES ('20200002', '阿莫西林', '天子药业', '100.00', '110.00', '120.00', '2010-01-01', '720', '白色至黄色粉末或颗粒。', '软胶囊', '阿莫西林。', '适用于敏感菌（不产β内酰胺酶菌）所致的感染。', '口服。成人一次0.5g，每6~8小时一次；小儿一日计量按体重20~40mg/Kg，每8小时一次。', '青霉素过敏以及青霉素皮肤实验阳性患者禁用。', '恶心、呕吐、腹泻，皮疹、药物热、哮喘。偶见兴奋、焦虑、失眠和头晕。');
INSERT INTO `medicine` VALUES ('20200003', '新康泰克', null, null, null, null, null, null, '', '', '', '', '', '', '');
INSERT INTO `medicine` VALUES ('20200004', '惠菲宁', null, null, null, null, null, null, '', '', '', '', '', '', '');
INSERT INTO `medicine` VALUES ('20200005', '泰诺林', null, '0.00', '0.00', '0.00', '2010-01-01', '0', 'K', 'K', 'K', 'K', 'K', 'K', 'K');
INSERT INTO `medicine` VALUES ('20200006', '日夜百服宁', null, null, null, null, null, null, '', '', '', '', '', '', '');
INSERT INTO `medicine` VALUES ('20200007', '开瑞能', null, null, null, null, null, null, '', '', '', '', '', '', '');
INSERT INTO `medicine` VALUES ('20200008', '复方阿司匹林', null, null, null, null, null, null, '', '', '', '', '', '', '');
INSERT INTO `medicine` VALUES ('20200009', '散利痛', null, null, null, null, null, null, '', '', '', '', '', '', '');
INSERT INTO `medicine` VALUES ('20200100', 'XXX', null, null, null, null, null, null, '', '', '', '', '', '', '');

-- ----------------------------
-- Table structure for `purchasedetail`
-- ----------------------------
DROP TABLE IF EXISTS `purchasedetail`;
CREATE TABLE `purchasedetail` (
  `purchaseId` varchar(23) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '进货流水号',
  `mid` int DEFAULT NULL COMMENT '药品ID',
  `purchasePrice` decimal(8,2) DEFAULT NULL COMMENT '进货价格',
  `purchaseQuantity` int DEFAULT NULL COMMENT '进货数量',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  KEY `pd_mid` (`mid`),
  KEY `pd_pid` (`purchaseId`),
  CONSTRAINT `pd_mid` FOREIGN KEY (`mid`) REFERENCES `medicine` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pd_pid` FOREIGN KEY (`purchaseId`) REFERENCES `purchasemain` (`purchaseId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of purchasedetail
-- ----------------------------
INSERT INTO `purchasedetail` VALUES ('12020052501000000010001', '20200001', '8.00', '1', '');
INSERT INTO `purchasedetail` VALUES ('12020052501000000010001', '20200002', '10.00', '2', '');
INSERT INTO `purchasedetail` VALUES ('12020052501075900010001', '20200001', '8.00', '10', '');
INSERT INTO `purchasedetail` VALUES ('12020052501075900010001', '20200002', '10.00', '10', '');
INSERT INTO `purchasedetail` VALUES ('12020052501100800010001', '20200001', '8.00', '10', '');
INSERT INTO `purchasedetail` VALUES ('12020052501100800010001', '20200002', '10.00', '100', '');
INSERT INTO `purchasedetail` VALUES ('12020052509025200030001', '20200001', '8.00', '1000', '');
INSERT INTO `purchasedetail` VALUES ('12020052509025200030001', '20200002', '10.00', '10000', '');
INSERT INTO `purchasedetail` VALUES ('12020052509072000060027', '20200001', '8.00', '1000', '');
INSERT INTO `purchasedetail` VALUES ('12020052509511700060027', '20200001', '8.00', '10000', '');
INSERT INTO `purchasedetail` VALUES ('12020052509511700060027', '20200002', '10.00', '10000', '');
INSERT INTO `purchasedetail` VALUES ('12020052510084300040027', '20200001', '8.00', '10000', '');
INSERT INTO `purchasedetail` VALUES ('12020052510084300040027', '20200002', '10.00', '1', '');
INSERT INTO `purchasedetail` VALUES ('12020052510173200020002', '20200001', '8.00', '10000', '');
INSERT INTO `purchasedetail` VALUES ('12020052510173200020002', '20200002', '10.00', '10000', '');
INSERT INTO `purchasedetail` VALUES ('12020053021090200030001', '20200008', '12.00', '999', '');
INSERT INTO `purchasedetail` VALUES ('12020053021090200030001', '20200007', '19.00', '222', '');
INSERT INTO `purchasedetail` VALUES ('12020061420273800010001', '20200002', '12.00', '100', '');
INSERT INTO `purchasedetail` VALUES ('12020061420273800010001', '20200003', '10.00', '1', '');

-- ----------------------------
-- Table structure for `purchasemain`
-- ----------------------------
DROP TABLE IF EXISTS `purchasemain`;
CREATE TABLE `purchasemain` (
  `purchaseId` varchar(23) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '进货流水号',
  `​medicineKinds` int DEFAULT NULL COMMENT '药品种类数',
  `​transactionAmount` decimal(10,2) DEFAULT NULL COMMENT '交易金额',
  `​purchseDate` date DEFAULT NULL COMMENT '进货日期',
  `​fid` int DEFAULT NULL COMMENT '厂家ID',
  `​sid` int DEFAULT NULL COMMENT '职员ID',
  `​remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`purchaseId`),
  KEY `pm_fid` (`​fid`),
  KEY `pm_sid` (`​sid`),
  CONSTRAINT `pm_fid` FOREIGN KEY (`​fid`) REFERENCES `factory` (`fid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pm_sid` FOREIGN KEY (`​sid`) REFERENCES `staff` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of purchasemain
-- ----------------------------
INSERT INTO `purchasemain` VALUES ('12020052500222800010001', '2', '1.00', '2020-05-25', '20200001', '20200001', 'TEST');
INSERT INTO `purchasemain` VALUES ('12020052501000000010001', '2', '0.00', '2020-05-25', '20200001', '20200001', 'TEST');
INSERT INTO `purchasemain` VALUES ('12020052501075900010001', '2', '0.00', '2020-05-25', '20200001', '20200001', 'TEST');
INSERT INTO `purchasemain` VALUES ('12020052501100800010001', '2', '0.00', '2020-05-25', '20200001', '20200001', 'TEST');
INSERT INTO `purchasemain` VALUES ('12020052509025200030001', '2', '0.00', '2020-05-25', '20200003', '20200001', 'TEST');
INSERT INTO `purchasemain` VALUES ('12020052509072000060027', '2', '99999.00', '2020-05-25', '20200006', '20200027', 'TEST');
INSERT INTO `purchasemain` VALUES ('12020052509511700060027', '2', '180000.00', '2020-05-25', '20200006', '20200027', 'TEST');
INSERT INTO `purchasemain` VALUES ('12020052510084300040027', '2', '0.00', '2020-05-25', '20200004', '20200027', '');
INSERT INTO `purchasemain` VALUES ('12020052510173200020002', '2', '180000.00', '2020-05-25', '20200002', '20200002', 'TEST');
INSERT INTO `purchasemain` VALUES ('12020052514411300020001', '2', '0.00', '2020-05-25', '20200002', '20200001', '');
INSERT INTO `purchasemain` VALUES ('12020052600164700010001', '1', '0.00', '2020-05-26', '20200001', '20200001', 'TEST');
INSERT INTO `purchasemain` VALUES ('12020052600165700010001', '1', '0.00', '2020-05-26', '20200001', '20200001', 'TEST');
INSERT INTO `purchasemain` VALUES ('12020052600173000010001', '1', '0.00', '2020-05-26', '20200001', '20200001', 'TEST');
INSERT INTO `purchasemain` VALUES ('12020052600180700010001', '1', '0.00', '2020-05-26', '20200001', '20200001', 'TEST');
INSERT INTO `purchasemain` VALUES ('12020052600185800010001', '1', '0.00', '2020-05-26', '20200001', '20200001', 'TEST');
INSERT INTO `purchasemain` VALUES ('12020053021090200030001', '2', '16206.00', '2020-05-30', '20200003', '20200001', 'TEST');
INSERT INTO `purchasemain` VALUES ('12020061420273800010001', '2', '1210.00', '2020-06-14', '20200001', '20200001', '');

-- ----------------------------
-- Table structure for `retail`
-- ----------------------------
DROP TABLE IF EXISTS `retail`;
CREATE TABLE `retail` (
  `retailId` varchar(23) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '​零售流水号',
  `mid` int DEFAULT NULL COMMENT '药品ID',
  `​retailQuantity` int DEFAULT NULL COMMENT '零售数量',
  `​transactionAmount` decimal(10,2) DEFAULT NULL COMMENT '交易金额',
  `​retailDate` date DEFAULT NULL COMMENT '零售日期',
  `​cid` int DEFAULT NULL COMMENT '客户ID',
  `sid` int DEFAULT NULL COMMENT '职员ID',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`retailId`),
  KEY `r_mid` (`mid`),
  KEY `r_cid` (`​cid`),
  KEY `r_sid` (`sid`),
  CONSTRAINT `r_cid` FOREIGN KEY (`​cid`) REFERENCES `client` (`cid`) ON UPDATE CASCADE,
  CONSTRAINT `r_mid` FOREIGN KEY (`mid`) REFERENCES `medicine` (`mid`) ON UPDATE CASCADE,
  CONSTRAINT `r_sid` FOREIGN KEY (`sid`) REFERENCES `staff` (`sid`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of retail
-- ----------------------------
INSERT INTO `retail` VALUES ('32020052611013100480002', '20200002', '10000', '1100000.00', '2020-05-26', '20200048', '20200002', 'TEST');
INSERT INTO `retail` VALUES ('32020052611040100030002', '20200001', '11', '165.00', '2020-05-26', '20200003', '20200002', 'TEST');

-- ----------------------------
-- Table structure for `saledetail`
-- ----------------------------
DROP TABLE IF EXISTS `saledetail`;
CREATE TABLE `saledetail` (
  `saleId` varchar(23) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '批发流水号',
  `mid` int DEFAULT NULL COMMENT '药品ID',
  `​saleQuantity` int DEFAULT NULL COMMENT '批发数量',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  KEY `sd_mid` (`mid`),
  KEY `sd_sid` (`saleId`),
  CONSTRAINT `sd_mid` FOREIGN KEY (`mid`) REFERENCES `medicine` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sd_sid` FOREIGN KEY (`saleId`) REFERENCES `salemain` (`saleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of saledetail
-- ----------------------------
INSERT INTO `saledetail` VALUES ('22020052600023700100001', '20200001', '10000', '');
INSERT INTO `saledetail` VALUES ('22020052600023700100001', '20200002', '10000', '');
INSERT INTO `saledetail` VALUES ('22020052600083900030001', '20200001', '20000', '');
INSERT INTO `saledetail` VALUES ('22020052600083900030001', '20200002', '20000', '');
INSERT INTO `saledetail` VALUES ('22020052600114800050001', '20200001', '20000', '');
INSERT INTO `saledetail` VALUES ('22020052600114800050001', '20200002', '20000', '');

-- ----------------------------
-- Table structure for `salemain`
-- ----------------------------
DROP TABLE IF EXISTS `salemain`;
CREATE TABLE `salemain` (
  `saleId` varchar(23) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '批发订单号',
  `​medicineKinds` int DEFAULT NULL COMMENT '药品种类数',
  `​transactionAmount` decimal(10,2) DEFAULT NULL COMMENT '交易金额',
  `​saleDate` date DEFAULT NULL COMMENT '批发日期',
  `cid` int DEFAULT NULL COMMENT '客户ID',
  `sid` int DEFAULT NULL COMMENT '职员ID',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`saleId`),
  KEY `sm_cid` (`cid`),
  KEY `sm_sid` (`sid`),
  CONSTRAINT `sm_cid` FOREIGN KEY (`cid`) REFERENCES `client` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sm_sid` FOREIGN KEY (`sid`) REFERENCES `staff` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of salemain
-- ----------------------------
INSERT INTO `salemain` VALUES ('22020052600023700100001', '2', '0.00', '2020-05-26', '20200010', '20200001', 'TEST');
INSERT INTO `salemain` VALUES ('22020052600083900030001', '2', '0.00', '2020-05-26', '20200003', '20200001', 'TEST');
INSERT INTO `salemain` VALUES ('22020052600114800050001', '2', '2600000.00', '2020-05-26', '20200005', '20200001', 'TEST');
INSERT INTO `salemain` VALUES ('22020052600143500080001', '10', '0.00', '2020-05-26', '20200008', '20200001', 'TEST');

-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `sid` int NOT NULL COMMENT '职员ID',
  `staffName` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '职员姓名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '登录密码',
  `birthDate` date DEFAULT NULL COMMENT '出生日期',
  `address` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '住址',
  `phoneNumber` char(11) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  `bankCard` char(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '银行卡号',
  `status` tinyint DEFAULT NULL COMMENT '在职状态',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('20200001', '马化腾', '123456', '1949-01-01', '腾讯大厦1号', '13005502283', '5592221618998459', '1');
INSERT INTO `staff` VALUES ('20200002', '南宫羽', '333333', '1900-01-01', '长春街95号-20-4', '15803692207', '5130968390240810', '0');
INSERT INTO `staff` VALUES ('20200003', '暨宁', 'kCQr1.WY:6', '2000-09-01', '南口广场96号-4-8', '15606205573', '5220567093051903', '1');
INSERT INTO `staff` VALUES ('20200004', '索琦', 'Ih9\\0yR8#P', '2000-09-01', '邹平路91号-3-4', '15107657837', '5472519980673682', '1');
INSERT INTO `staff` VALUES ('20200005', '孙志', 'ZbstC^\\Z`N', '2000-09-01', '华阳路141号-19-2', '15300811596', '5337973278266243', '1');
INSERT INTO `staff` VALUES ('20200006', '蓟福榕', '1GE7@O2jmG', '2000-09-01', '台西纬三广场84号-12-7', '15806356383', '5349939188587495', '1');
INSERT INTO `staff` VALUES ('20200007', '倪昌政', '92ph\\w)Y2p', '2000-09-01', '江苏广场116号-11-7', '13904348210', '5494111305517234', '1');
INSERT INTO `staff` VALUES ('20200008', '南鸣邦', '9[9E;MR3Yq', '2000-09-01', '银川西路127号-6-5', '15704928468', '5534752094072287', '1');
INSERT INTO `staff` VALUES ('20200009', '祁枫', '&BbF2Z\'d68', '2000-09-01', '洮南大厦38号-8-7', '13902426653', '5443971722840325', '1');
INSERT INTO `staff` VALUES ('20200010', '益秋', '0vnbkjz5/s', '2000-09-01', '招远街34号-6-9', '15202270760', '5260001664497544', '1');
INSERT INTO `staff` VALUES ('20200011', '越韵', 'n_>=y2<F.1', '2000-09-01', '三明北街136号-9-8', '15803133362', '5232750466690145', '1');
INSERT INTO `staff` VALUES ('20200012', '薛彬', '0D86#5OHv5', '2000-09-01', '峄县路46号-19-10', '13806367830', '5543689088988392', '1');
INSERT INTO `staff` VALUES ('20200013', '刘彩瑾', 'z8CxbSAm56', '2000-09-01', '安庆路54号-4-5', '13900132073', '5142230870141935', '1');
INSERT INTO `staff` VALUES ('20200014', '梁思', '`vFXl|qE9&', '2000-09-01', '夏庄街道59号-11-1', '13202165950', '5153343831223639', '1');
INSERT INTO `staff` VALUES ('20200015', '谷眉菊', 'Y-(r21|1De', '2000-09-01', '台东东七广场19号-11-2', '15608813138', '5298480976001069', '1');
INSERT INTO `staff` VALUES ('20200016', '元芬菊', 'vr7Om\",\"PI', '2000-09-01', '江西支街134号-14-10', '13205878441', '5254729108512548', '1');
INSERT INTO `staff` VALUES ('20200017', '洪瑗', '?:Zxy@~W_B', '2000-09-01', '临淮关大厦38号-19-9', '15902854316', '5496076752358002', '1');
INSERT INTO `staff` VALUES ('20200018', '吴宜玉', '4%B+eL7100', '2000-09-01', '峄县路86号-19-4', '13601312495', '5431985540496239', '1');
INSERT INTO `staff` VALUES ('20200019', '徒融', 'oE-qQE63w5', '2000-09-01', '台东四路59号-11-8', '13402252076', '5284549934351489', '1');
INSERT INTO `staff` VALUES ('20200020', '年叶嘉', 'J608+r81WV', '2000-09-01', '大麦岛54号-10-5', '13702493085', '5178679265123923', '1');
INSERT INTO `staff` VALUES ('20200021', '花菁', '6O69zLw3d:', '2000-09-01', '徐州大厦28号-17-2', '15801966672', '5135200055694833', '1');
INSERT INTO `staff` VALUES ('20200022', '墨青环', '0`~D4<@0N8', '2000-09-01', '三明南路119号-19-3', '13007784806', '5294354856112334', '1');
INSERT INTO `staff` VALUES ('20200023', '门黛', '76#[KV9Wc2', '2000-09-01', '大尧二路29号-12-1', '13704314890', '5457376528950828', '1');
INSERT INTO `staff` VALUES ('20200024', '鲜彬志', '0R*Iv\\Y9%2', '2000-09-01', '丹东街63号-13-5', '15001664458', '5160194619514728', '1');
INSERT INTO `staff` VALUES ('20200025', '孙滢', '/B9yR<=L0#', '2000-09-01', '恒山路136号-3-9', '15005862729', '5143858632762033', '1');
INSERT INTO `staff` VALUES ('20200026', '郝姣', '4;NQ<2~~M{', '2000-09-01', '肥城街67号-8-3', '15507987084', '5387929462658859', '1');
INSERT INTO `staff` VALUES ('20200027', '卓群', 'KAG1823', '2000-09-01', '华山路24号-5-7', '15001548113', '5251509215190260', '1');
INSERT INTO `staff` VALUES ('20200028', '李超晨', '>K8$R52yIf', '2000-09-01', '居庸关街29号-17-3', '15600286701', '5511835160727756', '1');
INSERT INTO `staff` VALUES ('20200029', '刘翔以', 'a37bE0&l-x', '2000-09-01', '莲岛大厦41号-2-5', '15607590453', '5407518774110992', '1');
INSERT INTO `staff` VALUES ('20200030', '后欢茗', '~E7]p8<*<5', '2000-09-01', '吉林路105号-6-8', '13501964426', '5314059555028428', '1');
INSERT INTO `staff` VALUES ('20200031', '陶鸣峰', ':7#Vr7chMc', '2000-09-01', '磁山路69号-11-1', '15203972758', '5283494212506689', '1');
INSERT INTO `staff` VALUES ('20200032', '宫朗', '2)7#}GjP9D', '2000-09-01', '黑龙江路11号-19-3', '13200366600', '5196098659812413', '1');
INSERT INTO `staff` VALUES ('20200033', '鄢璧', 'c6OPgB0v$Z', '2000-09-01', '台东一街34号-6-9', '13305810749', '5548908398320426', '1');
INSERT INTO `staff` VALUES ('20200034', '延美', 'R_L5kWrLPP', '2000-09-01', '聊城大厦131号-17-8', '13908040027', '5210854977716070', '1');
INSERT INTO `staff` VALUES ('20200035', '百志', 'S3@gf70HW8', '2000-09-01', '白塔广场80号-2-7', '13107160839', '5560263756245903', '1');
INSERT INTO `staff` VALUES ('20200036', '谷静婉', 'NCnY&f90Ub', '2000-09-01', '香港中大厦113号-14-2', '13302217057', '5247571112138872', '1');
INSERT INTO `staff` VALUES ('20200037', '荣之', '51aFGfVMR%', '2000-09-01', '武定路107号-1-3', '13406065324', '5106136696830383', '1');
INSERT INTO `staff` VALUES ('20200038', '梅惠', 'dY<WLM>f=+', '2000-09-01', '徐州大厦30号-12-3', '13701505338', '5340763969751701', '1');
INSERT INTO `staff` VALUES ('20200039', '周善翰', '?oP)Awn0XD', '2000-09-01', '临朐路58号-10-2', '13901861319', '5296717589370676', '1');
INSERT INTO `staff` VALUES ('20200040', '桑光', '7Nr/eh[-on', '2000-09-01', '定陶街93号-16-5', '15203918647', '5132447218486374', '1');
INSERT INTO `staff` VALUES ('20200041', '门彬', 'Sfk7q8`dtD', '2000-09-01', '益都街62号-6-2', '13608474438', '5165599723056363', '1');
INSERT INTO `staff` VALUES ('20200042', '娄瑶香', '7bHU9{n0[A', '2000-09-01', '惠民街126号-8-1', '13706913247', '5361288454513923', '1');
INSERT INTO `staff` VALUES ('20200043', '桑琼希', '8P&94Bip]K', '2000-09-01', '珠海一广场137号-20-6', '13203113021', '5262205154740564', '1');
INSERT INTO `staff` VALUES ('20200044', '伍华', 'UP)jY.Y@dt', '2000-09-01', '台西纬五路99号-6-3', '15705071423', '5373076405858455', '1');
INSERT INTO `staff` VALUES ('20200045', '冉咏', 'u,Xk.\'9u.o', '2000-09-01', '丰海路97号-9-1', '15307506437', '5358715486624158', '1');
INSERT INTO `staff` VALUES ('20200046', '官伊英', ';XhpLtpINv', '2000-09-01', '寿光广场14号-20-5', '13107411005', '5283169780278883', '1');
INSERT INTO `staff` VALUES ('20200047', '陶莲', 'wN$K75|S00', '2000-09-01', '芙蓉山村38号-17-2', '15802793414', '5531852456503698', '1');
INSERT INTO `staff` VALUES ('20200048', '凤姬玉', 'F%A8U\'A3uf', '2000-09-01', '海游路79号-4-9', '15306040855', '5370094718784287', '1');
INSERT INTO `staff` VALUES ('20200050', '广龙雄', '@8fNk4%Mpu', '2000-09-01', '仙山街95号-10-9', '15707519057', '5414525248557030', '1');
INSERT INTO `staff` VALUES ('20200051', '马化腾', '4oj,=`/G&m', '1971-10-29', '南山大道90号-20-2', '13807378437', '5579823916360931', '1');
INSERT INTO `staff` VALUES ('20200052', '马化腾', 'cv1\\GCf\\Bu', '1971-10-29', '红山峡路115号-11-9', '13808862482', '5394456946475479', '1');
INSERT INTO `staff` VALUES ('20200101', '季承时', '~:wJReWJ90', '1900-01-01', '人和路24号-2-1', '13206015919', '5305478372724947', '1');
INSERT INTO `staff` VALUES ('20200102', '寇妍舒', '$QK9-2rQN3', '1900-01-01', '宁夏路72号-8-8', '13004514200', '5228001374907908', '1');
INSERT INTO `staff` VALUES ('20200103', '樊芳', 'v7E5GcnmC,', '1900-01-01', '蒙阴大厦143号-20-10', '13300787218', '5346134396003484', '0');
INSERT INTO `staff` VALUES ('20200104', '雍艺素', 'XKCVHsd/^D', '1900-01-01', '太平角六街114号-8-9', '15106766265', '5547625894453938', '1');
INSERT INTO `staff` VALUES ('20200105', '雍艺素', 'XKCVHsd/^D', '1900-01-01', '太平角六街114号-8-9', '15106766265', '5547625894453938', '1');
INSERT INTO `staff` VALUES ('20200106', '贲梦雅', '+(6:7UOaIJ', '1900-01-01', '观海一路87号-7-2', '15802576261', '5385949966991640', '1');
INSERT INTO `staff` VALUES ('20200200', '李想', '12345678', '1900-01-01', '', '13611339958', '5222097220556531', '1');

-- ----------------------------
-- Table structure for `stock`
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `mid` int DEFAULT NULL COMMENT '药品ID',
  `stockQuantity` int DEFAULT NULL COMMENT '库存数量',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  KEY `s_mid` (`mid`),
  KEY `quantity` (`stockQuantity`),
  CONSTRAINT `s_mid` FOREIGN KEY (`mid`) REFERENCES `medicine` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES ('20200001', '11000', '');
INSERT INTO `stock` VALUES ('20200002', '10099', '');
INSERT INTO `stock` VALUES ('20200003', '10112', '');
INSERT INTO `stock` VALUES ('20200003', '334', '');
INSERT INTO `stock` VALUES ('20200004', '9821', '');
INSERT INTO `stock` VALUES ('20200005', '8764', '');
INSERT INTO `stock` VALUES ('20200006', '1345', '');
INSERT INTO `stock` VALUES ('20200007', '5900', '');
INSERT INTO `stock` VALUES ('20200008', '2999', '');
INSERT INTO `stock` VALUES ('20200009', '0', '');
INSERT INTO `stock` VALUES ('20200100', '0', '');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户姓名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `age` int DEFAULT NULL COMMENT '用户姓名',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户性别',
  `signature` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '个性签名',
  `phonenumber` char(11) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=20200029 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('20200001', 'Khighness', '111111', '18', '女', '我炒菜', '13611339958');
INSERT INTO `user` VALUES ('20200002', 'Kirby', 'wfszs', '20', '男', '我最帅', '15105692328');
INSERT INTO `user` VALUES ('20200003', '章难', 'zhangnan', '19', '男', '太难了', '13200227520');
INSERT INTO `user` VALUES ('20200004', '坤哥', 'kunge', '19', '男', '奥里给', '13006795265');
INSERT INTO `user` VALUES ('20200005', '然然', '1314520', '18', '女', '冲鸭', '15300014317');
INSERT INTO `user` VALUES ('20200006', '二营长', '222222', '21', '2', '22222', '13303365979');

-- ----------------------------
-- View structure for `me_st`
-- ----------------------------
DROP VIEW IF EXISTS `me_st`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `me_st` AS select `medicine`.`mid` AS `药品ID`,`medicine`.`medicineName` AS `药品名称`,`stock`.`stockQuantity` AS `库存数量`,`stock`.`remark` AS `备注` from (`medicine` left join `stock` on((`medicine`.`mid` = `stock`.`mid`))) ;
