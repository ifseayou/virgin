package com.isea.virgin.virginloggerannotation.annotation;

import java.lang.annotation.*;

/**
 * @author isea_you
 * @date 2019/9/25
 * @time 14:29
 * @target:
 */
@Documented // @Documented是否生成文档的标注, 也就是生成接口文档, 是否生成注解文档
@Retention(RetentionPolicy.RUNTIME)  // )@Retention注解表示的是本注解(标注这个注解的注解保留时期)
@Target(ElementType.METHOD)  // @Target注解是标注这个类它可以标注的位置,常用的元素类型(ElementType)
public @interface Log {
    String value() default "";
}
