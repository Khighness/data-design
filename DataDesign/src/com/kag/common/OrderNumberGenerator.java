package com.kag.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.*;

/**
 * @Description: 订单号生成工具类
 * @Author: 陈子康
 * @Date: 2020/4/30
 */
public class OrderNumberGenerator {

    /** 进货类别头 */
    private static final String PURCHASE_CODE = "1";
    /** 批发类别头 */
    private static final String SALE_CODE = "2";
    /** 退款类别头 */
    private static final String RETAIL_CODE = "3";

    /**
     * @Description: 生成时间串
     */
    private static String getTimeString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDateFormat.format(new Date());
    }

    /**
     * @Description: 生成进货订单号
     * 1、type[1位]：1（进货）
     * 2、time[10位]：时间戳（yyyyMMddHHmmss）
     * 3、fid[4位]：厂家ID取后4位
     * 4、sid[4位]：职员ID取后4位
     */
    public static String getPurchaseOrderNumber(int fid, int sid) {
        return PURCHASE_CODE + getTimeString() + String.valueOf(fid).substring(4) + String.valueOf(sid).substring(4);
    }

    /**
     * @Description: 生成批发订单号
     * 1、type[1位]：2（批发）
     * 2、time[10位]：时间戳（yyyyMMddHHmmss）
     * 3、cid[4位]：客户ID取后4位
     * 4、sid[4位]：职员ID取后4位
     */
    public static String getSaleOrderNumber(int cid, int sid) {
        return SALE_CODE + getTimeString() + String.valueOf(cid).substring(4) + String.valueOf(sid).substring(4);
    }

    /**
     * @Description: 生成零售订单号
     * 1、type[1位]：3（零售）
     * 2、time[10位]：时间戳（yyyyMMddHHmmss）
     * 3、cid[4位]：客户ID取后4位
     * 4、sid[4位]：职员ID取后4位
     */
    public static String getRetailOrderNumber(int cid, int sid) {
        return RETAIL_CODE + getTimeString() + String.valueOf(cid).substring(4) + String.valueOf(sid).substring(4);
    }

}