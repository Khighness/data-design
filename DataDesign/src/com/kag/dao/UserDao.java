package com.kag.dao;

import com.kag.entity.User;

/**
 * @Description: 用户持久层
 * @Author: 陈子康
 * @Date: 2020/5/2
 */
public interface UserDao {
    /**
     * @Description: 添加用户
     * @param user
     */
    public void addUser(User user);

    /**
     * @Description: 根据姓名查询ID
     * @param username
     * @return
     */
    public int queryUidByName(String username);
}
