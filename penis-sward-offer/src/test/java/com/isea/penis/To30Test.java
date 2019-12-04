package com.isea.penis;

import com.isea.penis.to30.Num21;
import com.isea.penis.to30.Num23;
import org.junit.Test;

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

}
