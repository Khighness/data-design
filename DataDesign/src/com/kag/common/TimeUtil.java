package com.kag.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 时间工具类
 * @Author: 陈子康
 * @Date: 2020/4/30
 */
public class TimeUtil {

    /**
     * @Description: 获取当前时间
     * @return String 时间
     */
    public static String CurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        return simpleDateFormat.format(new Date());
    }

    /**
     * @Description: 格式化日期
     * @param date
     * @return String
     */
    public static String getFormatDate(java.util.Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY年MM月dd日");
        return simpleDateFormat.format(date);
    }

    /**
     * @Description: 时间格式转化
     * @param date  java.util
     * @return date java.sql
     */
    public static java.sql.Date transformToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    /**
     * @Description: 时间格式转化
     * @param date  java.sql
     * @return date java.util
     */
    public static java.util.Date transformToUtilDate(java.sql.Date date) {
        return new java.util.Date(date.getTime());
    }

}
