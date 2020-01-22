package com.isea.design.factory.easy.pizza;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/22 9:40
 * @target:
 */
public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("准备GreekPizza...");
    }
}
