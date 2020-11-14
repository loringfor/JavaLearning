package com.loring.log;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class JDKLog{
    //private static final Logger logger = LoggerFactory.getLogger(TestLog.class);

    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();
        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.fine("ignored.");
        logger.severe("process will be terminated...");

//        logger.info("Current Time: {}", System.currentTimeMillis());
//        logger.info("Current Time: " + System.currentTimeMillis());
//        logger.info("Current Time: {}", System.currentTimeMillis());
//        logger.trace("trace log");
//        logger.warn("warn log");
//        logger.debug("debug log");
//        logger.info("info log");
//        logger.error("error log");
    }
}
