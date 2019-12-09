package com.isea.penis;

import com.isea.penis.end80.Num71;
import com.isea.penis.end80.Num73;
import com.isea.penis.end80.Num74;
import org.junit.Test;

/**
 * @author isea_you
 * @date 2019/11/22
 * @time 14:02
 * @target:
 */
public class End80Test {
    @Test
    public void testNum71() {
        int[] arr = {1,3,4,2,5};
        Num71 num71 = new Num71();
        System.out.println(num71.smallSum(arr));
    }

    @Test
    public void testNum73(){
        String[] strArr1 = {"112","wqw","2121"};
        String[] strArr2 = {"112","aad","ewqw","112"};
        Num73 num73 = new Num73();
        num73.printIntersection(strArr1,strArr2);
    }

    @Test
    public void testNum74(){
        int[] arr = {1,3,4,2,5};
        Num74 num74 = new Num74();
        num74.reverseOrderPair(arr);
    }
}
