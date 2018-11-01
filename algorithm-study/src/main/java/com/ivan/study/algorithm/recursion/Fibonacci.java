package com.ivan.study.algorithm.recursion;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/27.
 */

public class Fibonacci {

    public static long fun(long n ) {
        //1,1,2,3,5,8,13,21,34,...
        if(n == 1 || n == 2)
            return 1 ;
        return fun(n-2) + fun(n - 1) ;
    }

    public static void main(String[] args) {
        System.out.println(fun(10)) ;
    }
}
