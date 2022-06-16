package com.kag.dao;

import com.kag.entity.User;
import com.kag.common.ExceptionUtil;
import com.kag.common.MysqlUtil;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * @apiNote 用户持久层
 * @author KHighness
 * @since 2020/5/2
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
            ExceptionUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public void updateUserById(int uid, User user) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "UPDATE user SET username = ?, age = ?, sex = ?, signature = ?, phoneNumber = ? WHERE uid = ?;";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getSex());
            preparedStatement.setString(4, user.getSignature());
            preparedStatement.setString(5, user.getPhoneNumber());
            preparedStatement.setInt(6, user.getUid());
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("用户信息更新成功");
            } else {
                logger.error("用户信息更新失败");
            }
        } catch (SQLException e) {
            logger.warn("用户信息更新发生异常");
            ExceptionUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public void updateUserPassword(int uid, String password) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "UPDATE user SET password = ? WHERE uid = ?;";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, password);
            preparedStatement.setInt(2, uid);
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("用户密码更新成功");
            } else {
                logger.error("用户密码更新失败");
            }
        } catch (SQLException e) {
            logger.warn("用户密码更新发生异常");
            ExceptionUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public int queryUidByName(String username) {
        int uid = 0;
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT uid FROM user WHERE username = '" + username + "';";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            uid = resultSet.getInt(1);
            logger.info("查询姓名为" + username + "的用户编号");
        } catch (SQLException e) {
            logger.warn("查询姓名为" + username + "的用户编号发生异常");
            ExceptionUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return uid;
    }

    @Override
    public User queryUserById(int uid) {
        User user = null;
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT * FROM user WHERE uid = " + uid + ";";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            user = new User(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            );
            logger.info("查询编号为" + uid + "的用户");
        } catch (SQLException e) {
            logger.warn("查询编号为" + uid + "的用户发生异常");
            ExceptionUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return user;
    }

}
