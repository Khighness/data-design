package com.kag.service;

import com.kag.dao.MedicineDao;
import com.kag.dao.MedicineDaoImpl;
import com.kag.entity.Medicine;

/**
 * @apiNote 登录服务层
 * @author KHighness
 * @since 2020/4/24
 */
public class MedicineService {

    private MedicineDao medicineDao = new MedicineDaoImpl();

    public void addMedicineDetailInfoService(Medicine medicine) {
        medicineDao.addMedicineDetailInfo(medicine);
    }

    public void updateMedicineInfoService(int mid, Medicine medicine) {
        medicineDao.updateMedicineInfo(mid, medicine);
    }

    public Medicine queryMedicineByIdService(int mid) {
        return medicineDao.queryMedicineById(mid);
    }

    public Medicine queryMedicineByNameService(String medicineName) {
        return medicineDao.queryMedicineByName(medicineName);
    }

    public double queryMedicineRetailPriceService(int mid) {
        return medicineDao.queryMedicineRetailPrice(mid);
    }

    public double queryMedicineSalePriceService(int mid) {
        return medicineDao.queryMedicineSalePrice(mid);
    }

    public void deleteMedicineService(int mid) {
        medicineDao.deleteMedicine(mid);
    }

}
