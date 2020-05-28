package com.kag.dao;

import com.kag.common.*;
import com.kag.entity.Client;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description: 客户持久层
 * @Author: 陈子康
 * @Date: 2020/5/22
 */
public class ClientDaoImpl implements ClientDao{

    private Logger logger = Logger.getLogger(ClientDaoImpl.class);

    @Override
    public void addClient(Client client) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "INSERT INTO client VALUES(?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, client.getCid());
            preparedStatement.setString(2, client.getClientName());
            preparedStatement.setString(3, client.getClientAddress());
            preparedStatement.setString(4, client.getPhoneNumber());
            preparedStatement.setString(5, client.getBankCard());
            preparedStatement.setDouble(6, client.getCredibility());
            preparedStatement.setString(7, client.getRemark());
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("添加客户成功");
            } else {
                logger.error("添加客户失败");
            }
        } catch (SQLException e) {
            logger.warn("添加客户发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public void updateClientById(int clientId, Client client) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "UPDATE client SET cid = ?, clientName = ?, clientAddress = ?, phoneNumber = ?, bankCard = ?, credibility = ?, remark = ? WHERE cid = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, client.getCid());
            preparedStatement.setString(2, client.getClientName());
            preparedStatement.setString(3, client.getClientAddress());
            preparedStatement.setString(4, client.getPhoneNumber());
            preparedStatement.setString(5, client.getBankCard());
            preparedStatement.setDouble(6, client.getCredibility());
            preparedStatement.setString(7, client.getRemark());
            preparedStatement.setInt(8, clientId);
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("更新客户信息成功");
            } else {
                logger.error("更新客户信息失败");
            }
        } catch (SQLException e) {
            logger.error("更新客户信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public List<Client> queryClient() {
        List<Client> clientList = new ArrayList<Client>();
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT * FROM client";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                clientList.add(new Client(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDouble(6),
                        resultSet.getString(7)
                ));
            }
            logger.info("查询所有客户信息");
        } catch (SQLException e)  {
            logger.warn("查询所有客户信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return clientList;
    }

    @Override
    public Client queryClientById(int clientId) {
        Client client = null;
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT * FROM client WHERE cid = " + clientId + ";";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            client = new Client(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6),
                    resultSet.getString(7)
            );
            logger.info("查询编号为" + clientId + "的客户信息" );
        } catch (SQLException e) {
            logger.warn("查询编号为" + clientId + "的客户信息发生异常" );
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return client;
    }

    @Override
    public Client queryClientByName(String clientName) {
        Client client = null;
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT * FROM client WHERE clientName = '" + clientName + "';";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            client = new Client(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6),
                    resultSet.getString(7)
            );
            logger.info("查询姓名为" + clientName + "的客户信息");
        } catch (SQLException e) {
            logger.warn("查询姓名为" + clientName + "的客户信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return client;
    }

    @Override
    public void deleteClient(int clientId) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "DELETE FROM client WHERE cid = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, clientId);
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("删除编号为" + clientId + "的客户信息成功");
            } else {
                logger.error("删除编号为" + clientId + "的客户信息失败");
            }
        } catch (SQLException e) {
            logger.warn("删除编号为" + clientId + "的客户信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

//    public static void main(String[] args) {
//        ClientDao clientDao = new ClientDaoImpl();
//        Random random = new Random();
//        for (int i = 20200001; i <= 20200100; i++) {
//            BigDecimal bigDecimal = new BigDecimal(10 * random.nextDouble());
//            clientDao.addClient(new Client(i, RandomPersonInfoGenerator.getChineseName(),
//                    RandomPersonInfoGenerator.getAddress(),
//                    RandomPersonInfoGenerator.getTel(),
//                    RandomCreditCardNumberGenerator.getRandomCardNumber(),
//                    bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue(),
//                    " "));
//        }
//        clientDao.addClient(new Client(20200100, RandomPersonInfoGenerator.getChineseName(),
//                    RandomPersonInfoGenerator.getAddress(),
//                    RandomPersonInfoGenerator.getTel(),
//                    RandomCreditCardNumberGenerator.getRandomCardNumber(),
//                    8.7,
//                    " "));
//        clientDao.deleteClient(20200101);
//    }
}
