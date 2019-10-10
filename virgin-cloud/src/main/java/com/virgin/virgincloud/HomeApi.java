package com.virgin.virgincloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author isea_you
 * @date 2019/10/8
 * @time 18:01
 * @target:
 */
@FeignClient(value = "home", path = "/home")
public interface HomeApi {
    @GetMapping("/ping")
    String ping();
}