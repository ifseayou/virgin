package com.isea.design.proxy.dynamic.service;

/**
 * @author isea_you
 * @date 2019/9/27
 * @time 10:42
 * @target:  ①执行加减乘除运算
 *      	 ②日志：在程序执行期间追踪正在发生的活动
 *           ③验证：希望计算器只能处理正数的运算
 */
public interface ArithmeticCalculator {
    int add(int a, int b);
    int sub(int a, int b);
    int mul(int a, int b);
    int div(int a, int b);
}
