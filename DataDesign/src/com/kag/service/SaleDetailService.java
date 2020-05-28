package com.kag.service;

import com.kag.dao.SaleDetailDao;
import com.kag.dao.SaleDetailDaoImpl;
import com.kag.entity.SaleDetail;

/**
 * @Description: 批发服务层
 * @Author: 陈子康
 * @Date: 2020/5/24
 */
public class SaleDetailService {

    private SaleDetailDao saleDetailDao = new SaleDetailDaoImpl();

    public void addSaleDetailService(SaleDetail saleDetail) {
        saleDetailDao.addSaleDetail(saleDetail);
    }

}
