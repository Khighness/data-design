package com.kag.entity;

import java.util.Objects;

/**
 * @Description: 用户实体层
 * @Author: 陈子康
 * @Date: 2020/5/2
 */
public class User {

    private int uid;
    private String username;
    private String password;
    private Integer age;
    private String sex;
    private String signature;
    private String phoneNumber;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User() {

    }

    public User(int uid, String username, String password, Integer age, String sex, String signature, String phoneNumber) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.signature = signature;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return uid == user.uid &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(age, user.age) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(signature, user.signature) &&
                Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, username, password, age, sex, signature, phoneNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", signature='" + signature + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}