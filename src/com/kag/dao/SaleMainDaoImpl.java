package com.kag.dao;

import com.kag.common.ExceptUtil;
import com.kag.common.MysqlUtil;
import com.kag.common.TimeUtil;
import com.kag.entity.SaleDetail;
import com.kag.entity.SaleMain;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Period;
import java.util.Calendar;

/**
 * @Description: 批发（主表）持久层
 * @Author: 陈子康
 * @Date: 2020/5/22
 */
public class SaleMainDaoImpl implements SaleMainDao{

    private Logger logger = Logger.getLogger(SaleMainDaoImpl.class);

    @Override
    public void addSaleMain(SaleMain saleMain) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "INSERT INTO saleMain VALUES(?, ?, ?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, saleMain.getSaleId());
            preparedStatement.setInt(2, saleMain.getMedicineKinds());
            preparedStatement.setDouble(3, saleMain.getTransactionAmount());
            preparedStatement.setDate(4, TimeUtil.transformToSqlDate(saleMain.getSaleDate()));
            preparedStatement.setInt(5, saleMain.getCid());
            preparedStatement.setInt(6, saleMain.getSid());
            preparedStatement.setString(7, saleMain.getRemark());
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("添加批发主记录成功");
            } else {
                logger.error("添加批发主记录失败");
            }
        } catch (SQLException e) {
            logger.warn("添加批发主记录发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

//    public static void main(String[] args) {
//        SaleMainDao saleMainDao = new SaleMainDaoImpl();
//        saleMainDao.addSaleMain(new SaleMain("20200522931", 10, 2313321.23, Calendar.getInstance().getTime(), 20200002, 20200002, "Test"));
//    }

}
