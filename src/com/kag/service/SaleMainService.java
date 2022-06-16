package com.kag.service;

import com.kag.dao.SaleMainDao;
import com.kag.dao.SaleMainDaoImpl;
import com.kag.entity.SaleMain;

/**
 * @apiNote 批发服务层
 * @author KHighness
 * @since 2020/5/24
 */
public class SaleMainService {

    private SaleMainDao saleMainDao = new SaleMainDaoImpl();

    public void addSaleMainService(SaleMain saleMain) {
        saleMainDao.addSaleMain(saleMain);
    }

    public void updateSaleTransactionService(String saleId, double transactionAmount) {
        saleMainDao.updateSaleTransaction(saleId, transactionAmount);
    }

}
