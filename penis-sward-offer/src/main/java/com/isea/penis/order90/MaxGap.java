package com.isea.penis.order90;

/**
 * @author ifseayou@gmail.com
 * @date 2020/5/17 9:57
 * @target: 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时 间复杂度O(N)，且要求不能用非基于比较的排序。
 * 基于桶排序，找到相邻的两个数的最大差值
 * 算法思想：
 *  1，设计 数组长度+1 个桶，则一定存在一个空桶，排除了最大差值来自同一个桶的可能性
 *  2，bucket 方法确定某个数属于哪个桶
 */
public class MaxGap {
    public static int maxGap(int[] nums){
        if(nums == null || nums.length < 2){
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length ; i ++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        if(max == min){
            return 0;
        }

        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0; // 标识桶应该放在哪个位置
        for(int i = 0 ; i < len ; i ++){
            bid = bucket(nums[i],len,min,max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid],nums[i]):nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid],nums[i]):nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        for (int i = 0; i < len; i++) {
            if (hasNum[i]){
                res = Math.max(res,mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;

    }

    private static int bucket(int num, int len, int min, int max) {
        return (int) ((num - min) *  len / (max - min));
    }
}
