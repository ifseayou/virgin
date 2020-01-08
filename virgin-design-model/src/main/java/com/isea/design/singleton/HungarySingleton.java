package com.isea.design.singleton;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/8 22:39
 * @target: 恶汉 : 安全，造成内存的浪费
 */
public class HungarySingleton {
    private final static HungarySingleton INSTANCE = new HungarySingleton();
    private HungarySingleton(){}
    public static HungarySingleton getInstance(){
        return INSTANCE;
    }
}
