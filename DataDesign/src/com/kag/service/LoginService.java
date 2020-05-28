package com.kag.service;

import com.kag.common.ExceptUtil;
import com.kag.common.MysqlUtil;
import com.kag.entity.Staff;
import org.apache.log4j.Logger;

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

    private Logger logger = Logger.getLogger(LoginService.class);

    /**
     * @Description: 管理员登录检查
     * @param username
     * @param password
     * @return
     */
    public String AdminLoginCheck(String username, String password) {
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "Select * FROM user WHERE username = '"+ username + "';";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            if (!resultSet.next()) {
                logger.warn("管理员" + username + "登陆， 用户名不存在");
                return "用户名不存在";
            } else {
                if (password.equals(resultSet.getString(3))) {
                    logger.info("管理员" + username + "登陆成功");
                     return "true";
                } else {
                    logger.info("管理员" + username + "登陆，密码错误");
                    return "false";
                }
            }
        } catch (SQLException e) {
            logger.warn("管理员" + username + "登陆，发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return "false";
    }

    /**
     * @Description: 职员登陆检查
     * @param staffName
     * @param password
     * @return
     */
    public String StaffLoginCheck(String staffName, String password) {
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT * FROM staff WHERE staffName = '" + staffName +"';";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            if (!resultSet.next()) {
                logger.warn("职员" + staffName + "登录，用户名不存在");
                return "用户名不存在";
            } else {
                if (password.equals(resultSet.getString(3))) {
                    logger.info("职员" + staffName + "登陆成功");
                    return "true";
                } else {
                    logger.error("职员" + staffName + "登陆，密码错误");
                    return "false";
                }
            }
        } catch (SQLException e) {
            logger.warn("职员" + staffName + "登录，发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return "false";
    }

}