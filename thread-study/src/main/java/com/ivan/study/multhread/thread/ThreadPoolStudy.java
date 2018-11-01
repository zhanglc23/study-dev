package com.ivan.study.multhread.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Description:
 * author zhanglc
 * Created on 2018/9/10.
 */

public class ThreadPoolStudy {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        final List<String> list = new ArrayList<String>();

        for (int i = 0 ; i < 10000 ; i++) {
            list.add(i +"") ;
        }


        ExecutorService service = Executors.newFixedThreadPool(50);

        for (final  String s : list) {
            service.execute(new Runnable() {
                public void run()  {
                    System.out.println(s);
//                    Thread.sleep(1L);
//                    return "S";
                }
            });
//            System.out.println("s = " + s + " S = " + (String) submit.get());
            System.out.println("s = " + s );
        }
        System.out.println("end-------------");



    }



}
