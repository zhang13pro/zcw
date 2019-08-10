package com.bobo.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: bobobo
 * @Date: 2019/8/8 9:14
 * @Version：1.0
 */
public class DBUtils {

    private static SqlSessionFactory sqlSessionFactory = null;

    private DBUtils() {
    }

    static {
        //获取资源文件流
        String resorce = "SqlMapConfig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resorce);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    /**
     * 获得session对象
     * @return
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
