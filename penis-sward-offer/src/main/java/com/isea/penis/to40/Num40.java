package com.isea.penis.to40;

import java.util.HashMap;

/**
 * @author isea_you
 * @date 2019/11/6
 * @time 7:42
 * @target: 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 */
public class Num40 {

    /**
     * //num1,num2分别为长度为1的数组。传出参数
     * //将num1[0],num2[0]设置为返回结果
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> help = new HashMap<>();
        for (int i : array) {
            if (!help.containsKey(i)){
                help.put(i,1);
            }else { // 已经含有该key
                help.remove(i);
            }
        }
        Object[] res = help.keySet().toArray();
        num1[0] = (Integer) res[0];
        num2[0] = (Integer) res[1];
    }


    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,4,5,6,5,1};
        Num40 num40 = new Num40();
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        num40.FindNumsAppearOnce(arr,num1,num2);
        System.out.println(num1[0] + "-- " + num2[0]);
    }
}
