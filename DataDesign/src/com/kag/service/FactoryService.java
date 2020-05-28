package com.kag.service;

import com.kag.dao.FactoryDao;
import com.kag.dao.FactoryDaoImpl;
import com.kag.entity.Factory;

/**
 * @Description: 厂家服务层
 * @Author: 陈子康
 * @Date: 2020/5/24
 */
public class FactoryService {

    private FactoryDao factoryDao = new FactoryDaoImpl();

    public void addFactoryService(Factory factory) {
        factoryDao.addFactory(factory);
    }

    public Factory queryFactoryByIdService(int factoryId) {
        return factoryDao.queryFactoryById(factoryId);
    }
}
