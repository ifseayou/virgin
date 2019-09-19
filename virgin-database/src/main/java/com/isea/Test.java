package com.isea;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author isea_you
 * @date 2019/9/18
 * @time 14:48
 * @target:
 */
public class Test {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd:H:m:s");
        System.out.println(df.format(new Date()));
    }
}
