package com.loring.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonsLog {

    public static void main(String[] args) {
        Log log = LogFactory.getLog(CommonsLog.class);
        log.info("start...");
        log.warn("end.");
    }
}
