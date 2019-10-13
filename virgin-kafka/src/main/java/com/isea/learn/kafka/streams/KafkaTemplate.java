package com.isea.learn.kafka.streams;

import com.joinbright.iot.streams.KafkaStreamsTemplate;

/**
 * @author isea_you
 * @date 2019/10/12
 * @time 14:00
 * @target:
 */
public class KafkaTemplate {
    public static void main(String[] args) {
        KafkaStreamsTemplate template = new KafkaStreamsTemplate();
        template.execute(t -> t);
    }
}
