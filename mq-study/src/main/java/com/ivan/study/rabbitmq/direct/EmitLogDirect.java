package com.ivan.study.rabbitmq.direct;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLogDirect {

    private static final String EXCHANGE_NAME = "direct_logs";
    private static final String EXCHANGE_NAME_ABF = "abf";

    public static void main(String[] argv) throws Exception {
        //创建连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.8.66");
        factory.setUsername("root");
        factory.setPassword("root");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //声明路由器和路由器的类型
//        channel.exchangeDeclare(EXCHANGE_NAME_ABF, BuiltinExchangeType.DIRECT);
        
        String severity = "error";
        String message = ".........i am msg.........";

        //发布消息
        channel.basicPublish(EXCHANGE_NAME_ABF, severity, null, message.getBytes("UTF-8"));
        System.out.println(" [x] Sent '" + severity + "':'" + message + "'");

        channel.close();
        connection.close();
    }
    
}