package com.isea.glans.leetcode.easy;

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

}
