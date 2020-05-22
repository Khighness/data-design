package com.kag.dao;

import com.kag.common.ExceptUtil;
import com.kag.common.MysqlUtil;
import com.kag.common.TimeUtil;
import com.kag.entity.Ledger;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 账本持久层
 * @Author: 陈子康
 * @Date: 2020/5/6
 */
public class LedgerDaoImpl implements LedgerDao{

    private Logger logger = Logger.getLogger(LedgerDaoImpl.class);

    @Override
    public void addLedger(Ledger ledger) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "INSERT INTO ledger VALUES(?, ?, ?,);";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, ledger.getRecordId());
            preparedStatement.setInt(2, ledger.getType());
            preparedStatement.setDouble(3, ledger.getTransactionAmount());
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("添加账本记录成功");
            } else {
                logger.error("添加账本记录失败");
            }
        } catch (SQLException e) {
            logger.warn("添加账本记录发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public List<Ledger> queryLedger() {
        List<Ledger> ledgerList = new ArrayList<Ledger>();
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT * FROM ledger;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                ledgerList.add(new Ledger(
                   resultSet.getString(1),
                   resultSet.getInt(2),
                   resultSet.getDouble(3)
                ));
            }
            logger.info("查询账本所有记录");
        } catch (SQLException e) {
            logger.info("查询账本所有记录发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return ledgerList;
    }

    @Override
    public Ledger queryLedgerById(String LedgerId) {
        Ledger ledger = null;
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT * FROM ledger WHERE Ledger = " + LedgerId + ";";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            ledger = new Ledger(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getDouble(3)
            );
            logger.info("查询编号为" + LedgerId + "的账本记录");
        } catch (SQLException e) {
            logger.warn("查询编号为" + LedgerId + "的账本记录发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return ledger;
    }

}
