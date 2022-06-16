package com.kag.service;

import com.kag.dao.PurchaseDetailDao;
import com.kag.dao.PurchaseDetailDaoImpl;
import com.kag.entity.PurchaseDetail;

/**
 * @apiNote 进货服务层
 * @author KHighness
 * @since 2020/5/24
 */
public class PurchaseDetailService {

    private PurchaseDetailDao purchaseDetailDao = new PurchaseDetailDaoImpl();

    public void addPurchaseDetailService(PurchaseDetail purchaseDetail) {
        purchaseDetailDao.addPurchaseDetail(purchaseDetail);
    }
}
