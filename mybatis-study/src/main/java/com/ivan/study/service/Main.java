package com.ivan.study.service;

import com.ivan.study.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Description:
 * author zhanglc
 * Created on 2018/4/9.
 */

public class Main {

    public static void main(String[] args) {


//        BeanFactory

//        FactoryBean
        SortedMap<String,String> map = new TreeMap<>() ;

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        SqlSessionFactory factory = (SqlSessionFactory)context.getBean("sqlSessionFactory");
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class) ;

        mapper.selectByPrimaryKey(1) ;
        mapper.selectByPrimaryKey(1) ;

        sqlSession.commit();

        SqlSession sqlSession1 = factory.openSession();
        sqlSession1.getMapper(UserMapper.class).selectByPrimaryKey(1) ;
        sqlSession1.commit();



    }
}
