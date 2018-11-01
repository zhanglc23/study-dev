package com.ivan.study.hystrix;

import com.ivan.study.hystrix.consumer.HelloApiConsuer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * author zhanglc
 * Created on 2018/7/2.
 */

public class ConsumerMain {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-dubbo-consumer.xml");


        context.start();
        HelloApiConsuer bean = (HelloApiConsuer)context.getBean("helloApiConsuer");
        bean.sayHello();
        context.close();

//        Thread t = Thread.currentThread();
//        synchronized (t) {
//            t.wait();
//        }

    }
}
