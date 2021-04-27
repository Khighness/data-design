package com.kag.dao;

import com.kag.entity.Staff;
import com.kag.common.ExceptUtil;
import com.kag.common.MysqlUtil;
import com.kag.common.TimeUtil;
import org.apache.log4j.Logger;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 用户持久层接
 * @Author: 陈子康
 * @Date: 2020/5/6
 */
public class StaffDaoImpl implements StaffDao {

    private Logger logger = Logger.getLogger(StaffDaoImpl.class);

    @Override
    public void addStaff(Staff staff) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "INSERT INTO staff (sid, staffName, password, birthDate, address, phoneNumber, bankCard, status) VALUES(?, ?, ?, ?, ?, ?, ?, ?);"  ;
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, staff.getSid());
            preparedStatement.setString(2, staff.getStaffName());
            preparedStatement.setString(3, staff.getPassword());
            preparedStatement.setDate(4, TimeUtil.transformToSqlDate(staff.getBirthDate()));
            preparedStatement.setString(5, staff.getAddress());
            preparedStatement.setString(6, staff.getPhoneNumber());
            preparedStatement.setString(7, staff.getBankCard());
            preparedStatement.setInt(8, staff.getStatus());
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("添加职员成功");
            } else {
                logger.error("添加职员失败");
            }
        } catch (SQLException e) {
            logger.warn("添加职员发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public List<Staff> queryStaff() {
        List<Staff> staffList = new ArrayList<Staff>();
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        Staff staff = null;
        try {
            String SQL = "SELECT * FROM staff;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                staffList.add(new Staff(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        TimeUtil.transformToUtilDate(resultSet.getDate(4)),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getInt(8)
                ));
            }
            logger.info("查询所有职员信息");
        } catch (SQLException e) {
            logger.warn("查询所有职员信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return staffList;
    }

    @Override
    public Staff queryStaffById(int sid) {
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        Staff staff = null;
        try {
            String SQL = "SELECT * FROM staff WHERE sid = " + sid + ";" ;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            staff = new Staff(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    TimeUtil.transformToUtilDate(resultSet.getDate(4)),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getInt(8)
            );
            logger.info("查询编号为" + sid + "的职员信息");
        } catch (SQLException e) {
            logger.warn("查询编号为" + sid + "的职员信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return staff;
    }

    @Override
    public List<Staff> queryStaffByName(String staffName) {
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        List<Staff> staffList = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM staff WHERE staffName = '" + staffName + "';";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                staffList.add(new Staff(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        TimeUtil.transformToUtilDate(resultSet.getDate(4)),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getInt(8)
                ));
            }
            logger.info("查询姓名为" + staffName + "的职员信息");
        } catch (SQLException e) {
            logger.warn("查询姓名为" + staffName + "的职员信息发生异常");
            ExceptUtil.printException(e);
        }finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return staffList;
    }

    @Override
    public int querySidByName(String staffName) {
        int sid = 0;
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT sid FROM staff WHERE staffName = '" + staffName + "';" ;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            sid = resultSet.getInt(1);
            logger.info("查询姓名为" + staffName + "的职员编号");
        } catch (SQLException e) {
            logger.warn("查询姓名为" + staffName + "的职员编号发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return sid;
    }

    @Override
    public void updateStaff(int sid, Staff staff) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "UPDATE staff SET staffName = ?, password = ?, birthDate = ?, address = ?, phoneNumber = ?, bankCard = ?, status = ?  WHERE sid = ?;";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, staff.getStaffName());
            preparedStatement.setString(2, staff.getPassword());
            preparedStatement.setDate(3, TimeUtil.transformToSqlDate(staff.getBirthDate()));
            preparedStatement.setString(4, staff.getAddress());
            preparedStatement.setString(5, staff.getPhoneNumber());
            preparedStatement.setString(6, staff.getBankCard());
            preparedStatement.setInt(7, staff.getStatus());
            preparedStatement.setInt(8, sid);
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("更新编号为" + sid + "的职员信息成功");
            } else {
                logger.error("更新编号为" + sid + "的职员信息失败");
            }
        } catch (SQLException e) {
            logger.warn("更新编号为" + sid + "的职员信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public void deleteStaff(int sid) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "DELETE FROM staff WHERE sid = ? ;";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, sid);
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("删除编号为" + sid + "的职员成功");
            } else {
                logger.error("删除编号为" + sid + "的职员失败");
            }
        } catch (SQLException e) {
            logger.warn("删除编号为" + sid + "的职员发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public void departure(int sid) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "UPDATE staff SET status = 0 WHERE sid = ? ;";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, sid);
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("设置职员离职成功");
            } else {
                logger.error("设置职员离职失败");
            }
        } catch (SQLException e) {
            logger.warn("设置职员离职发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

}
