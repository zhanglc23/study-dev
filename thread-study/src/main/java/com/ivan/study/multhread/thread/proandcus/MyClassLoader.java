package com.ivan.study.multhread.thread.proandcus;

/**
 * Description:
 * author zhanglc
 * Created on 2018/9/5.
 */

public class MyClassLoader extends ClassLoader {


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
