package com.isea.clitoris.mybatis.dao;


import com.isea.clitoris.mybatis.domain.StatusRecord;
import org.apache.ibatis.annotations.Param;

/**
 * @author isea_you
 * @date 2019/9/18
 * @time 10:21
 * @target:
 */
public interface StatusRecordDao {
    Integer existTable(String tableName);

    Integer dropTable(@Param("tableName") String tableName);

    Integer createTable(@Param("tableName") String tableName);

    Integer insert(@Param("tableName") String tableName, @Param("statusRecord") StatusRecord statusRecord);
}
