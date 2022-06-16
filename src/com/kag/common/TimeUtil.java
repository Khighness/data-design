package com.kag.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @apiNote 时间工具类
 * @author KHighness
 * @since 2020/4/30
 */
public class TimeUtil {

    /**
     * @apiNote 获取当前时间
     * @return String 时间
     */
    public static String CurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        return simpleDateFormat.format(new Date());
    }

    /**
     * @apiNote 格式化日期
     * @param date
     * @return String
     */
    public static String getFormatDate(java.util.Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY年MM月dd日");
        return simpleDateFormat.format(date);
    }

    /**
     * @apiNote 时间格式转化
     * @param date  java.util
     * @return date java.sql
     */
    public static java.sql.Date transformToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    /**
     * @apiNote 时间格式转化
     * @param date  java.sql
     * @return date java.util
     */
    public static java.util.Date transformToUtilDate(java.sql.Date date) {
        return new java.util.Date(date.getTime());
    }

}
