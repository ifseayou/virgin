-- 该文件记录鄙人在进行SQL练习过程中，所写的SQL脚本

reportModelId  null
reportType  "01"
dateFrom  "2019-11-28 00:00"
dateTo "2019-11-28 23:00"
jcsIds ""
yhqyIds  "48315dfe-5522-4ebc-a79e-3a2397b67044"
stationIds  "110116000001,110116000009,110116000010"
devIds  ""

 SELECT dept.DEPT_NAME, station.BDZMC, term.LW_RTU_NAME AS SBMC,
					 CONCAT(term.IMUCODE,term.ZNBM,'0000') AS QJBM,
					 '' AS POWER, 'kWh' AS UNIT FROM us_app.fes_lv_term_info term
					 LEFT JOIN us_app.tv_station station ON station.SBBM = term.stationcode
					 LEFT JOIN us_sys.tb_sys_department dept ON dept.DEPT_ID = term.ZCDW
					 WHERE ("+whereSql+") AND term.ZNBM <> '0000' AND ZNBM <> '9999' and sfaz='T'
					 AND EXISTS (SELECT 1 FROM us_app.fes_yc_define WHERE term_id = term.GUID AND yc_type = '0014')
					ORDER BY term.ZCDW, term.STATIONCODE, term.ORDER_NO, term.ZNBM


whereSql = term.ZCDW IN ('48315dfe-5522-4ebc-a79e-3a2397b67044') OR term.STATIONCODE IN ('110116000001','110116000009','110116000010')

 SELECT dept.DEPT_NAME, station.BDZMC, term.LW_RTU_NAME AS SBMC,
					 CONCAT(term.IMUCODE,term.ZNBM,'0000') AS QJBM,
					 '' AS POWER, 'kWh' AS UNIT FROM us_app.fes_lv_term_info term
					 LEFT JOIN us_app.tv_station station ON station.SBBM = term.stationcode
					 LEFT JOIN us_sys.tb_sys_department dept ON dept.DEPT_ID = term.ZCDW
					 WHERE (term.ZCDW IN ('48315dfe-5522-4ebc-a79e-3a2397b67044') OR term.STATIONCODE IN ('110116000001','110116000009','110116000010')) AND term.ZNBM <> '0000' AND ZNBM <> '9999' and sfaz='T'
					 AND EXISTS (SELECT 1 FROM us_app.fes_yc_define WHERE term_id = term.GUID AND yc_type = '0014')
					ORDER BY term.ZCDW, term.STATIONCODE, term.ORDER_NO, term.ZNBM;




 SELECT GROUP_CONCAT(CONCAT(IMUCODE,ZNBM,'0000')) FROM (
			  SELECT STATIONCODE, IMUCODE, ZNBM FROM us_app.FES_LV_TERM_INFO term WHERE (
			  term.ZCDW IN ('48315dfe-5522-4ebc-a79e-3a2397b67044') OR term.STATIONCODE IN ('110116000001','110116000009','110116000010')
				) AND term.ZNBM <> '0000' and sfaz= 'T'
				 AND EXISTS (SELECT 1 FROM us_app.fes_yc_define WHERE term_id = term.GUID AND yc_type = '0014')
				 ORDER BY term.STATIONCODE, term.ORDER_NO, term.ZNBM ) tmp;


11011600000100090000,11011600000100080000,11011600000100070000,11011600000100060000,11011600000100050000,11011600000100040000,11011600000100030000,11011600000100020000,11011600000100010000,11011600000100110000,11011600000100100000
310115000006




[map type; class java.util.Map, [simple type, class java.lang.String] -> [simple type, class java.lang.String]]



