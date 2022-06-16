package com.kag.service;

import com.kag.dao.StockDao;
import com.kag.dao.StockDaoImpl;
import com.kag.entity.Stock;

import java.util.List;

/**
 * @apiNote 库存服务层
 * @author KHighness
 * @since 2020/5/24
 */
public class StockService {

    private StockDao stockDao = new StockDaoImpl();

    public void addStockService(int mid) {
        stockDao.addStock(mid);
    }

    public void updateIncreaseStockService(int mid, int increaseQuantity) {
        stockDao.updateIncreaseStock(mid, increaseQuantity);
    }

    public void updateDecreaseStockService(int mid, int decreaseQuantity) {
        stockDao.updateDecreaseStock(mid, decreaseQuantity);
    }

    public int queryStockQuantityByIdService(int mid) {
        return stockDao.queryStockQuantityById(mid);
    }

    public Stock queryStockByIdService(int mid) {
        return stockDao.queryStockById(mid);
    }

    public List<Stock> queryStockService() {
        return stockDao.queryStock();
    }

    public void deleteStockService(int mid) {
        stockDao.deleteStock(mid);
    }

}
