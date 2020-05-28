package com.kag.common;


import org.apache.log4j.Logger;

/**
 * @Description: 异常工具类
 * @Author: 陈子康
 * @Date: 2020/4/30
 */
public class ExceptUtil {
    /**
     * @Description: 统一异常日志
     * @param Exception
     */
    public static Logger logger = Logger.getLogger(ExceptUtil.class);

    public static void printException(Exception e) {
        logger.warn("Cause: " +  e.getCause());
        logger.warn("Message: " + e.getMessage());
    }
}
