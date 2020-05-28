package com.kag.service;

import com.kag.dao.UserDao;
import com.kag.dao.UserDaoImpl;
import com.kag.entity.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 用户服务层
 * @Author: 陈子康
 * @Date: 2020/5/2
 */
public class UserService {

    private UserDao userDao = new UserDaoImpl();

    public void addUserService(User user) {
        userDao.addUser(user);
    }

    public int queryUidService(String username) {
        return userDao.queryUidByName(username);
    }

}
