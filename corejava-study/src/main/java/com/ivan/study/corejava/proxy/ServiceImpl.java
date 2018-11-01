package com.ivan.study.corejava.proxy;

/**
 * Description:
 * author zhanglc
 * Created on 2018/9/5.
 */

public class ServiceImpl implements Service {
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
