package com.isea.clitoris;

import org.junit.Test;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/16 14:29
 * @target:
 */
@VirginAnnotation("江山美人")
public class AnnotationTest {
    @Test
    public void testVirginAnnotation(){
        Class<AnnotationTest> clazz = AnnotationTest.class;
        VirginAnnotation annotation = clazz.getAnnotation(VirginAnnotation.class);
        String value = annotation.value();
        System.out.println(value); // 江山美人
    }
}
