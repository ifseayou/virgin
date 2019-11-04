package com.isea.virgin.clitoris.proxy;

/**
 * @author isea_you
 * @date 2019/9/28
 * @time 7:49
 * @target:
 */
public class Main {

    public static void main(String[] args) {
        ArithmeticCalculatorImpl target = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLogginProxy();
        proxy.add(1, 2);
    }
}
