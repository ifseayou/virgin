package com.isea.clitoris.mybatis;


import com.alibaba.fastjson.JSONObject;
import com.isea.clitoris.mybatis.dao.StatusRecordDao;
import com.isea.clitoris.mybatis.dao.UserDao;
import com.isea.clitoris.mybatis.domain.StatusRecord;
import com.isea.clitoris.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import java.io.InputStream;
import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

/**
 * @author isea_you
 * @date 2019/9/17
 * @time 20:05
 * @target:
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
        InputStream resourceAsStream = Resources.getResourceAsStream("db.properties");

        Properties properties = new Properties();
        properties.load(resourceAsStream);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader, properties);
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        ArrayList<User> userArrayList = new ArrayList<>();
//        userArrayList.add(new User(1,"z3","z3"));
//        userArrayList.add(new User(2,"l4","l4"));
//        userArrayList.add(new User(3,"w5","w5"));
//
//        userDao.insertByList(userArrayList);
//        sqlSession.commit();

//
//        // 查询操作
//        User user = userDao.selectUserById(1);
//        System.out.println(user);
//
//        // 插入操作
//        userDao.insert2User(new User(3, "w5", "w5"));
//        User user1 = userDao.selectUserById(3);
//        System.out.println(user1);


/*        StatusRecordDao statusRecordDao = sqlSession.getMapper(StatusRecordDao.class);
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM");
        String date = df.format(new Date());
        Integer integer = statusRecordDao.existTable("status-record-" + date);
        System.out.println(integer);*/

        SimpleDateFormat df = new SimpleDateFormat("YYYY_MM");
//        String tableName = "status_record_" + df.format(new Date());
        String tableName = "status_record_" + df.format(new Date());
        // 如果有这张表，返回1，如果没有这张表，返回的是0，则创建该表
        Integer isExist = 2;
        String key = "11010800018600030000";
        String value = "{\"TIMESTAMP\":\"1568805998605\",\"VALUES\":[\"7A07=571\",\"0014=121\",\"0012=894\",\"0004=392\",\"0008=532\",\"0015=586\"],\"KEY\":\"11010800018600030000\"}";
        value = JSONObject.parse(value).toString();

        try {
            StatusRecordDao statusRecordDao = sqlSession.getMapper(StatusRecordDao.class);
//            isExist = statusRecordDao.existTable(tableName);
//            if ( 0 == isExist )
//                statusRecordDao.createTable(tableName);
            SimpleDateFormat d = new SimpleDateFormat("YYYY-MM-dd:H:m:s");

            String time = d.format(new Date());
            System.out.println(time);
//            Integer isOne = statusRecordDao.insert(tableName,
//                    new StatusRecord(key, time, value, 1));

            ArrayList<StatusRecord> statusRecords = new ArrayList<>();
            statusRecords.add(new StatusRecord("1", d.format(new Date()),"1",1));
            statusRecords.add(new StatusRecord("2", d.format(new Date()),"2",2));
            statusRecords.add(new StatusRecord("3", d.format(new Date()),"3",3));
            statusRecords.add(new StatusRecord("4", d.format(new Date()),"4",4));

            Integer isOne = statusRecordDao.insertByList(tableName, statusRecords);
            System.out.println(isOne);

            if (0 == isOne){
//                logger.error("插入" + tableName + "失败");
                System.out.println("插入" + tableName + "失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }

//
//        String tableName = "status-record-" + date;
////        statusRecordDao.dropTable(tableName);
//
//        System.out.println(statusRecordDao.createTable("status-record-" + date));
//
//        System.out.println(statusRecordDao.insert(tableName,
//                new StatusRecord("11010800018600030000", "1568776260753", "i miss on you...", 0)));
//
//

    }
}
