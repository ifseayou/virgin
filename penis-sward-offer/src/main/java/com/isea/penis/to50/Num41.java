package com.isea.penis.to50;

import java.util.ArrayList;

/**
 * @author isea_you
 * @date 2019/11/6
 * @time 8:02
 * @target: 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Num41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // 使用双指针来mock一个滑动窗口
        int left = 1;
        int right = 2;
        while(left < right){
            // 窗口的值,使用等差数列的求和公式
            int window = (left + right) * (right - left + 1) / 2;
            if (window == sum){
                ArrayList<Integer> help = new ArrayList<>();
                for (int i = left ;i <= right ;i ++){
                    help.add(i);
                }
                res.add(help);
                left ++;
            }else if (window < sum){
                right ++;
            }else {
                left ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Num41 num41 = new Num41();
        ArrayList<ArrayList<Integer>> res = num41.FindContinuousSequence(100);
        res.forEach(t ->{
            t.forEach(x-> System.out.print(x + " "));
            System.out.println();
        });
    }
}
