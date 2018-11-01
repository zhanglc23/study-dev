package com.ivan.study.algorithm.recursion;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/27.
 */

public class Factorial {

    public static long fun(long n) {

        //n! = n*(n-1)!
        if(n == 1 ) {
            return 1 ;
        }else {
            return n * fun(n - 1 ) ;
        }
    }

    public static void main(String[] args) {
        System.out.println(fun(4)) ;
    }
}
