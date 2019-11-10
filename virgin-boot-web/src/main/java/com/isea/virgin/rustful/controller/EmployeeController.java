package com.isea.virgin.rustful.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author isea_you
 * @date 2019/11/8
 * @time 21:31
 * @target:
 */
@RestController
public class EmployeeController {

    @RequestMapping("/success")
    public String success(){
        // 只要我们将html放置在classpath:/templates下，thymeleaf就能够自动渲染
        return "success";
    }
}
