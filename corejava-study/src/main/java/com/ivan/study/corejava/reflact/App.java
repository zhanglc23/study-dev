package com.ivan.study.corejava.reflact;

/**
 * Description:
 * author zhanglc
 * Created on 2018/9/5.
 */

public class App {

    private static String name ;
    private String name1 ;

    static {
        System.out.println("-------------------");
        name = "zhanglicai";
    }

    public App(String name1) {
        System.out.println("+++++++++++");
        this.name1 = name1;
    }
}
