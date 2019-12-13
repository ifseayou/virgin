package com.isea.clitoris;

import com.alibaba.fastjson.JSONObject;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author isea_you
 * @date 2019/11/11
 * @time 9:21
 * @target:
 */
public class Test {
    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
        ArrayList arr = new ArrayList();
        arr.add("中恒博瑞");
        arr.add("奂亿科技甲");
        arr.add("阿门");
        arr.add("奂亿科技乙");
        arr.add("园区分布");
        Collections.sort(arr,Collections.reverseOrder());
        arr.forEach(t -> System.out.println(t));
        HanyuPinyinOutputFormat hypy = new HanyuPinyinOutputFormat();
        hypy.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        hypy.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        hypy.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON);
        System.out.println(PinyinHelper.toHanyuPinyinStringArray("中恒博瑞".charAt(0), hypy)[0].charAt(0));


        String s = JSONObject.parseObject(null, String.class);
        System.out.println(s == null);


        int a = 'A';
        int z = 'Z';
        int x = '#';
        System.out.println(a + "   " + z + "   " + x);
    }


}