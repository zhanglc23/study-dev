package com.ivan.study.multhread.thread.pentint;

import java.util.concurrent.CountDownLatch;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/27.
 */

public class CountDownLatchTest {

    private static CountDownLatch latch = new CountDownLatch(2);

    private static long num = 0 ;

    private static volatile Boolean flag = true;


    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            public void run() {
                while (num <= 10000) {
                    if (flag) {
                        System.out.println(Thread.currentThread().getName()+"   "+ num);
                        num++ ;
                        flag = false ;
                    }
                }
                latch.countDown();

            }
        } , "even").start();


        new Thread(new Runnable() {
            public void run() {
                while (num <= 10000) {
                    if (!flag) {
                        System.out.println(Thread.currentThread().getName()+"   "+ num);
                        num++ ;
                        flag = true ;
                    }
                }
                latch.countDown();
            }
        } , "odd").start();

        latch.await();
    }





}
