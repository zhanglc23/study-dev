package com.ivan.study.dp.proxy;

import java.lang.reflect.Proxy;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/22.
 */

public class Test {
    public static void main(String[] args) {

        IService s = new AService();

        MyProxyHandle h = new MyProxyHandle(s) ;

        IService sp = (IService)Proxy.newProxyInstance(s.getClass().getClassLoader(), s.getClass().getInterfaces(), h);

        sp.save();
        sp.update();


    }
}
