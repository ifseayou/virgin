package com.isea.virgin.proxy;

import com.isea.virgin.service.ArithmeticCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author isea_you
 * @date 2019/9/28
 * @time 7:34
 * @target: 基于接口实现动态代理
 */
public class ArithmeticCalculatorLoggingProxy {
    private final Logger logger = LoggerFactory.getLogger(ArithmeticCalculatorLoggingProxy.class);

    // 要代理的对象
    private ArithmeticCalculator target;

    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    public ArithmeticCalculator getLoggingProxy() {
        ArithmeticCalculator proxy = null;
        // 代理对象由哪一个类加载器加载
        ClassLoader loader = target.getClass().getClassLoader();

        // 代理对象的类型，也即其中有哪些方法
        Class[] interfaces = {ArithmeticCalculator.class};
        InvocationHandler handler = new InvocationHandler() {
            /**
             *
             * @param proxy  正在返回的那个代理对象，一般情况下，在invoke方法中都不使用该对象
             * @param method 正在被调用的方法
             * @param args 调用方法时，传入的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 日志
                logger.info(method.getName() + " start");
                // 执行方法
                Object result = method.invoke(target, args);
                logger.warn("the result = " + result);
                // 日志
                logger.info(method.getName() + " end");
                return result;
            }
        };

        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, handler);
        // 当调用代理对象其中的方法时，该执行的代码
        return proxy;
    }
}
