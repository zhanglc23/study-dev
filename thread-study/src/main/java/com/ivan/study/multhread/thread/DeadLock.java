package com.ivan.study.multhread.thread;

/**
 * Description:
 * author zhanglc
 * Created on 2018/1/15.
 */

public class DeadLock {

    public static void main(String[] args) {
        DeadLock l1 = new DeadLock();
        DeadLock l2 = new DeadLock();

        new Thread(new MyThread(l1 ,l2 )).start();
        new Thread(new MyThread(l2 ,l1 )).start();

    }

}

class MyThread implements Runnable {
    private DeadLock l1 ;
    private DeadLock l2 ;

    public MyThread(DeadLock l1, DeadLock l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    public void run() {
        synchronized (l1) {
            System.out.println(Thread.currentThread().getName() + "l1 get lock");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (l2) {
                System.out.println(Thread.currentThread().getName() + "l2 get lock");
            }
        }

    }
}
