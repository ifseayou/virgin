package com.isea.virgin.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

/**
 * @author isea_you
 * @date 2019/8/16
 * @time 14:54
 * @target:
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
        InputStream resourceAsStream = Resources.getResourceAsStream("db.properties");
        Properties properties = new Properties();

        properties.load(resourceAsStream);
        System.out.println(properties);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader,properties);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Employee employee = sqlSession.selectOne("selectEmp", 1);
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }
    }
}
