package com.isea.virgin.service;

import org.junit.Test;

/**
 * @author isea_you
 * @date 2019/11/4
 * @time 16:02
 * @target: 测试ArithmeticCalculatorImpl
 */
public class ArithmeticCalculatorImplTest {
    @Test
    public void testAdd() {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorImpl();
        arithmeticCalculator.add(1, 2);
    }
}
