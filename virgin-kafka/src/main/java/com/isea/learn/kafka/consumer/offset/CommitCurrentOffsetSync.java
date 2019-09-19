package com.isea.learn.kafka.consumer.offset;

import org.apache.kafka.clients.consumer.*;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author isea_you
 * @date 2019/9/9
 * @time 9:39
 * @target:
 */
public class CommitCurrentOffsetSync {

    public static void main(String[] args) {
            Properties properties = new Properties();
            properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.1.30:9092");

            properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
            properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");

            properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,"isea");

            //创建消费者对象
            KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

            // 订阅主题
            consumer.subscribe(Arrays.asList("test"));

            try{
                while( true ){
                    //拉取数据
                    ConsumerRecords<String, String> records = consumer.poll(100);
                    for (ConsumerRecord<String, String> record : records) {
                        System.out.printf("topic = %s,partition = %s,offset = %s,key = %s,value = %s\n",
                                record.topic(),record.partition(),record.offset(),record.key(),record.value());
                    }
                    try {
                        consumer.commitSync();
                    }catch (CommitFailedException e){
                        e.printStackTrace();
                    }
                }
            }finally {
                consumer.close();
            }
    }
}
