package com.isea.design.proxy;

import com.isea.design.proxy.dynamic.ArithmeticCalculatorLogProxy;
import com.isea.design.proxy.dynamic.service.ArithmeticCalculator;
import com.isea.design.proxy.dynamic.service.impl.ArithmeticCalculatorImpl;
import org.junit.Test;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/8 23:06
 * @target: 测试动态代理，忘记其原理的时候，可以结合debug来理解过程
 */
public class DynamicProxyTest {
    @Test
    public void testDynamicProxy(){
        // 要代理的对象
        ArithmeticCalculatorImpl target = new ArithmeticCalculatorImpl();
        ArithmeticCalculatorLogProxy proxy = new ArithmeticCalculatorLogProxy(target);
        ArithmeticCalculator loggingProxy = proxy.getLoggingProxy();
        loggingProxy.sub(3,1);
    }
}
