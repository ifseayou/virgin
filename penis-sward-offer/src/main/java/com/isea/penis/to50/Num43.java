package com.isea.penis.to50;

/**
 * @author isea_you
 * @date 2019/11/7
 * @time 20:34
 * @target: 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务， 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class Num43 {
    public String LeftRotateString(String str, int n) {
        if ("".equals(str)) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        int index = n % str.length();
        int end = index;
        do {
            res.append(str.charAt(index));
            index = (index + 1) % str.length();
        } while (index != end);
        return res.toString();
    }

    public static void main(String[] args) {
        Num43 num43 = new Num43();
        System.out.println(num43.LeftRotateString("abcXYZdef", 3));
        System.out.println(num43.LeftRotateString("abcXYZdef", 10));
        System.out.println(num43.LeftRotateString("", 6));
    }
}
