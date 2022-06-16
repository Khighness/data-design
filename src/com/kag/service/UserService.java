package com.kag.service;

import com.kag.dao.UserDao;
import com.kag.dao.UserDaoImpl;
import com.kag.entity.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @apiNote 用户服务层
 * @author KHighness
 * @since 2020/5/2
 */
public class UserService {

    private UserDao userDao = new UserDaoImpl();

    public void addUserService(User user) {
        userDao.addUser(user);
    }

    public void updateUserService(int uid, User user) {
        userDao.updateUserById(uid, user);
    }

    public void updateUserPasswordService(int uid, String password) {
        userDao.updateUserPassword(uid, password);
    }

    public int queryUidService(String username) {
        return userDao.queryUidByName(username);
    }

    public User queryUserService(int uid) {
        return userDao.queryUserById(uid);
    }

}
