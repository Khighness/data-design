package com.kag.dao;

import com.kag.common.ExceptionUtil;
import com.kag.common.MysqlUtil;
import com.kag.common.TimeUtil;
import com.kag.entity.Medicine;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @apiNote 药品持久层
 * @author KHighness
 * @since 2020/5/22
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
            ExceptionUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public void addMedicineDetailInfo(Medicine medicine) {

        Connection connection = MysqlUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String SQL = "INSERT INTO medicine (mid, medicineName, `character`, dosageForm, qualityStandard, indication, aboutUse, taboo, adverseReactions) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, medicine.getMid());
            preparedStatement.setString(2, medicine.getMedicineName());
            preparedStatement.setString(3, medicine.getCharacter());
            preparedStatement.setString(4, medicine.getDosageForm());
            preparedStatement.setString(5, medicine.getIngredient());
            preparedStatement.setString(6, medicine.getIndication());
            preparedStatement.setString(7, medicine.getAboutUse());
            preparedStatement.setString(8, medicine.getTaboo());
            preparedStatement.setString(9, medicine.getAdverseReactions());
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("添加药品详细信息成功");
            } else {
                logger.error("添加药品详细信息失败");
            }
        } catch (SQLException e) {
            logger.warn("添加药品详细信息发生异常");
            ExceptionUtil.printException(e);
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
            String SQL = "INSERT INTO medicine  VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
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
            preparedStatement.setString(11, medicine.getIngredient());
            preparedStatement.setString(12, medicine.getIndication());
            preparedStatement.setString(13, medicine.getAboutUse());
            preparedStatement.setString(14, medicine.getTaboo());
            preparedStatement.setString(15, medicine.getAdverseReactions());
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("添加药品完全信息成功");
            } else {
                logger.error("添加药品完全信息失败");
            }
        } catch (SQLException e) {
            logger.warn("添加完全所有信息发生异常");
            ExceptionUtil.printException(e);
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
                    "medicineName = ?, " +
                    "purchasePrice = ?, " +
                    "retailPrice = ?, " +
                    "salePrice = ?, " +
                    "produceDate = ?, " +
                    "shelfLife = ?, " +
                    "`character` = ?, " +
                    "dosageForm = ?, " +
                    "qualityStandard = ?, " +
                    "indication = ?, " +
                    "aboutUse = ?, " +
                    "taboo = ?, " +
                    "adverseReactions = ? " +
                    "WHERE mid = ?;";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, medicine.getMedicineName());
            preparedStatement.setDouble(2, medicine.getPurchasePrice());
            preparedStatement.setDouble(3, medicine.getRetailPrice());
            preparedStatement.setDouble(4, medicine.getSalePrice());
            preparedStatement.setDate(5, TimeUtil.transformToSqlDate(medicine.getProduceDate()));
            preparedStatement.setInt(6, medicine.getShelfLife());
            preparedStatement.setString(7, medicine.getCharacter());
            preparedStatement.setString(8, medicine.getDosageForm());
            preparedStatement.setString(9, medicine.getIngredient());
            preparedStatement.setString(10, medicine.getIndication());
            preparedStatement.setString(11, medicine.getAboutUse());
            preparedStatement.setString(12, medicine.getTaboo());
            preparedStatement.setString(13, medicine.getAdverseReactions());
            preparedStatement.setInt(14, mid);
            int RES = preparedStatement.executeUpdate();
            if (RES == 1) {
                logger.info("更新药品信息成功");
            } else {
                logger.error("更新药品信息失败");
            }
        } catch (SQLException e) {
            logger.warn("更新药品信息发生异常");
            ExceptionUtil.printException(e);
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
                        resultSet.getString(15)
                ));
                logger.info("查询所有药品信息");
            }
        } catch (SQLException e) {
            logger.warn("查询所有信息发生异常");
            ExceptionUtil.printException(e);
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
            Date produceDate = null;
            if (resultSet.getDate(7) != null) {
                produceDate = TimeUtil.transformToUtilDate(resultSet.getDate(7));
            }
            medicine = new Medicine(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getDouble(5),
                    resultSet.getDouble(6),
                    produceDate,
                    resultSet.getInt(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(11),
                    resultSet.getString(12),
                    resultSet.getString(13),
                    resultSet.getString(14),
                    resultSet.getString(15)
            );
            logger.info("查询编号为" + mid + "的药品");
        } catch (SQLException e) {
            logger.warn("查询编号为" + mid + "的药品发生异常");
            ExceptionUtil.printException(e);
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
            Date produceDate = null;
            if (resultSet.getDate(7) != null) {
                produceDate = TimeUtil.transformToUtilDate(resultSet.getDate(7));
            }
            medicine = new Medicine(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getDouble(5),
                    resultSet.getDouble(6),
                    produceDate,
                    resultSet.getInt(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(11),
                    resultSet.getString(12),
                    resultSet.getString(13),
                    resultSet.getString(14),
                    resultSet.getString(15)
            );
            logger.info("查询名称为" + medicineName + "的药品信息");
        } catch (SQLException e) {
            logger.warn("查询名称为" + medicineName + "的药品信息发生异常");
            ExceptionUtil.printException(e);
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
            ExceptionUtil.printException(e);
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
            ExceptionUtil.printException(e);
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
            ExceptionUtil.printException(e);
        } finally {
            MysqlUtil.closeConnection(connection);
            MysqlUtil.closePreparedStatement(preparedStatement);
        }
    }

}
