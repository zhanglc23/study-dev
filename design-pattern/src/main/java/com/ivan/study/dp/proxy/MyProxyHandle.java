package com.ivan.study.dp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/22.
 */

public class MyProxyHandle implements InvocationHandler {

    private Object target ;

    public MyProxyHandle() {
    }

    public MyProxyHandle(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("------before-------");

        Object invoke = method.invoke(target, args);


        System.out.println("------after-------");
        return invoke;
    }
}