CREATE TABLE `tb_sys_person` (
  `GUID` varchar(42) NOT NULL COMMENT '系统编码',
  `CORP_ID` varchar(5) DEFAULT NULL COMMENT '所属单位',
  `PERS_JOBID` varchar(8) DEFAULT NULL COMMENT '工号',
  `PERS_ID` varchar(42) DEFAULT NULL COMMENT '身份证号',
  `PERS_NAME` varchar(300) DEFAULT NULL COMMENT '人员姓名',
  `LOGO_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '登录ID',
  `EMAIL` varchar(80) DEFAULT NULL COMMENT '邮件地址',
  `LOGO_PASS` varchar(200) DEFAULT NULL COMMENT '登录密码',
  `MOBILE_PHONE` varchar(12) DEFAULT NULL COMMENT '手机号码',
  `PERS_NOTE` varchar(200) DEFAULT NULL COMMENT '备注',
  `DEPT_ID` varchar(42) DEFAULT NULL COMMENT '所属部门',
  `DN` varchar(200) DEFAULT NULL COMMENT 'LDAP 编码',
  `SFDL` varchar(1) DEFAULT NULL COMMENT '是否调离',
  `DLRQ` datetime DEFAULT NULL COMMENT '调离日期',
  `OBJ_CAPTION` varchar(200) DEFAULT NULL,
  `CLS_ID` varchar(42) DEFAULT NULL,
  `ACCOUNT_TYPE` char(7) DEFAULT NULL COMMENT '账号类型',
  `ACCOUNT_STATUS` char(7) DEFAULT NULL COMMENT '账号状态',
  `SLEEP_TIME` datetime DEFAULT NULL COMMENT '开始休眠时间',
  `FLOWSTATUS` varchar(42) DEFAULT NULL,
  `OBJ_DISPIDX` decimal(65,30) DEFAULT NULL,
  `DUTY_ID` varchar(42) DEFAULT NULL COMMENT '岗位ID',
  `DUTY_NAME` varchar(80) DEFAULT NULL COMMENT '岗位名称',
  `GUID_` varchar(42) DEFAULT NULL COMMENT 'GUID_',
  `PORTAL_ID` varchar(42) DEFAULT NULL COMMENT '所属门户ID',
  `NAME_` varchar(80) DEFAULT NULL COMMENT '姓名',
  `SEX_` varchar(2) DEFAULT NULL COMMENT '性别',
  `BIRTHDAY_` varbinary(24) DEFAULT NULL COMMENT '出生年月',
  `CODE_` varchar(42) DEFAULT NULL COMMENT '编码(工号)',
  `IDENTITY_CARD` varchar(42) DEFAULT NULL COMMENT '身份证号',
  `LOGIN_ID` varchar(42) DEFAULT NULL COMMENT '登陆账号',
  `PASSWD_` varchar(200) DEFAULT NULL,
  `E_MAIL` varchar(80) DEFAULT NULL COMMENT '邮箱',
  `PHONE_` varchar(20) DEFAULT NULL COMMENT '电话',
  `COMPANY_ID` varchar(42) DEFAULT NULL COMMENT '公司ID',
  `COMPANY_NAME` varchar(80) DEFAULT NULL COMMENT '公司名称',
  `DEPT_NAME` varchar(80) DEFAULT NULL COMMENT '部门名称',
  `USER_TYPE` varchar(20) DEFAULT NULL,
  `AREA_ID` varchar(42) DEFAULT NULL,
  `LON` varchar(40) DEFAULT NULL,
  `LAT` varchar(40) DEFAULT NULL,
  `STATUS_` varchar(20) DEFAULT NULL,
  `COORDINATE_` varchar(100) DEFAULT NULL,
  `ORDER_NUM` tinyint(1) DEFAULT NULL,
  `ROOTID` varchar(42) DEFAULT NULL COMMENT '根机构id',
  `WEICHART_ID` varchar(80) DEFAULT NULL,
  `QQ_ID` varchar(80) DEFAULT NULL COMMENT 'QQ唯一标识',
  `PERS_IMG` longtext COMMENT '人员头像',
  `REGIST_SOURCE` varchar(1) DEFAULT NULL COMMENT '注册来源（web:1  app:2）',
  `GXQM` varchar(500) DEFAULT NULL,
  `REGISTER_TIME` datetime DEFAULT NULL COMMENT '账号创建时间',
  `CARD_ID` varchar(20) DEFAULT NULL COMMENT '身份证id',
  `CREATE_TIME` datetime DEFAULT NULL,
  `MODITY_TIME` datetime DEFAULT NULL,
  `CREATE_PERSON` varchar(42) DEFAULT NULL,
  `MODITY_PERSON` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`GUID`),
  KEY `IDX_SYS_PERS_DEPTID` (`DEPT_ID`),
  KEY `IDX_TB_SYS_PERSON_PERS_ID` (`PERS_ID`),
  KEY `IDX_TB_SYS_PERSON_DEPT_ID` (`DEPT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='人员表';

CREATE TRIGGER `addPerson` BEFORE INSERT ON `tb_sys_person` FOR EACH ROW begin

set new.GUID_=new.guid;
set new.NAME_ =new.PERS_NAME;
set new.CODE_ =new.PERS_JOBID;
set new.LOGIN_ID =new.LOGO_ID;
set new.PASSWD_ = new.LOGO_PASS;
set new.E_MAIL = new.EMAIL;
set new.PHONE_=new.MOBILE_PHONE;

set new.DEPT_NAME=(select DEPT_NAME FROM us_sys.tb_sys_department WHERE DEPT_ID=NEW.DEPT_ID);

set new.COMPANY_ID = us_sys.getCompany(NEW.DEPT_ID);

set new.COMPANY_NAME=(select DEPT_NAME FROM us_sys.tb_sys_department WHERE DEPT_ID=new.COMPANY_ID);
End;

CREATE TRIGGER `updatePerson` BEFORE UPDATE ON `tb_sys_person` FOR EACH ROW begin

set new.GUID_=new.guid;
set new.NAME_ =new.PERS_NAME;
set new.CODE_ =new.PERS_JOBID;
set new.LOGIN_ID =new.LOGO_ID;
set new.PASSWD_ = new.LOGO_PASS;
set new.E_MAIL = new.EMAIL;
set new.PHONE_=new.MOBILE_PHONE;
if NEW.DEPT_ID!=old.DEPT_ID  then

set new.DEPT_NAME=(select DEPT_NAME FROM us_sys.tb_sys_department WHERE DEPT_ID=NEW.DEPT_ID);

set new.COMPANY_ID = us_sys.getCompany(NEW.DEPT_ID);

set new.COMPANY_NAME=(select DEPT_NAME FROM us_sys.tb_sys_department WHERE DEPT_ID=new.COMPANY_ID);
end if;
end;



CREATE TABLE `tb_sys_department` (
  `GUID` varchar(42) NOT NULL COMMENT '系统编码',
  `CORP_ID` varchar(5) DEFAULT NULL COMMENT '单位ID',
  `DEPT_ID` varchar(42) DEFAULT NULL COMMENT '部门ID',
  `DEPT_NAME` varchar(200) DEFAULT NULL COMMENT '部门名称',
  `DEPT_TYPE` varchar(7) DEFAULT NULL COMMENT '部门类型',
  `SUPER_DEPT` varchar(42) DEFAULT NULL COMMENT '上级部门',
  `DN` text COMMENT 'LDAP同步的结构',
  `SFZF` char(1) DEFAULT NULL COMMENT '标记这个部门是否作废‘空’和‘0’标志未作废，‘1’为以作废',
  `ZFRQ` datetime DEFAULT NULL COMMENT '部门作废的日期',
  `BZ` varchar(500) DEFAULT NULL,
  `DWJB` varchar(7) DEFAULT NULL COMMENT '单位级别',
  `BMQC` varchar(100) DEFAULT NULL COMMENT '部门全称',
  `JC` varchar(50) DEFAULT NULL,
  `SSEJDW` varchar(42) DEFAULT NULL COMMENT '所属二级单位',
  `DDBMJC` varchar(10) DEFAULT NULL,
  `ZYXZ` varchar(7) DEFAULT NULL,
  `SSEJDWMC` varchar(200) DEFAULT NULL,
  `GLFW_DWID` varchar(42) DEFAULT NULL,
  `FULL_NAME` varchar(200) DEFAULT NULL,
  `OBJ_CAPTION` varchar(200) DEFAULT NULL,
  `CLS_ID` varchar(42) DEFAULT NULL,
  `FLOWSTATUS` varchar(42) DEFAULT NULL,
  `OBJ_DISPIDX` decimal(65,30) DEFAULT NULL,
  `ROOT_ID` varchar(42) DEFAULT NULL,
  `ADDRESS` varchar(200) DEFAULT NULL,
  `NATURE` char(7) DEFAULT NULL,
  `LOGO_URL` varchar(200) DEFAULT NULL,
  `LOGO_NAME` varchar(200) DEFAULT NULL,
  `LGTD` varchar(42) DEFAULT NULL,
  `LTTD` varchar(42) DEFAULT NULL,
  `QJBM` varchar(42) DEFAULT NULL,
  `XZQYBM` varchar(10) DEFAULT NULL,
  `SUPER_UNI` varchar(42) DEFAULT NULL,
  `JJ` varchar(1000) DEFAULT NULL,
  `XZQYBM_NAME` varchar(100) DEFAULT NULL,
  `LOGO_IMG` longtext,
  `QYLXR` varchar(50) DEFAULT NULL COMMENT '联系人',
  `QYLXDH` varchar(30) DEFAULT NULL COMMENT '联系电话',
  `LOGODATA` mediumtext COMMENT '外景图片',
  PRIMARY KEY (`GUID`),
  KEY `deptid_index` (`DEPT_ID`),
  KEY `GLFW_DWID_INDEX` (`GLFW_DWID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

CREATE TRIGGER `addDept` AFTER INSERT ON `tb_sys_department` FOR EACH ROW begin
 if new.DWJB='0100201' then
insert into us_sys.tb_sys_organization(GUID_,NAME_,FULL_NAME,CODE_,TYPE_,PARENT_ID,STATUS_)
 values(new.DEPT_ID,new.DEPT_NAME,new.DEPT_NAME,us_sys.nextval('organizationCode'),'单位',new.SUPER_DEPT,'123');
ELSE
insert into us_sys.tb_sys_organization(GUID_,NAME_,FULL_NAME,CODE_,TYPE_,PARENT_ID,STATUS_)
 values(new.DEPT_ID,new.DEPT_NAME,new.DEPT_NAME,us_sys.nextval('organizationCode'),'部门',new.SUPER_DEPT,'123');
end if;
end;

CREATE TRIGGER `updateDept` AFTER UPDATE ON `tb_sys_department` FOR EACH ROW begin
 if new.DWJB='0100201' then
update us_sys.tb_sys_organization set NAME_=new.DEPT_NAME,FULL_NAME=new.DEPT_NAME,TYPE_='单位',PARENT_ID=new.SUPER_DEPT,STATUS_='123' where GUID_=new.DEPT_ID;
ELSE
update us_sys.tb_sys_organization set NAME_=new.DEPT_NAME,FULL_NAME=new.DEPT_NAME,TYPE_='部门',PARENT_ID=new.SUPER_DEPT,STATUS_='123' where GUID_=new.DEPT_ID;
end if;
end;

CREATE TRIGGER `removeDept` AFTER DELETE ON `tb_sys_department` FOR EACH ROW begin
delete from us_sys.tb_sys_organization where GUID_ = old.DEPT_ID;
end;



如果当前登录人是企业人员:                   如何判断是企业的人,还是服务商的人? SELECT dept_id FROM tb_sys_person WHERE pers_id = '';
  a: 找到该企业下的所有部门                 select
  b: 找到该企业下的所有部门对应的所有人


如果当前登录人是服务商人员:
  a: 找到服务商下所有人+服务商下所有企业的所有人
  b: 找到服务商下所有人

如果当前登录人








