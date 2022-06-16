package com.kag.service;

import com.kag.dao.RetailDao;
import com.kag.dao.RetailDaoImpl;
import com.kag.entity.Retail;

/**
 * @apiNote 进货服务层
 * @author KHighness
 * @since 2020/5/24
 */
public class RetailService {

    private RetailDao retailDao = new RetailDaoImpl();

    public void addRetailService(Retail retail) {
        retailDao.addRetail(retail);
    }
}
