package com.ivan.study.corejava.nio.collection.list;

import java.io.IOException;
import java.util.PriorityQueue;

/**
 * Description:
 * author zhanglc
 * Created on 2018/10/30.
 */

public class PriorityQueueTest {



    public static void main(String[] args) {

        final PriorityQueue<String> pq = new PriorityQueue<String>(10);

        for (int i = 0 ; i < 5 ;i++) {
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        String name = Thread.currentThread().getName();
                        boolean offer = pq.offer(name);

                        System.out.println(name+"--->  add " + offer);
                    }
                }
            } , "thread-p-"+i).start();
        }

//        for (int i = 0 ; i < 5 ;i++) {
//            new Thread(new Runnable() {
//                public void run() {
//                    while (true ) {
//                        String e = pq.remove();
//                        System.out.println(e+"--->  remove ");
//                    }
//                }
//            }).start();
//        }

//        try {
//            System.in.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
