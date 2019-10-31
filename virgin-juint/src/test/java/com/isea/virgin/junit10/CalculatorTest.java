package com.isea.virgin.junit10;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author isea_you
 * @date 2019/10/30
 * @time 15:39
 * @target:
 */
public class CalculatorTest {
    @Test
    public void testAdd(){ // 按照testXXX 的命名方式；
        Calculator calculator = new Calculator();
        double res = calculator.add(10, 20);
        // 如果实际值不等于预期值，那么Junit就会抛出未经检查的异常
        Assert.assertEquals(30,res,0); // delta表示的是误差
    }
}
