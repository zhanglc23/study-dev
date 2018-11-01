package com.ivan.study;

public class Inc {

    public static void main(String[] args) {
        Inc inc = new Inc();
        int i = 0;
        inc.fermin(i);
        i = i++;
        System.out.println(i);

    }

    void fermin(int i) {

        int a = i++;
        ++a ;
        System.out.println("===="+a);
    }
}