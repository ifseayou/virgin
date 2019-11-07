package com.isea.clitoris.classes;

import java.math.BigDecimal;
import java.math.MathContext;


/**
 * @author isea_you
 * @date 2019/11/6
 * @time 11:05
 * @target:  求BigDecimal的开方
 */
public class BigDecimalUtil {

    public static BigDecimal sqrt(BigDecimal num) {
        if (num.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal x = num.divide(new BigDecimal("2"), MathContext.DECIMAL128);
        while (x.subtract(x = sqrtIteration(x, num)).abs().compareTo(new BigDecimal("0.0000000000000000000001")) > 0) ;
        return x;
    }

    private static BigDecimal sqrtIteration(BigDecimal x, BigDecimal n) {
        return x.add(n.divide(x, MathContext.DECIMAL128)).divide(new BigDecimal("2"), MathContext.DECIMAL128);
    }
}
