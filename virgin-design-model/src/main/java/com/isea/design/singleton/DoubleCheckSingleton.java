package com.isea.design.singleton;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/8 22:36
 * @target: 优势：不会有安全问题，兼顾效率
 */
public class DoubleCheckSingleton {
    private static DoubleCheckSingleton INSTANCE = null;
    private DoubleCheckSingleton(){}
    public static DoubleCheckSingleton getInstance(){
        if (INSTANCE == null){
            synchronized (DoubleCheckSingleton.class){
                if (INSTANCE == null){
                    INSTANCE = new DoubleCheckSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
