package com.kag.dao;

import com.kag.entity.Stock;

import java.util.List;

/**
 * @apiNote 库存持久层
 * @author KHighness
 * @since 2020/5/22
 */
public interface StockDao {

    public void addStock(int mid);

    public void addStockRemark(int mid, String remark);

    public void updateIncreaseStock(int mid, int increaseQuantity);

    public void updateDecreaseStock(int mid, int decreaseQuantity);

    public List<Stock> queryStock();

    public Stock queryStockById(int mid);

    public int queryStockQuantityById(int mid);

    public void deleteStock(int mid);

}
