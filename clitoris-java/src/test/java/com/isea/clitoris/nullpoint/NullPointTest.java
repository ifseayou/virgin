package com.isea.clitoris.nullpoint;

import org.junit.Test;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * @author isea_you
 * @date 2019/11/6
 * @time 20:12
 * @target:
 */
public class NullPointTest {
    @Test
    public void testFalseNullPointer() {
        ArrayList<String> falseNullPointer = new ArrayList<>();
        for (String s : falseNullPointer) {
            System.out.println(s.split(" "));
        }
        System.out.println("执行成功");

    }

    /**
     * 对于Null使用增强for循环会发生空指针
     */
    @Test
    public void testTrueForNullPointer() {
        ArrayList<String> trueNullPointer = null;
        for (String s : trueNullPointer) {
            System.out.println(s.split(" "));
            System.out.println("执行失败");
        }
    }

    @Test
    public void testTrueForINullPointer(){
        ArrayList<String> trueNullPointer = null;
        for (int i = 0; i < trueNullPointer.size(); i++) {
            System.out.println(i);
        }
    }

    @Test
    public void testPattern(){
        System.out.println(Pattern.matches("^[\\u4e00-\\u9fa5]{0,}$", "中"));
        System.out.println(Pattern.matches("^[0-9]","7"));
        System.out.println(Pattern.matches("^[A-Za-z]", "a"));
    }
}
