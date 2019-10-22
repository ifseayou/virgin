package com.isea.clitoris.mulThread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author isea_you
 * @date 2019/10/19
 * @time 15:29
 * @target: 演示join的作用
 */
public class ThreadJoinCase {
    private final static Logger logger = LoggerFactory.getLogger(ThreadJoinCase.class);

    public static void main(String[] args) throws InterruptedException {
        logger.info("main线程开始执行了....");
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                logger.info("thread-0" + i);
            }
        });
        thread.start();
        for (int i = 0; i < 10; i++) {
            thread.join(); // thread线程执行完毕了之后，才会执行下面的代码
            logger.info("main" + i);
        }
    }
}
