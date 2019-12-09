package com.isea.penis;

import com.isea.penis.recursion.RecursionSample;
import org.junit.Test;

/**
 * @author ifseayou@gmail.com
 * @date 2019/12/7 14:28
 * @target:
 */
public class RecursionTest {
    @Test
    public void testRecursionSample(){
        int[] arr = {1,44,2,33,14};
        RecursionSample rs = new RecursionSample();
        System.out.println(rs.getMax(arr));
    }
}
