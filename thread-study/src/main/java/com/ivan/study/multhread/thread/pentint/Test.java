package com.ivan.study.multhread.thread.pentint;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/27.
 */

public class Test {

    public static void main(String[] args) {
        Number number = new Number(0);

        new Thread(new OddPrinter(number) , "odd").start();
        new Thread(new EvenPrinter(number) , "even").start();
    }
}
