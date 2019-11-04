package com.isea.virgin.clitoris.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author isea_you
 * @date 2019/11/4
 * @time 7:57
 * @target: 基于xml的方式配置bean， 将bean交给spring（IOC）来管理
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object person1 = ctx.getBean(Person.class);
        System.out.println(person1);
        // Person{name='Tom', age=22, car=Car{brand='Ford', address='ChangAn', price=3000.0}}
    }
}
