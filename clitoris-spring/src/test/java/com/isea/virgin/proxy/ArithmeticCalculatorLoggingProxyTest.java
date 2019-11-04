package com.isea.virgin.proxy;

import com.isea.virgin.service.ArithmeticCalculator;
import org.junit.Test;

/**
 * @author isea_you
 * @date 2019/11/4
 * @time 16:32
 * @target: 测试代理
 */
public class ArithmeticCalculatorLoggingProxyTest {
    @Test
    public void testSub(){
        // 要代理的对象
        ArithmeticCalculatorImpl target = new ArithmeticCalculatorImpl();
        ArithmeticCalculator loggingProxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
        loggingProxy.sub(3,1);
    }
}
