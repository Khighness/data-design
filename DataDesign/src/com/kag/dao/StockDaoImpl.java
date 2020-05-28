package com.kag.dao;

import com.kag.common.ExceptUtil;
import com.kag.common.MysqlUtil;
import com.kag.common.TimeUtil;
import com.kag.entity.Stock;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 库存持久层
 * @Author: 陈子康
 * @Date: 2020/5/22
 */
public class StockDaoImpl implements StockDao{

    public Logger logger = Logger.getLogger(StockDaoImpl.class);

    @Override
    public void addStock(int mid) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "INSERT INTO stock VALUES(?, ?, ?);";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, mid);
            preparedStatement.setInt(2, 0);
            preparedStatement.setString(3, "");
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("添加库存记录成功");
            } else {
                logger.error("添加库存记录失败");
            }
        } catch (SQLException e) {
            logger.warn("添加库存记录发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public void addStockRemark(int mid, String remark) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "UPDATE stock SET reamrk = ? WHERE mid = ?;";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, remark);
            preparedStatement.setInt(2, mid);
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("添加库存备注成功");
            } else {
                logger.error("添加库存备注失败");
            }
        } catch (SQLException e) {
            logger.warn("添加库存备注发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
        }
    }

    @Override
    public void updateIncreaseStock(int mid, int increaseQuantity) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "UPDATE stock SET stockQuantity = stockQuantity + ? WHERE mid = ?;";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, increaseQuantity);
            preparedStatement.setInt(2, mid);
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("更新库存记录成功");
            } else {
                logger.error("更新库存记录失败");
            }
        } catch (SQLException e) {
            logger.warn("更新库存记录发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
        }
    }

    @Override
    public void updateDecreaseStock(int mid, int decreaseQuantity) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "UPDATE stock SET stockQuantity = stockquantity - ? WHERE mid = ?;";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, decreaseQuantity);
            preparedStatement.setInt(2, mid);
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("更新库存记录成功");
            } else {
                logger.error("更新库存记录失败");
            }
        } catch (SQLException e) {
            logger.warn("更新库存记录发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
        }
    }

    @Override
    public List<Stock> queryStock() {
        List<Stock> stockList = new ArrayList<Stock>();
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT * FROM stock;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                stockList.add(new Stock(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3)
                ));
            }
            logger.info("查询所有药品库存信息");
        } catch (SQLException e) {
            logger.warn("查询所有库存药品信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return stockList;
    }

    @Override
    public Stock queryStockById(int mid) {
        Stock stock = null;
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT * FROM stock WHERE mid = " + mid + ";";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            stock = new Stock(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3)
            );
            logger.info("查询编号为" + mid + "药品的库存信息");
        } catch (SQLException e) {
            logger.warn("查询编号为" + mid + "药品的库存信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return stock;
    }

    @Override
    public int queryStockQuantityById(int mid) {
        int stockQuantity = 0;
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT stockQuantity FROM stock WHERE mid = " + mid + ";";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            stockQuantity = resultSet.getInt(1);
        } catch (SQLException e) {
            logger.warn("查询编号为" + mid + "药品的库存数量发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return stockQuantity;
    }

    @Override
    public void deleteStock(int mid) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "DELETE FROM stock WHERE mid = ?;";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, mid);
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("删除编号为" + mid + "的药品库存记录成功");
            } else {
                logger.error("删除编号为" + mid + "的药品库存记录失败");
            }
        } catch (SQLException e) {
            logger.warn("删除编号为" + mid + "的药品库存记录发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

//    public static void main(String[] args) {
//        StockDao stockDao = new StockDaoImpl();
//        stockDao.addStock(20200003);
//        stockDao.addStock(20200004);
//        stockDao.updateIncreaseStock(20200001, 10000);
//        stockDao.updateDecreaseStock(20200002, 10);
//        for (Stock s:stockDao.queryStock()) {
//            System.out.println(s.toString());
//        }
//        System.out.println(stockDao.queryStockById(20200002));
//        System.out.println(stockDao.queryStockQuantityById(20200001));
//        stockDao.deleteStock(20200010);
//    }
}
