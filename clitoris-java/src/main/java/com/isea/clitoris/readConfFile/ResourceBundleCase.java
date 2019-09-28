package com.isea.clitoris.readConfFile;

import java.util.ResourceBundle;

/**
 * @author isea_you
 * @date 2019/9/19
 * @time 17:59
 * @target:
 */
public class ResourceBundleCase {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("bundles/locale");
        System.out.println(bundle.getString("name"));
    }
}
