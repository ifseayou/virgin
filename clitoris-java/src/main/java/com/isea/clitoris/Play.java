package com.isea.clitoris;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author ifseayou@gmail.com
 * @date 2021/1/11 23:47
 * @target:
 */
public class Play{
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("be");
        list.add("nice");
        list.add("be");
        list.add("more");
        list.forEach(t-> System.out.println(t));
        list.forEach(System.out::println);

    }
}