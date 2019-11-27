package com.isea.penis.to10;

/**
 * @author isea_you
 * @date 2019/10/23
 * @time 16:38
 * @target: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Num7 {
    public int Fibonacci(int n) {
        if (n == 1 || n == 2){
            return 1;
        }else {
            return Fibonacci(n - 1) + Fibonacci(n- 2);
        }
    }
}
