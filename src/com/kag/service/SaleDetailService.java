package com.kag.service;

import com.kag.dao.SaleDetailDao;
import com.kag.dao.SaleDetailDaoImpl;
import com.kag.entity.SaleDetail;

/**
 * @apiNote 批发服务层
 * @author KHighness
 * @since 2020/5/24
 */
public class SaleDetailService {

    private SaleDetailDao saleDetailDao = new SaleDetailDaoImpl();

    public void addSaleDetailService(SaleDetail saleDetail) {
        saleDetailDao.addSaleDetail(saleDetail);
    }

}
