package com.kag.service;

import com.kag.dao.PurchaseDetailDao;
import com.kag.dao.PurchaseDetailDaoImpl;
import com.kag.dao.PurchaseMainDao;
import com.kag.dao.PurchaseMainDaoImpl;
import com.kag.entity.PurchaseMain;

/**
 * @apiNote 进货服务层
 * @author KHighness
 * @since 2020/5/24
 */
public class PurchaseMainService {

    private PurchaseMainDao purchaseMainDao = new PurchaseMainDaoImpl();

    public void addPurchaseMainService(PurchaseMain purchaseMain) {
        purchaseMainDao.addPurchaseMain(purchaseMain);
    }

    public void updatePurchaseTransactionService(String purchaseId, double transactionAmount) {
        purchaseMainDao.updatePurchaseTransaction(purchaseId, transactionAmount);
    }

}
