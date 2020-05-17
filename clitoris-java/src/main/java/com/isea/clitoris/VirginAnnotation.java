package com.isea.clitoris;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/16 14:30
 * @target:
 */

/*
    @Retention 即保留策略，用于描述注解的生命周期，该注解有一个RetentionPolicy 类型成员变量，需要指定其值；有三个值：
        SOURCE      原文件中有效
        CLASS       默认
        RUNTIME     运行时保留，程序运行时，JVM会保留注释，程序可以反射获取到该注释

    @Target   用于描述注解的用在什么地方，描述：Class, interface (including annotation type), or enum declaration

    @Aliasfor 互为注解作用一个负责方便一个负责体现实际含义
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface VirginAnnotation {
    String value() default "This is a virgin annotation...";
}
