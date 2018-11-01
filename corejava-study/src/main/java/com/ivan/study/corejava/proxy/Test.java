package com.ivan.study.corejava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Description:
 * author zhanglc
 * Created on 2018/9/5.
 */

public class Test {

    public static void main(String[] args) {


        Service s = new ServiceImpl();

        InvocationHandler p = new MyProxy(s);

        Service o = (Service)Proxy.newProxyInstance(p.getClass().getClassLoader(), s.getClass().getInterfaces(), p);

        System.out.println(o.getClass().getName());
        o.sayHello("zhanglicai");


    }

}
