package com.kag.entity;

import java.util.Objects;

/**
 * @Description: 生产厂家实体层
 * @Author: 陈子康
 * @Date: 2020/5/19
 */
public class Factory {

    private int fid;
    private String factoryName;
    private String factoryAddress;
    private String postCode;
    private String telephoneNumber;
    private String remark;

    public Factory(int fid, String factoryName, String factoryAddress, String postCode, String telephoneNumber, String remark) {
        this.fid = fid;
        this.factoryName = factoryName;
        this.factoryAddress = factoryAddress;
        this.postCode = postCode;
        this.telephoneNumber = telephoneNumber;
        this.remark = remark;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryAddress() {
        return factoryAddress;
    }

    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factory factory = (Factory) o;
        return fid == factory.fid &&
                Objects.equals(factoryName, factory.factoryName) &&
                Objects.equals(factoryAddress, factory.factoryAddress) &&
                Objects.equals(postCode, factory.postCode) &&
                Objects.equals(telephoneNumber, factory.telephoneNumber) &&
                Objects.equals(remark, factory.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fid, factoryName, factoryAddress, postCode, telephoneNumber, remark);
    }

    @Override
    public String toString() {
        return "Factory{" +
                "fid=" + fid +
                ", factoryName='" + factoryName + '\'' +
                ", factoryAddress='" + factoryAddress + '\'' +
                ", postCode='" + postCode + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
