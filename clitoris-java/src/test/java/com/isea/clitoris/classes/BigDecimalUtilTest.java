package com.isea.clitoris.classes;

import org.junit.Test;

import java.math.BigDecimal;

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

}
