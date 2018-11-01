package com.ivan.study.hystrix;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * author zhanglc
 * Created on 2018/7/2.
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-context.xml");


        context.start();

        Thread t = Thread.currentThread();
        synchronized (t) {
            t.wait();
        }

    }


}
