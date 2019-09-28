package com.isea.virgin;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author isea_you
 * @date 2019/9/25
 * @time 13:55
 * @target:
 */
public class RedisPoolCase {
    public static void main(String[] args) {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(1024); // 资源池中最大连接数
        config.setMaxIdle(10); // 资源池允许最大空闲的连接数
        config.setMaxWaitMillis(1000); // 当资源池连接用尽后，调用者的最大等待时间(单位为毫秒)
        config.setTestOnBorrow(true); // 向资源池借用连接时是否做连接有效性检测(ping)，无效连接会被移除
        config.setTestOnReturn(true); //  向资源池归还连接时是否做连接有效性检测(ping)，无效连接会被移除

        //
        JedisPool jedisPool = new JedisPool(config,"192.168.1.30", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("three","3");
        System.out.println(jedis.get("three"));
    }
}
