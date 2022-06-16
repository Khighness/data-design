package com.kag.common;

import java.sql.*;

/**
 * @apiNote MySQL连接工具类
 * @author KHighness
 * @since 2020/4/30
 */
public class MysqlUtil {

    private final static String MySQL_URL = "jdbc:mysql://localhost:3306/medata?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false";
    private final static String MySQL_USERNAME = "root";
    private final static String MySQL_PASSWORD = "KAG1823";

    /**
     * @apiNote 返回数据库的连接
     * @return Connection
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接
            connection = DriverManager.getConnection(MySQL_URL, MySQL_USERNAME, MySQL_PASSWORD);
        } catch (ClassNotFoundException e) {
            //  TODO Auto-generated catch block
            ExceptionUtil.printException(e);
        } catch (SQLException e) {
            //  TODO Auto-generated catch block
            ExceptionUtil.printException(e);
        }
        return connection;
    }

    /**
     * @apiNote 关闭连接
     * @param connection
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                ExceptionUtil.printException(e);
            }
        }
    }

    /**
     * @apiNote 关闭statement
     * @param statement
     */
    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                ExceptionUtil.printException(e);
            }
        }
    }

    /**
     * @apiNote 关闭preparedStatement
     * @param preparedStatement
     */
    public static void closePreparedStatement(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                ExceptionUtil.printException(e);
            }
        }
    }

    /**
     * @apiNote 关闭resultSet
     * @param resultSet
     */
    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                ExceptionUtil.printException(e);
            }
        }
    }
}
