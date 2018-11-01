package com.ivan.study.hystrix.commond;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * author zhanglc
 * Created on 2018/7/2.
 */

public class DubboHystrixCommand extends HystrixCommand {

    private final String name;

    protected DubboHystrixCommand(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ExampleGroup-pool"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(4)));

        this.name = name ;
    }

    @Override
    protected Object run() throws Exception {
        System.out.println("running");
        TimeUnit.MILLISECONDS.sleep(1000);
        return "Hello " + name + "!";
    }
}
