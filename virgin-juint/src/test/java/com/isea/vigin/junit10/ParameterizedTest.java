package com.isea.vigin.junit10;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author isea_you
 * @date 2019/10/30
 * @time 16:08
 * @target: 参数化测试
 */

@RunWith(Parameterized.class) // 1 参数化测试必须使用Parameterize的测试运行器来运行一个测试类；以@RunWith注解
public class ParameterizedTest {
    private double excepted; // 2声明测试类中所有需要的实例变量
    private double valueOne;
    private double valueTwo;

    @Parameterized.Parameters // 2 同时提供一个用Parameters注解的方法
    public static Collection<Integer []> getTestParameters(){
        return Arrays.asList(new Integer[][]{{2,1,1}, {3,2,2}, {4,3,1}});
    }

    // 为测试指定需要的构造函数，无无参构造，有一个为测试接收参数的函数
    public ParameterizedTest(double excepted,double valueOne,double valueTwo){
        this.excepted = excepted;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    @Test
    public void sun(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(excepted,calculator.add(valueOne,valueTwo),0);
    }
}
