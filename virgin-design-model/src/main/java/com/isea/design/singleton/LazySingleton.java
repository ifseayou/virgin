package com.isea.design.singleton;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/8 22:40
 * @target: 懒汉：有效率，不安全
 */
public class LazySingleton {
    private static LazySingleton INSTANCE;
    private LazySingleton(){}
    public static LazySingleton getInstance(){
        if (INSTANCE == null){
            INSTANCE  = new LazySingleton();
        }
        return INSTANCE;
    }
}
