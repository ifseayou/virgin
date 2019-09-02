package com.isea.learn.kafka.producer;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * @author isea_you
 * @date 2019/8/31
 * @time 16:43
 * @target: Kafka生产者案例
 */
public class ProducerCase {
    public static void main(String[] args) {
        //创建配置对象
        Properties properties = new Properties();

        //设置kafka集群，必须的参数
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"hadoop101:9092");

        //序列化 ，必须的参数，必须实现：org.apache.kafka.common.serialization.Serializer接口的类
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        // 缓冲区的大小，默认是32M,生产者使用它缓冲发送到服务器的消息，如果生产过快，send()方法要么被组塞，要么爆出异常
        properties.setProperty(ProducerConfig.BUFFER_MEMORY_CONFIG,"33554432");

        //配置应答机制，等待所有的副本节点的应答，该参数指定了必须有多少分区副本收到消息，生产者才会消息写入是成功的
        properties.setProperty(ProducerConfig.ACKS_CONFIG,"all");

        // 当生产者发送失败的时候，允许最大尝试的次数，如果达到这个次数，生产者会放弃尝试，并返回错误，每次尝试之间的时间间隔是：retry.backoff.ms(默认100ms)
        properties.setProperty(ProducerConfig.RETRIES_CONFIG,"0");

        // 当有多个消息需要被发送到一同一个分区的时候，生产者会将他们放在同一个批次里，当批次填满，批次里的消息会被发送出去，半满的批次或者只有一个消息的
        // 批次也有可能被发送出去，这里这是16k
        properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG,"16384");

        // 指定生产者在发送消息批次之前等待更多的消息加入到批次的时间，生产者会在批次被填满或者是linger.ms达到上限的时候把消息发送出去。
        properties.setProperty(ProducerConfig.LINGER_MS_CONFIG,"10");

        // 指定分区类：
        properties.setProperty(ProducerConfig.PARTITIONER_CLASS_CONFIG,"com.isea.learn.kafka.partition.VirginPartition");

        //创建生产者 从这里开始看kafka的源码，可以看到所有的准备工作
        Producer<String,String> producer = new KafkaProducer<String, String>(properties);

        //准备数据
        String topic = "first";
        String value = "iseayou,you are so handsome...";
        // kafka的生产者，会将发送的数据封装成ProducerRecord对象
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic,value);


        try {
            producer.send(record);
        }catch (Exception e){
            e.printStackTrace();
        }

        //指定分区 ，第二个参数即为分区号，这里
//        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic,1,null,value);

        //生产者发送数据
        producer.send(record);// 这个是异步的方法
        //producer.send(record).get();这个是同步的方法。  这里调用了callable接口的实现类的方法

        //增加回调函数 ，回调方法的主要目的就是看看数据放置到了哪个分区，数据的offset的位置
        // 从send方法进入，可以看到kafka的生产者的发送数据的工作
        producer.send(record, new Callback() { // 这里的方法的第二个参数是可以传入的是一个函数式接口，所以这里可以使用Lambda来实现
            public void onCompletion(RecordMetadata metadata, Exception exception) {

                // 当前的数据发送到了哪一个分区
                System.out.println(metadata.partition());

                // 这里返回的是该元素要保存的数据的offset，发送数据的偏移量
                System.out.println(metadata.offset());
            }
        });

        producer.send(record,(metadata,ex)->{
            if (ex != null){
                ex.printStackTrace();
            }
        });

        //关闭连接
        producer.close();
    }
}
