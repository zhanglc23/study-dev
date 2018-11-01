package com.ivan.study.multhread.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Description:
 * author zhanglc
 * Created on 2018/7/9.
 */

public class Test {

    public static void main(String[] args) {

        Executors.newSingleThreadExecutor();

        Executors.newFixedThreadPool(10) ;

        Executors.newCachedThreadPool();

        Executors.newScheduledThreadPool(19) ;

        ThreadLocal<String> a = new ThreadLocal<String>();


//        ExecutorService

//        ThreadPoolExecutor

    }
}
