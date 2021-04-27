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

    public void updateFactoryService(int fid, Factory factory) {
        factoryDao.updateFactory(fid, factory);
    }

    public Factory queryFactoryByIdService(int factoryId) {
        return factoryDao.queryFactoryById(factoryId);
    }

    public Factory queryFactoryBuyNameService(String factoryName) {
        return factoryDao.queryFactoryByName(factoryName);
    }

    public void deleteFactoryService(int factoryId) {
        factoryDao.deleteFactory(factoryId);
    }

}
