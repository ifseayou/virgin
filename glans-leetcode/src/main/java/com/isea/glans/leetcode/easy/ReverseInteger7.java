package com.isea.glans.leetcode.easy;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/5 16:47
 * @target:
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 输入: 123
 * 输出: 321
 *
 * 输入: -123
 * 输出: -321
 *
 * 输入: 120
 * 输出: 21
 */
public class ReverseInteger7 {
    public int reverse(int x) {
        long rev = 0; // rev = rev * 10 处有益处的风险，所以使用long
        while(x != 0){
            rev = rev * 10 + x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int) rev;
    }
}
