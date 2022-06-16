package com.kag.common;


import org.apache.log4j.Logger;

/**
 * @apiNote 异常工具类
 * @author KHighness
 * @since 2020/4/30
 */
public class ExceptionUtil {
    /**
     * @apiNote 统一异常日志
     * @param Exception
     */
    public static Logger logger = Logger.getLogger(ExceptionUtil.class);

    public static void printException(Exception e) {
        logger.warn("Cause: " +  e.getCause());
        logger.warn("Message: " + e.getMessage());
    }
}
