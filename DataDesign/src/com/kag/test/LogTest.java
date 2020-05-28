package com.kag.test;

import org.apache.log4j.Logger;

public class LogTest {
    Logger logger = Logger.getLogger(LogTest.class);

    public LogTest() {
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.trace("TRACE");
        logger.warn("WARN");
    }
    public static void main(String[] args) {
        new LogTest();
    }
}
