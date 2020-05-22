package com.kag.dao;

import com.kag.entity.User;

/**
 * @Description: 用户持久层
 * @Author: 陈子康
 * @Date: 2020/5/2
 */
public interface UserDao {
    /**
     * @Description: 用户添加
     * @param user
     */
    public void addUser(User user);
}
