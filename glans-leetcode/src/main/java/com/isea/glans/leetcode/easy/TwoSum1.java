package com.isea.glans.leetcode.easy;

import java.util.HashMap;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/5 16:09
 * @target:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numIndex.put(nums[i],i);
        }
        for (int i = 0;i < nums.length ; i ++){
            int complete = target - nums[i];
            if (numIndex.containsKey(complete) && numIndex.get(complete) != i){
                return new int[]{i,numIndex.get(complete)};
            }
        }

       throw new IllegalArgumentException("No such solution...");
    }
}
