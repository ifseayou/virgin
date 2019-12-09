package com.isea.penis;

import com.isea.penis.to30.*;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author isea_you
 * @date 2019/12/3
 * @time 8:10
 * @target:
 */
public class To30Test {
    @Test
    public void testNum21(){
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        int[] falsePopA = {4,3,5,1,2};
        Num21 num21 = new Num21();
        System.out.println(num21.IsPopOrder(pushA,popA));
        System.out.println(num21.IsPopOrder(pushA,falsePopA));
    }

    @Test
    public void testNum23(){
        Num23 num23 = new Num23();
        int[] sequence1 = {1, 3, 2, 5, 7, 6, 4};
        int[] sequence2 = {1, 100, 2, 5, 7, 6, 4};

        System.out.println(num23.VerifySequenceOfBST(sequence1));
        System.out.println(num23.VerifySequenceOfBST(sequence2));
    }

    @Test
    public void testNum27(){
        String abc = "abc";
        Num27 num27 = new Num27();
        ArrayList<String> res = num27.Permutation(abc);
        res.forEach(t-> System.out.print(t + "\t"));


    }

    @Test
    public void  testNum28(){
        Num28 num28 = new Num28();
        int[] arr1 = {99,2,99,4,6,99,99};
        int[] arr2 = {1,3,1,4,6,1,1};
        int[] arr3 = {1,3,5,4,6,1,1};
        System.out.println(num28.MoreThanHalfNum_Solution(arr1));
        System.out.println(num28.MoreThanHalfNum_Solution(arr2));
        System.out.println(num28.MoreThanHalfNum_Solution(arr3));


        System.out.println(num28.MoreThanHalfNum_Solution2(arr1));
        System.out.println(num28.MoreThanHalfNum_Solution2(arr2));
        System.out.println(num28.MoreThanHalfNum_Solution2(arr3));
    }

    @Test
    public void testNum29(){
        Num29 num29 = new Num29();
        int[] inputs = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> res = num29.GetLeastNumbers_Solution(inputs, 4);
        res.forEach((i) ->
                System.out.print(i + " "));

        ArrayList<Integer> res2 = num29.solution2(inputs, 4);
        System.out.println();
        res2.forEach(t -> System.out.print(t + "\t"));
    }

    @Test
    public void testNum30(){
        int[] arr = {6,-3,-2,7,-15,1,2,2};
        Num30 num30 = new Num30();
        System.out.println(num30.FindGreatestSumOfSubArray(arr));
    }
}
