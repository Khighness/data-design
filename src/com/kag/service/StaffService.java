package com.kag.service;

import com.kag.dao.StaffDao;
import com.kag.dao.StaffDaoImpl;
import com.kag.entity.Staff;
import com.kag.common.TimeUtil;

import java.util.List;

/**
 * @apiNote 职员服务层
 * @author KHighness
 * @since 2020/5/7
 */
public class StaffService {

    private StaffDao staffDao = new StaffDaoImpl();

    public void addStaffService(Staff staff) {
        staffDao.addStaff(staff);
    }

    public int querySidService(String staffName) {
        return staffDao.querySidByName(staffName);
    }

    public Staff queryStaffByIdService(int sid) {
        return staffDao.queryStaffById(sid);
    }

    public List<Staff> queryStaffByNameService(String staffName) {
        return staffDao.queryStaffByName(staffName);
    }

    public void updateStaffService(int sid, Staff staff) {
        staffDao.updateStaff(sid, staff);
    }

    public void deleteStaffService(int sid) {
        staffDao.deleteStaff(sid);
    }

    public void departureService(int sid) {
        staffDao.departure(sid);
    }

}
