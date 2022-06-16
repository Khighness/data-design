package com.kag.dao;

import com.kag.common.ExceptionUtil;
import com.kag.common.MysqlUtil;
import com.kag.entity.PurchaseDetail;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @apiNote 进货（附表）持久层
 * @author KHighness
 * @since 2020/5/22
 */
public class PurchaseDetailDaoImpl implements PurchaseDetailDao {

    private Logger logger = Logger.getLogger(PurchaseDetailDaoImpl.class);

    @Override
    public void addPurchaseDetail(PurchaseDetail purchaseDetail) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "INSERT INTO purchaseDetail VALUES(?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, purchaseDetail.getPurchaseId());
            preparedStatement.setInt(2, purchaseDetail.getMid());
            preparedStatement.setDouble(3, purchaseDetail.getPurchasePrice());
            preparedStatement.setInt(4, purchaseDetail.getPurchaseQuantity());
            preparedStatement.setString(5, purchaseDetail.getRemark());
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("添加进购子记录成功");
            } else {
                logger.error("添加进购子记录失败");
            }
        } catch (SQLException e) {
            logger.warn("添加进购子记录发生异常");
            ExceptionUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

}
