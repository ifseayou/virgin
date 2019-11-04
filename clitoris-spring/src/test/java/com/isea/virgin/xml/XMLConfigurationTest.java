package com.isea.virgin.xml;

import com.isea.virgin.xml.beans.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author isea_you
 * @date 2019/11/4
 * @time 16:23
 * @target: 测试基于Xml方式配置bean到IOC容器中
 */
public class XMLConfigurationTest {
    @Test
    public void testPerson2Car(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object person1 = ctx.getBean(Person.class);
        System.out.println(person1);
        // Person{name='Tom', age=22, car=Car{brand='Ford', address='ChangAn', price=3000.0}}
    }
}
