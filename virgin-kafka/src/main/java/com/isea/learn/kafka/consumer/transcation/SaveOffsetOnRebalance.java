package com.isea.learn.kafka.consumer.transcation;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.common.TopicPartition;

import java.util.Collection;

/**
 * @author isea_you
 * @date 2019/9/9
 * @time 15:42
 * @target:
 */
public class SaveOffsetOnRebalance implements ConsumerRebalanceListener {
    @Override
    public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
        // 提交数据库事务，大致的想法是：在处理完记录之后，将记录和偏移量插入数据库，然后在即将失去分区所有权之前提交事务，确保成功保存了这些信息
        commmitDBTranscation();
    }

    private void commmitDBTranscation() {

    }

    @Override
    public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
        for (TopicPartition partition : partitions) {
            // 另外一个虚构的方法，来从数据库中获取偏移量，在分配到分新分区的时候，使用seek()方法定位到那些记录
            seek(partition,getOffsetFromDB(partition));
        }
    }

    private void seek(TopicPartition partition, Object offsetFromDB) {

    }

    private Object getOffsetFromDB(TopicPartition partition) {
        return null;
    }
}
