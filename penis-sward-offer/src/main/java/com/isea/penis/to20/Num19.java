package com.isea.penis.to20;

import java.util.ArrayList;

/**
 * @author isea_you
 * @date 2019/10/28
 * @time 9:42
 * @target: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * !!! 注意这里处理的技巧是，每次处理 n- 1个数据 ，如此一来就能很好的控制下标
 */
public class Num19 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while (a <= c && c <= d) {
            circlePrintMatrix(matrix, res, a++, b++, c--, d--);
        }
        return res;
    }

    private void circlePrintMatrix(int[][] matrix, ArrayList<Integer> res, int a, int b, int c, int d) {
        if (a == c) { // 同一行
            for (int i = b; i <= d; i++) {
                res.add(matrix[a][i]);
            }
        } else if (b == d) { // 同一列
            for (int i = a; i <= c; i++) {
                res.add(matrix[i][b]);
            }
        } else { // 不同行，不同列
            int curR = a;
            int curC = b;
            while (curC != d) { // 上行
                res.add(matrix[a][curC++]);
            }
            while (curR != c) { // 右列
                res.add(matrix[curR++][d]);
            }
            while(curC != b){ // 下行
                res.add(matrix[c][curC --]);
            }
            while(curR != a){ // 左列
                res.add(matrix[curR --][b]);
            }
        }
    }
}
