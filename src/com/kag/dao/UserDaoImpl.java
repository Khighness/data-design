package com.kag.dao;

import com.kag.entity.User;
import com.kag.common.ExceptUtil;
import com.kag.common.MysqlUtil;
import com.kag.common.TimeUtil;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * @Description: 用户持久层
 * @Author: 陈子康
 * @Date: 2020/5/2
 */
public class UserDaoImpl implements UserDao{

    private Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Override
    public  void addUser(User user) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "INSERT INTO user (uid, username, password, age, sex, signature, phoneNumber) VALUES(?,  ?,  ?,  ?,  ?,  ?,  ?);";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, user.getUid());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setString(5, user.getSex());
            preparedStatement.setString(6, user.getSignature());
            preparedStatement.setString(7, user.getPhoneNumber());
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("用户注册成功");
            } else {
                logger.error("用户注册失败");
            }
        } catch (SQLException e) {
            logger.warn("用户注册发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

}
