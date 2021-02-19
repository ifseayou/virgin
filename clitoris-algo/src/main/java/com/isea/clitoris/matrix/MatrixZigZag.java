package com.isea.clitoris.matrix;

/**
 * @author ifseayou@gmail.com
 * @date 2021/2/18 19:07
 * @target: 之字形打印矩阵
 */
public class MatrixZigZag {
    public static void printMatrixZigZag(int[][] matrix){
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = matrix.length -1;
        int endC = matrix[0].length -1;
        boolean flag = false;
        while(aR != endR +1){
            printLevel(matrix,aR,aC,bR,bC,flag);
            aR = aC == endC? aR +1:aR;
            aC = aC == endC? aC:aC + 1;
            bR = bR == endR? bR:bR +1;
            bC = bR == endR? bC + 1:bC;
            flag = !flag;
        }
    }

    private static void printLevel(int[][] matrix, int tR, int tC, int dR, int dC, boolean flag) {
        if (flag){
            while(tR != dR + 1){
                System.out.print(matrix[tR++][tC--]);
            }
        }else {
            while(dR != tR -1){
                System.out.print(matrix[dR --][dC ++]);
            }
        }
    }

}
