package com.isea.clitoris.classes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author isea_you
 * @date 2019/9/26
 * @time 19:14
 * @target:
 */
public class ThreadLocalCase {
    private final static Logger logger = LoggerFactory.getLogger(ThreadLocalCase.class);
    static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        local.set("good");
        new Thread(() ->
            logger.info(local.get())
        ).start();
        logger.info(local.get());
    }
}
/**
 * 65 [main] INFO com.isea.clitoris.classes.ThreadLocalCase - good
 * 65 [Thread-0] INFO com.isea.clitoris.classes.ThreadLocalCase - null
 */
