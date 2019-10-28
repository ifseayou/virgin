package com.isea.clitoris.method;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author isea_you
 * @date 2019/9/19
 * @time 17:29
 * @target:
 */
public class GetFormatDateCase {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dfs1 = new SimpleDateFormat("YYYY_MM_dd");
        System.out.println(dfs1.format(new Date())); // 2019_09_19

        SimpleDateFormat dfs2 = new SimpleDateFormat("yyyy-MM-dd HH:m:s ");
        System.out.println(dfs2.format(new Date()));


        SimpleDateFormat dfs3 = new SimpleDateFormat("yyyy-MM-dd:HH:m:s:SSS");
        Date date = new Date();
        String result = dfs3.format(date);
        System.out.println(result); // 2019-09-21:10:14:36:358

        // 由时间获得时间戳
        System.out.println(date.getTime());  // 时间戳

        Date date1 = dfs3.parse(result);
        long ts = date1.getTime();
        System.out.println(ts);





    }

}
