package com.ivan.study.multhread.thread.proandcus;

import java.util.List;
import java.util.Random;

/**
 * Description:
 * author zhanglc
 * Created on 2018/9/5.
 */

public class Producter implements Runnable {

    private List<String> list ;

    private String name ;

    public Producter(List<String> list, String name) {
        this.list = list;
        this.name = name;
    }

    public void run() {
        while (true) {
            synchronized (list) {
                if(list.size() == 3) {
                    list.notifyAll();
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    Random ra =new Random();
                    String s = ra.nextInt(1000) + "";
                    list.add(s);
                    System.out.println("producer " + name +"  "+s);
                }
            }
        }

    }
}
