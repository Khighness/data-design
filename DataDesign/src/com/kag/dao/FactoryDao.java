package com.kag.dao;

import com.kag.entity.Factory;

import java.util.List;

/**
 * @Description: 生产厂家持久层
 * @Author: 陈子康
 * @Date: 2020/5/21
 */
public interface FactoryDao {

    public void addFactory(Factory factory);

    public void updateFactory(int factoryId, Factory factory);

    public List<Factory> queryFactory();

    public Factory queryFactoryById(int factoryId);

    public Factory queryFactoryByName(String factoryName);

    public void deleteFactory(int factoryId);

}
