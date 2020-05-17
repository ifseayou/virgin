package com.isea.learn.ignite.demo2;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;

/**
 * @author ifseayou@gmail.com
 * @date 2020/2/12 10:57
 * @target:
 */
public class IgniteClientNodeExample {
    public static void main(String[] args) {
        Ignite ignite;
        if(args.length == 1 && !args[0].isEmpty())
        {
            //如果启动时指定了配置文件,则用指定的配置文件
            System.out.println("Use " + args[0] + " to start.");
            ignite = Ignition.start(args[0]);
        }
        else
        {
            //如果启动时没指定配置文件,则生成一个配置文件
            System.out.println("Create an IgniteConfiguration to start.");
            TcpDiscoverySpi spi = new TcpDiscoverySpi();
            TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
            ipFinder.setMulticastGroup("224.0.0.251");
            spi.setIpFinder(ipFinder);
            IgniteConfiguration cfg = new IgniteConfiguration();
            cfg.setDiscoverySpi(spi);
            //显式配置client模式启动该节点.
            cfg.setClientMode(true);
            ignite = Ignition.start(cfg);
        }
        //从ignite中读取缓存,并读取数据
        IgniteCache<String, String> cityProvinceCache = ignite.getOrCreateCache("TEST");
        System.out.println("Montreal is in " + cityProvinceCache.get("Montreal"));
        System.out.println("Edmonton is in " + cityProvinceCache.get("Edmonton"));
        System.out.println("Markham is in " + cityProvinceCache.get("Markham"));
        System.out.println("Toronto is in " + cityProvinceCache.get("Toronto"));
    }
}
