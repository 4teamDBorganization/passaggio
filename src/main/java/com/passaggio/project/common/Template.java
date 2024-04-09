package com.passaggio.project.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    private static SqlSessionFactory sqlSessionFactory;

    private Template(){}

    public static SqlSession getSqlSession(){

        if(sqlSessionFactory == null){

            try {
                InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");

                sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            } catch (IOException e) {
                System.out.println("Template.getSqlSession() Error : " + e.getMessage());;
            }

        }

        return sqlSessionFactory.openSession(false);
    }
}
