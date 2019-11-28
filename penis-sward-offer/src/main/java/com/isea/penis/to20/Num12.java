package com.isea.penis.to20;

/**
 * @author isea_you
 * @date 2019/10/24
 * @time 10:19
 * @target: 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * !!! 这里需要注意的是负数
 */
public class Num12 {
    public double Power(double base, int exponent) {
        double res = 1;
        if (exponent < 0){
            for (int i = exponent; i < 0; i ++){
                res = res * base;
            }
            return 1.0 / res;
        }else {
            for (int i = 0; i < exponent; i++) {
                res = res * base;
            }
            return res;
        }
    }
}
