package com.kag.dao;

import com.kag.entity.Medicine;

import java.util.List;

/**
 * @Description: 药品持久层
 * @Author: 陈子康
 * @Date: 2020/5/19
 */
public interface MedicineDao {

    public void addMedicineMainInfo(Medicine medicine);

    public void addMedicineDetailInfo(Medicine medicine);

    public void addMedicineAllInfo(Medicine medicine);

    public void updateMedicineInfo(int mid, Medicine medicine);

    public List<Medicine> queryMedicine();

    public Medicine queryMedicineById(int mid);

    public Medicine queryMedicineByName(String medicineName);

    public double queryMedicineRetailPrice(int mid);

    public double queryMedicineSalePrice(int mid);

    public void deleteMedicine(int mid);
}
