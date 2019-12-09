package com.isea.penis.to30;

import java.util.HashMap;

/**
 * @author isea_you
 * @date 2019/10/31
 * @time 9:43
 * @target: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * !!!  不使用hashMap的方式解决这个问题，hashMap的时间复杂度是O（1），空间复杂度是O（N）
 * !!! 解决的办法就是模拟删除
 */
public class Num28 {
    public int MoreThanHalfNum_Solution(int[] array) {
        int cand = 0; // 候选
        int times = 0; // 候选出现的次数
        // 1，如果一个数出现的次数大于一半，他肯定会被剩下来，但是不表示他一定是符合条件的！
        for (int i = 0; i < array.length; i++) {
            if (times == 0) { // 表示当前没有候选
                cand = array[i];
                times = 1;
            } else if (array[i] == cand) {// 表示有了候选，且候选等于当前元素
                times++; // 候选的点数 + 1
            } else { // 找到了和候选不一样的元素
                times--; // 候选的点数 - 1 ，或者是：删除了候选（times-1=0）和当前两个元素，接下来下一个元素会变成候选
            }
        }

        times = 0;
        // 1，例如1,2，3 这里的3会被选出来，其实并没有超过一半
        for (int i = 0; i < array.length; i++) {
            if (array[i] == cand) {
                times++;
            }
        }
        if (times > array.length / 2) {
            return cand;
        } else {
            return 0;
        }
    }

    /**
     * 使用的HashMap的方式来解决这个问题
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution2(int[] array) {
        HashMap<Integer, Integer> help = new HashMap<>();
        for (int i : array) {
            if (help.containsKey(i)) {
                int val = help.get(i) + 1;
                if (val > array.length / 2) {
                    return i;
                } else {
                    help.put(i, val);
                }
            } else {
                help.put(i, 1);
            }
        }
        return 0;
    }
}
