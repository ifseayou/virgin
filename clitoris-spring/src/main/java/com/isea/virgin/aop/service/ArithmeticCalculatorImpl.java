package com.isea.virgin.aop.service;

import org.springframework.stereotype.Component;

/**
 * @author isea_you
 * @date 2019/9/27
 * @time 10:43
 * @target: aop实现
 */
@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    @Override
    public int add(int a, int b) {
        int res = a + b;
        return res;
    }

    @Override
    public int sub(int a, int b) {
        int res = a - b;
        return res;
    }

    @Override
    public int mul(int a, int b) {
        int res = a * b;
        return res;
    }

    @Override
    public int div(int a, int b) {
        int res = a / b;
        return res;
    }
}
