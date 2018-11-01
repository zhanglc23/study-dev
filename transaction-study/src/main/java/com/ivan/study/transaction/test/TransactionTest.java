package com.ivan.study.transaction.test;

import com.ivan.study.transaction.service.TradeService;
import com.ivan.study.transaction.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.image.VolatileImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 * author zhanglc
 * Created on 2017/11/28.
 */

public class TransactionTest {

    private static final Logger logger = LoggerFactory.getLogger(TransactionTest.class) ;

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");


        UserService userService = (UserService)context.getBean("userService");
        final TradeService tradeService = (TradeService)context.getBean("tradeService");


        ExecutorService service = Executors.newFixedThreadPool(10);


        for(int i  = 0 ; i < 1000 ; i++) {
            logger.info("{}次执行{}" , i , Thread.currentThread().getName());
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    //转账
                    tradeService.transfer("1111111111", "2222222222", 1L);
                }
            };
            service.execute(runnable) ;
        }











    }








}
