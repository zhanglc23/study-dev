package com.ivan.study.multhread.thread.pentint;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/27.
 */

public class OddPrinter implements Runnable {

    private Number number ;

//    private CyclicBarrier barrier;

//    public OddPrinter(Number number, CyclicBarrier barrier) {
//        this.number = number;
//        this.barrier = barrier;
//    }


    public OddPrinter(Number number) {
        this.number = number;
    }

    public void run() {

        synchronized (number) {

            while (number.value <= 100) {
                if(number.value % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + "   " + number.value);
                    number.value = number.value + 1  ;
                }else {
                    try {
                        number.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                number.notifyAll();
            }
        }
    }
}
