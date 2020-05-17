package com.isea.learn.ignite.demo1;

import org.apache.ignite.Ignition;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.ClientException;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.ClientConfiguration;

/**
 * @author ifseayou@gmail.com
 * @date 2020/2/11 14:08
 * @target:
 */
public class HelloIgnite {
    private static ClientCache<Integer, Province> provinceCache;
    private static ClientCache<String, City> cityCache;

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Ignite thin client example started.");
        //连接到Ignite集群,默认端口号为10800
        ClientConfiguration cfg = new ClientConfiguration().setAddresses("hadoop104:10800");

        //用java的try-with-resource statement启动client
        try (IgniteClient igniteClient = Ignition.startClient(cfg)){
            System.out.println();
            System.out.println("Begin create cache and insert data.");
            //创建两个缓存,具体步骤见该函数
            createCacheAndInsertData(igniteClient);

            System.out.println();
            System.out.println("Begin query cache.");
            //根据输入开始查询
            for(String city : args)
            {
                //先用城市名字,查询city缓存
                City c = cityCache.get(city);
                Province p = null;
                if (c != null)
                {
                    //在用城市数据中的province id查询province缓存
                    p = provinceCache.get(c.getProvinceId());
                }
                //输出查询结果
                if (c != null && p != null) {
                    System.out.println("Find " + c.getName() + " in province " + p.getName());
                }
                else
                {
                    System.out.println("Cannot find " + city + " in any province.");
                }
            }
        }
        catch (ClientException e) {
            System.err.println(e.getMessage());
        }
        catch (Exception e) {
            System.err.format("Unexpected failure: %s\n", e);
        }
    }

    private static void createCacheAndInsertData(IgniteClient igniteClient)
    {
        //创建province缓存,用来存放省份信息,该缓存以省的id为key
        final String PROVINCE_CACHE_NAME = "province";
        provinceCache = igniteClient.getOrCreateCache(PROVINCE_CACHE_NAME);

        //往province缓存中写入一些数据
        int provinceId = 1;
        final Province on = new Province(provinceId++, "Ontario");
        final Province ab = new Province(provinceId++, "Alberta");
        final Province qc = new Province(provinceId++, "Quebec");

        provinceCache.put(on.getId(), on);
        provinceCache.put(ab.getId(), ab);
        provinceCache.put(qc.getId(), qc);
        System.out.println("Successfully insert all provinces data.");

        //创建city缓存,用来存放城市信息,该缓存以城市的名字为key
        final String CITY_CACHE_NAME = "city";
        cityCache = igniteClient.getOrCreateCache(CITY_CACHE_NAME);
        //往city缓存写入一些数据
        int cityId = 1;
        final City toronto = new City(cityId++, "Toronto", on.getId());
        final City edmonton = new City(cityId++, "Edmonton", ab.getId());
        final City calgary = new City(cityId++, "Calgary", ab.getId());
        final City montreal = new City(cityId++, "Montreal", qc.getId());

        cityCache.put(toronto.getName(), toronto);
        cityCache.put(edmonton.getName(), edmonton);
        cityCache.put(calgary.getName(), calgary);
        cityCache.put(montreal.getName(), montreal);
        System.out.println("Successfully insert all city data.");
    }
}
