package com.ivan.study.dp.build.singleton;

/**
 * Description:
 * author zhanglc
 * Created on 2018/10/22.
 */

public class DHLSingleton {

    private static volatile DHLSingleton instance = null ;

    private DHLSingleton(){}

    public static DHLSingleton getInstance() {
        if (null == instance) {
            synchronized (DHLSingleton.class) {
                if (null == instance)
                    instance = new DHLSingleton();
            }
        }
        return instance ;
    }

}
