package com.isea.virgin;

import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author isea_you
 * @date 2019/9/16
 * @time 18:19
 * @target:
 */
public class RedisVirgin {
    public static void main(String[] args) {
        Jedis jd = new Jedis("192.168.1.30",6379);
        // 测试redis是否连接成功
        System.out.println(jd.ping());

        // 尝试设置一个值，String类型
        System.out.println(jd.set("one", "1")); // 如果设置成功，返回OK

        // 获取刚刚设置的值
        System.out.println(jd.get("one"));

        // list类型设置值
        System.out.println(jd.lpush("two", "2", "2.1", "2.2"));
        System.out.println(jd.lpop("two"));  // lpop类似于出栈操作，一旦出栈，此数据就不在了
        System.out.println(jd.lrange("two",0,-1));
    }
}
