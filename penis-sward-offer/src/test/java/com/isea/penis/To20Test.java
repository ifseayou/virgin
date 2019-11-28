package com.isea.penis;

import com.isea.penis.to20.Num11;
import com.isea.penis.to20.Num12;
import com.isea.penis.to20.Num13;
import org.junit.Test;

/**
 * @author isea_you
 * @date 2019/11/28
 * @time 20:50
 * @target:
 */
public class To20Test {
    @Test
    public void testNum11(){
        Num11 num11 = new Num11();
        System.out.println(num11.NumberOf1(1));
        System.out.println(num11.NumberOf1(2));
        System.out.println(num11.NumberOf1(3));
        System.out.println(num11.NumberOf1(4));
    }

    @Test void testNum12(){
        Num12 num12 = new Num12();
        System.out.println(num12.Power(2.0, 4));
        System.out.println(num12.Power(1.0, 0));
        System.out.println(num12.Power(0.0, 1));
        System.out.println(num12.Power(2.0, -2));
    }

    @Test
    public void testNum13(){
        int[] array = {4,5,3,2,1,6};
        for (int i : array) {
            System.out.print(i + "\t");
        }
        Num13 num13 = new Num13();
        num13.reOrderArray(array);
        System.out.println();
        for (int i : array) {
            System.out.print(i + "\t");
        }
    }
}
