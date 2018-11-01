package com.ivan.study.kafka;

import java.util.Properties;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/16.
 */

public class KafkaClient {

    public static void main(String[] args) {

//        Consumer<String, String> consumer;
//        {
//            consumer = new KafkaConsumer(props);
//        }

    }


    private static Properties getProperties() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "172.16.76.14:9092,172.16.76.20:9092,172.16.76.21:9092";
        props.put("group.id", "ActConsumerGroup");
        props.put("enable.auto.commit", true);
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }
}
