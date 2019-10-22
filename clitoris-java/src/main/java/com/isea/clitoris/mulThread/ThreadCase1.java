package com.isea.clitoris.mulThread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author isea_you
 * @date 2019/10/19
 * @time 14:02
 * @target: 观察两个线程之间是交替执行的
 */
public class ThreadCase1 {
    private final static Logger logger = LoggerFactory.getLogger(ThreadCase1.class);

    public static void main(String[] args) {
        new Thread(() ->{
            for (int i = 0; i < 100; i++) {
                logger.info("Thread" + i);
            }
        }).start();

        for (int i = 0; i < 100; i++) {
            logger.info("Main" + i);
        }
    }
}
