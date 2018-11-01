package com.ivan.study.multhread.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Description:
 * author zhanglc
 * Created on 2018/9/5.
 */

public class TestA {

    static AtomicLong count = new AtomicLong(0) ;

    public static void main(String[] args) throws InterruptedException {

        List<String> list = new ArrayList<String>();

        for (int i = 0 ; i < 10000 ; i++) {
            list.add(i+"");
        }


        ExecutorService service = Executors.newFixedThreadPool(10);

        for (final String s : list) {

            service.execute(new Runnable() {
                public void run() {
                    count.incrementAndGet();
                    System.out.println(s);

                }
            });
        }


        Thread.sleep(10000);
        System.out.println(count);

    }


}
