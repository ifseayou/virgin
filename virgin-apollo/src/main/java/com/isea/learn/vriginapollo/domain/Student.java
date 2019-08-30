package com.isea.learn.vriginapollo.domain;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author isea_you
 * @date 2019/8/21
 * @time 15:44
 * @target:
 */
//@Configuration
@Component
@EnableApolloConfig
public class Student {

    @Value("${stu.name}")
    private String name;
    @Value("${stu.sex}")
    private String sex;
    @Value("${stu.age}")
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
