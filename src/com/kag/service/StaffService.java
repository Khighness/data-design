package com.kag.service;

import com.kag.dao.StaffDao;
import com.kag.dao.StaffDaoImpl;
import com.kag.entity.Staff;
import com.kag.common.TimeUtil;

import java.util.List;

/**
 * @Description: 职员服务层
 * @Author: 陈子康
 * @Date: 2020/5/7
 */
public class StaffService {

    private StaffDao staffDao = new StaffDaoImpl();

    public void addStaffService(Staff staff) {
        staffDao.addStaff(staff);
    }

    public StringBuffer queryStaffByIdService(int sid) {
        Staff staff = staffDao.queryStaffById(sid);
        if (staff == null) {
            return new StringBuffer("");
        } else {
            StringBuffer staffBuffer = new StringBuffer();
            staffBuffer
                    .append(" ▶ 编号：" + staff.getSid() + "\n\r")
                    .append(" ▶ 姓名：" + staff.getStaffName() + "\n\r")
                    .append(" ▶ 生日：" + TimeUtil.getFormatDate(staff.getBirthDate()) + "\n\r")
                    .append(" ▶ 住址：" + staff.getAddress() + "\n\r")
                    .append(" ▶ 联系电话：" + staff.getPhoneNumber() + "\n\r")
                    .append(" ▶ 银行卡号：" + staff.getBankCard() + "\n\r")
                    .append(" ▶ 在职状态: " + ((staff.getStatus() == 1) ? " 在职" : " 离职") + "\n\r");
            return staffBuffer;
        }
    }

    public StringBuffer queryStaffByNameService(String staffName) {
        List<Staff> staffList = staffDao.queryStaffByName(staffName);
        if (staffList == null) {
            return new StringBuffer("");
        } else {
            StringBuffer staffBuffer = new StringBuffer();
            for (int i = 0; i < staffList.size(); i++) {
                staffBuffer
                        .append("第" + (i+1) +"位职员信息如下" + "\n\r")
                        .append(" ▶ 编号：" + staffList.get(i).getSid() + "\n\r")
                        .append(" ▶ 姓名：" + staffList.get(i).getStaffName() + "\n\r")
                        .append(" ▶ 生日：" + TimeUtil.getFormatDate(staffList.get(i).getBirthDate()) + "\n\r")
                        .append(" ▶ 住址：" + staffList.get(i).getAddress() + "\n\r")
                        .append(" ▶ 联系电话：" + staffList.get(i).getPhoneNumber() + "\n\r")
                        .append(" ▶ 银行卡号：" + staffList.get(i).getBankCard() + "\n\r")
                        .append(" ▶ 在职状态: " + ((staffList.get(i).getStatus() == 1) ? " 在职" : " 离职") + "\n\r");
            }
            return staffBuffer;
        }
    }

    public void updateStaffService(int sid, Staff staff) {

    }

    public void deleteStaffService(int sid) {

    }

    public void departureService(int sid) {

    }

    public boolean isSidLegal(String sid) {
        return false;
    }

}
