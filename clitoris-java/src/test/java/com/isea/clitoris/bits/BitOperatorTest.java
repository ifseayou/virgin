package com.isea.clitoris.bits;

import org.junit.Test;

/**
 * @author isea_you
 * @date 2019/11/11
 * @time 8:31
 * @target: 测试位运算
 * |是按位或    有一个1 就是1
 * &是按位与    两个都1 才是1
 * ^是按位抑或  两位相异，为1
 *
 *
 */
public class BitOperatorTest {
    @Test
    public void  testBitOperator(){
        int x = 5;
        int y = 11;
        System.out.println(x | y); // 15  0101 | 1011 = 1111
        System.out.println(x & y); // 1   0101 & 1011 = 0001
        System.out.println(x ^ y); // 14  0101 ^ 1011 = 1110
        System.out.println(x >> 1); // 右移 2   也就是除以2
        System.out.println(x << 1); // 左移 10  也就是乘以2
    }
}
