package com.isea.penis.to50;

/**
 * @author isea_you
 * @date 2019/11/10
 * @time 20:47
 * @target: 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Num48 {
    public int Add(int num1,int num2) {
        int sum = num1;
        while(num2 != 0){
            sum = num1 ^ num2; // 按位 ^ 异或，相异时为1
            num2 = (num1 & num2) << 1; // 按位& ，相的时候为1 ，左移操作！
            num1 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Num48 num48 = new Num48();
        System.out.println(num48.Add(1, 1));
    }
}
