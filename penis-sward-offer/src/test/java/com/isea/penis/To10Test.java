package com.isea.penis;

import com.isea.penis.to10.Num1;
import com.isea.penis.to10.Num2;
import com.isea.penis.to10.Num5;
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
}
