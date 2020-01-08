package com.isea.design.proxy.dynamic;

import com.isea.design.proxy.dynamic.service.ArithmeticCalculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/8 22:54
 * @target:
 */

public class ArithmeticCalculatorLogProxy {

    // 要代理的对象
    private ArithmeticCalculator target;
    public ArithmeticCalculatorLogProxy(ArithmeticCalculator target) {
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
             * 	在invoke方法上实现代理的功能，并且将对代理实例方法的调用转到目标对象的方法上
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
                System.out.println(method.getName() + " start");
                // 执行方法
                Object result = method.invoke(target, args);
                System.out.println("the result = " + result);
                // 日志
                System.out.println(method.getName() + " end");
                return result;
            }
        };

        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, handler);
        // 当调用代理对象其中的方法时，该执行的代码
        return proxy;
    }
}
