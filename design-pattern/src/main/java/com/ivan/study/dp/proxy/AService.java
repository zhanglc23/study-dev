package com.ivan.study.dp.proxy;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/22.
 */

public class AService implements IService {
    public void save() {
        System.out.println("------save-------");
    }

    public void update() {
        System.out.println("------update-------");
    }
}
