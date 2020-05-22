package com.kag.dao;

import com.kag.common.ExceptUtil;
import com.kag.common.MysqlUtil;
import com.kag.common.TimeUtil;
import com.kag.entity.PurchaseMain;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * @Description: 进货（主表）持久层
 * @Author: 陈子康
 * @Date: 2020/5/22
 */
public class PurchaseMainDaoImpl implements PurchaseMainDao {

    private Logger logger = Logger.getLogger(PurchaseMainDaoImpl.class);

    @Override
    public void addPurchaseMain(PurchaseMain purchaseMain) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "INSERT INTO purchaseMain VALUES(?, ?, ?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, purchaseMain.getPurchaseId());
            preparedStatement.setInt(2, purchaseMain.getMedicineKinds());
            preparedStatement.setDouble(3, purchaseMain.getTransactionAmount());
            preparedStatement.setDate(4, TimeUtil.transformToSqlDate(purchaseMain.getPurchaseDate()));
            preparedStatement.setInt(5, purchaseMain.getFid());
            preparedStatement.setInt(6, purchaseMain.getSid());
            preparedStatement.setString(7,  purchaseMain.getRemark());
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("添加进购主记录成功");
            } else {
                logger.error("添加进购主记录失败");
            }
        } catch (SQLException e) {
            logger.warn("添加进购主记录发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

//    public static void main(String[] args) {
//        PurchaseMainDao purchaseMainDao = new PurchaseMainDaoImpl();
//        purchaseMainDao.addPurchaseMain(new PurchaseMain("20200522836", 100, 1300848.12, Calendar.getInstance().getTime(), 20200002, 20200001, "K"));
//    }

}
