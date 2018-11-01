package com.ivan.study.multhread.chapter1;

import com.ivan.study.multhread.chapter2.Counter2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCounter {


    public void testThread(){  
        for(int i = 0; i < 5 ; i++){  
            new Thread(new Counter(10)).start();  
        }  
    }

    public void testExecutor(){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 10 ; i++){
            exec.execute(new Counter(10));
        }
        exec.shutdown();
    }

    public void testCounter2(){
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<Future<String>>();
        for(int i = 0; i < 10 ; i++){
            results.add(exec.submit(new Counter2(10)));
        }
        exec.shutdown();
        for (Future<String> future:results) {
            System.out.println(future.isDone());
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally{
                exec.shutdown();
            }
        }

    }

    public static void main(String[] args) {
        TestCounter counter = new TestCounter();

//        counter.testThread();
//        counter.testExecutor();
        counter.testCounter2();
    }

}  