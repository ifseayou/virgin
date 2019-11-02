package com.isea.penis.to30;

/**
 * @author isea_you
 * @date 2019/10/31
 * @time 9:43
 * @target: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * !!!  不是员工hashMap的方式解决这个问题，hashMap的时间复杂度是O（1），空间复杂度是O（N）
 */
public class Num28 {
    public int MoreThanHalfNum_Solution(int[] array) {
        int cand = 0; // 候选
        int times = 0; // 候选出现的次数
        // 1，如果一个数出现的次数大于一半，他肯定会被剩下来，但是不表示他一定是符合条件的！
        for (int i = 0; i != array.length; i++) {
            if (times == 0) { // 表示当前没有候选
                cand = array[i];
                times = 1;
            } else if (array[i] == cand) {// 表示有了候选，且候选等于当前元素
                times++; // 候选的点数 + 1
            } else { // 找到了和候选不一样的元素
                times--; // 候选的点数 - 1 ，等效于删除了这两个元素
            }
        }

        times = 0;
        // 1，例如1,2，3 这里的3会被选出来，其实并没有超过一半
        for (int i = 0; i != array.length; i++) {
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

    public static void main(String[] args) {
        Num28 num28 = new Num28();
        int[] arr1 = {99,2,99,4,6,99,99};
        int[] arr2 = {1,3,1,4,6,1,1};
        int[] arr3 = {1,3,5,4,6,1,1};
        System.out.println(num28.MoreThanHalfNum_Solution(arr1));
        System.out.println(num28.MoreThanHalfNum_Solution(arr2));
        System.out.println(num28.MoreThanHalfNum_Solution(arr3));
    }
}
