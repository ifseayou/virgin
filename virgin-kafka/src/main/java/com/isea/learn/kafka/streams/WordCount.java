package com.isea.learn.kafka.streams;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

/**
 * @author isea_you
 * @date 2019/10/12
 * @time 13:26
 * @target:
 */
public class WordCount {
    public static void main(String[] args) {
        Properties props = new Properties();
        // 每个stream都需要有一个应用id
        props.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "word count");
        props.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.30:9092");
        props.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> source = builder.stream("seconddata-topic");//执行输入的主题

        final Pattern pattern = Pattern.compile("\\w+");

        KStream<String, String> couts = source.flatMapValues(value -> Arrays.asList(pattern.split(value.toLowerCase())));
        // 这中间进行一系列的操作,来表示Streams 进行的对数据的处理
        couts.to("seconddataclean-topic"); // sink的主题

        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        final CountDownLatch latch = new CountDownLatch(1);

        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread("streams-word-count-shutdown-hook") {
            @Override
            public void run() {
                streams.close();
                latch.countDown();
            }
        });

        try {
            streams.start();
            latch.await();
        } catch (Throwable e) {
            System.exit(1);
        }
        System.exit(0);
    }
}
