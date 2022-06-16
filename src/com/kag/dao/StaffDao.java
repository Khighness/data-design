package com.kag.dao;

import com.kag.entity.Staff;

import java.util.List;

/**
 * @apiNote 职员持久层
 * @author KHighness
 * @since 2020/5/6
 */
public interface StaffDao {

    /**
     * @apiNote 新增职员
     * @param staff
     */
    public void addStaff(Staff staff);

    /**
     * @Description： 查询所有职员
     * @return
     */
    public List<Staff> queryStaff();

    /**
     * @apiNote 通过编号查询职员
     * @param staff
     */
    public Staff queryStaffById(int sid);

    /**
     * @apiNote 通过姓名查询职员
     * @param staffName
     * @return
     */
    public List<Staff> queryStaffByName(String staffName);

    /**
     * @apiNote 通过姓名查询职员编号
     * @param staffName
     * @return
     */
    public int querySidByName(String staffName);

    /**
     * @apiNote 更改职员
     * @param sid
     */
    public void updateStaff(int sid, Staff staff);

    /**
     * @apiNote 删除职员
     * @param sid
     */
    public void deleteStaff(int sid);

    /**
     * @apiNote 职员离职
     * @param sid
     */
    public void departure(int sid);

}
