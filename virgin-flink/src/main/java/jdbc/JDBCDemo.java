package jdbc;

import java.sql.*;

/**
 * @author isea_you
 * @date 2019/8/22
 * @time 16:50
 * @target:
 */
public class JDBCDemo {
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test";

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
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            statement = conn.createStatement();
            String sql;
            sql = "SELECT bookid,card FROM book WHERE card = 1;";
            ResultSet resultSet = statement.executeQuery(sql);

            // 展开结果集数据库
            while(resultSet.next()){
                // 通过字段检索
                int bookid  = resultSet.getInt("bookid");
                int card = resultSet.getInt("card");

                // 输出数据
                System.out.print("bookID: " + bookid);
                System.out.print(",card : " + card);
                System.out.println();
            }
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