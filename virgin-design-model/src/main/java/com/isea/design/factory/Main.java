package com.isea.design.factory;

import com.isea.design.factory.easy.OrderPizza;
import com.isea.design.factory.easy.SimpleFactory;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/22 9:57
 * @target:
 */
public class Main {
    public static void main(String[] args) {
        new OrderPizza(new SimpleFactory());
    }
}
