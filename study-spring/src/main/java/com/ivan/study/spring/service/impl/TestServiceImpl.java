package com.ivan.study.spring.service.impl;

import com.ivan.study.spring.service.TestService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import java.lang.annotation.Annotation;

/**
 * Description:
 * author zhanglc
 * Created on 2018/10/29.
 */

public class TestServiceImpl implements TestService,BeanNameAware ,
        BeanFactoryAware,ApplicationContextAware , InitializingBean {


    @Override
    public String sayHello() {
        return "Hello Spring";
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void setBeanName(String s) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
