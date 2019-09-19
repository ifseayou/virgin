package com.isea.learn.kafka.consumer.offset;

import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author isea_you
 * @date 2019/9/9
 * @time 11:41
 * @target:
 */
public class CommitSpecificOffset {
    public static void main(String[] args) {
        int count = 0;
        Logger logger = LoggerFactory.getLogger(CommitCurrentOffsetAsync.class);

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.1.30:9092");

        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");

        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,"isea");

        //创建消费者对象
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        // 订阅主题
        consumer.subscribe(Arrays.asList("test"));

        // 用于跟踪偏移量的map
        HashMap<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<>();

        while(true){
            //拉取数据
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("topic = %s,partition = %s,offset = %s,key = %s,value = %s\n",
                        record.topic(),
                        record.partition(),
                        record.offset(),
                        record.key(),
                        record.value());
                //  在读取每条记录之后，使用期望处理的下一个消息的偏移量来更新Map里的偏移量，下一次就从这里开始读取消息。
                currentOffsets.put(new TopicPartition(record.topic(),record.partition()),
                        new OffsetAndMetadata(record.offset() + 1,"no metadata"));
            }
            // 我们决定每处理1000条消息句提交一次偏移量，在实际的开发中，你可以根据时间或者是记录的内容进行提交
            if (count % 1000 == 0) consumer.commitAsync(currentOffsets,null);
            count ++;
        }
    }
}