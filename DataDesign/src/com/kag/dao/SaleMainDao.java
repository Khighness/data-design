package com.kag.dao;

import com.kag.entity.SaleMain;

/**
 * @Description: 批发（主表）持久层
 * @Author: 陈子康
 * @Date: 2020/5/6
 */
public interface SaleMainDao {

    public void addSaleMain(SaleMain saleMain);

    public void updateSaleTransaction(String saleId, double transactionAmount);
}
