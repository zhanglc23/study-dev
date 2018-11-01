package com.ivan.study.multhread.thread.proandcus;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * author zhanglc
 * Created on 2018/9/5.
 */

public class TestPC {

    static ThreadLocal tm = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {

//        List<String> list = new ArrayList<String>();
//
//        for (int i = 0 ; i < 10 ; i++) {
//            new Thread(new Producter(list , i+"")).start();
//        }
//        for (int j = 0 ; j < 10 ; j++) {
//            new Thread(new Customer(list , j+"")).start();
//        }

        for (int i = 0 ; i < 10 ; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0 ; j < 100 ; j++) {
                        tm.set((Integer)tm.get()+1);
                    }
                    System.out.println(tm.get());
                }
            } , "C"+i).start();
        }

        System.out.println(tm.get());


    }




}
