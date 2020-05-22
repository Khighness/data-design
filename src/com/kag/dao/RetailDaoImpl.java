package com.kag.dao;

import com.kag.common.ExceptUtil;
import com.kag.common.MysqlUtil;
import com.kag.common.TimeUtil;
import com.kag.entity.Retail;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * @Description: 零售持久层
 * @Author: 陈子康
 * @Date: 2020/5/22
 */
public class RetailDaoImpl implements RetailDao{

    private Logger logger = Logger.getLogger(RetailDaoImpl.class);

    @Override
    public void addRetail(Retail retail) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement  preparedStatement = null;
        try {
            String SQL = "INSERT INTO retail VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, retail.getRetailId());
            preparedStatement.setInt(2, retail.getMid());
            preparedStatement.setInt(3, retail.getRetailQuantity());
            preparedStatement.setDouble(4, retail.getTransactionAmount());
            preparedStatement.setDate(5, TimeUtil.transformToSqlDate(retail.getRetailDate()));
            preparedStatement.setInt(6, retail.getCid());
            preparedStatement.setInt(7, retail.getSid());
            preparedStatement.setString(8, retail.getRemark());
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("添加零售记录成功");
            } else {
                logger.error("添加零售记录失败");
            }
        } catch (SQLException e) {
            logger.warn("添加零售记录发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

//    public static void main(String[] args) {
//        RetailDao retailDao = new RetailDaoImpl();
//        retailDao.addRetail(new Retail("2020005221009", 20200001, 3, 100, Calendar.getInstance().getTime(), 20200001, 20200022, "Test"));
//    }

}
