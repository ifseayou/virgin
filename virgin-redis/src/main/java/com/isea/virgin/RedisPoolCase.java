package com.isea.virgin;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @author isea_you
 * @date 2019/10/13
 * @time 14:33
 * @target:
 */
public class RedisPoolCase {
    public static void main(String[] args) {
        getSnapShot("310115000035000100000012");
    }

    public static void getSnapShot(String point){
        List<String> result ;
        String host="192.168.1.212";
        int port=6379;
        String password="sys";
        int database=5;
        int maxTotal=200;
        int maxIdle=100;
        int maxWaitMillis=15000;
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(maxWaitMillis);
        config.setMaxTotal(maxTotal);
        config.setTestOnBorrow(false);
        config.setTestOnReturn(true);
        JedisPool jp = new JedisPool(config,host,port);
        Jedis jedis = null;
        try {
            jedis = jp.getResource();
            jedis.auth(password);
            jedis.select(database);

            ArrayList<String> list = new ArrayList<>();
            list.add("110108000186000300007A07");
            list.add("110108000186000400007A07");
            list.add("110108000186000500007A07");
            list.add("110108000004000100007A07");

            result = jedis.hmget("overrideConfig",String.valueOf(list));
            System.out.println(jedis.hget("overrideConfig", "110108000004000100007A07"));
            for (String s : result) {
                System.out.println("result: "+s);
            }

            List<String> overrideConfig = jedis.hmget("overrideConfig", "110108000004000100007A07", "110108000186000400007A07");
            for (String s : overrideConfig) {
                System.out.println("s" + s);
            }

            jedis.close();
            jp.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(jedis!=null&&jedis.isConnected()){
                jedis.close();
            }
            if(jp!=null&&!jp.isClosed()){
                jp.close();
            }
        }
    }
}
