package com.isea.design.proxy.dynamic.service.impl;

import com.isea.design.proxy.dynamic.service.ArithmeticCalculator;

/**
 * @author isea_you
 * @date 2019/9/27
 * @time 10:43
 * @target:
 * 	① 执行加减乘除运算
 * 	②日志：在程序执行期间追踪正在发生的活动
 * 	③验证：希望计算器只能处理正数的运算
 *
 * 	这样的写法的缺点是，日志信息嵌入到了逻辑方法中，增加了耦合度
 */
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

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
        return a / b;
    }
}
