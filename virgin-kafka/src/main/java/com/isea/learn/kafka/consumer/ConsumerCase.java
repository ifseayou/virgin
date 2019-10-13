package com.isea.learn.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author isea_you
 * @date 2019/9/7
 * @time 14:39
 * @target:
 */
public class ConsumerCase {
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.1.30:9092");

        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");


        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,"isea");
        properties.put("zookeeper.session.timeout.ms", "500");
        properties.put("zookeeper.sync.time.ms", "250");
        properties.put("auto.commit.interval.ms", "1000");

        //创建消费者对象
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        // 订阅主题
        consumer.subscribe(Arrays.asList("seconddata-topic"));

        try{
            while( true ){
                //拉取数据
                ConsumerRecords<String, String> records = consumer.poll(400);
                for (ConsumerRecord<String, String> record : records) {
                    // 打印数据
                    System.out.println(record.value());
                    System.out.println(record);
                }
            }

        }finally {
            consumer.close();
        }
    }
}
