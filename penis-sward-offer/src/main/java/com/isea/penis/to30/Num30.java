package com.isea.penis.to30;

/**
 * @author isea_you
 * @date 2019/11/2
 * @time 11:52
 * @target: 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，
 * 也即连续子数组的最大和。
 */
class Num30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0){
            return 0; // 如果数组的长度为0或者数组为null，直接返回该数组的连续子数组的最大和为0
        }
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0;i < array.length ; i ++){
            cur += array[i];
            max = Math.max(cur,max);
            cur =  cur < 0 ? 0 : cur;// 如果加到当前小于0，则从当前的下一个元素开始累加计算。因为+负数，会变的更小。
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {6,-3,-2,7,-15,1,2,2};
        Num30 num30 = new Num30();
        System.out.println(num30.FindGreatestSumOfSubArray(arr));
    }
}
