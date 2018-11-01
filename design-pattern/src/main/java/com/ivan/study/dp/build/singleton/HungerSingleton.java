package com.ivan.study.dp.build.singleton;

/**
 * Description:饿汉式 单例模式
 * author zhanglc
 * Created on 2018/10/22.
 */

public class HungerSingleton {

    private static HungerSingleton instance = new HungerSingleton();

    private HungerSingleton() {}

    public static HungerSingleton getInstance() {
        return instance ;
    }

}
