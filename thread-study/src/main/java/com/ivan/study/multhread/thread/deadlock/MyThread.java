package com.ivan.study.multhread.thread.deadlock;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/27.
 */

public class MyThread implements Runnable {

    private Object objA ;
    private Object objB ;


    public MyThread(Object objA, Object objB) {
        this.objA = objA;
        this.objB = objB;
    }

    public void run() {
        synchronized (objA) {
            System.out.println("11111");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objB){
                System.out.println("222222222");
            }
        }

    }
}
