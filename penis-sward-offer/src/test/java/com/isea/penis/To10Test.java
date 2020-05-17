package com.isea.penis;

import com.isea.penis.to10.*;
import org.junit.Test;

/**
 * @author isea_you
 * @date 2019/11/25
 * @time 16:56
 * @target:
 */
public class To10Test {
    @Test
    public void testNum1() {
        /**
         * 1 2 3
         * 4 5 6
         * 7 8 9
         */
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Num1 num1 = new Num1();
        System.out.println(num1.find(0, arr));
        System.out.println(num1.find(3, arr));
    }

    @Test
    public void testNum2() {
        String target = "We Are Happy";
        StringBuffer sb = new StringBuffer(target);
        Num2 num2 = new Num2();
        System.out.println(num2.replaceSpace(sb));
    }

    @Test
    public void testNum3() {
    }

    @Test
    public void testNum5(){
        Num5 num5 = new Num5();
        num5.push(4);
        num5.push(5);
        num5.push(6);
        System.out.println(num5.pop());
        System.out.println(num5.pop());
    }

    @Test
    public void  testNum6(){
        int[] arr = new int[]{3,4,5,1,2};
        Num6 num6 = new Num6();
        System.out.println(num6.minNumberInRotateArray(arr));
    }

    @Test
    public void testNum7(){
        Num7 num7 = new Num7();
        System.out.println(num7.Fibonacci(1));
        System.out.println(num7.Fibonacci(2));
        System.out.println(num7.Fibonacci(3));
        System.out.println(num7.Fibonacci(4));
        System.out.println(num7.Fibonacci(9));
    }

    @Test
    public void testNum8(){
        Num8 num8 = new Num8();
        System.out.println(num8.JumpFloor(2));
        System.out.println(num8.JumpFloor(3));
        System.out.println(num8.JumpFloor(4));
    }

    @Test
    public void testNum9(){
        Num9 num9 = new Num9();
        System.out.println(num9.JumpFloorII(1));
        System.out.println(num9.JumpFloorII(3));
        System.out.println(num9.JumpFloorII(4));
    }

    @Test
    public void testNum10(){
        Num10 num10 = new Num10();
        System.out.println(num10.RectCover(1));
        System.out.println(num10.RectCover(2));
        System.out.println(num10.RectCover(3));
    }


    @Test
    public void test(){
        int[] oneD = {1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < oneD.length; i++) {
            System.out.print(oneD[i]+ "\t");
        }

        int[][] twoD = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        System.out.println();
        for (int i = 0; i < twoD.length; i++) {
            for (int j = 0 ; j < twoD[i].length; j ++){
                System.out.print(twoD[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
