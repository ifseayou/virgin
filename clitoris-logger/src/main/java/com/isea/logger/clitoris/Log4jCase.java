package com.isea.logger.clitoris;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author isea_you
 * @date 2019/9/24
 * @time 10:49
 * @target:
 */
public class Log4jCase {
    private final static Logger logger = LoggerFactory.getLogger(Log4jCase.class);
    public static void main(String[] args) {
        logger.info("hello");
    }
}
