package com.isea.design.factory.easy.pizza;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/22 9:39
 * @target:
 */
public class ChinesePizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("开始准备ChinesePizza...");
    }
}
