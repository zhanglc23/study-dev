package com.ivan.study.multhread;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/20.
 */

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> list = new ArrayList<String>();

        int count = 0 ;

        for (int i = 0 ; i < 10000; i++) {
            list.add("abc" + i) ;
        }

        ExecutorService service =  Executors.newFixedThreadPool(2);

        for (final String s : list) {

            Future<String> submit = service.submit(new Callable<String>() {
                public String call() throws Exception {
//                    Thread.currentThread().sleep(1000);
                    return s;
                }
            });

            String s1 = submit.get();
            System.out.println("return " + s1 );
            count += 1 ;
            System.out.println(count);

            if(count == list.size()) {
                service.shutdown();
                break;
            }
        }


    }
}
