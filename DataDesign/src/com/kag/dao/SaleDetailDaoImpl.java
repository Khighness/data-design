package com.kag.dao;

import com.kag.common.ExceptUtil;
import com.kag.common.MysqlUtil;
import com.kag.common.TimeUtil;
import com.kag.entity.SaleDetail;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Description: 批发（附表）持久层
 * @Author: 陈子康
 * @Date: 2020/5/22
 */
public class SaleDetailDaoImpl implements SaleDetailDao {

    private Logger logger = Logger.getLogger(SaleDetailDaoImpl.class);

    @Override
    public void addSaleDetail(SaleDetail saleDetail) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "INSERT INTO saleDetail VALUES(?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, saleDetail.getSaleId());
            preparedStatement.setInt(2, saleDetail.getMid());
            preparedStatement.setInt(3, saleDetail.getSaleQuantity());
            preparedStatement.setString(4, saleDetail.getRemark());
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

}
