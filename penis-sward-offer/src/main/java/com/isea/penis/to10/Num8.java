package com.isea.penis.to10;

import java.util.HashMap;

/**
 * @author isea_you
 * @date 2019/10/23
 * @time 16:46
 * @target: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 这里给出优化版
 */
public class Num8 {
    HashMap<Integer, Integer> cache = new HashMap<>();
    public int JumpFloor(int target) {

        if (target == 1){
            return 1;
        }else if (target == 2){
            return 2;
        }
        if (cache.containsKey(target)){
            return cache.get(target);
        }
        int res = JumpFloor(target - 1) + JumpFloor(target - 2);
        cache.put(target,res);
        return res;
    }

    public static void main(String[] args) {
        Num8 num8 = new Num8();
        System.out.println(num8.JumpFloor(2));
        System.out.println(num8.JumpFloor(3));
        System.out.println(num8.JumpFloor(4));

    }

}
