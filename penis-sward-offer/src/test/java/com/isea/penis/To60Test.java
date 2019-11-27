package com.isea.penis;

import com.isea.penis.to60.Num54;
import org.junit.Test;

/**
 * @author isea_you
 * @date 2019/11/25
 * @time 18:22
 * @target:
 */
public class To60Test {
    @Test
    public void testNum54(){
        Num54 num54 = new Num54();
        String str = "12e";
        num54.isNumeric(str.toCharArray());
    }
}
