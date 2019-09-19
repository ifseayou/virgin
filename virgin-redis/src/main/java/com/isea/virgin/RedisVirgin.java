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

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd" );
        Date d= new Date();
        String totalSize = sdf.format(d);
        System.out.println(jd.ping());
        jd.set(totalSize,"50");
        System.out.println(jd.get(totalSize));
        System.out.println("-------------");

        System.out.println(jd.set(totalSize, String.valueOf(Integer.valueOf(jd.get(totalSize)) + 20)));
        System.out.println(jd);
    }
}
