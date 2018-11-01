package com.ivan.study.dp.build.singleton;

/**
 * Description: 懒汉式单例模式
 * author zhanglc
 * Created on 2018/10/22.
 */

public class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton() {}

    public static synchronized LazySingleton getInstance() {
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
