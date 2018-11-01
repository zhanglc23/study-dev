package com.ivan.study.service;

public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("Method 1 start");
        }
    }

    public static void main(String[] args) {

    }
}