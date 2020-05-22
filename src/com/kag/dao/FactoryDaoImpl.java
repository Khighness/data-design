package com.kag.dao;

import com.kag.common.ExceptUtil;
import com.kag.common.MysqlUtil;
import com.kag.common.TimeUtil;
import com.kag.entity.Factory;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 生产厂家持久层
 * @Author: 陈子康
 * @Date: 2020/5/22
 */
public class FactoryDaoImpl implements FactoryDao {

    private Logger logger = Logger.getLogger(FactoryDaoImpl.class);

    @Override
    public void addFactory(Factory factory) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "INSERT INTO factory VALUES(?, ?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, factory.getFid());
            preparedStatement.setString(2, factory.getFactoryName());
            preparedStatement.setString(3, factory.getFactoryAddress());
            preparedStatement.setString(4, factory.getPostCode());
            preparedStatement.setString(5, factory.getTelephoneNumber());
            preparedStatement.setString(6, factory.getRemark());
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("添加厂家成功");
            } else {
                logger.error("添加厂家失败");
            }
        } catch (SQLException e) {
            logger.warn("添加厂家发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public void updateFactory(int factoryId, Factory factory) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "UPDATE factory SET fid = ?, factoryName = ?, factoryAddress = ?, postCode = ?, telephoneNumber = ?, remark = ?;";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, factory.getFid());
            preparedStatement.setString(2, factory.getFactoryName());
            preparedStatement.setString(3, factory.getFactoryAddress());
            preparedStatement.setString(4, factory.getPostCode());
            preparedStatement.setString(5, factory.getTelephoneNumber());
            preparedStatement.setString(6, factory.getRemark());
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("更新编号为" + factoryId + "的厂家信息成功");
            } else {
                logger.error("更新编号为" + factoryId + "的厂家信息失败");
            }
        } catch (SQLException e) {
            logger.warn("更新编号为" + factoryId + "的厂家信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public List<Factory> queryFactory() {
        List<Factory> factoryList = new ArrayList<Factory>();
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT * FROM factory";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                factoryList.add(new Factory(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                ));
            }
            logger.info("查询所有厂家信息");
        } catch (SQLException e) {
            logger.warn("查询所有厂家信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
        }
        return factoryList;
    }

    @Override
    public Factory queryFactoryById(int factoryId) {
        Factory factory = null;
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT * FROM factory WHERE fid = " + factoryId + ";";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            factory = new Factory(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
            logger.info("查询编号为" + factoryId + "的厂家信息");
        } catch (SQLException e) {
            logger.warn("查询编号为" + factoryId + "的厂家信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return factory;
    }

    @Override
    public Factory queryFactoryByName(String factoryName) {
        Factory factory = null;
        Connection connection = MysqlUtil.getConnection();
        Statement statement= null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT * FROM factory WHERE factoryName = '" + factoryName + "';";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            factory = new Factory(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
            logger.info("查询名称为" + factoryName + "的厂家信息");
        } catch (SQLException e) {
            logger.warn("查询名称为" + factoryName + "的厂家信息");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return factory;
    }

    @Override
    public void deleteFactory(int factoryId) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "DELETE FROM factory WHERE fid = ?;";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, factoryId);
            int RES = preparedStatement.executeUpdate();
            if (RES == 0) {
                logger.info("删除编号为" + factoryId + "的厂家信息成功");
            } else {
                logger.error("删除编号为" + factoryId + "的厂家信息失败");
            }
        } catch (SQLException e) {
            logger.warn("删除编号为" + factoryId + "的厂家信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

//    public static void main(String[] args) {
//        FactoryDao factoryDao =new FactoryDaoImpl();
//        factoryDao.addFactory(new Factory(20200001, "健康药业", "天河路10号10-1", "518000", "12345678901", " "));
//        factoryDao.addFactory(new Factory(20200002, "富贵药业", "天河路10号10-2", "518000", "12345678901", " "));
//        factoryDao.addFactory(new Factory(20200003, "升腾药业", "天河路10号10-3", "518000", "12345678901", " "));
//        System.out.println(factoryDao.queryFactoryById(20200002).toString());
//        System.out.println(factoryDao.queryFactoryByName("升腾药业").toString());
//    }

}
