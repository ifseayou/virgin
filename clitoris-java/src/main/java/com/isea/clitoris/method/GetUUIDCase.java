package com.isea.clitoris.method;

import java.util.UUID;

/**
 * @author isea_you
 * @date 2019/9/19
 * @time 17:18
 * @target:
 */
public class GetUUIDCase {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());  //
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid);
    }
}
