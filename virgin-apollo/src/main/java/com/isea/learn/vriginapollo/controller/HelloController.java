package com.isea.learn.vriginapollo.controller;

import com.alibaba.fastjson.JSON;
import com.isea.learn.vriginapollo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author isea_you
 * @date 2019/8/21
 * @time 15:52
 * @target:
 */
@RestController
public class HelloController {

    @Autowired
    private Student student;

    @GetMapping(path = "show")
    public String show() {
        return JSON.toJSONString(student);
    }

}
