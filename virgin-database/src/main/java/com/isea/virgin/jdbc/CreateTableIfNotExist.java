package com.isea.virgin.jdbc;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author isea_you
 * @date 2019/9/17
 * @time 18:33
 * @target:
 */
public class CreateTableIfNotExist {
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/db";

/*     MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";*/

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "hailong1996";

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            statement = conn.createStatement();
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd" );
            java.util.Date d= new Date();
            String dateTotal = sdf.format(d);
            String tableName = "status-record-"+ dateTotal;
            String sql;
            sql = "show tables like '" + tableName + "';" ;
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                System.out.println("数据库存在...");
            }else {
                sql = "create table `" + tableName + "`(`KEY`  VARCHAR(24),`timestamp`  VARCHAR(20),`value`  VARCHAR(100),`step`  INT(2));";
                System.out.println(sql);
                statement.executeUpdate(sql);
            }

            String key = "11010800018600030000";
            String value = "you can tell me how big you";
            sql = "insert into `" + tableName + "` values('" + key + "','" + System.currentTimeMillis() + "','" + value + "'," + 1 +")";
            System.out.println(sql);

            statement.executeUpdate(sql);

            // 完成后关闭
            resultSet.close();
            statement.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(statement!=null) statement.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
