package com.ivan.study.algorithm.corejava;

/**
 * Description:
 * author zhanglc
 * Created on 2018/6/1.
 */

public class Test {

    public static void main(String[] args) {
        Integer a = 10 ;
        Integer b = new Integer(10) ;
        int c = 10 ;

        Integer a1 = 200 ;
        Integer b1 = new Integer(200) ;
        int c1 = 200 ;

        System.out.println(a == b);  //false
        System.out.println(a == c);  //true
        System.out.println(b == c);  //true

        System.out.println(a1 == b1); //false
        System.out.println(a1 == c1); //true
        System.out.println(b1 == c1); //true

//        int i = 128;
//        Integer i2 = 128;
//        Integer i3 = new Integer(128);
//        System.out.println(i == i2); //Integer会自动拆箱为int，所以为true
//        System.out.println(i == i3); //true，理由同上
//        Integer i4 = 127;//编译时被翻译成：Integer i4 = Integer.valueOf(127);
//        Integer i5 = 127;
//        System.out.println(i4 == i5);//true
//        Integer i6 = 128;
//        Integer i7 = 128;
//        System.out.println(i6 == i7);//false
//        Integer i8 = new Integer(127);
//        System.out.println(i5 == i8); //false
//        Integer i9 = new Integer(128);
//        Integer i10 = new Integer(128);
//        System.out.println(i9 == i10);  //false


    }


}
