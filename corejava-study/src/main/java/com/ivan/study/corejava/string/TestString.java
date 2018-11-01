package com.ivan.study.corejava.string;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/20.
 */

public class TestString {

    public static void main(String[] args) {
//        String s = new String("1");
//        s.intern();
//        String s2 = "1";
//        System.out.println(s == s2);
//
//        String s3 = new String("1") + new String("1");
//        s3.intern();
//        String s4 = "11";
//        System.out.println(s3 == s4);

//        String s = new String("1");
//        String s2 = "1";
//        s.intern();
//        System.out.println(s == s2);
//
//        String s3 = new String("1") + new String("1");
//        String s4 = "11";
//        s3.intern();
//        System.out.println(s3 == s4);

//        String str1 = "a";
//        String str2 = "b";
//        String str3 = "ab";
//        String str4 = str1 + str2;
//        String str5 = new String("ab");
//
//        System.out.println(str5.equals(str3));
//        System.out.println(str5 == str3);
//        System.out.println(str5.intern() == str3);
//        System.out.println(str5.intern() == str4);


        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);

        //JDK1.6以及以下：false false
        //JDK1.7以及以上：false true



//        String s = new String("1");
//        String s2 = "1";
//        s.intern();
//        System.out.println(s == s2);
//
//        String s3 = new String("1") + new String("1");
//        String s4 = "11";
//        s3.intern();
//        System.out.println(s3 == s4);
        //JDK1.6以及以下：false false
        //JDK1.7以及以上：false false
    }

}
