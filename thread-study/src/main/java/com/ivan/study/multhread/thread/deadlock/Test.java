package com.ivan.study.multhread.thread.deadlock;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/27.
 */

public class Test {

    public static void main(String[] args) {

        Object a = new Object();
        Object b = new Object();

        Thread ta = new Thread(new MyThread(a , b ));
        Thread ba = new Thread(new MyThread(b , a ));
        ta.start();
        ba.start();


    }

}
