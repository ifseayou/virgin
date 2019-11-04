package com.isea.virgin.aop.aspect;

import com.isea.virgin.aop.service.ArithmeticCalculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author isea_you
 * @date 2019/11/4
 * @time 19:10
 * @target:
 */
public class LoggingAspectTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
    ArithmeticCalculator calculator = context.getBean("arithmeticCalculatorImpl", ArithmeticCalculator.class);


    @Test
    public void testAdd() {
        int res = calculator.add(1, 2);
        System.out.println("LoggingAspect==>the result : " + res);
    }

    @Test
    public void testDiv() {
        calculator.div(1, 0);
    }
}
