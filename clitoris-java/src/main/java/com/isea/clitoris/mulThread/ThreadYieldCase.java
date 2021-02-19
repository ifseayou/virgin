package com.isea.clitoris.mulThread;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import sun.awt.windows.ThemeReader;

/**
 * @author ifseayou@gmail.com
 * @date 2021/1/25 11:50
 * @target:
 */
public class ThreadYieldCase{
    private final static Logger logger = LoggerFactory.getLogger(ThreadYieldCase.class);
    public static void main(String[] args) {
        Thread subThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                logger.info("subThread" + i);
            }
        });
        subThread.start();
        for (int i = 0; i < 100; i++) {
            if (i % 15== 0){
                Thread.yield();
            }
        }
    }
}

