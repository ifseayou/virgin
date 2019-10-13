package com.isea.clitoris.mybatis.main;

import com.isea.clitoris.mybatis.dao.CodeRatioDao;
import com.isea.clitoris.mybatis.domain.CodeRatio;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

/**
 * @author isea_you
 * @date 2019/10/13
 * @time 9:36
 * @target:
 */
public class CodeRatioDaoMain {
    public static void main(String[] args) throws Exception {
        List<CodeRatio> codeRatios = getConfig();
        for (CodeRatio codeRatio : codeRatios) {
            System.out.println(codeRatio);
        }
    }

    public static List<CodeRatio> getConfig() throws Exception{
        Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
        InputStream resourceAsStream = Resources.getResourceAsStream("db.properties");

        Properties properties = new Properties();
        properties.load(resourceAsStream);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader, properties);
        SqlSession sqlSession = sqlSessionFactory.openSession();


        try {
            CodeRatioDao codeRatioDao = sqlSession.getMapper(CodeRatioDao.class);
            List<CodeRatio> result = codeRatioDao.select();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            sqlSession.commit();
            sqlSession.close();
        }
        return null;
    }
}
