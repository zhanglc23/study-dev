package com.ivan.study.multhread.chapter2;

import java.util.concurrent.Callable;

public class Counter2 implements Callable<String> {
    private int countNum;  
    private static int taskCount = 0;//线程id  
    private final int taskId = taskCount++;  
      
    public Counter2(int countNum) {  
        this.countNum = countNum;  
    }  
      
    public String show(){  
        return "Id[" + taskId + "] countNum:" + countNum + "  ";  
    }  
    @Override  
    public String call() throws Exception {  
        String result = null;  
        while(countNum-- > 0){  
            result = show();  
            Thread.yield();  
        }  
        return result;  
    }  
  
}  