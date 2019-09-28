package com.isea.virgin.clitorisspring.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author isea_you
 * @date 2019/9/28
 * @time 7:49
 * @target:
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ArithmeticCalculatorImpl target = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLogginProxy();
        proxy.add(1, 2);
//        logger.info(String.valueOf(proxy.add(1,2)));

    }
}
