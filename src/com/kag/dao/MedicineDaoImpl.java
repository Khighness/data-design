package com.kag.dao;

import com.kag.common.ExceptUtil;
import com.kag.common.MysqlUtil;
import com.kag.common.TimeUtil;
import com.kag.entity.Medicine;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.ResultsetRow;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 药品持久层
 * @Author: 陈子康
 * @Date: 2020/5/22
 */
public class MedicineDaoImpl implements MedicineDao {

    private Logger logger = Logger.getLogger(MedicineDaoImpl.class);

    @Override
    public void addMedicineMainInfo(Medicine medicine) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "INSERT INTO medicine (mid, medicineName, manufacturer, purchasePrice) VALUES(?, ?, ?, ? )";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, medicine.getMid());
            preparedStatement.setString(2, medicine.getMedicineName());
            preparedStatement.setString(3, medicine.getManufacturer());
            preparedStatement.setDouble(4, medicine.getPurchasePrice());
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("添加药品主要信息成功");
            } else {
                logger.error("添加药品主要信息失败");
            }
        } catch (SQLException e) {
            logger.warn("添加药品主要信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public void addMedicineAllInfo(Medicine medicine) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "INSERT INTO medicine  VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, medicine.getMid());
            preparedStatement.setString(2, medicine.getMedicineName());
            preparedStatement.setString(3, medicine.getManufacturer());
            preparedStatement.setDouble(4, medicine.getPurchasePrice());
            preparedStatement.setDouble(5, medicine.getRetailPrice());
            preparedStatement.setDouble(6, medicine.getSalePrice());
            preparedStatement.setDate(7, TimeUtil.transformToSqlDate(medicine.getProduceDate()));
            preparedStatement.setInt(8, medicine.getShelfLife());
            preparedStatement.setString(9, medicine.getCharacter());
            preparedStatement.setString(10, medicine.getDosageForm());
            preparedStatement.setString(11, medicine.getProducePlace());
            preparedStatement.setString(12, medicine.getQualityStandard());
            preparedStatement.setString(13, medicine.getIndication());
            preparedStatement.setString(14, medicine.getAboutUse());
            preparedStatement.setString(15, medicine.getTaboo());
            preparedStatement.setString(16, medicine.getAdverseReactions());
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("添加药品完全信息成功");
            } else {
                logger.error("添加药品完全信息失败");
            }
        } catch (SQLException e) {
            logger.warn("添加完全所有信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public void updateMedicineInfo(int mid, Medicine medicine) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "UPDATE medicine SET " +
                    "mid = ?, " +
                    "medicineName = ?, " +
                    "manufacturer = ?, " +
                    "purchasePrice = ?, " +
                    "retailPrice = ?, " +
                    "salePrice = ?, " +
                    "produceDate = ?, " +
                    "shelfLife = ?, " +
                    "`character` = ?, " +
                    "dosageForm = ?, " +
                    "producePlace = ?, " +
                    "qualityStandard = ?, " +
                    "indication = ?, " +
                    "aboutUse = ?, " +
                    "taboo = ?, " +
                    "adverseReactions = ? " +
                    "WHERE mid = ?;";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, medicine.getMid());
            preparedStatement.setString(2, medicine.getMedicineName());
            preparedStatement.setString(3, medicine.getManufacturer());
            preparedStatement.setDouble(4, medicine.getPurchasePrice());
            preparedStatement.setDouble(5, medicine.getRetailPrice());
            preparedStatement.setDouble(6, medicine.getSalePrice());
            preparedStatement.setDate(7, TimeUtil.transformToSqlDate(medicine.getProduceDate()));
            preparedStatement.setInt(8, medicine.getShelfLife());
            preparedStatement.setString(9, medicine.getCharacter());
            preparedStatement.setString(10, medicine.getDosageForm());
            preparedStatement.setString(11, medicine.getProducePlace());
            preparedStatement.setString(12, medicine.getQualityStandard());
            preparedStatement.setString(13, medicine.getIndication());
            preparedStatement.setString(14, medicine.getAboutUse());
            preparedStatement.setString(15, medicine.getTaboo());
            preparedStatement.setString(16, medicine.getAdverseReactions());
            preparedStatement.setInt(17, mid);
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("更新药品信息成功");
            } else {
                logger.error("更新药品信息失败");
            }
        } catch (SQLException e) {
            logger.warn("更新药品信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public List<Medicine> queryMedicine() {
        List<Medicine> medicineList = new ArrayList<Medicine>();
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT * FROM medicine;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                medicineList.add(new Medicine(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getDouble(5),
                        resultSet.getDouble(6),
                        TimeUtil.transformToUtilDate(resultSet.getDate(7)),
                        resultSet.getInt(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getString(12),
                        resultSet.getString(13),
                        resultSet.getString(14),
                        resultSet.getString(15),
                        resultSet.getString(16)
                ));
                logger.info("查询所有药品信息");
            }
        } catch (SQLException e) {
            logger.warn("查询所有信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return medicineList;
    }

    @Override
    public Medicine queryMedicineById(int mid) {
        Medicine medicine = null;
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT * FROM medicine WHERE mid = " + mid + ";";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            medicine = new Medicine(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getDouble(5),
                    resultSet.getDouble(6),
                    TimeUtil.transformToUtilDate(resultSet.getDate(7)),
                    resultSet.getInt(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(11),
                    resultSet.getString(12),
                    resultSet.getString(13),
                    resultSet.getString(14),
                    resultSet.getString(15),
                    resultSet.getString(16)
            );
            logger.info("查询编号为" + mid + "的药品");
        } catch (SQLException e) {
            logger.warn("查询编号为" + mid + "的药品发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return medicine;
    }

    @Override
    public Medicine queryMedicineByName(String medicineName) {
        Medicine medicine = null;
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT * FROM medicine WHERE medicineName = '" + medicineName + "';";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            medicine = new Medicine(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getDouble(5),
                    resultSet.getDouble(6),
                    TimeUtil.transformToUtilDate(resultSet.getDate(7)),
                    resultSet.getInt(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(11),
                    resultSet.getString(12),
                    resultSet.getString(13),
                    resultSet.getString(14),
                    resultSet.getString(15),
                    resultSet.getString(16)
            );
            logger.info("查询名称为" + medicineName + "的药品信息");
        } catch (SQLException e) {
            logger.warn("查询名称为" + medicineName + "的药品信息发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
            MysqlUtil.closeResultSet(resultSet);
        }
        return medicine;
    }

    @Override
    public double queryMedicineRetailPrice(int mid) {
        double retailPrice = 0;
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT retailPrice FROM medicine WHERE mid = " + mid + ";";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            retailPrice = resultSet.getDouble(1);
            logger.info("查询编号为" + mid + "的药品零售价格");
        } catch (SQLException e) {
            logger.warn("查询编号为" + mid + "的药品零售价格发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
        }
        return retailPrice;
    }

    @Override
    public double queryMedicineSalePrice(int mid) {
        double retailPrice = 0;
        Connection connection = MysqlUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT salePrice FROM medicine WHERE mid = " + mid + ";";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            retailPrice = resultSet.getDouble(1);
            logger.info("查询编号为" + mid + "的药品批发价格");
        } catch (SQLException e) {
            logger.warn("查询编号为" + mid + "的药品批发价格发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closeStatement(statement);
        }
        return retailPrice;
    }

    @Override
    public void deleteMedicine(int mid) {
        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "DELETE FROM medicine WHERE mid = ?;";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, mid);
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("删除编号为" + mid + "的药品成功");
            } else {
                logger.error("删除编号为" + mid + "的药品失败");
            }
        } catch (SQLException e) {
            logger.warn("删除编号为" + mid + "的药品发生异常");
            ExceptUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

//    public static void main(String[] args) {
//        MedicineDao medicineDao = new MedicineDaoImpl();
//        medicineDao.addMedicineMainInfo(new Medicine(20200001, "阿莫西林", "健康药业", 99.5));
//        medicineDao.addMedicineAllInfo(new Medicine(20200002, "A", "健康药业", 90.1, 110, 120,
//                new Date(),  360, "K", "K", "K", "K", "K", "K", "K", "K"));
//        medicineDao.addMedicineAllInfo(new Medicine(20200003, "G", "健康药业", 90.1, 110, 120,
//                new Date(),  360, "K", "K", "K", "K", "K", "K", "K", "K"));
//        for (Medicine m : medicineDao.queryMedicine()) {
//            System.out.println(m.toString());
//        }
//        System.out.println(medicineDao.queryMedicineById(20200001).toString());
//        System.out.println(medicineDao.queryMedicineByName("A").toString());
//        medicineDao.deleteMedicine(20200003);
//        System.out.println(medicineDao.queryMedicineRetailPrice(20200001));
//        System.out.println(medicineDao.queryMedicineSalePrice(20200002));
//    }

}
