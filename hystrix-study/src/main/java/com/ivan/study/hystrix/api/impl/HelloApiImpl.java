package com.ivan.study.hystrix.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ivan.study.hystrix.api.HelloApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Description:
 * author zhanglc
 * Created on 2018/7/2.
 */
@Component("helloApi")
@Service
public class HelloApiImpl implements HelloApi {

    private static final Logger logger = LoggerFactory.getLogger(HelloApiImpl.class) ;

    @Override
    public String sayHello(String args) {
        logger.info("sayHello.............{}" , args);
        System.out.println(String.format("sayHello.............%s" , args));
        return "Hello ! this is a test api .";
    }
}
