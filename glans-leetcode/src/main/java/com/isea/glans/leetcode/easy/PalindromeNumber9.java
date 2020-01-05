package com.isea.glans.leetcode.easy;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/5 16:59
 * @target:
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 输入: 121
 * 输出: true
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class PalindromeNumber9 {
    public boolean isPalindrome(int x) {
        // 小于0，不是回文数字，所有能被10整除但是不等于0的数，一定不是回文数字
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int  rev = 0;
        while(x > rev){
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        // 前者处理类似55的数，后者处理类似123 或者121的数
        return x == rev ||  x == rev / 10;
    }
}
