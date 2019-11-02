package com.isea.penis.to30;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author isea_you
 * @date 2019/11/1
 * @time 19:45
 * @target: 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Num29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();


        return res;
    }

    public static void main(String[] args) {
        PriorityQueue<Object> heap = new PriorityQueue<>();
        Num29 num29 = new Num29();
        int[] inputs = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> res = num29.GetLeastNumbers_Solution(inputs, 4);
        res.forEach((i) ->
                System.out.print(i + " "));
    }
}
