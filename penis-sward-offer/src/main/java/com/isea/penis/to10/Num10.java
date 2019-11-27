package com.isea.penis.to10;

/**
 * @author isea_you
 * @date 2019/10/23
 * @time 21:49
 * @target: 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 本质上也是走台阶的问题！
 */
public class Num10 {
    public int RectCover(int target) {
        if (target == 1){
            return 1;
        }else if (target == 2){
            return 2;
        }else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }
}
