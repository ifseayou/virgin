package com.isea.virgin.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPoolManager {
    private static JedisPool jedisPool;
    private static final Logger logger = LoggerFactory.getLogger(RedisPoolManager.class);

    static {
        //初始化
        jedisPool = getPoolInstance();
    }


    /**
     * 获取链接池实例
     *
     * @return
     */
    public static JedisPool getPoolInstance() {
        if (jedisPool == null) {
            //实现单例
            synchronized (RedisPoolManager.class) {
                if (jedisPool == null) {
                    jedisPool = initPoolInstance();
                }
            }
        }
        return jedisPool;
    }

    /**
     * 获取链接池实例
     *
     * @return
     */
    public static JedisPool getPoolInstance(int max_active, int max_idle, int max_wait, boolean test_on_borrow, String host, int port, String password, int database, int timeout) {
        if (jedisPool == null) {
            //实现单例
            synchronized (RedisPoolManager.class) {
                if (jedisPool == null) {
                    jedisPool = initPoolInstance(max_active, max_idle, max_wait, test_on_borrow, host, port, password, database, timeout);
                }
            }
        } else {
            jedisPool.close();
            jedisPool = null;
            //实现单例
            synchronized (RedisPoolManager.class) {
                if (jedisPool == null) {
                    jedisPool = initPoolInstance(max_active, max_idle, max_wait, test_on_borrow, host, port, password, database, timeout);
                }
            }
        }
        return jedisPool;
    }

    /**
     * 初始化链接池实例
     *
     * @return
     */
    private static JedisPool initPoolInstance() {
        // 获取参数
/*        int max_active = Integer.parseInt(PropertyUtil.getValue(ConfKeyEnum.REDIS_COMMON_MAXTOTAL));
        int max_idle = Integer.parseInt(PropertyUtil.getValue(ConfKeyEnum.REDIS_COMMON_MAXIDLE));
        int max_wait = Integer.parseInt(PropertyUtil.getValue(ConfKeyEnum.REDIS_COMMON_MAXWAITMILLIS));
        boolean test_on_borrow = Boolean.parseBoolean(PropertyUtil.getValue(ConfKeyEnum.REDIS_COMMON_TESTONBORROW));

        String host = PropertyUtil.getValue(ConfKeyEnum.REDIS_COMMON_HOST);
        int port = Integer.parseInt(PropertyUtil.getValue(ConfKeyEnum.REDIS_COMMON_PORT));
        String password = PropertyUtil.getValue(ConfKeyEnum.REDIS_COMMON_PASSWORD);
        if (StringUtils.isBlank(password)) {
            password = null;
        }
        int database = Integer.parseInt(PropertyUtil.getValue(ConfKeyEnum.REDIS_COMMON_DATABASE));
        int timeout = Integer.parseInt(PropertyUtil.getValue(ConfKeyEnum.REDIS_COMMON_TIMEOUT));
        */
        int max_active = 20;
        int max_idle = 100;
        int max_wait = 15000;
        boolean test_on_borrow = false;

        String host = "192.168.1.212";
        int port = 6379;
        String password = "sys";
        if (StringUtils.isBlank(password)) {
            password = null;
        }
        int database = 5;
        int timeout = 15000;
        //创建连接池
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(max_active);
        config.setMaxIdle(max_idle);
        config.setMaxWaitMillis(max_wait);
        config.setTestOnBorrow(test_on_borrow);
        jedisPool = new JedisPool(config, host, port, timeout, password, database);
        return jedisPool;
    }


    private static JedisPool initPoolInstance(int max_active, int max_idle, int max_wait, boolean test_on_borrow, String host, int port, String password, int database, int timeout) {
        // 获取参数
        //创建连接池
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(max_active);
        config.setMaxIdle(max_idle);
        config.setMaxWaitMillis(max_wait);
        config.setTestOnBorrow(test_on_borrow);
        jedisPool = new JedisPool(config, host, port, timeout, password, database);
        return jedisPool;
    }

    /**
     * 取得redis的客户端
     *
     * @return
     */
    public static Jedis getRedisClient() {
        Jedis jedis = null;
        try {
            jedis = getPoolInstance().getResource();
        } catch (Exception ex) {
            logger.error("getRedisClient error:", ex);
        }
        return jedis;
    }

}
