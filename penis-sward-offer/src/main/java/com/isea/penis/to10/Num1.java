package com.isea.penis.to10;

/**
 * @author isea_you
 * @date 2019/10/23
 * @time 11:33
 * @target: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Num1 {
    public boolean find(int target,int[][] array){
        int r = 0;
        int l = array[0].length - 1;
        while(r < array.length && l >= 0){
            if (target > array[r][l]){
                r ++;
            }else if (target < array[r][l]){
                l --;
            }else {
                return true;
            }
        }
        return false;
    }
}
