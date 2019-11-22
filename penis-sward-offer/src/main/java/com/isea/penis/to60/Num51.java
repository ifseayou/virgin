package com.isea.penis.to60;

/**
 * @author isea_you
 * @date 2019/11/15
 * @time 8:00
 * @target: 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * ！！！使用下三角和上三角的方式进行计算
 * 例如，n = 4的时候 ：
 *      a0  a2  a2  a3
 * B0   1   A1  A2  A3  last=last*A1
 * B1   A0  1   A2  A3  last=last*A2
 * B2   A0  A1  1   A3  last=last*A3
 * B3   A0  A1  A2  1   last=1
 */
public class Num51 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if (A.length != 0){
            B[0] =  1;
            for (int i = 1; i < A.length ; i ++){
                B[i] = B[i - 1] * A[i - 1];
            }
            int last = 1; // 方阵的最后一个数
            for (int i = A.length - 2; i >= 0 ; i --){
                last *= A[i + 1];
                B[i] *= last;
            }
        }
        return B;
    }
    public static void main(String[] args) {
        Num51 num51 = new Num51();
        int[] A1 = {2,3,5};
        int[] res1 = num51.multiply(A1);
        for (int i : res1) {
            System.out.print(i + "\t");
        }// 6,3,2
        System.out.println();

        int[] A2 = {1};
        int[] res2 = num51.multiply(A2);
        for (int i : res2) {
            System.out.print(i + "\t");
        }// 1
        System.out.println();

        int[] A3 = {};
        int[] res3 = num51.multiply(A3);
        for (int i : res3) {
            System.out.print(i + "\t");
        }// 1
        System.out.println();
    }
}
