package com.isea.penis.to40;

/**
 * @author isea_you
 * @date 2019/11/4
 * @time 8:42
 * @target: 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * !!! 丑数列举：1,2,3,4,5,6,8,9,10，12,15,16
 * 思路：一个丑数 * 2/3/5 才有会得到一个丑数
 *
 */
public class Num33 {
    public int GetUglyNumber_Solution(int index) {
        if (index < 7) {
            return index;
        }
        int[] res = new int[index]; // 丑数的数组
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        res[0] = 1;
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(res[p2] * 2, Math.min(res[p3] * 3, res[p5] * 5)); // 计算当前最小的丑数才进入丑数数组
            if (res[i] == res[p2] * 2) p2++;
            if (res[i] == res[p3] * 3) p3++;
            if (res[i] == res[p5] * 5) p5++;
        }
        return res[index - 1];
    }
}
