package com.kag.dao;

import com.kag.entity.Stock;

import java.util.List;

/**
 * @Description: 库存持久层
 * @Author: 陈子康
 * @Date: 2020/5/22
 */
public interface StockDao {

    public void addStock(int mid);

    public void addStockRemark(int mid, String remark);

    public void updateStock(int mid, int newQuantity);

    public List<Stock> queryStock();

    public Stock queryStockById(int mid);

}
