package com.ivan.study.rabbitmq.work;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import sun.reflect.misc.FieldUtil;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Recv {

    private final static String MQ_USER = "abf";
    private final static String MQ_PWD = "eLTWTqIaFVVkmuUq";
    private final static String MQ_VHOST = "/abf";
    private final static String MQ_EXCHANGE = "abf_x_account";
    private final static String MQ_KEY = "abf_key";
    private final static String QUEUE_NAME = "abf_q_account";
    private static final String MQ_HOST = "172.16.73.157" ;
    static final ThreadLocal<Long> local = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return 0L;
        }
    };

    public static void main(String[] argv) throws Exception {

        ExecutorService service = Executors.newFixedThreadPool(200);



        service.submit(new Runnable() {
            @Override
            public void run() {
                //建立连接和通道
                ConnectionFactory factory = new ConnectionFactory();
                factory.setHost(MQ_HOST);
                factory.setUsername(MQ_USER);
                factory.setPassword(MQ_PWD);
                factory.setVirtualHost(MQ_VHOST);
                try {
                    Connection connection = factory.newConnection();
                    final Channel channel = connection.createChannel();

//                    channel.exchangeDeclare()
                    //声明要消费的队列
                    channel.queueDeclare(QUEUE_NAME, true, false, false, null);
                    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

                    channel.basicQos(100);
                    local.set(local.get().longValue()+100L);
                    System.out.println(local.get().longValue());
                    //回调消费消息
                    final Consumer consumer = new DefaultConsumer(channel) {
                        @Override
                        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                                throws IOException {
                            String message = new String(body, "UTF-8");
                            System.out.println(" [x] Received '" + message + "'");
//                            System.out.println(" [x] Done");
                            channel.basicAck(envelope.getDeliveryTag(), false);
                        }
                    };
                    boolean autoAck = false;
                    channel.basicConsume(QUEUE_NAME, autoAck, consumer);
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        });

    }


    private static void doWork(String task) throws InterruptedException {
        for (char ch : task.toCharArray()) {
//            if (ch == '.') Thread.sleep(1000);
//            Thread.sleep(Integer.valueOf(ch) * 1000);
//            System.out.println("----------" + task);
        }
    }
}