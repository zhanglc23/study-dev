package com.ivan.study.multhread.thread;

/**
 * Description:
 * author zhanglc
 * Created on 2017/12/12.
 */

public class Thread1 extends Thread {

    private static int count = 0 ;

    private String name ;
    public Thread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        for (int i = 0 ; i < 100 ; i++) {
            System.out.println( name + "--runnig..." + i);
            count++ ;
            try {
                sleep((int)(Math.random()*10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread1 t1 = new Thread1("t1") ;
        Thread1 t2 = new Thread1("t2") ;
        t1.start();
        t2.start();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}
