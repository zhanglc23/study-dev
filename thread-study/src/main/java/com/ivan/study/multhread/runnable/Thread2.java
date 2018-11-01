package com.ivan.study.multhread.runnable;

/**
 * Description:
 * author zhanglc
 * Created on 2017/12/12.
 */

public class Thread2 implements Runnable {

    private String name ;

    public Thread2(String name ) {
        this.name = name ;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 5 ; i++ ) {
            System.out.println( name + "--runnig..." + i);

            try {
                Thread.sleep((int)(Math.random()*10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Thread2("t1")).start();
        new Thread(new Thread2("t2")).start();
    }
}
