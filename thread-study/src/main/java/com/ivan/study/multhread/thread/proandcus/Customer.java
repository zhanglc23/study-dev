package com.ivan.study.multhread.thread.proandcus;

import java.util.List;

/**
 * Description:
 * author zhanglc
 * Created on 2018/9/5.
 */

public class Customer implements Runnable {

    private List<String> list ;

    private String name ;

    public Customer(List<String> list, String name) {
        this.list = list;
        this.name = name;
    }

    public void run() {

        while (true) {
            synchronized (list) {
                if(list.size() == 0) {
                    try {
                        list.wait();
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.notifyAll();
                }else {
                    String s = list.get(0);
                    list.remove(0) ;
                    System.out.println("consumer " + name +"  "+s);
                }
            }
        }
    }
}
