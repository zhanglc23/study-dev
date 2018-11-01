package com.ivan.study.utils;

/**
 * Description:
 * author zhanglc
 * Created on 2018/3/8.
 */

public class PrintUtil {

    public static void printArr(int[] args) {
        for (int i = 0 ; i < args.length ; i++) {
            System.out.print(args[i] + "\t");
        }
        System.out.println();
    }
}
