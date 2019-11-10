package com.zhbr.iot.mock;

/**
 * @author isea_you
 * @date 2019/10/23
 * @time 18:42
 * @target:
 */

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.*;
import java.util.concurrent.TimeUnit;

//seconddata-topic
@SuppressWarnings("ALL")
public class
Seconddata {
    private static KafkaProducer<String, String> producer;
    private final static String TOPIC = "seconddata-topic";

    public Seconddata() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.1.30:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //设置分区类,根据key进行数据分区
        producer = new KafkaProducer<String, String>(props);
    }

    public void produce() {
        int i = 1;
        List list = new ArrayList();
        list.add("11010800018300010000");
        list.add("11010800018300020000");
        list.add("11010800018300030000");
        list.add("11010800000400010000");


/*        list.add("31011200000600020000");
        list.add("31011200000600050000");
        list.add("31011200000600060000");
        list.add("31011200000600070000");*/
        List list1 = new ArrayList();
        list1.add("7A07");
        list1.add("0014");
        list1.add("0012");
        list1.add("0001");
        list1.add("0002");
        list1.add("0003");
        list1.add("0004");
        list1.add("0005");
        list1.add("0006");
        list1.add("0008");
        list1.add("1121");
        list1.add("1122");
        list1.add("1123");
        list1.add("0015");
        list1.add("000C");
        list1.add("000D");
        list1.add("000E");

/*
        list1.add("0012");
        list1.add("0013");
*/

//        {"VALUES":["0012=1.020","0013=-0.720","0008=0.873","0007=50.050","0004=6.180","0005=7.860","0006=10.380","1121=388.200","1122=388.100","1123=388.500"],
//        "KEY":"15052500000600600000",
//        "TIMESTAMP":"1566868892000"}


        while (true) {
            for (int j = 0; j < list.size(); j++) {
                Map map = new HashMap();
                String key = list.get(j).toString();
                long time = System.currentTimeMillis();
                String timeStamp = Long.toString(time);
                List value = new ArrayList();
                List list2 = new ArrayList();
                for (int k = 0; k < list1.size(); k++) {
                    long x = (long) (Math.random() * 1000);
                    list2.add(list1.get(k).toString() + "=" + x);
                    map.put("VALUES", list2);
                }
                map.put("KEY", key);
                map.put("TIMESTAMP", timeStamp);
                String msg = JSON.toJSONString(map);
                System.out.println(msg);
                producer.send(new ProducerRecord<String, String>(TOPIC, key ,msg));
            }
//            i++;·


//            if (i == 100) {
//                break;
//            }
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }




        }
//        producer.close();
    }

    public static void main(String[] args) {
        new Seconddata().produce();
    }
}
