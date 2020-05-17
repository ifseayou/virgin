package com.isea.glans.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/5 16:11
 * @target:
 */
public class EasyTest {

    @Test
    public void testTwoSum1(){
        TwoSum1 twoSum1 = new TwoSum1();
        int[] nums = {2, 7, 11, 15};
        int[] res = twoSum1.twoSum(nums, 9);
        for (int re : res) {
            System.out.print(re + "\t");
        }
    }

    @Test
    public void testReverseInteger7(){
        ReverseInteger7 reverseInteger7 = new ReverseInteger7();
        System.out.println(reverseInteger7.reverse(-20));
        System.out.println(reverseInteger7.reverse(123));
    }

    @Test
    public void testPalindromeNumber9(){
        PalindromeNumber9 palindromeNumber9 = new PalindromeNumber9();
        for (int i = -9; i < 100 ; i ++){
            System.out.print(i  +  "-" +palindromeNumber9.isPalindrome(i) + "\t");
            if(i % 10 == 0) System.out.println();
        }
    }

    @Test
    public void testRomanToInt13(){
        RomanToInt13 romanToInt13 = new RomanToInt13();
        Assert.assertEquals(3,romanToInt13.romanToInt("III"));
        Assert.assertEquals(romanToInt13.romanToInt("IV"),4);
        Assert.assertEquals(romanToInt13.romanToInt("IX"),9);
        Assert.assertEquals(romanToInt13.romanToInt("LVIII"),58);
        Assert.assertEquals(romanToInt13.romanToInt("MCMXCIV"),1994);
    }


    @Test
    public void testLCP14(){
        LongestCommonPrefix14 longestCommonPrefix14 = new LongestCommonPrefix14();
        String[] strs1 = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};
        String[] strs3 = {"cd","car","car"};
        System.out.println(longestCommonPrefix14.longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefix14.longestCommonPrefix(strs2));
        System.out.println(longestCommonPrefix14.longestCommonPrefix(strs3));
    }

    @Test
    public void testNutritionFacts(){
        double a = Math.pow(1.1, 10) * 100;
        double b = Math.pow(1.07,10) * 100;
        System.out.println(a + "-" + b + "=" + (a -b));


        double c = Math.pow(1.1,20) * 100;
        double d = Math.pow(1.07,20) * 100;
        System.out.println(c + "-" + d + "=" + (c - d));
    }

    @Test
    public void test(){
        String substring = "QUEXIAN-202001190001".substring(16);
        System.out.println(substring);
        System.out.println(Integer.valueOf(substring));
        System.out.println(Integer.valueOf("QUEXIAN-202001191001".substring(16)));
    }
}
