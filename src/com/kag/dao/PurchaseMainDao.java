package com.kag.dao;

import com.kag.entity.PurchaseMain;

/**
 * @apiNote 进货（主表）持久层
 * @author KHighness
 * @since 2020/5/21
 */
public interface PurchaseMainDao {

    public void addPurchaseMain(PurchaseMain purchaseMain);

    public void updatePurchaseTransaction(String purchaseId, double transactionAmount);

}
