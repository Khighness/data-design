package com.kag.service;

import com.kag.common.ExceptUtil;
import com.kag.common.MysqlUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description: 登录服务层
 * @Author: 陈子康
 * @Date: 2020/5/17
 */
public class LoginService {

    /**
     * @Description: 管理员登录检查
     * @param username
     * @param password
     * @return
     */
    public String Admin_loginCheck(String username, String password) {
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        /**
         * @Description: 验证用户名是否存在
         */
        try {
            String SQL = "Select * FROM user WHERE username = '"+ username + "';";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            if (!resultSet.next()) {
                return "该用户名不存在";
            } else {
                if (password.equals(resultSet.getString(3))) {
                     return "true";
                } else {
                    return "false";
                }
            }
        } catch (SQLException e) {
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return "false";
    }

}