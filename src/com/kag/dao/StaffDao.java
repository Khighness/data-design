package com.kag.dao;

import com.kag.entity.Staff;

import java.util.List;

/**
 * @Description: 职员持久层
 * @Author: 陈子康
 * @Date: 2020/5/6
 */
public interface StaffDao {

    /**
     * @Description: 新增职员
     * @param staff
     */
    public void addStaff(Staff staff);

    /**
     * @Description: 查询所有职员
     */
    public List<Staff> queryStaff();

    /**
     * @Description: 通过编号查询职员
     * @param staff
     */
    public Staff queryStaffById(int sid);

    /**
     * @Description: 通过姓名查询职员
     * @param staffName
     * @return
     */
    public List<Staff> queryStaffByName(String staffName);

    /**
     * @Description: 更改职员
     * @param sid
     */
    public void updateStaff(int sid, Staff staff);

    /**
     * @Description: 删除职员
     * @param sid
     */
    public void deleteStaff(int sid);

    /**
     * @Description: 职员离职
     * @param sid
     */
    public void departure(int sid);

}
