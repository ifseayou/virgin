package com.isea.learn.kafka.consumer.offset;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author isea_you
 * @date 2019/9/9
 * @time 10:29
 * @target:
 */
public class CommitCurrentOffsetAsync {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(CommitCurrentOffsetAsync.class);

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
            //                consumer.commitAsync();
                consumer.commitAsync((offsetAndMetadataMap,e)->{
                    if (e != null){
                        logger.error("commit failed for offsets{}",offsetAndMetadataMap,e);
                    }
                });
            }
        }finally {
            consumer.close();
        }
    }
}
