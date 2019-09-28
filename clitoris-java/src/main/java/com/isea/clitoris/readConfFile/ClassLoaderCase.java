package com.isea.clitoris.readConfFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

/**
 * @author isea_you
 * @date 2019/9/19
 * @time 18:05
 * @target:
 */
public class ClassLoaderCase {
    public static void main(String[] args) throws FileNotFoundException {
        URL resource = Thread.currentThread().getContextClassLoader().getResource("bundles/locale.properties");
    }
}
