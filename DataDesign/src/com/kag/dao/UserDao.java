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
     * @Description: 根据ID更新用户
     * @param uid
     * @param user
     */
    public void updateUserById(int uid, User user);

    /**
     * @Description: 根据ID修改密码
     * @param uid
     * @param password
     */
    public void updateUserPassword(int uid, String password);

    /**
     * @Description: 根据姓名查询ID
     * @param username
     * @return uid
     */
    public int queryUidByName(String username);

    /**
     * @Description: 根据ID查询用户
     * @param uid
     * @return user
     */
    public User queryUserById(int uid);
}
