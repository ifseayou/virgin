package com.isea.virgin;

import com.isea.virgin.utils.RedisPoolManager;
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
        // 测试一下RedisPoolManager
        Jedis jedis = RedisPoolManager.getRedisClient();
        try {
            System.out.println(jedis.hget("overrideConfig", "110108000004000100007A07"));
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            jedis.close();
        }
    }
}
