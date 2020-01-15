package com.isea.glans.leetcode.easy;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/15 16:11
 * @target: 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *          当前比前一个小或者相等，前者累计 加 到sum
 *          当前比前一个大，前者累计 减 到sum
 *          最后一个一定加。
 */
public class RomanToInt13 {

    public int romanToInt(String s) {
        int sum = 0;
        int pre = getValue(s.charAt(0));
        for (int i = 1; i < s.length() ;i ++){
            int cur = getValue(s.charAt(i));
            if (cur <= pre){
                sum += pre;
            }else {
                sum -= pre;
            }
            pre = cur;
        }
        // 最后一个子母一定加
        sum += getValue(s.charAt(s.length() -1));
        return sum;
    }

    private int getValue(char ch){
        switch (ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
