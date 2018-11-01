package com.ivan.study.hystrix.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ivan.study.hystrix.api.HelloApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Description:
 * author zhanglc
 * Created on 2018/7/2.
 */
@Component("helloApiConsuer")
public class HelloApiConsuer {

    private static final Logger logger = LoggerFactory.getLogger(HelloApiConsuer.class) ;

    @Reference
    private HelloApi helloApi ;

    public void sayHello() {

        String s = helloApi.sayHello("Hi , this consumer is a test .");
        logger.info("sayHello test ............{}" , s );
        System.out.println(String.format("sayHello test ............%s" , s ));
    }


}
