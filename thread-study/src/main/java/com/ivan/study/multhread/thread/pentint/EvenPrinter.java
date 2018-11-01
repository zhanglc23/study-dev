package com.ivan.study.multhread.thread.pentint;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/27.
 */

public class EvenPrinter implements Runnable{

    private Number number ;

    public EvenPrinter(Number number) {
        this.number = number;
    }

    public void run() {
        while (number.value <= 100) {
            synchronized (number) {
                if(number.value % 2 == 0) {
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
