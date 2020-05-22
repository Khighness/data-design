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

//    /** 订单类别头 */
//    private static final String ORDER_CODE = "1";
//    /** 退货类别头 */
//    private static final String RETURN_ORDER = "2";
//    /** 退款类别头 */
//    private static final String REFUND_ORDER = "3";
//    /** 未付款重新支付别头 */
//    private static final String AGAIN_ORDER = "4";
//    /** 随即编码 */
//    private static final int[] r = new int[]{7, 9, 6, 2, 8, 1, 3, 0, 5, 4};
//    /** 用户id和随机数总长度 */
//    private static final int maxLength = 12;
//
//    /**
//      * @Description: 更具id进行加密+加随机数组成固定长度编码
//      */
//    private static String toCode(Long id) {
//        String IDSTR = id.toString();
//        StringBuilder IDSBS = new StringBuilder();
//        for (int i = IDSTR.length() - 1; i >= 0; i--) {
//            IDSBS.append(r[IDSTR.charAt(i) - '0']);
//        }
//        return IDSBS.append(getRandom(maxLength - IDSTR.length())).toString();
//    }
//
//    /**
//      * @Description: 生成时间戳
//      */
//    private static String getDateTime() {
//        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//        return sdf.format(new Date());
//    }
//
//    /**
//      * @Description: 生成固定长度随机码
//      * @param n  长度
//      */
//    private static long getRandom(long n) {
//        long min = 1, max = 9;
//        for (int i = 1; i < n; i++) {
//            min *= 10;
//            max *= 10;
//        }
//        long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min;
//        return rangeLong;
//    }
//
//    /**
//      * @Description: 生成不带类别标头的编码
//      * @param userId
//      */
//    private static synchronized String getCode(Long userId) {
//        userId = userId == null ? 10000 : userId;
//        return getDateTime() + toCode(userId);
//    }
//
//    /**
//      * @Description: 生成订单单号编码
//      * @param userId
//      */
//    public static String getOrderCode(Long userId) {
//        return ORDER_CODE + getCode(userId);
//    }
//
//    /**
//      * @Description: 生成退货单号编码
//      * @param userId
//      */
//    public static String getReturnCode(Long userId) {
//        return RETURN_ORDER + getCode(userId);
//    }
//
//    /**
//      * @Description: 生成退款单号编码
//      * @param userId
//      */
//    public static String getRefundCode(Long userId) {
//        return REFUND_ORDER + getCode(userId);
//    }
//
//    /**
//      * @Description: 未付款重新支付
//      * @param userId
//      */
//    public static String getAgainCode(Long userId) {
//    return AGAIN_ORDER + getCode(userId);
//    }
//
//    public static void main(String[] args) {
//        String id = getOrderCode((long) 20200001);
//        System.out.println(id);
//        System.out.println(id.length());
//    }

    /**
     * @Description: 生成进货订单号
     * 1、type[1位]：1（进货）
     * 2、time[10位]：时间戳（yyyyMMddHHmmss）
     * 3、fid[2位]：厂家ID取后两位
     * 4、sid[2位]：职员ID取后两位
     */
    public String getPurchaseOrderNumberGenerator() {
        return "";
    }


}