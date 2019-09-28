package com.isea.virgin.clitorisspring.aop.service;

/**
 * @author isea_you
 * @date 2019/9/27
 * @time 10:43
 * @target:
 */
public class ArithmeticCalculatorImpl implements ArithmeticCalculator{

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        if (b == 0){
            throw new IllegalArgumentException("除数不能为0");
        }
        return a / b;
    }
}
