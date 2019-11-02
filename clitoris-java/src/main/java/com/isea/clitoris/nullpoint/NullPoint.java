package com.isea.clitoris.nullpoint;

import java.util.ArrayList;

/**
 * @author isea_you
 * @date 2019/10/31
 * @time 21:24
 * @target: 指明什么情况下会发生空指针异常
 */
public class NullPoint {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> falseNullPointer = new ArrayList<>();
        for (String s : falseNullPointer) {
            System.out.println(s.split(" "));
        }
        System.out.println("执行成功");

        Thread.sleep(3000);
        new Thread(()->{
            ArrayList<String> trueNullPointer = null;
            for (String s : trueNullPointer) {
                System.out.println(s.split(" "));
                System.out.println("执行失败");
            }
        }).start();
    }
}
