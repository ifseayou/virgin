package com.isea.virgin.virginloggerannotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author isea_you
 * @date 2019/9/25
 * @time 15:42
 * @target:
 */
@RestController
@RequestMapping(value = "/v1/demo")
public class DemoController {
    private final Logger logger= LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/list")
    @Log("学生列表")
    public @ResponseBody
    List<Student> list(){
        ArrayList<Student> list=new ArrayList<>();
        Student student0=new Student(1,"kobe",30);
        Student student1=new Student(2,"james",30);
        Student student2=new Student(3,"rose",30);

        list.add(student0);
        list.add(student1);
        list.add(student2);

        return list;
    }

//    @Log("学生实体")
    @RequestMapping("/detail")
    public @ResponseBody Student student(int id){
        return new Student(1,"kobe",30);
    }
}