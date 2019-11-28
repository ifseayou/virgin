package com.isea.penis.to20;

/**
 * @author isea_you
 * @date 2019/10/24
 * @time 9:08
 * @target: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 这种与运算的方式非常perfect，需要学习。位运算规则参考 /dataSource/algo/readme.java
 */
public class Num11 {
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            count ++;
            n = n & (n - 1);
        }
        return count;
    }
}
