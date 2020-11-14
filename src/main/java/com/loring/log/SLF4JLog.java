package com.loring.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JLog {
    private static final Logger logger = LoggerFactory.getLogger(SLF4JLog.class);

    public static void main(String[] args) {
        logger.info("Current Time: {}", System.currentTimeMillis());
        logger.info("Current Time: " + System.currentTimeMillis());
        logger.info("Current Time: {}", System.currentTimeMillis());
        logger.trace("trace log");
        logger.warn("warn log");
        logger.debug("debug log");
        logger.info("info log");
        logger.error("error log");
    }
}