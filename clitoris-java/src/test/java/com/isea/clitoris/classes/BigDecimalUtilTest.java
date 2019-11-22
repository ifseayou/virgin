package com.isea.clitoris.classes;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author isea_you
 * @date 2019/11/6
 * @time 20:07
 * @target: 测试BigDecimalUtil
 */
public class BigDecimalUtilTest {
    @Test
    public void testSqrt(){
        BigDecimal num1 = new BigDecimal(0.0);
        BigDecimal num2 = new BigDecimal(10);
        System.out.println(BigDecimalUtil.sqrt(num1));
        System.out.println(BigDecimalUtil.sqrt(num2));
    }

    @Test
    public void testArraysSort(){
        // 按照从小到大的顺序排列
        String[] strArr = {"31","3","32"};
        Arrays.sort(strArr,(a,b)->{ // 没有传入比较器的时候默认使用从小到大的顺序排列
            String x = a + b;
            String y = b + a;
            return x.compareTo(y);
        });

        for (String str : strArr) {
            System.out.print(str + "\t");
        }
    }

    @Test
    public void testArraysSort2(){
        // 按照从小到大的顺序排列
        String[] strArr = {"31","3","32"};
        Arrays.sort(strArr, Comparator.reverseOrder()); // 倒序排列

        for (String str : strArr) {
            System.out.print(str + "\t");
        }
    }


}
