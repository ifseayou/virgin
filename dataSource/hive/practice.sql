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

