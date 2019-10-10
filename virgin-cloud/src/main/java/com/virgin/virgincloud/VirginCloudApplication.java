package com.virgin.virgincloud;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.Resource;

@SpringBootApplication
@EnableFeignClients
public class VirginCloudApplication implements ApplicationRunner {
    @Resource
    private HomeApi homeApi;

    public static void main(String[] args) {
        SpringApplication.run(VirginCloudApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(homeApi.ping());
    }
}
