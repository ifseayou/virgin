package com.isea.penis.to40;

/**
 * @author isea_you
 * @date 2019/11/2
 * @time 13:50
 * @target: 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * 1~13中包含1的数字有1、10、11、12、13因此共出现6次
 */
public class Num31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res += getNum1(i);
        }
        return res;
    }

    // 计算num中有多少个1
    private int getNum1(int num) {
        int res = 0;
        while (num != 0) {
            if (num % 10 == 1) {
                res++;
            }
            num = num / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Num31 num31 = new Num31();
        System.out.println(num31.NumberOf1Between1AndN_Solution(13));
        System.out.println(num31.NumberOf1Between1AndN_Solution(100));
    }
}
