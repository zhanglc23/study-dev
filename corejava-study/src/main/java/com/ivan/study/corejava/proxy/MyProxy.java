package com.ivan.study.corejava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description:
 * author zhanglc
 * Created on 2018/9/5.
 */

public class MyProxy implements InvocationHandler {

    private Object service ;

    public MyProxy(Object service) {
        this.service = service;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before invocation...");

        System.out.println("invocate method " + method.getName());
        method.invoke(service , args) ;


        System.out.println("after invocation...");




        return null;
    }
}
